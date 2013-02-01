/*    */ package org.hi.i18n.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ import org.hi.i18n.model.LanguageStr;
/*    */ import org.hi.i18n.service.LanguageStrManager;
/*    */ 
/*    */ public class LanguageStrManagerImpl extends ManagerImpl
/*    */   implements LanguageStrManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 13 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 18 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 23 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 28 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveLanguageStr(LanguageStr languageStr)
/*    */   {
/* 33 */     saveObject(languageStr);
/*    */   }
/*    */ 
/*    */   public void removeLanguageStrById(Integer id)
/*    */   {
/* 38 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public LanguageStr getLanguageStrById(Integer id)
/*    */   {
/* 43 */     return (LanguageStr)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<LanguageStr> getLanguageStrList(PageInfo pageInfo) {
/* 47 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityLanguageStr(LanguageStr languageStr) {
/* 51 */     saveObject(languageStr);
/*    */   }
/*    */ 
/*    */   public void removeSecurityLanguageStrById(Integer id)
/*    */   {
/* 56 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public LanguageStr getSecurityLanguageStrById(Integer id)
/*    */   {
/* 61 */     return (LanguageStr)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<LanguageStr> getSecurityLanguageStrList(PageInfo pageInfo) {
/* 65 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.i18n.service.impl.LanguageStrManagerImpl
 * JD-Core Version:    0.6.0
 */