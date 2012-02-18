package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.UserAuthorityPageInfo;
import org.hi.framework.security.model.UserAuthority;
import org.hi.framework.security.service.UserAuthorityManager;

public class UserAuthorityListAction extends BaseAction{
	private UserAuthority userAuthority;
	private UserAuthorityPageInfo pageInfo;
	private List<UserAuthority> userAuthoritys;
	
	public String execute() throws Exception {
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
}
