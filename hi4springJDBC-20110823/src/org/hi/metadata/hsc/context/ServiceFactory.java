/*     */ package org.hi.metadata.hsc.context;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
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
/*  36 */   protected static final Log logger = LogFactory.getLog("org.hi.generator.context.ServiceFactory");
/*     */   public static final String SERVICE_CONFIG_FILE_SUFFIX = "hsc.xml";
/*     */ 
/*     */   public static Service loadService(String pathFile)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/*  50 */     Object obj = JAXBUtil.loadObect(Service.class, pathFile);
/*  51 */     return (Service)obj;
/*     */   }
/*     */ 
/*     */   public static Service loadService(InputStream fileInputStream) throws FileNotFoundException, JAXBException {
/*  55 */     Object obj = JAXBUtil.loadObect(Service.class, fileInputStream);
/*  56 */     return (Service)obj;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadAllService(Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/*  67 */     Map result = new HashMap();
/*     */ 
/*  69 */     result.putAll(loadSystemServiceMap());
/*  70 */     result.putAll(loadCustomerServiceMap(environment));
/*     */ 
/*  72 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Entity> loadAllEnumeration(Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/*  83 */     return loadAllEnumeration(loadAllService(environment));
/*     */   }
/*     */ 
/*     */   public static Map<String, Entity> loadAllEnumeration(Map<String, Service> allServices)
/*     */   {
/*  91 */     Map result = new HashMap();
/*  92 */     Set allServiceKey = allServices.keySet();
/*  93 */     for (String key : allServiceKey) {
/*  94 */       Service service = (Service)allServices.get(key);
/*     */ 
/*  96 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/*  99 */       for (Entity entity : service.getEntity()) {
/* 100 */         if (entity.getEntityType() == 2)
/* 101 */           result.put(entity.getEntityName(), entity);
/*     */       }
/*     */     }
/* 104 */     return result;
/*     */   }
/*     */ 
/*     */   public static Service getService(Entity entity, Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/* 116 */     return getService(entity, loadAllService(environment));
/*     */   }
/*     */ 
/*     */   public static Service getService(Entity entity, Map<String, Service> allServices)
/*     */   {
/* 126 */     Set allServiceKey = allServices.keySet();
/* 127 */     for (String key : allServiceKey) {
/* 128 */       Service service = (Service)allServices.get(key);
/*     */ 
/* 130 */       if ((service.getEntity() == null) || (service.getEntity().size() == 0)) {
/*     */         continue;
/*     */       }
/* 133 */       for (Entity tagEntity : service.getEntity()) {
/* 134 */         if (tagEntity.getEntityName().equals(entity.getEntityName()))
/* 135 */           return service;
/*     */       }
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */   public static List<Service> loadSystemService()
/*     */     throws JAXBException, IOException
/*     */   {
/* 148 */     List result = new ArrayList();
/*     */ 
/* 163 */     InputStream servicesStream = ServiceFactory.class.getResourceAsStream("services.properties");
/* 164 */     if (servicesStream == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     BufferedReader r = new BufferedReader(new InputStreamReader(servicesStream, "UTF-8"));
/*     */     String serviceFileName;
/* 169 */     while ((serviceFileName = r.readLine()) != null) {
/* 170 */       String serviceFileName = serviceFileName.trim();
/* 171 */       InputStream serivceInputStream = ServiceFactory.class.getResourceAsStream(serviceFileName);
/* 172 */       Service service = loadService(serivceInputStream);
/* 173 */       result.add(service);
/*     */     }
/*     */ 
/* 176 */     r.close();
/*     */ 
/* 178 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadSystemServiceMap()
/*     */     throws JAXBException, IOException
/*     */   {
/* 189 */     Map result = new HashMap();
/*     */ 
/* 191 */     List systemServices = loadSystemService();
/*     */ 
/* 193 */     for (Iterator iter = systemServices.iterator(); iter.hasNext(); ) {
/* 194 */       Service service = (Service)iter.next();
/* 195 */       result.put(service.getServiceName(), service);
/*     */     }
/*     */ 
/* 199 */     return result;
/*     */   }
/*     */ 
/*     */   public static List<Service> loadCustomerService(Environment environment)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/* 212 */     List result = new ArrayList();
/* 213 */     String dirStr = environment.getDir();
/* 214 */     File customerDir = new File(dirStr);
/*     */ 
/* 216 */     if (!customerDir.exists()) {
/* 217 */       URL metadataUrl = ServiceFactory.class.getClassLoader().getResource("../metadata");
/*     */       try {
/* 219 */         customerDir = new File(metadataUrl.toURI());
/*     */       } catch (URISyntaxException localURISyntaxException) {
/*     */       }
/*     */     }
/* 223 */     File[] customerFiles = customerDir.listFiles(new ServiceFilenameFilter());
/* 224 */     if (customerFiles != null)
/*     */     {
/* 226 */       for (int i = 0; i < customerFiles.length; i++) {
/* 227 */         Service service = loadService(customerFiles[i].toString());
/* 228 */         result.add(service);
/*     */       }
/*     */     }
/* 231 */     return result;
/*     */   }
/*     */ 
/*     */   public static Map<String, Service> loadCustomerServiceMap(Environment environment)
/*     */     throws FileNotFoundException, JAXBException
/*     */   {
/* 244 */     Map result = new HashMap();
/*     */ 
/* 246 */     List customerServices = loadCustomerService(environment);
/*     */ 
/* 248 */     for (Iterator iter = customerServices.iterator(); iter.hasNext(); ) {
/* 249 */       Service service = (Service)iter.next();
/* 250 */       result.put(service.getServiceName(), service);
/*     */     }
/* 252 */     return result;
/*     */   }
/*     */ 
/*     */   public static void writeServiceXML(String serviceFile, Service service)
/*     */     throws JAXBException, IOException
/*     */   {
/* 264 */     JAXBUtil.writeObject(Service.class, service, serviceFile);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.metadata.hsc.context.ServiceFactory
 * JD-Core Version:    0.6.0
 */