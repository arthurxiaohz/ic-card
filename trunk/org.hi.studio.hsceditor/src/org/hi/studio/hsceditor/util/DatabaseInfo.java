/*     */ package org.hi.studio.hsceditor.util;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.Driver;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ 
/*     */ public class DatabaseInfo
/*     */ {
/*  15 */   private String uri = "";
/*  16 */   private String user = "";
/*  17 */   private String password = "";
/*  18 */   private String catalog = "";
/*  19 */   private String schema = "";
/*  20 */   private Driver driver = null;
/*  21 */   private boolean enableView = false;
/*  22 */   private String productName = null;
/*     */ 
/*  24 */   public final String POSTGRESQL = "PostgreSQL";
/*  25 */   public final String MYSQL = "MySQL";
/*  26 */   public final String HSQLDB = "HSQL Database Engine";
/*  27 */   public final String DERBY = "Apache Derby";
/*     */ 
/*     */   public DatabaseInfo(Class<?> driverClass) throws InstantiationException, IllegalAccessException {
/*  30 */     this.driver = ((Driver)driverClass.newInstance());
/*     */   }
/*     */ 
/*     */   public void setURI(String uri) {
/*  34 */     this.uri = uri;
/*     */   }
/*     */ 
/*     */   public String getURI() {
/*  38 */     return this.uri;
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog) {
/*  42 */     this.catalog = catalog;
/*     */   }
/*     */ 
/*     */   public String getCatalog() {
/*  46 */     return this.catalog;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/*  50 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/*  54 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setSchema(String schema) {
/*  58 */     this.schema = schema;
/*     */   }
/*     */ 
/*     */   public String getSchema() {
/*  62 */     return this.schema;
/*     */   }
/*     */ 
/*     */   public void setUser(String user) {
/*  66 */     this.user = user;
/*     */   }
/*     */ 
/*     */   public String getUser() {
/*  70 */     return this.user;
/*     */   }
/*     */ 
/*     */   public void setEnableView(boolean flag) {
/*  74 */     this.enableView = flag;
/*     */   }
/*     */ 
/*     */   public boolean isEnableView() {
/*  78 */     return this.enableView;
/*     */   }
/*     */ 
/*     */   public Connection connect()
/*     */     throws SQLException
/*     */   {
/*  88 */     Properties p = new Properties();
/*  89 */     p.setProperty("user", this.user);
/*  90 */     p.setProperty("password", this.password);
/*  91 */     return this.driver.connect(this.uri, p);
/*     */   }
/*     */ 
/*     */   public List<String> loadTables() throws SQLException {
/*  95 */     List list = new ArrayList();
/*  96 */     Connection con = null;
/*     */     try
/*     */     {
/*  99 */       con = connect();
/* 100 */       DatabaseMetaData meta = con.getMetaData();
/* 101 */       this.productName = meta.getDatabaseProductName();
/* 102 */       if ((isMSSQL()) && 
/* 103 */         (this.catalog.length() == 0)) {
/* 104 */         this.catalog = "%";
/*     */       }
/*     */ 
/* 108 */       this.catalog = (this.catalog.length() == 0 ? null : this.catalog);
/* 109 */       this.schema = (this.schema.length() == 0 ? null : this.schema);
/* 110 */       ResultSet tables = meta.getTables(this.catalog, this.schema, "%", 
/* 111 */         isOracle() ? new String[] { "TABLE", "VIEW", "SYNONYM" } : null);
/*     */ 
/* 113 */       while (tables.next()) {
/* 114 */         String t = tables.getString("TABLE_TYPE");
/* 115 */         if (("TABLE".equals(t)) || (("VIEW".equals(t)) && (this.enableView)) || ((isOracle()) && ("SYNONYM".equals(t)))) {
/* 116 */           list.add(tables.getString("table_name"));
/*     */         }
/*     */       }
/*     */ 
/* 120 */       tables.close();
/*     */ 
/* 122 */       if ((this.driver.getClass().getName().equals("org.hsqldb.jdbcDriver")) && (this.uri.indexOf("jdbc:hsqldb:hsql://") != 0)) {
/* 123 */         Statement stmt = null;
/*     */         try {
/* 125 */           stmt = con.createStatement();
/*     */ 
/* 128 */           stmt.executeUpdate("SHUTDOWN;");
/*     */         } finally {
/* 130 */           if (stmt != null)
/* 131 */             stmt.close();
/*     */         }
/*     */       }
/*     */     } finally {
/* 135 */       if (con != null) {
/* 136 */         con.close();
/*     */       }
/*     */     }
/* 139 */     return list;
/*     */   }
/*     */ 
/*     */   public String getProductName()
/*     */   {
/* 144 */     return this.productName;
/*     */   }
/*     */ 
/*     */   public boolean isPostgreSQL() {
/* 148 */     return "PostgreSQL".equals(this.productName);
/*     */   }
/*     */ 
/*     */   public boolean isMySQL() {
/* 152 */     return "MySQL".equals(this.productName);
/*     */   }
/*     */ 
/*     */   public boolean isHSQLDB() {
/* 156 */     return "HSQL Database Engine".equals(this.productName);
/*     */   }
/*     */ 
/*     */   public boolean isDerby() {
/* 160 */     return "Apache Derby".equals(this.productName);
/*     */   }
/*     */ 
/*     */   public boolean isMSSQL()
/*     */   {
/* 165 */     return this.productName.toLowerCase().indexOf("microsoft") != -1;
/*     */   }
/*     */ 
/*     */   public boolean isOracle()
/*     */   {
/* 173 */     return this.productName.toLowerCase().indexOf("oracl") != -1;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.DatabaseInfo
 * JD-Core Version:    0.6.0
 */