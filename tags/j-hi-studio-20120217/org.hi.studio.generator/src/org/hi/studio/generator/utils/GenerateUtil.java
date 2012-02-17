/*     */ package org.hi.studio.generator.utils;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.List;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.jface.dialogs.ProgressMonitorDialog;
/*     */ import org.eclipse.jface.operation.IRunnableWithProgress;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.hi.generator.ant.EnvironmentTask;
/*     */ import org.hi.generator.ant.HiGeneraterToolTask;
/*     */ import org.hi.generator.ant.ServiceTask;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.studio.core.log.ExceptionManager;
/*     */ import org.hi.studio.core.utils.FileUtil;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.dialog.GenerateSelectDialog;
/*     */ 
/*     */ public class GenerateUtil
/*     */ {
/*     */   public static void generateAll(IProject prj)
/*     */   {
/*  29 */     HiGeneraterToolTask task = getHiGeneraterToolTask();
/*  30 */     if (task != null)
/*     */       try
/*     */       {
/*  33 */         new ProgressMonitorDialog(null).run(true, false, 
/*  34 */           new GenerateAllHscXmlLongRunningOperation(task));
/*     */       } catch (Exception e) {
/*  36 */         ExceptionManager.logError(e, "");
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void generateHsc(String hscFile, String entityNames)
/*     */   {
/*  48 */     HiGeneraterToolTask task = getHiGeneraterToolTask();
/*     */ 
/*  67 */     if (task != null)
/*     */       try
/*     */       {
/*  70 */         new ProgressMonitorDialog(null).run(true, false, 
/*  71 */           new GenerateHscLongRunningOperation(task, hscFile, entityNames));
/*     */       } catch (Exception e) {
/*  73 */         ExceptionManager.logError(e, "");
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void generateHsc(String hscFile)
/*     */   {
/*  85 */     HiGeneraterToolTask task = getHiGeneraterToolTask();
/*  86 */     if (task != null)
/*     */       try
/*     */       {
/*  89 */         new ProgressMonitorDialog(null).run(true, false, 
/*  90 */           new GenerateHscLongRunningOperation(task, hscFile, null));
/*     */       } catch (Exception e) {
/*  92 */         ExceptionManager.logError(e, "");
/*     */       }
/*     */   }
/*     */ 
/*     */   private static boolean canGenerate(String filename)
/*     */   {
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   public static HiGeneraterToolTask getHiGeneraterToolTask()
/*     */   {
/* 110 */     HiGeneraterToolTask hitask = new HiGeneraterToolTask();
/*     */ 
/* 112 */     GenerateSelectDialog generateSelectDialog = new GenerateSelectDialog(Display.getCurrent().getActiveShell());
/* 113 */     generateSelectDialog.setTasks(hitask);
/*     */ 
/* 117 */     if (generateSelectDialog.open() == 0) {
/* 118 */       return hitask;
/*     */     }
/*     */ 
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   static class GenerateAllHscXmlLongRunningOperation
/*     */     implements IRunnableWithProgress
/*     */   {
/*     */     HiGeneraterToolTask task;
/*     */ 
/*     */     public GenerateAllHscXmlLongRunningOperation(HiGeneraterToolTask task)
/*     */     {
/* 176 */       this.task = task;
/*     */     }
/*     */ 
/*     */     public void run(IProgressMonitor monitor)
/*     */       throws InvocationTargetException, InterruptedException
/*     */     {
/* 182 */       monitor.beginTask("生成Hsc文件对应的代码", -1);
/*     */ 
/* 184 */       String webPath = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject()).getLocation().toOSString();
/* 185 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/* 187 */       EnvironmentTask environmentTask = this.task.createEnvironment();
/* 188 */       environmentTask.setEnvironmentFile(environmentFile);
/*     */ 
/* 191 */       ServiceTask serviceTask = this.task.createService();
/*     */ 
/* 193 */       List hscFileList = FileUtil.getChildFileByExtension(environmentTask.getEnvironment().getDir(), "hsc.xml");
/* 194 */       serviceTask.setHscFileList(hscFileList);
/*     */ 
/* 201 */       this.task.execute();
/*     */ 
/* 204 */       monitor.done();
/*     */     }
/*     */   }
/*     */ 
/*     */   static class GenerateHscLongRunningOperation
/*     */     implements IRunnableWithProgress
/*     */   {
/*     */     HiGeneraterToolTask task;
/*     */     String hscFile;
/*     */     String entityNames;
/*     */ 
/*     */     public GenerateHscLongRunningOperation(HiGeneraterToolTask task, String hscFile, String entityNames)
/*     */     {
/* 135 */       this.task = task;
/* 136 */       this.hscFile = hscFile;
/* 137 */       this.entityNames = entityNames;
/*     */     }
/*     */ 
/*     */     public void run(IProgressMonitor monitor)
/*     */       throws InvocationTargetException, InterruptedException
/*     */     {
/* 143 */       monitor.beginTask("生成Hsc文件对应的代码", -1);
/*     */ 
/* 145 */       String webPath = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject()).getLocation().toOSString();
/* 146 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/* 148 */       EnvironmentTask environmentTask = this.task.createEnvironment();
/* 149 */       environmentTask.setEnvironmentFile(environmentFile);
/* 150 */       ServiceTask serviceTask = this.task.createService();
/*     */ 
/* 152 */       serviceTask.getHscFileList().add(this.hscFile);
/*     */ 
/* 155 */       if (this.entityNames != null) {
/* 156 */         serviceTask.setEntities(this.entityNames);
/*     */       }
/*     */ 
/* 160 */       this.task.execute();
/*     */ 
/* 162 */       monitor.done();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.utils.GenerateUtil
 * JD-Core Version:    0.6.0
 */