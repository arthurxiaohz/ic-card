package org.hi.base.organization.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.organization.action.HiOrgPageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.service.HiOrgManager;

public class HiOrgAction extends BaseAction{
	private HiOrg hiOrg;
	private HiOrgPageInfo pageInfo;
	private List<HiOrg> hiOrgs;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存部门
	 */
	public String saveHiOrg() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		if(super.perExecute(hiOrg)!= null) return returnCommand();
		hiOrgMgr.saveHiOrg(hiOrg);
		super.postExecute(hiOrg);
		return returnCommand();
	}
	
	
	/**
	 * 删除部门
	 */
	public String removeHiOrg() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		hiOrgMgr.removeHiOrgById(hiOrg.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些部门
	 */
	public String removeAllHiOrg() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer hiOrgid = new Integer( ids[i] );
				hiOrgMgr.removeHiOrgById(hiOrgid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看部门
	 */
	public String viewHiOrg() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		hiOrg = hiOrgMgr.getHiOrgById(hiOrg.getId());
		return returnCommand();
	}
	
	/**
	 * 部门列表
	 */
	public String hiOrgList() throws Exception {
		HiOrgManager hiOrgMgr = (HiOrgManager)SpringContextHolder.getBean(HiOrg.class);
		pageInfo = pageInfo == null ? new HiOrgPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		hiOrgs = hiOrgMgr.getSecurityHiOrgList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public HiOrg getHiOrg() {
		return hiOrg;
	}

	public void setHiOrg(HiOrg hiOrg) {
		this.hiOrg = hiOrg;
	}
	
	public List<HiOrg> getHiOrgs() {
		return hiOrgs;
	}

	public void setHiOrgs(List<HiOrg> hiOrgs) {
		this.hiOrgs = hiOrgs;
	}

	public HiOrgPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(HiOrgPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
