/*     */ package org.hi.framework.security.acegi;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
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
/*     */ import org.hi.framework.util.FrameworkBossJarUtil;
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
/*  61 */     this.mappingLocations = mappingLocations;
/*  62 */     setObjectDefinitionSource();
/*     */   }
/*     */ 
/*     */   protected void setObjectDefinitionSource() throws IOException {
/*  66 */     HiFilterInvocationDefinitionSourceEditor fidsEditor = new HiFilterInvocationDefinitionSourceEditor();
/*  67 */     List allMappingLocations = new ArrayList();
/*     */     String hiJarUrl;
/*  71 */     if (HiConfigHolder.getJarFile() != null) {
/*  72 */       List jarUrls = new ArrayList();
/*  73 */       String[] jars = HiConfigHolder.getJarFile().trim().split("[,]");
/*     */       String hiJarUrl;
/*  74 */       for (String jarFileName : jars) {
/*  75 */         hiJarUrl = null;
/*     */         try
/*     */         {
/*  80 */           hiJarUrl = FrameworkBossJarUtil.getInstance().getFrameworkBossJarPath();
/*  81 */           if (hiJarUrl != null)
/*  82 */             jarUrls.add(URLDecoder.decode(hiJarUrl, "utf-8"));
/*     */         }
/*     */         catch (Exception localException)
/*     */         {
/*     */         }
/*     */       }
/*  88 */       if (jarUrls.size() > 0) {
/*  89 */         for (Iterator localIterator = jarUrls.iterator(); localIterator.hasNext(); ) { hiJarUrl = (String)localIterator.next();
/*  90 */           if (hiJarUrl != null) {
/*  91 */             Object jarResources = JarResource.getInstance(new File(hiJarUrl), "*-security.properties");
/*     */             Object localObject1;
/*  92 */             localException = (localObject1 = jarResources).length; for (hiJarUrl = 0; hiJarUrl < localException; hiJarUrl++) { Resource resource = localObject1[hiJarUrl];
/*  93 */               allMappingLocations.add(resource);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 100 */     for (int i = 0; i < this.mappingLocations.length; i++) {
/* 101 */       allMappingLocations.add(this.mappingLocations[i]);
/*     */     }
/* 103 */     StringBuffer sb = new StringBuffer();
/* 104 */     for (Resource resource : allMappingLocations) {
/* 105 */       sb.append(DataInputStreamUtil.getInputStreameSegment(resource, 
/* 106 */         "WEB_SECURITY", 
/* 107 */         "WEB_SECURITY_END"));
/*     */     }
/*     */ 
/* 110 */     fidsEditor.setAsText(sb.toString());
/* 111 */     setObjectDefinitionSource((FilterInvocationDefinitionSource)fidsEditor.getValue());
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
/*     */   {
/* 116 */     ServletContext.setRequest((HttpServletRequest)request);
/* 117 */     ServletContext.setResponse((HttpServletResponse)response);
/* 118 */     super.doFilter(request, response, chain);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.acegi.ResourceBindleFilterSecurityInterceptor
 * JD-Core Version:    0.6.0
 */