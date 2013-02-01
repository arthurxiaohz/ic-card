/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.action.MenuLinkPageInfo;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.service.MenuLinkManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.web.PageInfoUtil;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuLinkListAction extends BaseAction
/*    */ {
/*    */   private MenuLink menuLink;
/*    */   private MenuLinkPageInfo pageInfo;
/*    */   private List<MenuLink> menuLinks;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 19 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 20 */     this.pageInfo = (this.pageInfo == null ? new MenuLinkPageInfo() : this.pageInfo);
/* 21 */     PageInfo sarchPageInfo = PageInfoUtil.populate(this.pageInfo, this);
/*    */ 
/* 23 */     this.menuLinks = menuLinkMgr.getSecurityMenuLinkList(sarchPageInfo);
/*    */ 
/* 25 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MenuLink getMenuLink() {
/* 29 */     return this.menuLink;
/*    */   }
/*    */ 
/*    */   public void setMenuLink(MenuLink menuLink) {
/* 33 */     this.menuLink = menuLink;
/*    */   }
/*    */ 
/*    */   public List<MenuLink> getMenuLinks() {
/* 37 */     return this.menuLinks;
/*    */   }
/*    */ 
/*    */   public void setMenuLinks(List<MenuLink> menuLinks) {
/* 41 */     this.menuLinks = menuLinks;
/*    */   }
/*    */ 
/*    */   public MenuLinkPageInfo getPageInfo() {
/* 45 */     return this.pageInfo;
/*    */   }
/*    */ 
/*    */   public void setPageInfo(MenuLinkPageInfo pageInfo) {
/* 49 */     this.pageInfo = pageInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuLinkListAction
 * JD-Core Version:    0.6.0
 */