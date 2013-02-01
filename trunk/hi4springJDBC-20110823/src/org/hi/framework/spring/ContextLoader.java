/*     */ package org.hi.framework.spring;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import org.springframework.beans.BeansException;
/*     */ import org.springframework.context.ApplicationContext;
/*     */ import org.springframework.context.ApplicationContextException;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.context.ConfigurableWebApplicationContext;
/*     */ import org.springframework.web.context.WebApplicationContext;
/*     */ 
/*     */ public class ContextLoader extends org.springframework.web.context.ContextLoader
/*     */ {
/*  33 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   protected WebApplicationContext createWebApplicationContext(ServletContext servletContext, ApplicationContext parent)
/*     */     throws BeansException
/*     */   {
/*  40 */     List jarUrls = new ArrayList();
/*     */ 
/*  43 */     if (HiConfigHolder.getJarFile() != null) {
/*  44 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*  45 */       for (String jarFileName : jars) {
/*  46 */         String hiJarUrl = null;
/*     */         try {
/*  48 */           File classFile = new File(getClass().getClassLoader().getResource("").toURI());
/*  49 */           hiJarUrl = new URL(classFile.getParentFile().toURI().toString() + "/lib/" + jarFileName).getFile();
/*  50 */           if (hiJarUrl != null)
/*  51 */             jarUrls.add(URLDecoder.decode(hiJarUrl, "utf-8"));
/*     */         }
/*     */         catch (Exception e) {
/*  54 */           this.logger.error("error:load jar file  == " + jarFileName);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  61 */     Class contextClass = determineContextClass(servletContext);
/*  62 */     if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
/*  63 */       throw new ApplicationContextException("Custom context class [" + contextClass.getName() + 
/*  64 */         "] is not of type ConfigurableWebApplicationContext");
/*     */     }
/*     */ 
/*  67 */     List allResources = new ArrayList();
/*  68 */     ConfigurableWebApplicationContext wac = 
/*  69 */       (ConfigurableWebApplicationContext)BeanUtils.instantiateClass(contextClass);
/*  70 */     wac.setParent(parent);
/*  71 */     wac.setServletContext(servletContext);
/*  72 */     String configLocation = servletContext.getInitParameter("contextConfigLocation");
/*     */ 
/*  74 */     if (configLocation != null) {
/*  75 */       String[] resources = StringUtils.tokenizeToStringArray(configLocation, ",; \t\n");
/*     */ 
/*  78 */       for (int i = 0; i < resources.length; i++) {
/*  79 */         if ((resources[i] == null) || (resources[i].equals("")))
/*     */           continue;
/*  81 */         if (resources[i].toUpperCase().indexOf("WEB-INF") >= 0) {
/*  82 */           allResources.add(resources[i]);
/*     */         }
/*     */       }
/*     */ 
/*  86 */       if (jarUrls.size() > 0) {
/*  87 */         for (String hiJarUrl : jarUrls) {
/*  88 */           if (hiJarUrl == null)
/*     */             continue;
/*  90 */           Resource[] jarResources = JarResource.getInstance(new File(hiJarUrl), "*appContext-*.xml");
/*  91 */           for (Resource resource : jarResources) {
/*     */             try {
/*  93 */               allResources.add(resource.getURL().toString());
/*     */             }
/*     */             catch (IOException localIOException)
/*     */             {
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 102 */       for (int i = 0; i < resources.length; i++) {
/* 103 */         if ((resources[i] == null) || (resources[i].equals("")))
/*     */           continue;
/* 105 */         if (resources[i].toUpperCase().indexOf("WEB-INF") < 0) {
/* 106 */           allResources.add(resources[i]);
/*     */         }
/*     */       }
/* 109 */       wac.setConfigLocations((String[])allResources.toArray(new String[allResources.size()]));
/*     */     }
/*     */ 
/* 112 */     wac.refresh();
/* 113 */     return wac;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.spring.ContextLoader
 * JD-Core Version:    0.6.0
 */