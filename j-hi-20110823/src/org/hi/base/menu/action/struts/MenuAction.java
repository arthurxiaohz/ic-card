package org.hi.base.menu.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.menu.action.MenuPageInfo;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.service.MenuManager;

public class MenuAction extends BaseAction{
	private Menu menu;
	private MenuPageInfo pageInfo;
	private List<Menu> menus;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存菜单项
	 */
	public String saveMenu() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		if(super.perExecute(menu)!= null) return returnCommand();
		menuMgr.saveMenu(menu);
		super.postExecute(menu);
		return returnCommand();
	}
	
	
	/**
	 * 删除菜单项
	 */
	public String removeMenu() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		menuMgr.removeMenuById(menu.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些菜单项
	 */
	public String removeAllMenu() throws Exception {
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
	
	/**
	 *查看菜单项
	 */
	public String viewMenu() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		menu = menuMgr.getMenuById(menu.getId());
		return returnCommand();
	}
	  
	/**
	 * 菜单项列表
	 */
	public String menuList() throws Exception {
		MenuManager menuMgr = (MenuManager)SpringContextHolder.getBean(Menu.class);
		pageInfo = pageInfo == null ? new MenuPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
