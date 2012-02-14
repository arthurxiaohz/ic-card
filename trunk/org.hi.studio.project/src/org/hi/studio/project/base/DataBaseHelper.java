/*    */ package org.hi.studio.project.base;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class DataBaseHelper
/*    */ {
/*  7 */   public static final Map<String, String[]> ormMap = new HashMap();
/*    */   static final String HIBERNATE = "hibernate";
/*    */   static final String IBATIS = "ibatis";
/*    */   static final String IBATIS3 = "ibatis3";
/*    */   static final String SPRINGJDBC = "springJDBC";
/*    */   static final String ORACLE = "ORACLE";
/*    */   static final String MYSQL = "MYSQL";
/*    */   static final String MSSQL = "MSSQL";
/*    */   static final String OTHER = "OTHER";
/*    */   static final String WEBWORK = "webwork";
/*    */   static final String STRUTS = "struts";
/*    */   static final String STRUTS2 = "struts2";
/*    */   static final String CLASSIC_ZH = "经典版";
/*    */   static final String DWZ_ZH = "DWZ版";
/*    */   static final String CLASSIC = "classic";
/*    */   static final String DWZ = "dwz";
/*    */   static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
/*    */   static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
/*    */   static final String DRIVER_MSSQL = "net.sourceforge.jtds.jdbc.Driver";
/*    */   static final String DRIVER_NONE = "";
/*    */   static final String URL_ORACLE = "jdbc:oracle:thin:@localhost:1521:database";
/*    */   static final String URL_MYSQL = "jdbc:mysql://localhost:3306/database?useUnicode=true&characterEncoding=UTF-8";
/*    */   static final String URL_MSSQL = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=database";
/*    */   static final String URL_NONE = "";
/*    */   static final String DIALECT_HIBERNATE_ORACLE = "org.hi.framework.dao.hibernate.HiOracle9iDialect";
/*    */   static final String DIALECT_HIBERNATE_MYSQL = "org.hi.framework.dao.hibernate.HiMySQLDialect";
/*    */   static final String DIALECT_HIBERNATE_MSSQL = "org.hi.framework.dao.hibernate.HiSQLServerDialect";
/*    */   static final String DIALECT_IBATIS_ORACLE = "org.hi.framework.dao.ibatis.HiOracle9iDialect";
/*    */   static final String DIALECT_IBATIS_MYSQL = "org.hi.framework.dao.ibatis.HiMySQLDialect";
/*    */   static final String DIALECT_IBATIS_MSSQL = "org.hi.framework.dao.ibatis.HiSQLServerDialect";
/*    */   static final String DIALECT_SPRINGJDBC_ORACLE = "org.hi.framework.dao.springjdbc.HiOracle9iDialect";
/*    */   static final String DIALECT_SPRINGJDBC_MYSQL = "org.hi.framework.dao.springjdbc.HiMySQLDialect";
/*    */   static final String DIALECT_SPRINGJDBC_MSSQL = "org.hi.framework.dao.springjdbc.HiSQLServerDialect";
/*    */   static final String DIALECT_NONE = "";
/* 59 */   public static final String[] ORMTYPESTR = { "hibernate", "ibatis", "ibatis3", "springJDBC" };
/* 60 */   public static final String[] WEBTYPEVIEWSTR = { "webwork", "struts2" };
/* 61 */   public static final String[] WEBTYPESTR = { "webwork", "struts" };
/* 62 */   public static final String[] PAGETYPEVIEWSTR = { "经典版", "DWZ版" };
/* 63 */   public static final String[] PAGETYPESTR = { "classic", "dwz" };
/*    */ 
/* 65 */   public static final String[] DBTYPESTR = { "ORACLE", "MYSQL", "MSSQL", "OTHER" };
/* 66 */   public static final String[] DRIVERSTR = { "oracle.jdbc.driver.OracleDriver", "com.mysql.jdbc.Driver", "net.sourceforge.jtds.jdbc.Driver", "" };
/* 67 */   public static final String[] TESTSQLSTR = { "select 1 from DUAL", "select 1", "select 1", "" };
/* 68 */   public static final String[] URLSTR = { "jdbc:oracle:thin:@localhost:1521:database", "jdbc:mysql://localhost:3306/database?useUnicode=true&characterEncoding=UTF-8", "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=database", "" };
/*    */ 
/* 71 */   static String[] dialectHibernateStr = { "org.hi.framework.dao.hibernate.HiOracle9iDialect", "org.hi.framework.dao.hibernate.HiMySQLDialect", "org.hi.framework.dao.hibernate.HiSQLServerDialect", "" };
/*    */ 
/* 73 */   static String[] dialectIbatisStr = { "org.hi.framework.dao.ibatis.HiOracle9iDialect", "org.hi.framework.dao.ibatis.HiMySQLDialect", "org.hi.framework.dao.ibatis.HiSQLServerDialect", "" };
/*    */ 
/* 75 */   static String[] dialectSpringJDBCStr = { "org.hi.framework.dao.springjdbc.HiOracle9iDialect", "org.hi.framework.dao.springjdbc.HiMySQLDialect", "org.hi.framework.dao.springjdbc.HiSQLServerDialect", "" };
/*    */ 
/* 77 */   static { ormMap.put("hibernate", dialectHibernateStr);
/* 78 */     ormMap.put("ibatis", dialectIbatisStr);
/* 79 */     ormMap.put("ibatis3", dialectIbatisStr);
/* 80 */     ormMap.put("springJDBC", dialectSpringJDBCStr);
/*    */   }
/*    */ 
/*    */   public static String[] getDialect(String ormType)
/*    */   {
/* 85 */     return (String[])ormMap.get(ormType);
/*    */   }
/*    */ 
/*    */   public static String getDefaultDialect() {
/* 89 */     return dialectHibernateStr[0];
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.base.DataBaseHelper
 * JD-Core Version:    0.6.0
 */