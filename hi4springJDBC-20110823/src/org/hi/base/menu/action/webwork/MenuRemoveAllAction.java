/*    */ package org.hi.base.menu.action.webwork;
/*    */ 
/*    */ import org.hi.SpringContextHolder;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.framework.web.webwork.BaseAction;
/*    */ 
/*    */ public class MenuRemoveAllAction extends BaseAction
/*    */ {
/*    */   private Menu menu;
/*    */   private String orderIndexs;
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 14 */     MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
/*    */ 
/* 16 */     if ((this.orderIndexs != null) && (this.orderIndexs.length() > 0))
/*    */     {
/* 18 */       String[] ids = this.orderIndexs.split(",");
/* 19 */       for (int i = 0; i < ids.length; i++)
/*    */       {
/* 21 */         if (ids[i].length() <= 0)
/*    */           continue;
/* 23 */         Integer menuid = new Integer(ids[i]);
/* 24 */         menuMgr.removeMenuById(menuid);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 29 */     return returnCommand();
/*    */   }
/*    */ 
/*    */   public Menu getMenu() {
/* 33 */     return this.menu;
/*    */   }
/*    */ 
/*    */   public void setMenu(Menu menu) {
/* 37 */     this.menu = menu;
/*    */   }
/*    */ 
/*    */   public String getOrderIndexs() {
/* 41 */     return this.orderIndexs;
/*    */   }
/*    */ 
/*    */   public void setOrderIndexs(String orderIndexs) {
/* 45 */     this.orderIndexs = orderIndexs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.action.webwork.MenuRemoveAllAction
 * JD-Core Version:    0.6.0
 */