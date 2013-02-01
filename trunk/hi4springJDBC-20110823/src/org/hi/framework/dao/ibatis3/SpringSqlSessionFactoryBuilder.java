/*     */ package org.hi.framework.dao.ibatis3;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
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
/*     */ import org.hi.framework.util.FrameworkBossJarUtil;
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
/*  47 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   public IbatisHiDialect getDialet() {
/*  50 */     return this.dialect;
/*     */   }
/*     */   public void setDialect(IbatisHiDialect dialect) {
/*  53 */     this.dialect = dialect;
/*     */   }
/*     */   public Resource[] getMappingLocations() {
/*  56 */     return this.mappingLocations;
/*     */   }
/*     */   public void setMappingLocations(Resource[] mappingLocations) {
/*  59 */     this.mappingLocations = mappingLocations;
/*     */   }
/*     */ 
/*     */   public Resource[] getMappingJarLocations() {
/*  63 */     return this.mappingJarLocations;
/*     */   }
/*     */   public void setMappingJarLocations(Resource[] mappingJarLocations) {
/*  66 */     this.mappingJarLocations = mappingJarLocations;
/*     */   }
/*     */   public boolean isSqlShow() {
/*  69 */     return this.sqlShow;
/*     */   }
/*     */   public void setSqlShow(boolean sqlShow) {
/*  72 */     this.sqlShow = sqlShow;
/*     */   }
/*     */ 
/*     */   public void setConfigLocation(Resource configLocation) {
/*  76 */     this.configLocation = configLocation;
/*     */   }
/*     */ 
/*     */   public ServletContext getServletContext()
/*     */   {
/*  81 */     return SpringContextHolder.getServletContext();
/*     */   }
/*     */   public void setProperties(Properties properties) {
/*  84 */     this.properties = properties;
/*     */   }
/*     */ 
/*     */   public void setDataSource(DataSource dataSource) {
/*  88 */     this.dataSource = dataSource;
/*     */   }
/*     */ 
/*     */   public SqlSessionFactory getObject() throws Exception {
/*  92 */     return this.sqlSessionFactory;
/*     */   }
/*     */ 
/*     */   public Class<? extends SqlSessionFactory> getObjectType() {
/*  96 */     return this.sqlSessionFactory == null ? SqlSessionFactory.class : 
/*  97 */       this.sqlSessionFactory.getClass();
/*     */   }
/*     */ 
/*     */   public boolean isSingleton() {
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws IOException
/*     */   {
/* 107 */     if (this.dialect == null) {
/* 108 */       String dialectValue = this.properties.getProperty("ibatis.dialect");
/* 109 */       if (dialectValue != null) {
/* 110 */         this.dialect = ((IbatisHiDialect)BeanUtil.CreateObject(dialectValue));
/*     */       }
/*     */     }
/* 113 */     List jarResource = new ArrayList();
/*     */ 
/* 115 */     Set jars = new LinkedHashSet();
/* 116 */     if (HiConfigHolder.getJarFile() != null) {
/* 117 */       jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
/*     */     }
/*     */ 
/* 120 */     if (this.mappingJarLocations != null) {
/* 121 */       for (Resource resource : this.mappingJarLocations) {
/* 122 */         if (jars.contains(resource.getFilename()))
/*     */           continue;
/* 124 */         jarResource.add(resource);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 130 */     for (String jarFileName : jars) {
/* 131 */       URL hiJarUrl = null;
/*     */       try
/*     */       {
/* 137 */         hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarURL();
/* 138 */         if (hiJarUrl != null)
/* 139 */           jarResource.add(new UrlResource(hiJarUrl));
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 143 */         this.logger.error("error:load jar file  == " + jarFileName);
/*     */       }
/*     */     }
/* 146 */     this.mappingJarLocations = ((Resource[])jarResource.toArray(new Resource[jarResource.size()]));
/*     */ 
/* 151 */     if (this.configLocation == null) {
/* 152 */       throw new IllegalArgumentException(
/* 153 */         "Property 'configLocation' is required");
/*     */     }
/* 155 */     if (this.dataSource == null) {
/* 156 */       throw new IllegalArgumentException(
/* 157 */         "Property 'dataSource' is required");
/*     */     }
/*     */ 
/* 160 */     InputStream xx = this.configLocation.getInputStream();
/* 161 */     InputStreamReader x = new InputStreamReader(xx);
/* 162 */     BufferedReader dis = new BufferedReader(x);
/*     */ 
/* 165 */     XMLConfigBuilder parser = new XMLConfigBuilder(dis, null, this.properties);
/* 166 */     Configuration config = parser.parse();
/*     */ 
/* 173 */     config.setEnvironment(null);
/*     */ 
/* 175 */     this.sqlSessionFactory = new DefaultSqlSessionFactory(config, this.dataSource);
/*     */   }
/*     */   public SqlSessionFactory getSqlSessionFactory() {
/* 178 */     return this.sqlSessionFactory;
/*     */   }
/*     */   public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
/* 181 */     this.sqlSessionFactory = sqlSessionFactory;
/*     */   }
/*     */   public DataSource getDataSource() {
/* 184 */     return this.dataSource;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.SpringSqlSessionFactoryBuilder
 * JD-Core Version:    0.6.0
 */