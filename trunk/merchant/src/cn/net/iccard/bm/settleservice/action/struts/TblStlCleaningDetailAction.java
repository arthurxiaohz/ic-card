package cn.net.iccard.bm.settleservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.settleservice.action.TblStlCleaningDetailPageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlCleaningDetail;
import cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager;

public class TblStlCleaningDetailAction extends BaseAction{
	private TblStlCleaningDetail tblStlCleaningDetail;
	private TblStlCleaningDetailPageInfo pageInfo;
	private List<TblStlCleaningDetail> tblStlCleaningDetails;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存清分流水表
	 */
	public String saveTblStlCleaningDetail() throws Exception {
		TblStlCleaningDetailManager tblStlCleaningDetailMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
		if(super.perExecute(tblStlCleaningDetail)!= null) return returnCommand();
		tblStlCleaningDetailMgr.saveTblStlCleaningDetail(tblStlCleaningDetail);
		super.postExecute(tblStlCleaningDetail);
		return returnCommand();
	}
	
	
	/**
	 * 删除清分流水表
	 */
	public String removeTblStlCleaningDetail() throws Exception {
		TblStlCleaningDetailManager tblStlCleaningDetailMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
		tblStlCleaningDetailMgr.removeTblStlCleaningDetailById(tblStlCleaningDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些清分流水表
	 */
	public String removeAllTblStlCleaningDetail() throws Exception {
		TblStlCleaningDetailManager tblStlCleaningDetailMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlCleaningDetailid = new Integer( ids[i] );
				tblStlCleaningDetailMgr.removeTblStlCleaningDetailById(tblStlCleaningDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看清分流水表
	 */
	public String viewTblStlCleaningDetail() throws Exception {
		TblStlCleaningDetailManager tblStlCleaningDetailMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
		tblStlCleaningDetail = tblStlCleaningDetailMgr.getTblStlCleaningDetailById(tblStlCleaningDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 清分流水表列表
	 */
	public String tblStlCleaningDetailList() throws Exception {
		TblStlCleaningDetailManager tblStlCleaningDetailMgr = (TblStlCleaningDetailManager)SpringContextHolder.getBean(TblStlCleaningDetail.class);
		pageInfo = pageInfo == null ? new TblStlCleaningDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlCleaningDetails = tblStlCleaningDetailMgr.getSecurityTblStlCleaningDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlCleaningDetail getTblStlCleaningDetail() {
		return tblStlCleaningDetail;
	}

	public void setTblStlCleaningDetail(TblStlCleaningDetail tblStlCleaningDetail) {
		this.tblStlCleaningDetail = tblStlCleaningDetail;
	}
	
	public List<TblStlCleaningDetail> getTblStlCleaningDetails() {
		return tblStlCleaningDetails;
	}

	public void setTblStlCleaningDetails(List<TblStlCleaningDetail> tblStlCleaningDetails) {
		this.tblStlCleaningDetails = tblStlCleaningDetails;
	}

	public TblStlCleaningDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlCleaningDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
