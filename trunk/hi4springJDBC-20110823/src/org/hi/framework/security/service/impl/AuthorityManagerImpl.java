/*    */ package org.hi.framework.security.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class AuthorityManagerImpl extends ManagerImpl
/*    */   implements AuthorityManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 15 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 20 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 25 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 30 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveAuthority(Authority Authority)
/*    */   {
/* 35 */     saveObject(Authority);
/*    */   }
/*    */ 
/*    */   public void removeAuthorityById(Integer id)
/*    */   {
/* 40 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public Authority getAuthorityById(Integer id)
/*    */   {
/* 45 */     return (Authority)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<Authority> getAuthorityList(PageInfo pageInfo) {
/* 49 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityAuthority(Authority authority)
/*    */   {
/* 54 */     saveObject(authority);
/*    */   }
/*    */   public void removeSecurityAuthorityById(Integer id) {
/* 57 */     removeObjectById(id);
/*    */   }
/*    */   public Authority getSecurityAuthorityById(Integer id) {
/* 60 */     return (Authority)getObjectById(id);
/*    */   }
/*    */   public List<Authority> getSecurityAuthorityList(PageInfo pageInfo) {
/* 63 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.service.impl.AuthorityManagerImpl
 * JD-Core Version:    0.6.0
 */