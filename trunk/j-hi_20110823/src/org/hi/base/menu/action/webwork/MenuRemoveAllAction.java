package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;

public class MenuRemoveAllAction extends BaseAction{
	private Menu menu;
	private String orderIndexs;
	
	public String execute() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer menuid = new Integer( ids[i] );
				menuMgr.removeMenuById(menuid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	

}
