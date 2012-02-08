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
 * �ó�����ʵ��quartz��<code>Job</code>�ӿ�,���еĹ������񶼱���̳и���
 * ��ʵ��<code>execute()</code>����.
 * ��Ŀ���ǽ�ָ���Ĺ�������(���̳и������Ĺ�������)ʵ��quartz�����ù�������
 *<code>JobDetail</code>(quartz�������)�ĵ���
 * 
 * @see org.quartz.Job
 * @author ���
 * @since 2007-09-17
 */

public abstract class  JobDetail implements Job {
	protected static final Log logger = LogFactory.getLog(JobDetail.class);
	
	/**
	 * ����ִ�еĹ�������
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
