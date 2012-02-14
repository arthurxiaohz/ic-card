/*    */ package org.hi.studio.hsceditor.visual.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.studio.hsceditor.dialect.IIndexType;
/*    */ 
/*    */ public class IndexModel
/*    */ {
/*    */   private String indexName;
/*    */   private IIndexType indexType;
/* 18 */   private List<String> columns = new ArrayList();
/*    */ 
/*    */   public String getIndexName() {
/* 21 */     return this.indexName;
/*    */   }
/*    */ 
/*    */   public void setIndexName(String indexName) {
/* 25 */     this.indexName = indexName;
/*    */   }
/*    */ 
/*    */   public IIndexType getIndexType()
/*    */   {
/* 34 */     return this.indexType;
/*    */   }
/*    */ 
/*    */   public void setIndexType(IIndexType indexType)
/*    */   {
/* 43 */     this.indexType = indexType;
/*    */   }
/*    */ 
/*    */   public List<String> getColumns() {
/* 47 */     return this.columns;
/*    */   }
/*    */ 
/*    */   public void setColumns(List<String> columns) {
/* 51 */     this.columns = columns;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 55 */     StringBuilder sb = new StringBuilder();
/* 56 */     for (String column : this.columns) {
/* 57 */       if (sb.length() != 0) {
/* 58 */         sb.append(", ");
/*    */       }
/* 60 */       sb.append(column);
/*    */     }
/* 62 */     return this.indexName + " - " + this.indexType.getName() + " (" + sb.toString() + ")";
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.IndexModel
 * JD-Core Version:    0.6.0
 */