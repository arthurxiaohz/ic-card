/*     */ package org.hi.studio.hsceditor.visual.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.ui.views.properties.IPropertyDescriptor;
/*     */ import org.eclipse.ui.views.properties.IPropertySource;
/*     */ import org.eclipse.ui.views.properties.PropertyDescriptor;
/*     */ import org.eclipse.ui.views.properties.TextPropertyDescriptor;
/*     */ import org.hi.studio.hsceditor.DBPlugin;
/*     */ 
/*     */ public class RootModel extends AbstractDBModel
/*     */   implements IPropertySource
/*     */ {
/*  19 */   private List<AbstractDBEntityModel> children = new ArrayList();
/*  20 */   private List<DommainModel> dommains = new ArrayList();
/*  21 */   private String dialectName = "";
/*  22 */   private boolean logicalMode = false;
/*     */ 
/*  24 */   private String jarFile = "";
/*  25 */   private String jdbcDriver = "";
/*  26 */   private String jdbcUrl = "";
/*  27 */   private String jdbcUser = "";
/*  28 */   private String jdbcPassword = "";
/*  29 */   private String jdbcSchema = "";
/*  30 */   private String jdbcCatalog = "";
/*  31 */   private boolean includeView = false;
/*     */ 
/*  34 */   private String packageName = "";
/*  35 */   private String serviceName = "";
/*  36 */   private String baseData = "";
/*  37 */   private String description = "hi平台";
/*     */   public static final String P_MODE = "p_mode";
/*     */   public static final String P_JDBC_INFO = "p_jdbc_info";
/*     */   public static final String P_CHILDREN = "p_children";
/*     */   public static final String P_DOMMAINS = "p_dommains";
/*     */   public static final String P_PACKAGE_INFO = "p_package_info";
/*     */   public static final String P_ServiceName_INFO = "p_servicename_info";
/*     */   public static final String P_BASEDATA_INFO = "p_basedata_info";
/*     */   public static final String P_DESCRIPTION_INFO = "p_description_info";
/*     */ 
/*     */   public String getJarFile()
/*     */   {
/*  51 */     return this.jarFile;
/*     */   }
/*     */ 
/*     */   public void setJarFile(String jarFile) {
/*  55 */     this.jarFile = jarFile;
/*  56 */     firePropertyChange("p_jdbc_info", null, jarFile);
/*     */   }
/*     */ 
/*     */   public String getJdbcDriver() {
/*  60 */     return this.jdbcDriver;
/*     */   }
/*     */ 
/*     */   public void setJdbcDriver(String jdbcDriver) {
/*  64 */     this.jdbcDriver = jdbcDriver;
/*  65 */     firePropertyChange("p_jdbc_info", null, jdbcDriver);
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl() {
/*  69 */     return this.jdbcUrl;
/*     */   }
/*     */ 
/*     */   public void setJdbcUrl(String jdbcUrl) {
/*  73 */     this.jdbcUrl = jdbcUrl;
/*  74 */     firePropertyChange("p_jdbc_info", null, jdbcUrl);
/*     */   }
/*     */ 
/*     */   public String getJdbcUser() {
/*  78 */     return this.jdbcUser;
/*     */   }
/*     */ 
/*     */   public void setJdbcUser(String jdbcUser) {
/*  82 */     this.jdbcUser = jdbcUser;
/*  83 */     firePropertyChange("p_jdbc_info", null, jdbcUser);
/*     */   }
/*     */ 
/*     */   public String getJdbcPassword() {
/*  87 */     return this.jdbcPassword;
/*     */   }
/*     */ 
/*     */   public void setJdbcPassword(String jdbcPassword) {
/*  91 */     this.jdbcPassword = jdbcPassword;
/*  92 */     firePropertyChange("p_jdbc_info", null, jdbcPassword);
/*     */   }
/*     */ 
/*     */   public String getJdbcSchema() {
/*  96 */     return this.jdbcSchema;
/*     */   }
/*     */ 
/*     */   public void setJdbcSchema(String jdbcSchema) {
/* 100 */     this.jdbcSchema = jdbcSchema;
/* 101 */     firePropertyChange("p_jdbc_info", null, jdbcSchema);
/*     */   }
/*     */ 
/*     */   public String getJdbcCatalog() {
/* 105 */     return this.jdbcCatalog;
/*     */   }
/*     */ 
/*     */   public void setJdbcCatalog(String jdbcCatalog) {
/* 109 */     this.jdbcCatalog = jdbcCatalog;
/* 110 */     firePropertyChange("p_jdbc_info", null, jdbcCatalog);
/*     */   }
/*     */ 
/*     */   public boolean isIncludeView() {
/* 114 */     return this.includeView;
/*     */   }
/*     */ 
/*     */   public void setIncludeView(boolean includeView) {
/* 118 */     this.includeView = includeView;
/* 119 */     firePropertyChange("p_jdbc_info", null, new Boolean(this.jdbcCatalog));
/*     */   }
/*     */ 
/*     */   public void setLogicalMode(boolean logicalMode) {
/* 123 */     this.logicalMode = logicalMode;
/* 124 */     firePropertyChange("p_mode", null, new Boolean(logicalMode));
/*     */   }
/*     */ 
/*     */   public boolean getLogicalMode() {
/* 128 */     return this.logicalMode;
/*     */   }
/*     */ 
/*     */   public void addChild(AbstractDBEntityModel model)
/*     */   {
/* 133 */     if ((model != null) && (!this.children.contains(model)))
/*     */     {
/* 135 */       this.children.add(model);
/* 136 */       firePropertyChange("p_children", null, model);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeChild(AbstractDBEntityModel model) {
/* 141 */     this.children.remove(model);
/* 142 */     firePropertyChange("p_children", model, null);
/*     */   }
/*     */ 
/*     */   public List<AbstractDBEntityModel> getChildren() {
/* 146 */     return this.children;
/*     */   }
/*     */ 
/*     */   public TableModel getTable(String tableName) {
/* 150 */     for (int i = 0; i < this.children.size(); i++) {
/* 151 */       TableModel table = (TableModel)this.children.get(i);
/* 152 */       if (table.getTableName().equals(tableName)) {
/* 153 */         return table;
/*     */       }
/*     */     }
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */   public List<DommainModel> getDommains() {
/* 160 */     if (this.dommains == null) {
/* 161 */       this.dommains = new ArrayList();
/*     */     }
/* 163 */     return this.dommains;
/*     */   }
/*     */ 
/*     */   public void setDommains(List<DommainModel> dommains) {
/* 167 */     this.dommains = dommains;
/* 168 */     for (AbstractDBEntityModel entity : getChildren()) {
/* 169 */       if ((entity instanceof TableModel)) {
/* 170 */         TableModel table = (TableModel)entity;
/* 171 */         for (ColumnModel column : table.getColumns()) {
/* 172 */           if (column.getDommain() != null) {
/* 173 */             for (DommainModel dommain : dommains) {
/* 174 */               if (dommain.getId().equals(column.getDommain().getId())) {
/* 175 */                 column.setDommain(dommain);
/* 176 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 181 */         table.firePropertyChange("p_columns", null, null);
/*     */       }
/*     */     }
/*     */ 
/* 185 */     firePropertyChange("p_dommains", null, dommains);
/*     */   }
/*     */ 
/*     */   public String getDialectName() {
/* 189 */     return this.dialectName;
/*     */   }
/*     */ 
/*     */   public void setDialectName(String dialectName) {
/* 193 */     this.dialectName = dialectName;
/*     */   }
/*     */ 
/*     */   public Object getEditableValue() {
/* 197 */     return this;
/*     */   }
/*     */ 
/*     */   public IPropertyDescriptor[] getPropertyDescriptors() {
/* 201 */     return new IPropertyDescriptor[] { 
/* 205 */       new TextPropertyDescriptor("p_package_info", 
/* 206 */       DBPlugin.getResourceString("property.package")), 
/* 207 */       new PropertyDescriptor("p_servicename_info", 
/* 208 */       DBPlugin.getResourceString("property.servicename")), 
/* 209 */       new TextPropertyDescriptor("p_basedata_info", 
/* 210 */       DBPlugin.getResourceString("property.basedata")), 
/* 211 */       new TextPropertyDescriptor("p_description_info", 
/* 212 */       DBPlugin.getResourceString("property.description")) };
/*     */   }
/*     */ 
/*     */   public Object getPropertyValue(Object id)
/*     */   {
/* 220 */     if (id == "p_package_info") {
/* 221 */       return getPackageName();
/*     */     }
/* 223 */     if (id == "p_servicename_info") {
/* 224 */       return getServiceName();
/*     */     }
/* 226 */     if (id == "p_basedata_info") {
/* 227 */       return getBaseData();
/*     */     }
/* 229 */     if (id == "p_description_info") {
/* 230 */       return getDescription();
/*     */     }
/*     */ 
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isPropertySet(Object id)
/*     */   {
/* 241 */     return (id == "p_package_info") || 
/* 238 */       (id == "p_servicename_info") || 
/* 239 */       (id == "p_basedata_info") || 
/* 240 */       (id == "p_description_info");
/*     */   }
/*     */ 
/*     */   public void resetPropertyValue(Object id)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void setPropertyValue(Object id, Object value)
/*     */   {
/* 254 */     if (id == "p_package_info")
/* 255 */       setPackageName((String)value);
/* 256 */     else if (id == "p_servicename_info")
/* 257 */       setServiceName((String)value);
/* 258 */     else if (id == "p_basedata_info")
/* 259 */       setBaseData((String)value);
/* 260 */     else if (id == "p_description_info")
/* 261 */       setDescription((String)value);
/*     */   }
/*     */ 
/*     */   public String getPackageName()
/*     */   {
/* 267 */     return this.packageName;
/*     */   }
/*     */ 
/*     */   public void setPackageName(String packageName) {
/* 271 */     this.packageName = packageName.toLowerCase();
/* 272 */     firePropertyChange("p_package_info", null, packageName);
/*     */   }
/*     */ 
/*     */   public String getServiceName()
/*     */   {
/* 279 */     return this.serviceName;
/*     */   }
/*     */ 
/*     */   public void setServiceName(String serviceName) {
/* 283 */     this.serviceName = serviceName.toLowerCase();
/* 284 */     firePropertyChange("p_servicename_info", null, serviceName);
/*     */   }
/*     */ 
/*     */   public String getBaseData() {
/* 288 */     return this.baseData;
/*     */   }
/*     */ 
/*     */   public void setBaseData(String baseData) {
/* 292 */     this.baseData = baseData;
/* 293 */     firePropertyChange("p_basedata_info", null, baseData);
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 297 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 301 */     this.description = description;
/* 302 */     firePropertyChange("p_description_info", null, description);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.model.RootModel
 * JD-Core Version:    0.6.0
 */