/*     */ package org.hi.framework.dao.ibatis;
/*     */ 
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
/*     */ import org.hi.framework.util.FrameworkBossJarUtil;
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
/*  34 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*  36 */   public IbatisHiDialect getDialect() { return this.dialect; }
/*     */ 
/*     */   public void setDialect(IbatisHiDialect dialect) {
/*  39 */     this.dialect = dialect;
/*     */   }
/*     */   public Resource[] getMappingLocations() {
/*  42 */     return this.mappingLocations;
/*     */   }
/*     */   public void setMappingLocations(Resource[] mappingLocations) {
/*  45 */     this.mappingLocations = mappingLocations;
/*     */   }
/*     */ 
/*     */   public Resource[] getMappingJarLocations() {
/*  49 */     return this.mappingJarLocations;
/*     */   }
/*     */   public void setMappingJarLocations(Resource[] mappingJarLocations) {
/*  52 */     this.mappingJarLocations = mappingJarLocations;
/*     */   }
/*     */ 
/*     */   public Properties getProperties() {
/*  56 */     return this.properties;
/*     */   }
/*     */   public void setProperties(Properties properties) {
/*  59 */     this.properties = properties;
/*     */   }
/*     */   public boolean isSqlShow() {
/*  62 */     return this.sqlShow;
/*     */   }
/*     */   public void setSqlShow(boolean sqlShow) {
/*  65 */     this.sqlShow = sqlShow;
/*     */   }
/*     */ 
/*     */   public void setConfigLocation(Resource configLocation) {
/*  69 */     this.configLocation = configLocation;
/*  70 */     super.setConfigLocation(configLocation);
/*     */   }
/*     */ 
/*     */   public ServletContext getServletContext() {
/*  74 */     return SpringContextHolder.getServletContext();
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws Exception
/*     */   {
/*  81 */     if (this.dialect == null) {
/*  82 */       String dialectValue = this.properties.getProperty("ibatis.dialect");
/*  83 */       if (dialectValue != null) {
/*  84 */         this.dialect = ((IbatisHiDialect)BeanUtil.CreateObject(dialectValue));
/*     */       }
/*     */     }
/*  87 */     List jarResource = new ArrayList();
/*     */ 
/*  89 */     Set jars = new LinkedHashSet();
/*  90 */     if (HiConfigHolder.getJarFile() != null) {
/*  91 */       jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
/*     */     }
/*     */ 
/*  94 */     if (this.mappingJarLocations != null) {
/*  95 */       for (Resource resource : this.mappingJarLocations) {
/*  96 */         if (jars.contains(resource.getFilename()))
/*     */           continue;
/*  98 */         jarResource.add(resource);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 104 */     for (String jarFileName : jars) {
/* 105 */       URL hiJarUrl = null;
/*     */       try
/*     */       {
/* 111 */         hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarURL();
/* 112 */         if (hiJarUrl != null)
/* 113 */           jarResource.add(new UrlResource(hiJarUrl));
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 117 */         this.logger.error("error:load jar file  == " + jarFileName);
/*     */       }
/*     */     }
/*     */ 
/* 121 */     this.mappingJarLocations = ((Resource[])jarResource.toArray(new Resource[jarResource.size()]));
/*     */ 
/* 123 */     super.afterPropertiesSet();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.HiSqlMapClientFactoryBean
 * JD-Core Version:    0.6.0
 */