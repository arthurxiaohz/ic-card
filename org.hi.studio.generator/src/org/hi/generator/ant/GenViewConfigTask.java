/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.utils.FileUtil;
/*     */ import org.hi.studio.generator.utils.XWorkUtil;
/*     */ 
/*     */ public class GenViewConfigTask extends AbstractTask
/*     */ {
/*  23 */   String viewType = "webwork";
/*  24 */   String pageType = "jsp";
/*     */   String configExtends;
/*     */ 
/*     */   public GenViewConfigTask(HiGeneraterToolTask parent)
/*     */   {
/*  28 */     super(parent);
/*     */     try
/*     */     {
/*  32 */       IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/*  33 */       String webPath = webFolder.getLocation().toString();
/*  34 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/*  36 */       Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*     */ 
/*  38 */       String viewType = env.getGenerate().getViewType();
/*  39 */       if ((viewType != null) && (!viewType.equals(""))) {
/*  40 */         setViewType(viewType);
/*     */       }
/*     */ 
/*  43 */       String appName = env.getGenerate().getAppName();
/*  44 */       if ((appName != null) && (!appName.equals(""))) {
/*  45 */         setConfigExtends(appName);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  50 */       LogMessage.logError("EnvironmentFactory", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void execute()
/*     */     throws BuildException
/*     */   {
/*  57 */     List services = this.parent.getSerivces();
/*  58 */     TemplateHelp templateHelp = getTemplateHelp();
/*     */ 
/*  60 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "view" + File.separator + "config";
/*     */     try {
/*  62 */       templateHelp.loadTemplateDir(templateDir);
/*     */     } catch (IOException localIOException) {
/*  64 */       this.log.error("not found template directory :" + templateDir);
/*     */     }
/*     */ 
/*  67 */     ServiceTool serviceTool = this.parent.getServiceTool();
/*     */ 
/*  69 */     templateHelp.put("appName", getExtendName());
/*  70 */     putTemplateContext();
/*     */ 
/*  72 */     for (Service service : services)
/*     */     {
/*  74 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/*  77 */       templateHelp.put("service", service);
/*     */ 
/*  79 */       generateFrameworkConfig(service, serviceTool, this.parent.getAllService());
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void generateFrameworkConfig(Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/*  84 */     String outputDir = getDestdir(0);
/*  85 */     FileUtil.createDir(outputDir);
/*  86 */     String fileName = outputDir + File.separator + getConfigPrefix() + "-" + service.getServiceName() + ".xml";
/*     */ 
/*  88 */     getTemplateHelp().process(this.viewType + File.separator + this.pageType + File.separator + "viewconfig" + getTemplateHelp().getFileSuffix(), fileName);
/*     */ 
/*  91 */     String xworkfile = outputDir + File.separator + getConfigPrefix() + ".xml";
/*  92 */     String includeFile = getConfigPrefix() + "-" + service.getServiceName() + ".xml";
/*  93 */     XWorkUtil.writeXWorkFile(xworkfile, includeFile);
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  99 */     return "生成" + this.viewType + "配置";
/*     */   }
/*     */ 
/*     */   public String getViewType()
/*     */   {
/* 104 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/* 108 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public String getConfigExtends() {
/* 112 */     return this.configExtends;
/*     */   }
/*     */ 
/*     */   public void setConfigExtends(String configExtends) {
/* 116 */     this.configExtends = configExtends;
/*     */   }
/*     */ 
/*     */   private String getExtendName() {
/* 120 */     if (this.configExtends != null) {
/* 121 */       return this.configExtends;
/*     */     }
/* 123 */     if ((this.viewType.equals("webwork")) || 
/* 124 */       (this.viewType.equals("struts"))) {
/* 125 */       return "hi";
/*     */     }
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   private String getConfigPrefix() {
/* 131 */     if (this.viewType.equals("webwork"))
/* 132 */       return "xwork";
/* 133 */     if (this.viewType.equals("struts"))
/* 134 */       return this.viewType;
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   public String getPageType() {
/* 139 */     return this.pageType;
/*     */   }
/*     */ 
/*     */   public void setPageType(String pageType) {
/* 143 */     this.pageType = pageType;
/*     */   }
/*     */ 
/*     */   public Integer getSort() {
/* 147 */     return new Integer(7);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenViewConfigTask
 * JD-Core Version:    0.6.0
 */