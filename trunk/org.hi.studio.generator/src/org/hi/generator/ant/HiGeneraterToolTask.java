/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ 
/*     */ public class HiGeneraterToolTask extends HiBaseTask
/*     */ {
/*     */   EnvironmentTask environmentTask;
/*     */   ServiceTask serviceTask;
/*     */   private String destdir;
/*     */   private String envdir;
/*     */   private Map<String, Service> allService;
/*     */   private ServiceTool serviceTool;
/*  58 */   public List generators = new ArrayList();
/*     */ 
/*     */   private void checkEnvironment() {
/*  61 */     if (this.environmentTask != null)
/*  62 */       throw new BuildException("Only a single environment is allowed.");
/*     */   }
/*     */ 
/*     */   public EnvironmentTask createEnvironment()
/*     */   {
/*  71 */     checkEnvironment();
/*  72 */     this.environmentTask = new EnvironmentTask(this);
/*  73 */     return this.environmentTask;
/*     */   }
/*     */ 
/*     */   public ServiceTask createService()
/*     */   {
/*  81 */     this.serviceTask = new ServiceTask(this);
/*  82 */     return this.serviceTask;
/*     */   }
/*     */ 
/*     */   public Environment getEnvironment()
/*     */   {
/*  89 */     return this.environmentTask.getEnvironment();
/*     */   }
/*     */ 
/*     */   public List<Service> getSerivces()
/*     */   {
/*  96 */     return this.serviceTask.getServices();
/*     */   }
/*     */ 
/*     */   public List<String> getEntityNames()
/*     */   {
/* 103 */     return this.serviceTask.getEntityNames();
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenDDL()
/*     */   {
/* 111 */     AbstractTask generator = new GenDLLTask(this);
/* 112 */     addGenerator(generator);
/* 113 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenJava()
/*     */   {
/* 121 */     AbstractTask generator = new GenJavaTask(this);
/* 122 */     addGenerator(generator);
/* 123 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenORM()
/*     */   {
/* 131 */     AbstractTask generator = new GenORMTask(this);
/* 132 */     addGenerator(generator);
/* 133 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenSecurity()
/*     */   {
/* 141 */     AbstractTask generator = new GenSecurityTask(this);
/* 142 */     addGenerator(generator);
/* 143 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenBaseData()
/*     */   {
/* 151 */     AbstractTask generator = new GenBaseDataTask(this);
/* 152 */     addGenerator(generator);
/* 153 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenContext()
/*     */   {
/* 161 */     AbstractTask generator = new GenSpringContextTask(this);
/* 162 */     addGenerator(generator);
/* 163 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenViewConfig()
/*     */   {
/* 172 */     AbstractTask generator = new GenViewConfigTask(this);
/* 173 */     addGenerator(generator);
/* 174 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenPage()
/*     */   {
/* 183 */     AbstractTask generator = new GenPageTask(this);
/* 184 */     addGenerator(generator);
/* 185 */     return generator;
/*     */   }
/*     */ 
/*     */   public AbstractTask createGenTest()
/*     */   {
/* 194 */     AbstractTask generator = new GenTestTask(this);
/* 195 */     addGenerator(generator);
/* 196 */     return generator;
/*     */   }
/*     */ 
/*     */   public void execute() {
/* 200 */     if (this.environmentTask == null)
/*     */     {
/* 203 */       throw new BuildException("No environment specified.  must have one of the following: <environment>");
/*     */     }
/* 205 */     this.environmentTask.getEnvironment();
/* 206 */     this.serviceTask.getServices();
/* 207 */     this.serviceTool = ServiceTool.newInstance(this);
/*     */ 
/* 209 */     validateParameters();
/* 210 */     Iterator iterator = this.generators.iterator();
/* 211 */     AbstractTask generatorTask = null;
/*     */ 
/* 213 */     while (iterator.hasNext()) {
/* 214 */       generatorTask = (AbstractTask)iterator.next();
/*     */ 
/* 220 */       generatorTask.execute();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getEnvdir() {
/* 225 */     return this.envdir;
/*     */   }
/*     */ 
/*     */   public void setEnvdir(String envdir) {
/* 229 */     this.envdir = envdir;
/*     */   }
/*     */ 
/*     */   public String getDestdir() {
/* 233 */     return this.destdir;
/*     */   }
/*     */   public void setDestdir(String destdir) {
/* 236 */     this.destdir = destdir;
/*     */   }
/*     */ 
/*     */   protected boolean addGenerator(AbstractTask generator)
/*     */   {
/* 241 */     return this.generators.add(generator);
/*     */   }
/*     */ 
/*     */   private void validateParameters()
/*     */   {
/* 248 */     if (this.generators.isEmpty())
/*     */     {
/* 251 */       throw new BuildException("No exporters specified in <hibernatetool>. There has to be at least one specified. An exporter is e.g. <hbm2java> or <hbmtemplate>. See documentation for details.");
/*     */     }
/* 253 */     Iterator iterator = this.generators.iterator();
/*     */ 
/* 255 */     while (iterator.hasNext()) {
/* 256 */       AbstractTask generatorTask = (AbstractTask)iterator.next();
/* 257 */       generatorTask.validateParameters();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Map<String, Service> getAllService()
/*     */   {
/* 263 */     if (this.allService == null) {
/*     */       try {
/* 265 */         this.allService = ServiceFactory.loadAllService(getEnvironment());
/*     */       } catch (IOException e1) {
/* 267 */         e1.printStackTrace();
/*     */       } catch (JAXBException e1) {
/* 269 */         e1.printStackTrace();
/*     */       }
/*     */     }
/* 272 */     return this.allService;
/*     */   }
/*     */ 
/*     */   public ServiceTool getServiceTool() {
/* 276 */     return this.serviceTool;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.HiGeneraterToolTask
 * JD-Core Version:    0.6.0
 */