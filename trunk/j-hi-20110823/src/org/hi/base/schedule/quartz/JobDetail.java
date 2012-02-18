package org.hi.base.schedule.quartz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;

/**
 * 该抽象类实体quartz的<code>Job</code>接口,所有的工作任务都必须继承该类
 * 并实现<code>execute()</code>方法.
 * 其目的是将指定的工作任务(即继承该类您的工作任务)实现quartz对所用工作任务
 *<code>JobDetail</code>(quartz自身的类)的调度
 * 
 * @see org.quartz.Job
 * @author 张昊
 * @since 2007-09-17
 */

public abstract class  JobDetail implements Job {
	protected static final Log logger = LogFactory.getLog(JobDetail.class);
	
	/**
	 * 任务执行的工作内容
	 */
	public abstract void execute();
	
	/**
	 * This implementation applies the passed-in job data map as bean property
	 * values, and delegates to <code>executeInternal</code> afterwards.
	 * @see #executeInternal
	 */
	public final void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			BeanWrapper bw = new BeanWrapperImpl(this);
			MutablePropertyValues pvs = new MutablePropertyValues();
			pvs.addPropertyValues(context.getScheduler().getContext());
			pvs.addPropertyValues(context.getMergedJobDataMap());
			bw.setPropertyValues(pvs, true);
		}
		catch (SchedulerException ex) {
			throw new JobExecutionException(ex);
		}
		executeInternal(context);
	}
	
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			execute();
		}
		catch (Exception ex) {
			logger.warn(this.getClass()+" method execute invoke error", ex);
			throw new JobExecutionException(this.getClass()+" method execute invoke error", ex, false);
		}
	}
}
