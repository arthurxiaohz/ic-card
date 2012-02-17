/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.eclipse.core.resources.IProject;
/*    */ import org.eclipse.core.runtime.IPath;
/*    */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.metadata.hsc.context.environment.Generate;
/*    */ import org.hi.studio.core.log.ExceptionManager;
/*    */ import org.hi.studio.core.utils.HiProjectUtil;
/*    */ 
/*    */ public class EnvironmentTask extends HiTask
/*    */ {
/*    */   private Environment environment;
/*    */   private String environmentFile;
/*    */ 
/*    */   public EnvironmentTask(HiGeneraterToolTask parent)
/*    */   {
/* 30 */     super(parent);
/*    */   }
/*    */ 
/*    */   public Environment getEnvironment()
/*    */   {
/* 35 */     if (this.environmentFile == null) {
/* 36 */       this.environmentFile = (this.parent.getEnvdir() + File.separator + "config" + File.separator + "environment.xml");
/*    */     }
/* 38 */     if (this.environment == null) {
/*    */       try {
/* 40 */         this.environment = EnvironmentFactory.loadEnvironment(this.environmentFile);
/* 41 */         IProject project = HiProjectUtil.getCurrentProject();
/*    */ 
/* 43 */         String projectDir = "";
/* 44 */         if (project != null) {
/* 45 */           projectDir = project.getLocation().toString();
/*    */         }
/*    */ 
/* 48 */         if ((projectDir != null) && (!projectDir.equals(""))) {
/* 49 */           this.environment.setDir(projectDir + "/" + this.environment.getDir());
/* 50 */           this.environment.getGenerate().setSrcOutput(projectDir + "/" + this.environment.getGenerate().getSrcOutput());
/* 51 */           this.environment.getGenerate().setStandardOutput(projectDir + "/" + this.environment.getGenerate().getStandardOutput());
/* 52 */           this.environment.getGenerate().setTempletDir(projectDir + "/" + this.environment.getGenerate().getTempletDir());
/*    */         }
/*    */       }
/*    */       catch (Exception e) {
/* 56 */         ExceptionManager.logError(e, "getEnvironment");
/* 57 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */ 
/* 61 */     return this.environment;
/*    */   }
/*    */ 
/*    */   public String getEnvironmentFile() {
/* 65 */     return this.environmentFile;
/*    */   }
/*    */   public void setEnvironmentFile(String environmentFile) {
/* 68 */     this.environmentFile = environmentFile;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 72 */     return "environment";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 77 */     return new Integer(0);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.EnvironmentTask
 * JD-Core Version:    0.6.0
 */