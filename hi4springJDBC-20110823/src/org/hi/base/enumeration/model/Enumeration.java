/*    */ package org.hi.base.enumeration.model;
/*    */ 
/*    */ import org.hi.base.enumeration.model.original.EnumerationAbstract;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class Enumeration extends EnumerationAbstract
/*    */ {
/*    */   public String getDescription()
/*    */   {
/* 13 */     if (HiConfigHolder.getI18NLanguage() == null) {
/* 14 */       return this.description;
/*    */     }
/* 16 */     return I18NUtil.getString(this.displayRef);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.enumeration.model.Enumeration
 * JD-Core Version:    0.6.0
 */