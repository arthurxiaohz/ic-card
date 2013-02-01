/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.service.HiOrgManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiOrgSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private HiOrg hiOrg;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.hiOrg) != null) return returnCommand();
/* 14 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 15 */     hiOrgMgr.saveHiOrg(this.hiOrg);
/* 16 */     super.postExecute(this.hiOrg);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiOrg getHiOrg() {
/* 21 */     return this.hiOrg;
/*    */   }
/*    */ 
/*    */   public void setHiOrg(HiOrg hiOrg) {
/* 25 */     this.hiOrg = hiOrg;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiOrgSaveAction
 * JD-Core Version:    0.6.0
 */