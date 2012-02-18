package org.hi.base.menu.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.menu.action.MenuLinkPageInfo;
import org.hi.base.menu.action.MenuPageInfo;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;

public class MenuListAction extends BaseAction{
	private Menu menu;
	private MenuPageInfo pageInfo;
	private List<Menu> menus;
	
	public String execute() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		pageInfo = pageInfo == null ? new MenuPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		menus = menuMgr.getSecurityMenuList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public MenuPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(MenuPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
