/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSource;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSourceEditor;
/*    */ import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.spring.JarResource;
/*    */ import org.hi.framework.util.DataInputStreamUtil;
/*    */ import org.hi.framework.util.FrameworkBossJarUtil;
/*    */ import org.springframework.core.io.Resource;
/*    */ 
/*    */ public class ResourceBindleMethodSecurityInterceptor extends MethodSecurityInterceptor
/*    */ {
/*    */   private static final String FILTER_BUSINESS_ATTRIBUTER_START = "BUSINESS_SECURITY";
/*    */   private static final String FILTER_BUSINESS_ATTRIBUTER_START_END = "BUSINESS_SECURITY_END";
/*    */   private Resource[] mappingLocations;
/*    */ 
/*    */   public void setMappingLocations(Resource[] mappingLocations)
/*    */     throws IOException
/*    */   {
/* 48 */     this.mappingLocations = mappingLocations;
/* 49 */     setObjectDefinitionSource();
/*    */   }
/*    */ 
/*    */   private void setObjectDefinitionSource() throws IOException {
/* 53 */     MethodDefinitionSourceEditor mdsEditor = new MethodDefinitionSourceEditor();
/*    */ 
/* 55 */     List allMappingLocations = new ArrayList();
/*    */     String hiJarUrl;
/* 58 */     if (HiConfigHolder.getJarFile() != null) {
/* 59 */       List jarUrls = new ArrayList();
/* 60 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*    */       String hiJarUrl;
/* 61 */       for (String jarFileName : jars) {
/* 62 */         hiJarUrl = null;
/*    */         try
/*    */         {
/* 67 */           hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarPath();
/* 68 */           if (hiJarUrl != null)
/* 69 */             jarUrls.add(hiJarUrl);
/*    */         }
/*    */         catch (Exception localException)
/*    */         {
/*    */         }
/*    */       }
/* 75 */       if (jarUrls.size() > 0) {
/* 76 */         for (Iterator localIterator = jarUrls.iterator(); localIterator.hasNext(); ) { hiJarUrl = (String)localIterator.next();
/* 77 */           if (hiJarUrl != null) {
/* 78 */             Object jarResources = JarResource.getInstance(new File(hiJarUrl), "*-security.properties");
/*    */             Object localObject1;
/* 79 */             localException = (localObject1 = jarResources).length; for (hiJarUrl = 0; hiJarUrl < localException; hiJarUrl++) { Resource resource = localObject1[hiJarUrl];
/* 80 */               allMappingLocations.add(resource);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 86 */     for (int i = 0; i < this.mappingLocations.length; i++) {
/* 87 */       allMappingLocations.add(this.mappingLocations[i]);
/*    */     }
/*    */ 
/* 90 */     StringBuffer sb = new StringBuffer();
/* 91 */     for (Resource resource : allMappingLocations) {
/* 92 */       sb.append(DataInputStreamUtil.getInputStreameSegment(resource, 
/* 93 */         "BUSINESS_SECURITY", 
/* 94 */         "BUSINESS_SECURITY_END"));
/*    */     }
/*    */ 
/* 97 */     mdsEditor.setAsText(sb.toString());
/* 98 */     setObjectDefinitionSource((MethodDefinitionSource)mdsEditor.getValue());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor
 * JD-Core Version:    0.6.0
 */