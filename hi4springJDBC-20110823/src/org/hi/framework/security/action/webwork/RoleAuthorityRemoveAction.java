/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleAuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class RoleAuthorityRemoveAction extends BaseAction
/*    */ {
/*    */   private RoleAuthority roleAuthority;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
/* 14 */     roleAuthorityMgr.removeRoleAuthorityById(this.roleAuthority.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public RoleAuthority getRoleAuthority() {
/* 19 */     return this.roleAuthority;
/*    */   }
/*    */ 
/*    */   public void setRoleAuthority(RoleAuthority roleAuthority) {
/* 23 */     this.roleAuthority = roleAuthority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.RoleAuthorityRemoveAction
 * JD-Core Version:    0.6.0
 */