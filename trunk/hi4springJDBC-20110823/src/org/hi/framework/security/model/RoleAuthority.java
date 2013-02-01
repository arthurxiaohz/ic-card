/*    */ package org.hi.framework.security.model;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.service.MenuLinkManager;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.security.model.original.RoleAuthorityAbstract;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ 
/*    */ public class RoleAuthority extends RoleAuthorityAbstract
/*    */ {
/*    */   public Authority getAuthority()
/*    */   {
/* 15 */     if ((!HiConfigHolder.getProperty("${hi.orm.type}").equals("SpringJDBC")) || (this.authority == null)) {
/* 16 */       return this.authority;
/*    */     }
/* 18 */     if (this.authority.getMenuLink() == null) {
/* 19 */       AuthorityManager authMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 20 */       this.authority = authMgr.getAuthorityById(this.authority.getId());
/*    */     }
/*    */ 
/* 23 */     if (this.authority.getMenuLink().getMenu() == null) {
/* 24 */       MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 25 */       this.authority.setMenuLink(menuLinkMgr.getMenuLinkById(this.authority.getMenuLink().getId()));
/*    */     }
/*    */ 
/* 29 */     return this.authority;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.RoleAuthority
 * JD-Core Version:    0.6.0
 */