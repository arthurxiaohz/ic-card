/*    */ package org.hi.studio.hsceditor;
/*    */ 
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class Messages
/*    */ {
/*  9 */   private static ResourceBundle resource = ResourceBundle.getBundle("org.hi.studio.hsceditor.DBPlugin");
/*    */ 
/*    */   public static String getResourceString(String key) {
/*    */     try {
/* 13 */       return resource.getString(key); } catch (MissingResourceException localMissingResourceException) {
/*    */     }
/* 15 */     return key;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.Messages
 * JD-Core Version:    0.6.0
 */