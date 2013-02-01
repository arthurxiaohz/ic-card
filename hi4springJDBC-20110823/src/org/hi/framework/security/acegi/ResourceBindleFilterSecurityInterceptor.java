/*     */ package org.hi.framework.security.acegi;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.acegisecurity.intercept.web.FilterInvocationDefinitionSource;
/*     */ import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.spring.JarResource;
/*     */ import org.hi.framework.util.DataInputStreamUtil;
/*     */ import org.hi.framework.web.ServletContext;
/*     */ import org.springframework.core.io.Resource;
/*     */ 
/*     */ public class ResourceBindleFilterSecurityInterceptor extends FilterSecurityInterceptor
/*     */ {
/*     */   private static final String FILTER_WEB_ATTRIBUTER_START = "WEB_SECURITY";
/*     */   private static final String FILTER_WEB_ATTRIBUTER_START_END = "WEB_SECURITY_END";
/*     */   private Resource[] mappingLocations;
/*     */ 
/*     */   public void setMappingLocations(Resource[] mappingLocations)
/*     */     throws IOException
/*     */   {
/*  60 */     this.mappingLocations = mappingLocations;
/*  61 */     setObjectDefinitionSource();
/*     */   }
/*     */ 
/*     */   protected void setObjectDefinitionSource() throws IOException {
/*  65 */     HiFilterInvocationDefinitionSourceEditor fidsEditor = new HiFilterInvocationDefinitionSourceEditor();
/*  66 */     List allMappingLocations = new ArrayList();
/*     */     String hiJarUrl;
/*  70 */     if (HiConfigHolder.getJarFile() != null) {
/*  71 */       List jarUrls = new ArrayList();
/*  72 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*     */       String hiJarUrl;
/*  73 */       for (String jarFileName : jars) {
/*  74 */         hiJarUrl = null;
/*     */         try {
/*  76 */           hiJarUrl = URLDecoder.decode(getClass().getClassLoader().getResource("../lib/" + jarFileName).getFile(), "utf-8");
/*  77 */           if (hiJarUrl != null)
/*  78 */             jarUrls.add(hiJarUrl);
/*     */         }
/*     */         catch (Exception localException)
/*     */         {
/*     */         }
/*     */       }
/*  84 */       if (jarUrls.size() > 0) {
/*  85 */         for (Iterator localIterator = jarUrls.iterator(); localIterator.hasNext(); ) { hiJarUrl = (String)localIterator.next();
/*  86 */           if (hiJarUrl != null) {
/*  87 */             Object jarResources = JarResource.getInstance(new File(hiJarUrl), "*-security.properties");
/*     */             Object localObject1;
/*  88 */             localException = (localObject1 = jarResources).length; for (hiJarUrl = 0; hiJarUrl < localException; hiJarUrl++) { Resource resource = localObject1[hiJarUrl];
/*  89 */               allMappingLocations.add(resource);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  96 */     for (int i = 0; i < this.mappingLocations.length; i++) {
/*  97 */       allMappingLocations.add(this.mappingLocations[i]);
/*     */     }
/*  99 */     StringBuffer sb = new StringBuffer();
/* 100 */     for (Resource resource : allMappingLocations) {
/* 101 */       sb.append(
/* 103 */         DataInputStreamUtil.getInputStreameSegment(resource, 
/* 102 */         "WEB_SECURITY", 
/* 103 */         "WEB_SECURITY_END"));
/*     */     }
/*     */ 
/* 106 */     fidsEditor.setAsText(sb.toString());
/* 107 */     setObjectDefinitionSource((FilterInvocationDefinitionSource)fidsEditor.getValue());
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
/*     */   {
/* 112 */     ServletContext.setRequest((HttpServletRequest)request);
/* 113 */     ServletContext.setResponse((HttpServletResponse)response);
/* 114 */     super.doFilter(request, response, chain);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.ResourceBindleFilterSecurityInterceptor
 * JD-Core Version:    0.6.0
 */