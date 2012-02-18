package org.hi.base.menu.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;

public class MenuLinkRemoveAllAction extends BaseAction{
	private MenuLink menuLink;
	private String orderIndexs;
	
	public String execute() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer menuLinkid = new Integer( ids[i] );
				menuLinkMgr.removeMenuLinkById(menuLinkid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public MenuLink getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(MenuLink menuLink) {
		this.menuLink = menuLink;
	}

	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	

	
}
