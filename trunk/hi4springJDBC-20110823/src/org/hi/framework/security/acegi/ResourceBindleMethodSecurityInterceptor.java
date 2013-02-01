/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSource;
/*    */ import org.acegisecurity.intercept.method.MethodDefinitionSourceEditor;
/*    */ import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.spring.JarResource;
/*    */ import org.hi.framework.util.DataInputStreamUtil;
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
/* 47 */     this.mappingLocations = mappingLocations;
/* 48 */     setObjectDefinitionSource();
/*    */   }
/*    */ 
/*    */   private void setObjectDefinitionSource() throws IOException {
/* 52 */     MethodDefinitionSourceEditor mdsEditor = new MethodDefinitionSourceEditor();
/*    */ 
/* 54 */     List allMappingLocations = new ArrayList();
/*    */     String hiJarUrl;
/* 57 */     if (HiConfigHolder.getJarFile() != null) {
/* 58 */       List jarUrls = new ArrayList();
/* 59 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*    */       String hiJarUrl;
/* 60 */       for (String jarFileName : jars) {
/* 61 */         hiJarUrl = null;
/*    */         try {
/* 63 */           hiJarUrl = URLDecoder.decode(getClass().getClassLoader().getResource("../lib/" + jarFileName).getFile(), "utf-8");
/* 64 */           if (hiJarUrl != null)
/* 65 */             jarUrls.add(hiJarUrl);
/*    */         }
/*    */         catch (Exception localException)
/*    */         {
/*    */         }
/*    */       }
/* 71 */       if (jarUrls.size() > 0) {
/* 72 */         for (Iterator localIterator = jarUrls.iterator(); localIterator.hasNext(); ) { hiJarUrl = (String)localIterator.next();
/* 73 */           if (hiJarUrl != null) {
/* 74 */             Object jarResources = JarResource.getInstance(new File(hiJarUrl), "*-security.properties");
/*    */             Object localObject1;
/* 75 */             localException = (localObject1 = jarResources).length; for (hiJarUrl = 0; hiJarUrl < localException; hiJarUrl++) { Resource resource = localObject1[hiJarUrl];
/* 76 */               allMappingLocations.add(resource);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 82 */     for (int i = 0; i < this.mappingLocations.length; i++) {
/* 83 */       allMappingLocations.add(this.mappingLocations[i]);
/*    */     }
/*    */ 
/* 86 */     StringBuffer sb = new StringBuffer();
/* 87 */     for (Resource resource : allMappingLocations) {
/* 88 */       sb.append(
/* 90 */         DataInputStreamUtil.getInputStreameSegment(resource, 
/* 89 */         "BUSINESS_SECURITY", 
/* 90 */         "BUSINESS_SECURITY_END"));
/*    */     }
/*    */ 
/* 93 */     mdsEditor.setAsText(sb.toString());
/* 94 */     setObjectDefinitionSource((MethodDefinitionSource)mdsEditor.getValue());
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.ResourceBindleMethodSecurityInterceptor
 * JD-Core Version:    0.6.0
 */