package org.hi.base.menu.action.webwork.actionExt;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.navigator.menu.MenuComponent;

import org.hi.base.menu.strutsmenu.WebDynamicTreeManager;
import org.hi.framework.web.webwork.BaseAction;
/**
 * @author ’≈Íª
 * Created on 2005-03-25
 */
public class CommonLoadTreeAction extends BaseAction {

	public String execute()throws Exception {
		
		HttpServletRequest request = getRequest();
		HashMap parMap = new HashMap();
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String element = (String) enumeration.nextElement();
			if ( !"type".equals(element) & !"menuName".equals(element))
			parMap.put(element, request.getParameter(element));
		}
		WebDynamicTreeManager treemgr=new WebDynamicTreeManager();
		String type = request.getParameter("type");
		MenuComponent menu = treemgr.getLoadMenu(request.getParameter("menuName"), parMap,type == null ? "commonloadxtree":type,request);
		request.setAttribute("com.hi.tree.menu",menu);

		return getParameter("type");		
		
	}
		
/*
		HttpServletRequest request = contain.getRequest();
		HashMap parMap = new HashMap();
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String element = (String) enumeration.nextElement();
			parMap.put(element, request.getParameter(element));
		}
		WebDynamicTreeManager treemgr=new WebDynamicTreeManager();
		request.setAttribute("com.hi.tree.menu",treemgr.getMenu(request.getParameter("menuName"),parMap,contain));

		return contain.getParameter("type");
	}
*/
}
