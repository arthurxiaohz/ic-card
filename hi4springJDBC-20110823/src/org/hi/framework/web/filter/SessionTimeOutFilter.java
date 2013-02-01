/*    */ package org.hi.framework.web.filter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.hi.common.util.StringUtils;
/*    */ import org.springframework.web.filter.OncePerRequestFilter;
/*    */ 
/*    */ public class SessionTimeOutFilter extends OncePerRequestFilter
/*    */ {
/*    */   private String sessionAttributeKey;
/*    */   private String redirectURI;
/*    */   private String uncludeURIs;
/*    */ 
/*    */   protected boolean shouldNotFilter(HttpServletRequest request)
/*    */     throws ServletException
/*    */   {
/* 29 */     HttpSession session = request.getSession();
/* 30 */     Object obj = session.getAttribute(this.sessionAttributeKey);
/* 31 */     String requestURI = request.getRequestURI();
/* 32 */     Set uncludes = new HashSet();
/*    */ 
/* 34 */     if (this.uncludeURIs == null)
/* 35 */       uncludes.add(this.redirectURI);
/*    */     else {
/* 37 */       paserUnclude(uncludes);
/*    */     }
/*    */ 
/* 40 */     return (obj != null) || (uncludes.contains(requestURI));
/*    */   }
/*    */ 
/*    */   private void paserUnclude(Set uncludes)
/*    */   {
/* 45 */     String[] uris = StringUtils.strToStrArray(this.uncludeURIs);
/* 46 */     for (int i = 0; i < uris.length; i++)
/* 47 */       uncludes.add(uris[i]);
/*    */   }
/*    */ 
/*    */   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
/*    */   {
/* 52 */     if (!shouldNotFilter(request))
/* 53 */       response.sendRedirect(this.redirectURI);
/*    */   }
/*    */ 
/*    */   public void setRedirectURI(String redirectURI)
/*    */   {
/* 62 */     this.redirectURI = redirectURI;
/*    */   }
/*    */ 
/*    */   public void setSessionAttributeKey(String sessionAttributeKey)
/*    */   {
/* 70 */     this.sessionAttributeKey = sessionAttributeKey;
/*    */   }
/*    */ 
/*    */   public void setUncludeURIs(String uncludeURIs)
/*    */   {
/* 78 */     this.uncludeURIs = uncludeURIs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.filter.SessionTimeOutFilter
 * JD-Core Version:    0.6.0
 */