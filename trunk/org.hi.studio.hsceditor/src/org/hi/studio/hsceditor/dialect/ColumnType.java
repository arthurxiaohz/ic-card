/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ColumnType
/*    */   implements IColumnType, Serializable
/*    */ {
/*    */   private String name;
/*    */   private String logicalName;
/*    */   private boolean supportSize;
/*    */   private int type;
/*    */ 
/*    */   public ColumnType(String name, String logicalName, boolean supportSize, int type)
/*    */   {
/* 13 */     this.name = name;
/* 14 */     this.logicalName = logicalName;
/* 15 */     this.supportSize = supportSize;
/* 16 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 20 */     return this.name;
/*    */   }
/*    */ 
/*    */   public String getLogicalName() {
/* 24 */     return this.logicalName;
/*    */   }
/*    */ 
/*    */   public boolean supportSize() {
/* 28 */     return this.supportSize;
/*    */   }
/*    */ 
/*    */   public int getType() {
/* 32 */     return this.type;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 36 */     return getLogicalName() + " - " + getName();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.ColumnType
 * JD-Core Version:    0.6.0
 */