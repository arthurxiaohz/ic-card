/*    */ package org.hi.studio.hsceditor.dialect;
/*    */ 
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ import org.hi.studio.hsceditor.Messages;
/*    */ import org.hi.studio.hsceditor.validator.DiagramErrors;
/*    */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*    */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*    */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*    */ 
/*    */ public class OracleDialect extends AbstractDialect
/*    */ {
/* 21 */   private static final IColumnType[] COLUMN_TYPES = { 
/* 22 */     new ColumnType("NUMBER", Messages.getResourceString("type.numeric"), true, 2), 
/* 23 */     new ColumnType("BINARY_FLOAT", Messages.getResourceString("type.bit"), false, 6), 
/* 24 */     new ColumnType("BINARY_DOUBLE", Messages.getResourceString("type.bit"), false, 8), 
/* 25 */     new ColumnType("VARCHAR2", Messages.getResourceString("type.string"), true, 12), 
/* 26 */     new ColumnType("NVARCHAR2", Messages.getResourceString("type.string"), true, 12), 
/* 27 */     new ColumnType("CHAR", Messages.getResourceString("type.char"), true, 1), 
/* 28 */     new ColumnType("NCHAR", Messages.getResourceString("type.char"), true, 1), 
/* 29 */     new ColumnType("CLOB", Messages.getResourceString("type.string"), true, 2005), 
/* 30 */     new ColumnType("DATE", Messages.getResourceString("type.date"), false, 91), 
/* 31 */     new ColumnType("TIMESTAMP", Messages.getResourceString("type.date"), true, 93), 
/* 32 */     new ColumnType("RAW", Messages.getResourceString("type.binary"), false, -2), 
/* 33 */     new ColumnType("BLOB", Messages.getResourceString("type.binary"), false, 2004) };
/*    */ 
/*    */   public OracleDialect()
/*    */   {
/* 37 */     super(COLUMN_TYPES);
/*    */   }
/*    */ 
/*    */   public String createTableDDL(RootModel root, TableModel model, boolean schema, boolean drop, boolean alterTable, boolean comment, StringBuilder additions)
/*    */   {
/* 45 */     String ddl = super.createTableDDL(
/* 46 */       root, model, schema, drop, alterTable, comment, additions);
/*    */ 
/* 48 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 50 */     for (ColumnModel column : model.getColumns()) {
/* 51 */       if (column.isAutoIncrement()) {
/* 52 */         String seqName = model.getTableName() + "_" + column.getColumnName() + "_SEQ";
/* 53 */         String triggerName = model.getTableName() + "_" + column.getColumnName() + "_TRG";
/*    */ 
/* 55 */         if (drop) {
/* 56 */           sb.append("DROP SEQUENCE ").append(seqName).append(";").append(this.LS);
/*    */ 
/* 58 */           sb.append(this.LS);
/*    */         }
/*    */ 
/* 61 */         sb.append("CREATE SEQUENCE ");
/* 62 */         sb.append(seqName);
/* 63 */         sb.append("NOMAXVALUE NOCACHE NOORDER NOCYCLE;").append(this.LS);
/*    */ 
/* 65 */         sb.append(this.LS);
/*    */ 
/* 67 */         sb.append("CREATE TRIGGER ");
/* 68 */         sb.append(triggerName).append(this.LS);
/* 69 */         sb.append("BEFORE INSERT ON ").append(model.getTableName()).append(this.LS);
/* 70 */         sb.append("FOR EACH ROW").append(this.LS);
/* 71 */         sb.append("BEGIN").append(this.LS);
/* 72 */         sb.append("SELECT ").append(seqName).append(".NEXTVAL ");
/* 73 */         sb.append("INTO :NEW.").append(column.getColumnName()).append(" FROM DUAL;").append(this.LS);
/* 74 */         sb.append("END;").append(this.LS);
/*    */       }
/*    */     }
/*    */ 
/* 78 */     if (sb.length() > 0) {
/* 79 */       return ddl = ddl + this.LS + sb.toString();
/*    */     }
/*    */ 
/* 82 */     return ddl;
/*    */   }
/*    */ 
/*    */   public void validate(DiagramErrors errors, RootModel model)
/*    */   {
/* 87 */     for (AbstractDBEntityModel entity : model.getChildren())
/* 88 */       if ((entity instanceof TableModel)) {
/* 89 */         TableModel table = (TableModel)entity;
/* 90 */         String tableName = table.getTableName();
/* 91 */         if (tableName.length() > 30) {
/* 92 */           errors.addError("ERROR", table, 
/* 93 */             DBPlugin.getResourceString("validation.error.oracle.tableNameLength"));
/*    */         }
/*    */ 
/* 96 */         for (ColumnModel column : table.getColumns()) {
/* 97 */           String columnName = column.getColumnName();
/* 98 */           if (columnName.length() > 30) {
/* 99 */             errors.addError("ERROR", table, column, 
/* 100 */               DBPlugin.getResourceString("validation.error.oracle.columnNameLength"));
/*    */           }
/*    */         }
/*    */ 
/* 104 */         for (IndexModel index : table.getIndices()) {
/* 105 */           String indexName = index.getIndexName();
/* 106 */           if (indexName.length() > 30)
/* 107 */             errors.addError("ERROR", table, index, 
/* 108 */               DBPlugin.getResourceString("validation.error.oracle.indexNameLength"));
/*    */         }
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.OracleDialect
 * JD-Core Version:    0.6.0
 */