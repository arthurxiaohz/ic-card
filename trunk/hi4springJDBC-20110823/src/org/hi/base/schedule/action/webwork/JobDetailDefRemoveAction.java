/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class JobDetailDefRemoveAction extends BaseAction
/*    */ {
/*    */   private JobDetailDef jobDetailDef;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/* 14 */     jobDetailDefMgr.removeJobDetailDefById(this.jobDetailDef.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public JobDetailDef getJobDetailDef() {
/* 19 */     return this.jobDetailDef;
/*    */   }
/*    */ 
/*    */   public void setJobDetailDef(JobDetailDef jobDetailDef) {
/* 23 */     this.jobDetailDef = jobDetailDef;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.JobDetailDefRemoveAction
 * JD-Core Version:    0.6.0
 */