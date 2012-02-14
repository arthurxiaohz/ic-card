/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import org.hi.studio.hsceditor.Messages;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class HsqldbDialect extends AbstractDialect
/*    */ {
/* 14 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 15 */     new ColumnType("INT", Messages.getResourceString("type.integer"), false, 4), 
/* 16 */     new ColumnType("INTEGER", Messages.getResourceString("type.integer"), false, 4), 
/* 17 */     new ColumnType("DOUBLE", Messages.getResourceString("type.real"), false, 8), 
/* 18 */     new ColumnType("FLOAT", Messages.getResourceString("type.real"), false, 6), 
/* 19 */     new ColumnType("VARCHAR", Messages.getResourceString("type.string"), true, 12), 
/* 20 */     new ColumnType("VARCHAR_IGNORECASE", Messages.getResourceString("type.string"), true, 12), 
/* 21 */     new ColumnType("CHAR", Messages.getResourceString("type.char"), true, 1), 
/* 22 */     new ColumnType("CHARACTER", Messages.getResourceString("type.char"), true, 1), 
/* 23 */     new ColumnType("DECIMAL", Messages.getResourceString("type.real"), true, 3), 
/* 24 */     new ColumnType("NUMERIC", Messages.getResourceString("type.numeric"), true, 2), 
/* 25 */     new ColumnType("BOOLEAN", Messages.getResourceString("type.boolean"), true, 16), 
/* 26 */     new ColumnType("BIT", Messages.getResourceString("type.bit"), true, -7), 
/* 27 */     new ColumnType("TINYINT", Messages.getResourceString("type.integer"), true, -6), 
/* 28 */     new ColumnType("SMALLINT", Messages.getResourceString("type.integer"), true, 5), 
/* 29 */     new ColumnType("BIGINT", Messages.getResourceString("type.integer"), true, -5), 
/* 30 */     new ColumnType("REAL", Messages.getResourceString("type.real"), true, 7), 
/* 31 */     new ColumnType("BINATY", Messages.getResourceString("type.binary"), true, -2), 
/* 32 */     new ColumnType("VARBINATY", Messages.getResourceString("type.binary"), true, -2), 
/* 33 */     new ColumnType("LONGBINARY", Messages.getResourceString("type.binary"), true, -2), 
/* 34 */     new ColumnType("DATE", Messages.getResourceString("type.date"), false, 91), 
/* 35 */     new ColumnType("TIME", Messages.getResourceString("type.time"), false, 92), 
/* 36 */     new ColumnType("TIMESTAMP", Messages.getResourceString("type.datetime"), false, 93), 
/* 37 */     new ColumnType("DATETIME", Messages.getResourceString("type.datetime"), false, 93), 
/* 38 */     new ColumnType("OTHER", Messages.getResourceString("type.other"), false, 1111), 
/* 39 */     new ColumnType("OBJECT", Messages.getResourceString("type.object"), false, 1111) };
/*    */ 
/*    */   public HsqldbDialect()
/*    */   {
/* 43 */     super(COLUMN_TYPES);
/*    */   }
/*    */ 
/*    */   protected String createColumnDDL(RootModel root, TableModel tableModel, ColumnModel columnModel, boolean schema, boolean alterTable, StringBuilder additions)
/*    */   {
/* 48 */     StringBuffer sb = new StringBuffer();
/* 49 */     sb.append(columnModel.getColumnName());
/* 50 */     sb.append(" ").append(columnModel.getColumnType().getName());
/* 51 */     if (columnModel.getColumnType().supportSize()) {
/* 52 */       sb.append("(").append(columnModel.getSize()).append(")");
/*    */     }
/* 54 */     if (columnModel.getDefaultValue().length() != 0) {
/* 55 */       sb.append(" DEFAULT ").append(columnModel.getDefaultValue());
/*    */     }
/* 57 */     if (columnModel.isNotNull()) {
/* 58 */       sb.append(" NOT NULL");
/*    */     }
/* 60 */     if (columnModel.isAutoIncrement()) {
/* 61 */       sb.append(" IDENTITY");
/*    */     }
/* 63 */     if ((columnModel.isPrimaryKey()) && 
/* 64 */       (!alterTable) && (tableModel.getPrimaryKeyColumns().length == 1)) {
/* 65 */       sb.append(" PRIMARY KEY");
/*    */     }
/*    */ 
/* 68 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.HsqldbDialect
 * JD-Core Version:    0.6.0
 */