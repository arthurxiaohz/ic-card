/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class PrivilegeResourceSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private PrivilegeResource privilegeResource;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.privilegeResource) != null) return returnCommand();
/* 14 */     PrivilegeResourceManager privilegeResourceMgr = (PrivilegeResourceManager)SpringContextHolder.getBean(PrivilegeResource.class);
/* 15 */     privilegeResourceMgr.savePrivilegeResource(this.privilegeResource);
/* 16 */     super.postExecute(this.privilegeResource);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public PrivilegeResource getPrivilegeResource() {
/* 21 */     return this.privilegeResource;
/*    */   }
/*    */ 
/*    */   public void setPrivilegeResource(PrivilegeResource privilegeResource) {
/* 25 */     this.privilegeResource = privilegeResource;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.PrivilegeResourceSaveAction
 * JD-Core Version:    0.6.0
 */