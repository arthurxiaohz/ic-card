/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.service.MenuLinkManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuLinkRemoveAction extends BaseAction
/*    */ {
/*    */   private MenuLink menuLink;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 14 */     menuLinkMgr.removeMenuLinkById(this.menuLink.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MenuLink getMenuLink() {
/* 19 */     return this.menuLink;
/*    */   }
/*    */ 
/*    */   public void setMenuLink(MenuLink menuLink) {
/* 23 */     this.menuLink = menuLink;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuLinkRemoveAction
 * JD-Core Version:    0.6.0
 */