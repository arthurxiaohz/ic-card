/*     */ package org.hi.base.menu.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.menu.action.MenuPageInfo;
/*     */ import org.hi.base.menu.model.Menu;
/*     */ import org.hi.base.menu.service.MenuManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class MenuAction extends BaseAction
/*     */ {
/*     */   private Menu menu;
/*     */   private MenuPageInfo pageInfo;
/*     */   private List<Menu> menus;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveMenu()
/*     */     throws Exception
/*     */   {
/*  25 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  26 */     if (super.perExecute(this.menu) != null) return returnCommand();
/*  27 */     menuMgr.saveMenu(this.menu);
/*  28 */     super.postExecute(this.menu);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeMenu()
/*     */     throws Exception
/*     */   {
/*  37 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  38 */     menuMgr.removeMenuById(this.menu.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllMenu()
/*     */     throws Exception
/*     */   {
/*  46 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer menuid = new Integer(ids[i]);
/*  55 */         menuMgr.removeMenuById(menuid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewMenu()
/*     */     throws Exception
/*     */   {
/*  67 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  68 */     this.menu = menuMgr.getMenuById(this.menu.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String menuList()
/*     */     throws Exception
/*     */   {
/*  76 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new MenuPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.menus = menuMgr.getSecurityMenuList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public Menu getMenu()
/*     */   {
/*  89 */     return this.menu;
/*     */   }
/*     */ 
/*     */   public void setMenu(Menu menu) {
/*  93 */     this.menu = menu;
/*     */   }
/*     */ 
/*     */   public List<Menu> getMenus() {
/*  97 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public void setMenus(List<Menu> menus) {
/* 101 */     this.menus = menus;
/*     */   }
/*     */ 
/*     */   public MenuPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(MenuPageInfo pageInfo) {
/* 109 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public String getOrderIndexs() {
/* 113 */     return this.orderIndexs;
/*     */   }
/*     */ 
/*     */   public void setOrderIndexs(String orderIndexs) {
/* 117 */     this.orderIndexs = orderIndexs;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.struts.MenuAction
 * JD-Core Version:    0.6.0
 */