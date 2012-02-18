package org.hi.base.menu.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.base.menu.action.MenuLinkPageInfo;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

public class MenuLinkListAction extends BaseAction{
	private MenuLink menuLink;
	private MenuLinkPageInfo pageInfo;
	private List<MenuLink> menuLinks;
	
	public String execute() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		pageInfo = pageInfo == null ? new MenuLinkPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		menuLinks = menuLinkMgr.getSecurityMenuLinkList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public MenuLink getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(MenuLink menuLink) {
		this.menuLink = menuLink;
	}
	
	public List<MenuLink> getMenuLinks() {
		return menuLinks;
	}

	public void setMenuLinks(List<MenuLink> menuLinks) {
		this.menuLinks = menuLinks;
	}

	public MenuLinkPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MenuLinkPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
