/*    */ package org.hi.base.menu.model;
/*    */ 
/*    */ import org.hi.base.menu.model.original.MenuAbstract;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.i18n.util.I18NUtil;
/*    */ 
/*    */ public class Menu extends MenuAbstract
/*    */ {
/*    */   public String getDisplay()
/*    */   {
/* 11 */     if (HiConfigHolder.getI18NLanguage() == null)
/* 12 */       return this.description;
/* 13 */     return I18NUtil.getString(this.displayRef);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.model.Menu
 * JD-Core Version:    0.6.0
 */