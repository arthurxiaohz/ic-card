/*     */ package org.hi.studio.generator.db;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.core.runtime.IStatus;
/*     */ import org.eclipse.core.runtime.Status;
/*     */ import org.eclipse.core.runtime.jobs.Job;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.dialogs.ProgressMonitorDialog;
/*     */ import org.eclipse.jface.operation.IRunnableWithProgress;
/*     */ import org.hi.generator.ant.EnvironmentTask;
/*     */ import org.hi.generator.ant.HiGeneraterToolTask;
/*     */ import org.hi.metadata.hsc.context.environment.Database;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.plugin.HiCorePlugin;
/*     */ import org.hi.studio.core.utils.FileUtil;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ 
/*     */ public class DbUtil
/*     */ {
/* 100 */   private static java.sql.Connection hiConnection = null;
/* 101 */   private static String hiDatabseType = "";
/*     */ 
/*     */   private static Environment getEnvironment()
/*     */   {
/*  36 */     HiGeneraterToolTask hitask = new HiGeneraterToolTask();
/*     */ 
/*  39 */     String webPath = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject()).getLocation().toOSString();
/*  40 */     String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/*  42 */     EnvironmentTask environmentTask = hitask.createEnvironment();
/*  43 */     environmentTask.setEnvironmentFile(environmentFile);
/*     */ 
/*  45 */     return environmentTask.getEnvironment();
/*     */   }
/*     */ 
/*     */   public static java.sql.Connection getConnection()
/*     */   {
/*  53 */     Environment env = getEnvironment();
/*  54 */     String driverClass = env.getDatabase().getConnection().getDriverClass();
/*  55 */     String url = env.getDatabase().getConnection().getUrl();
/*  56 */     String username = env.getDatabase().getConnection().getUsername();
/*  57 */     String password = env.getDatabase().getConnection().getPassword();
/*     */ 
/*  59 */     return getConnection(driverClass, url, username, password);
/*     */   }
/*     */ 
/*     */   public static boolean canConncet(String driverClass, String url, String username, String password)
/*     */   {
/*  67 */     java.sql.Connection con = getConnection(driverClass, url, username, password);
/*  68 */     if (con != null)
/*     */     {
/*     */       try {
/*  71 */         con.close();
/*     */       } catch (SQLException e) {
/*  73 */         ExceptionManager.logError(e, "close connection error");
/*     */       }
/*     */ 
/*  76 */       return true;
/*     */     }
/*     */ 
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   public static java.sql.Connection getConnection(String driverClass, String url, String username, String password)
/*     */   {
/*  88 */     java.sql.Connection con = null;
/*     */     try {
/*  90 */       Class.forName(driverClass).newInstance();
/*  91 */       con = DriverManager.getConnection(url, username, password);
/*     */     }
/*     */     catch (Exception e) {
/*  94 */       ExceptionManager.logError(e, "createConnection error");
/*     */     }
/*     */ 
/*  97 */     return con;
/*     */   }
/*     */ 
/*     */   public static void initPlatform(java.sql.Connection con, String databseType)
/*     */   {
/* 107 */     hiConnection = con;
/* 108 */     hiDatabseType = databseType;
/* 109 */     if (!supportBatch(hiConnection))
/*     */     {
/* 111 */       MessageDialog.openError(null, "数据库不支持批量sql", "数据库不支持批量sql");
/* 112 */       return;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 117 */       new ProgressMonitorDialog(null).run(true, true, 
/* 118 */         new LongRunningOperation());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 124 */       ExceptionManager.logError(e, "long run exception");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void initService(java.sql.Connection con, List<File> sqlFileList)
/*     */   {
/* 133 */     if ((con == null) || (!supportBatch(con)))
/*     */     {
/* 135 */       MessageDialog.openError(null, "数据库不支持批量sql，或者数据连接为空", "数据库不支持批量sql，或者数据连接为空");
/* 136 */       return;
/*     */     }
/*     */ 
/* 140 */     List batchSql = getSql(sqlFileList);
/* 141 */     excuteSql(con, batchSql);
/*     */     try
/*     */     {
/* 144 */       con.close();
/*     */     } catch (Exception e) {
/* 146 */       ExceptionManager.logError(e, "close connection error");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static List<String> getSql(List<File> sqlFileList)
/*     */   {
/* 153 */     List resultList = new ArrayList();
/*     */ 
/* 155 */     for (Iterator it = sqlFileList.iterator(); it.hasNext(); ) {
/* 156 */       File sqlFile = (File)it.next();
/* 157 */       boolean isBaseData = false;
/* 158 */       if (sqlFile.getName().endsWith("BaseData.sql")) {
/* 159 */         isBaseData = true;
/*     */       }
/*     */       try
/*     */       {
/* 163 */         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "gbk"));
/* 164 */         String sql = "";
/* 165 */         for (String line = null; (line = br.readLine()) != null; )
/*     */         {
/* 168 */           if ((line.trim().startsWith("--")) || (line.trim().startsWith("/--")))
/*     */           {
/* 170 */             if (!sql.trim().equals("")) {
/* 171 */               resultList.add(sql);
/*     */             }
/* 173 */             sql = "";
/*     */           }
/*     */           else {
/* 176 */             if (isBaseData)
/*     */             {
/* 178 */               if (line.lastIndexOf(";") != -1)
/* 179 */                 line = line.substring(0, line.lastIndexOf(";"));
/*     */             }
/* 181 */             sql = sql + line + "  ";
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 186 */         br.close();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 190 */         ExceptionManager.logError(e, "read sql file");
/*     */       }
/*     */     }
/*     */ 
/* 194 */     return resultList;
/*     */   }
/*     */ 
/*     */   private static int[] excuteSql(java.sql.Connection con, List<String> sqlList)
/*     */   {
/* 202 */     if (sqlList.size() == 0) {
/* 203 */       return null;
/*     */     }
/*     */ 
/* 207 */     Statement sm = null;
/*     */     try {
/* 209 */       sm = con.createStatement();
/* 210 */       for (Iterator it = sqlList.iterator(); it.hasNext(); ) {
/* 211 */         sm.addBatch((String)it.next());
/*     */       }
/*     */ 
/* 214 */       return sm.executeBatch();
/*     */     } catch (Exception e) {
/* 216 */       ExceptionManager.logError(e, "excute sql error");
/*     */     }
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */   private static boolean supportBatch(java.sql.Connection con)
/*     */   {
/*     */     try {
/* 224 */       DatabaseMetaData md = con.getMetaData();
/* 225 */       return md.supportsBatchUpdates();
/*     */     } catch (SQLException e) {
/* 227 */       e.printStackTrace();
/*     */     }
/* 229 */     return false;
/*     */   }
/*     */ 
/*     */   static class LongRunningOperation
/*     */     implements IRunnableWithProgress
/*     */   {
/*     */     public void run(IProgressMonitor monitor)
/*     */       throws InvocationTargetException, InterruptedException
/*     */     {
/* 251 */       Job job = new Job("初始化数据库")
/*     */       {
/*     */         protected IStatus run(IProgressMonitor monitor)
/*     */         {
/* 255 */           monitor.beginTask("开始初始化数据库", -1);
/*     */ 
/* 259 */           String sqlPath = HiCorePlugin.getCurrentPluginDirectory() + "/resource/sql/" + DbUtil.hiDatabseType;
/* 260 */           List fileList = FileUtil.getChildFileByExtension(sqlPath, "sql");
/*     */ 
/* 262 */           monitor.subTask("取初始化sql文件");
/* 263 */           String defaultBaseData = "";
/* 264 */           List createList = new ArrayList();
/* 265 */           List initBaseDataList = new ArrayList();
/* 266 */           for (Iterator it = fileList.iterator(); it.hasNext(); ) {
/* 267 */             String filePath = (String)it.next();
/* 268 */             if (filePath.endsWith("BaseData.sql")) {
/* 269 */               if (filePath.indexOf("default") > 0)
/*     */               {
/* 271 */                 defaultBaseData = filePath;
/*     */               }
/* 273 */               else initBaseDataList.add(new File(filePath));
/*     */             }
/*     */             else
/*     */             {
/* 277 */               createList.add(new File(filePath));
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 282 */           if (new File(defaultBaseData).exists()) {
/* 283 */             initBaseDataList.add(new File(defaultBaseData));
/*     */           }
/*     */ 
/* 287 */           monitor.subTask("执行创建表脚本");
/*     */ 
/* 289 */           List batchCreateSql = DbUtil.access$1(createList);
/* 290 */           DbUtil.access$3(DbUtil.hiConnection, batchCreateSql);
/*     */ 
/* 293 */           monitor.subTask("执行初始化数据脚本");
/*     */ 
/* 295 */           List batchInitSql = DbUtil.access$1(initBaseDataList);
/*     */ 
/* 297 */           DbUtil.access$3(DbUtil.hiConnection, batchInitSql);
/*     */ 
/* 299 */           monitor.done();
/*     */           try
/*     */           {
/* 302 */             DbUtil.hiConnection.close();
/*     */           } catch (SQLException e) {
/* 304 */             ExceptionManager.logError(e, "close error");
/*     */           }
/*     */ 
/* 307 */           return Status.OK_STATUS;
/*     */         }
/*     */       };
/* 311 */       job.setUser(true);
/* 312 */       job.schedule();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.db.DbUtil
 * JD-Core Version:    0.6.0
 */