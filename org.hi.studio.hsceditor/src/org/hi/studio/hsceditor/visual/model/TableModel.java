/*     */ package org.hi.studio.hsceditor.visual.model;
/*     */ 
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.draw2d.geometry.Rectangle;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.ui.views.properties.ColorPropertyDescriptor;
/*     */ import org.eclipse.ui.views.properties.IPropertyDescriptor;
/*     */ import org.eclipse.ui.views.properties.PropertyDescriptor;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ 
/*     */ public class TableModel extends AbstractDBEntityModel
/*     */   implements ICloneableModel
/*     */ {
/*  18 */   private String error = "";
/*  19 */   private String linkedPath = "";
/*  20 */   private String tableName = "";
/*  21 */   private String logicalName = "";
/*  22 */   private String description = "";
/*     */   private boolean isDeleted;
/*  27 */   private boolean isCreator = true;
/*     */ 
/*  29 */   private ColumnModel[] columns = new ColumnModel[0];
/*  30 */   private IndexModel[] indices = new IndexModel[0];
/*     */   private RGB backgroundColor;
/*  34 */   private String extendServiceName = "";
/*  35 */   private String extendEntityName = "";
/*     */ 
/*  37 */   private String entityBaseData = "";
/*     */   public static final String P_ERROR = "p_error";
/*     */   public static final String P_TABLE_NAME = "p_table_name";
/*     */   public static final String P_ENTITY_BASEDATA_NAME = "p_entity_basedata_name";
/*     */   public static final String P_LOGICAL_NAME = "p_logical_name";
/*     */   public static final String P_COLUMNS = "p_columns";
/*     */   public static final String P_INDICES = "p_indices";
/*     */   public static final String P_CONSTRAINT = "p_constraint";
/*     */   public static final String P_LINKED_PATH = "p_linked_path";
/*     */   public static final String P_BACKGROUND_COLOR = "p_background_color";
/*     */ 
/*     */   public ColumnModel[] getPrimaryKeyColumns()
/*     */   {
/*  52 */     List primaryKeyColumns = new ArrayList();
/*  53 */     for (ColumnModel columnModel : getColumns()) {
/*  54 */       if (columnModel.isPrimaryKey()) {
/*  55 */         primaryKeyColumns.add(columnModel);
/*     */       }
/*     */     }
/*  58 */     return (ColumnModel[])primaryKeyColumns.toArray(new ColumnModel[primaryKeyColumns.size()]);
/*     */   }
/*     */ 
/*     */   public boolean isLinkedTable() {
/*  62 */     return getLinkedPath().length() != 0;
/*     */   }
/*     */ 
/*     */   public String getLinkedPath() {
/*  66 */     if (this.linkedPath == null) {
/*  67 */       this.linkedPath = "";
/*     */     }
/*  69 */     return this.linkedPath;
/*     */   }
/*     */ 
/*     */   public void setLinkedPath(String linkedPath) {
/*  73 */     this.linkedPath = linkedPath;
/*  74 */     firePropertyChange("p_linked_path", null, linkedPath);
/*     */   }
/*     */ 
/*     */   public String getError()
/*     */   {
/*  82 */     if (this.error == null) {
/*  83 */       this.error = "";
/*     */     }
/*  85 */     return this.error;
/*     */   }
/*     */ 
/*     */   public void setError(String error)
/*     */   {
/*  93 */     this.error = error;
/*  94 */     firePropertyChange("p_error", null, error);
/*     */   }
/*     */ 
/*     */   public String getLogicalName() {
/*  98 */     return this.logicalName;
/*     */   }
/*     */ 
/*     */   public void setLogicalName(String logicalName)
/*     */   {
/* 104 */     this.logicalName = StringUtil.upperFirstChar(logicalName);
/* 105 */     firePropertyChange("p_logical_name", null, logicalName);
/*     */   }
/*     */ 
/*     */   public void setTableName(String tableName)
/*     */   {
/* 111 */     this.tableName = StringUtil.upperFirstChar(tableName);
/* 112 */     firePropertyChange("p_table_name", null, tableName);
/*     */   }
/*     */ 
/*     */   public String getTableName() {
/* 116 */     return this.tableName;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 120 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 124 */     if (this.description == null) {
/* 125 */       this.description = "";
/*     */     }
/* 127 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setColumns(ColumnModel[] columns) {
/* 131 */     this.columns = columns;
/* 132 */     firePropertyChange("p_columns", null, columns);
/*     */   }
/*     */ 
/*     */   public ColumnModel[] getColumns() {
/* 136 */     return this.columns;
/*     */   }
/*     */ 
/*     */   public ColumnModel getColumn(String columnName) {
/* 140 */     for (int i = 0; i < this.columns.length; i++) {
/* 141 */       if (this.columns[i].getColumnName().equals(columnName)) {
/* 142 */         return this.columns[i];
/*     */       }
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */   public IndexModel[] getIndices() {
/* 149 */     if (this.indices == null) {
/* 150 */       this.indices = new IndexModel[0];
/*     */     }
/* 152 */     return this.indices;
/*     */   }
/*     */ 
/*     */   public void setIndices(IndexModel[] indices) {
/* 156 */     this.indices = indices;
/* 157 */     firePropertyChange("p_indices", null, indices);
/*     */   }
/*     */ 
/*     */   public IPropertyDescriptor[] getPropertyDescriptors() {
/* 161 */     if (isLinkedTable()) {
/* 162 */       return new IPropertyDescriptor[] { 
/* 163 */         new PropertyDescriptor("p_table_name", DBPlugin.getResourceString("property.tableName")), 
/* 164 */         new PropertyDescriptor("p_linked_path", DBPlugin.getResourceString("property.linkedPath")) };
/*     */     }
/*     */ 
/* 167 */     return new IPropertyDescriptor[] { 
/* 168 */       new PropertyDescriptor("p_entity_basedata_name", "BaseData"), 
/* 169 */       new ColorPropertyDescriptor("p_background_color", DBPlugin.getResourceString("property.backgroundColor")) };
/*     */   }
/*     */ 
/*     */   public Object getPropertyValue(Object id)
/*     */   {
/* 175 */     if (id == "p_entity_basedata_name")
/* 176 */       return getEntityBaseData();
/* 177 */     if (id == "p_linked_path")
/* 178 */       return getLinkedPath();
/* 179 */     if (id == "p_background_color") {
/* 180 */       return getBackgroundColor();
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isPropertySet(Object id)
/*     */   {
/* 187 */     return (id == "p_entity_basedata_name") || (id == "p_background_color");
/*     */   }
/*     */ 
/*     */   public void setPropertyValue(Object id, Object value)
/*     */   {
/* 194 */     if (id == "p_table_name")
/* 195 */       setTableName((String)value);
/* 196 */     else if (id == "p_background_color")
/* 197 */       setBackgroundColor((RGB)value);
/*     */   }
/*     */ 
/*     */   public RGB getBackgroundColor()
/*     */   {
/* 202 */     if (this.backgroundColor == null) {
/* 203 */       this.backgroundColor = new RGB(255, 255, 206);
/*     */     }
/* 205 */     return this.backgroundColor;
/*     */   }
/*     */ 
/*     */   public void setBackgroundColor(RGB backgroundColor) {
/* 209 */     this.backgroundColor = backgroundColor;
/* 210 */     firePropertyChange("p_background_color", null, backgroundColor);
/*     */   }
/*     */ 
/*     */   public ICloneableModel clone() {
/* 214 */     TableModel table = new TableModel();
/* 215 */     table.setTableName(getTableName());
/* 216 */     table.setLogicalName(getLogicalName());
/* 217 */     table.setDescription(getDescription());
/* 218 */     table.setLinkedPath(getLinkedPath());
/* 219 */     table.setConstraint(new Rectangle(getConstraint()));
/* 220 */     table.setBackgroundColor(getBackgroundColor());
/*     */ 
/* 222 */     ColumnModel[] oldColumns = getColumns();
/* 223 */     new ColumnModel[oldColumns.length];
/* 224 */     List columns = new ArrayList();
/* 225 */     for (int i = 0; i < oldColumns.length; i++) {
/* 226 */       if (!oldColumns[i].isParent()) {
/* 227 */         columns.add(oldColumns[i].toNewColumn());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 242 */     table.setColumns((ColumnModel[])columns.toArray(new ColumnModel[columns.size()]));
/*     */ 
/* 246 */     return table;
/*     */   }
/*     */ 
/*     */   public String getExtendServiceName() {
/* 250 */     return this.extendServiceName;
/*     */   }
/*     */ 
/*     */   public void setExtendServiceName(String extendServiceName) {
/* 254 */     this.extendServiceName = extendServiceName;
/*     */   }
/*     */ 
/*     */   public String getExtendEntityName() {
/* 258 */     return this.extendEntityName;
/*     */   }
/*     */ 
/*     */   public void setExtendEntityName(String extendEntityName) {
/* 262 */     this.extendEntityName = extendEntityName;
/*     */   }
/*     */ 
/*     */   public String getEntityBaseData() {
/* 266 */     return this.entityBaseData;
/*     */   }
/*     */ 
/*     */   public void setEntityBaseData(String entityBaseData) {
/* 270 */     this.entityBaseData = entityBaseData;
/*     */   }
/*     */ 
/*     */   public boolean isDeleted()
/*     */   {
/* 275 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setDeleted(boolean isDeleted) {
/* 279 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public boolean isCreator() {
/* 283 */     return this.isCreator;
/*     */   }
/*     */ 
/*     */   public void setCreator(boolean isCreator) {
/* 287 */     this.isCreator = isCreator;
/*     */   }
/*     */ 
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener)
/*     */   {
/* 292 */     super.removePropertyChangeListener(listener);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.TableModel
 * JD-Core Version:    0.6.0
 */