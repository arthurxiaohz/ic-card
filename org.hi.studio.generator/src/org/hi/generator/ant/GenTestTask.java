/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.generator.context.service.tools.ServiceTool;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.generator.util.FileUtil;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ 
/*    */ public class GenTestTask extends AbstractTask
/*    */ {
/*    */   public GenTestTask(HiGeneraterToolTask parent)
/*    */   {
/* 17 */     super(parent);
/*    */   }
/*    */ 
/*    */   public void execute() {
/* 21 */     List services = this.parent.getSerivces();
/* 22 */     this.parent.getEnvironment();
/* 23 */     TemplateHelp templateHelp = getTemplateHelp();
/* 24 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "test";
/*    */     try {
/* 26 */       templateHelp.loadTemplateDir(templateDir);
/*    */     } catch (IOException localIOException) {
/* 28 */       this.log.error("not found template directory :" + templateDir);
/*    */     }
/*    */ 
/* 31 */     putTemplateContext();
/*    */ 
/* 34 */     for (Service service : services) {
/* 35 */       templateHelp.put("service", service);
/* 36 */       List entities = service.getEntity();
/* 37 */       if ((entities == null) || (entities.size() == 0)) {
/* 38 */         return;
/*    */       }
/* 40 */       for (Entity entity : entities)
/*    */       {
/* 42 */         if (entity.getEntityType() == 2) {
/*    */           continue;
/*    */         }
/* 45 */         if (!this.parent.getServiceTool().hasInEntity(entity.getEntityName(), this.parent.getEntityNames())) {
/*    */           continue;
/*    */         }
/* 48 */         templateHelp.put("entity", entity);
/* 49 */         String testDir = getDestdir(0).replace("src", "test");
/* 50 */         String packageName = "test" + service.getPackageName().substring(service.getPackageName().indexOf("."));
/* 51 */         templateHelp.put("packageName", packageName);
/* 52 */         String outputDir = testDir + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString());
/* 53 */         FileUtil.createDir(outputDir);
/* 54 */         String fileName = outputDir + File.separator + "Test" + entity.getEntityName() + "Case.java";
/*    */ 
/* 56 */         if (FileUtil.exists(fileName)) {
/* 57 */           return;
/*    */         }
/* 59 */         getTemplateHelp().process("test" + templateHelp.getFileSuffix(), fileName);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 67 */     return "生成测试用例";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 72 */     return new Integer(9);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenTestTask
 * JD-Core Version:    0.6.0
 */