/*    */ package org.hi.studio.generator.utils;
/*    */ 
/*    */ import org.eclipse.core.resources.IFolder;
/*    */ import org.eclipse.core.runtime.IPath;
/*    */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.studio.core.log.ExceptionManager;
/*    */ import org.hi.studio.core.utils.HiProjectUtil;
/*    */ 
/*    */ public class EnvironmentUtil
/*    */ {
/*    */   public static Environment getCurrentEnvironment()
/*    */   {
/* 17 */     IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/* 18 */     String webPath = webFolder.getLocation().toString();
/* 19 */     String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*    */ 
/* 21 */     Environment env = null;
/*    */     try {
/* 23 */       env = EnvironmentFactory.loadEnvironment(environmentFile);
/*    */     }
/*    */     catch (Exception e) {
/* 26 */       ExceptionManager.logError(e, "");
/*    */     }
/*    */ 
/* 29 */     return env;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.utils.EnvironmentUtil
 * JD-Core Version:    0.6.0
 */