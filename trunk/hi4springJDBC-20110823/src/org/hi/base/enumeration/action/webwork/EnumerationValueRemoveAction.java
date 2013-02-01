/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationValueRemoveAction extends BaseAction
/*    */ {
/*    */   private EnumerationValue enumerationValue;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/* 14 */     enumerationValueMgr.removeEnumerationValueById(this.enumerationValue.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public EnumerationValue getEnumerationValue() {
/* 19 */     return this.enumerationValue;
/*    */   }
/*    */ 
/*    */   public void setEnumerationValue(EnumerationValue enumerationValue) {
/* 23 */     this.enumerationValue = enumerationValue;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationValueRemoveAction
 * JD-Core Version:    0.6.0
 */