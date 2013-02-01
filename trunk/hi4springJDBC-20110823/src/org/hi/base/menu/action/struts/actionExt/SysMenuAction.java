/*    */ package org.hi.base.menu.action.struts.actionExt;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.HashMap;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.hi.base.menu.strutsmenu.SysMenuTreeManager;
/*    */ import org.hi.framework.web.struts.BaseAction;
/*    */ 
/*    */ public class SysMenuAction extends BaseAction
/*    */ {
/*    */   private static final long serialVersionUID = 811769890701070558L;
/* 18 */   private String forward = null;
/*    */ 
/*    */   public String execute() throws Exception {
/* 21 */     this.forward = getParameter("type");
/* 22 */     HttpServletRequest request = getRequest();
/* 23 */     HashMap parMap = new HashMap();
/* 24 */     Enumeration enumeration = request.getParameterNames();
/* 25 */     while (enumeration.hasMoreElements()) {
/* 26 */       String element = (String)enumeration.nextElement();
/* 27 */       parMap.put(element, request.getParameter(element));
/*    */     }
/* 29 */     SysMenuTreeManager treemgr = new SysMenuTreeManager();
/* 30 */     request.setAttribute("com.hi.tree.menu", treemgr.getMenu(getParameter("menuName"), parMap, request));
/*    */ 
/* 32 */     return (this.forward == null) || (this.forward.trim().equals("")) ? "commonxtree" : this.forward;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.action.struts.actionExt.SysMenuAction
 * JD-Core Version:    0.6.0
 */