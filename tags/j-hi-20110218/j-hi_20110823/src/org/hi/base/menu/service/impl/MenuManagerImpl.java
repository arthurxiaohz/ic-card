package org.hi.base.menu.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.menu.service.MenuManager;

public class MenuManagerImpl extends ManagerImpl implements MenuManager{
    
	/**
	 * 保存对象之前的操作
	 */
    protected void preSaveObject(Object obj) {
    	Menu menu = (Menu)obj;
    	if(menu.getCreator() == null)
    		menu.setCreator(UserContextHelper.getUser());
        super.preSaveObject(obj);

    }
    /**
     * 保存对象之后的操作
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
     * 删除菜单之前的操作
     */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
     * 删除菜单之后的操作
     */
    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    /**
     * 保存菜单
     */
    public void saveMenu(Menu Menu){
    	saveObject(Menu);
    
    }
    /**
     * 根据ID删除菜单
     */
    public void removeMenuById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * 根据ID查询菜单
     */
    public Menu getMenuById(Integer id){
   		return (Menu) getObjectById(id);
    }
    /**
     * 菜单列表
     */
    public List<Menu> getMenuList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    public void saveSecurityMenu(Menu menu){
    	saveObject(menu);
    }
    public void removeSecurityMenuById(Integer id){
    	removeObjectById(id);
    }
    public Menu getSecurityMenuById(Integer id){
    	return (Menu) getObjectById(id);
    }
    public List<Menu> getSecurityMenuList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
}
