/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.GroupRole;
/*    */ import org.hi.framework.security.service.GroupRoleManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class GroupRoleManagerImpl extends ManagerImpl
/*    */   implements GroupRoleManager
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
/*    */   public void saveGroupRole(GroupRole GroupRole)
/*    */   {
/* 34 */     saveObject(GroupRole);
/*    */   }
/*    */ 
/*    */   public void removeGroupRoleById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public GroupRole getGroupRoleById(Integer id)
/*    */   {
/* 44 */     return (GroupRole)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<GroupRole> getGroupRoleList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityGroupRole(GroupRole groupRole) {
/* 52 */     saveObject(groupRole);
/*    */   }
/*    */   public void removeSecurityGroupRoleById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public GroupRole getSecurityGroupRoleById(Integer id) {
/* 58 */     return (GroupRole)getObjectById(id);
/*    */   }
/*    */   public List<GroupRole> getSecurityGroupRoleList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.impl.GroupRoleManagerImpl
 * JD-Core Version:    0.6.0
 */