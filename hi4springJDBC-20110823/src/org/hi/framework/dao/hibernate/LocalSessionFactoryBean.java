/*    */ package org.hi.framework.dao.hibernate;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.util.FrameworkBossJarUtil;
/*    */ import org.springframework.core.io.Resource;
/*    */ import org.springframework.core.io.UrlResource;
/*    */ 
/*    */ public class LocalSessionFactoryBean extends org.springframework.orm.hibernate3.LocalSessionFactoryBean
/*    */ {
/*    */   protected Resource[] mappingJarLocations;
/*    */ 
/*    */   public void setMappingJarLocations(Resource[] mappingJarLocations)
/*    */   {
/* 21 */     this.mappingJarLocations = mappingJarLocations;
/*    */   }
/*    */ 
/*    */   public void afterPropertiesSet() throws Exception
/*    */   {
/* 26 */     Set jars = new LinkedHashSet();
/*    */ 
/* 28 */     if (HiConfigHolder.getJarFile() != null) {
/* 29 */       jars = StringUtils.strToSet(HiConfigHolder.getJarFile().trim());
/*    */     }
/*    */ 
/* 32 */     List jarResource = new ArrayList();
/*    */ 
/* 35 */     if (this.mappingJarLocations != null) {
/* 36 */       for (Resource resource : this.mappingJarLocations)
/*    */       {
/* 38 */         if (jars.contains(resource.getFilename())) {
/*    */           continue;
/*    */         }
/* 41 */         jarResource.add(resource);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 48 */     for (String jarFileName : jars) {
/* 49 */       URL hiJarUrl = null;
/*    */       try
/*    */       {
/* 55 */         hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarURL();
/* 56 */         if (hiJarUrl != null)
/* 57 */           jarResource.add(new UrlResource(hiJarUrl));
/*    */       }
/*    */       catch (Exception e)
/*    */       {
/* 61 */         this.logger.error("error:load jar file  == " + jarFileName);
/*    */       }
/*    */     }
/*    */ 
/* 65 */     this.mappingJarLocations = ((Resource[])jarResource.toArray(new Resource[jarResource.size()]));
/* 66 */     super.setMappingJarLocations(this.mappingJarLocations);
/* 67 */     super.afterPropertiesSet();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.hibernate.LocalSessionFactoryBean
 * JD-Core Version:    0.6.0
 */