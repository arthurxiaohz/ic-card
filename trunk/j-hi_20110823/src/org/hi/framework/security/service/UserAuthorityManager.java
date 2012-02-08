package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.service.Manager;

public interface UserAuthorityManager extends Manager{
    
    public void saveUserAuthority(UserAuthority userAuthority);

    public void removeUserAuthorityById(Integer id);

    public UserAuthority getUserAuthorityById(Integer id);

    public List<UserAuthority> getUserAuthorityList(PageInfo pageInfo);
    
    
    /**
     * Ϊ�������û�������Ȩ
     * @param users �û�����
     * @param userAuthorities Ȩ�޼����(���š���Χ)����
     */
    public void saveBatchUserAuthority(List<HiUser> users, List<UserAuthority> userAuthorities);
    
    /**
     * �õ������û����û�Ȩ��
     * @param user �û�
     * @return
     */
    public List<UserAuthority> getUserAuthority(HiUser user);
    
    /**
     * ����userAuthorities���ϸ����Ľű�indexs����ָ���ű�Ԫ�ص�����
     * @param indexs
     * @param userAuthorities
     */
    public void saveBatchSingleUserAuthority(String[] indexs, List<UserAuthority> userAuthorities, HiUser user);
    
    /**
     * ɾ������û���ص�����Ȩ��
     * @param userId �û�ID
     */
    public void removeUserAuthorityByUser(Integer userId);
    
    /**
     * ͨ�������Ľ�ɫȨ�ޣ�ɾ�����ɫ��Ӧ���û�Ȩ��
     * @param roleAuthority
     */
    public void removeUserAuthorityByRoleAuthority(RoleAuthority roleAuthority);
    
    public void saveSecurityUserAuthority(UserAuthority userAuthority);
    public void removeSecurityUserAuthorityById(Integer id);
    public UserAuthority getSecurityUserAuthorityById(Integer id);
    public List<UserAuthority> getSecurityUserAuthorityList(PageInfo pageInfo);
}
