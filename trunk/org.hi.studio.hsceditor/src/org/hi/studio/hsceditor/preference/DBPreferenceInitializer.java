/*    */ package org.hi.studio.hsceditor.preference;
/*    */ 
/*    */ import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
/*    */ import org.eclipse.jface.preference.IPreferenceStore;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class DBPreferenceInitializer extends AbstractPreferenceInitializer
/*    */ {
/*    */   public void initializeDefaultPreferences()
/*    */   {
/* 17 */     IPreferenceStore store = DBPlugin.getDefault().getPreferenceStore();
/* 18 */     store.setDefault("pref_validate_on_save", false);
/* 19 */     store.setDefault("pref_validate_physical_table_name_required", "ERROR");
/* 20 */     store.setDefault("pref_validate_physical_table_name_duplicated", "ERROR");
/* 21 */     store.setDefault("pref_validate_on_logical_table_name_required", "WARNING");
/* 22 */     store.setDefault("pref_validate_on_logical_table_name_duplicated", "WARNING");
/* 23 */     store.setDefault("pref_validate_physical_column_name_required", "ERROR");
/* 24 */     store.setDefault("pref_validate_physical_column_name_duplicatedl", "ERROR");
/* 25 */     store.setDefault("pref_validate_physical_column_name_required", "WARNING");
/* 26 */     store.setDefault("pref_validate_physical_column_name_duplicated", "WARNING");
/* 27 */     store.setDefault("pref_validate_on_columns", "ERROR");
/* 28 */     store.setDefault("pref_validate_primary_key", "WARNING");
/* 29 */     store.setDefault("pref_validate_foreign_key_column_type", "ERROR");
/* 30 */     store.setDefault("pref_validate_foreign_key_column_size", "ERROR");
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.preference.DBPreferenceInitializer
 * JD-Core Version:    0.6.0
 */