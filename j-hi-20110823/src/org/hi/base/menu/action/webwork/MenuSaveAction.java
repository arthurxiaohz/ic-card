package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;
import org.hi.framework.web.SynchronizationData;

public class MenuSaveAction extends BaseAction implements SynchronizationData{
	private Menu menu;
	
	public String execute() throws Exception {
		if(super.perExecute(menu)!= null) return returnCommand();
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		menuMgr.saveMenu(menu);
		super.postExecute(menu);
		return returnCommand();
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
