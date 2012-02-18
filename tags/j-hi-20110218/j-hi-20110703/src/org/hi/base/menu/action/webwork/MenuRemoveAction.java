package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;

public class MenuRemoveAction extends BaseAction{
	private Menu menu;
	
	public String execute() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		menuMgr.removeMenuById(menu.getId());
		return returnCommand();
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
