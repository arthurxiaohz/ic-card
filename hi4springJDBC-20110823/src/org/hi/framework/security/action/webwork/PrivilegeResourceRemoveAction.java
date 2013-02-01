/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class PrivilegeResourceRemoveAction extends BaseAction
/*    */ {
/*    */   private PrivilegeResource privilegeResource;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/* 14 */     privilegeResourceMgr.removePrivilegeResourceById(this.privilegeResource.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public PrivilegeResource getPrivilegeResource() {
/* 19 */     return this.privilegeResource;
/*    */   }
/*    */ 
/*    */   public void setPrivilegeResource(PrivilegeResource privilegeResource) {
/* 23 */     this.privilegeResource = privilegeResource;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.PrivilegeResourceRemoveAction
 * JD-Core Version:    0.6.0
 */