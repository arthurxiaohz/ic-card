/*     */ package org.hi.studio.hsceditor.visual.model;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import org.hi.studio.core.utils.StringUtil;
/*     */ import org.hi.studio.hsceditor.dialect.IColumnType;
/*     */ 
/*     */ public class ColumnModel
/*     */   implements Serializable
/*     */ {
/*  11 */   private String columnName = "";
/*  12 */   private String logicalName = "";
/*  13 */   private IColumnType columnType = null;
/*     */ 
/*  15 */   private String size = "";
/*  16 */   private String scale = "";
/*     */ 
/*  18 */   private boolean notNull = false;
/*  19 */   private boolean primaryKey = false;
/*  20 */   private String description = "";
/*  21 */   private boolean autoIncrement = false;
/*  22 */   private String defaultValue = "";
/*  23 */   private DommainModel dommain = null;
/*     */ 
/*  25 */   private String mainEntityName = "";
/*     */ 
/*  27 */   private String hiValidator = "";
/*     */ 
/*  30 */   private String lkServiceName = "";
/*  31 */   private String lkEntityName = "";
/*  32 */   private String lkFieldName = "";
/*     */ 
/*  35 */   private boolean isLkForeignKey = false;
/*     */   private int hiDataType;
/*  38 */   private boolean isSearch = false;
/*  39 */   private boolean isListDisplay = true;
/*     */ 
/*  41 */   private boolean isReadOnly = false;
/*  42 */   private boolean isHidden = false;
/*  43 */   private boolean isFull = false;
/*  44 */   private boolean isMainLookup = false;
/*  45 */   private boolean isParent = false;
/*     */ 
/*     */   public boolean isReadOnly() {
/*  48 */     return this.isReadOnly;
/*     */   }
/*     */ 
/*     */   public void setReadOnly(boolean isReadOnly) {
/*  52 */     this.isReadOnly = isReadOnly;
/*     */   }
/*     */ 
/*     */   public boolean isHidden() {
/*  56 */     return this.isHidden;
/*     */   }
/*     */ 
/*     */   public void setHidden(boolean isHidden) {
/*  60 */     this.isHidden = isHidden;
/*     */   }
/*     */ 
/*     */   public boolean isFull() {
/*  64 */     return this.isFull;
/*     */   }
/*     */ 
/*     */   public void setFull(boolean isFull) {
/*  68 */     this.isFull = isFull;
/*     */   }
/*     */ 
/*     */   public boolean isMainLookup() {
/*  72 */     return this.isMainLookup;
/*     */   }
/*     */ 
/*     */   public void setMainLookup(boolean isMainLookup) {
/*  76 */     this.isMainLookup = isMainLookup;
/*     */   }
/*     */ 
/*     */   public boolean isParent() {
/*  80 */     return this.isParent;
/*     */   }
/*     */ 
/*     */   public void setParent(boolean isParent) {
/*  84 */     this.isParent = isParent;
/*     */   }
/*     */ 
/*     */   public boolean isListDisplay() {
/*  88 */     return this.isListDisplay;
/*     */   }
/*     */ 
/*     */   public void setListDisplay(boolean isListDisplay) {
/*  92 */     this.isListDisplay = isListDisplay;
/*     */   }
/*     */ 
/*     */   public boolean isLkForeignKey() {
/*  96 */     return this.isLkForeignKey;
/*     */   }
/*     */ 
/*     */   public void setLkForeignKey(boolean isLkForeignKey) {
/* 100 */     this.isLkForeignKey = isLkForeignKey;
/*     */   }
/*     */ 
/*     */   public boolean isSearch() {
/* 104 */     return this.isSearch;
/*     */   }
/*     */ 
/*     */   public void setSearch(boolean isSearch) {
/* 108 */     this.isSearch = isSearch;
/*     */   }
/*     */ 
/*     */   public int getHiDataType() {
/* 112 */     return this.hiDataType;
/*     */   }
/*     */ 
/*     */   public void setHiDataType(int hiDataType) {
/* 116 */     this.hiDataType = hiDataType;
/*     */   }
/*     */ 
/*     */   public String getLogicalName() {
/* 120 */     return this.logicalName;
/*     */   }
/*     */ 
/*     */   public void setLogicalName(String logicalName)
/*     */   {
/* 125 */     this.logicalName = StringUtil.lowerFirstChar(logicalName);
/*     */   }
/*     */ 
/*     */   public String getColumnName() {
/* 129 */     return this.columnName;
/*     */   }
/*     */ 
/*     */   public void setColumnName(String columnName)
/*     */   {
/* 135 */     this.columnName = StringUtil.lowerFirstChar(columnName);
/*     */   }
/*     */ 
/*     */   public IColumnType getColumnType() {
/* 139 */     if (this.dommain != null) {
/* 140 */       return this.dommain.getType();
/*     */     }
/* 142 */     return this.columnType;
/*     */   }
/*     */ 
/*     */   public void setColumnType(IColumnType columnType) {
/* 146 */     this.columnType = columnType;
/*     */   }
/*     */ 
/*     */   public boolean isNotNull() {
/* 150 */     return this.notNull;
/*     */   }
/*     */ 
/*     */   public void setNotNull(boolean notNull) {
/* 154 */     this.notNull = notNull;
/*     */   }
/*     */ 
/*     */   public boolean isPrimaryKey() {
/* 158 */     return this.primaryKey;
/*     */   }
/*     */ 
/*     */   public void setPrimaryKey(boolean primaryKey) {
/* 162 */     this.primaryKey = primaryKey;
/*     */   }
/*     */ 
/*     */   public String getSize()
/*     */   {
/* 169 */     if (this.size == null) {
/* 170 */       return "";
/*     */     }
/*     */ 
/* 173 */     return this.size;
/*     */   }
/*     */ 
/*     */   public void setSize(String size) {
/* 177 */     this.size = size;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 181 */     if (this.description == null) {
/* 182 */       this.description = "";
/*     */     }
/* 184 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 188 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public boolean isAutoIncrement() {
/* 192 */     return this.autoIncrement;
/*     */   }
/*     */ 
/*     */   public void setAutoIncrement(boolean autoIncrement) {
/* 196 */     this.autoIncrement = autoIncrement;
/*     */   }
/*     */ 
/*     */   public String getDefaultValue() {
/* 200 */     if (this.defaultValue == null) {
/* 201 */       this.defaultValue = "";
/*     */     }
/* 203 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String defaultValue) {
/* 207 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ 
/*     */   public DommainModel getDommain() {
/* 211 */     return this.dommain;
/*     */   }
/*     */ 
/*     */   public void setDommain(DommainModel dommain) {
/* 215 */     this.dommain = dommain;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 219 */     return getColumnName();
/*     */   }
/*     */ 
/*     */   public String getLkServiceName() {
/* 223 */     return this.lkServiceName;
/*     */   }
/*     */ 
/*     */   public void setLkServiceName(String lkServiceName) {
/* 227 */     this.lkServiceName = lkServiceName;
/*     */   }
/*     */ 
/*     */   public String getLkEntityName() {
/* 231 */     return this.lkEntityName;
/*     */   }
/*     */ 
/*     */   public void setLkEntityName(String lkEntityName) {
/* 235 */     this.lkEntityName = lkEntityName;
/*     */   }
/*     */ 
/*     */   public String getLkFieldName() {
/* 239 */     return this.lkFieldName;
/*     */   }
/*     */ 
/*     */   public void setLkFieldName(String lkFieldName) {
/* 243 */     this.lkFieldName = lkFieldName;
/*     */   }
/*     */ 
/*     */   public String getMainEntityName() {
/* 247 */     System.out.println("mainEntityName:" + this.mainEntityName);
/* 248 */     return this.mainEntityName;
/*     */   }
/*     */ 
/*     */   public void setMainEntityName(String mainEntityName) {
/* 252 */     this.mainEntityName = mainEntityName;
/*     */   }
/*     */ 
/*     */   public ColumnModel toNewColumn() {
/* 256 */     ColumnModel newModel = new ColumnModel();
/*     */ 
/* 260 */     newModel.setColumnName(getColumnName());
/* 261 */     newModel.setLogicalName(getLogicalName());
/* 262 */     newModel.setDescription(getDescription());
/* 263 */     newModel.setDefaultValue(getDefaultValue());
/*     */ 
/* 265 */     newModel.setNotNull(isNotNull());
/* 266 */     newModel.setPrimaryKey(isPrimaryKey());
/* 267 */     newModel.setDommain(getDommain());
/* 268 */     newModel.setSize(getSize());
/*     */ 
/* 270 */     newModel.setScale(getScale());
/*     */ 
/* 272 */     newModel.setLkServiceName(this.lkServiceName);
/* 273 */     newModel.setLkEntityName(this.lkEntityName);
/* 274 */     newModel.setLkFieldName(this.lkFieldName);
/* 275 */     newModel.setLkForeignKey(this.isLkForeignKey);
/*     */ 
/* 277 */     newModel.setMainEntityName(this.mainEntityName);
/*     */ 
/* 279 */     newModel.setHiDataType(this.hiDataType);
/* 280 */     newModel.setSearch(this.isSearch);
/* 281 */     newModel.setListDisplay(this.isListDisplay);
/* 282 */     newModel.setReadOnly(this.isReadOnly);
/* 283 */     newModel.setHidden(this.isHidden);
/* 284 */     newModel.setFull(this.isFull);
/* 285 */     newModel.setMainLookup(this.isMainLookup);
/* 286 */     newModel.setParent(this.isParent);
/*     */ 
/* 288 */     newModel.setHiValidator(this.hiValidator);
/*     */ 
/* 290 */     return newModel;
/*     */   }
/*     */ 
/*     */   public String getScale() {
/* 294 */     if (this.scale == null) {
/* 295 */       return "";
/*     */     }
/*     */ 
/* 298 */     return this.scale;
/*     */   }
/*     */ 
/*     */   public void setScale(String scale) {
/* 302 */     this.scale = scale;
/*     */   }
/*     */ 
/*     */   public String getHiValidator()
/*     */   {
/* 307 */     return this.hiValidator;
/*     */   }
/*     */ 
/*     */   public void setHiValidator(String hiValidator) {
/* 311 */     this.hiValidator = hiValidator;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.ColumnModel
 * JD-Core Version:    0.6.0
 */