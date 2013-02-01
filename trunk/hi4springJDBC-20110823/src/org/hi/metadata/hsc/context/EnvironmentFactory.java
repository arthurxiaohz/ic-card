/*     */ package org.hi.metadata.hsc.context;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.common.util.JAXBUtil;
/*     */ import org.hi.metadata.hsc.context.environment.Environment;
/*     */ import org.hi.metadata.hsc.context.environment.ObjectFactory;
/*     */ 
/*     */ public class EnvironmentFactory extends ObjectFactory
/*     */ {
/*     */   public static final String ENVIRONMENT_DIRECTORY = "generater";
/*     */   public static final String ENVIRONMENT_FILE_NAME = "environment.xml";
/*  54 */   public static final String TEMPLATES_DIR = "generater" + File.separator + "templates";
/*     */ 
/*  59 */   public static final String TEMPORARY_DIR = "generater" + File.separator + "temp";
/*     */ 
/*  64 */   public static final String ENVIRONMENT_CONFIG_XML_FILE = "generater" + File.separator + "config/" + "environment.xml";
/*     */ 
/*  66 */   protected static final Log logger = LogFactory.getLog("org.hi.generator.context.EnvironmentFactory");
/*     */ 
/*     */   public static Environment loadEnvironment()
/*     */     throws JAXBException, FileNotFoundException
/*     */   {
/*  74 */     return loadEnvironment(ENVIRONMENT_CONFIG_XML_FILE);
/*     */   }
/*     */ 
/*     */   public static Environment loadEnvironment(String environmentFile)
/*     */     throws JAXBException, FileNotFoundException
/*     */   {
/*  85 */     Object obj = JAXBUtil.loadObect(Environment.class, environmentFile);
/*  86 */     return (Environment)obj;
/*     */   }
/*     */ 
/*     */   public static Environment loadServletEnvironment(String servletRootDir)
/*     */     throws JAXBException, FileNotFoundException
/*     */   {
/*  96 */     File dir = new File(servletRootDir + File.separator + "WEB-INF/config");
/*  97 */     if (!dir.isDirectory()) {
/*  98 */       dir = new File(servletRootDir + File.separator + "/config");
/*     */     }
/*     */ 
/* 101 */     File[] files = dir.listFiles(new FilenameFilter()
/*     */     {
/*     */       public boolean accept(File dir, String name) {
/* 104 */         return name.equals("environment.xml");
/*     */       }
/*     */     });
/* 108 */     if (files.length != 1) {
/* 109 */       return null;
/*     */     }
/* 111 */     Object obj = JAXBUtil.loadObect(Environment.class, files[0].toString());
/* 112 */     return (Environment)obj;
/*     */   }
/*     */ 
/*     */   public static void writeEnvironmentXML(String environmentFile, Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/* 123 */     JAXBUtil.writeObject(Environment.class, environment, environmentFile);
/*     */   }
/*     */ 
/*     */   public static void writeEnvironmentXml(Environment environment)
/*     */     throws JAXBException, IOException
/*     */   {
/* 133 */     writeEnvironmentXML(ENVIRONMENT_CONFIG_XML_FILE, environment);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.metadata.hsc.context.EnvironmentFactory
 * JD-Core Version:    0.6.0
 */