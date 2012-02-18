package org.hi.base.menu.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.menu.model.Menu;
import org.hi.framework.service.Manager;

public interface MenuManager extends Manager{
    /**
     * ����˵�
     * @param menu
     */
    public void saveMenu(Menu menu);
    /**
     * ��������ɾ���˵�
     * @param id
     */
    public void removeMenuById(Integer id);
    /**
     * ����������ѯ�˵�
     * @param id
     * @return
     */
    public Menu getMenuById(Integer id);
    /**
     * ȡ�ò˵��б�
     * @param pageInfo
     * @return
     */
    public List<Menu> getMenuList(PageInfo pageInfo);
    
    public void saveSecurityMenu(Menu menu);
    public void removeSecurityMenuById(Integer id);
    public Menu getSecurityMenuById(Integer id);
    public List<Menu> getSecurityMenuList(PageInfo pageInfo);
}
