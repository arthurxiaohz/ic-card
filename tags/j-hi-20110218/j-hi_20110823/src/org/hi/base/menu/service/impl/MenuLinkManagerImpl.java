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
	 * ����˵�����֮ǰ�Ĳ���
	 */
    protected void preSaveObject(Object obj) {
    	MenuLink link = (MenuLink)obj;
    	if(link.getCreator() == null)
    		link.setCreator(UserContextHelper.getUser());
        super.preSaveObject(obj);

    }

    /**
     * ����˵�����֮��Ĳ���
     */
    protected void postSaveObject(Object obj) {
        super.postSaveObject(obj);

    }
    /**
	 * ɾ������֮ǰ�Ĳ���
	 */
    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }
    /**
     * ɾ������֮��Ĳ���
     */
    protected void postRemoveObject(Object obj) {
        super.postRemoveObject(obj);
        
    }
    /**
     * ����˵�����
     */
    public void saveMenuLink(MenuLink MenuLink){
    	saveObject(MenuLink);
    
    }
    /**
     * ��������ɾ���˵�����
     */
    public void removeMenuLinkById(Integer id){
    	removeObjectById(id);
    	
    }
    /**
     * ����������ѯһ���˵����Ӷ���
     */
    public MenuLink getMenuLinkById(Integer id){
   		return (MenuLink) getObjectById(id);
    }
    /**
     * ���ز˵������б�
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
