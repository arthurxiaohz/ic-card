package org.hi.framework.security.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.framework.security.action.RoleAuthorityPageInfo;
import org.hi.framework.security.model.RoleAuthority;
import org.hi.framework.security.service.RoleAuthorityManager;

public class RoleAuthorityAction extends BaseAction{
	private RoleAuthority roleAuthority;
	private RoleAuthorityPageInfo pageInfo;
	private List<RoleAuthority> roleAuthoritys;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存角色权限
	 */
	public String saveRoleAuthority() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		if(super.perExecute(roleAuthority)!= null) return returnCommand();
		roleAuthorityMgr.saveRoleAuthority(roleAuthority);
		super.postExecute(roleAuthority);
		return returnCommand();
	}
	
	
	/**
	 * 删除角色权限
	 */
	public String removeRoleAuthority() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		roleAuthorityMgr.removeRoleAuthorityById(roleAuthority.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些角色权限
	 */
	public String removeAllRoleAuthority() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer roleAuthorityid = new Integer( ids[i] );
				roleAuthorityMgr.removeRoleAuthorityById(roleAuthorityid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看角色权限
	 */
	public String viewRoleAuthority() throws Exception {
		RoleAuthorityManager roleAuthorityMgr = (RoleAuthorityManager)SpringContextHolder.getBean(RoleAuthority.class);
		roleAuthority = roleAuthorityMgr.getRoleAuthorityById(roleAuthority.getId());
		return returnCommand();
	}
	
	/**
	 * 角色权限列表
	 */
	public String roleAuthorityList() throws Exception {
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
