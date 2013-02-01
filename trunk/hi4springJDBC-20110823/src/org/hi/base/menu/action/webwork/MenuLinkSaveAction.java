/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.service.MenuLinkManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuLinkSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private MenuLink menuLink;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.menuLink) != null) return returnCommand();
/* 14 */     MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
/* 15 */     menuLinkMgr.saveMenuLink(this.menuLink);
/* 16 */     super.postExecute(this.menuLink);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public MenuLink getMenuLink() {
/* 21 */     return this.menuLink;
/*    */   }
/*    */ 
/*    */   public void setMenuLink(MenuLink menuLink) {
/* 25 */     this.menuLink = menuLink;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuLinkSaveAction
 * JD-Core Version:    0.6.0
 */