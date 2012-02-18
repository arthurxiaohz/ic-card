package org.hi.framework.security.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.framework.security.action.RoleAuthorityPageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.RoleAuthorityManager;

public class RoleAuthorityListAction extends BaseAction{
	private RoleAuthority roleAuthority;
	private RoleAuthorityPageInfo pageInfo;
	private List<RoleAuthority> roleAuthoritys;
	
	public String execute() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		pageInfo = pageInfo == null ? new RoleAuthorityPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		roleAuthoritys = roleAuthorityMgr.getRoleAuthorityList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public RoleAuthority getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthority roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	
	public List<RoleAuthority> getRoleAuthoritys() {
		return roleAuthoritys;
	}

	public void setRoleAuthoritys(List<RoleAuthority> roleAuthoritys) {
		this.roleAuthoritys = roleAuthoritys;
	}

	public RoleAuthorityPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(RoleAuthorityPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
