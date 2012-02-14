/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.generator.template.TemplateHelpFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ 
/*     */ public abstract class AbstractTask extends HiTask
/*     */ {
/*     */   private TemplateHelp templateHelp;
/*     */   private String destdir;
/*     */   private String templateRootDir;
/*     */   public static final int OUT_TYPE_SRC = 0;
/*     */   public static final int OUT_TYPE_STANDARD = 1;
/*     */ 
/*     */   public AbstractTask(HiGeneraterToolTask parent)
/*     */   {
/*  27 */     super(parent);
/*     */   }
/*     */   public void validateParameters() {
/*  30 */     Environment environment = this.parent.getEnvironment();
/*     */ 
/*  32 */     if ((environment.getGenerate().getSrcOutput() == null) || (environment.getGenerate().getStandardOutput() == null))
/*  33 */       throw new BuildException("destdir must be set, either locally or on <hibernatetool>");
/*     */   }
/*     */ 
/*     */   public String getDestdir(int outType)
/*     */   {
/*  38 */     Environment environment = this.parent.getEnvironment();
/*  39 */     if (this.destdir == null) {
/*  40 */       if (outType == 0) {
/*  41 */         return environment.getGenerate().getSrcOutput();
/*     */       }
/*  43 */       return environment.getGenerate().getStandardOutput();
/*     */     }
/*     */ 
/*  46 */     return this.destdir;
/*     */   }
/*     */ 
/*     */   public void setDestdir(String destdir)
/*     */   {
/*  51 */     this.destdir = destdir;
/*     */   }
/*     */ 
/*     */   public TemplateHelp getTemplateHelp() {
/*  55 */     if (this.templateHelp == null) {
/*  56 */       String templateRootDir = this.templateRootDir;
/*  57 */       if ((templateRootDir == null) || (templateRootDir.trim().equals("")))
/*  58 */         templateRootDir = this.parent.getEnvironment().getGenerate().getTempletDir();
/*  59 */       this.templateHelp = TemplateHelpFactory.newInstance(templateRootDir);
/*  60 */       this.templateHelp.setFileSuffix(TemplateHelpFactory.getTemplateFileSuffix());
/*  61 */       this.templateHelp.put("encoding", TemplateHelpFactory.getTemplateFileEncoding());
/*     */     }
/*  63 */     return this.templateHelp;
/*     */   }
/*     */ 
/*     */   protected void setExtendService(Entity entity)
/*     */   {
/*  68 */     if (this.parent.getServiceTool().hasExtendEntity(entity)) {
/*  69 */       ExtendEntity extendEntity = entity.getExtendEntity();
/*  70 */       String exServiceName = extendEntity.getExtendServiceName();
/*  71 */       Service exService = (Service)this.parent.getAllService().get(exServiceName);
/*  72 */       if (exService == null) {
/*  73 */         this.log.error("not found service: " + exServiceName);
/*     */       } else {
/*  75 */         this.templateHelp.put("extendService", exService);
/*  76 */         List exEntities = exService.getEntity();
/*  77 */         for (Iterator iterator = exEntities.iterator(); iterator.hasNext(); ) {
/*  78 */           Entity exentity = (Entity)iterator.next();
/*  79 */           if (exentity.getEntityName().equals(extendEntity.getExtendEntityName())) {
/*  80 */             this.templateHelp.put("extendEntity", exentity);
/*  81 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void putTemplateContext()
/*     */   {
/*  90 */     this.templateHelp.put("environment", this.parent.getEnvironment());
/*  91 */     this.templateHelp.put("serviceTool", this.parent.getServiceTool());
/*  92 */     this.templateHelp.put("entitySet", this.parent.getEntityNames());
/*  93 */     this.templateHelp.put("allServices", this.parent.getAllService());
/*  94 */     this.templateHelp.put("StringUtils", new StringUtils());
/*     */   }
/*     */   public String getTemplateRootDir() {
/*  97 */     return this.templateRootDir;
/*     */   }
/*     */   public void setTemplateRootDir(String templateRootDir) {
/* 100 */     this.templateRootDir = templateRootDir;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.AbstractTask
 * JD-Core Version:    0.6.0
 */