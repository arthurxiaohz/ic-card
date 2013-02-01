/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.SecurityGroup;
/*    */ import org.hi.framework.security.service.SecurityGroupManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class SecurityGroupManagerImpl extends ManagerImpl
/*    */   implements SecurityGroupManager
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
/*    */   public void saveSecurityGroup(SecurityGroup SecurityGroup)
/*    */   {
/* 34 */     saveObject(SecurityGroup);
/*    */   }
/*    */ 
/*    */   public void removeSecurityGroupById(Integer id)
/*    */   {
/* 39 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public SecurityGroup getSecurityGroupById(Integer id)
/*    */   {
/* 44 */     return (SecurityGroup)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<SecurityGroup> getSecurityGroupList(PageInfo pageInfo) {
/* 48 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecuritySecurityGroup(SecurityGroup securityGroup) {
/* 52 */     saveObject(securityGroup);
/*    */   }
/*    */   public void removeSecuritySecurityGroupById(Integer id) {
/* 55 */     removeObjectById(id);
/*    */   }
/*    */   public SecurityGroup getSecuritySecurityGroupById(Integer id) {
/* 58 */     return (SecurityGroup)getObjectById(id);
/*    */   }
/*    */   public List<SecurityGroup> getSecuritySecurityGroupList(PageInfo pageInfo) {
/* 61 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.service.impl.SecurityGroupManagerImpl
 * JD-Core Version:    0.6.0
 */