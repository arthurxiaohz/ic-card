/*     */ package org.hi.framework.dao.ibatis;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.core.io.UrlResource;
/*     */ import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
/*     */ 
/*     */ public class HiSqlMapClientFactoryBean extends SqlMapClientFactoryBean
/*     */ {
/*     */   private IbatisHiDialect dialect;
/*     */   private Resource[] mappingLocations;
/*     */   private Resource[] mappingJarLocations;
/*     */   private Properties properties;
/*     */   private Resource configLocation;
/*     */   private boolean sqlShow;
/*  33 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*  35 */   public IbatisHiDialect getDialect() { return this.dialect; }
/*     */ 
/*     */   public void setDialect(IbatisHiDialect dialect) {
/*  38 */     this.dialect = dialect;
/*     */   }
/*     */   public Resource[] getMappingLocations() {
/*  41 */     return this.mappingLocations;
/*     */   }
/*     */   public void setMappingLocations(Resource[] mappingLocations) {
/*  44 */     this.mappingLocations = mappingLocations;
/*     */   }
/*     */ 
/*     */   public Resource[] getMappingJarLocations() {
/*  48 */     return this.mappingJarLocations;
/*     */   }
/*     */   public void setMappingJarLocations(Resource[] mappingJarLocations) {
/*  51 */     this.mappingJarLocations = mappingJarLocations;
/*     */   }
/*     */ 
/*     */   public Properties getProperties() {
/*  55 */     return this.properties;
/*     */   }
/*     */   public void setProperties(Properties properties) {
/*  58 */     this.properties = properties;
/*     */   }
/*     */   public boolean isSqlShow() {
/*  61 */     return this.sqlShow;
/*     */   }
/*     */   public void setSqlShow(boolean sqlShow) {
/*  64 */     this.sqlShow = sqlShow;
/*     */   }
/*     */ 
/*     */   public void setConfigLocation(Resource configLocation) {
/*  68 */     this.configLocation = configLocation;
/*  69 */     super.setConfigLocation(configLocation);
/*     */   }
/*     */ 
/*     */   public ServletContext getServletContext() {
/*  73 */     return SpringContextHolder.getServletContext();
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws Exception
/*     */   {
/*  80 */     if (this.dialect == null) {
/*  81 */       String dialectValue = this.properties.getProperty("ibatis.dialect");
/*  82 */       if (dialectValue != null) {
/*  83 */         this.dialect = ((IbatisHiDialect)BeanUtil.CreateObject(dialectValue));
/*     */       }
/*     */     }
/*  86 */     List jarResource = new ArrayList();
/*     */ 
/*  88 */     Set jars = new LinkedHashSet();
/*  89 */     if (HiConfigHolder.getJarFile() != null) {
/*  90 */       jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
/*     */     }
/*     */ 
/*  93 */     if (this.mappingJarLocations != null) {
/*  94 */       for (Resource resource : this.mappingJarLocations) {
/*  95 */         if (jars.contains(resource.getFilename()))
/*     */           continue;
/*  97 */         jarResource.add(resource);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 103 */     for (String jarFileName : jars) {
/* 104 */       URL hiJarUrl = null;
/*     */       try {
/* 106 */         File classFile = new File(getClass().getClassLoader().getResource("").toURI());
/* 107 */         hiJarUrl = new URL(classFile.getParentFile().toURI().toString() + "/lib/" + jarFileName);
/* 108 */         if (hiJarUrl != null)
/* 109 */           jarResource.add(new UrlResource(hiJarUrl));
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 113 */         this.logger.error("error:load jar file  == " + jarFileName);
/*     */       }
/*     */     }
/*     */ 
/* 117 */     this.mappingJarLocations = ((Resource[])jarResource.toArray(new Resource[jarResource.size()]));
/*     */ 
/* 119 */     super.afterPropertiesSet();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.HiSqlMapClientFactoryBean
 * JD-Core Version:    0.6.0
 */