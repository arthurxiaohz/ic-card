/*    */ package org.hi.base.organization.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.service.HiOrgManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class HiOrgRemoveAction extends BaseAction
/*    */ {
/*    */   private HiOrg hiOrg;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 14 */     hiOrgMgr.removeHiOrgById(this.hiOrg.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public HiOrg getHiOrg() {
/* 19 */     return this.hiOrg;
/*    */   }
/*    */ 
/*    */   public void setHiOrg(HiOrg hiOrg) {
/* 23 */     this.hiOrg = hiOrg;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.organization.action.webwork.HiOrgRemoveAction
 * JD-Core Version:    0.6.0
 */