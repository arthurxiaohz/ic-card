/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.metadata.hsc.context.environment.Database;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ import org.hi.studio.generator.db.DbUtil;
/*    */ import org.hi.studio.generator.utils.FileUtil;
/*    */ 
/*    */ public class GenDLLTask extends AbstractTask
/*    */ {
/* 23 */   boolean exportToDatabase = false;
/*    */ 
/* 25 */   boolean drop = true;
/*    */ 
/* 27 */   boolean format = true;
/*    */ 
/*    */   public GenDLLTask(HiGeneraterToolTask parent) {
/* 30 */     super(parent);
/*    */   }
/*    */ 
/*    */   public void execute() {
/* 34 */     List services = this.parent.getSerivces();
/* 35 */     Environment environment = this.parent.getEnvironment();
/* 36 */     String destdir = getDestdir(1);
/* 37 */     TemplateHelp templateHelp = getTemplateHelp();
/* 38 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + 
/* 39 */       "db" + File.separator + environment.getDatabase().getDbtype();
/*    */     try {
/* 41 */       templateHelp.loadTemplateDir(templateDir);
/*    */     } catch (IOException localIOException1) {
/* 43 */       this.log.error("not found template directory :" + templateDir);
/*    */     }
/*    */ 
/* 46 */     putTemplateContext();
/*    */ 
/* 48 */     for (Iterator i = services.iterator(); i.hasNext(); ) {
/* 49 */       Service service = (Service)i.next();
/* 50 */       templateHelp.put("service", service);
/* 51 */       templateHelp.put("drop", Boolean.valueOf(this.drop));
/*    */ 
/* 53 */       String outputDir = destdir + File.separator + "db" + File.separator + environment.getDatabase().getDbtype();
/* 54 */       FileUtil.createDir(outputDir);
/* 55 */       String fileName = outputDir + File.separator + service.getServiceName() + ".sql";
/*    */ 
/* 57 */       Writer writer = null;
/*    */       try {
/* 59 */         writer = new FileWriter(fileName);
/*    */       } catch (IOException e) {
/* 61 */         this.log.error("Problem output file: " + fileName);
/* 62 */         e.printStackTrace();
/*    */       }
/* 64 */       getTemplateHelp().process("ddl" + getTemplateHelp().getFileSuffix(), writer);
/*    */ 
/* 67 */       List list = new ArrayList();
/* 68 */       list.add(new File(fileName));
/* 69 */       DbUtil.initService(DbUtil.getConnection(), list);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setDrop(boolean drop)
/*    */   {
/* 75 */     this.drop = drop;
/*    */   }
/*    */ 
/*    */   public void setExportToDatabase(boolean exportToDatabase) {
/* 79 */     this.exportToDatabase = exportToDatabase;
/*    */   }
/*    */ 
/*    */   public void setFormat(boolean format) {
/* 83 */     this.format = format;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 87 */     return "生成DDL";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 93 */     return new Integer(1);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenDLLTask
 * JD-Core Version:    0.6.0
 */