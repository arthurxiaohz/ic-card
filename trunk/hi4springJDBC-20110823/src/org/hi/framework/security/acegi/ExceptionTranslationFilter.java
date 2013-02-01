/*     */ package org.hi.framework.security.acegi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.acegisecurity.AccessDeniedException;
/*     */ import org.acegisecurity.AcegiSecurityException;
/*     */ import org.acegisecurity.AuthenticationException;
/*     */ import org.acegisecurity.AuthenticationTrustResolver;
/*     */ import org.acegisecurity.AuthenticationTrustResolverImpl;
/*     */ import org.acegisecurity.InsufficientAuthenticationException;
/*     */ import org.acegisecurity.context.SecurityContext;
/*     */ import org.acegisecurity.context.SecurityContextHolder;
/*     */ import org.acegisecurity.ui.AccessDeniedHandler;
/*     */ import org.acegisecurity.ui.AccessDeniedHandlerImpl;
/*     */ import org.acegisecurity.ui.AuthenticationEntryPoint;
/*     */ import org.acegisecurity.ui.savedrequest.SavedRequest;
/*     */ import org.acegisecurity.util.PortResolver;
/*     */ import org.acegisecurity.util.PortResolverImpl;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.util.Assert;
/*     */ 
/*     */ public class ExceptionTranslationFilter
/*     */   implements Filter, InitializingBean
/*     */ {
/*  77 */   private static final Log logger = LogFactory.getLog(ExceptionTranslationFilter.class);
/*     */ 
/*  81 */   private AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();
/*     */   private AuthenticationEntryPoint authenticationEntryPoint;
/*  83 */   private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
/*  84 */   private PortResolver portResolver = new PortResolverImpl();
/*  85 */   private boolean createSessionAllowed = true;
/*     */ 
/*  87 */   private String encoding = "UTF-8";
/*     */ 
/*     */   public void afterPropertiesSet()
/*     */     throws Exception
/*     */   {
/*  92 */     Assert.notNull(this.authenticationEntryPoint, "authenticationEntryPoint must be specified");
/*  93 */     Assert.notNull(this.portResolver, "portResolver must be specified");
/*  94 */     Assert.notNull(this.authenticationTrustResolver, "authenticationTrustResolver must be specified");
/*     */   }
/*     */ 
/*     */   public void destroy() {
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/* 101 */     if (!(request instanceof HttpServletRequest)) {
/* 102 */       throw new ServletException("HttpServletRequest required");
/*     */     }
/*     */ 
/* 105 */     if (!(response instanceof HttpServletResponse)) {
/* 106 */       throw new ServletException("HttpServletResponse required");
/*     */     }
/*     */ 
/* 109 */     if (this.encoding != null)
/* 110 */       request.setCharacterEncoding(this.encoding);
/*     */     try
/*     */     {
/* 113 */       chain.doFilter(request, response);
/*     */ 
/* 115 */       if (logger.isDebugEnabled())
/* 116 */         logger.debug("Chain processed normally");
/*     */     }
/*     */     catch (AuthenticationException ex) {
/* 119 */       handleException(request, response, chain, ex);
/*     */     } catch (AccessDeniedException ex) {
/* 121 */       handleException(request, response, chain, ex);
/*     */     } catch (ServletException ex) {
/* 123 */       if (((ex.getRootCause() instanceof AuthenticationException)) || 
/* 124 */         ((ex.getRootCause() instanceof AccessDeniedException)))
/* 125 */         handleException(request, response, chain, (AcegiSecurityException)ex.getRootCause());
/*     */       else
/* 127 */         throw ex;
/*     */     }
/*     */     catch (IOException ex) {
/* 130 */       throw ex;
/*     */     }
/*     */   }
/*     */ 
/*     */   public AuthenticationEntryPoint getAuthenticationEntryPoint() {
/* 135 */     return this.authenticationEntryPoint;
/*     */   }
/*     */ 
/*     */   public AuthenticationTrustResolver getAuthenticationTrustResolver() {
/* 139 */     return this.authenticationTrustResolver;
/*     */   }
/*     */ 
/*     */   public PortResolver getPortResolver() {
/* 143 */     return this.portResolver;
/*     */   }
/*     */ 
/*     */   private void handleException(ServletRequest request, ServletResponse response, FilterChain chain, AcegiSecurityException exception) throws IOException, ServletException
/*     */   {
/* 148 */     if ((exception instanceof AuthenticationException)) {
/* 149 */       if (logger.isDebugEnabled()) {
/* 150 */         logger.debug("Authentication exception occurred; redirecting to authentication entry point", exception);
/*     */       }
/*     */ 
/* 153 */       sendStartAuthentication(request, response, chain, (AuthenticationException)exception);
/* 154 */     } else if ((exception instanceof AccessDeniedException)) {
/* 155 */       if (this.authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
/* 156 */         if (logger.isDebugEnabled()) {
/* 157 */           logger.debug("Access is denied (user is anonymous); redirecting to authentication entry point", 
/* 158 */             exception);
/*     */         }
/*     */ 
/* 161 */         sendStartAuthentication(request, response, chain, 
/* 162 */           new InsufficientAuthenticationException("Full authentication is required to access this resource"));
/*     */       } else {
/* 164 */         if (logger.isDebugEnabled()) {
/* 165 */           logger.debug("Access is denied (user is not anonymous); delegating to AccessDeniedHandler", 
/* 166 */             exception);
/*     */         }
/*     */ 
/* 169 */         this.accessDeniedHandler.handle(request, response, (AccessDeniedException)exception);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void init(FilterConfig filterConfig)
/*     */     throws ServletException
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean isCreateSessionAllowed()
/*     */   {
/* 188 */     return this.createSessionAllowed;
/*     */   }
/*     */ 
/*     */   protected void sendStartAuthentication(ServletRequest request, ServletResponse response, FilterChain chain, AuthenticationException reason) throws ServletException, IOException
/*     */   {
/* 193 */     HttpServletRequest httpRequest = (HttpServletRequest)request;
/*     */ 
/* 195 */     SavedRequest savedRequest = new SavedRequest(httpRequest, this.portResolver);
/*     */ 
/* 197 */     if (logger.isDebugEnabled()) {
/* 198 */       logger.debug("Authentication entry point being called; SavedRequest added to Session: " + savedRequest);
/*     */     }
/*     */ 
/* 201 */     if (this.createSessionAllowed)
/*     */     {
/* 204 */       httpRequest.getSession().setAttribute("ACEGI_SAVED_REQUEST_KEY", savedRequest);
/*     */     }
/*     */ 
/* 209 */     SecurityContextHolder.getContext().setAuthentication(null);
/*     */ 
/* 211 */     this.authenticationEntryPoint.commence(httpRequest, (HttpServletResponse)response, reason);
/*     */   }
/*     */ 
/*     */   public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
/* 215 */     Assert.notNull(accessDeniedHandler, "AccessDeniedHandler required");
/* 216 */     this.accessDeniedHandler = accessDeniedHandler;
/*     */   }
/*     */ 
/*     */   public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
/* 220 */     this.authenticationEntryPoint = authenticationEntryPoint;
/*     */   }
/*     */ 
/*     */   public void setAuthenticationTrustResolver(AuthenticationTrustResolver authenticationTrustResolver) {
/* 224 */     this.authenticationTrustResolver = authenticationTrustResolver;
/*     */   }
/*     */ 
/*     */   public void setCreateSessionAllowed(boolean createSessionAllowed) {
/* 228 */     this.createSessionAllowed = createSessionAllowed;
/*     */   }
/*     */ 
/*     */   public void setPortResolver(PortResolver portResolver) {
/* 232 */     this.portResolver = portResolver;
/*     */   }
/*     */ 
/*     */   public void setEncoding(String encoding) {
/* 236 */     this.encoding = encoding;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.ExceptionTranslationFilter
 * JD-Core Version:    0.6.0
 */