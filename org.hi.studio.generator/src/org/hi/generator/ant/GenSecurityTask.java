/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.generator.context.service.tools.ServiceTool;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ import org.hi.studio.generator.utils.FileUtil;
/*    */ 
/*    */ public class GenSecurityTask extends AbstractTask
/*    */ {
/*    */   public GenSecurityTask(HiGeneraterToolTask parent)
/*    */   {
/* 21 */     super(parent);
/*    */   }
/*    */ 
/*    */   public void execute() {
/* 25 */     List services = this.parent.getSerivces();
/* 26 */     TemplateHelp templateHelp = getTemplateHelp();
/*    */ 
/* 28 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "security";
/*    */     try
/*    */     {
/* 31 */       templateHelp.loadTemplateDir(templateDir);
/*    */     } catch (IOException localIOException) {
/* 33 */       this.log.error("not found template directory :" + templateDir);
/*    */     }
/*    */ 
/* 36 */     ServiceTool serviceTool = this.parent.getServiceTool();
/* 37 */     putTemplateContext();
/*    */ 
/* 39 */     for (Service service : services)
/*    */     {
/* 41 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*    */         continue;
/*    */       }
/* 44 */       templateHelp.put("service", service);
/*    */ 
/* 46 */       generateProperty(service, serviceTool, this.parent.getAllService());
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void generateProperty(Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/* 51 */     String outputDir = getDestdir(0) + File.separator + service.getPackageName().replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString());
/* 52 */     FileUtil.createDir(outputDir);
/* 53 */     String fileName = outputDir + File.separator + service.getServiceName() + "-security.properties";
/*    */ 
/* 55 */     getTemplateHelp().process("security.properties" + getTemplateHelp().getFileSuffix(), fileName);
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 62 */     return "生成权限控制";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 68 */     return new Integer(8);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenSecurityTask
 * JD-Core Version:    0.6.0
 */