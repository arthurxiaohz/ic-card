/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.action.MenuPageInfo;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuListAction extends BaseAction
/*    */ {
/*    */   private Menu menu;
/*    */   private MenuPageInfo pageInfo;
/*    */   private List<Menu> menus;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 21 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/* 22 */     this.pageInfo = (this.pageInfo == null ? new MenuPageInfo() : this.pageInfo);
/* 23 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 25 */     this.menus = menuMgr.getSecurityMenuList(sarchPageInfo);
/*    */ 
/* 27 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Menu getMenu() {
/* 31 */     return this.menu;
/*    */   }
/*    */ 
/*    */   public void setMenu(Menu menu) {
/* 35 */     this.menu = menu;
/*    */   }
/*    */ 
/*    */   public List<Menu> getMenus() {
/* 39 */     return this.menus;
/*    */   }
/*    */ 
/*    */   public void setMenus(List<Menu> menus) {
/* 43 */     this.menus = menus;
/*    */   }
/*    */ 
/*    */   public MenuPageInfo getPageInfo() {
/* 47 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(MenuPageInfo pageInfo) {
/* 51 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuListAction
 * JD-Core Version:    0.6.0
 */