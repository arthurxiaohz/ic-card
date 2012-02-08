package org.hi.base.menu.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.menu.model.MenuLink;
import org.hi.framework.service.Manager;

public interface MenuLinkManager extends Manager{
    /**
     * 保存菜单链接
     * @param menuLink
     */
    public void saveMenuLink(MenuLink menuLink);
    /**
     * 删除菜单链接
     * @param menuLink
     */
    public void removeMenuLinkById(Integer id);
    /**
     * 根据主键查询菜单链接
     * @param id
     */
    public MenuLink getMenuLinkById(Integer id);
    /**
     * 取得菜单链接列表
     * @param menuLink
     */
    public List<MenuLink> getMenuLinkList(PageInfo pageInfo);
    
    public void saveSecurityMenuLink(MenuLink menuLink);
    public void removeSecurityMenuLinkById(Integer id);
    public MenuLink getSecurityMenuLinkById(Integer id);
    public List<MenuLink> getSecurityMenuLinkList(PageInfo pageInfo);
}
