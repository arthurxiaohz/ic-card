package org.hi.base.schedule.quartz;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.base.schedule.service.JobDetailDefManager;
import org.hi.base.schedule.service.TriggerDefManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.quartz.Calendar;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.simpl.SimpleThreadPool;
import org.quartz.spi.JobFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.JobDetailAwareTrigger;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.LocalDataSourceJobStore;
import org.springframework.scheduling.quartz.LocalTaskExecutorThreadPool;
import org.springframework.scheduling.quartz.ResourceJobSchedulingDataProcessor;
import org.springframework.scheduling.quartz.SchedulerContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.util.CollectionUtils;

/**
 * Quartz的任务调度工厂,实现<code>SchedulerFactoryBean</code>接口
 * @author 张昊
 * @since 2007-0917
 * @see org.quartz.Scheduler
 * @see org.quartz.SchedulerFactory
 * @see org.quartz.impl.StdSchedulerFactory
 * @see org.hi.base.schedule.SchedulerFactory
 */
public class QuartzSchedulerFactoryBean
    implements FactoryBean, ApplicationContextAware, InitializingBean, Lifecycle, DisposableBean, org.hi.base.schedule.SchedulerFactory {

	public static final String PROP_THREAD_COUNT = "org.quartz.threadPool.threadCount";

	public static final int DEFAULT_THREAD_COUNT = 10;


	private static final ThreadLocal configTimeTaskExecutorHolder = new ThreadLocal();

	/**
	 * Return the TaskExecutor for the currently configured Quartz Scheduler,
	 * to be used by LocalTaskExecutorThreadPool.
	 * <p>This instance will be set before initialization of the corresponding
	 * Scheduler, and reset immediately afterwards. It is thus only available
	 * during configuration.
	 * @see #setDataSource
	 * @see LocalDataSourceJobStore
	 */
	public static TaskExecutor getConfigTimeTaskExecutor() {
		return (TaskExecutor) configTimeTaskExecutorHolder.get();
	}


	protected final Log logger = LogFactory.getLog(getClass());


	private Class schedulerFactoryClass = StdSchedulerFactory.class;

	private String schedulerName;

	private Resource configLocation;

	private Properties quartzProperties;

	private TaskExecutor taskExecutor;

	private Map schedulerContextMap;

	private ApplicationContext applicationContext;

	private String applicationContextSchedulerContextKey;

	private JobFactory jobFactory = new AdaptableJobFactory();

	private boolean overwriteExistingJobs = false;

	private String[] jobSchedulingDataLocations;

	private List<JobDetail> jobDetails = new LinkedList<JobDetail>();

	private Map calendars;

	private List triggers = new ArrayList();

	private boolean autoStartup = true;

	private int startupDelay = 0;

	private boolean waitForJobsToCompleteOnShutdown = false;
	
	private JobDetailDefManager jobDetailDefManager;
	
	private TriggerDefManager triggerDefManager;
	
//	private Map<String, JobDetail> jobDetailMap = new LinkedHashMap<String, JobDetail>();

	private Scheduler scheduler;


	/**
	 * Set the Quartz SchedulerFactory implementation to use.
	 * <p>Default is StdSchedulerFactory, reading in the standard
	 * quartz.properties from quartz.jar. To use custom Quartz
	 * properties, specify "configLocation" or "quartzProperties".
	 * @see org.quartz.impl.StdSchedulerFactory
	 * @see #setConfigLocation
	 * @see #setQuartzProperties
	 */
	public void setSchedulerFactoryClass(Class schedulerFactoryClass) {
		if (schedulerFactoryClass == null || !SchedulerFactory.class.isAssignableFrom(schedulerFactoryClass)) {
			throw new IllegalArgumentException("schedulerFactoryClass must implement [org.quartz.SchedulerFactory]");
		}
		this.schedulerFactoryClass = schedulerFactoryClass;
	}

	/**
	 * Set the name of the Scheduler to fetch from the SchedulerFactory.
	 * If not specified, the default Scheduler will be used.
	 * @see org.quartz.SchedulerFactory#getScheduler(String)
	 * @see org.quartz.SchedulerFactory#getScheduler
	 */
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	/**
	 * Set the location of the Quartz properties config file, for example
	 * as classpath resource "classpath:quartz.properties".
	 * <p>Note: Can be omitted when all necessary properties are specified
	 * locally via this bean, or when relying on Quartz' default configuration.
	 * @see #setQuartzProperties
	 */
	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}

	/**
	 * Set Quartz properties, like "org.quartz.threadPool.class".
	 * <p>Can be used to override values in a Quartz properties config file,
	 * or to specify all necessary properties locally.
	 * @see #setConfigLocation
	 */
	public void setQuartzProperties(Properties quartzProperties) {
		this.quartzProperties = quartzProperties;
	}


	/**
	 * Set the Spring TaskExecutor to use as Quartz backend.
	 * Exposed as thread pool through the Quartz SPI.
	 * <p>Can be used to assign a JDK 1.5 ThreadPoolExecutor or a CommonJ
	 * WorkManager as Quartz backend, to avoid Quartz's manual thread creation.
	 * <p>By default, a Quartz SimpleThreadPool will be used, configured through
	 * the corresponding Quartz properties.
	 * @see #setQuartzProperties
	 * @see LocalTaskExecutorThreadPool
	 * @see org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
	 * @see org.springframework.scheduling.commonj.WorkManagerTaskExecutor
	 */
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}


	/**
	 * Register objects in the Scheduler context via a given Map.
	 * These objects will be available to any Job that runs in this Scheduler.
	 * <p>Note: When using persistent Jobs whose JobDetail will be kept in the
	 * database, do not put Spring-managed beans or an ApplicationContext
	 * reference into the JobDataMap but rather into the SchedulerContext.
	 * @param schedulerContextAsMap Map with String keys and any objects as
	 * values (for example Spring-managed beans)
	 * @see JobDetailBean#setJobDataAsMap
	 */
	public void setSchedulerContextAsMap(Map schedulerContextAsMap) {
		this.schedulerContextMap = schedulerContextAsMap;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * Set the key of an ApplicationContext reference to expose in the
	 * SchedulerContext, for example "applicationContext". Default is none.
	 * Only applicable when running in a Spring ApplicationContext.
	 * <p>Note: When using persistent Jobs whose JobDetail will be kept in the
	 * database, do not put an ApplicationContext reference into the JobDataMap
	 * but rather into the SchedulerContext.
	 * <p>In case of a QuartzJobBean, the reference will be applied to the Job
	 * instance as bean property. An "applicationContext" attribute will
	 * correspond to a "setApplicationContext" method in that scenario.
	 * <p>Note that BeanFactory callback interfaces like ApplicationContextAware
	 * are not automatically applied to Quartz Job instances, because Quartz
	 * itself is reponsible for the lifecycle of its Jobs.
	 * @see JobDetailBean#setApplicationContextJobDataKey
	 * @see org.springframework.context.ApplicationContext
	 */
	public void setApplicationContextSchedulerContextKey(String applicationContextSchedulerContextKey) {
		this.applicationContextSchedulerContextKey = applicationContextSchedulerContextKey;
	}

	/**
	 * Set the Quartz JobFactory to use for this Scheduler.
	 * <p>Default is Spring's AdaptableJobFactory, which supports Runnables
	 * as well as standard Quartz Jobs.
	 * <p>Specify an instance of Spring's SpringBeanJobFactory here (typically
	 * as an inner bean definition) to automatically populate a job's bean
	 * properties from the specified job data map and scheduler context.
	 * @see AdaptableJobFactory
	 * @see SpringBeanJobFactory
	 */
	public void setJobFactory(JobFactory jobFactory) {
		this.jobFactory = jobFactory;
	}


	/**
	 * Set whether any jobs defined on this SchedulerFactoryBean should overwrite
	 * existing job definitions. Default is "false", to not overwrite already
	 * registered jobs that have been read in from a persistent job store.
	 */
	public void setOverwriteExistingJobs(boolean overwriteExistingJobs) {
		this.overwriteExistingJobs = overwriteExistingJobs;
	}

	/**
	 * Set the location of a Quartz job definition XML file that follows the
	 * "job_scheduling_data_1_0" DTD. Can be specified to automatically
	 * register jobs that are defined in such a file, possibly in addition
	 * to jobs defined directly on this SchedulerFactoryBean.
	 * @see ResourceJobSchedulingDataProcessor
	 * @see org.quartz.xml.JobSchedulingDataProcessor
	 */
	public void setJobSchedulingDataLocation(String jobSchedulingDataLocation) {
		this.jobSchedulingDataLocations = new String[] {jobSchedulingDataLocation};
	}

	/**
	 * Set the locations of Quartz job definition XML files that follow the
	 * "job_scheduling_data_1_0" DTD. Can be specified to automatically
	 * register jobs that are defined in such files, possibly in addition
	 * to jobs defined directly on this SchedulerFactoryBean.
	 * @see ResourceJobSchedulingDataProcessor
	 * @see org.quartz.xml.JobSchedulingDataProcessor
	 */
	public void setJobSchedulingDataLocations(String[] jobSchedulingDataLocations) {
		this.jobSchedulingDataLocations = jobSchedulingDataLocations;
	}

	/**
	 * Register a list of Quartz Calendar objects with the Scheduler
	 * that this FactoryBean creates, to be referenced by Triggers.
	 * @param calendars Map with calendar names as keys as Calendar
	 * objects as values
	 * @see org.quartz.Calendar
	 * @see org.quartz.Trigger#setCalendarName
	 */
	public void setCalendars(Map calendars) {
		this.calendars = calendars;
	}


	/**
	 * Set whether to automatically start the scheduler after initialization.
	 * Default is "true"; set this to "false" to allow for manual startup.
	 */
	public void setAutoStartup(boolean autoStartup) {
		this.autoStartup = autoStartup;
	}

	/**
	 * Set the number of seconds to wait after initialization before
	 * starting the scheduler asynchronously. Default is 0, meaning
	 * immediate synchronous startup on initialization of this bean.
	 * <p>Setting this to 10 or 20 seconds makes sense if no jobs
	 * should be run before the entire application has started up.
	 */
	public void setStartupDelay(int startupDelay) {
		this.startupDelay = startupDelay;
	}

	/**
	 * Set whether to wait for running jobs to complete on shutdown.
	 * Default is "false".
	 * @see org.quartz.Scheduler#shutdown(boolean)
	 */
	public void setWaitForJobsToCompleteOnShutdown(boolean waitForJobsToCompleteOnShutdown) {
		this.waitForJobsToCompleteOnShutdown = waitForJobsToCompleteOnShutdown;
	}


	public void afterPropertiesSet() throws Exception {

		// Create SchedulerFactory instance.
		SchedulerFactory schedulerFactory = (SchedulerFactory)
				BeanUtils.instantiateClass(this.schedulerFactoryClass);

		initSchedulerFactory(schedulerFactory);

		if (this.taskExecutor != null) {
			// Make given TaskExecutor available for SchedulerFactory configuration.
			configTimeTaskExecutorHolder.set(this.taskExecutor);
		}

		// Get Scheduler instance from SchedulerFactory.
		try {
			this.scheduler = createScheduler(schedulerFactory, this.schedulerName);
			if (this.jobFactory != null) {
				if (this.jobFactory instanceof SchedulerContextAware) {
					((SchedulerContextAware) this.jobFactory).setSchedulerContext(this.scheduler.getContext());
				}
				this.scheduler.setJobFactory(this.jobFactory);
			}
		}

		finally {
			if (this.taskExecutor != null) {
				configTimeTaskExecutorHolder.set(null);
			}
		}

		populateSchedulerContext();

		loadJobAndTriggers();
		
		registerJobsAndTriggers();

		// Start Scheduler immediately, if demanded.
		if (this.autoStartup) {
			startScheduler(this.scheduler, this.startupDelay);
		}
	}


	/**
	 * Load and/or apply Quartz properties to the given SchedulerFactory.
	 * @param schedulerFactory the SchedulerFactory to initialize
	 */
	private void initSchedulerFactory(SchedulerFactory schedulerFactory)
			throws SchedulerException, IOException {

		if (this.configLocation != null || this.quartzProperties != null ||
				this.schedulerName != null || this.taskExecutor != null) {

			if (!(schedulerFactory instanceof StdSchedulerFactory)) {
				throw new IllegalArgumentException("StdSchedulerFactory required for applying Quartz properties");
			}

			Properties mergedProps = new Properties();

			// Set necessary default properties here, as Quartz will not apply
			// its default configuration when explicitly given properties.
			if (this.taskExecutor != null) {
				mergedProps.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_CLASS, LocalTaskExecutorThreadPool.class.getName());
			}
			else {
				mergedProps.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_CLASS, SimpleThreadPool.class.getName());
				mergedProps.setProperty(PROP_THREAD_COUNT, Integer.toString(DEFAULT_THREAD_COUNT));
			}

			if (this.configLocation != null) {
				if (logger.isInfoEnabled()) {
					logger.info("Loading Quartz config from [" + this.configLocation + "]");
				}
				PropertiesLoaderUtils.fillProperties(mergedProps, this.configLocation);
			}

			CollectionUtils.mergePropertiesIntoMap(this.quartzProperties, mergedProps);


			// Make sure to set the scheduler name as configured in the Spring configuration.
			if (this.schedulerName != null) {
				mergedProps.put(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, this.schedulerName);
			}

			((StdSchedulerFactory) schedulerFactory).initialize(mergedProps);
		}
	}

	/**
	 * Create the Scheduler instance for the given factory and scheduler name.
	 * Called by afterPropertiesSet.
	 * <p>Default implementation invokes SchedulerFactory's <code>getScheduler</code>
	 * method. Can be overridden for custom Scheduler creation.
	 * @param schedulerFactory the factory to create the Scheduler with
	 * @param schedulerName the name of the scheduler to create
	 * @return the Scheduler instance
	 * @throws SchedulerException if thrown by Quartz methods
	 * @see #afterPropertiesSet
	 * @see org.quartz.SchedulerFactory#getScheduler
	 */
	protected Scheduler createScheduler(SchedulerFactory schedulerFactory, String schedulerName)
			throws SchedulerException {

		// StdSchedulerFactory's default "getScheduler" implementation
		// uses the scheduler name specified in the Quartz properties,
		// which we have set before (in "initSchedulerFactory").
		return schedulerFactory.getScheduler();
	}

	/**
	 * Expose the specified context attributes and/or the current
	 * ApplicationContext in the Quartz SchedulerContext.
	 */
	private void populateSchedulerContext() throws SchedulerException {
		// Put specified objects into Scheduler context.
		if (this.schedulerContextMap != null) {
			this.scheduler.getContext().putAll(this.schedulerContextMap);
		}

		// Register ApplicationContext in Scheduler context.
		if (this.applicationContextSchedulerContextKey != null) {
			if (this.applicationContext == null) {
				throw new IllegalStateException(
				    "SchedulerFactoryBean needs to be set up in an ApplicationContext " +
				    "to be able to handle an 'applicationContextSchedulerContextKey'");
			}
			this.scheduler.getContext().put(this.applicationContextSchedulerContextKey, this.applicationContext);
		}
	}


	/**
	 * Register jobs and triggers (within a transaction, if possible).
	 */
	private void registerJobsAndTriggers() throws SchedulerException {
		try {

			if (this.jobSchedulingDataLocations != null) {
				ResourceJobSchedulingDataProcessor dataProcessor = new ResourceJobSchedulingDataProcessor();
				if (this.applicationContext != null) {
					dataProcessor.setResourceLoader(this.applicationContext);
				}
				for (int i = 0; i < this.jobSchedulingDataLocations.length; i++) {
					dataProcessor.processFileAndScheduleJobs(
					    this.jobSchedulingDataLocations[i], this.scheduler, this.overwriteExistingJobs);
				}
			}

			// Register JobDetails.
			for (Iterator it = this.jobDetails.iterator(); it.hasNext();) {
				JobDetail jobDetail = (JobDetail) it.next();
				addJobToScheduler(jobDetail);
			}


			// Register Calendars.
			if (this.calendars != null) {
				for (Iterator it = this.calendars.keySet().iterator(); it.hasNext();) {
					String calendarName = (String) it.next();
					Calendar calendar = (Calendar) this.calendars.get(calendarName);
					this.scheduler.addCalendar(calendarName, calendar, true, true);
				}
			}

			// Register Triggers.
			if (this.triggers != null) {
				for (Iterator it = this.triggers.iterator(); it.hasNext();) {
					Trigger trigger = (Trigger) it.next();
					addTriggerToScheduler(trigger);
				}
			}
		}

		catch (Throwable ex) {
			if (ex instanceof SchedulerException) {
				throw (SchedulerException) ex;
			}
			if (ex instanceof Exception) {
				throw new SchedulerException(
						"Registration of jobs and triggers failed: " + ex.getMessage(), (Exception) ex);
			}
			throw new SchedulerException("Registration of jobs and triggers failed: " + ex.getMessage());
		}
	}

	/**
	 * Add the given job to the Scheduler, if it doesn't already exist.
	 * Overwrites the job in any case if "overwriteExistingJobs" is set.
	 * @param jobDetail the job to add
	 * @return <code>true</code> if the job was actually added,
	 * <code>false</code> if it already existed before
	 * @see #setOverwriteExistingJobs
	 */
	private boolean addJobToScheduler(JobDetail jobDetail) throws SchedulerException {
		if (this.overwriteExistingJobs ||
		    this.scheduler.getJobDetail(jobDetail.getName(), jobDetail.getGroup()) == null) {
			this.scheduler.addJob(jobDetail, true);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Add the given trigger to the Scheduler, if it doesn't already exist.
	 * Overwrites the trigger in any case if "overwriteExistingJobs" is set.
	 * @param trigger the trigger to add
	 * @return <code>true</code> if the trigger was actually added,
	 * <code>false</code> if it already existed before
	 * @see #setOverwriteExistingJobs
	 */
	private boolean addTriggerToScheduler(Trigger trigger) throws SchedulerException {
		boolean triggerExists = (this.scheduler.getTrigger(trigger.getName(), trigger.getGroup()) != null);
		if (!triggerExists || this.overwriteExistingJobs) {
			// Check if the Trigger is aware of an associated JobDetail.
			if (trigger instanceof JobDetailAwareTrigger) {
				JobDetail jobDetail = ((JobDetailAwareTrigger) trigger).getJobDetail();
				// Automatically register the JobDetail too.
				if (!this.jobDetails.contains(jobDetail) && addJobToScheduler(jobDetail)) {
					this.jobDetails.add(jobDetail);
				}
			}
			if (!triggerExists) {
				try {
					this.scheduler.scheduleJob(trigger);
				}
				catch (ObjectAlreadyExistsException ex) {
					if (logger.isDebugEnabled()) {
						logger.debug("Unexpectedly found existing trigger, assumably due to cluster race condition: " +
								ex.getMessage() + " - can safely be ignored");
					}
					if (this.overwriteExistingJobs) {
						this.scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
					}
				}
			}
			else {
				this.scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
			}
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Start the Quartz Scheduler, respecting the "startupDelay" setting.
	 * @param scheduler the Scheduler to start
	 * @param startupDelay the number of seconds to wait before starting
	 * the Scheduler asynchronously
	 */
	protected void startScheduler(final Scheduler scheduler, final int startupDelay) throws SchedulerException {
		if (startupDelay <= 0) {
			logger.info("Starting Quartz Scheduler now");
			scheduler.start();
		}
		else {
			if (logger.isInfoEnabled()) {
				logger.info("Will start Quartz Scheduler [" + scheduler.getSchedulerName() +
						"] in " + startupDelay + " seconds");
			}
			Thread schedulerThread = new Thread() {
				public void run() {
					try {
						Thread.sleep(startupDelay * 1000);
					}
					catch (InterruptedException ex) {
						// simply proceed
					}
					if (logger.isInfoEnabled()) {
						logger.info("Starting Quartz Scheduler now, after delay of " + startupDelay + " seconds");
					}
					try {
						scheduler.start();
					}
					catch (SchedulerException ex) {
						throw new SchedulingException("Could not start Quartz Scheduler after delay", ex);
					}
				}
			};
			schedulerThread.setName("Quartz Scheduler [" + scheduler.getSchedulerName() + "]");
			schedulerThread.start();
		}
	}


	//---------------------------------------------------------------------
	// Implementation of FactoryBean interface
	//---------------------------------------------------------------------

	public Object getObject() {
		return this.scheduler;
	}

	public Class getObjectType() {
		return (this.scheduler != null) ? this.scheduler.getClass() : Scheduler.class;
	}

	public boolean isSingleton() {
		return true;
	}


	//---------------------------------------------------------------------
	// Implementation of Lifecycle interface
	//---------------------------------------------------------------------

	public void start() throws SchedulingException {
		if (this.scheduler != null) {
			try {
				this.scheduler.start();
			}
			catch (SchedulerException ex) {
				throw new SchedulingException("Could not start Quartz Scheduler", ex);
			}
		}
	}

	public void stop() throws SchedulingException {
		if (this.scheduler != null) {
			try {
				this.scheduler.standby();
			}
			catch (SchedulerException ex) {
				throw new SchedulingException("Could not stop Quartz Scheduler", ex);
			}
		}
	}

	public boolean isRunning() throws SchedulingException {
		if (this.scheduler != null) {
			try {
				return !this.scheduler.isInStandbyMode();
			}
			catch (SchedulerException ex) {
				return false;
			}
		}
		return false;
	}


	//---------------------------------------------------------------------
	// Implementation of DisposableBean interface
	//---------------------------------------------------------------------

	/**
	 * Shut down the Quartz scheduler on bean factory shutdown,
	 * stopping all scheduled jobs.
	 */
	public void destroy() throws SchedulerException {
		logger.info("Shutting down Quartz Scheduler");
		this.scheduler.shutdown(this.waitForJobsToCompleteOnShutdown);
	}

	//---------------------------------------------------------------------
	// 扩展功能
	//---------------------------------------------------------------------
	
	/* (non-Javadoc)
	 * @see org.hi.base.schedule.SchedulerFactoryBean#restart()
	 */
	public void restart() throws Exception{
		destroy();
		this.autoStartup = true;
		afterPropertiesSet();
		
	}
	

	/* (non-Javadoc)
	 * @see org.hi.base.schedule.SchedulerFactoryBean#shutdown()
	 */
	public void shutdown() throws Exception {
		destroy();
	}
	
	public void setJobDetailDefManager(JobDetailDefManager jobDetailDefManager) {
		this.jobDetailDefManager = jobDetailDefManager;
	}

	public void setTriggerDefManager(TriggerDefManager triggerDefManager) {
		this.triggerDefManager = triggerDefManager;
	}
	
	/**
	 * 通过从数据库取出对JobDeail与Trigger的定义,构建出JobDeail与Trigger实例
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	protected void loadJobAndTriggers() throws ClassNotFoundException, ParseException{
		
		// load JobDetail
		this.jobDetails.clear();
		try{
		Filter filter = FilterFactory.getSimpleFilter("enabled", null).addCondition("enabled", YesNo.YESNO_YES, null, Filter.RELATION_OR);
		List<JobDetailDef> jobDetailDefs = jobDetailDefManager.getObjects();
		
		for (JobDetailDef jobDetailDef : jobDetailDefs) {
			Class jobClass = Class.forName(jobDetailDef.getJobClassName());
			
			// Build JobDetail instance.
			String jobGroup = jobDetailDef.getJobGroup();
			jobGroup = (jobGroup == null || jobGroup.trim().equals("")) ? Scheduler.DEFAULT_GROUP : jobGroup;
			
			JobDetail jobDetail = new JobDetail(jobDetailDef.getJobName(), jobGroup, jobClass);
			jobDetail.getJobDataMap().put("jobDetailDef", jobDetailDef);
			jobDetail.setVolatility(jobDetailDef.getVolatiled() == null || jobDetailDef.getVolatiled().equals(YesNo.YESNO_NO) ? false : true);
			jobDetail.setDurability(jobDetailDef.getDurable() == null || jobDetailDef.getDurable().equals(YesNo.YESNO_NO) ? false : true);
			jobDetail.setRequestsRecovery(jobDetailDef.getShouldRecover() == null || jobDetailDef.getShouldRecover().equals(YesNo.YESNO_NO) ? false : true);
			jobDetail.setDescription(jobDetailDef.getDescription());
			this.jobDetails.add(jobDetail);
		}
		
		//load Trigger
		this.triggers.clear();
		List<TriggerDef> triggerDefs = this.triggerDefManager.getObjects(filter);
		for (TriggerDef triggerDef : triggerDefs) {
			JobDetailDef jobDetailDef = triggerDef.getJobDetail();
			CronTrigger cronTrigger = new CronTrigger(triggerDef.getTriggerName()
					, triggerDef.getTriggerGroup() == null ? Scheduler.DEFAULT_GROUP : triggerDef.getTriggerGroup()
					, jobDetailDef.getJobName()
					, jobDetailDef.getJobGroup() == null ? Scheduler.DEFAULT_GROUP : jobDetailDef.getJobGroup());
			cronTrigger.setPriority(triggerDef.getPriority() == null ? Trigger.DEFAULT_PRIORITY : triggerDef.getPriority());
			cronTrigger.setStartTime(triggerDef.getStartTime() == null ? new Date() : new Date(triggerDef.getStartTime().getTime()));
			cronTrigger.setEndTime(triggerDef.getEndTime() != null ? new Date(triggerDef.getEndTime().getTime()) : null);
			cronTrigger.setCronExpression(triggerDef.getCronExpression());
			cronTrigger.setTimeZone(TimeZone.getDefault());
			cronTrigger.setDescription(triggerDef.getDescription());
			this.triggers.add(cronTrigger);
		}
		}
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
