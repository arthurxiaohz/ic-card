/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.PrivilegeResource;
/*    */ import org.hi.framework.security.service.PrivilegeResourceManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class PrivilegeResourceManagerImpl extends ManagerImpl
/*    */   implements PrivilegeResourceManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 14 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 19 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 24 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 29 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void savePrivilegeResource(PrivilegeResource privilegeResource)
/*    */   {
/* 34 */     saveObject(privilegeResource);
/*    */   }
/*    */ 
/*    */   public void removePrivilegeResourceById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public PrivilegeResource getPrivilegeResourceById(Integer id)
/*    */   {
/* 44 */     return (PrivilegeResource)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<PrivilegeResource> getPrivilegeResourceList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityPrivilegeResource(PrivilegeResource privilegeResource) {
/* 52 */     saveObject(privilegeResource);
/*    */   }
/*    */   public void removeSecurityPrivilegeResourceById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public PrivilegeResource getSecurityPrivilegeResourceById(Integer id) {
/* 58 */     return (PrivilegeResource)getObjectById(id);
/*    */   }
/*    */   public List<PrivilegeResource> getSecurityPrivilegeResourceList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.impl.PrivilegeResourceManagerImpl
 * JD-Core Version:    0.6.0
 */