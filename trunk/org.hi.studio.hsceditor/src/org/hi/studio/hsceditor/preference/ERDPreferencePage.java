/*    */ package org.hi.studio.hsceditor.preference;
/*    */ 
/*    */ import org.eclipse.jface.preference.BooleanFieldEditor;
/*    */ import org.eclipse.jface.preference.ComboFieldEditor;
/*    */ import org.eclipse.jface.preference.FieldEditorPreferencePage;
/*    */ import org.eclipse.swt.widgets.Composite;
/*    */ import org.eclipse.ui.IWorkbench;
/*    */ import org.eclipse.ui.IWorkbenchPreferencePage;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class ERDPreferencePage extends FieldEditorPreferencePage
/*    */   implements IWorkbenchPreferencePage
/*    */ {
/* 14 */   private static final String[][] VALIDATION_LEVELS = { 
/* 15 */     { DBPlugin.getResourceString("preference.validation.level.warning"), "WARNING" }, 
/* 16 */     { DBPlugin.getResourceString("preference.validation.level.error"), "ERROR" }, 
/* 17 */     { DBPlugin.getResourceString("preference.validation.level.ignore"), "IGNORE" } };
/*    */ 
/*    */   public ERDPreferencePage()
/*    */   {
/* 21 */     super(1);
/* 22 */     setPreferenceStore(DBPlugin.getDefault().getPreferenceStore());
/*    */   }
/*    */ 
/*    */   public void init(IWorkbench workbench) {
/*    */   }
/*    */ 
/*    */   protected void createFieldEditors() {
/* 29 */     setTitle("AmaterasERD");
/*    */ 
/* 31 */     Composite parent = getFieldEditorParent();
/*    */ 
/* 33 */     addField(
/* 35 */       new BooleanFieldEditor("pref_validate_on_save", 
/* 35 */       DBPlugin.getResourceString("preference.validation"), parent));
/*    */ 
/* 37 */     addField(
/* 39 */       new ComboFieldEditor("pref_validate_physical_table_name_required", 
/* 38 */       DBPlugin.getResourceString("preference.validation.tableName.required"), 
/* 39 */       VALIDATION_LEVELS, parent));
/* 40 */     addField(
/* 42 */       new ComboFieldEditor("pref_validate_physical_table_name_duplicated", 
/* 41 */       DBPlugin.getResourceString("preference.validation.tableName.duplicated"), 
/* 42 */       VALIDATION_LEVELS, parent));
/* 43 */     addField(
/* 45 */       new ComboFieldEditor("pref_validate_on_logical_table_name_required", 
/* 44 */       DBPlugin.getResourceString("preference.validation.logicalTableName.required"), 
/* 45 */       VALIDATION_LEVELS, parent));
/* 46 */     addField(
/* 48 */       new ComboFieldEditor("pref_validate_on_logical_table_name_duplicated", 
/* 47 */       DBPlugin.getResourceString("preference.validation.logicalTableName.duplicated"), 
/* 48 */       VALIDATION_LEVELS, parent));
/*    */ 
/* 50 */     addField(
/* 52 */       new ComboFieldEditor("pref_validate_physical_column_name_required", 
/* 51 */       DBPlugin.getResourceString("preference.validation.columnName.required"), 
/* 52 */       VALIDATION_LEVELS, parent));
/* 53 */     addField(
/* 55 */       new ComboFieldEditor("pref_validate_physical_column_name_duplicatedl", 
/* 54 */       DBPlugin.getResourceString("preference.validation.columnName.duplicated"), 
/* 55 */       VALIDATION_LEVELS, parent));
/* 56 */     addField(
/* 58 */       new ComboFieldEditor("pref_validate_physical_column_name_required", 
/* 57 */       DBPlugin.getResourceString("preference.validation.logicalColumnName.required"), 
/* 58 */       VALIDATION_LEVELS, parent));
/* 59 */     addField(
/* 61 */       new ComboFieldEditor("pref_validate_physical_column_name_duplicated", 
/* 60 */       DBPlugin.getResourceString("preference.validation.logicalColumnName.duplicated"), 
/* 61 */       VALIDATION_LEVELS, parent));
/*    */ 
/* 63 */     addField(
/* 65 */       new ComboFieldEditor("pref_validate_on_columns", 
/* 64 */       DBPlugin.getResourceString("preference.validation.noColumns"), 
/* 65 */       VALIDATION_LEVELS, parent));
/* 66 */     addField(
/* 68 */       new ComboFieldEditor("pref_validate_primary_key", 
/* 67 */       DBPlugin.getResourceString("preference.validation.primaryKey"), 
/* 68 */       VALIDATION_LEVELS, parent));
/*    */ 
/* 70 */     addField(
/* 72 */       new ComboFieldEditor("pref_validate_foreign_key_column_type", 
/* 71 */       DBPlugin.getResourceString("preference.validation.foreignKey.columnType"), 
/* 72 */       VALIDATION_LEVELS, parent));
/* 73 */     addField(
/* 75 */       new ComboFieldEditor("pref_validate_foreign_key_column_size", 
/* 74 */       DBPlugin.getResourceString("preference.validation.foreignKey.columnSize"), 
/* 75 */       VALIDATION_LEVELS, parent));
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.preference.ERDPreferencePage
 * JD-Core Version:    0.6.0
 */