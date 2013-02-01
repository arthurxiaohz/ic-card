/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.RoleAuthority;
/*    */ import org.hi.framework.security.service.RoleAuthorityManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class RoleAuthorityManagerImpl extends ManagerImpl
/*    */   implements RoleAuthorityManager
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
/*    */   public void saveRoleAuthority(RoleAuthority RoleAuthority)
/*    */   {
/* 34 */     saveObject(RoleAuthority);
/*    */   }
/*    */ 
/*    */   public void removeRoleAuthorityById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public RoleAuthority getRoleAuthorityById(Integer id)
/*    */   {
/* 44 */     return (RoleAuthority)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> getRoleAuthorityList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityRoleAuthority(RoleAuthority roleAuthority) {
/* 52 */     saveObject(roleAuthority);
/*    */   }
/*    */   public void removeSecurityRoleAuthorityById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public RoleAuthority getSecurityRoleAuthorityById(Integer id) {
/* 58 */     return (RoleAuthority)getObjectById(id);
/*    */   }
/*    */   public List<RoleAuthority> getSecurityRoleAuthorityList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.impl.RoleAuthorityManagerImpl
 * JD-Core Version:    0.6.0
 */