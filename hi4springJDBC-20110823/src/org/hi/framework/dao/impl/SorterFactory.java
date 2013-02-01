/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import org.hi.framework.dao.Sorter;
/*    */ 
/*    */ public class SorterFactory
/*    */ {
/*    */   public static Sorter getSimpleSort(String name)
/*    */   {
/*  8 */     Sorter sort = new SimpleSorter();
/*  9 */     sort.addSort(name);
/* 10 */     return sort;
/*    */   }
/*    */ 
/*    */   public static Sorter getSimpleSort(String name, String direction) {
/* 14 */     Sorter sort = new SimpleSorter();
/* 15 */     sort.addSort(name, direction);
/* 16 */     return sort;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.impl.SorterFactory
 * JD-Core Version:    0.6.0
 */