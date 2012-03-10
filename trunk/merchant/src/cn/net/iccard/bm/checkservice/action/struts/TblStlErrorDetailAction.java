package cn.net.iccard.bm.checkservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.checkservice.action.TblStlErrorDetailPageInfo;
import cn.net.iccard.bm.checkservice.model.TblStlErrorDetail;
import cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager;

public class TblStlErrorDetailAction extends BaseAction{
	private TblStlErrorDetail tblStlErrorDetail;
	private TblStlErrorDetailPageInfo pageInfo;
	private List<TblStlErrorDetail> tblStlErrorDetails;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存差错明细表
	 */
	public String saveTblStlErrorDetail() throws Exception {
		TblStlErrorDetailManager tblStlErrorDetailMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
		if(super.perExecute(tblStlErrorDetail)!= null) return returnCommand();
		tblStlErrorDetailMgr.saveTblStlErrorDetail(tblStlErrorDetail);
		super.postExecute(tblStlErrorDetail);
		return returnCommand();
	}
	
	
	/**
	 * 删除差错明细表
	 */
	public String removeTblStlErrorDetail() throws Exception {
		TblStlErrorDetailManager tblStlErrorDetailMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
		tblStlErrorDetailMgr.removeTblStlErrorDetailById(tblStlErrorDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些差错明细表
	 */
	public String removeAllTblStlErrorDetail() throws Exception {
		TblStlErrorDetailManager tblStlErrorDetailMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlErrorDetailid = new Integer( ids[i] );
				tblStlErrorDetailMgr.removeTblStlErrorDetailById(tblStlErrorDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看差错明细表
	 */
	public String viewTblStlErrorDetail() throws Exception {
		TblStlErrorDetailManager tblStlErrorDetailMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
		tblStlErrorDetail = tblStlErrorDetailMgr.getTblStlErrorDetailById(tblStlErrorDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 差错明细表列表
	 */
	public String tblStlErrorDetailList() throws Exception {
		TblStlErrorDetailManager tblStlErrorDetailMgr = (TblStlErrorDetailManager)SpringContextHolder.getBean(TblStlErrorDetail.class);
		pageInfo = pageInfo == null ? new TblStlErrorDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlErrorDetails = tblStlErrorDetailMgr.getSecurityTblStlErrorDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlErrorDetail getTblStlErrorDetail() {
		return tblStlErrorDetail;
	}

	public void setTblStlErrorDetail(TblStlErrorDetail tblStlErrorDetail) {
		this.tblStlErrorDetail = tblStlErrorDetail;
	}
	
	public List<TblStlErrorDetail> getTblStlErrorDetails() {
		return tblStlErrorDetails;
	}

	public void setTblStlErrorDetails(List<TblStlErrorDetail> tblStlErrorDetails) {
		this.tblStlErrorDetails = tblStlErrorDetails;
	}

	public TblStlErrorDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlErrorDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
