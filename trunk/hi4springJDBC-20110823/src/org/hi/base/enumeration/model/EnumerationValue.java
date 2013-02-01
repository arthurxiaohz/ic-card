/*    */ package org.hi.base.enumeration.model;
/*    */ 
/*    */ import org.hi.base.enumeration.model.original.EnumerationValueAbstract;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class EnumerationValue extends EnumerationValueAbstract
/*    */ {
/*    */   public String getDescription()
/*    */   {
/* 14 */     if (HiConfigHolder.getI18NLanguage() == null) {
/* 15 */       return this.description;
/*    */     }
/* 17 */     if (this.enumeration == null) {
/* 18 */       return this.description;
/*    */     }
/* 20 */     return I18NUtil.getString(this.displayRef, this.enumeration.getEnName());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.model.EnumerationValue
 * JD-Core Version:    0.6.0
 */