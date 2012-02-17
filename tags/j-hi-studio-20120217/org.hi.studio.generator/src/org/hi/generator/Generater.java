/*     */ package org.hi.generator;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.common.util.FileUtil;
/*     */ import org.hi.generator.impl.GeneraterImpl;
/*     */ import org.hi.metadata.hsc.context.EnvironmentFactory;
/*     */ import org.hi.metadata.hsc.context.ServiceFactory;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.hi.metadata.hsc.context.service.Service;
/*     */ import org.hi.metadata.hsc.util.ServiceFilenameFilter;
/*     */ import org.springframework.util.StringUtils;
/*     */ 
/*     */ public class Generater
/*     */ {
/*     */   protected Environment environment;
/*     */   protected static String[] serviceNames;
/*  38 */   protected final Log log = LogFactory.getLog(getClass());
/*     */   protected Map<String, Service> allServices;
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws JAXBException, IOException
/*     */   {
/*  42 */     Generater generaer = new GeneraterImpl();
/*  43 */     generaer.argsProcess(args);
/*  44 */     generaer.run();
/*     */   }
/*     */ 
/*     */   private void argsProcess(String[] args)
/*     */   {
/*  49 */     if (!args[0].equals("null")) {
/*  50 */       serviceNames = StringUtils.tokenizeToStringArray(args[0], ",");
/*     */     }
/*     */     else {
/*  53 */       File serviceDir = new File("hsc.xml");
/*  54 */       serviceNames = serviceDir.list(new ServiceFilenameFilter());
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void run() throws JAXBException, IOException {
/*  59 */     setEnvironment();
/*  60 */     this.allServices = ServiceFactory.loadAllService(this.environment);
/*  61 */     building(readService());
/*     */   }
/*     */ 
/*     */   protected void building(List<Service> services) throws IOException {
/*  65 */     init();
/*     */ 
/*  78 */     genAntBuilder();
/*     */   }
/*     */ 
/*     */   protected void genHibneateHbm(Service service, Entity entity)
/*     */     throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void genHibneateConfig(List<Service> services)
/*     */     throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void genAntBuilder() throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void init() throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void setEnvironment() throws JAXBException, FileNotFoundException
/*     */   {
/* 101 */     this.environment = EnvironmentFactory.loadEnvironment();
/*     */   }
/*     */ 
/*     */   protected List<Service> readService()
/*     */     throws JAXBException, FileNotFoundException
/*     */   {
/* 111 */     List services = new ArrayList();
/*     */ 
/* 113 */     for (int i = 0; i < serviceNames.length; i++) {
/* 114 */       String serviceName = serviceNames[i];
/* 115 */       Service service = ServiceFactory.loadService("hsc.xml" + File.separator + serviceName);
/* 116 */       File file = new File("hsc.xml" + File.separator + serviceName);
/* 117 */       File outFile = new File(EnvironmentFactory.ENVIRONMENT_CONFIG_XML_FILE + File.separator + "temp" + File.separator + serviceName);
/*     */       try {
/* 119 */         FileUtil.copyFile(file, outFile);
/*     */       } catch (IOException localIOException) {
/* 121 */         this.log.error("copy file " + serviceName + "failing!");
/*     */       }
/* 123 */       services.add(service);
/*     */     }
/* 125 */     return services;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.generator.Generater
 * JD-Core Version:    0.6.0
 */