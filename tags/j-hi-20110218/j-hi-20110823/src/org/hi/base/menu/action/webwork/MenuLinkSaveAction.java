package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.framework.web.SynchronizationData;

public class MenuLinkSaveAction extends BaseAction implements SynchronizationData{
	private MenuLink menuLink;
	
	public String execute() throws Exception {
		if(super.perExecute(menuLink)!= null) return returnCommand();
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		menuLinkMgr.saveMenuLink(menuLink);
		super.postExecute(menuLink);
		return returnCommand();
	}
	
	public MenuLink getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(MenuLink menuLink) {
		this.menuLink = menuLink;
	}

}
