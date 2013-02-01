/*    */ package org.hi.base.menu.strutsmenu;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import org.apache.struts.util.MessageResourcesFactory;
/*    */ import org.apache.struts.util.PropertyMessageResources;
/*    */ 
/*    */ public class Resource
/*    */ {
/*    */   public static String message(String bundle, Locale locale, String key)
/*    */   {
/* 22 */     MessageResourcesFactory factoryObject = MessageResourcesFactory.createFactory();
/* 23 */     PropertyMessageResources msgResource = new PropertyMessageResources(factoryObject, bundle, false);
/* 24 */     return msgResource.getMessage(locale, key);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.Resource
 * JD-Core Version:    0.6.0
 */