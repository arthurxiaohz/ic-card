/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.generator.context.service.tools.ServiceTool;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.metadata.hsc.context.environment.Database;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ import org.hi.studio.generator.db.DbUtil;
/*    */ import org.hi.studio.generator.utils.FileUtil;
/*    */ 
/*    */ public class GenBaseDataTask extends AbstractTask
/*    */ {
/*    */   public GenBaseDataTask(HiGeneraterToolTask parent)
/*    */   {
/* 21 */     super(parent);
/*    */   }
/*    */ 
/*    */   public void execute() {
/* 25 */     List services = this.parent.getSerivces();
/* 26 */     Environment environment = this.parent.getEnvironment();
/* 27 */     TemplateHelp templateHelp = getTemplateHelp();
/*    */ 
/* 29 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + 
/* 30 */       "db" + File.separator + environment.getDatabase().getDbtype();
/*    */     try {
/* 32 */       templateHelp.loadTemplateDir(templateDir);
/*    */     } catch (IOException localIOException) {
/* 34 */       this.log.error("not found template directory :" + templateDir);
/*    */     }
/*    */ 
/* 37 */     ServiceTool serviceTool = this.parent.getServiceTool();
/*    */ 
/* 39 */     putTemplateContext();
/*    */ 
/* 41 */     for (Service service : services)
/*    */     {
/* 43 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*    */         continue;
/*    */       }
/* 46 */       templateHelp.put("service", service);
/*    */ 
/* 48 */       generateBaseDataSQL(environment, service, serviceTool, this.parent.getAllService());
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void generateBaseDataSQL(Environment environment, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*    */   {
/* 54 */     String outputDir = getDestdir(1) + File.separator + "db" + File.separator + environment.getDatabase().getDbtype();
/* 55 */     FileUtil.createDir(outputDir);
/* 56 */     String fileName = outputDir + File.separator + service.getServiceName() + "_BaseData.sql";
/*    */ 
/* 58 */     Writer writer = null;
/*    */     try {
/* 60 */       writer = new FileWriter(fileName);
/*    */     } catch (IOException e) {
/* 62 */       this.log.error("Problem output file: " + fileName);
/* 63 */       e.printStackTrace();
/*    */     }
/* 65 */     getTemplateHelp().process("basedata" + getTemplateHelp().getFileSuffix(), writer);
/*    */ 
/* 68 */     List list = new ArrayList();
/* 69 */     list.add(new File(fileName));
/* 70 */     DbUtil.initService(DbUtil.getConnection(), list);
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 77 */     return "生成初始化数据";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 83 */     return new Integer(2);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenBaseDataTask
 * JD-Core Version:    0.6.0
 */