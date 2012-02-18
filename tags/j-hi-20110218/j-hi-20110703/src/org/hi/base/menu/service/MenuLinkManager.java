package org.hi.base.menu.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.menu.model.MenuLink;
import org.hi.framework.service.Manager;

public interface MenuLinkManager extends Manager{
    /**
     * ����˵�����
     * @param menuLink
     */
    public void saveMenuLink(MenuLink menuLink);
    /**
     * ɾ���˵�����
     * @param menuLink
     */
    public void removeMenuLinkById(Integer id);
    /**
     * ����������ѯ�˵�����
     * @param id
     */
    public MenuLink getMenuLinkById(Integer id);
    /**
     * ȡ�ò˵������б�
     * @param menuLink
     */
    public List<MenuLink> getMenuLinkList(PageInfo pageInfo);
    
    public void saveSecurityMenuLink(MenuLink menuLink);
    public void removeSecurityMenuLinkById(Integer id);
    public MenuLink getSecurityMenuLinkById(Integer id);
    public List<MenuLink> getSecurityMenuLinkList(PageInfo pageInfo);
}
