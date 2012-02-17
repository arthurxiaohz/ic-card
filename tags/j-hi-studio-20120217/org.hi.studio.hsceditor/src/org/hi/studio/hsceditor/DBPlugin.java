/*     */ package org.hi.studio.hsceditor;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.runtime.IConfigurationElement;
/*     */ import org.eclipse.core.runtime.IExtension;
/*     */ import org.eclipse.core.runtime.IExtensionPoint;
/*     */ import org.eclipse.core.runtime.IExtensionRegistry;
/*     */ import org.eclipse.core.runtime.ILog;
/*     */ import org.eclipse.core.runtime.IStatus;
/*     */ import org.eclipse.core.runtime.Platform;
/*     */ import org.eclipse.core.runtime.Status;
/*     */ import org.eclipse.jface.resource.ImageDescriptor;
/*     */ import org.eclipse.jface.resource.ImageRegistry;
/*     */ import org.eclipse.swt.graphics.Color;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.ui.plugin.AbstractUIPlugin;
/*     */ import org.hi.studio.hsceditor.dialect.IDialect;
/*     */ import org.hi.studio.hsceditor.util.ColorRegistry;
/*     */ import org.osgi.framework.BundleContext;
/*     */ 
/*     */ public class DBPlugin extends AbstractUIPlugin
/*     */ {
/*     */   public static final String PREF_VALIDATE_ON_SAVE = "pref_validate_on_save";
/*     */   public static final String PREF_VALIDATE_PHYSICAL_TABLE_NAME_REQUIRED = "pref_validate_physical_table_name_required";
/*     */   public static final String PREF_VALIDATE_PHYSICAL_TABLE_NAME_DUPLICATED = "pref_validate_physical_table_name_duplicated";
/*     */   public static final String PREF_VALIDATE_LOGICAL_TABLE_NAME_REQUIRED = "pref_validate_on_logical_table_name_required";
/*     */   public static final String PREF_VALIDATE_LOGICAL_TABLE_NAME_DUPLICATED = "pref_validate_on_logical_table_name_duplicated";
/*     */   public static final String PREF_VALIDATE_PHYSICAL_COLUMN_NAME_REQUIRED = "pref_validate_physical_column_name_required";
/*     */   public static final String PREF_VALIDATE_PHYSICAL_COLUMN_NAME_DUPLICATED = "pref_validate_physical_column_name_duplicatedl";
/*     */   public static final String PREF_VALIDATE_LOGICAL_COLUMN_NAME_REQUIRED = "pref_validate_physical_column_name_required";
/*     */   public static final String PREF_VALIDATE_LOGICAL_COLUMN_NAME_DUPLICATED = "pref_validate_physical_column_name_duplicated";
/*     */   public static final String PREF_VALIDATE_PRIMARY_KEY = "pref_validate_primary_key";
/*     */   public static final String PREF_VALIDATE_NO_COLUMNS = "pref_validate_on_columns";
/*     */   public static final String PREF_VALIDATE_FOREIGN_KEY_COLUMN_TYPE = "pref_validate_foreign_key_column_type";
/*     */   public static final String PREF_VALIDATE_FOREIGN_KEY_COLUMN_SIZE = "pref_validate_foreign_key_column_size";
/*     */   public static final String LEVEL_ERROR = "ERROR";
/*     */   public static final String LEVEL_WARNING = "WARNING";
/*     */   public static final String LEVEL_IGNORE = "IGNORE";
/*     */   private static DBPlugin plugin;
/*     */   public static final String PLUGIN_ID = "org.hi.studio.hsceditor";
/*  54 */   private Map<String, IDialect> contributedDialects = null;
/*  55 */   private ColorRegistry colorRegistry = new ColorRegistry();
/*     */   public static final String ICON_TABLE = "icons/table.gif";
/*     */   public static final String ICON_COLUMN = "icons/column.gif";
/*     */   public static final String ICON_PK_COLUMN = "icons/pk_column.gif";
/*     */   public static final String ICON_INDEX = "icons/index.gif";
/*     */   public static final String ICON_FOLDER = "icons/folder.gif";
/*     */   public static final String ICON_DOMMAIN = "icons/domain.gif";
/*     */   public static final String ICON_ERROR = "icons/error.gif";
/*     */   public static final String ICON_WARNING = "icons/warning.gif";
/*     */   public static final String ICON_OVERLAY_ERROR = "icons/ovr_error.gif";
/*     */   public static final String ICON_OVERLAY_WARNING = "icons/ovr_warning.gif";
/*     */ 
/*     */   public DBPlugin()
/*     */   {
/*  72 */     plugin = this;
/*     */   }
/*     */ 
/*     */   public static String getResourceString(String key) {
/*  76 */     return Messages.getResourceString(key);
/*     */   }
/*     */ 
/*     */   public void start(BundleContext context)
/*     */     throws Exception
/*     */   {
/*  83 */     super.start(context);
/*     */   }
/*     */ 
/*     */   public static Image getImage(String path)
/*     */   {
/*  99 */     ImageRegistry images = getDefault().getImageRegistry();
/* 100 */     Image image = images.get(path);
/* 101 */     if (image == null) {
/* 102 */       image = getImageDescriptor(path).createImage();
/* 103 */       images.put(path, image);
/*     */     }
/* 105 */     return image;
/*     */   }
/*     */ 
/*     */   public void stop(BundleContext context)
/*     */     throws Exception
/*     */   {
/* 112 */     super.stop(context);
/* 113 */     getImageRegistry().dispose();
/* 114 */     this.colorRegistry.dispose();
/* 115 */     plugin = null;
/*     */   }
/*     */ 
/*     */   public static DBPlugin getDefault()
/*     */   {
/* 122 */     return plugin;
/*     */   }
/*     */ 
/*     */   public Color getColor(RGB rgb) {
/* 126 */     return this.colorRegistry.getColor(rgb);
/*     */   }
/*     */ 
/*     */   public static ImageDescriptor getImageDescriptor(String path)
/*     */   {
/* 137 */     return AbstractUIPlugin.imageDescriptorFromPlugin("org.hi.studio.hsceditor", path);
/*     */   }
/*     */ 
/*     */   public static void logException(Exception ex) {
/* 141 */     IStatus status = new Status(4, "org.hi.studio.hsceditor", 4, "Error", ex);
/* 142 */     getDefault().getLog().log(status);
/* 143 */     ex.printStackTrace();
/*     */   }
/*     */ 
/*     */   public String createMessage(String key, String[] values) {
/* 147 */     String message = getResourceString(key);
/* 148 */     for (int i = 0; i < values.length; i++) {
/* 149 */       message = message.replaceAll("\\{" + i + "\\}", values[i]);
/*     */     }
/* 151 */     return message;
/*     */   }
/*     */ 
/*     */   public Map<String, IDialect> getContributedDialects()
/*     */   {
/* 160 */     if (this.contributedDialects == null) {
/* 161 */       IExtensionRegistry registry = Platform.getExtensionRegistry();
/* 162 */       IExtensionPoint point = registry.getExtensionPoint("org.hi.studio.hsceditor.dialects");
/* 163 */       IExtension[] extensions = point.getExtensions();
/* 164 */       this.contributedDialects = new HashMap();
/*     */ 
/* 166 */       for (int i = 0; i < extensions.length; i++) {
/* 167 */         IConfigurationElement[] elements = extensions[i].getConfigurationElements();
/* 168 */         for (int j = 0; j < elements.length; j++) {
/*     */           try {
/* 170 */             if ("dialect".equals(elements[j].getName())) {
/* 171 */               String name = elements[j].getAttribute("name");
/* 172 */               IDialect dialect = (IDialect)elements[j].createExecutableExtension("class");
/* 173 */               this.contributedDialects.put(name, dialect);
/*     */             }
/*     */           } catch (Exception ex) {
/* 176 */             logException(ex);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 181 */     return this.contributedDialects;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.DBPlugin
 * JD-Core Version:    0.6.0
 */