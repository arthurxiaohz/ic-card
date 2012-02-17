/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import org.hi.studio.hsceditor.Messages;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class PostgreSQLDialect extends AbstractDialect
/*    */ {
/* 12 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 13 */     new ColumnType("BIGINT", Messages.getResourceString("type.integer"), false, -5), 
/* 14 */     new ColumnType("BIT", Messages.getResourceString("type.bit"), true, -7), 
/* 15 */     new ColumnType("VARBIT", Messages.getResourceString("type.bit"), true, -7), 
/* 16 */     new ColumnType("BOOLEAN", Messages.getResourceString("type.boolean"), false, 16), 
/* 18 */     new ColumnType("BYTEA", Messages.getResourceString("type.binary"), false, -2), 
/* 19 */     new ColumnType("VARCHAR", Messages.getResourceString("type.string"), true, 12), 
/* 20 */     new ColumnType("CHARACTER", Messages.getResourceString("type.char"), true, 1), 
/* 23 */     new ColumnType("DATE", Messages.getResourceString("type.date"), false, 91), 
/* 26 */     new ColumnType("INTEGER", Messages.getResourceString("type.integer"), false, 4), 
/* 32 */     new ColumnType("NUMERIC", Messages.getResourceString("type.numeric"), true, 2), 
/* 36 */     new ColumnType("REAL", Messages.getResourceString("type.real"), false, 7), 
/* 37 */     new ColumnType("SMALLINT", Messages.getResourceString("type.integer"), false, 5), 
/* 38 */     new ColumnType("TEXT", Messages.getResourceString("type.string"), false, 12), 
/* 39 */     new ColumnType("TIME", Messages.getResourceString("type.time"), false, 92), 
/* 40 */     new ColumnType("TIMESTAMP", Messages.getResourceString("type.datetime"), false, 93), 
/* 45 */     new ColumnType("SERIAL", Messages.getResourceString("type.serial"), false, 4), 
/* 46 */     new ColumnType("BIGSERIAL", Messages.getResourceString("type.serial"), false, -5), 
/* 47 */     new ColumnType("XML", Messages.getResourceString("type.xml"), false, 1111) };
/*    */ 
/*    */   public PostgreSQLDialect()
/*    */   {
/* 51 */     super(COLUMN_TYPES);
/*    */   }
/*    */ 
/*    */   protected String createColumnDDL(RootModel root, TableModel tableModel, ColumnModel columnModel, boolean schema, boolean alterTable, StringBuilder additions)
/*    */   {
/* 57 */     StringBuffer sb = new StringBuffer();
/* 58 */     sb.append(columnModel.getColumnName());
/* 59 */     if (columnModel.isAutoIncrement()) {
/* 60 */       if (columnModel.getColumnType().getName().equals("BIGINT"))
/* 61 */         sb.append(" BIGSERIAL");
/*    */       else
/* 63 */         sb.append(" SERIAL");
/*    */     }
/*    */     else {
/* 66 */       sb.append(" ").append(columnModel.getColumnType().getName());
/* 67 */       if (columnModel.getColumnType().supportSize()) {
/* 68 */         sb.append("(").append(columnModel.getSize()).append(")");
/*    */       }
/* 70 */       if (columnModel.isNotNull()) {
/* 71 */         sb.append(" NOT NULL");
/*    */       }
/*    */     }
/* 74 */     if (columnModel.getDefaultValue().length() != 0) {
/* 75 */       sb.append(" DEFAULT ").append(columnModel.getDefaultValue());
/*    */     }
/* 77 */     if ((columnModel.isPrimaryKey()) && 
/* 78 */       (!alterTable) && (tableModel.getPrimaryKeyColumns().length == 1)) {
/* 79 */       sb.append(" PRIMARY KEY");
/*    */     }
/*    */ 
/* 82 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.PostgreSQLDialect
 * JD-Core Version:    0.6.0
 */