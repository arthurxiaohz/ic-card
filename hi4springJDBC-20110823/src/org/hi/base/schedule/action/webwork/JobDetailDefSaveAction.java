/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class JobDetailDefSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private JobDetailDef jobDetailDef;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.jobDetailDef) != null) return returnCommand();
/* 14 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/* 15 */     jobDetailDefMgr.saveJobDetailDef(this.jobDetailDef);
/* 16 */     super.postExecute(this.jobDetailDef);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public JobDetailDef getJobDetailDef() {
/* 21 */     return this.jobDetailDef;
/*    */   }
/*    */ 
/*    */   public void setJobDetailDef(JobDetailDef jobDetailDef) {
/* 25 */     this.jobDetailDef = jobDetailDef;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.JobDetailDefSaveAction
 * JD-Core Version:    0.6.0
 */