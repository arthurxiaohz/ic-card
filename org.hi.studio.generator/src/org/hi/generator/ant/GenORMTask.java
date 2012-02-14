/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.metadata.hsc.constant.ORMappingType;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.utils.FileUtil;
/*     */ 
/*     */ public class GenORMTask extends AbstractTask
/*     */ {
/*  25 */   String ormType = "hibernate";
/*     */ 
/*     */   public GenORMTask(HiGeneraterToolTask parent)
/*     */   {
/*  29 */     super(parent);
/*     */     try
/*     */     {
/*  33 */       IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/*  34 */       String webPath = webFolder.getLocation().toString();
/*  35 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/*  37 */       Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*     */ 
/*  39 */       String type = env.getGenerate().getOrmType();
/*  40 */       if ((type != null) && (!type.equals("")))
/*  41 */         setOrmType(type);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  45 */       LogMessage.logError("EnvironmentFactory", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void execute()
/*     */   {
/*  55 */     List services = this.parent.getSerivces();
/*  56 */     TemplateHelp templateHelp = getTemplateHelp();
/*     */ 
/*  58 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "orm" + File.separator + this.ormType;
/*     */     try {
/*  60 */       templateHelp.loadTemplateDir(templateDir);
/*     */     } catch (IOException localIOException) {
/*  62 */       this.log.error("not found template directory :" + templateDir);
/*     */     }
/*     */ 
/*  65 */     putTemplateContext();
/*     */ 
/*  67 */     for (Service service : services) {
/*  68 */       templateHelp.put("service", service);
/*  69 */       List entities = service.getEntity();
/*  70 */       if ((entities == null) || (entities.size() == 0)) {
/*  71 */         return;
/*     */       }
/*  73 */       for (Entity entity : entities)
/*     */       {
/*  75 */         if (entity.getEntityType() == 2) {
/*     */           continue;
/*     */         }
/*  78 */         if (!this.parent.getServiceTool().hasInEntity(entity.getEntityName(), this.parent.getEntityNames())) {
/*     */           continue;
/*     */         }
/*  81 */         templateHelp.put("entity", entity);
/*  82 */         setExtendService(entity);
/*  83 */         String outputDir = getDestdir(0) + File.separator + service.getPackageName().replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "dao" + File.separator + this.ormType;
/*  84 */         FileUtil.createDir(outputDir);
/*  85 */         String fileName = outputDir + File.separator + entity.getEntityName() + ORMappingType.getOutputFileType(this.ormType);
/*     */ 
/*  87 */         getTemplateHelp().process(ORMappingType.templateFileName(this.ormType) + templateHelp.getFileSuffix(), fileName);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  94 */     return "生成" + this.ormType + "映射文件";
/*     */   }
/*     */ 
/*     */   public String getOrmType() {
/*  98 */     return this.ormType;
/*     */   }
/*     */ 
/*     */   public void setOrmType(String ormType) {
/* 102 */     this.ormType = ormType;
/*     */   }
/*     */ 
/*     */   public Integer getSort() {
/* 106 */     return new Integer(6);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenORMTask
 * JD-Core Version:    0.6.0
 */