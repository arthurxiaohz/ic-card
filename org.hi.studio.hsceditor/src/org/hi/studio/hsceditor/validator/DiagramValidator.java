/*     */ package org.hi.studio.hsceditor.validator;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.eclipse.jface.preference.IPreferenceStore;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.DialectProvider;
/*     */ import org.hi.studio.hsceditor.util.FilterUtil;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.ColumnModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationModel;
/*     */ import org.hi.studio.hsceditor.visual.model.EnumerationValueModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class DiagramValidator
/*     */ {
/*     */   private RootModel model;
/*  29 */   private Set<String> tableNames = new HashSet();
/*  30 */   private Set<String> logicalNames = new HashSet();
/*  31 */   private Set<String> enumerationNames = new HashSet();
/*     */ 
/*     */   public DiagramValidator(RootModel model)
/*     */   {
/*  38 */     this.model = model;
/*     */   }
/*     */ 
/*     */   public DiagramErrors doValidate()
/*     */   {
/*  47 */     DiagramErrors errors = new DiagramErrors();
/*     */ 
/*  50 */     for (AbstractDBEntityModel entity : this.model.getChildren()) {
/*  51 */       if ((entity instanceof TableModel)) {
/*  52 */         TableModel table = (TableModel)entity;
/*  53 */         table.setError("");
/*     */ 
/*  55 */         if ((table instanceof EnumerationModel))
/*  56 */           validateEnumeration(errors, this.model, (EnumerationModel)table);
/*     */         else {
/*  58 */           validateTable(errors, this.model, table);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  64 */     String dialectName = this.model.getDialectName();
/*  65 */     DialectProvider.getDialect(dialectName);
/*     */ 
/*  68 */     return errors;
/*     */   }
/*     */ 
/*     */   private void validateEnumeration(DiagramErrors errors, RootModel root, EnumerationModel table)
/*     */   {
/*  76 */     IPreferenceStore store = DBPlugin.getDefault().getPreferenceStore();
/*  77 */     String enumName = table.getEnumName();
/*  78 */     String enumDesc = table.getEnumDesc();
/*     */ 
/*  80 */     if ((enumName == null) || (enumName.equals("")) || (FilterUtil.validate(enumName))) {
/*  81 */       errors.addError("ERROR", 
/*  82 */         table, enumName + "为系统保留关键字或者非法字符，枚举名称有误");
/*     */     }
/*  84 */     if ((enumDesc == null) || (enumDesc.equals(""))) {
/*  85 */       errors.addError("ERROR", 
/*  86 */         table, "描述为空，枚举有误");
/*     */     }
/*  88 */     if (this.enumerationNames.contains(enumName))
/*  89 */       errors.addError(store.getString("pref_validate_physical_table_name_required"), 
/*  90 */         table, "枚举名重名");
/*     */     else {
/*  92 */       this.enumerationNames.add(enumName);
/*     */     }
/*     */ 
/*  96 */     ColumnModel[] columns = table.getColumns();
/*  97 */     if (columns.length == 0) {
/*  98 */       errors.addError(store.getString("pref_validate_on_columns"), 
/*  99 */         table, DBPlugin.getResourceString("validation.error.noColumns"));
/*     */     } else {
/* 101 */       new HashSet();
/* 102 */       new HashSet();
/* 103 */       for (ColumnModel column : columns)
/* 104 */         if ((column instanceof EnumerationValueModel)) {
/* 105 */           String value = ((EnumerationValueModel)column).getEnumValue();
/* 106 */           String desc = ((EnumerationValueModel)column).getEnumValue();
/* 107 */           ((EnumerationValueModel)column).getEnumCode();
/* 108 */           if ((desc == null) || (desc.equals("")) || 
/* 109 */             (value == null) || (value.equals(""))) {
/* 110 */             errors.addError("ERROR", 
/* 111 */               table, "枚举值有空值");
/*     */           }
/*     */ 
/* 114 */           if (FilterUtil.validate(value))
/* 115 */             errors.addError("ERROR", 
/* 116 */               table, value + "为关键字，枚举值有误");
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void validateTable(DiagramErrors errors, RootModel root, TableModel table)
/*     */   {
/* 129 */     IPreferenceStore store = DBPlugin.getDefault().getPreferenceStore();
/*     */ 
/* 132 */     String tableName = table.getTableName();
/* 133 */     if ((tableName == null) || (tableName.length() == 0)) {
/* 134 */       errors.addError(store.getString("pref_validate_physical_table_name_required"), 
/* 135 */         table, DBPlugin.getResourceString("validation.error.tableName.required"));
/*     */     }
/* 137 */     else if (this.tableNames.contains(tableName))
/* 138 */       errors.addError(store.getString("pref_validate_physical_table_name_duplicated"), 
/* 139 */         table, DBPlugin.getResourceString("validation.error.tableName.duplicated"));
/*     */     else {
/* 141 */       this.tableNames.add(tableName);
/*     */     }
/*     */ 
/* 144 */     String logicalName = table.getLogicalName();
/* 145 */     if ((logicalName == null) || (logicalName.length() == 0)) {
/* 146 */       errors.addError(store.getString("pref_validate_on_logical_table_name_required"), 
/* 147 */         table, DBPlugin.getResourceString("validation.error.logicalTableName.required"));
/*     */     }
/* 149 */     else if (this.logicalNames.contains(logicalName))
/* 150 */       errors.addError(store.getString("pref_validate_on_logical_table_name_duplicated"), 
/* 151 */         table, DBPlugin.getResourceString("validation.error.logicalTableName.duplicated"));
/*     */     else {
/* 153 */       this.logicalNames.add(logicalName);
/*     */     }
/*     */ 
/* 157 */     if (FilterUtil.validate(tableName)) {
/* 158 */       errors.addError("ERROR", 
/* 159 */         table, logicalName + "为系统保留关键字或者非法字符，表名称有误");
/*     */     }
/* 161 */     if (FilterUtil.validate(logicalName)) {
/* 162 */       errors.addError("ERROR", 
/* 163 */         table, logicalName + "为系统保留关键字或者非法字符，实体名称有误");
/*     */     }
/*     */ 
/* 167 */     ColumnModel[] columns = table.getColumns();
/* 168 */     if (columns.length == 0) {
/* 169 */       errors.addError(store.getString("pref_validate_on_columns"), 
/* 170 */         table, DBPlugin.getResourceString("validation.error.noColumns"));
/*     */     } else {
/* 172 */       Set columnNames = new HashSet();
/* 173 */       new HashSet();
/* 174 */       boolean findPk = false;
/* 175 */       for (ColumnModel column : columns) {
/* 176 */         if (column.isPrimaryKey()) {
/* 177 */           findPk = true;
/*     */         }
/* 179 */         String columnName = column.getColumnName();
/* 180 */         if ((columnName == null) || (columnName.length() == 0)) {
/* 181 */           errors.addError(store.getString("pref_validate_physical_column_name_required"), 
/* 182 */             table, column, DBPlugin.getResourceString("validation.error.columnName.required"));
/*     */         }
/* 184 */         else if (columnNames.contains(columnName))
/* 185 */           errors.addError(store.getString("pref_validate_physical_column_name_duplicatedl"), 
/* 186 */             table, column, DBPlugin.getResourceString("validation.error.columnName.duplicated"));
/*     */         else {
/* 188 */           columnNames.add(columnName);
/*     */         }
/*     */ 
/* 191 */         if ((!columnName.equals("id")) && (FilterUtil.validate(columnName))) {
/* 192 */           errors.addError("ERROR", 
/* 193 */             table, columnName + "为关键字，属性名称有误");
/*     */         }
/* 195 */         int type = column.getHiDataType();
/* 196 */         if (((type != 6) && (type != 7)) || (
/* 197 */           (column.getLkEntityName() != null) && (!column.getLkEntityName().equals(""))))
/*     */           continue;
/* 199 */         errors.addError("ERROR", 
/* 200 */           table, columnName + "带回项或者带回枚举项不能为空");
/*     */       }
/*     */ 
/* 217 */       if (!findPk)
/* 218 */         errors.addError(store.getString("pref_validate_primary_key"), 
/* 219 */           table, DBPlugin.getResourceString("validation.error.noPrimaryKey"));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.validator.DiagramValidator
 * JD-Core Version:    0.6.0
 */