/*   */ package org.hi.base.schedule.model;
/*   */ 
/*   */ import org.hi.base.schedule.model.original.JobDetailDefAbstract;
/*   */ 
/*   */ public class JobDetailDef extends JobDetailDefAbstract
/*   */ {
/*   */   public void setJobGroup(String jobGroup)
/*   */   {
/* 9 */     this.jobGroup = ((jobGroup != null) && (jobGroup.trim().equals("")) ? null : jobGroup);
/*   */   }
/*   */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.model.JobDetailDef
 * JD-Core Version:    0.6.0
 */