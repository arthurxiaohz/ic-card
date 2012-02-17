/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.utils.FileUtil;
/*     */ 
/*     */ public class GenPageTask extends AbstractTask
/*     */ {
/*  28 */   private String viewType = "webwork";
/*  29 */   private String pageType = "jsp";
/*  30 */   private String pageFrameType = "classic";
/*  31 */   private String outputDir = null;
/*     */ 
/*     */   public GenPageTask(HiGeneraterToolTask parent) {
/*  34 */     super(parent);
/*     */     try {
/*  36 */       IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/*  37 */       String webPath = webFolder.getLocation().toString();
/*  38 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/*  40 */       Environment environment = EnvironmentFactory.loadEnvironment(environmentFile);
/*  41 */       String pageFrameType = environment.getGenerate().getPageFrameType();
/*  42 */       if ((pageFrameType != null) && (!pageFrameType.equals("")))
/*  43 */         setPageFrameType(pageFrameType);
/*     */     }
/*     */     catch (Exception e) {
/*  46 */       LogMessage.logError("pageFrameType", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void execute()
/*     */   {
/*  52 */     List services = this.parent.getSerivces();
/*  53 */     this.parent.getEnvironment();
/*  54 */     TemplateHelp templateHelp = getTemplateHelp();
/*     */ 
/*  56 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "view" + File.separator + this.pageType;
/*     */     try {
/*  58 */       templateHelp.loadTemplateDir(templateDir);
/*     */     } catch (IOException localIOException) {
/*  60 */       this.log.error("not found template directory :" + templateDir);
/*     */     }
/*     */ 
/*  63 */     ServiceTool serviceTool = this.parent.getServiceTool();
/*  64 */     Map allService = this.parent.getAllService();
/*     */ 
/*  66 */     putTemplateContext();
/*     */ 
/*  68 */     for (Service service : services) {
/*  69 */       templateHelp.put("service", service);
/*  70 */       List entities = service.getEntity();
/*     */ 
/*  72 */       this.outputDir = (getDestdir(1) + File.separator + service.getServiceName());
/*  73 */       FileUtil.createDir(this.outputDir);
/*     */ 
/*  75 */       if ((entities == null) || (entities.size() == 0)) {
/*  76 */         return;
/*     */       }
/*  78 */       for (Entity entity : entities)
/*     */       {
/*  80 */         if (entity.getEntityType() == 2) {
/*     */           continue;
/*     */         }
/*  83 */         if (!this.parent.getServiceTool().hasInEntity(entity.getEntityName(), this.parent.getEntityNames())) {
/*     */           continue;
/*     */         }
/*  86 */         setExtendService(entity);
/*     */ 
/*  88 */         Entity pageEntity = new Entity();
/*  89 */         ExtendEntity extendEntityDef = entity.getExtendEntity();
/*     */ 
/*  92 */         if ((extendEntityDef == null) || (extendEntityDef.getExtendEntityName() == null) || (extendEntityDef.getExtendEntityName().trim().equals(""))) {
/*  93 */           pageEntity = entity;
/*     */         }
/*     */         else {
/*  96 */           BeanUtil.setBean2Bean(entity, pageEntity);
/*     */ 
/*  98 */           Set fields = new HashSet();
/*  99 */           for (Field field : pageEntity.getField()) {
/* 100 */             fields.add(field.getFieldName());
/*     */           }
/* 102 */           extendProcess(pageEntity, fields, pageEntity);
/*     */         }
/*     */ 
/* 105 */         templateHelp.put("entity", pageEntity);
/*     */ 
/* 107 */         if (!this.pageFrameType.toLowerCase().equals("dwz"))
/* 108 */           generateJS(pageEntity, service, serviceTool, allService);
/* 109 */         generateListPage(pageEntity, service, serviceTool, allService);
/* 110 */         generateEditPage(pageEntity, service, serviceTool, allService);
/* 111 */         generateViewPage(pageEntity, service, serviceTool, allService);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void extendProcess(Entity entity, Set<String> fields, Entity resourceEntity)
/*     */   {
/* 118 */     if (entity == null) {
/* 119 */       return;
/*     */     }
/*     */ 
/* 122 */     for (Field field : entity.getField()) {
/* 123 */       if (!fields.contains(field.getFieldName())) {
/* 124 */         resourceEntity.getField().add(field);
/* 125 */         fields.add(field.getFieldName());
/*     */       }
/*     */     }
/* 128 */     ExtendEntity extendEntityDef = entity.getExtendEntity();
/*     */ 
/* 131 */     if (extendEntityDef == null) {
/* 132 */       return;
/*     */     }
/* 134 */     ServiceTool serviceTool = this.parent.getServiceTool();
/* 135 */     Map allService = this.parent.getAllService();
/* 136 */     Entity extendEntity = serviceTool.getEntityByName(allService, extendEntityDef.getExtendEntityName());
/* 137 */     extendProcess(extendEntity, fields, resourceEntity);
/*     */   }
/*     */ 
/*     */   protected void generateJS(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/* 141 */     String fileName = this.outputDir + File.separator + entity.getEntityName() + ".js";
/* 142 */     getTemplateHelp().process(this.pageFrameType + File.separator + "js" + getTemplateHelp().getFileSuffix(), fileName);
/*     */   }
/*     */ 
/*     */   protected void generateListPage(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 147 */     String fileName = this.outputDir + File.separator + entity.getEntityName() + "List." + this.pageType;
/* 148 */     getTemplateHelp().process(this.pageFrameType + File.separator + "list" + getTemplateHelp().getFileSuffix(), fileName);
/*     */   }
/*     */ 
/*     */   protected void generateEditPage(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 153 */     String fileName = this.outputDir + File.separator + entity.getEntityName() + "Edit." + this.pageType;
/* 154 */     getTemplateHelp().process(this.pageFrameType + File.separator + "edit" + getTemplateHelp().getFileSuffix(), fileName);
/*     */   }
/*     */ 
/*     */   protected void generateViewPage(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 159 */     String fileName = this.outputDir + File.separator + entity.getEntityName() + "View." + this.pageType;
/* 160 */     getTemplateHelp().process(this.pageFrameType + File.separator + "view" + getTemplateHelp().getFileSuffix(), fileName);
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 166 */     return "生成页面";
/*     */   }
/*     */ 
/*     */   public String getPageType()
/*     */   {
/* 171 */     return this.pageType;
/*     */   }
/*     */ 
/*     */   public void setPageType(String pageType) {
/* 175 */     this.pageType = pageType;
/*     */   }
/*     */ 
/*     */   public String getViewType() {
/* 179 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/* 183 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public String getPageFrameType() {
/* 187 */     return this.pageFrameType;
/*     */   }
/*     */ 
/*     */   public void setPageFrameType(String pageFrameType) {
/* 191 */     this.pageFrameType = pageFrameType;
/*     */   }
/*     */ 
/*     */   public Integer getSort()
/*     */   {
/* 196 */     return new Integer(4);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenPageTask
 * JD-Core Version:    0.6.0
 */