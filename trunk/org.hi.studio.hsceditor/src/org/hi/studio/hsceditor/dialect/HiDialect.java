/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ public class HiDialect extends AbstractDialect
/*    */ {
/* 21 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 24 */     new ColumnType("String", "字符", true, 1), 
/* 25 */     new ColumnType("Int", "整型", true, 2), 
/* 26 */     new ColumnType("Float", "浮点型", true, 3), 
/* 27 */     new ColumnType("Date", "日期型", true, 4), 
/* 28 */     new ColumnType("Datetime", "日期时间型", true, 5), 
/* 29 */     new ColumnType("Lookup", "带回型", true, 6), 
/* 30 */     new ColumnType("Enumeration", "枚举型", true, 7) };
/*    */ 
/*    */   public HiDialect()
/*    */   {
/* 34 */     super(COLUMN_TYPES);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.HiDialect
 * JD-Core Version:    0.6.0
 */