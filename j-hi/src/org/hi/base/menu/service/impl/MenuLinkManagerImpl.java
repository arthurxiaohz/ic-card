package org.hi.base.menu.service.impl;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.menu.service.MenuLinkManager;

public class MenuLinkManagerImpl extends ManagerImpl implements MenuLinkManager{
  
	
	/**
	 * 保存菜单链接之前的操作
	 */
    protected void preSaveObject(Object obj) {
    	MenuLink link = (MenuLink)obj;
    	if(link.getCreator() == null)
    		link.setCreator(UserContextHelper.getUser());
        super.preSaveObject(obj);

    }

    /**
     * 保存菜单链接之后的操作
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
	 * 删除对象之前的操作
	 */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
     * 删除对象之后的操作
     */
    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    /**
     * 保存菜单链接
     */
    public void saveMenuLink(MenuLink MenuLink){
    	saveObject(MenuLink);
    
    }
    /**
     * 根据主键删除菜单链接
     */
    public void removeMenuLinkById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * 根据主键查询一个菜单链接对象
     */
    public MenuLink getMenuLinkById(Integer id){
   		return (MenuLink) getObjectById(id);
    }
    /**
     * 返回菜单链接列表
     */
    public List<MenuLink> getMenuLinkList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
    
    
    public void saveSecurityMenuLink(MenuLink menuLink){
    	saveObject(menuLink);
    }
    public void removeSecurityMenuLinkById(Integer id){
    	removeObjectById(id);
    }
    public MenuLink getSecurityMenuLinkById(Integer id){
    	return (MenuLink) getObjectById(id);
    }
    public List<MenuLink> getSecurityMenuLinkList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }
}
