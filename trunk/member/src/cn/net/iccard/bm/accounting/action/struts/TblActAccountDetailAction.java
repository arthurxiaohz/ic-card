package cn.net.iccard.bm.accounting.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.accounting.action.TblActAccountDetailPageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountDetail;
import cn.net.iccard.bm.accounting.service.TblActAccountDetailManager;

public class TblActAccountDetailAction extends BaseAction{
	private TblActAccountDetail tblActAccountDetail;
	private TblActAccountDetailPageInfo pageInfo;
	private List<TblActAccountDetail> tblActAccountDetails;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存账户明细
	 */
	public String saveTblActAccountDetail() throws Exception {
		TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
		if(super.perExecute(tblActAccountDetail)!= null) return returnCommand();
		tblActAccountDetailMgr.saveTblActAccountDetail(tblActAccountDetail);
		super.postExecute(tblActAccountDetail);
		return returnCommand();
	}
	
	
	/**
	 * 删除账户明细
	 */
	public String removeTblActAccountDetail() throws Exception {
		TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
		tblActAccountDetailMgr.removeTblActAccountDetailById(tblActAccountDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些账户明细
	 */
	public String removeAllTblActAccountDetail() throws Exception {
		TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblActAccountDetailid = new Integer( ids[i] );
				tblActAccountDetailMgr.removeTblActAccountDetailById(tblActAccountDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看账户明细
	 */
	public String viewTblActAccountDetail() throws Exception {
		TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
		tblActAccountDetail = tblActAccountDetailMgr.getTblActAccountDetailById(tblActAccountDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 账户明细列表
	 */
	public String tblActAccountDetailList() throws Exception {
		TblActAccountDetailManager tblActAccountDetailMgr = (TblActAccountDetailManager)SpringContextHolder.getBean(TblActAccountDetail.class);
		pageInfo = pageInfo == null ? new TblActAccountDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblActAccountDetails = tblActAccountDetailMgr.getSecurityTblActAccountDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblActAccountDetail getTblActAccountDetail() {
		return tblActAccountDetail;
	}

	public void setTblActAccountDetail(TblActAccountDetail tblActAccountDetail) {
		this.tblActAccountDetail = tblActAccountDetail;
	}
	
	public List<TblActAccountDetail> getTblActAccountDetails() {
		return tblActAccountDetails;
	}

	public void setTblActAccountDetails(List<TblActAccountDetail> tblActAccountDetails) {
		this.tblActAccountDetails = tblActAccountDetails;
	}

	public TblActAccountDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblActAccountDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
