package org.hi.framework.security.context;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;

/**
 * 该类是一个工具类,所有的成员方法均是静态的,目的只是更方便的获取与当前用户相关的信息.
 * 其原理是通过Acegi提供的<code>SecurityContextHolder</code>类得获取以线程为key的一个
 * <code>SecurityContext</code>实例
 * @see org.hi.framework.security.context.UserContext
 * @see org.acegisecurity.context.SecurityContextHolder
 * @see org.acegisecurity.context.SecurityContext
 * @author 张昊
 * @since 2007-1-21
 *
 */
public class UserContextHelper {
    
    /**
     * 当前登录用户的上下文
     * @return 返回当前用户的上下文
     */
    public static UserContext getUserContext(){
    	return getAuthentication() != null && getAuthentication().getPrincipal() instanceof UserContext ? (UserContext)(getAuthentication().getPrincipal()) : null ;
    }
    
    /**
     * @return
     * @see org.acegisecurity.context.SecurityContextHolder#getContext()
     */
    public static SecurityContext getContext(){
    	return SecurityContextHolder.getContext();
    }
       
    /**
     * @return
     * @see org.acegisecurity.context.SecurityContext#getAuthentication()
     */
    public static Authentication getAuthentication(){
    	return getContext() == null ? null :getContext().getAuthentication();
    }
    
	/**
	 * 当前用户的基本信息,HiUser的POJO
	 * @return 返回当前用户的基本信息
	 */
    public static HiUser getUser(){
    	return getUserContext() == null ? null : getUserContext().getUser();
    }
    
	/**
	 * 当前用户所在部门的信息
	 * @return 返回当前用户所在的部门
	 */
    public static HiOrg getOrg(){
    	return getUserContext() == null ? null : getUserContext().getOrg();
    }
    
	/**
	 * 获得当前用户的ID值
	 * @return 返回当前用户的ID值
	 */
    public static Integer getUserId(){
    	return getUserContext() == null ? null : getUserContext().getUserId();
    }
 
	/**
	 * 获得当前用户所在部门的部门管理者的ID值
	 * @return 当前用户的部门领导的ID值
	 */
    public static Integer getOrgId(){
    	return getUserContext() == null ? null : getUserContext().getOrgId();
    }
    
	/**
	 * 获得当前用户的名称
	 * @return 返回当前用户的名称
	 */
    public static String getUserName(){
    	return getUserContext() == null ? null : getUserContext().getUserName();
    }
    
	/**
	 * 获得当前用户所在部门的部门名称
	 * @return 当前用户的部门的部门名称
	 */    
    public static String getOrgName(){
    	return getUserContext() == null ? null : getUserContext().getOrgName();
    }
}
