/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import org.hi.studio.hsceditor.Messages;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class DerbyDialect extends AbstractDialect
/*    */ {
/* 12 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 13 */     new ColumnType("BOOLEAN", Messages.getResourceString("type.boolean"), true, 16), 
/* 14 */     new ColumnType("BIGINT", Messages.getResourceString("type.integer"), true, -5), 
/* 15 */     new ColumnType("VARCHAR", Messages.getResourceString("type.string"), true, 12), 
/* 16 */     new ColumnType("LONG VARCHAR", Messages.getResourceString("type.string"), true, 12), 
/* 17 */     new ColumnType("CHAR", Messages.getResourceString("type.char"), true, 1), 
/* 18 */     new ColumnType("CHARACTER", Messages.getResourceString("type.char"), true, 1), 
/* 19 */     new ColumnType("DECIMAL", Messages.getResourceString("type.real"), true, 3), 
/* 20 */     new ColumnType("DEC", Messages.getResourceString("type.real"), true, 3), 
/* 21 */     new ColumnType("NUMERIC", Messages.getResourceString("type.numeric"), true, 2), 
/* 22 */     new ColumnType("NUM", Messages.getResourceString("type.numeric"), true, 2), 
/* 23 */     new ColumnType("INT", Messages.getResourceString("type.integer"), true, 4), 
/* 24 */     new ColumnType("INTEGER", Messages.getResourceString("type.integer"), true, 4), 
/* 25 */     new ColumnType("DOUBLE", Messages.getResourceString("type.real"), true, 8), 
/* 26 */     new ColumnType("FLOAT", Messages.getResourceString("type.real"), true, 6), 
/* 27 */     new ColumnType("DATE", Messages.getResourceString("type.date"), false, 91), 
/* 28 */     new ColumnType("TIME", Messages.getResourceString("type.time"), false, 92), 
/* 29 */     new ColumnType("TIMESTAMP", Messages.getResourceString("type.datetime"), false, 93), 
/* 30 */     new ColumnType("REAL", Messages.getResourceString("type.real"), true, 7), 
/* 31 */     new ColumnType("SMALLINT", Messages.getResourceString("type.integer"), true, 5), 
/* 32 */     new ColumnType("TINYINT", Messages.getResourceString("type.integer"), true, -6), 
/* 33 */     new ColumnType("CHARACTER VARYING FOR BIT DATA", Messages.getResourceString("type.binary"), true, -2), 
/* 34 */     new ColumnType("CHAR VARYING FOR BIT DATA", Messages.getResourceString("type.binary"), true, -2), 
/* 35 */     new ColumnType("VARCHAR FOR BIT DATA", Messages.getResourceString("type.binary"), true, -2) };
/*    */ 
/*    */   public DerbyDialect()
/*    */   {
/* 46 */     super(COLUMN_TYPES);
/*    */   }
/*    */ 
/*    */   protected String createColumnDDL(RootModel root, TableModel tableModel, ColumnModel columnModel, boolean schema, boolean alterTable, StringBuilder additions)
/*    */   {
/* 51 */     String ddl = super.createColumnDDL(root, tableModel, columnModel, schema, alterTable, additions);
/* 52 */     if (columnModel.isAutoIncrement()) {
/* 53 */       ddl = ddl + " GENERATED ALWAYS AS IDENTITY";
/*    */     }
/* 55 */     return ddl;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.DerbyDialect
 * JD-Core Version:    0.6.0
 */