/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.framework.web.SynchronizationData;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuSaveAction extends BaseAction
/*    */   implements SynchronizationData
/*    */ {
/*    */   private Menu menu;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 13 */     if (super.perExecute(this.menu) != null) return returnCommand();
/* 14 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/* 15 */     menuMgr.saveMenu(this.menu);
/* 16 */     super.postExecute(this.menu);
/* 17 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Menu getMenu() {
/* 21 */     return this.menu;
/*    */   }
/*    */ 
/*    */   public void setMenu(Menu menu) {
/* 25 */     this.menu = menu;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuSaveAction
 * JD-Core Version:    0.6.0
 */