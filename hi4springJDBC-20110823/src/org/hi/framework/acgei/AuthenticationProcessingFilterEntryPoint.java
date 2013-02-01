/*     */ package org.hi.framework.acgei;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.acegisecurity.AuthenticationException;
/*     */ import org.acegisecurity.ui.AuthenticationEntryPoint;
/*     */ import org.acegisecurity.util.PortMapper;
/*     */ import org.acegisecurity.util.PortMapperImpl;
/*     */ import org.acegisecurity.util.PortResolver;
/*     */ import org.acegisecurity.util.PortResolverImpl;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.util.Assert;
/*     */ 
/*     */ public class AuthenticationProcessingFilterEntryPoint
/*     */   implements AuthenticationEntryPoint, InitializingBean
/*     */ {
/*  60 */   private static final Log logger = LogFactory.getLog(AuthenticationProcessingFilterEntryPoint.class);
/*     */ 
/*  64 */   private PortMapper portMapper = new PortMapperImpl();
/*  65 */   private PortResolver portResolver = new PortResolverImpl();
/*     */   private String loginFormUrl;
/*  67 */   private boolean forceHttps = false;
/*  68 */   private boolean serverSideRedirect = false;
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws Exception
/*     */   {
/*  73 */     Assert.hasLength(this.loginFormUrl, "loginFormUrl must be specified");
/*  74 */     Assert.notNull(this.portMapper, "portMapper must be specified");
/*  75 */     Assert.notNull(this.portResolver, "portResolver must be specified");
/*     */   }
/*     */ 
/*     */   public void commence(ServletRequest request, ServletResponse response, AuthenticationException authException) throws IOException, ServletException
/*     */   {
/*  80 */     HttpServletRequest req = (HttpServletRequest)request;
/*  81 */     String scheme = request.getScheme();
/*  82 */     String serverName = request.getServerName();
/*  83 */     int serverPort = this.portResolver.getServerPort(request);
/*  84 */     String contextPath = req.getContextPath();
/*     */ 
/*  86 */     boolean inHttp = "http".equals(scheme.toLowerCase());
/*  87 */     boolean inHttps = "https".equals(scheme.toLowerCase());
/*     */ 
/*  89 */     boolean includePort = true;
/*     */ 
/*  91 */     String redirectUrl = null;
/*  92 */     boolean doForceHttps = false;
/*  93 */     Integer httpsPort = null;
/*     */ 
/*  95 */     if ((inHttp) && (serverPort == 80))
/*  96 */       includePort = false;
/*  97 */     else if ((inHttps) && (serverPort == 443)) {
/*  98 */       includePort = false;
/*     */     }
/*     */ 
/* 101 */     if ((this.forceHttps) && (inHttp)) {
/* 102 */       httpsPort = this.portMapper.lookupHttpsPort(new Integer(serverPort));
/*     */ 
/* 104 */       if (httpsPort != null) {
/* 105 */         doForceHttps = true;
/* 106 */         if (httpsPort.intValue() == 443)
/* 107 */           includePort = false;
/*     */         else {
/* 109 */           includePort = true;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 115 */     if (this.serverSideRedirect)
/*     */     {
/* 117 */       if (doForceHttps)
/*     */       {
/* 121 */         String servletPath = req.getServletPath();
/* 122 */         String pathInfo = req.getPathInfo();
/* 123 */         String query = req.getQueryString();
/*     */ 
/* 125 */         redirectUrl = "https://" + serverName + (includePort ? ":" + httpsPort : "") + contextPath + 
/* 126 */           servletPath + (pathInfo == null ? "" : pathInfo) + (query == null ? "" : new StringBuilder("?").append(query).toString());
/*     */       }
/*     */       else
/*     */       {
/* 130 */         if (logger.isDebugEnabled()) {
/* 131 */           logger.debug("Server side forward to: " + this.loginFormUrl);
/*     */         }
/*     */ 
/* 134 */         RequestDispatcher dispatcher = req.getRequestDispatcher(this.loginFormUrl);
/*     */ 
/* 136 */         dispatcher.forward(request, response);
/*     */ 
/* 138 */         return;
/*     */       }
/*     */ 
/*     */     }
/* 144 */     else if (doForceHttps)
/*     */     {
/* 146 */       redirectUrl = "https://" + serverName + (includePort ? ":" + httpsPort : "") + contextPath + 
/* 147 */         this.loginFormUrl;
/*     */     }
/*     */     else
/*     */     {
/* 151 */       redirectUrl = scheme + "://" + serverName + (includePort ? ":" + serverPort : "") + contextPath + 
/* 152 */         this.loginFormUrl;
/*     */     }
/*     */ 
/* 157 */     if (logger.isDebugEnabled()) {
/* 158 */       logger.debug("Redirecting to: " + redirectUrl);
/*     */     }
/*     */ 
/* 163 */     if (("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest)request).getHeader("X-Requested-With"))) || (request.getParameter("ajax") != null)) {
/* 164 */       PrintWriter out = response.getWriter();
/* 165 */       out.println("{\"statusCode\":\"301\",\"message\":\"Session Timeout! Please re-sign in!\"}");
/* 166 */       throw new BusinessException("Session Timeout");
/*     */     }
/*     */ 
/* 170 */     ((HttpServletResponse)response).sendRedirect(((HttpServletResponse)response).encodeRedirectURL(redirectUrl));
/*     */   }
/*     */ 
/*     */   public boolean getForceHttps()
/*     */   {
/* 175 */     return this.forceHttps;
/*     */   }
/*     */ 
/*     */   public String getLoginFormUrl() {
/* 179 */     return this.loginFormUrl;
/*     */   }
/*     */ 
/*     */   public PortMapper getPortMapper() {
/* 183 */     return this.portMapper;
/*     */   }
/*     */ 
/*     */   public PortResolver getPortResolver() {
/* 187 */     return this.portResolver;
/*     */   }
/*     */ 
/*     */   public boolean isServerSideRedirect() {
/* 191 */     return this.serverSideRedirect;
/*     */   }
/*     */ 
/*     */   public void setForceHttps(boolean forceHttps)
/*     */   {
/* 202 */     this.forceHttps = forceHttps;
/*     */   }
/*     */ 
/*     */   public void setLoginFormUrl(String loginFormUrl)
/*     */   {
/* 212 */     this.loginFormUrl = loginFormUrl;
/*     */   }
/*     */ 
/*     */   public void setPortMapper(PortMapper portMapper) {
/* 216 */     this.portMapper = portMapper;
/*     */   }
/*     */ 
/*     */   public void setPortResolver(PortResolver portResolver) {
/* 220 */     this.portResolver = portResolver;
/*     */   }
/*     */ 
/*     */   public void setServerSideRedirect(boolean serverSideRedirect)
/*     */   {
/* 230 */     this.serverSideRedirect = serverSideRedirect;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.acgei.AuthenticationProcessingFilterEntryPoint
 * JD-Core Version:    0.6.0
 */