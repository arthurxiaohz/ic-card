package org.hi.base.menu.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.menu.model.Menu;
import org.hi.framework.service.Manager;

public interface MenuManager extends Manager{
    /**
     * 保存菜单
     * @param menu
     */
    public void saveMenu(Menu menu);
    /**
     * 根据主键删除菜单
     * @param id
     */
    public void removeMenuById(Integer id);
    /**
     * 根据主键查询菜单
     * @param id
     * @return
     */
    public Menu getMenuById(Integer id);
    /**
     * 取得菜单列表
     * @param pageInfo
     * @return
     */
    public List<Menu> getMenuList(PageInfo pageInfo);
    
    public void saveSecurityMenu(Menu menu);
    public void removeSecurityMenuById(Integer id);
    public Menu getSecurityMenuById(Integer id);
    public List<Menu> getSecurityMenuList(PageInfo pageInfo);
}
