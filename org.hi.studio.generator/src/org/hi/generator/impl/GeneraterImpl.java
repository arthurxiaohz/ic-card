/*    */ package org.hi.generator.impl;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.hi.generator.Generater;
/*    */ import org.hi.generator.template.TemplateHelp;
/*    */ import org.hi.generator.template.TemplateHelpFactory;
/*    */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*    */ import org.hi.metadata.hsc.context.environment.Environment;
/*    */ import org.hi.metadata.hsc.context.environment.Generate;
/*    */ import org.hi.metadata.hsc.context.service.Entity;
/*    */ import org.hi.metadata.hsc.context.service.Service;
/*    */ 
/*    */ public class GeneraterImpl extends Generater
/*    */ {
/*    */   TemplateHelp templateHelp;
/*    */   String templateDir;
/*    */ 
/*    */   protected void init()
/*    */     throws IOException
/*    */   {
/* 26 */     this.templateDir = this.environment.getGenerate().getTempletDir();
/* 27 */     if ((this.templateDir == null) || (this.templateDir.trim().equals(""))) {
/* 28 */       this.templateDir = EnvironmentFactory.TEMPLATES_DIR;
/*    */     }
/* 30 */     this.templateHelp = TemplateHelpFactory.newInstance(this.templateDir);
/*    */   }
/*    */ 
/*    */   protected void genHibneateHbm(Service service, Entity entity) throws IOException
/*    */   {
/* 35 */     this.templateHelp.loadTemplateDir(this.templateDir + File.separator + "hibernate");
/* 36 */     String templetFilename = "hbm.hbm" + TemplateHelpFactory.getTemplateFileSuffix();
/* 37 */     this.templateHelp.put("environment", this.environment);
/* 38 */     this.templateHelp.put("service", service);
/* 39 */     this.templateHelp.put("entity", entity);
/* 40 */     this.templateHelp.put("allServices", this.allServices);
/* 41 */     Writer writer = new FileWriter(EnvironmentFactory.TEMPORARY_DIR + File.separator + entity.getEntityName() + ".hbm.xml");
/* 42 */     this.templateHelp.process(templetFilename, writer);
/*    */   }
/*    */ 
/*    */   protected void genHibneateConfig(List<Service> services) throws IOException {
/* 46 */     this.templateHelp.loadTemplateDir(this.templateDir + File.separator + "hibernate");
/* 47 */     String templetFilename = "hibernate.cfg" + TemplateHelpFactory.getTemplateFileSuffix();
/*    */ 
/* 49 */     List entities = new ArrayList();
/* 50 */     for (Iterator iter = services.iterator(); iter.hasNext(); ) {
/* 51 */       Service service = (Service)iter.next();
/* 52 */       entities.addAll(service.getEntity());
/*    */     }
/* 54 */     this.templateHelp.put("entities", entities);
/* 55 */     this.templateHelp.put("services", services);
/* 56 */     this.templateHelp.put("environment", this.environment);
/* 57 */     Writer writer = new FileWriter(EnvironmentFactory.TEMPORARY_DIR + File.separator + "hibernate.cfg.xml");
/* 58 */     this.templateHelp.process(templetFilename, writer);
/*    */   }
/*    */ 
/*    */   protected void genAntBuilder()
/*    */     throws IOException
/*    */   {
/* 64 */     this.templateHelp.loadTemplateDir(this.templateDir + File.separator + "ant");
/* 65 */     String templetFilename = "build.ftl" + TemplateHelpFactory.getTemplateFileSuffix();
/* 66 */     this.templateHelp.put("environment", this.environment);
/* 67 */     Writer writer = new FileWriter(EnvironmentFactory.TEMPORARY_DIR + File.separator + "build.xml");
/* 68 */     this.templateHelp.process(templetFilename, writer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.impl.GeneraterImpl
 * JD-Core Version:    0.6.0
 */