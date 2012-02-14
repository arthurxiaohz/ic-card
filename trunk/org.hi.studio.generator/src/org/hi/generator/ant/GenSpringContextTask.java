/*    */ package org.hi.generator.ant;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.tools.ant.BuildException;
/*    */ import org.eclipse.core.resources.IFolder;
/*    */ import org.eclipse.core.runtime.IPath;
/*    */ import org.hi.generator.context.service.tools.ServiceTool;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.metadata.hsc.context.environment.Generate;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ import org.hi.studio.core.log.LogMessage;
/*    */ import org.hi.studio.core.utils.HiProjectUtil;
/*    */ import org.hi.studio.generator.utils.FileUtil;
/*    */ 
/*    */ public class GenSpringContextTask extends AbstractTask
/*    */ {
/*    */   public GenSpringContextTask(HiGeneraterToolTask parent)
/*    */   {
/* 22 */     super(parent);
/*    */   }
/*    */ 
/*    */   public void execute() throws BuildException {
/* 26 */     List services = this.parent.getSerivces();
/* 27 */     TemplateHelp templateHelp = getTemplateHelp();
/*    */ 
/* 29 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "spring";
/*    */     try {
/* 31 */       templateHelp.loadTemplateDir(templateDir);
/*    */     } catch (IOException localIOException) {
/* 33 */       this.log.error("not found template directory :" + templateDir);
/* 36 */     }
/*    */ ServiceTool serviceTool = this.parent.getServiceTool();
/*    */ 
/* 38 */     putTemplateContext();
/*    */     String webPath;
/*    */     try { IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/* 43 */       webPath = webFolder.getLocation().toString();
/* 44 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*    */ 
/* 46 */       Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*    */ 
/* 48 */       templateHelp.put("ormtype", env.getGenerate().getOrmType());
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 52 */       LogMessage.logError("EnvironmentFactory", e);
/*    */     }
/*    */ 
/* 59 */     for (Service service : services)
/*    */     {
/* 61 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*    */         continue;
/*    */       }
/* 64 */       templateHelp.put("service", service);
/*    */ 
/* 66 */       generateSpringContext(service, serviceTool, this.parent.getAllService());
/*    */     }
/*    */   }
/*    */ 
/*    */   protected void generateSpringContext(Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/* 71 */     String outputDir = getDestdir(0) + File.separator + service.getPackageName().replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString());
/* 72 */     FileUtil.createDir(outputDir);
/* 73 */     String fileName = outputDir + File.separator + "appContext-" + service.getServiceName() + ".xml";
/*    */ 
/* 75 */     getTemplateHelp().process("appContext.xml" + getTemplateHelp().getFileSuffix(), fileName);
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 80 */     return "生成Spring配置";
/*    */   }
/*    */ 
/*    */   public Integer getSort()
/*    */   {
/* 86 */     return new Integer(5);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenSpringContextTask
 * JD-Core Version:    0.6.0
 */