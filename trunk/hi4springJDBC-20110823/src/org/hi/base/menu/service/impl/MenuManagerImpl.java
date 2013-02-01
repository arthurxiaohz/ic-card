/*    */ package org.hi.base.menu.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.menu.model.Menu;
/*    */ import org.hi.base.menu.service.MenuManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class MenuManagerImpl extends ManagerImpl
/*    */   implements MenuManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 19 */     Menu menu = (Menu)obj;
/* 20 */     if (menu.getCreator() == null)
/* 21 */       menu.setCreator(UserContextHelper.getUser());
/* 22 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 29 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 36 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 43 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveMenu(Menu Menu)
/*    */   {
/* 50 */     saveObject(Menu);
/*    */   }
/*    */ 
/*    */   public void removeMenuById(Integer id)
/*    */   {
/* 57 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public Menu getMenuById(Integer id)
/*    */   {
/* 64 */     return (Menu)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<Menu> getMenuList(PageInfo pageInfo)
/*    */   {
/* 70 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityMenu(Menu menu) {
/* 74 */     saveObject(menu);
/*    */   }
/*    */   public void removeSecurityMenuById(Integer id) {
/* 77 */     removeObjectById(id);
/*    */   }
/*    */   public Menu getSecurityMenuById(Integer id) {
/* 80 */     return (Menu)getObjectById(id);
/*    */   }
/*    */   public List<Menu> getSecurityMenuList(PageInfo pageInfo) {
/* 83 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.service.impl.MenuManagerImpl
 * JD-Core Version:    0.6.0
 */