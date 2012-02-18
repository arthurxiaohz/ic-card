package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;

public class MenuLinkRemoveAction extends BaseAction{
	private MenuLink menuLink;
	
	public String execute() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		menuLinkMgr.removeMenuLinkById(menuLink.getId());
		return returnCommand();
	}
	
	public MenuLink getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(MenuLink menuLink) {
		this.menuLink = menuLink;
	}
}
