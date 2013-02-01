/*    */ package org.hi.base.menu.filter;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.strutsmenu.MenuCollectionProcessor;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ 
/*    */ public class HiMenuMenuLinkCollectionProcessor
/*    */   implements MenuCollectionProcessor
/*    */ {
/*    */   public Collection getCollection(Collection coll, Map<String, String> parameters)
/*    */   {
/* 16 */     if (HiConfigHolder.getI18NLanguage() != null) {
/* 17 */       return coll;
/*    */     }
/*    */ 
/* 20 */     for (Iterator iterator = coll.iterator(); iterator.hasNext(); ) {
/* 21 */       Object obj = iterator.next();
/*    */ 
/* 23 */       if ((obj instanceof Menu)) {
/* 24 */         Menu menu = (Menu)obj;
/* 25 */         if (menu.getMenuName().equals("i18n")) {
/* 26 */           iterator.remove();
/* 27 */           coll.remove(obj);
/*    */         }
/*    */       }
/* 30 */       if ((obj instanceof MenuLink)) {
/* 31 */         MenuLink menuLink = (MenuLink)obj;
/* 32 */         if (menuLink.getMenu().getMenuName().equals("i18n")) {
/* 33 */           iterator.remove();
/* 34 */           coll.remove(obj);
/*    */         }
/*    */       }
/*    */     }
/* 38 */     return coll;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.filter.HiMenuMenuLinkCollectionProcessor
 * JD-Core Version:    0.6.0
 */