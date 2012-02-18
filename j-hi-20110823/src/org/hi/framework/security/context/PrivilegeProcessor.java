package org.hi.framework.security.context;

import javax.servlet.http.HttpServletRequest;

import org.hi.framework.dao.Filter;
import org.hi.framework.security.model.UserAuthority;

/**
 * 该接口是自定义权限范围的权限处理器,当在定义角色或权限用户授权时,如果在范围下拉中选择自定义权限范围时
 * 就会在页面的左侧出现权限处理器的文本框,在该文本框中输入该接口子类的全限定义.从原理上来说,权限处理器无非是
 * 回调该接口的声明方法以返回一个过滤器,系统会自动将该过滤器自动封闭为数据库的查询条件.
 * @author 张昊
 * @since 2011-8-15
 * @org.hi.framework.security.context.PrivilegeProcessorFactory
 *
 */
public interface PrivilegeProcessor {
	/**
	 * 如果权限范围是自定义权限范围,系统会自动调用该方法,并通过该方法返回的过滤器进行条件查询
	 * @param request Http的Request对象,以方便动态的取一些动态的查询值
	 * @param userAuthority 该权限处理器所对应的用户权限,在该参数中你可以获当前的取权限信息
	 * @return 返回一个权限的过滤器
	 */
	public Filter getPrivilegeFilter(HttpServletRequest request, UserAuthority userAuthority);
}
