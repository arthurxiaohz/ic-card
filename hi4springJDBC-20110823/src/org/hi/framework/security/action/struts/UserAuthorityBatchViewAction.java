/*    */ package org.hi.framework.security.action.struts;
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
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class UserAuthorityBatchViewAction extends BaseAction
/*    */ {
/*    */   private List<Authority> authorities;
/*    */   private List<HiOrg> orgs;
/*    */   private List<Menu> menus;
/* 21 */   private String showMode = HiConfigHolder.getSecurityOrgShowMode();
/*    */ 
/* 23 */   public String execute() throws Exception { AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
/* 24 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/* 25 */     Sorter sorter = SorterFactory.getSimpleSort("menuLink.menu.id");
/*    */ 
/* 27 */     this.authorities = authorityMgr.getObjects(null, sorter);
/* 28 */     this.menus = menuMgr.getObjects();
/*    */ 
/* 30 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public List<HiOrg> getOrgs()
/*    */   {
/* 35 */     if (this.orgs == null) {
/* 36 */       HiOrgManager orgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
/* 37 */       this.orgs = orgMgr.getObjects();
/*    */     }
/* 39 */     return this.orgs;
/*    */   }
/*    */ 
/*    */   public String getShowMode() {
/* 43 */     return this.showMode;
/*    */   }
/*    */ 
/*    */   public List<Menu> getMenus() {
/* 47 */     return this.menus;
/*    */   }
/*    */ 
/*    */   public List<Authority> getAuthorities()
/*    */   {
/* 52 */     return this.authorities;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.security.action.struts.UserAuthorityBatchViewAction
 * JD-Core Version:    0.6.0
 */