/*     */ package org.hi.studio.hsceditor.dialect;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.List<Lorg.hi.studio.hsceditor.visual.model.IndexModel;>;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.IndexModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class DefaultSchemaLoader
/*     */   implements ISchemaLoader
/*     */ {
/*     */   public void loadSchema(RootModel root, IDialect dialect, Connection conn, String[] tables, String catalog, String schema)
/*     */     throws SQLException
/*     */   {
/*  35 */     if (tables.length == 0)
/*  36 */       return;
/*     */     List children;
/*     */     TableModel tableModel;
/*     */     ColumnModel[] columns;
/*     */     int k;
/*  38 */     for (int i = 0; i < tables.length; i++) {
/*  39 */       TableModel table = getTableInfo(tables[i], dialect, conn, catalog, schema);
/*     */ 
/*  42 */       children = root.getChildren();
/*  43 */       for (int j = 0; j < children.size(); j++) {
/*  44 */         AbstractDBEntityModel obj = (AbstractDBEntityModel)children.get(j);
/*  45 */         if ((obj instanceof TableModel)) {
/*  46 */           tableModel = (TableModel)obj;
/*  47 */           if (tableModel.getTableName().equals(table.getTableName())) {
/*  48 */             table.setLogicalName(tableModel.getLogicalName());
/*  49 */             table.setDescription(tableModel.getDescription());
/*  50 */             table.setConstraint(tableModel.getConstraint());
/*  51 */             columns = table.getColumns();
/*  52 */             for (k = 0; k < columns.length; k++) {
/*  53 */               ColumnModel columnModel = tableModel.getColumn(columns[k].getColumnName());
/*  54 */               if (columnModel != null) {
/*  55 */                 columns[k].setLogicalName(columnModel.getLogicalName());
/*  56 */                 columns[k].setDescription(columnModel.getDescription());
/*     */               }
/*     */             }
/*  59 */             root.removeChild(tableModel);
/*  60 */             break;
/*     */           }
/*     */         }
/*     */       }
/*  64 */       if (table.getConstraint() == null) {
/*  65 */         table.setConstraint(new Rectangle(10 + i * 50, 10 + i * 50, -1, -1));
/*     */       }
/*  67 */       root.addChild(table);
/*     */     }
/*     */ 
/*  70 */     setForeignKeys(root, conn, catalog, schema);
/*     */ 
/*  73 */     List indexModels = new ArrayList();
/*  74 */     for (AbstractDBEntityModel entity : root.getChildren())
/*  75 */       if ((entity instanceof TableModel)) {
/*  76 */         TableModel table = (TableModel)entity;
/*  77 */         columns = (k = table.getIndices()).length; for (tableModel = 0; tableModel < columns; tableModel++) { IndexModel indexModel = k[tableModel];
/*  78 */           boolean match = true;
/*  79 */           for (AbstractDBConnectionModel fkConn : table.getModelSourceConnections()) {
/*  80 */             if ((fkConn instanceof ForeignKeyModel)) {
/*  81 */               ForeignKeyMapping[] mappings = ((ForeignKeyModel)fkConn).getMapping();
/*  82 */               if (mappings.length == indexModel.getColumns().size()) {
/*  83 */                 for (ForeignKeyMapping mapping : mappings) {
/*  84 */                   if (!indexModel.getColumns().contains(mapping.getTarget().getColumnName())) {
/*  85 */                     match = false;
/*  86 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*  92 */           if (!match) {
/*  93 */             indexModels.add(indexModel);
/*     */           }
/*     */         }
/*  96 */         table.setIndices((IndexModel[])indexModels.toArray(new IndexModel[indexModels.size()]));
/*     */       }
/*     */   }
/*     */ 
/*     */   protected TableModel getTableInfo(String tableName, IDialect dialect, Connection conn, String catalog, String schema)
/*     */     throws SQLException
/*     */   {
/* 103 */     TableModel table = new TableModel();
/* 104 */     table.setTableName(tableName);
/*     */ 
/* 106 */     DatabaseMetaData meta = conn.getMetaData();
/*     */ 
/* 108 */     List list = new ArrayList();
/*     */ 
/* 110 */     Statement stmt = conn.createStatement();
/* 111 */     ResultSet rs = stmt.executeQuery(dialect.getColumnMetadataSQL(tableName));
/* 112 */     ResultSetMetaData rm = rs.getMetaData();
/*     */ 
/* 114 */     ResultSet columns = meta.getColumns(catalog, schema, tableName, "%");
/* 115 */     while (columns.next()) {
/* 116 */       IColumnType type = dialect.getColumnType(columns.getString("TYPE_NAME"));
/* 117 */       if (type == null) {
/* 118 */         type = dialect.getColumnType(columns.getInt("DATA_TYPE"));
/* 119 */         if (type == null) {
/* 120 */           type = dialect.getDefaultColumnType();
/*     */         }
/*     */       }
/*     */ 
/* 124 */       ColumnModel column = new ColumnModel();
/* 125 */       column.setColumnName(columns.getString("COLUMN_NAME"));
/* 126 */       column.setColumnType(type);
/* 127 */       column.setSize(columns.getString("COLUMN_SIZE"));
/* 128 */       column.setNotNull(columns.getString("IS_NULLABLE").equals("NO"));
/*     */ 
/* 131 */       column.setDescription(columns.getString("remarks"));
/*     */ 
/* 133 */       int rmIndex = getResultSetMetaDataIndex(rm, column.getColumnName());
/* 134 */       if (rmIndex > 0) {
/* 135 */         column.setAutoIncrement(rm.isAutoIncrement(rmIndex));
/*     */       }
/*     */ 
/* 138 */       list.add(column);
/*     */     }
/* 140 */     columns.close();
/*     */ 
/* 142 */     ResultSet keys = meta.getPrimaryKeys(catalog, schema, tableName);
/* 143 */     while (keys.next()) {
/* 144 */       String columnName = keys.getString("COLUMN_NAME");
/* 145 */       for (int i = 0; i < list.size(); i++) {
/* 146 */         ColumnModel column = (ColumnModel)list.get(i);
/* 147 */         if (column.getColumnName().equals(columnName)) {
/* 148 */           column.setPrimaryKey(true);
/*     */         }
/*     */       }
/*     */     }
/* 152 */     keys.close();
/*     */ 
/* 154 */     rs.close();
/* 155 */     stmt.close();
/*     */ 
/* 157 */     table.setColumns((ColumnModel[])list.toArray(new ColumnModel[list.size()]));
/*     */ 
/* 159 */     List indices = loadIndexModels(tableName, dialect, conn, catalog, schema, list);
/* 160 */     table.setIndices((IndexModel[])indices.toArray(new IndexModel[indices.size()]));
/*     */ 
/* 162 */     return table;
/*     */   }
/*     */ 
/*     */   protected List<IndexModel> loadIndexModels(String tableName, IDialect dialect, Connection conn, String catalog, String schema, List<ColumnModel> columns)
/*     */     throws SQLException
/*     */   {
/* 168 */     List result = new ArrayList();
/* 169 */     DatabaseMetaData meta = conn.getMetaData();
/*     */ 
/* 171 */     ResultSet rs = meta.getIndexInfo(catalog, schema, tableName, false, true);
/*     */     IndexModel index;
/* 172 */     while (rs.next()) {
/* 173 */       String indexName = rs.getString("INDEX_NAME");
/* 174 */       if (indexName != null) {
/* 175 */         IndexModel indexModel = null;
/* 176 */         for (Iterator localIterator1 = result.iterator(); localIterator1.hasNext(); ) { index = (IndexModel)localIterator1.next();
/* 177 */           if (index.getIndexName().equals(indexName)) {
/* 178 */             indexModel = index;
/* 179 */             break;
/*     */           }
/*     */         }
/* 182 */         if (indexModel == null) {
/* 183 */           indexModel = new IndexModel();
/* 184 */           indexModel.setIndexName(indexName);
/* 185 */           indexModel.setIndexName(rs.getString("INDEX_NAME"));
/* 186 */           if (rs.getBoolean("NON_UNIQUE"))
/* 187 */             indexModel.setIndexType(new IndexType("INDEX"));
/*     */           else {
/* 189 */             indexModel.setIndexType(new IndexType("UNIQUE"));
/*     */           }
/* 191 */           result.add(indexModel);
/*     */         }
/* 193 */         indexModel.getColumns().add(rs.getString("COLUMN_NAME"));
/*     */       }
/*     */     }
/* 196 */     rs.close();
/*     */ 
/* 198 */     List removeIndexModels = new ArrayList();
/* 199 */     for (IndexModel indexModel : result) {
/* 200 */       Object pkColumns = new ArrayList();
/* 201 */       for (ColumnModel columnModel : columns) {
/* 202 */         if (columnModel.isPrimaryKey()) {
/* 203 */           ((List)pkColumns).add(columnModel.getColumnName());
/*     */         }
/*     */       }
/* 206 */       if (indexModel.getColumns().size() == ((List)pkColumns).size()) {
/* 207 */         boolean isNotPk = false;
/* 208 */         for (int i = 0; i < indexModel.getColumns().size(); i++) {
/* 209 */           if (!((String)indexModel.getColumns().get(i)).equals(((List)pkColumns).get(i))) {
/* 210 */             isNotPk = true;
/* 211 */             break;
/*     */           }
/*     */         }
/* 214 */         if (!isNotPk) {
/* 215 */           removeIndexModels.add(indexModel);
/*     */         }
/*     */       }
/*     */     }
/* 219 */     result.removeAll(removeIndexModels);
/*     */ 
/* 221 */     return (List<IndexModel>)result;
/*     */   }
/*     */ 
/*     */   protected int getResultSetMetaDataIndex(ResultSetMetaData rm, String columnName)
/*     */     throws SQLException
/*     */   {
/* 229 */     for (int i = 1; i < rm.getColumnCount(); i++) {
/* 230 */       if (rm.getColumnName(i).equals(columnName)) {
/* 231 */         return i;
/*     */       }
/*     */     }
/* 234 */     return 0;
/*     */   }
/*     */ 
/*     */   protected void setForeignKeys(RootModel root, Connection conn, String catalog, String schema)
/*     */     throws SQLException
/*     */   {
/* 240 */     for (int i = 0; i < root.getChildren().size(); i++) {
/* 241 */       TableModel table = (TableModel)root.getChildren().get(i);
/* 242 */       for (AbstractDBConnectionModel connModel : (AbstractDBConnectionModel[])table.getModelSourceConnections().toArray(
/* 243 */         new AbstractDBConnectionModel[table.getModelSourceConnections().size()]))
/*     */       {
/* 244 */         if ((connModel instanceof ForeignKeyModel)) {
/* 245 */           connModel.detachSource();
/* 246 */           connModel.detachTarget();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 251 */     DatabaseMetaData meta = conn.getMetaData();
/* 252 */     for (int i = 0; i < root.getChildren().size(); i++) {
/* 253 */       TableModel table = (TableModel)root.getChildren().get(i);
/*     */ 
/* 255 */       ResultSet rs = meta.getImportedKeys(catalog, schema, table.getTableName());
/* 256 */       Object map = new HashMap();
/* 257 */       while (rs.next()) {
/* 258 */         String pkTable = rs.getString("PKTABLE_NAME");
/* 259 */         String pkColumn = rs.getString("PKCOLUMN_NAME");
/* 260 */         String fkTable = rs.getString("FKTABLE_NAME");
/* 261 */         String fkColumn = rs.getString("FKCOLUMN_NAME");
/* 262 */         String keyName = rs.getString("FK_NAME");
/*     */ 
/* 264 */         if ((root.getTable(pkTable) != null) && (root.getTable(fkTable) != null)) {
/* 265 */           if (((Map)map).get(keyName) == null) {
/* 266 */             Map entry = new HashMap();
/* 267 */             entry.put("fkTable", fkTable);
/* 268 */             entry.put("pkTable", pkTable);
/* 269 */             entry.put("mappings", new ArrayList());
/* 270 */             ((Map)map).put(keyName, entry);
/*     */           }
/*     */ 
/* 273 */           List mappings = 
/* 274 */             (List)((Map)((Map)map).get(keyName)).get("mappings");
/* 275 */           ForeignKeyMapping mapping = new ForeignKeyMapping();
/* 276 */           mapping.setRefer(root.getTable(fkTable).getColumn(fkColumn));
/* 277 */           mapping.setTarget(root.getTable(pkTable).getColumn(pkColumn));
/* 278 */           mappings.add(mapping);
/*     */         }
/*     */       }
/* 281 */       rs.close();
/*     */ 
/* 283 */       Iterator ite = ((Map)map).entrySet().iterator();
/* 284 */       while (ite.hasNext()) {
/* 285 */         Map.Entry entry = (Map.Entry)ite.next();
/* 286 */         Map entryMap = (Map)entry.getValue();
/*     */ 
/* 289 */         List mappings = 
/* 290 */           (List)entryMap.get("mappings");
/*     */ 
/* 292 */         ForeignKeyModel fkeyModel = new ForeignKeyModel();
/* 293 */         fkeyModel.setForeignKeyName((String)entry.getKey());
/* 294 */         fkeyModel.setMapping((ForeignKeyMapping[])mappings.toArray(new ForeignKeyMapping[mappings.size()]));
/*     */ 
/* 296 */         fkeyModel.setSource(root.getTable((String)entryMap.get("fkTable")));
/* 297 */         fkeyModel.setTarget(root.getTable((String)entryMap.get("pkTable")));
/* 298 */         fkeyModel.attachSource();
/* 299 */         fkeyModel.attachTarget();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.DefaultSchemaLoader
 * JD-Core Version:    0.6.0
 */