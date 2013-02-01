/*     */ package org.hi.framework.spring;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.util.FrameworkBossJarUtil;
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
/*  34 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   protected WebApplicationContext createWebApplicationContext(ServletContext servletContext, ApplicationContext parent)
/*     */     throws BeansException
/*     */   {
/*  41 */     List jarUrls = new ArrayList();
/*     */ 
/*  44 */     if (HiConfigHolder.getJarFile() != null) {
/*  45 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*  46 */       for (String jarFileName : jars) {
/*  47 */         String hiJarUrl = null;
/*     */         try
/*     */         {
/*  54 */           hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarPath();
/*  55 */           if (hiJarUrl != null)
/*  56 */             jarUrls.add(URLDecoder.decode(hiJarUrl, "utf-8"));
/*     */         }
/*     */         catch (Exception e) {
/*  59 */           this.logger.error("error:load jar file  == " + jarFileName);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  66 */     Class contextClass = determineContextClass(servletContext);
/*  67 */     if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
/*  68 */       throw new ApplicationContextException("Custom context class [" + contextClass.getName() + 
/*  69 */         "] is not of type ConfigurableWebApplicationContext");
/*     */     }
/*     */ 
/*  72 */     List allResources = new ArrayList();
/*  73 */     ConfigurableWebApplicationContext wac = 
/*  74 */       (ConfigurableWebApplicationContext)BeanUtils.instantiateClass(contextClass);
/*  75 */     wac.setParent(parent);
/*  76 */     wac.setServletContext(servletContext);
/*  77 */     String configLocation = servletContext.getInitParameter("contextConfigLocation");
/*     */ 
/*  79 */     if (configLocation != null) {
/*  80 */       String[] resources = StringUtils.tokenizeToStringArray(configLocation, ",; \t\n");
/*     */ 
/*  83 */       for (int i = 0; i < resources.length; i++) {
/*  84 */         if ((resources[i] == null) || (resources[i].equals("")))
/*     */           continue;
/*  86 */         if (resources[i].toUpperCase().indexOf("WEB-INF") >= 0) {
/*  87 */           allResources.add(resources[i]);
/*     */         }
/*     */       }
/*     */ 
/*  91 */       if (jarUrls.size() > 0) {
/*  92 */         for (String hiJarUrl : jarUrls) {
/*  93 */           if (hiJarUrl == null)
/*     */             continue;
/*  95 */           Resource[] jarResources = JarResource.getInstance(new File(hiJarUrl), "*appContext-*.xml");
/*  96 */           for (Resource resource : jarResources) {
/*     */             try {
/*  98 */               allResources.add(resource.getURL().toString());
/*     */             }
/*     */             catch (IOException localIOException)
/*     */             {
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 107 */       for (int i = 0; i < resources.length; i++) {
/* 108 */         if ((resources[i] == null) || (resources[i].equals("")))
/*     */           continue;
/* 110 */         if (resources[i].toUpperCase().indexOf("WEB-INF") < 0) {
/* 111 */           allResources.add(resources[i]);
/*     */         }
/*     */       }
/* 114 */       wac.setConfigLocations((String[])allResources.toArray(new String[allResources.size()]));
/*     */     }
/*     */ 
/* 117 */     wac.refresh();
/* 118 */     return wac;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.spring.ContextLoader
 * JD-Core Version:    0.6.0
 */