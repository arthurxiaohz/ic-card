/*     */ package org.hi.base.schedule.quartz;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.base.schedule.model.JobDetailDef;
/*     */ import org.hi.base.schedule.model.TriggerDef;
/*     */ import org.hi.base.schedule.service.JobDetailDefManager;
/*     */ import org.hi.base.schedule.service.TriggerDefManager;
/*     */ import org.hi.framework.dao.Filter;
/*     */ import org.hi.framework.dao.impl.FilterFactory;
/*     */ import org.quartz.Calendar;
/*     */ import org.quartz.CronTrigger;
/*     */ import org.quartz.JobDataMap;
/*     */ import org.quartz.JobDetail;
/*     */ import org.quartz.ObjectAlreadyExistsException;
/*     */ import org.quartz.Scheduler;
/*     */ import org.quartz.SchedulerContext;
/*     */ import org.quartz.SchedulerException;
/*     */ import org.quartz.Trigger;
/*     */ import org.quartz.impl.StdSchedulerFactory;
/*     */ import org.quartz.simpl.SimpleThreadPool;
/*     */ import org.quartz.spi.JobFactory;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import org.springframework.beans.factory.DisposableBean;
/*     */ import org.springframework.beans.factory.FactoryBean;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.context.ApplicationContext;
/*     */ import org.springframework.context.ApplicationContextAware;
/*     */ import org.springframework.context.Lifecycle;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.core.io.support.PropertiesLoaderUtils;
/*     */ import org.springframework.core.task.TaskExecutor;
/*     */ import org.springframework.scheduling.SchedulingException;
/*     */ import org.springframework.scheduling.quartz.AdaptableJobFactory;
/*     */ import org.springframework.scheduling.quartz.JobDetailAwareTrigger;
/*     */ import org.springframework.scheduling.quartz.LocalTaskExecutorThreadPool;
/*     */ import org.springframework.scheduling.quartz.ResourceJobSchedulingDataProcessor;
/*     */ import org.springframework.scheduling.quartz.SchedulerContextAware;
/*     */ import org.springframework.util.CollectionUtils;
/*     */ 
/*     */ public class QuartzSchedulerFactoryBean
/*     */   implements FactoryBean, ApplicationContextAware, InitializingBean, Lifecycle, DisposableBean, org.hi.base.schedule.SchedulerFactory
/*     */ {
/*     */   public static final String PROP_THREAD_COUNT = "org.quartz.threadPool.threadCount";
/*     */   public static final int DEFAULT_THREAD_COUNT = 10;
/*  72 */   private static final ThreadLocal configTimeTaskExecutorHolder = new ThreadLocal();
/*     */ 
/*  88 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*  91 */   private Class schedulerFactoryClass = StdSchedulerFactory.class;
/*     */   private String schedulerName;
/*     */   private Resource configLocation;
/*     */   private Properties quartzProperties;
/*     */   private TaskExecutor taskExecutor;
/*     */   private Map schedulerContextMap;
/*     */   private ApplicationContext applicationContext;
/*     */   private String applicationContextSchedulerContextKey;
/* 107 */   private JobFactory jobFactory = new AdaptableJobFactory();
/*     */ 
/* 109 */   private boolean overwriteExistingJobs = false;
/*     */   private String[] jobSchedulingDataLocations;
/* 113 */   private List<JobDetail> jobDetails = new LinkedList();
/*     */   private Map calendars;
/* 117 */   private List triggers = new ArrayList();
/*     */ 
/* 119 */   private boolean autoStartup = true;
/*     */ 
/* 121 */   private int startupDelay = 0;
/*     */ 
/* 123 */   private boolean waitForJobsToCompleteOnShutdown = false;
/*     */   private JobDetailDefManager jobDetailDefManager;
/*     */   private TriggerDefManager triggerDefManager;
/*     */   private Scheduler scheduler;
/*     */ 
/*     */   public static TaskExecutor getConfigTimeTaskExecutor()
/*     */   {
/*  84 */     return (TaskExecutor)configTimeTaskExecutorHolder.get();
/*     */   }
/*     */ 
/*     */   public void setSchedulerFactoryClass(Class schedulerFactoryClass)
/*     */   {
/* 144 */     if ((schedulerFactoryClass == null) || (!org.quartz.SchedulerFactory.class.isAssignableFrom(schedulerFactoryClass))) {
/* 145 */       throw new IllegalArgumentException("schedulerFactoryClass must implement [org.quartz.SchedulerFactory]");
/*     */     }
/* 147 */     this.schedulerFactoryClass = schedulerFactoryClass;
/*     */   }
/*     */ 
/*     */   public void setSchedulerName(String schedulerName)
/*     */   {
/* 157 */     this.schedulerName = schedulerName;
/*     */   }
/*     */ 
/*     */   public void setConfigLocation(Resource configLocation)
/*     */   {
/* 168 */     this.configLocation = configLocation;
/*     */   }
/*     */ 
/*     */   public void setQuartzProperties(Properties quartzProperties)
/*     */   {
/* 178 */     this.quartzProperties = quartzProperties;
/*     */   }
/*     */ 
/*     */   public void setTaskExecutor(TaskExecutor taskExecutor)
/*     */   {
/* 195 */     this.taskExecutor = taskExecutor;
/*     */   }
/*     */ 
/*     */   public void setSchedulerContextAsMap(Map schedulerContextAsMap)
/*     */   {
/* 210 */     this.schedulerContextMap = schedulerContextAsMap;
/*     */   }
/*     */ 
/*     */   public void setApplicationContext(ApplicationContext applicationContext) {
/* 214 */     this.applicationContext = applicationContext;
/*     */   }
/*     */ 
/*     */   public void setApplicationContextSchedulerContextKey(String applicationContextSchedulerContextKey)
/*     */   {
/* 234 */     this.applicationContextSchedulerContextKey = applicationContextSchedulerContextKey;
/*     */   }
/*     */ 
/*     */   public void setJobFactory(JobFactory jobFactory)
/*     */   {
/* 248 */     this.jobFactory = jobFactory;
/*     */   }
/*     */ 
/*     */   public void setOverwriteExistingJobs(boolean overwriteExistingJobs)
/*     */   {
/* 258 */     this.overwriteExistingJobs = overwriteExistingJobs;
/*     */   }
/*     */ 
/*     */   public void setJobSchedulingDataLocation(String jobSchedulingDataLocation)
/*     */   {
/* 270 */     this.jobSchedulingDataLocations = new String[] { jobSchedulingDataLocation };
/*     */   }
/*     */ 
/*     */   public void setJobSchedulingDataLocations(String[] jobSchedulingDataLocations)
/*     */   {
/* 282 */     this.jobSchedulingDataLocations = jobSchedulingDataLocations;
/*     */   }
/*     */ 
/*     */   public void setCalendars(Map calendars)
/*     */   {
/* 294 */     this.calendars = calendars;
/*     */   }
/*     */ 
/*     */   public void setAutoStartup(boolean autoStartup)
/*     */   {
/* 303 */     this.autoStartup = autoStartup;
/*     */   }
/*     */ 
/*     */   public void setStartupDelay(int startupDelay)
/*     */   {
/* 314 */     this.startupDelay = startupDelay;
/*     */   }
/*     */ 
/*     */   public void setWaitForJobsToCompleteOnShutdown(boolean waitForJobsToCompleteOnShutdown)
/*     */   {
/* 323 */     this.waitForJobsToCompleteOnShutdown = waitForJobsToCompleteOnShutdown;
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws Exception
/*     */   {
/* 330 */     org.quartz.SchedulerFactory schedulerFactory = (org.quartz.SchedulerFactory)
/* 331 */       BeanUtils.instantiateClass(this.schedulerFactoryClass);
/*     */ 
/* 333 */     initSchedulerFactory(schedulerFactory);
/*     */ 
/* 335 */     if (this.taskExecutor != null)
/*     */     {
/* 337 */       configTimeTaskExecutorHolder.set(this.taskExecutor);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 342 */       this.scheduler = createScheduler(schedulerFactory, this.schedulerName);
/* 343 */       if (this.jobFactory != null) {
/* 344 */         if ((this.jobFactory instanceof SchedulerContextAware)) {
/* 345 */           ((SchedulerContextAware)this.jobFactory).setSchedulerContext(this.scheduler.getContext());
/*     */         }
/* 347 */         this.scheduler.setJobFactory(this.jobFactory);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 352 */       if (this.taskExecutor != null) {
/* 353 */         configTimeTaskExecutorHolder.set(null);
/*     */       }
/*     */     }
/*     */ 
/* 357 */     populateSchedulerContext();
/*     */ 
/* 359 */     loadJobAndTriggers();
/*     */ 
/* 361 */     registerJobsAndTriggers();
/*     */ 
/* 364 */     if (this.autoStartup)
/* 365 */       startScheduler(this.scheduler, this.startupDelay);
/*     */   }
/*     */ 
/*     */   private void initSchedulerFactory(org.quartz.SchedulerFactory schedulerFactory)
/*     */     throws SchedulerException, IOException
/*     */   {
/* 377 */     if ((this.configLocation != null) || (this.quartzProperties != null) || 
/* 378 */       (this.schedulerName != null) || (this.taskExecutor != null))
/*     */     {
/* 380 */       if (!(schedulerFactory instanceof StdSchedulerFactory)) {
/* 381 */         throw new IllegalArgumentException("StdSchedulerFactory required for applying Quartz properties");
/*     */       }
/*     */ 
/* 384 */       Properties mergedProps = new Properties();
/*     */ 
/* 388 */       if (this.taskExecutor != null) {
/* 389 */         mergedProps.setProperty("org.quartz.threadPool.class", LocalTaskExecutorThreadPool.class.getName());
/*     */       }
/*     */       else {
/* 392 */         mergedProps.setProperty("org.quartz.threadPool.class", SimpleThreadPool.class.getName());
/* 393 */         mergedProps.setProperty("org.quartz.threadPool.threadCount", Integer.toString(10));
/*     */       }
/*     */ 
/* 396 */       if (this.configLocation != null) {
/* 397 */         if (this.logger.isInfoEnabled()) {
/* 398 */           this.logger.info("Loading Quartz config from [" + this.configLocation + "]");
/*     */         }
/* 400 */         PropertiesLoaderUtils.fillProperties(mergedProps, this.configLocation);
/*     */       }
/*     */ 
/* 403 */       CollectionUtils.mergePropertiesIntoMap(this.quartzProperties, mergedProps);
/*     */ 
/* 407 */       if (this.schedulerName != null) {
/* 408 */         mergedProps.put("org.quartz.scheduler.instanceName", this.schedulerName);
/*     */       }
/*     */ 
/* 411 */       ((StdSchedulerFactory)schedulerFactory).initialize(mergedProps);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected Scheduler createScheduler(org.quartz.SchedulerFactory schedulerFactory, String schedulerName)
/*     */     throws SchedulerException
/*     */   {
/* 433 */     return schedulerFactory.getScheduler();
/*     */   }
/*     */ 
/*     */   private void populateSchedulerContext()
/*     */     throws SchedulerException
/*     */   {
/* 442 */     if (this.schedulerContextMap != null) {
/* 443 */       this.scheduler.getContext().putAll(this.schedulerContextMap);
/*     */     }
/*     */ 
/* 447 */     if (this.applicationContextSchedulerContextKey != null) {
/* 448 */       if (this.applicationContext == null) {
/* 449 */         throw new IllegalStateException(
/* 450 */           "SchedulerFactoryBean needs to be set up in an ApplicationContext to be able to handle an 'applicationContextSchedulerContextKey'");
/*     */       }
/*     */ 
/* 453 */       this.scheduler.getContext().put(this.applicationContextSchedulerContextKey, this.applicationContext);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void registerJobsAndTriggers()
/*     */     throws SchedulerException
/*     */   {
/*     */     try
/*     */     {
/* 464 */       if (this.jobSchedulingDataLocations != null) {
/* 465 */         ResourceJobSchedulingDataProcessor dataProcessor = new ResourceJobSchedulingDataProcessor();
/* 466 */         if (this.applicationContext != null) {
/* 467 */           dataProcessor.setResourceLoader(this.applicationContext);
/*     */         }
/* 469 */         for (int i = 0; i < this.jobSchedulingDataLocations.length; i++) {
/* 470 */           dataProcessor.processFileAndScheduleJobs(
/* 471 */             this.jobSchedulingDataLocations[i], this.scheduler, this.overwriteExistingJobs);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 476 */       for (Iterator it = this.jobDetails.iterator(); it.hasNext(); ) {
/* 477 */         JobDetail jobDetail = (JobDetail)it.next();
/* 478 */         addJobToScheduler(jobDetail);
/*     */       }
/*     */ 
/* 483 */       if (this.calendars != null) {
/* 484 */         for (Iterator it = this.calendars.keySet().iterator(); it.hasNext(); ) {
/* 485 */           String calendarName = (String)it.next();
/* 486 */           Calendar calendar = (Calendar)this.calendars.get(calendarName);
/* 487 */           this.scheduler.addCalendar(calendarName, calendar, true, true);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 492 */       if (this.triggers != null) {
/* 493 */         for (Iterator it = this.triggers.iterator(); it.hasNext(); ) {
/* 494 */           Trigger trigger = (Trigger)it.next();
/* 495 */           addTriggerToScheduler(trigger);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable ex)
/*     */     {
/* 501 */       if ((ex instanceof SchedulerException)) {
/* 502 */         throw ((SchedulerException)ex);
/*     */       }
/* 504 */       if ((ex instanceof Exception)) {
/* 505 */         throw new SchedulerException(
/* 506 */           "Registration of jobs and triggers failed: " + ex.getMessage(), (Exception)ex);
/*     */       }
/* 508 */       throw new SchedulerException("Registration of jobs and triggers failed: " + ex.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean addJobToScheduler(JobDetail jobDetail)
/*     */     throws SchedulerException
/*     */   {
/* 521 */     if ((this.overwriteExistingJobs) || 
/* 522 */       (this.scheduler.getJobDetail(jobDetail.getName(), jobDetail.getGroup()) == null)) {
/* 523 */       this.scheduler.addJob(jobDetail, true);
/* 524 */       return true;
/*     */     }
/*     */ 
/* 527 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean addTriggerToScheduler(Trigger trigger)
/*     */     throws SchedulerException
/*     */   {
/* 540 */     boolean triggerExists = this.scheduler.getTrigger(trigger.getName(), trigger.getGroup()) != null;
/* 541 */     if ((!triggerExists) || (this.overwriteExistingJobs))
/*     */     {
/* 543 */       if ((trigger instanceof JobDetailAwareTrigger)) {
/* 544 */         JobDetail jobDetail = ((JobDetailAwareTrigger)trigger).getJobDetail();
/*     */ 
/* 546 */         if ((!this.jobDetails.contains(jobDetail)) && (addJobToScheduler(jobDetail))) {
/* 547 */           this.jobDetails.add(jobDetail);
/*     */         }
/*     */       }
/* 550 */       if (!triggerExists) {
/*     */         try {
/* 552 */           this.scheduler.scheduleJob(trigger);
/*     */         }
/*     */         catch (ObjectAlreadyExistsException ex) {
/* 555 */           if (this.logger.isDebugEnabled()) {
/* 556 */             this.logger.debug("Unexpectedly found existing trigger, assumably due to cluster race condition: " + 
/* 557 */               ex.getMessage() + " - can safely be ignored");
/*     */           }
/* 559 */           if (!this.overwriteExistingJobs) break label200; 
/* 560 */         }this.scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
/*     */       }
/*     */       else
/*     */       {
/* 565 */         this.scheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
/*     */       }
/* 567 */       label200: return true;
/*     */     }
/*     */ 
/* 570 */     return false;
/*     */   }
/*     */ 
/*     */   protected void startScheduler(Scheduler scheduler, int startupDelay)
/*     */     throws SchedulerException
/*     */   {
/* 582 */     if (startupDelay <= 0) {
/* 583 */       this.logger.info("Starting Quartz Scheduler now");
/* 584 */       scheduler.start();
/*     */     }
/*     */     else {
/* 587 */       if (this.logger.isInfoEnabled()) {
/* 588 */         this.logger.info("Will start Quartz Scheduler [" + scheduler.getSchedulerName() + 
/* 589 */           "] in " + startupDelay + " seconds");
/*     */       }
/* 591 */       Thread schedulerThread = new Thread(startupDelay, scheduler) {
/*     */         public void run() {
/*     */           try {
/* 594 */             Thread.sleep(this.val$startupDelay * 1000);
/*     */           }
/*     */           catch (InterruptedException localInterruptedException)
/*     */           {
/*     */           }
/* 599 */           if (QuartzSchedulerFactoryBean.this.logger.isInfoEnabled())
/* 600 */             QuartzSchedulerFactoryBean.this.logger.info("Starting Quartz Scheduler now, after delay of " + this.val$startupDelay + " seconds");
/*     */           try
/*     */           {
/* 603 */             this.val$scheduler.start();
/*     */           }
/*     */           catch (SchedulerException ex) {
/* 606 */             throw new SchedulingException("Could not start Quartz Scheduler after delay", ex);
/*     */           }
/*     */         }
/*     */       };
/* 610 */       schedulerThread.setName("Quartz Scheduler [" + scheduler.getSchedulerName() + "]");
/* 611 */       schedulerThread.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object getObject()
/*     */   {
/* 621 */     return this.scheduler;
/*     */   }
/*     */ 
/*     */   public Class getObjectType() {
/* 625 */     return this.scheduler != null ? this.scheduler.getClass() : Scheduler.class;
/*     */   }
/*     */ 
/*     */   public boolean isSingleton() {
/* 629 */     return true;
/*     */   }
/*     */ 
/*     */   public void start()
/*     */     throws SchedulingException
/*     */   {
/* 638 */     if (this.scheduler != null)
/*     */       try {
/* 640 */         this.scheduler.start();
/*     */       }
/*     */       catch (SchedulerException ex) {
/* 643 */         throw new SchedulingException("Could not start Quartz Scheduler", ex);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void stop() throws SchedulingException
/*     */   {
/* 649 */     if (this.scheduler != null)
/*     */       try {
/* 651 */         this.scheduler.standby();
/*     */       }
/*     */       catch (SchedulerException ex) {
/* 654 */         throw new SchedulingException("Could not stop Quartz Scheduler", ex);
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean isRunning() throws SchedulingException
/*     */   {
/* 660 */     if (this.scheduler != null) {
/*     */       try {
/* 662 */         return !this.scheduler.isInStandbyMode();
/*     */       }
/*     */       catch (SchedulerException ex) {
/* 665 */         return false;
/*     */       }
/*     */     }
/* 668 */     return false;
/*     */   }
/*     */ 
/*     */   public void destroy()
/*     */     throws SchedulerException
/*     */   {
/* 681 */     this.logger.info("Shutting down Quartz Scheduler");
/* 682 */     this.scheduler.shutdown(this.waitForJobsToCompleteOnShutdown);
/*     */   }
/*     */ 
/*     */   public void restart()
/*     */     throws Exception
/*     */   {
/* 693 */     destroy();
/* 694 */     this.autoStartup = true;
/* 695 */     afterPropertiesSet();
/*     */   }
/*     */ 
/*     */   public void shutdown()
/*     */     throws Exception
/*     */   {
/* 704 */     destroy();
/*     */   }
/*     */ 
/*     */   public void setJobDetailDefManager(JobDetailDefManager jobDetailDefManager) {
/* 708 */     this.jobDetailDefManager = jobDetailDefManager;
/*     */   }
/*     */ 
/*     */   public void setTriggerDefManager(TriggerDefManager triggerDefManager) {
/* 712 */     this.triggerDefManager = triggerDefManager;
/*     */   }
/*     */ 
/*     */   protected void loadJobAndTriggers()
/*     */     throws ClassNotFoundException, ParseException
/*     */   {
/* 723 */     this.jobDetails.clear();
/*     */     try {
/* 725 */       Filter filter = FilterFactory.getSimpleFilter("enabled", null).addCondition("enabled", Integer.valueOf(3200), null, "OR");
/* 726 */       List jobDetailDefs = this.jobDetailDefManager.getObjects();
/*     */       Class jobClass;
/* 728 */       for (JobDetailDef jobDetailDef : jobDetailDefs) {
/* 729 */         jobClass = Class.forName(jobDetailDef.getJobClassName());
/*     */ 
/* 732 */         String jobGroup = jobDetailDef.getJobGroup();
/* 733 */         jobGroup = (jobGroup == null) || (jobGroup.trim().equals("")) ? "DEFAULT" : jobGroup;
/*     */ 
/* 735 */         JobDetail jobDetail = new JobDetail(jobDetailDef.getJobName(), jobGroup, jobClass);
/* 736 */         jobDetail.getJobDataMap().put("jobDetailDef", jobDetailDef);
/* 737 */         jobDetail.setVolatility((jobDetailDef.getVolatiled() != null) && (!jobDetailDef.getVolatiled().equals(Integer.valueOf(3201))));
/* 738 */         jobDetail.setDurability((jobDetailDef.getDurable() != null) && (!jobDetailDef.getDurable().equals(Integer.valueOf(3201))));
/* 739 */         jobDetail.setRequestsRecovery((jobDetailDef.getShouldRecover() != null) && (!jobDetailDef.getShouldRecover().equals(Integer.valueOf(3201))));
/* 740 */         jobDetail.setDescription(jobDetailDef.getDescription());
/* 741 */         this.jobDetails.add(jobDetail);
/*     */       }
/*     */ 
/* 745 */       this.triggers.clear();
/* 746 */       List triggerDefs = this.triggerDefManager.getObjects(filter);
/* 747 */       for (TriggerDef triggerDef : triggerDefs) {
/* 748 */         JobDetailDef jobDetailDef = triggerDef.getJobDetail();
/* 749 */         CronTrigger cronTrigger = new CronTrigger(triggerDef.getTriggerName(), 
/* 750 */           triggerDef.getTriggerGroup() == null ? "DEFAULT" : triggerDef.getTriggerGroup(), 
/* 751 */           jobDetailDef.getJobName(), 
/* 752 */           jobDetailDef.getJobGroup() == null ? "DEFAULT" : jobDetailDef.getJobGroup());
/* 753 */         cronTrigger.setPriority(triggerDef.getPriority() == null ? 5 : triggerDef.getPriority().intValue());
/* 754 */         cronTrigger.setStartTime(triggerDef.getStartTime() == null ? new Date() : new Date(triggerDef.getStartTime().getTime()));
/* 755 */         cronTrigger.setEndTime(triggerDef.getEndTime() != null ? new Date(triggerDef.getEndTime().getTime()) : null);
/* 756 */         cronTrigger.setCronExpression(triggerDef.getCronExpression());
/* 757 */         cronTrigger.setTimeZone(TimeZone.getDefault());
/* 758 */         cronTrigger.setDescription(triggerDef.getDescription());
/* 759 */         this.triggers.add(cronTrigger);
/*     */       }
/*     */     }
/*     */     catch (Throwable e) {
/* 763 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.quartz.QuartzSchedulerFactoryBean
 * JD-Core Version:    0.6.0
 */