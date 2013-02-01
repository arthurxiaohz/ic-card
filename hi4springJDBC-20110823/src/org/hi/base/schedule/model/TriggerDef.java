/*    */ package org.hi.base.schedule.model;
/*    */ 
/*    */ import org.hi.base.schedule.model.original.TriggerDefAbstract;
/*    */ 
/*    */ public class TriggerDef extends TriggerDefAbstract
/*    */ {
/*    */   private String jobDetailName;
/*    */ 
/*    */   public void setTriggerGroup(String triggerGroup)
/*    */   {
/* 10 */     this.triggerGroup = ((triggerGroup != null) && (triggerGroup.trim().equals("")) ? null : triggerGroup);
/*    */   }
/*    */   public String getJobDetailName() {
/* 13 */     return this.jobDetailName;
/*    */   }
/*    */   public void setJobDetailName(String jobDetailName) {
/* 16 */     this.jobDetailName = jobDetailName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.model.TriggerDef
 * JD-Core Version:    0.6.0
 */