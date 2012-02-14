/*     */ package org.hi.studio.hsceditor.visual.generate;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.ResourceBundle;
/*     */ import org.apache.velocity.VelocityContext;
/*     */ import org.apache.velocity.app.Velocity;
/*     */ import org.apache.velocity.runtime.log.NullLogChute;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.swt.widgets.DirectoryDialog;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.hi.studio.hsceditor.util.IOUtils;
/*     */ import org.hi.studio.hsceditor.visual.model.AbstractDBEntityModel;
/*     */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*     */ import org.hi.studio.hsceditor.visual.model.TableModel;
/*     */ 
/*     */ public class HTMLGenerator
/*     */   implements IGenerator
/*     */ {
/*  28 */   private static ResourceBundle bundle = ResourceBundle.getBundle(HTMLGenerator.class.getName());
/*  29 */   private static Map<String, String> messages = new HashMap();
/*     */ 
/*  31 */   static { for (Enumeration e = bundle.getKeys(); e.hasMoreElements(); ) {
/*  32 */       String key = (String)e.nextElement();
/*  33 */       messages.put(key, bundle.getString(key));
/*     */     }
/*     */ 
/*  39 */     Velocity.addProperty("runtime.log.logsystem.class", 
/*  40 */       NullLogChute.class.getName()); }
/*     */ 
/*     */   private void processTemplate(String templateName, File output, VelocityContext context) throws Exception
/*     */   {
/*  44 */     StringWriter writer = new StringWriter();
/*     */ 
/*  46 */     InputStreamReader reader = new InputStreamReader(
/*  47 */       HTMLGenerator.class.getResourceAsStream(templateName), "UTF-8");
/*  48 */     Velocity.evaluate(context, writer, null, reader);
/*     */ 
/*  50 */     FileOutputStream out = new FileOutputStream(output);
/*  51 */     out.write(writer.getBuffer().toString().getBytes("UTF-8"));
/*  52 */     IOUtils.close(out);
/*     */ 
/*  54 */     IOUtils.close(reader);
/*  55 */     IOUtils.close(writer);
/*     */   }
/*     */ 
/*     */   public void execute(IFile erdFile, RootModel root) {
/*     */     try {
/*  60 */       DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell(), 8192);
/*  61 */       String rootDir = dialog.open();
/*     */ 
/*  63 */       if (rootDir != null)
/*  64 */         generate(rootDir, root);
/*     */     }
/*     */     catch (Exception ex) {
/*  67 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void generate(String rootDir, RootModel root) throws Exception {
/*  72 */     IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("stylesheet.css"), 
/*  73 */       new FileOutputStream(new File(rootDir, "stylesheet.css")));
/*     */ 
/*  75 */     Velocity.init();
/*  76 */     VelocityContext context = new VelocityContext();
/*  77 */     context.put("model", root);
/*  78 */     context.put("util", new VelocityUtils());
/*  79 */     context.put("msg", messages);
/*     */ 
/*  81 */     processTemplate("index.html", new File(rootDir, "index.html"), context);
/*  82 */     processTemplate("list.html", new File(rootDir, "list.html"), context);
/*  83 */     processTemplate("summary.html", new File(rootDir, "summary.html"), context);
/*     */ 
/*  85 */     File imageDir = new File(rootDir, "images");
/*  86 */     imageDir.mkdir();
/*     */ 
/*  88 */     IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("primarykey.gif"), 
/*  89 */       new FileOutputStream(new File(imageDir, "primarykey.gif")));
/*     */ 
/*  91 */     File tableDir = new File(rootDir, "tables");
/*  92 */     tableDir.mkdir();
/*     */ 
/*  94 */     for (AbstractDBEntityModel entity : root.getChildren())
/*  95 */       if ((entity instanceof TableModel)) {
/*  96 */         context.put("table", entity);
/*  97 */         processTemplate("table.html", 
/*  98 */           new File(tableDir, 
/*  98 */           ((TableModel)entity).getTableName() + ".html"), context);
/*     */       }
/*     */   }
/*     */ 
/*     */   public String getGeneratorName()
/*     */   {
/* 104 */     return "HTML";
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.HTMLGenerator
 * JD-Core Version:    0.6.0
 */