/*    */ package org.hi.base.schedule.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.schedule.model.JobDetailDef;
/*    */ import org.hi.base.schedule.service.JobDetailDefManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class JobDetailDefRemoveAllAction extends BaseAction
/*    */ {
/*    */   private JobDetailDef jobDetailDef;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     JobDetailDefManager jobDetailDefMgr = (JobDetailDefManager)SpringContextHolder.getBean(JobDetailDef.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer jobDetailDefid = new Integer(ids[i]);
/* 24 */         jobDetailDefMgr.removeJobDetailDefById(jobDetailDefid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public JobDetailDef getJobDetailDef() {
/* 33 */     return this.jobDetailDef;
/*    */   }
/*    */ 
/*    */   public void setJobDetailDef(JobDetailDef jobDetailDef) {
/* 37 */     this.jobDetailDef = jobDetailDef;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.action.webwork.JobDetailDefRemoveAllAction
 * JD-Core Version:    0.6.0
 */