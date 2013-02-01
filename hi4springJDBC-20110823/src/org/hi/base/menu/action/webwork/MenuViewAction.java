/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuViewAction extends BaseAction
/*    */ {
/*    */   private Menu menu;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/* 14 */     this.menu = menuMgr.getMenuById(this.menu.getId());
/* 15 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Menu getMenu() {
/* 19 */     return this.menu;
/*    */   }
/*    */ 
/*    */   public void setMenu(Menu menu) {
/* 23 */     this.menu = menu;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuViewAction
 * JD-Core Version:    0.6.0
 */