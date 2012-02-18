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
	 * �������֮ǰ�Ĳ���
	 */
    protected void preSaveObject(Object obj) {
    	Menu menu = (Menu)obj;
    	if(menu.getCreator() == null)
    		menu.setCreator(UserContextHelper.getUser());
        super.preSaveObject(obj);

    }
    /**
     * �������֮��Ĳ���
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
     * ɾ���˵�֮ǰ�Ĳ���
     */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
     * ɾ���˵�֮��Ĳ���
     */
    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    /**
     * ����˵�
     */
    public void saveMenu(Menu Menu){
    	saveObject(Menu);
    
    }
    /**
     * ����IDɾ���˵�
     */
    public void removeMenuById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * ����ID��ѯ�˵�
     */
    public Menu getMenuById(Integer id){
   		return (Menu) getObjectById(id);
    }
    /**
     * �˵��б�
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
