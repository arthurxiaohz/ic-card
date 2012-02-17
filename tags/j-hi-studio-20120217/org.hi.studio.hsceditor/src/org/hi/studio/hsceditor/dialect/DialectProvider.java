/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class DialectProvider
/*    */ {
/* 14 */   private static Map<String, IDialect> dialects = DBPlugin.getDefault().getContributedDialects();
/*    */ 
/*    */   public static IDialect[] getDialects() {
/* 17 */     Iterator ite = dialects.values().iterator();
/* 18 */     List dialects = new ArrayList();
/* 19 */     while (ite.hasNext()) {
/* 20 */       dialects.add((IDialect)ite.next());
/*    */     }
/* 22 */     return (IDialect[])dialects.toArray(new IDialect[dialects.size()]);
/*    */   }
/*    */ 
/*    */   public static String[] getDialectNames() {
/* 26 */     Set set = dialects.keySet();
/* 27 */     return (String[])set.toArray(new String[set.size()]);
/*    */   }
/*    */ 
/*    */   public static IDialect getDialect(String dbName) {
/* 31 */     return (IDialect)dialects.get(dbName);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.DialectProvider
 * JD-Core Version:    0.6.0
 */