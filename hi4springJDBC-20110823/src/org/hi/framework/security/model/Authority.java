/*    */ package org.hi.framework.security.model;
/*    */ 
/*    */ import org.acegisecurity.GrantedAuthority;
/*    */ import org.hi.framework.security.model.original.AuthorityAbstract;
/*    */ 
/*    */ public class Authority extends AuthorityAbstract
/*    */   implements GrantedAuthority
/*    */ {
/*    */   public String getAuthority()
/*    */   {
/* 17 */     return this.authorityName;
/*    */   }
/*    */ 
/*    */   public void setAuthorityName(String authorityName) {
/* 21 */     authorityName = authorityName == null ? null : authorityName.trim();
/* 22 */     super.setAuthorityName(authorityName);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.Authority
 * JD-Core Version:    0.6.0
 */