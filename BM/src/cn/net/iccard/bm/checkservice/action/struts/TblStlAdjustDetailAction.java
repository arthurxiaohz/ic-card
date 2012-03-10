package cn.net.iccard.bm.checkservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.checkservice.action.TblStlAdjustDetailPageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlAdjustDetail;
import cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager;

public class TblStlAdjustDetailAction extends BaseAction{
	private TblStlAdjustDetail tblStlAdjustDetail;
	private TblStlAdjustDetailPageInfo pageInfo;
	private List<TblStlAdjustDetail> tblStlAdjustDetails;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存调账申请表
	 */
	public String saveTblStlAdjustDetail() throws Exception {
		TblStlAdjustDetailManager tblStlAdjustDetailMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
		if(super.perExecute(tblStlAdjustDetail)!= null) return returnCommand();
		tblStlAdjustDetailMgr.saveTblStlAdjustDetail(tblStlAdjustDetail);
		super.postExecute(tblStlAdjustDetail);
		return returnCommand();
	}
	
	
	/**
	 * 删除调账申请表
	 */
	public String removeTblStlAdjustDetail() throws Exception {
		TblStlAdjustDetailManager tblStlAdjustDetailMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
		tblStlAdjustDetailMgr.removeTblStlAdjustDetailById(tblStlAdjustDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些调账申请表
	 */
	public String removeAllTblStlAdjustDetail() throws Exception {
		TblStlAdjustDetailManager tblStlAdjustDetailMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlAdjustDetailid = new Integer( ids[i] );
				tblStlAdjustDetailMgr.removeTblStlAdjustDetailById(tblStlAdjustDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看调账申请表
	 */
	public String viewTblStlAdjustDetail() throws Exception {
		TblStlAdjustDetailManager tblStlAdjustDetailMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
		tblStlAdjustDetail = tblStlAdjustDetailMgr.getTblStlAdjustDetailById(tblStlAdjustDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 调账申请表列表
	 */
	public String tblStlAdjustDetailList() throws Exception {
		TblStlAdjustDetailManager tblStlAdjustDetailMgr = (TblStlAdjustDetailManager)SpringContextHolder.getBean(TblStlAdjustDetail.class);
		pageInfo = pageInfo == null ? new TblStlAdjustDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlAdjustDetails = tblStlAdjustDetailMgr.getSecurityTblStlAdjustDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlAdjustDetail getTblStlAdjustDetail() {
		return tblStlAdjustDetail;
	}

	public void setTblStlAdjustDetail(TblStlAdjustDetail tblStlAdjustDetail) {
		this.tblStlAdjustDetail = tblStlAdjustDetail;
	}
	
	public List<TblStlAdjustDetail> getTblStlAdjustDetails() {
		return tblStlAdjustDetails;
	}

	public void setTblStlAdjustDetails(List<TblStlAdjustDetail> tblStlAdjustDetails) {
		this.tblStlAdjustDetails = tblStlAdjustDetails;
	}

	public TblStlAdjustDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlAdjustDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
