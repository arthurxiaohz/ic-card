package org.hi.framework.security.service;

import java.util.List;

import org.hi.base.organization.model.HiUser;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContext;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.model.UserGroup;
import org.hi.framework.security.model.UserRole;
import org.springframework.dao.DataAccessException;

/**
 * 安全管理器接口该接口是SPI,目的是通过给定用户帐号得到用户信息,包括用户基本信息,该用户拥有的角色,该用户拥有
 * 的用户权限,该用户所在的用户组及该用户的上下文信息.
 * 该接口是后端服务接口,您可以通过<code>UserContextHelper</code>类到上述所有信息
 * @author 张昊
 * @since 2007-1-27
 * @see org.hi.framework.security.context.UserContextHelper
 *
 */
public interface SecurityManager {
	/**
	 * 通过给定的用户帐号得到该用户的基本信息
	 * @param username 用户帐号
	 * @return 返回与给定帐号对应的<code>HiUser</code>实例
	 */
	public HiUser getUser(String username);
	
	/**
	 * 通过给定用户实例得到该用户所拥有的权限
	 * @param user 用户实例
	 * @return 返回给定用户所拥有的权限
	 * @throws DataAccessException 如果该用户没有任何权限将抛出该异常
	 */
	public List<UserAuthority> getUserAuthorities(HiUser user) throws DataAccessException;
	
	/**
	 * 通过给定用户实例得到该用户所拥有的角色
	 * @param user 用户实例
	 * @return 返回给定用户所拥有的角色
	 */
	public List<UserRole> getUserRoles(HiUser user);
	
	/**
	 * 通过给定用户实例得到该用户所在的用户组
	 * @param user 用户实例
	 * @return 返回给定用户所在的用户组
	 */
	public List<UserGroup> getUserGroups(HiUser user);
	
	/**
	 * 通过给定用户实例得到该用户的用户上下文
	 * @param user 用户实例
	 * @return 返回给定用户的用户上下文

	 */
	public UserContext getUserContext(String username);
	
}
