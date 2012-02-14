/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import org.hi.studio.hsceditor.Messages;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class MySQLDialect extends AbstractDialect
/*    */ {
/* 12 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 13 */     new ColumnType("BOOL", Messages.getResourceString("type.boolean"), true, 16), 
/* 14 */     new ColumnType("BOOLEAN", Messages.getResourceString("type.boolean"), true, 16), 
/* 15 */     new ColumnType("BIT", Messages.getResourceString("type.bit"), true, -7), 
/* 16 */     new ColumnType("TINYINT", Messages.getResourceString("type.integer"), true, -6), 
/* 17 */     new ColumnType("SMALLINT", Messages.getResourceString("type.integer"), true, 5), 
/* 18 */     new ColumnType("MEDIUMINT", Messages.getResourceString("type.integer"), true, 4), 
/* 19 */     new ColumnType("INT", Messages.getResourceString("type.integer"), true, 4), 
/* 20 */     new ColumnType("INTEGER", Messages.getResourceString("type.integer"), true, 4), 
/* 21 */     new ColumnType("BIGINT", Messages.getResourceString("type.integer"), true, -5), 
/* 22 */     new ColumnType("FLOAT", Messages.getResourceString("type.real"), true, 6), 
/* 23 */     new ColumnType("DOUBLE", Messages.getResourceString("type.real"), true, 8), 
/* 24 */     new ColumnType("DECIMAL", Messages.getResourceString("type.real"), true, 3), 
/* 25 */     new ColumnType("DEC", Messages.getResourceString("type.real"), true, 3), 
/* 26 */     new ColumnType("DATE", Messages.getResourceString("type.date"), false, 91), 
/* 27 */     new ColumnType("DATETIME", Messages.getResourceString("type.datetime"), false, 91), 
/* 28 */     new ColumnType("TIME", Messages.getResourceString("type.time"), false, 92), 
/* 29 */     new ColumnType("TIMESTAMP", Messages.getResourceString("type.datetime"), false, 93), 
/* 30 */     new ColumnType("YEAR", Messages.getResourceString("type.year"), false, 4), 
/* 31 */     new ColumnType("CHAR", Messages.getResourceString("type.char"), true, 1), 
/* 32 */     new ColumnType("CHARACTER", Messages.getResourceString("type.char"), true, 1), 
/* 33 */     new ColumnType("VARCHAR", Messages.getResourceString("type.string"), true, 12), 
/* 34 */     new ColumnType("BINARY", Messages.getResourceString("type.binary"), true, -2), 
/* 35 */     new ColumnType("VARBINARY", Messages.getResourceString("type.binary"), true, -3), 
/* 36 */     new ColumnType("TINYTEXT", Messages.getResourceString("type.string"), true, 12), 
/* 37 */     new ColumnType("TEXT", Messages.getResourceString("type.string"), true, 12), 
/* 38 */     new ColumnType("MEDIUMTEXT", Messages.getResourceString("type.string"), true, 12), 
/* 39 */     new ColumnType("LONGTEXT", Messages.getResourceString("type.string"), true, 12) };
/*    */ 
/*    */   public MySQLDialect()
/*    */   {
/* 50 */     super(COLUMN_TYPES);
/*    */   }
/*    */ 
/*    */   protected String createColumnDDL(RootModel root, TableModel tableModel, ColumnModel columnModel, boolean schema, boolean alterTable, StringBuilder additions)
/*    */   {
/* 55 */     String ddl = super.createColumnDDL(root, tableModel, columnModel, schema, alterTable, additions);
/* 56 */     if (columnModel.isAutoIncrement()) {
/* 57 */       ddl = ddl + " AUTO_INCREMENT";
/*    */     }
/* 59 */     return ddl;
/*    */   }
/*    */ 
/*    */   public String getColumnMetadataSQL(String tableName) {
/* 63 */     return "SELECT * FROM " + tableName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.MySQLDialect
 * JD-Core Version:    0.6.0
 */