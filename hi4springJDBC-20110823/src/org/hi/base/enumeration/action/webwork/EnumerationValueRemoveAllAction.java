/*    */ package org.hi.base.enumeration.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.enumeration.model.EnumerationValue;
/*    */ import org.hi.base.enumeration.service.EnumerationValueManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class EnumerationValueRemoveAllAction extends BaseAction
/*    */ {
/*    */   private EnumerationValue enumerationValue;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     EnumerationValueManager enumerationValueMgr = (EnumerationValueManager)SpringContextHolder.getBean(EnumerationValue.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer enumerationValueid = new Integer(ids[i]);
/* 24 */         enumerationValueMgr.removeEnumerationValueById(enumerationValueid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public EnumerationValue getEnumerationValue() {
/* 33 */     return this.enumerationValue;
/*    */   }
/*    */ 
/*    */   public void setEnumerationValue(EnumerationValue enumerationValue) {
/* 37 */     this.enumerationValue = enumerationValue;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.action.webwork.EnumerationValueRemoveAllAction
 * JD-Core Version:    0.6.0
 */