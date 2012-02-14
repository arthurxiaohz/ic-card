/*    */ package org.hi.studio.generator.db;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DatabaseMetaData;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ public class DbTest
/*    */ {
/*    */   public static boolean supportBatch(Connection con)
/*    */   {
/*    */     try
/*    */     {
/* 18 */       DatabaseMetaData md = con.getMetaData();
/* 19 */       return md.supportsBatchUpdates();
/*    */     }
/*    */     catch (SQLException e)
/*    */     {
/* 23 */       e.printStackTrace();
/*    */     }
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   public static int[] goBatch(Connection con, String[] sqls)
/*    */   {
/* 30 */     if (sqls == null)
/*    */     {
/* 32 */       return null;
/*    */     }
/* 34 */     Statement sm = null;
/*    */     try
/*    */     {
/* 37 */       sm = con.createStatement();
/* 38 */       for (int i = 0; i < sqls.length; i++)
/*    */       {
/* 40 */         sm.addBatch(sqls[i]);
/*    */       }
/*    */ 
/* 43 */       return sm.executeBatch();
/*    */     }
/*    */     catch (SQLException e)
/*    */     {
/* 47 */       e.printStackTrace();
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
/*    */   {
/* 65 */     String userName = "root";
/* 66 */     String password = "sde";
/*    */ 
/* 68 */     String[] sqls = new String[2];
/* 69 */     sqls[0] = "DROP TABLE IF EXISTS Entity4;";
/* 70 */     sqls[1] = "CREATE TABLE Entity4 (id int auto_increment NOT NULL , version int NOT NULL ,\t\t     column_2 int   NULL,\t\t     column_3 int   NULL,\t\t     primary key (id));";
/* 71 */     Connection con = null;
/*    */     try
/*    */     {
/* 74 */       Class.forName("org.gjt.mm.mysql.Driver").newInstance();
/* 75 */       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hi", userName, password);
/* 76 */       boolean supportBatch = supportBatch(con);
/* 77 */       System.out.println(supportBatch);
/*    */ 
/* 79 */       if (supportBatch)
/*    */       {
/* 81 */         goBatch(con, sqls);
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (SQLException e)
/*    */     {
/* 87 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.db.DbTest
 * JD-Core Version:    0.6.0
 */