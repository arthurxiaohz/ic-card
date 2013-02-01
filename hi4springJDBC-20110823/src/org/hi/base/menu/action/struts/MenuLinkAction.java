/*     */ package org.hi.base.menu.action.struts;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.menu.action.MenuLinkPageInfo;
/*     */ import org.hi.base.menu.model.MenuLink;
/*     */ import org.hi.base.menu.service.MenuLinkManager;
/*     */ import org.hi.framework.paging.PageInfo;
/*     */ import org.hi.framework.web.PageInfoUtil;
/*     */ import org.hi.framework.web.struts.BaseAction;
/*     */ 
/*     */ public class MenuLinkAction extends BaseAction
/*     */ {
/*     */   private MenuLink menuLink;
/*     */   private MenuLinkPageInfo pageInfo;
/*     */   private List<MenuLink> menuLinks;
/*     */   private String orderIndexs;
/*     */ 
/*     */   public String saveMenuLink()
/*     */     throws Exception
/*     */   {
/*  25 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  26 */     if (super.perExecute(this.menuLink) != null) return returnCommand();
/*  27 */     menuLinkMgr.saveMenuLink(this.menuLink);
/*  28 */     super.postExecute(this.menuLink);
/*  29 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeMenuLink()
/*     */     throws Exception
/*     */   {
/*  37 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  38 */     menuLinkMgr.removeMenuLinkById(this.menuLink.getId());
/*  39 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String removeAllMenuLink()
/*     */     throws Exception
/*     */   {
/*  46 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  47 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*     */     {
/*  49 */       String[] ids = this.orderIndexs.split(",");
/*  50 */       for (int i = 0; i < ids.length; i++)
/*     */       {
/*  52 */         if (ids[i].length() <= 0)
/*     */           continue;
/*  54 */         Integer menuLinkid = new Integer(ids[i]);
/*  55 */         menuLinkMgr.removeMenuLinkById(menuLinkid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  60 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String viewMenuLink()
/*     */     throws Exception
/*     */   {
/*  67 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  68 */     this.menuLink = menuLinkMgr.getMenuLinkById(this.menuLink.getId());
/*  69 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public String menuLinkList()
/*     */     throws Exception
/*     */   {
/*  76 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/*  77 */     this.pageInfo = (this.pageInfo == null ? new MenuLinkPageInfo() : this.pageInfo);
/*  78 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*     */ 
/*  80 */     this.menuLinks = menuLinkMgr.getSecurityMenuLinkList(sarchPageInfo);
/*     */ 
/*  82 */     return returnCommand();
/*     */   }
/*     */ 
/*     */   public MenuLink getMenuLink()
/*     */   {
/*  89 */     return this.menuLink;
/*     */   }
/*     */ 
/*     */   public void setMenuLink(MenuLink menuLink) {
/*  93 */     this.menuLink = menuLink;
/*     */   }
/*     */ 
/*     */   public List<MenuLink> getMenuLinks() {
/*  97 */     return this.menuLinks;
/*     */   }
/*     */ 
/*     */   public void setMenuLinks(List<MenuLink> menuLinks) {
/* 101 */     this.menuLinks = menuLinks;
/*     */   }
/*     */ 
/*     */   public MenuLinkPageInfo getPageInfo() {
/* 105 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(MenuLinkPageInfo pageInfo) {
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

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.struts.MenuLinkAction
 * JD-Core Version:    0.6.0
 */