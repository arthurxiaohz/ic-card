/*     */ package org.hi.framework.dao.ibatis3;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.sql.DataSource;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.ibatis.builder.xml.XMLConfigBuilder;
/*     */ import org.apache.ibatis.mapping.Configuration;
/*     */ import org.apache.ibatis.session.SqlSessionFactory;
/*     */ import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.common.util.BeanUtil;
/*     */ import org.hi.common.util.StringUtils;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.dao.ibatis.IbatisHiDialect;
/*     */ import org.springframework.beans.factory.FactoryBean;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.core.io.UrlResource;
/*     */ 
/*     */ public final class SpringSqlSessionFactoryBuilder
/*     */   implements FactoryBean, InitializingBean
/*     */ {
/*     */   private SqlSessionFactory sqlSessionFactory;
/*     */   private Properties properties;
/*     */   private DataSource dataSource;
/*     */   private IbatisHiDialect dialect;
/*     */   private Resource[] mappingLocations;
/*     */   private Resource[] mappingJarLocations;
/*     */   private Resource configLocation;
/*     */   private boolean sqlShow;
/*  46 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   public IbatisHiDialect getDialet() {
/*  49 */     return this.dialect;
/*     */   }
/*     */   public void setDialect(IbatisHiDialect dialect) {
/*  52 */     this.dialect = dialect;
/*     */   }
/*     */   public Resource[] getMappingLocations() {
/*  55 */     return this.mappingLocations;
/*     */   }
/*     */   public void setMappingLocations(Resource[] mappingLocations) {
/*  58 */     this.mappingLocations = mappingLocations;
/*     */   }
/*     */ 
/*     */   public Resource[] getMappingJarLocations() {
/*  62 */     return this.mappingJarLocations;
/*     */   }
/*     */   public void setMappingJarLocations(Resource[] mappingJarLocations) {
/*  65 */     this.mappingJarLocations = mappingJarLocations;
/*     */   }
/*     */   public boolean isSqlShow() {
/*  68 */     return this.sqlShow;
/*     */   }
/*     */   public void setSqlShow(boolean sqlShow) {
/*  71 */     this.sqlShow = sqlShow;
/*     */   }
/*     */ 
/*     */   public void setConfigLocation(Resource configLocation) {
/*  75 */     this.configLocation = configLocation;
/*     */   }
/*     */ 
/*     */   public ServletContext getServletContext()
/*     */   {
/*  80 */     return SpringContextHolder.getServletContext();
/*     */   }
/*     */   public void setProperties(Properties properties) {
/*  83 */     this.properties = properties;
/*     */   }
/*     */ 
/*     */   public void setDataSource(DataSource dataSource) {
/*  87 */     this.dataSource = dataSource;
/*     */   }
/*     */ 
/*     */   public SqlSessionFactory getObject() throws Exception {
/*  91 */     return this.sqlSessionFactory;
/*     */   }
/*     */ 
/*     */   public Class<? extends SqlSessionFactory> getObjectType() {
/*  95 */     return this.sqlSessionFactory == null ? SqlSessionFactory.class : 
/*  96 */       this.sqlSessionFactory.getClass();
/*     */   }
/*     */ 
/*     */   public boolean isSingleton() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws IOException
/*     */   {
/* 106 */     if (this.dialect == null) {
/* 107 */       String dialectValue = this.properties.getProperty("ibatis.dialect");
/* 108 */       if (dialectValue != null) {
/* 109 */         this.dialect = ((IbatisHiDialect)BeanUtil.CreateObject(dialectValue));
/*     */       }
/*     */     }
/* 112 */     List jarResource = new ArrayList();
/*     */ 
/* 114 */     Set jars = new LinkedHashSet();
/* 115 */     if (HiConfigHolder.getJarFile() != null) {
/* 116 */       jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
/*     */     }
/*     */ 
/* 119 */     if (this.mappingJarLocations != null) {
/* 120 */       for (Resource resource : this.mappingJarLocations) {
/* 121 */         if (jars.contains(resource.getFilename()))
/*     */           continue;
/* 123 */         jarResource.add(resource);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 129 */     for (String jarFileName : jars) {
/* 130 */       URL hiJarUrl = null;
/*     */       try {
/* 132 */         File classFile = new File(getClass().getClassLoader().getResource("").toURI());
/* 133 */         hiJarUrl = new URL(classFile.getParentFile().toURI().toString() + "/lib/" + jarFileName);
/*     */ 
/* 135 */         if (hiJarUrl != null)
/* 136 */           jarResource.add(new UrlResource(hiJarUrl));
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 140 */         this.logger.error("error:load jar file  == " + jarFileName);
/*     */       }
/*     */     }
/* 143 */     this.mappingJarLocations = ((Resource[])jarResource.toArray(new Resource[jarResource.size()]));
/*     */ 
/* 148 */     if (this.configLocation == null) {
/* 149 */       throw new IllegalArgumentException(
/* 150 */         "Property 'configLocation' is required");
/*     */     }
/* 152 */     if (this.dataSource == null) {
/* 153 */       throw new IllegalArgumentException(
/* 154 */         "Property 'dataSource' is required");
/*     */     }
/*     */ 
/* 157 */     InputStream xx = this.configLocation.getInputStream();
/* 158 */     InputStreamReader x = new InputStreamReader(xx);
/* 159 */     BufferedReader dis = new BufferedReader(x);
/*     */ 
/* 162 */     XMLConfigBuilder parser = new XMLConfigBuilder(dis, null, this.properties);
/* 163 */     Configuration config = parser.parse();
/*     */ 
/* 170 */     config.setEnvironment(null);
/*     */ 
/* 172 */     this.sqlSessionFactory = new DefaultSqlSessionFactory(config, this.dataSource);
/*     */   }
/*     */   public SqlSessionFactory getSqlSessionFactory() {
/* 175 */     return this.sqlSessionFactory;
/*     */   }
/*     */   public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
/* 178 */     this.sqlSessionFactory = sqlSessionFactory;
/*     */   }
/*     */   public DataSource getDataSource() {
/* 181 */     return this.dataSource;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.SpringSqlSessionFactoryBuilder
 * JD-Core Version:    0.6.0
 */