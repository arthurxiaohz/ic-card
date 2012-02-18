package org.hi.base.menu.action.webwork.actionExt;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.hi.base.menu.strutsmenu.WebDynamicTreeManager;
import org.hi.framework.web.webwork.BaseAction;

/**
 * @author ’≈Íª
 * Created on 2005-03-25
 */
public class CommonTreeAction extends BaseAction {

	private static final long serialVersionUID = 811769890701070558L;
	private String forward =  null;
	
	public String execute()throws Exception {
		forward = getParameter("type");
		HttpServletRequest request = getRequest();
		HashMap parMap = new HashMap();
		Enumeration enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String element = (String) enumeration.nextElement();
			parMap.put(element, request.getParameter(element));
		}
		WebDynamicTreeManager treemgr=new WebDynamicTreeManager();
		request.setAttribute("com.hi.tree.menu",treemgr.getMenu(getParameter("menuName"),parMap,request));

		return forward == null || forward.trim().equals("") ? "commonxtree" : forward;
	}
}
