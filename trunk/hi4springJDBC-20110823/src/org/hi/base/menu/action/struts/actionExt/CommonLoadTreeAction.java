/*    */ package org.hi.base.menu.action.struts.actionExt;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.HashMap;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import net.sf.navigator.menu.MenuComponent;
/*    */ import org.hi.base.menu.strutsmenu.WebDynamicTreeManager;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class CommonLoadTreeAction extends BaseAction
/*    */ {
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 20 */     HttpServletRequest request = getRequest();
/* 21 */     HashMap parMap = new HashMap();
/* 22 */     Enumeration enumeration = request.getParameterNames();
/* 23 */     while (enumeration.hasMoreElements()) {
/* 24 */       String element = (String)enumeration.nextElement();
/* 25 */       if ((("type".equals(element) ? 0 : 1) & ("menuName".equals(element) ? 0 : 1)) != 0)
/* 26 */         parMap.put(element, request.getParameter(element));
/*    */     }
/* 28 */     WebDynamicTreeManager treemgr = new WebDynamicTreeManager();
/* 29 */     String type = request.getParameter("type");
/* 30 */     MenuComponent menu = treemgr.getLoadMenu(request.getParameter("menuName"), parMap, type == null ? "commonloadxtree" : type, request);
/* 31 */     request.setAttribute("com.hi.tree.menu", menu);
/*    */ 
/* 33 */     return getParameter("type");
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.struts.actionExt.CommonLoadTreeAction
 * JD-Core Version:    0.6.0
 */