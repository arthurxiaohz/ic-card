/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleAuthorityManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class RoleAuthoritySaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private RoleAuthority roleAuthority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.roleAuthority) != null) return returnCommand();
/* 14 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 15 */     roleAuthorityMgr.saveRoleAuthority(this.roleAuthority);
/* 16 */     super.postExecute(this.roleAuthority);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public RoleAuthority getRoleAuthority() {
/* 21 */     return this.roleAuthority;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthority(RoleAuthority roleAuthority) {
/* 25 */     this.roleAuthority = roleAuthority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleAuthoritySaveAction
 * JD-Core Version:    0.6.0
 */