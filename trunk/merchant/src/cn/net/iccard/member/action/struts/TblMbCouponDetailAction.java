package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbCouponDetailPageInfo;
import cn.net.iccard.member.model.TblMbCouponDetail;
import cn.net.iccard.member.service.TblMbCouponDetailManager;

public class TblMbCouponDetailAction extends BaseAction{
	private TblMbCouponDetail tblMbCouponDetail;
	private TblMbCouponDetailPageInfo pageInfo;
	private List<TblMbCouponDetail> tblMbCouponDetails;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存会员优惠券明细
	 */
	public String saveTblMbCouponDetail() throws Exception {
		TblMbCouponDetailManager tblMbCouponDetailMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
		if(super.perExecute(tblMbCouponDetail)!= null) return returnCommand();
		tblMbCouponDetailMgr.saveTblMbCouponDetail(tblMbCouponDetail);
		super.postExecute(tblMbCouponDetail);
		return returnCommand();
	}
	
	
	/**
	 * 删除会员优惠券明细
	 */
	public String removeTblMbCouponDetail() throws Exception {
		TblMbCouponDetailManager tblMbCouponDetailMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
		tblMbCouponDetailMgr.removeTblMbCouponDetailById(tblMbCouponDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些会员优惠券明细
	 */
	public String removeAllTblMbCouponDetail() throws Exception {
		TblMbCouponDetailManager tblMbCouponDetailMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbCouponDetailid = new Integer( ids[i] );
				tblMbCouponDetailMgr.removeTblMbCouponDetailById(tblMbCouponDetailid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看会员优惠券明细
	 */
	public String viewTblMbCouponDetail() throws Exception {
		TblMbCouponDetailManager tblMbCouponDetailMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
		tblMbCouponDetail = tblMbCouponDetailMgr.getTblMbCouponDetailById(tblMbCouponDetail.getId());
		return returnCommand();
	}
	
	/**
	 * 会员优惠券明细列表
	 */
	public String tblMbCouponDetailList() throws Exception {
		TblMbCouponDetailManager tblMbCouponDetailMgr = (TblMbCouponDetailManager)SpringContextHolder.getBean(TblMbCouponDetail.class);
		pageInfo = pageInfo == null ? new TblMbCouponDetailPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbCouponDetails = tblMbCouponDetailMgr.getSecurityTblMbCouponDetailList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbCouponDetail getTblMbCouponDetail() {
		return tblMbCouponDetail;
	}

	public void setTblMbCouponDetail(TblMbCouponDetail tblMbCouponDetail) {
		this.tblMbCouponDetail = tblMbCouponDetail;
	}
	
	public List<TblMbCouponDetail> getTblMbCouponDetails() {
		return tblMbCouponDetails;
	}

	public void setTblMbCouponDetails(List<TblMbCouponDetail> tblMbCouponDetails) {
		this.tblMbCouponDetails = tblMbCouponDetails;
	}

	public TblMbCouponDetailPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbCouponDetailPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
