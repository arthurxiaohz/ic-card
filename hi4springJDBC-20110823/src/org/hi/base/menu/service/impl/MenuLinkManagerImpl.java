/*    */ package org.hi.base.menu.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hi.base.menu.model.MenuLink;
/*    */ import org.hi.base.menu.service.MenuLinkManager;
/*    */ import org.hi.framework.paging.PageInfo;
/*    */ import org.hi.framework.security.context.UserContextHelper;
/*    */ import org.hi.framework.service.impl.ManagerImpl;
/*    */ 
/*    */ public class MenuLinkManagerImpl extends ManagerImpl
/*    */   implements MenuLinkManager
/*    */ {
/*    */   protected void preSaveObject(Object obj)
/*    */   {
/* 19 */     MenuLink link = (MenuLink)obj;
/* 20 */     if (link.getCreator() == null)
/* 21 */       link.setCreator(UserContextHelper.getUser());
/* 22 */     super.preSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postSaveObject(Object obj)
/*    */   {
/* 30 */     super.postSaveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void preRemoveObject(Object obj)
/*    */   {
/* 37 */     super.preRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   protected void postRemoveObject(Object obj)
/*    */   {
/* 44 */     super.postRemoveObject(obj);
/*    */   }
/*    */ 
/*    */   public void saveMenuLink(MenuLink MenuLink)
/*    */   {
/* 51 */     saveObject(MenuLink);
/*    */   }
/*    */ 
/*    */   public void removeMenuLinkById(Integer id)
/*    */   {
/* 58 */     removeObjectById(id);
/*    */   }
/*    */ 
/*    */   public MenuLink getMenuLinkById(Integer id)
/*    */   {
/* 65 */     return (MenuLink)getObjectById(id);
/*    */   }
/*    */ 
/*    */   public List<MenuLink> getMenuLinkList(PageInfo pageInfo)
/*    */   {
/* 71 */     return super.getList(pageInfo);
/*    */   }
/*    */ 
/*    */   public void saveSecurityMenuLink(MenuLink menuLink)
/*    */   {
/* 76 */     saveObject(menuLink);
/*    */   }
/*    */   public void removeSecurityMenuLinkById(Integer id) {
/* 79 */     removeObjectById(id);
/*    */   }
/*    */   public MenuLink getSecurityMenuLinkById(Integer id) {
/* 82 */     return (MenuLink)getObjectById(id);
/*    */   }
/*    */   public List<MenuLink> getSecurityMenuLinkList(PageInfo pageInfo) {
/* 85 */     return super.getList(pageInfo);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.service.impl.MenuLinkManagerImpl
 * JD-Core Version:    0.6.0
 */