/*    */ package org.hi.base.schedule.quartz;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ import org.quartz.Scheduler;
/*    */ import org.quartz.SchedulerException;
/*    */ import org.springframework.beans.BeanWrapper;
/*    */ import org.springframework.beans.BeanWrapperImpl;
/*    */ import org.springframework.beans.MutablePropertyValues;
/*    */ 
/*    */ public abstract class JobDetail
/*    */   implements Job
/*    */ {
/* 25 */   protected static final Log logger = LogFactory.getLog(JobDetail.class);
/*    */ 
/*    */   public abstract void execute();
/*    */ 
/*    */   public final void execute(JobExecutionContext context)
/*    */     throws JobExecutionException
/*    */   {
/*    */     try
/*    */     {
/* 39 */       BeanWrapper bw = new BeanWrapperImpl(this);
/* 40 */       MutablePropertyValues pvs = new MutablePropertyValues();
/* 41 */       pvs.addPropertyValues(context.getScheduler().getContext());
/* 42 */       pvs.addPropertyValues(context.getMergedJobDataMap());
/* 43 */       bw.setPropertyValues(pvs, true);
/*    */     }
/*    */     catch (SchedulerException ex) {
/* 46 */       throw new JobExecutionException(ex);
/*    */     }
/* 48 */     executeInternal(context);
/*    */   }
/*    */ 
/*    */   protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
/*    */     try {
/* 53 */       execute();
/*    */     }
/*    */     catch (Exception ex) {
/* 56 */       logger.warn(getClass() + " method execute invoke error", ex);
/* 57 */       throw new JobExecutionException(getClass() + " method execute invoke error", ex, false);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.quartz.JobDetail
 * JD-Core Version:    0.6.0
 */