/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.Enumeration;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.base.enumeration.service.EnumerationManager;
/*    */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationValueSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private EnumerationValue enumerationValue;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 15 */     if (super.perExecute(this.enumerationValue) != null) return returnCommand();
/* 16 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/* 17 */     EnumerationManager enumerationMgr = (EnumerationManager)SpringContextHolder.getBean(Enumeration.class);
/* 18 */     if ((this.enumerationValue.getEnumeration() != null) && (this.enumerationValue.getEnumeration().getId() != null) && (this.enumerationValue.getId() == null)) {
/* 19 */       Enumeration enumeration = enumerationMgr.getEnumerationById(this.enumerationValue.getEnumeration().getId());
/* 20 */       this.enumerationValue.setEnumeration(enumeration);
/* 21 */       enumeration.getEnumerationValues().add(this.enumerationValue);
/*    */     }
/* 23 */     enumerationValueMgr.saveEnumerationValue(this.enumerationValue);
/* 24 */     super.postExecute(this.enumerationValue);
/* 25 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public EnumerationValue getEnumerationValue() {
/* 29 */     return this.enumerationValue;
/*    */   }
/*    */ 
/*    */   public void setEnumerationValue(EnumerationValue enumerationValue) {
/* 33 */     this.enumerationValue = enumerationValue;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationValueSaveAction
 * JD-Core Version:    0.6.0
 */