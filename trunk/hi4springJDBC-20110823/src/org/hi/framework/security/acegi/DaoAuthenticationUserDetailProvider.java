/*    */ package org.hi.framework.security.acegi;
/*    */ 
/*    */ import org.acegisecurity.Authentication;
/*    */ import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
/*    */ import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
/*    */ import org.acegisecurity.userdetails.UserDetails;
/*    */ 
/*    */ public class DaoAuthenticationUserDetailProvider extends DaoAuthenticationProvider
/*    */ {
/*    */   protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user)
/*    */   {
/* 28 */     UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, 
/* 29 */       authentication.getCredentials(), user.getAuthorities());
/* 30 */     result.setDetails(user);
/*    */ 
/* 32 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.acegi.DaoAuthenticationUserDetailProvider
 * JD-Core Version:    0.6.0
 */