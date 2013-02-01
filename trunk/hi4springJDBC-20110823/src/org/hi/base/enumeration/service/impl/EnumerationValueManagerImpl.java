/*    */ package org.hi.base.enumeration.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.Enumeration;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.base.enumeration.service.EnumerationManager;
/*    */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class EnumerationValueManagerImpl extends ManagerImpl
/*    */   implements EnumerationValueManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 20 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 27 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 34 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 40 */     EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 41 */     enumMgr.reloadEnumeration();
/* 42 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveEnumerationValue(EnumerationValue enumerationValue)
/*    */   {
/* 48 */     EnumerationManager enumMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 49 */     enumMgr.saveEnumeration(enumerationValue.getEnumeration());
/*    */   }
/*    */ 
/*    */   public void removeEnumerationValueById(Integer id)
/*    */   {
/* 55 */     EnumerationValue enumerationValue = getEnumerationValueById(id);
/* 56 */     Enumeration enumeration = enumerationValue.getEnumeration();
/* 57 */     enumeration.getEnumerationValues().remove(enumerationValue);
/* 58 */     enumerationValue.setEnumeration(null);
/* 59 */     removeObject(enumerationValue);
/*    */   }
/*    */ 
/*    */   public EnumerationValue getEnumerationValueById(Integer id)
/*    */   {
/* 66 */     return (EnumerationValue)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<EnumerationValue> getEnumerationValueList(PageInfo pageInfo)
/*    */   {
/* 72 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityEnumerationValue(EnumerationValue enumerationValue)
/*    */   {
/* 77 */     saveObject(enumerationValue);
/*    */   }
/*    */   public void removeSecurityEnumerationValueById(Integer id) {
/* 80 */     removeObjectById(id);
/*    */   }
/*    */   public EnumerationValue getSecurityEnumerationValueById(Integer id) {
/* 83 */     return (EnumerationValue)getObjectById(id);
/*    */   }
/*    */   public List<EnumerationValue> getSecurityEnumerationValueList(PageInfo pageInfo) {
/* 86 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.service.impl.EnumerationValueManagerImpl
 * JD-Core Version:    0.6.0
 */