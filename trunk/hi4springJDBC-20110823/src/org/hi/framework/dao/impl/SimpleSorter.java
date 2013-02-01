/*    */ package org.hi.framework.dao.impl;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.hi.framework.dao.Sorter;
/*    */ 
/*    */ class SimpleSorter
/*    */   implements Sorter
/*    */ {
/* 18 */   private StringBuffer strBuf = new StringBuffer();
/* 19 */   protected final Log log = LogFactory.getLog(getClass());
/*    */ 
/* 24 */   private Map<String, String> sorts = new LinkedHashMap();
/*    */ 
/* 29 */   private int n = 0;
/*    */ 
/*    */   public Sorter addSort(String name)
/*    */   {
/* 36 */     if ((name == null) || (name.trim().equals(""))) {
/* 37 */       this.log.fatal("addSort method of name is null");
/* 38 */       return this;
/*    */     }
/*    */ 
/* 41 */     return addSort(name, "ASC");
/*    */   }
/*    */ 
/*    */   public Sorter addSort(String name, String direction)
/*    */   {
/* 49 */     if ((name == null) || (name.trim().equals(""))) {
/* 50 */       this.log.fatal("addSort method of name is null");
/* 51 */       return this;
/*    */     }
/*    */ 
/* 54 */     if (direction == null) {
/* 55 */       direction = "ASC";
/*    */     }
/* 57 */     if (this.n > 0) this.strBuf.append(" ,");
/* 58 */     this.n += 1;
/* 59 */     this.sorts.put(name, direction);
/* 60 */     this.strBuf.append(name).append(" ").append(direction);
/* 61 */     return this;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 69 */     return this.strBuf.toString();
/*    */   }
/*    */ 
/*    */   public Map<String, String> getSorts()
/*    */   {
/* 76 */     return this.sorts;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.impl.SimpleSorter
 * JD-Core Version:    0.6.0
 */