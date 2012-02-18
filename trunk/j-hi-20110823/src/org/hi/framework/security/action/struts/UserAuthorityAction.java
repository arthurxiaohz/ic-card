package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.UserAuthorityPageInfo;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;

public class UserAuthorityAction extends BaseAction{
	private UserAuthority userAuthority;
	private UserAuthorityPageInfo pageInfo;
	private List<UserAuthority> userAuthoritys;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存用户权限
	 */
	public String saveUserAuthority() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		if(super.perExecute(userAuthority)!= null) return returnCommand();
		userAuthorityMgr.saveUserAuthority(userAuthority);
		super.postExecute(userAuthority);
		return returnCommand();
	}
	
	
	/**
	 * 删除用户权限
	 */
	public String removeUserAuthority() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		userAuthorityMgr.removeUserAuthorityById(userAuthority.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些用户权限
	 */
	public String removeAllUserAuthority() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer userAuthorityid = new Integer( ids[i] );
				userAuthorityMgr.removeUserAuthorityById(userAuthorityid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看用户权限
	 */
	public String viewUserAuthority() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		userAuthority = userAuthorityMgr.getUserAuthorityById(userAuthority.getId());
		return returnCommand();
	}
	
	/**
	 * 用户权限列表
	 */
	public String userAuthorityList() throws Exception {
		UserAuthorityManager userAuthorityMgr = (UserAuthorityManager)SpringContextHolder.getBean(UserAuthority.class);
		pageInfo = pageInfo == null ? new UserAuthorityPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		userAuthoritys = userAuthorityMgr.getUserAuthorityList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public UserAuthority getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthority userAuthority) {
		this.userAuthority = userAuthority;
	}
	
	public List<UserAuthority> getUserAuthoritys() {
		return userAuthoritys;
	}

	public void setUserAuthoritys(List<UserAuthority> userAuthoritys) {
		this.userAuthoritys = userAuthoritys;
	}

	public UserAuthorityPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(UserAuthorityPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
