/*    */ package org.hi.framework.security.context;
/*    */ 
/*    */ import org.acegisecurity.Authentication;
/*    */ import org.acegisecurity.context.SecurityContext;
/*    */ import org.acegisecurity.context.SecurityContextHolder;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.model.HiUser;
/*    */ 
/*    */ public class UserContextHelper
/*    */ {
/*    */   public static UserContext getUserContext()
/*    */   {
/* 27 */     return (getAuthentication() != null) && ((getAuthentication().getPrincipal() instanceof UserContext)) ? (UserContext)getAuthentication().getPrincipal() : null;
/*    */   }
/*    */ 
/*    */   public static SecurityContext getContext()
/*    */   {
/* 35 */     return SecurityContextHolder.getContext();
/*    */   }
/*    */ 
/*    */   public static Authentication getAuthentication()
/*    */   {
/* 43 */     return getContext() == null ? null : getContext().getAuthentication();
/*    */   }
/*    */ 
/*    */   public static HiUser getUser()
/*    */   {
/* 51 */     return getUserContext() == null ? null : getUserContext().getUser();
/*    */   }
/*    */ 
/*    */   public static HiOrg getOrg()
/*    */   {
/* 59 */     return getUserContext() == null ? null : getUserContext().getOrg();
/*    */   }
/*    */ 
/*    */   public static Integer getUserId()
/*    */   {
/* 67 */     return getUserContext() == null ? null : getUserContext().getUserId();
/*    */   }
/*    */ 
/*    */   public static Integer getOrgId()
/*    */   {
/* 75 */     return getUserContext() == null ? null : getUserContext().getOrgId();
/*    */   }
/*    */ 
/*    */   public static String getUserName()
/*    */   {
/* 83 */     return getUserContext() == null ? null : getUserContext().getUserName();
/*    */   }
/*    */ 
/*    */   public static String getOrgName()
/*    */   {
/* 91 */     return getUserContext() == null ? null : getUserContext().getOrgName();
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.context.UserContextHelper
 * JD-Core Version:    0.6.0
 */