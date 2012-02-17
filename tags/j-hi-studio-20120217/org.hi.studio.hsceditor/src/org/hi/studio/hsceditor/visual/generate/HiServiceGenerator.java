/*     */ package org.hi.studio.hsceditor.visual.generate;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.StringWriter;
/*     */ import org.apache.velocity.VelocityContext;
/*     */ import org.apache.velocity.app.Velocity;
/*     */ import org.apache.velocity.runtime.log.NullLogChute;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.ui.dialogs.SaveAsDialog;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.hsceditor.util.IOUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ 
/*     */ public class HiServiceGenerator
/*     */   implements IGenerator
/*     */ {
/*     */   static
/*     */   {
/*  32 */     Velocity.addProperty("runtime.log.logsystem.class", 
/*  33 */       NullLogChute.class.getName());
/*     */   }
/*     */ 
/*     */   private static void processTemplate(String templateName, File output, VelocityContext context) throws Exception {
/*  37 */     StringWriter writer = new StringWriter();
/*     */ 
/*  39 */     InputStreamReader reader = new InputStreamReader(
/*  40 */       HiServiceGenerator.class.getResourceAsStream(templateName), "UTF-8");
/*  41 */     Velocity.evaluate(context, writer, null, reader);
/*     */ 
/*  43 */     FileOutputStream out = new FileOutputStream(output);
/*  44 */     out.write(writer.getBuffer().toString().getBytes("UTF-8"));
/*  45 */     IOUtils.close(out);
/*     */ 
/*  47 */     IOUtils.close(reader);
/*  48 */     IOUtils.close(writer);
/*     */   }
/*     */ 
/*     */   public void execute(IFile erdFile, RootModel root)
/*     */   {
/*     */     try {
/*  54 */       SaveAsDialog dialog = new SaveAsDialog(Display.getCurrent().getActiveShell());
/*     */ 
/*  56 */       IFolder descfolder = HiProjectUtil.getWebContentDir(erdFile.getProject());
/*  57 */       IFile original = descfolder.getFile("WEB-INF/metadata/" + root.getServiceName() + ".hsc.xml");
/*     */ 
/*  59 */       if (original != null)
/*  60 */         dialog.setOriginalFile(original);
/*     */       else {
/*  62 */         dialog.setOriginalFile(erdFile);
/*     */       }
/*  64 */       dialog.create();
/*     */ 
/*  66 */       if (dialog.open() == 1) {
/*  67 */         return;
/*     */       }
/*     */ 
/*  70 */       IPath filePath = dialog.getResult();
/*  71 */       IFile destFile = ResourcesPlugin.getWorkspace().getRoot()
/*  72 */         .getFile(filePath);
/*     */ 
/*  74 */       if (filePath != null)
/*  75 */         generate(destFile.getLocation().toFile(), root);
/*     */     }
/*     */     catch (Exception ex) {
/*  78 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void generate(File hscFile, RootModel root) throws Exception
/*     */   {
/*  84 */     Velocity.init();
/*  85 */     VelocityContext context = new VelocityContext();
/*  86 */     context.put("model", root);
/*  87 */     context.put("util", new VelocityUtils());
/*     */ 
/*  89 */     processTemplate("hscdemo.vm", hscFile, context);
/*     */   }
/*     */ 
/*     */   public static void generate(RootModel root)
/*     */     throws Exception
/*     */   {
/*  97 */     IProject prj = HiProjectUtil.getCurrentProject();
/*  98 */     if (prj == null) {
/*  99 */       prj = HiProjectUtil.getCurrentProject();
/*     */     }
/*     */ 
/* 102 */     IFolder descfolder = HiProjectUtil.getWebContentDir(prj);
/* 103 */     IFile original = descfolder.getFile("WEB-INF/metadata/" + root.getServiceName() + ".hsc.xml");
/*     */ 
/* 105 */     generate(original.getLocation().toFile(), root);
/*     */   }
/*     */ 
/*     */   public String getGeneratorName() {
/* 109 */     return "HSC";
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.HiServiceGenerator
 * JD-Core Version:    0.6.0
 */