/*    */ package org.hi.framework.util;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.security.CodeSource;
/*    */ import java.security.ProtectionDomain;
/*    */ 
/*    */ public class FrameworkBossJarUtil
/*    */ {
/*    */   public static final FrameworkBossJarUtil getInstance()
/*    */   {
/* 18 */     return SingletonHolder.INSTANCE;
/*    */   }
/*    */ 
/*    */   public String getFrameworkBossJarPath()
/*    */   {
/* 27 */     return getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
/*    */   }
/*    */ 
/*    */   public URL getFrameworkBossJarURL()
/*    */   {
/* 34 */     return getClass().getProtectionDomain().getCodeSource().getLocation();
/*    */   }
/*    */ 
/*    */   private static class SingletonHolder
/*    */   {
/* 12 */     private static final FrameworkBossJarUtil INSTANCE = new FrameworkBossJarUtil(null);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.util.FrameworkBossJarUtil
 * JD-Core Version:    0.6.0
 */