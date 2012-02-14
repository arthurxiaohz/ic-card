/*    */ package org.hi.studio.hsceditor.visual.generate;
/*    */ 
/*    */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*    */ 
/*    */ public class VelocityUtils
/*    */ {
/*    */   public String escapeHTML(String str)
/*    */   {
/*  8 */     str = str.replaceAll("&", "&amp;");
/*  9 */     str = str.replaceAll("<", "&lt;");
/* 10 */     str = str.replaceAll(">", "&gt;");
/* 11 */     str = str.replaceAll("\"", "&quote;");
/*    */ 
/* 13 */     str = str.replaceAll("\r\n", "\n");
/* 14 */     str = str.replaceAll("\r", "\n");
/* 15 */     str = str.replaceAll("\n", "<br>");
/*    */ 
/* 17 */     return str;
/*    */   }
/*    */ 
/*    */   public boolean isEmpty(String value) {
/* 21 */     return (value == null) || (value.length() == 0);
/*    */   }
/*    */ 
/*    */   public String escapeHTML2(String str) {
/* 25 */     str = escapeHTML(str);
/* 26 */     if (str.length() == 0) {
/* 27 */       return "&nbsp;";
/*    */     }
/* 29 */     return str;
/*    */   }
/*    */ 
/*    */   public boolean isEmpty(Object[] array) {
/* 33 */     return array.length == 0;
/*    */   }
/*    */ 
/*    */   public boolean isEnumeration(Object obj)
/*    */   {
/* 38 */     return (obj instanceof EnumerationModel);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.VelocityUtils
 * JD-Core Version:    0.6.0
 */