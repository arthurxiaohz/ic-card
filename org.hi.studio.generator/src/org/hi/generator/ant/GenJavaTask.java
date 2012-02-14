/*     */ package org.hi.generator.ant;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.eclipse.core.resources.IFolder;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.generator.context.service.tools.ServiceTool;
/*     */ import org.hi.generator.template.TemplateHelp;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.Generate;
/*     */ import org.hi.metadata.hsc.context.service.ChildEntity;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.utils.HiProjectUtil;
/*     */ import org.hi.studio.generator.utils.FileUtil;
/*     */ 
/*     */ public class GenJavaTask extends AbstractTask
/*     */ {
/*  42 */   String ormType = "hibernate";
/*  43 */   String viewType = "webwork";
/*     */ 
/*     */   public GenJavaTask(HiGeneraterToolTask parent) {
/*  46 */     super(parent);
/*     */     try
/*     */     {
/*  50 */       IFolder webFolder = HiProjectUtil.getWebContentDir(HiProjectUtil.getCurrentProject());
/*  51 */       String webPath = webFolder.getLocation().toString();
/*  52 */       String environmentFile = webPath + "/WEB-INF/config/environment.xml";
/*     */ 
/*  54 */       Environment env = EnvironmentFactory.loadEnvironment(environmentFile);
/*     */ 
/*  57 */       String type = env.getGenerate().getOrmType();
/*  58 */       if ((type != null) && (!type.equals(""))) {
/*  59 */         setOrmType(type);
/*     */       }
/*     */ 
/*  62 */       String viewType = env.getGenerate().getViewType();
/*  63 */       if ((viewType != null) && (!viewType.equals(""))) {
/*  64 */         setViewType(viewType);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  70 */       LogMessage.logError("EnvironmentFactory", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void execute() {
/*  75 */     List services = this.parent.getSerivces();
/*  76 */     this.parent.getEnvironment();
/*  77 */     TemplateHelp templateHelp = getTemplateHelp();
/*  78 */     String templateDir = templateHelp.getTemplateRootDir() + File.separator + "java";
/*     */     try {
/*  80 */       templateHelp.loadTemplateDir(templateDir);
/*     */     } catch (IOException localIOException) {
/*  82 */       this.log.error("not found template directory :" + templateDir);
/*     */     }
/*     */ 
/*  85 */     putTemplateContext();
/*     */ 
/*  87 */     ServiceTool serviceTool = this.parent.getServiceTool();
/*  88 */     Map allService = this.parent.getAllService();
/*     */ 
/*  91 */     for (Service service : services) {
/*  92 */       templateHelp.put("service", service);
/*     */ 
/*  94 */       if (service.getEntity() == null) {
/*     */         continue;
/*     */       }
/*  97 */       for (Iterator iter = service.getEntity().iterator(); iter.hasNext(); ) {
/*  98 */         Entity entity = (Entity)iter.next();
/*     */ 
/* 100 */         if (!serviceTool.hasInEntity(entity.getEntityName(), this.parent.getEntityNames())) {
/*     */           continue;
/*     */         }
/* 103 */         templateHelp.put("entity", entity);
/*     */ 
/* 106 */         setExtendService(entity);
/*     */ 
/* 108 */         if (entity.getEntityType() == 2) {
/* 109 */           generateEnumeration(entity, service, serviceTool, allService);
/*     */         }
/*     */         else {
/* 112 */           generatePOJO(entity, service, serviceTool, allService);
/* 113 */           generateDAO(entity, service, serviceTool, allService);
/* 114 */           generateManager(entity, service, serviceTool, allService);
/* 115 */           generateConversion(entity, service, serviceTool, allService);
/* 116 */           generateAction(entity, service, serviceTool, allService);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void generatePOJO(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 124 */     String packageName = service.getPackageName();
/* 125 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "model";
/* 126 */     String fileName = outputDir + File.separator + entity.getEntityName() + ".java";
/* 127 */     String abstractFileName = outputDir + File.separator + "original" + File.separator + entity.getEntityName() + "Abstract.java";
/* 128 */     FileUtil.createDir(outputDir + File.separator + "original");
/*     */ 
/* 131 */     Set importSet = new HashSet();
/* 132 */     List fields = entity.getField();
/*     */ 
/* 134 */     importSet.add(service.getPackageName() + ".model." + entity.getEntityName());
/* 135 */     Map enumerations = null;
/* 136 */     for (Field field : fields)
/*     */     {
/* 138 */       if ((field.getFieldType() == 6) || (field.getFieldType() == 8)) {
/* 139 */         LookupEntity lookupEntity = field.getLookupEntity();
/* 140 */         String lkServiceName = lookupEntity.getLkServiceName();
/* 141 */         Service lkService = (Service)allService.get(lkServiceName);
/* 142 */         if (lkService == null)
/* 143 */           this.log.error("not found service: " + lkServiceName + " entity:" + entity.getEntityName() + " lookup_field:" + field.getFieldName());
/* 144 */         String lkPackageName = lkService.getPackageName();
/* 145 */         String lkEntityName = lookupEntity.getLkEntityName();
/* 146 */         importSet.add(lkPackageName + ".model." + lkEntityName);
/*     */       }
/*     */ 
/* 149 */       if ((field.getFieldType() == 7) && (field.getDefaultValue() != null) && (!field.getDefaultValue().trim().equals(""))) {
/* 150 */         if (enumerations == null)
/* 151 */           enumerations = ServiceFactory.loadAllEnumeration(allService);
/* 152 */         Entity enumeration = (Entity)enumerations.get(field.getEnumerationEntity());
/*     */ 
/* 154 */         Service enumerationService = null;
/* 155 */         if (enumeration != null) {
/* 156 */           enumerationService = ServiceFactory.getService(enumeration, allService);
/*     */         }
/* 158 */         if (enumerationService != null)
/* 159 */           importSet.add(enumerationService.getPackageName() + ".model." + enumeration.getEntityName());
/*     */       }
/*     */     }
/*     */     Service exService;
/* 164 */     if (serviceTool.hasExtendEntity(entity)) {
/* 165 */       ExtendEntity extendEntity = entity.getExtendEntity();
/* 166 */       String exServiceName = extendEntity.getExtendServiceName();
/* 167 */       exService = (Service)allService.get(exServiceName);
/* 168 */       if (exService == null)
/* 169 */         this.log.error("not found service: " + exServiceName);
/* 170 */       String exPackageName = exService.getPackageName();
/* 171 */       String exEntityName = extendEntity.getExtendEntityName();
/* 172 */       importSet.add(exPackageName + ".model." + exEntityName);
/*     */     }
/*     */ 
/* 175 */     if ((entity.getChildEntity() != null) && (entity.getChildEntity().size() > 0)) {
/* 176 */       List childEntities = entity.getChildEntity();
/* 177 */       for (ChildEntity childEntity : childEntities) {
/* 178 */         String childEntityName = childEntity.getChildEntityName();
/* 179 */         Service childService = (Service)allService.get(childEntity.getChildServiceName());
/* 180 */         if (childService == null)
/* 181 */           this.log.error("not found service: " + childEntity.getChildServiceName());
/* 182 */         String childPackageName = childService.getPackageName();
/* 183 */         importSet.add(childPackageName + ".model." + childEntityName);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 188 */     getTemplateHelp().put("importClass", importSet);
/*     */ 
/* 191 */     Writer writer = null;
/*     */     try {
/* 193 */       writer = new FileWriter(abstractFileName);
/*     */     } catch (IOException e) {
/* 195 */       this.log.error("Problem output file: " + abstractFileName);
/* 196 */       e.printStackTrace();
/*     */     }
/* 198 */     getTemplateHelp().process("pojo" + getTemplateHelp().getFileSuffix(), writer);
/*     */ 
/* 201 */     if (!FileUtil.exists(fileName)) {
/*     */       try {
/* 203 */         writer = new FileWriter(fileName);
/*     */       } catch (IOException e) {
/* 205 */         this.log.error("Problem output file: " + fileName);
/* 206 */         e.printStackTrace();
/*     */       }
/* 208 */       getTemplateHelp().process("entitypojo" + getTemplateHelp().getFileSuffix(), writer);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void generateDAO(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/* 213 */     String packageName = service.getPackageName();
/*     */ 
/* 215 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "dao";
/* 216 */     FileUtil.createDir(outputDir);
/* 217 */     String fileName = outputDir + File.separator + entity.getEntityName() + "DAO.java";
/*     */ 
/* 220 */     Writer writer = null;
/* 221 */     if (!FileUtil.exists(fileName)) {
/*     */       try {
/* 223 */         writer = new FileWriter(fileName);
/*     */       } catch (IOException e) {
/* 225 */         this.log.error("Problem output file: " + fileName);
/* 226 */         e.printStackTrace();
/*     */       }
/* 228 */       getTemplateHelp().process("dao" + getTemplateHelp().getFileSuffix(), writer);
/*     */     }
/* 230 */     createFrameworkDAO(entity, service, serviceTool, allService);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkDAO(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService) {
/* 234 */     String packageName = service.getPackageName();
/*     */ 
/* 236 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + 
/* 237 */       File.separator + "dao" + File.separator + this.ormType.toLowerCase();
/*     */ 
/* 239 */     FileUtil.createDir(outputDir);
/* 240 */     String fileName = outputDir + File.separator + entity.getEntityName() + "DAO" + StringUtils.upperFrist(this.ormType) + ".java";
/* 241 */     if (FileUtil.exists(fileName)) {
/* 242 */       return;
/*     */     }
/* 244 */     Writer writer = null;
/*     */     try {
/* 246 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 248 */       this.log.error("Problem output file: " + fileName);
/* 249 */       e.printStackTrace();
/*     */     }
/* 251 */     getTemplateHelp().process("dao" + this.ormType + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void generateManager(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 256 */     String packageName = service.getPackageName();
/*     */ 
/* 259 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "service";
/* 260 */     FileUtil.createDir(outputDir);
/* 261 */     String fileName = outputDir + File.separator + entity.getEntityName() + "Manager.java";
/*     */ 
/* 263 */     Writer writer = null;
/* 264 */     if (!FileUtil.exists(fileName))
/*     */     {
/*     */       try {
/* 267 */         writer = new FileWriter(fileName);
/*     */       } catch (IOException e) {
/* 269 */         this.log.error("Problem output file: " + fileName);
/* 270 */         e.printStackTrace();
/*     */       }
/* 272 */       getTemplateHelp().process("manager" + getTemplateHelp().getFileSuffix(), writer);
/*     */     }
/*     */ 
/* 276 */     outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + 
/* 277 */       File.separator + "service" + File.separator + "impl";
/* 278 */     FileUtil.createDir(outputDir);
/* 279 */     fileName = outputDir + File.separator + entity.getEntityName() + "ManagerImpl.java";
/* 280 */     if (FileUtil.exists(fileName))
/* 281 */       return;
/*     */     try {
/* 283 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 285 */       this.log.error("Problem output file: " + fileName);
/* 286 */       e.printStackTrace();
/*     */     }
/* 288 */     getTemplateHelp().process("managerimpl" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void generateEnumeration(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 293 */     List enumerations = entity.getEnumeration();
/*     */ 
/* 295 */     if ((enumerations == null) || (enumerations.size() == 0)) {
/* 296 */       return;
/*     */     }
/* 298 */     String packageName = service.getPackageName();
/* 299 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "model";
/* 300 */     FileUtil.createDir(outputDir);
/* 301 */     String fileName = outputDir + File.separator + entity.getEntityName() + ".java";
/*     */ 
/* 303 */     Writer writer = null;
/*     */     try {
/* 305 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 307 */       this.log.error("Problem output file: " + fileName);
/* 308 */       e.printStackTrace();
/*     */     }
/* 310 */     getTemplateHelp().process("enumeration" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void generateConversion(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 319 */     if ((entity.getChildEntity() == null) || (entity.getChildEntity().size() == 0)) {
/* 320 */       return;
/*     */     }
/* 322 */     String packageName = service.getPackageName();
/* 323 */     String outputDir = getDestdir(0) + File.separator + packageName.replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "model";
/* 324 */     String fileName = outputDir + File.separator + entity.getEntityName() + "-conversion.properties";
/*     */ 
/* 326 */     Writer writer = null;
/*     */     try {
/* 328 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 330 */       this.log.error("Problem output file: " + fileName);
/* 331 */       e.printStackTrace();
/*     */     }
/* 333 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "conversion" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void generateAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService)
/*     */   {
/* 338 */     String outputDir = getDestdir(0) + File.separator + service.getPackageName().replaceAll("[.]", new StringBuilder("\\").append(File.separator).toString()) + File.separator + "action";
/* 339 */     String frameworkOutputDir = outputDir + File.separator + this.viewType;
/* 340 */     FileUtil.createDir(frameworkOutputDir);
/*     */ 
/* 342 */     String fileName = outputDir + File.separator + entity.getEntityName() + "PageInfo.java";
/* 343 */     Writer writer = null;
/*     */     try {
/* 345 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 347 */       this.log.error("Problem output file: " + fileName);
/* 348 */       e.printStackTrace();
/*     */     }
/* 350 */     getTemplateHelp().process("action" + File.separator + "pageinfo" + getTemplateHelp().getFileSuffix(), writer);
/* 351 */     if (this.viewType.equals("struts")) {
/* 352 */       createFrameworkAction(entity, service, serviceTool, allService, frameworkOutputDir);
/* 353 */     } else if (this.viewType.equals("webwork")) {
/* 354 */       createFrameworkViewAction(entity, service, serviceTool, allService, frameworkOutputDir);
/* 355 */       createFrameworkSaveAction(entity, service, serviceTool, allService, frameworkOutputDir);
/* 356 */       createFrameworkRemoveAction(entity, service, serviceTool, allService, frameworkOutputDir);
/* 357 */       createFrameworkListAction(entity, service, serviceTool, allService, frameworkOutputDir);
/* 358 */       createFrameworkRemoveAllAction(entity, service, serviceTool, allService, frameworkOutputDir);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void createFrameworkAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir)
/*     */   {
/* 364 */     String fileName = outputDir + File.separator + entity.getEntityName() + "Action.java";
/* 365 */     Writer writer = null;
/*     */ 
/* 367 */     if (FileUtil.exists(fileName))
/* 368 */       return;
/*     */     try
/*     */     {
/* 371 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 373 */       this.log.error("Problem output file: " + fileName);
/* 374 */       e.printStackTrace();
/*     */     }
/* 376 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "action" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkViewAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir) {
/* 380 */     String fileName = outputDir + File.separator + entity.getEntityName() + "ViewAction.java";
/* 381 */     Writer writer = null;
/*     */ 
/* 383 */     if (FileUtil.exists(fileName))
/* 384 */       return;
/*     */     try
/*     */     {
/* 387 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 389 */       this.log.error("Problem output file: " + fileName);
/* 390 */       e.printStackTrace();
/*     */     }
/* 392 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "viewaction" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkSaveAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir) {
/* 396 */     String fileName = outputDir + File.separator + entity.getEntityName() + "SaveAction.java";
/* 397 */     Writer writer = null;
/*     */ 
/* 399 */     if (FileUtil.exists(fileName))
/* 400 */       return;
/*     */     try
/*     */     {
/* 403 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 405 */       this.log.error("Problem output file: " + fileName);
/* 406 */       e.printStackTrace();
/*     */     }
/* 408 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "saveaction" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkRemoveAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir)
/*     */   {
/* 413 */     String fileName = outputDir + File.separator + entity.getEntityName() + "RemoveAction.java";
/* 414 */     Writer writer = null;
/*     */ 
/* 416 */     if (FileUtil.exists(fileName))
/* 417 */       return;
/*     */     try
/*     */     {
/* 420 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 422 */       this.log.error("Problem output file: " + fileName);
/* 423 */       e.printStackTrace();
/*     */     }
/* 425 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "removeaction" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkListAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir)
/*     */   {
/* 430 */     String fileName = outputDir + File.separator + entity.getEntityName() + "ListAction.java";
/* 431 */     Writer writer = null;
/*     */ 
/* 433 */     if (FileUtil.exists(fileName))
/* 434 */       return;
/*     */     try
/*     */     {
/* 437 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 439 */       this.log.error("Problem output file: " + fileName);
/* 440 */       e.printStackTrace();
/*     */     }
/* 442 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "listaction" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   protected void createFrameworkRemoveAllAction(Entity entity, Service service, ServiceTool serviceTool, Map<String, Service> allService, String outputDir)
/*     */   {
/* 447 */     String fileName = outputDir + File.separator + entity.getEntityName() + "RemoveAllAction.java";
/* 448 */     Writer writer = null;
/*     */ 
/* 450 */     if (FileUtil.exists(fileName))
/* 451 */       return;
/*     */     try
/*     */     {
/* 454 */       writer = new FileWriter(fileName);
/*     */     } catch (IOException e) {
/* 456 */       this.log.error("Problem output file: " + fileName);
/* 457 */       e.printStackTrace();
/*     */     }
/* 459 */     getTemplateHelp().process("action" + File.separator + this.viewType + File.separator + "removeallaction" + getTemplateHelp().getFileSuffix(), writer);
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 466 */     return "生成Java代码";
/*     */   }
/*     */ 
/*     */   public String getOrmType() {
/* 470 */     return this.ormType;
/*     */   }
/*     */ 
/*     */   public void setOrmType(String ormType) {
/* 474 */     this.ormType = ormType;
/*     */   }
/*     */ 
/*     */   public String getViewType() {
/* 478 */     return this.viewType;
/*     */   }
/*     */ 
/*     */   public void setViewType(String viewType) {
/* 482 */     this.viewType = viewType;
/*     */   }
/*     */ 
/*     */   public Integer getSort()
/*     */   {
/* 487 */     return new Integer(3);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.ant.GenJavaTask
 * JD-Core Version:    0.6.0
 */