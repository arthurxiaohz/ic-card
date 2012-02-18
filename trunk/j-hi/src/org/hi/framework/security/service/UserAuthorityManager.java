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
     * 为给定的用户批量授权
     * @param users 用户集合
     * @param userAuthorities 权限及相关(部门、范围)集合
     */
    public void saveBatchUserAuthority(List<HiUser> users, List<UserAuthority> userAuthorities);
    
    /**
     * 得到给定用户的用户权限
     * @param user 用户
     * @return
     */
    public List<UserAuthority> getUserAuthority(HiUser user);
    
    /**
     * 根据userAuthorities集合给定的脚标indexs保存指定脚标元素的数据
     * @param indexs
     * @param userAuthorities
     */
    public void saveBatchSingleUserAuthority(String[] indexs, List<UserAuthority> userAuthorities, HiUser user);
    
    /**
     * 删除与该用户相关的所有权限
     * @param userId 用户ID
     */
    public void removeUserAuthorityByUser(Integer userId);
    
    /**
     * 通过给定的角色权限，删除与角色对应的用户权限
     * @param roleAuthority
     */
    public void removeUserAuthorityByRoleAuthority(RoleAuthority roleAuthority);
    
    public void saveSecurityUserAuthority(UserAuthority userAuthority);
    public void removeSecurityUserAuthorityById(Integer id);
    public UserAuthority getSecurityUserAuthorityById(Integer id);
    public List<UserAuthority> getSecurityUserAuthorityList(PageInfo pageInfo);
}
