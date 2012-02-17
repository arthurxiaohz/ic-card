/*     */ package org.hi.metadata.hsc.context;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.common.util.JAXBUtil;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.ObjectFactory;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.metadata.hsc.util.ServiceFilenameFilter;
/*     */ 
/*     */ public class ServiceFactory extends ObjectFactory
/*     */ {
/*     */   public static final String SERVICE_CONFIG_FILES_DIR_NAME = "config";
/*     */   public static final String SERVICE_CONFIG_FILES_DIR = "generater/config";
/*  39 */   protected static final Log logger = LogFactory.getLog("org.hi.generator.context.ServiceFactory");
/*     */   public static final String SERVICE_CONFIG_FILE_SUFFIX = "hsc.xml";
/*     */ 
/*     */   public static Service loadService(String pathFile)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/*  53 */     Object obj = JAXBUtil.loadObect(Service.class, pathFile);
/*  54 */     return (Service)obj;
/*     */   }
/*     */ 
/*     */   public static Service loadService(InputStream fileInputStream) throws FileNotFoundException, JAXBException {
/*  58 */     Object obj = JAXBUtil.loadObect(Service.class, fileInputStream);
/*  59 */     return (Service)obj;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadAllService(Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/*  70 */     Map result = new HashMap();
/*     */ 
/*  72 */     result.putAll(loadSystemServiceMap());
/*  73 */     result.putAll(loadCustomerServiceMap(environment));
/*     */ 
/*  75 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Entity> loadAllEnumeration(Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/*  86 */     return loadAllEnumeration(loadAllService(environment));
/*     */   }
/*     */ 
/*     */   public static Map<String, Entity> loadAllEnumeration(Map<String, Service> allServices)
/*     */   {
/*  94 */     Map result = new HashMap();
/*  95 */     Set allServiceKey = allServices.keySet();
/*  96 */     for (String key : allServiceKey) {
/*  97 */       Service service = (Service)allServices.get(key);
/*     */ 
/*  99 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/* 102 */       for (Entity entity : service.getEntity()) {
/* 103 */         if (entity.getEntityType() == 2)
/* 104 */           result.put(entity.getEntityName(), entity);
/*     */       }
/*     */     }
/* 107 */     return result;
/*     */   }
/*     */ 
/*     */   public static Service getService(Entity entity, Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/* 119 */     return getService(entity, loadAllService(environment));
/*     */   }
/*     */ 
/*     */   public static Service getService(Entity entity, Map<String, Service> allServices)
/*     */   {
/* 129 */     Set allServiceKey = allServices.keySet();
/* 130 */     for (String key : allServiceKey) {
/* 131 */       Service service = (Service)allServices.get(key);
/*     */ 
/* 133 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/* 136 */       for (Entity tagEntity : service.getEntity()) {
/* 137 */         if (tagEntity.getEntityName().equals(entity.getEntityName()))
/* 138 */           return service;
/*     */       }
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   public static List<Service> loadSystemService()
/*     */     throws JAXBException, IOException
/*     */   {
/* 151 */     List result = new ArrayList();
/*     */ 
/* 166 */     InputStream servicesStream = ServiceFactory.class.getResourceAsStream("services.properties");
/* 167 */     if (servicesStream == null) {
/* 168 */       return null;
/*     */     }
/* 170 */     BufferedReader r = new BufferedReader(new InputStreamReader(servicesStream, "UTF-8"));
/*     */     String serviceFileName;
/* 172 */     while ((serviceFileName = r.readLine()) != null) {
/* 173 */       String serviceFileName = serviceFileName.trim();
/* 174 */       InputStream serivceInputStream = ServiceFactory.class.getResourceAsStream(serviceFileName);
/* 175 */       Service service = loadService(serivceInputStream);
/* 176 */       result.add(service);
/*     */     }
/*     */ 
/* 179 */     r.close();
/*     */ 
/* 181 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadSystemServiceMap()
/*     */     throws JAXBException, IOException
/*     */   {
/* 192 */     Map result = new HashMap();
/*     */ 
/* 194 */     List systemServices = loadSystemService();
/*     */ 
/* 196 */     for (Iterator iter = systemServices.iterator(); iter.hasNext(); ) {
/* 197 */       Service service = (Service)iter.next();
/* 198 */       result.put(service.getServiceName(), service);
/*     */     }
/*     */ 
/* 202 */     return result;
/*     */   }
/*     */ 
/*     */   public static List<Service> loadCustomerService(Environment environment)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/* 215 */     List result = new ArrayList();
/*     */ 
/* 218 */     String dirStr = environment.getDir();
/*     */ 
/* 220 */     File customerDir = new File(dirStr);
/*     */ 
/* 222 */     File[] customerFiles = customerDir.listFiles(new ServiceFilenameFilter());
/* 223 */     if (customerFiles != null)
/*     */     {
/* 225 */       for (int i = 0; i < customerFiles.length; i++) {
/* 226 */         Service service = loadService(customerFiles[i].toString());
/* 227 */         result.add(service);
/*     */       }
/*     */     }
/* 230 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadCustomerServiceMap(Environment environment)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/* 243 */     Map result = new HashMap();
/*     */ 
/* 245 */     List customerServices = loadCustomerService(environment);
/*     */ 
/* 247 */     for (Iterator iter = customerServices.iterator(); iter.hasNext(); ) {
/* 248 */       Service service = (Service)iter.next();
/* 249 */       result.put(service.getServiceName(), service);
/*     */     }
/* 251 */     return result;
/*     */   }
/*     */ 
/*     */   public static void writeServiceXML(String serviceFile, Service service)
/*     */     throws JAXBException, IOException
/*     */   {
/* 263 */     JAXBUtil.writeObject(Service.class, service, serviceFile);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.metadata.hsc.context.ServiceFactory
 * JD-Core Version:    0.6.0
 */