package org.hi.test.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.test.action.NationPageInfo;
import org.hi.test.model.Nation;
import org.hi.test.service.NationManager;

public class NationAction extends BaseAction{
	private Nation nation;
	private NationPageInfo pageInfo;
	private List<Nation> nations;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存Nation
	 */
	public String saveNation() throws Exception {
		NationManager nationMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
		if(super.perExecute(nation)!= null) return returnCommand();
		nationMgr.saveNation(nation);
		super.postExecute(nation);
		return returnCommand();
	}
	
	
	/**
	 * 删除Nation
	 */
	public String removeNation() throws Exception {
		NationManager nationMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
		nationMgr.removeNationById(nation.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些Nation
	 */
	public String removeAllNation() throws Exception {
		NationManager nationMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer nationid = new Integer( ids[i] );
				nationMgr.removeNationById(nationid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看Nation
	 */
	public String viewNation() throws Exception {
		NationManager nationMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
		nation = nationMgr.getNationById(nation.getId());
		return returnCommand();
	}
	
	/**
	 * Nation列表
	 */
	public String nationList() throws Exception {
		NationManager nationMgr = (NationManager)SpringContextHolder.getBean(Nation.class);
		pageInfo = pageInfo == null ? new NationPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		nations = nationMgr.getSecurityNationList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}
	
	public List<Nation> getNations() {
		return nations;
	}

	public void setNations(List<Nation> nations) {
		this.nations = nations;
	}

	public NationPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(NationPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
