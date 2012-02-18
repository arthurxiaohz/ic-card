package org.hi.base.menu.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.menu.action.MenuLinkPageInfo;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.menu.service.MenuLinkManager;

public class MenuLinkAction extends BaseAction{
	private MenuLink menuLink;
	private MenuLinkPageInfo pageInfo;
	private List<MenuLink> menuLinks;
	private String orderIndexs;
	   
	
	/**
	 * 新增/修改保存菜单链接
	 */
	public String saveMenuLink() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		if(super.perExecute(menuLink)!= null) return returnCommand();
		menuLinkMgr.saveMenuLink(menuLink);
		super.postExecute(menuLink);
		return returnCommand();
	}
	
	
	/**
	 * 删除菜单链接
	 */
	public String removeMenuLink() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		menuLinkMgr.removeMenuLinkById(menuLink.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些菜单链接
	 */
	public String removeAllMenuLink() throws Exception {
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
	
	/**
	 *查看菜单链接
	 */
	public String viewMenuLink() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		menuLink = menuLinkMgr.getMenuLinkById(menuLink.getId());
		return returnCommand();
	}
	
	/**
	 * 菜单链接列表
	 */
	public String menuLinkList() throws Exception {
		MenuLinkManager menuLinkMgr = (MenuLinkManager)SpringContextHolder.getBean(MenuLink.class);
		pageInfo = pageInfo == null ? new MenuLinkPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
