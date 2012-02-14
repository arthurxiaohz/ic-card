/*     */ package org.hi.studio.hsceditor.dialect;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.validator.DiagramErrors;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public abstract class AbstractDialect
/*     */   implements IDialect
/*     */ {
/*     */   private IColumnType[] types;
/*  19 */   protected IIndexType[] indexTypes = { 
/*  20 */     new IndexType("UNIQUE"), 
/*  21 */     new IndexType("INDEX") };
/*     */ 
/*  24 */   protected final String LS = System.getProperty("line.separator");
/*     */ 
/*     */   public AbstractDialect(IColumnType[] types) {
/*  27 */     this.types = types;
/*     */   }
/*     */ 
/*     */   public IColumnType getColumnType(int sqlType) {
/*  31 */     for (int i = 0; i < this.types.length; i++) {
/*  32 */       if (sqlType == this.types[i].getType()) {
/*  33 */         return this.types[i];
/*     */       }
/*     */     }
/*  36 */     return null;
/*     */   }
/*     */ 
/*     */   public IColumnType getColumnType(String typeName) {
/*  40 */     for (IColumnType type : this.types) {
/*  41 */       if (type.getName().toUpperCase().equals(typeName.toUpperCase())) {
/*  42 */         return type;
/*     */       }
/*     */     }
/*  45 */     return null;
/*     */   }
/*     */ 
/*     */   public IColumnType getDefaultColumnType() {
/*  49 */     IColumnType[] types = getColumnTypes();
/*  50 */     for (int i = 0; i < types.length; i++) {
/*  51 */       if (types[i].getType() == 4) {
/*  52 */         return types[i];
/*     */       }
/*     */     }
/*  55 */     return types[0];
/*     */   }
/*     */ 
/*     */   public IColumnType[] getColumnTypes() {
/*  59 */     return this.types;
/*     */   }
/*     */ 
/*     */   public IIndexType[] getIndexTypes() {
/*  63 */     return this.indexTypes;
/*     */   }
/*     */ 
/*     */   public IIndexType getDefaultIndexType() {
/*  67 */     return getIndexTypes()[0];
/*     */   }
/*     */ 
/*     */   public IIndexType getIndexType(String typeName) {
/*  71 */     for (IIndexType indexType : getIndexTypes()) {
/*  72 */       if (indexType.getName().equals(typeName)) {
/*  73 */         return indexType;
/*     */       }
/*     */     }
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */   public String createDDL(RootModel model, boolean schema, boolean drop, boolean alterTable, boolean comment)
/*     */   {
/*  81 */     List children = TableDependencyCalculator.getSortedTable(model);
/*  82 */     StringBuilder sb = new StringBuilder();
/*  83 */     StringBuilder additions = new StringBuilder();
/*     */     TableModel table;
/*  84 */     for (int i = children.size() - 1; i >= 0; i--) {
/*  85 */       table = (TableModel)children.get(i);
/*  86 */       if ((drop) && (!table.isLinkedTable())) {
/*  87 */         sb.append("DROP TABLE ").append(getTableName(model, table, schema)).append(";").append(this.LS);
/*     */       }
/*     */     }
/*  90 */     if (drop) {
/*  91 */       sb.append(this.LS);
/*     */     }
/*     */ 
/*  94 */     for (TableModel table : children) {
/*  95 */       if (!table.isLinkedTable()) {
/*  96 */         sb.append(createTableDDL(model, table, schema, drop, alterTable, comment, additions));
/*  97 */         sb.append(this.LS);
/*     */       }
/*     */     }
/*     */ 
/* 101 */     if (additions.length() > 0) {
/* 102 */       sb.append(this.LS);
/* 103 */       sb.append(additions.toString());
/*     */     }
/*     */ 
/* 106 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   protected String getTableName(RootModel root, TableModel table, boolean schema) {
/* 110 */     if (!schema) {
/* 111 */       return table.getTableName();
/*     */     }
/* 113 */     return root.getJdbcSchema() + "." + table.getTableName();
/*     */   }
/*     */ 
/*     */   public String createTableDDL(RootModel root, TableModel model, boolean schema, boolean drop, boolean alterTable, boolean comment, StringBuilder additions)
/*     */   {
/* 121 */     int additionsLength = additions.length();
/* 122 */     StringBuffer sb = new StringBuffer();
/*     */ 
/* 124 */     String logicalName = model.getLogicalName();
/*     */ 
/* 126 */     if (comment) {
/* 127 */       sb.append("/**********************************/").append(this.LS);
/* 128 */       sb.append("/* ");
/* 129 */       if ((logicalName != null) && (logicalName.length() > 0)) {
/* 130 */         sb.append(DBPlugin.getResourceString("ddl.tableName")).append(": ");
/* 131 */         sb.append(logicalName);
/*     */       } else {
/* 133 */         sb.append(DBPlugin.getResourceString("ddl.tableName")).append(": ");
/* 134 */         sb.append(getTableName(root, model, schema));
/*     */       }
/* 136 */       sb.append(" */").append(this.LS);
/* 137 */       sb.append("/**********************************/").append(this.LS);
/*     */     }
/*     */ 
/* 140 */     sb.append("CREATE TABLE ").append(getTableName(root, model, schema)).append("(" + this.LS);
/* 141 */     ColumnModel[] columns = model.getColumns();
/* 142 */     for (int i = 0; i < columns.length; i++) {
/* 143 */       if (i != 0) {
/* 144 */         sb.append("," + this.LS);
/*     */       }
/* 146 */       sb.append("  ");
/* 147 */       sb.append(createColumnDDL(root, model, columns[i], schema, alterTable, additions));
/*     */     }
/*     */ 
/* 150 */     ColumnModel[] primaryKeys = model.getPrimaryKeyColumns();
/* 151 */     if ((alterTable) && (primaryKeys.length != 0)) {
/* 152 */       StringBuilder pkBuf = new StringBuilder();
/* 153 */       pkBuf.append("ALTER TABLE ").append(getTableName(root, model, schema));
/* 154 */       pkBuf.append(" ADD PRIMARY KEY (");
/* 155 */       for (int i = 0; i < primaryKeys.length; i++) {
/* 156 */         if (i != 0) {
/* 157 */           pkBuf.append(", ");
/*     */         }
/* 159 */         pkBuf.append(primaryKeys[i].getColumnName());
/*     */       }
/* 161 */       pkBuf.append(");").append(this.LS);
/* 162 */       additions.insert(additionsLength, pkBuf.toString());
/*     */     }
/*     */ 
/* 167 */     if ((!alterTable) && (primaryKeys.length > 1)) {
/* 168 */       sb.append(",").append(this.LS);
/* 169 */       sb.append("  PRIMARY KEY (");
/* 170 */       for (int i = 0; i < primaryKeys.length; i++) {
/* 171 */         if (i != 0) {
/* 172 */           sb.append(", ");
/*     */         }
/* 174 */         sb.append(primaryKeys[i].getColumnName());
/*     */       }
/* 176 */       sb.append(")");
/*     */     }
/*     */ 
/* 182 */     List fkList = model.getModelSourceConnections();
/* 183 */     for (int i = 0; i < fkList.size(); i++) {
/* 184 */       ForeignKeyModel conn = (ForeignKeyModel)fkList.get(i);
/* 185 */       ForeignKeyMapping[] mappings = conn.getMapping();
/*     */       ForeignKeyMapping[] arrayOfForeignKeyMapping1;
/* 187 */       int j = (arrayOfForeignKeyMapping1 = mappings).length; int i = 0;
/*     */       while (true) { ForeignKeyMapping mapping = arrayOfForeignKeyMapping1[i];
/* 188 */         if ((mapping.getRefer() == null) || (mapping.getTarget() == null))
/*     */           break;
/* 187 */         i++; if (i < j)
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 193 */         TableModel target = (TableModel)conn.getTarget();
/*     */ 
/* 195 */         StringBuilder fkBuf = new StringBuilder();
/* 196 */         fkBuf.append("FOREIGN KEY (");
/* 197 */         for (int j = 0; j < mappings.length; j++) {
/* 198 */           if (j != 0) {
/* 199 */             fkBuf.append(",");
/*     */           }
/* 201 */           fkBuf.append(mappings[j].getRefer().getColumnName());
/*     */         }
/* 203 */         fkBuf.append(") REFERENCES ");
/* 204 */         fkBuf.append(getTableName(root, target, schema));
/* 205 */         fkBuf.append(" (");
/* 206 */         for (int j = 0; j < mappings.length; j++) {
/* 207 */           if (j != 0) {
/* 208 */             fkBuf.append(",");
/*     */           }
/* 210 */           fkBuf.append(mappings[j].getTarget().getColumnName());
/*     */         }
/* 212 */         fkBuf.append(")");
/*     */ 
/* 214 */         if (alterTable) {
/* 215 */           String fkName = "FK_" + model.getTableName() + "_" + i;
/* 216 */           additions.append("ALTER TABLE ").append(getTableName(root, model, schema));
/* 217 */           additions.append(" ADD CONSTRAINT ").append(fkName).append(" ");
/* 218 */           additions.append(fkBuf.toString()).append(";");
/* 219 */           additions.append(this.LS);
/*     */         } else {
/* 221 */           sb.append("," + this.LS + "  ");
/* 222 */           sb.append(fkBuf.toString());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 229 */     for (int index = 0; index < model.getIndices().length; index++) {
/* 230 */       IndexModel indexModel = model.getIndices()[index];
/* 231 */       if (indexModel.getIndexType().getName().equals("UNIQUE")) {
/* 232 */         StringBuilder indexBuf = new StringBuilder();
/*     */ 
/* 234 */         indexBuf.append("CONSTRAINT ").append(indexModel.getIndexName()).append(" UNIQUE ");
/* 235 */         indexBuf.append("(");
/* 236 */         for (int i = 0; i < indexModel.getColumns().size(); i++) {
/* 237 */           if (i != 0) {
/* 238 */             indexBuf.append(", ");
/*     */           }
/* 240 */           indexBuf.append((String)indexModel.getColumns().get(i));
/*     */         }
/* 242 */         indexBuf.append(")");
/*     */ 
/* 244 */         if (alterTable) {
/* 245 */           additions.append("ALTER TABLE ").append(getTableName(root, model, schema)).append(" ");
/* 246 */           additions.append("ADD ").append(indexBuf.toString()).append(";");
/* 247 */           additions.append(this.LS);
/*     */         }
/*     */         else {
/* 250 */           sb.append("," + this.LS + "  ");
/* 251 */           sb.append(indexBuf.toString());
/*     */         }
/*     */       } else {
/* 254 */         additions.append("CREATE INDEX ").append(indexModel.getIndexName()).append(" ");
/* 255 */         additions.append("ON ").append(getTableName(root, model, schema)).append(" (");
/* 256 */         for (int i = 0; i < indexModel.getColumns().size(); i++) {
/* 257 */           if (i != 0) {
/* 258 */             additions.append(", ");
/*     */           }
/* 260 */           additions.append((String)indexModel.getColumns().get(i));
/*     */         }
/* 262 */         additions.append(");").append(this.LS);
/*     */       }
/*     */     }
/*     */ 
/* 266 */     sb.append(this.LS);
/* 267 */     sb.append(");" + this.LS);
/*     */ 
/* 269 */     if (additions.length() != additionsLength) {
/* 270 */       additions.append(this.LS);
/*     */     }
/*     */ 
/* 273 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   protected String createColumnDDL(RootModel root, TableModel tableModel, ColumnModel columnModel, boolean schema, boolean alterTable, StringBuilder additions)
/*     */   {
/* 278 */     StringBuffer sb = new StringBuffer();
/* 279 */     sb.append(columnModel.getColumnName());
/* 280 */     sb.append(" ").append(columnModel.getColumnType().getName());
/* 281 */     if (columnModel.getColumnType().supportSize()) {
/* 282 */       sb.append("(").append(columnModel.getSize()).append(")");
/*     */     }
/* 284 */     if (columnModel.isNotNull()) {
/* 285 */       sb.append(" NOT NULL");
/*     */     }
/* 287 */     if (columnModel.getDefaultValue().length() != 0) {
/* 288 */       sb.append(" DEFAULT ").append(columnModel.getDefaultValue());
/*     */     }
/* 290 */     if ((columnModel.isPrimaryKey()) && 
/* 291 */       (!alterTable) && (tableModel.getPrimaryKeyColumns().length == 1)) {
/* 292 */       sb.append(" PRIMARY KEY");
/*     */     }
/*     */ 
/* 295 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public ISchemaLoader getSchemaLoader() {
/* 299 */     return new DefaultSchemaLoader();
/*     */   }
/*     */ 
/*     */   public void validate(DiagramErrors errors, RootModel model) {
/*     */   }
/*     */ 
/*     */   public String getColumnMetadataSQL(String tableName) {
/* 306 */     return "SELECT * FROM \"" + tableName + "\"";
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.AbstractDialect
 * JD-Core Version:    0.6.0
 */