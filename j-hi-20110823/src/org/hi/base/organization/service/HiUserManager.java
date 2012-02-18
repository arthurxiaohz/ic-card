package org.hi.base.organization.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.menu.model.Menu;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.service.Manager;

public interface HiUserManager extends Manager{
    /**
     * �����û�
     * @param hiUser
     */
    public void saveHiUser(HiUser hiUser);
    /**
     * ɾ���û�
     * @param id
     */
    public void removeHiUserById(Integer id);
    /**
     * ��ѯ�û�
     * @param id
     * @return
     */
    public HiUser getHiUserById(Integer id);
    /**
     * �û��б�
     * @param pageInfo
     * @return
     */
    public List<HiUser> getHiUserList(PageInfo pageInfo);
    
    public void saveSecurityHiUser(HiUser hiUser);
    public void removeSecurityHiUserById(Integer id);
    public HiUser getSecurityHiUserById(Integer id);
    public List<HiUser> getSecurityHiUserList(PageInfo pageInfo);
    
    public String getAllOrgHTML();
    public String getAllUserByOrgIdHTML(String orgid);
    public String getAllUserHTML();
}
