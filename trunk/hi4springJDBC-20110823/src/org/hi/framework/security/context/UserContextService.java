/*    */ package org.hi.framework.security.context;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.acegisecurity.context.SecurityContext;
/*    */ import org.acegisecurity.context.SecurityContextHolder;
/*    */ import org.acegisecurity.userdetails.UserDetails;
/*    */ import org.acegisecurity.userdetails.UserDetailsService;
/*    */ import org.acegisecurity.userdetails.UsernameNotFoundException;
/*    */ import org.hi.framework.security.service.SecurityManager;
/*    */ import org.springframework.dao.DataAccessException;
/*    */ 
/*    */ public class UserContextService
/*    */   implements UserDetailsService
/*    */ {
/*    */   private SecurityManager scurityManager;
/*    */ 
/*    */   public UserDetails loadUserByUsername(String username)
/*    */     throws UsernameNotFoundException, DataAccessException
/*    */   {
/* 45 */     UserContext uesrContext = this.scurityManager.getUserContext(username);
/*    */ 
/* 47 */     if (uesrContext == null) {
/* 48 */       throw new UsernameNotFoundException("user:" + username + " not found");
/*    */     }
/* 50 */     return uesrContext;
/*    */   }
/*    */ 
/*    */   public void setSecurityManager(SecurityManager securityManager) {
/* 54 */     this.scurityManager = securityManager;
/*    */   }
/*    */ 
/*    */   /** @deprecated */
/*    */   public void loadSecurityContext(HttpServletRequest request)
/*    */   {
/* 68 */     Object contextFromSessionObject = request.getSession(true).getAttribute("ACEGI_SECURITY_CONTEXT");
/*    */ 
/* 70 */     if (contextFromSessionObject == null) {
/* 71 */       return;
/*    */     }
/* 73 */     if (!(contextFromSessionObject instanceof SecurityContext)) {
/* 74 */       return;
/*    */     }
/* 76 */     SecurityContextHolder.setContext((SecurityContext)contextFromSessionObject);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.context.UserContextService
 * JD-Core Version:    0.6.0
 */