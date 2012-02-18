package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.AuthorityPageInfo;
import org.hi.framework.security.model.Authority;
import org.hi.framework.security.service.AuthorityManager;

public class AuthorityAction extends BaseAction{
	private Authority authority;
	private AuthorityPageInfo pageInfo;
	private List<Authority> authoritys;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存权限
	 */
	public String saveAuthority() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		if(super.perExecute(authority)!= null) return returnCommand();
		authorityMgr.saveAuthority(authority);
		super.postExecute(authority);
		return returnCommand();
	}
	
	
	/**
	 * 删除权限
	 */
	public String removeAuthority() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		authorityMgr.removeAuthorityById(authority.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些权限
	 */
	public String removeAllAuthority() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer authorityid = new Integer( ids[i] );
				authorityMgr.removeAuthorityById(authorityid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看权限
	 */
	public String viewAuthority() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		authority = authorityMgr.getAuthorityById(authority.getId());
		return returnCommand();
	}
	
	/**
	 * 权限列表
	 */
	public String authorityList() throws Exception {
		AuthorityManager authorityMgr = (AuthorityManager)SpringContextHolder.getBean(Authority.class);
		pageInfo = pageInfo == null ? new AuthorityPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
