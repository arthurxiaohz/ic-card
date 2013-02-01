/*    */ package org.hi.framework.security.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.base.organization.model.HiOrg;
/*    */ import org.hi.base.organization.service.HiOrgManager;
/*    */ import org.hi.framework.HiConfigHolder;
/*    */ import org.hi.framework.dao.Sorter;
/*    */ import org.hi.framework.dao.impl.SorterFactory;
/*    */ import org.hi.framework.security.model.Authority;
/*    */ import org.hi.framework.security.service.AuthorityManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class UserAuthorityBatchViewAction extends BaseAction
/*    */ {
/*    */   private List<Authority> authorities;
/*    */   private List<HiOrg> orgs;
/*    */   private List<Menu> menus;
/* 22 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*    */ 
/* 24 */   public String execute() throws Exception { AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 25 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/* 26 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.id");
/*    */ 
/* 28 */     this.authorities = authorityMgr.getObjects(null, sorter);
/* 29 */     this.menus = menuMgr.getObjects();
/*    */ 
/* 31 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public List<HiOrg> getOrgs()
/*    */   {
/* 36 */     if (this.orgs == null) {
/* 37 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 38 */       this.orgs = orgMgr.getObjects();
/*    */     }
/* 40 */     return this.orgs;
/*    */   }
/*    */ 
/*    */   public String getShowMode() {
/* 44 */     return this.showMode;
/*    */   }
/*    */ 
/*    */   public List<Menu> getMenus() {
/* 48 */     return this.menus;
/*    */   }
/*    */ 
/*    */   public List<Authority> getAuthorities()
/*    */   {
/* 53 */     return this.authorities;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.action.webwork.UserAuthorityBatchViewAction
 * JD-Core Version:    0.6.0
 */