/*     */ package org.hi.metadata.hsc;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.service.ChildEntity;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ExtendEntity;
/*     */ import org.hi.metadata.hsc.context.service.Field;
/*     */ import org.hi.metadata.hsc.context.service.LookupEntity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ 
/*     */ public class HSCHelper
/*     */ {
/*     */   private static Environment environment;
/*     */   private static Map<String, Service> allService;
/*  32 */   protected static final Log logger = LogFactory.getLog("org.hi.metadata.hsc.HSCHelper");
/*     */ 
/*  34 */   public static Map<String, Service> getAllService(String servletRootDir) throws JAXBException, IOException { getEnvironment(servletRootDir);
/*  35 */     if (allService == null)
/*  36 */       allService = ServiceFactory.loadAllService(environment);
/*  37 */     return allService; }
/*     */ 
/*     */   public static Map<String, Entity> getAllEnumeration(String servletRootDir) throws JAXBException, IOException
/*     */   {
/*  41 */     if (allService == null)
/*  42 */       getAllService(servletRootDir);
/*  43 */     return ServiceFactory.loadAllEnumeration(allService);
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> getServices(String servletRootDir) throws FileNotFoundException, JAXBException {
/*  47 */     getEnvironment(servletRootDir);
/*  48 */     return ServiceFactory.loadCustomerServiceMap(environment);
/*     */   }
/*     */ 
/*     */   public static List<Entity> getAllEntity(String servletRootDir) throws JAXBException, IOException {
/*  52 */     List entitis = new ArrayList();
/*  53 */     getAllService(servletRootDir);
/*  54 */     for (Map.Entry entry : allService.entrySet()) {
/*  55 */       entitis.addAll(((Service)entry.getValue()).getEntity());
/*     */     }
/*  57 */     return entitis;
/*     */   }
/*     */ 
/*     */   public static List<Entity> getEntities(String servletRootDir) throws JAXBException, IOException {
/*  61 */     List entitis = new ArrayList();
/*  62 */     Map services = getServices(servletRootDir);
/*  63 */     for (Map.Entry entry : services.entrySet()) {
/*  64 */       entitis.addAll(((Service)entry.getValue()).getEntity());
/*     */     }
/*  66 */     return entitis;
/*     */   }
/*     */ 
/*     */   public static Entity getEntity(String servletRootDir, Class clazz) throws JAXBException, IOException
/*     */   {
/*  71 */     Map services = getAllService(servletRootDir);
/*  72 */     for (Map.Entry entry : services.entrySet()) {
/*  73 */       Service service = (Service)entry.getValue();
/*  74 */       List entits = service.getEntity();
/*  75 */       for (Entity entity : entits) {
/*  76 */         if ((entity.getEntityName().equals(clazz.getSimpleName())) && 
/*  77 */           (clazz.getName().contains(service.getPackageName())))
/*  78 */           return entity;
/*     */       }
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   public static Field getField(String servletRootDir, Class clazz, String propertyName) throws JAXBException, IOException {
/*  85 */     Entity entity = getEntity(servletRootDir, clazz);
/*  86 */     return getField(servletRootDir, entity, propertyName);
/*     */   }
/*     */ 
/*     */   public static Field getField(String servletRootDir, Entity entity, String propertyName) throws JAXBException, IOException {
/*  90 */     String[] propertis = propertyName.split("[.]");
/*     */ 
/*  92 */     Field currentField = null;
/*     */ 
/*  94 */     for (Field field : entity.getField()) {
/*  95 */       if (field.getFieldName().equals(propertis[0])) {
/*  96 */         currentField = field;
/*     */       }
/*     */     }
/*  99 */     if (propertis.length == 1) {
/* 100 */       return currentField;
/*     */     }
/* 102 */     String entityName = currentField.getLookupEntity().getLkEntityName();
/* 103 */     String serviceName = currentField.getLookupEntity().getLkServiceName();
/* 104 */     Entity domainEntity = getEntity(servletRootDir, entityName, serviceName);
/* 105 */     String domainPropertyName = "";
/* 106 */     for (int i = 1; i <= propertis.length - 1; i++) {
/* 107 */       domainPropertyName = domainPropertyName + propertis[i];
/*     */     }
/*     */ 
/* 110 */     return getField(servletRootDir, domainEntity, domainPropertyName);
/*     */   }
/*     */ 
/*     */   public static Entity getEntity(String servletRootDir, String entityName, String serviceName) throws JAXBException, IOException {
/* 114 */     Map services = getAllService(servletRootDir);
/* 115 */     for (Map.Entry entry : services.entrySet()) {
/* 116 */       Service service = (Service)entry.getValue();
/* 117 */       List entits = service.getEntity();
/* 118 */       for (Entity entity : entits) {
/* 119 */         if ((entity.getEntityName().equals(entityName)) && 
/* 120 */           (service.getServiceName().equals(serviceName)))
/* 121 */           return entity;
/*     */       }
/*     */     }
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */   public static Entity getEntity(String servletRootDir, String entityName) throws JAXBException, IOException {
/* 128 */     Map services = getAllService(servletRootDir);
/* 129 */     for (Map.Entry entry : services.entrySet()) {
/* 130 */       Service service = (Service)entry.getValue();
/* 131 */       List entits = service.getEntity();
/* 132 */       for (Entity entity : entits) {
/* 133 */         if (entity.getEntityName().equals(entityName))
/* 134 */           return entity;
/*     */       }
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ 
/*     */   public static List<Entity> getItemEntities(String servletRootDir, Class clazz)
/*     */     throws JAXBException, IOException
/*     */   {
/* 149 */     List result = new ArrayList();
/* 150 */     Entity masterEntity = getEntity(servletRootDir, clazz);
/* 151 */     List childs = masterEntity.getChildEntity();
/* 152 */     for (ChildEntity childEntity : childs) {
/* 153 */       result.add(getEntity(servletRootDir, childEntity.getChildEntityName(), childEntity.getChildServiceName()));
/*     */     }
/* 155 */     return result;
/*     */   }
/*     */ 
/*     */   public static Entity getParentEntity(String servletRootDir, Class clazz)
/*     */     throws JAXBException, IOException
/*     */   {
/* 167 */     Entity entity = getEntity(servletRootDir, clazz);
/* 168 */     ExtendEntity exEntity = entity.getExtendEntity();
/* 169 */     if ((exEntity == null) || (exEntity.getExtendEntityName() == null) || (exEntity.getExtendEntityName().trim().equals("")) || 
/* 170 */       (exEntity.getExtendServiceName() == null) || (exEntity.getExtendServiceName().trim().equals(""))) {
/* 171 */       return null;
/*     */     }
/* 173 */     return getEntity(servletRootDir, exEntity.getExtendEntityName(), exEntity.getExtendServiceName());
/*     */   }
/*     */ 
/*     */   public static Entity getMasterEntity(String servletRootDir, Class clazz)
/*     */     throws JAXBException, IOException
/*     */   {
/* 185 */     Entity entity = getEntity(servletRootDir, clazz);
/* 186 */     List fields = entity.getField();
/* 187 */     for (Field field : fields)
/* 188 */       if (field.isIsParent()) {
/* 189 */         String masterEntityName = field.getLookupEntity().getLkEntityName();
/* 190 */         String masterServiceName = field.getLookupEntity().getLkServiceName();
/* 191 */         return getEntity(servletRootDir, masterEntityName, masterServiceName);
/*     */       }
/* 193 */     return null;
/*     */   }
/*     */ 
/*     */   public static Class getEntityClass(String servletRootDir, Entity entity) throws ClassNotFoundException, JAXBException, IOException {
/* 197 */     getAllService(servletRootDir);
/* 198 */     String packageName = null;
/* 199 */     for (Map.Entry entry : allService.entrySet()) {
/* 200 */       Service service = (Service)entry.getValue();
/*     */ 
/* 202 */       for (Entity _entity : service.getEntity()) {
/* 203 */         if ((_entity.getEntityName().equals(entity.getEntityName())) && (_entity.getTableName().equals(entity.getTableName()))) {
/* 204 */           packageName = service.getPackageName();
/* 205 */           break;
/*     */         }
/*     */       }
/*     */ 
/* 209 */       if (packageName != null) {
/*     */         break;
/*     */       }
/*     */     }
/* 213 */     if (packageName == null) {
/* 214 */       return null;
/*     */     }
/* 216 */     String className = packageName + ".model." + entity.getEntityName();
/* 217 */     return Class.forName(className.trim());
/*     */   }
/*     */ 
/*     */   private static Environment getEnvironment(String servletRootDir) throws FileNotFoundException, JAXBException {
/* 221 */     if (environment == null)
/* 222 */       environment = EnvironmentFactory.loadServletEnvironment(servletRootDir);
/* 223 */     return environment;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.HSCHelper
 * JD-Core Version:    0.6.0
 */