/*     */ package org.hi.studio.hsceditor.visual.generate;
/*     */ 
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.FileDialog;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*     */ import org.hi.studio.hsceditor.util.IOUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBConnectionModel;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyMapping;
/*     */ import org.hi.studio.hsceditor.visual.model.ForeignKeyModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ import org.seasar.fisshplate.template.FPTemplate;
/*     */ 
/*     */ public class ExcelGenerator
/*     */   implements IGenerator
/*     */ {
/*     */   public void execute(IFile erdFile, RootModel root)
/*     */   {
/* 134 */     FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), 8192);
/* 135 */     dialog.setFilterExtensions(new String[] { "*.xls" });
/* 136 */     String path = dialog.open();
/* 137 */     if (path == null) {
/* 138 */       return;
/*     */     }
/*     */ 
/* 141 */     List tables = new ArrayList();
/*     */ 
/* 143 */     for (AbstractDBEntityModel entity : root.getChildren()) {
/* 144 */       if ((entity instanceof TableModel)) {
/* 145 */         TableModel table = (TableModel)entity;
/* 146 */         TableData tableData = new TableData();
/* 147 */         tableData.setLogicalTableName(table.getLogicalName());
/* 148 */         tableData.setPhysicalTableName(table.getTableName());
/* 149 */         tableData.setDescription(table.getDescription());
/*     */ 
/* 151 */         List columns = new ArrayList();
/* 152 */         for (ColumnModel column : table.getColumns()) {
/* 153 */           ColumnData columnData = new ColumnData();
/* 154 */           columnData.setLogicalColumnName(column.getLogicalName());
/* 155 */           columnData.setPhysicalColumnName(column.getColumnName());
/* 156 */           columnData.setDescription(column.getDescription());
/* 157 */           columnData.setType(column.getColumnType().getName());
/* 158 */           if (column.getColumnType().supportSize()) {
/* 159 */             columnData.setSize(column.getSize());
/*     */           }
/* 161 */           if (column.isPrimaryKey()) {
/* 162 */             columnData.setPrimaryKey("仜");
/*     */           }
/* 164 */           if (column.isNotNull()) {
/* 165 */             columnData.setNullable("亊");
/*     */           }
/*     */ 
/* 168 */           for (AbstractDBConnectionModel conn : table.getModelSourceConnections()) {
/* 169 */             if ((conn instanceof ForeignKeyModel)) {
/* 170 */               ForeignKeyModel foreignKey = (ForeignKeyModel)conn;
/* 171 */               ForeignKeyMapping[] mappings = foreignKey.getMapping();
/* 172 */               for (ForeignKeyMapping mapping : mappings) {
/* 173 */                 if (mapping.getRefer() == column) {
/* 174 */                   columnData.setForeignKey("仜");
/* 175 */                   columnData.setReference(
/* 176 */                     ((TableModel)foreignKey.getTarget()).getTableName() + 
/* 177 */                     "." + mapping.getTarget().getColumnName());
/* 178 */                   break;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/* 184 */           columnData.setIndex(columns.size() + 1);
/* 185 */           columns.add(columnData);
/*     */         }
/* 187 */         tableData.setColumns(columns);
/* 188 */         tables.add(tableData);
/*     */       }
/*     */     }
/*     */ 
/* 192 */     Map data = new HashMap();
/* 193 */     data.put("tables", tables);
/*     */ 
/* 195 */     InputStream in = getClass().getResourceAsStream("template.xls");
/* 196 */     FPTemplate template = new FPTemplate();
/*     */     try {
/* 198 */       HSSFWorkbook wb = template.process(in, data);
/*     */ 
/* 200 */       FileOutputStream fos = new FileOutputStream(path);
/* 201 */       wb.write(fos);
/* 202 */       IOUtils.close(fos);
/*     */     }
/*     */     catch (Exception ex) {
/* 205 */       DBPlugin.logException(ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getGeneratorName() {
/* 210 */     return "Excel";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 214 */     new ExcelGenerator().execute(null, null);
/*     */   }
/*     */ 
/*     */   public static class ColumnData
/*     */   {
/*     */     private int index;
/*  61 */     private String logicalColumnName = "";
/*  62 */     private String physicalColumnName = "";
/*  63 */     private String primaryKey = "";
/*  64 */     private String foreignKey = "";
/*  65 */     private String type = "";
/*  66 */     private String size = "";
/*  67 */     private String reference = "";
/*  68 */     private String description = "";
/*  69 */     private String nullable = "";
/*     */ 
/*     */     public String getNullable() {
/*  72 */       return this.nullable;
/*     */     }
/*     */     public void setNullable(String nullable) {
/*  75 */       this.nullable = nullable;
/*     */     }
/*     */     public String getLogicalColumnName() {
/*  78 */       return this.logicalColumnName;
/*     */     }
/*     */     public void setLogicalColumnName(String logicalColumnName) {
/*  81 */       this.logicalColumnName = logicalColumnName;
/*     */     }
/*     */     public String getPhysicalColumnName() {
/*  84 */       return this.physicalColumnName;
/*     */     }
/*     */     public void setPhysicalColumnName(String physicalColumnName) {
/*  87 */       this.physicalColumnName = physicalColumnName;
/*     */     }
/*     */     public String getPrimaryKey() {
/*  90 */       return this.primaryKey;
/*     */     }
/*     */     public void setPrimaryKey(String primaryKey) {
/*  93 */       this.primaryKey = primaryKey;
/*     */     }
/*     */     public String getForeignKey() {
/*  96 */       return this.foreignKey;
/*     */     }
/*     */     public void setForeignKey(String foreignKey) {
/*  99 */       this.foreignKey = foreignKey;
/*     */     }
/*     */     public String getType() {
/* 102 */       return this.type;
/*     */     }
/*     */     public void setType(String type) {
/* 105 */       this.type = type;
/*     */     }
/*     */     public String getSize() {
/* 108 */       return this.size;
/*     */     }
/*     */     public void setSize(String size) {
/* 111 */       this.size = size;
/*     */     }
/*     */     public String getReference() {
/* 114 */       return this.reference;
/*     */     }
/*     */     public void setReference(String reference) {
/* 117 */       this.reference = reference;
/*     */     }
/*     */     public String getDescription() {
/* 120 */       return this.description;
/*     */     }
/*     */     public void setDescription(String description) {
/* 123 */       this.description = description;
/*     */     }
/*     */     public int getIndex() {
/* 126 */       return this.index;
/*     */     }
/*     */     public void setIndex(int index) {
/* 129 */       this.index = index;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class TableData
/*     */   {
/*  29 */     private String logicalTableName = "";
/*  30 */     private String physicalTableName = "";
/*     */     private String description;
/*  32 */     private List<ExcelGenerator.ColumnData> columns = new ArrayList();
/*     */ 
/*  34 */     public String getLogicalTableName() { return this.logicalTableName; }
/*     */ 
/*     */     public void setLogicalTableName(String logicalTableName) {
/*  37 */       this.logicalTableName = logicalTableName;
/*     */     }
/*     */     public String getPhysicalTableName() {
/*  40 */       return this.physicalTableName;
/*     */     }
/*     */     public void setPhysicalTableName(String physicalTableName) {
/*  43 */       this.physicalTableName = physicalTableName;
/*     */     }
/*     */     public String getDescription() {
/*  46 */       return this.description;
/*     */     }
/*     */     public void setDescription(String description) {
/*  49 */       this.description = description;
/*     */     }
/*     */     public List<ExcelGenerator.ColumnData> getColumns() {
/*  52 */       return this.columns;
/*     */     }
/*     */     public void setColumns(List<ExcelGenerator.ColumnData> columns) {
/*  55 */       this.columns = columns;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.ExcelGenerator
 * JD-Core Version:    0.6.0
 */