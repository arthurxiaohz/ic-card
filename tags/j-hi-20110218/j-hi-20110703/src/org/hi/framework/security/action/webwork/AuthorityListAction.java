package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.AuthorityPageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;

public class AuthorityListAction extends BaseAction{
	private Authority authority;
	private AuthorityPageInfo pageInfo;
	private List<Authority> authoritys;
	
	public String execute() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		pageInfo = pageInfo == null ? new AuthorityPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo,this);
		
		authoritys = authorityMgr.getAuthorityList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}

	public AuthorityPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(AuthorityPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
