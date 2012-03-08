package cn.net.iccard.bm.checkservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.checkservice.action.TblStlOrganizationPageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlOrganization;
import cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager;

public class TblStlOrganizationAction extends BaseAction{
	private TblStlOrganization tblStlOrganization;
	private TblStlOrganizationPageInfo pageInfo;
	private List<TblStlOrganization> tblStlOrganizations;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存发卡行支持表
	 */
	public String saveTblStlOrganization() throws Exception {
		TblStlOrganizationManager tblStlOrganizationMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
		if(super.perExecute(tblStlOrganization)!= null) return returnCommand();
		tblStlOrganizationMgr.saveTblStlOrganization(tblStlOrganization);
		super.postExecute(tblStlOrganization);
		return returnCommand();
	}
	
	
	/**
	 * 删除发卡行支持表
	 */
	public String removeTblStlOrganization() throws Exception {
		TblStlOrganizationManager tblStlOrganizationMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
		tblStlOrganizationMgr.removeTblStlOrganizationById(tblStlOrganization.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些发卡行支持表
	 */
	public String removeAllTblStlOrganization() throws Exception {
		TblStlOrganizationManager tblStlOrganizationMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlOrganizationid = new Integer( ids[i] );
				tblStlOrganizationMgr.removeTblStlOrganizationById(tblStlOrganizationid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看发卡行支持表
	 */
	public String viewTblStlOrganization() throws Exception {
		TblStlOrganizationManager tblStlOrganizationMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
		tblStlOrganization = tblStlOrganizationMgr.getTblStlOrganizationById(tblStlOrganization.getId());
		return returnCommand();
	}
	
	/**
	 * 发卡行支持表列表
	 */
	public String tblStlOrganizationList() throws Exception {
		TblStlOrganizationManager tblStlOrganizationMgr = (TblStlOrganizationManager)SpringContextHolder.getBean(TblStlOrganization.class);
		pageInfo = pageInfo == null ? new TblStlOrganizationPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlOrganizations = tblStlOrganizationMgr.getSecurityTblStlOrganizationList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlOrganization getTblStlOrganization() {
		return tblStlOrganization;
	}

	public void setTblStlOrganization(TblStlOrganization tblStlOrganization) {
		this.tblStlOrganization = tblStlOrganization;
	}
	
	public List<TblStlOrganization> getTblStlOrganizations() {
		return tblStlOrganizations;
	}

	public void setTblStlOrganizations(List<TblStlOrganization> tblStlOrganizations) {
		this.tblStlOrganizations = tblStlOrganizations;
	}

	public TblStlOrganizationPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlOrganizationPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
