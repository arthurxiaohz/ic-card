package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbCouponPageInfo;
import cn.net.iccard.member.model.TblMbCoupon;
import cn.net.iccard.member.service.TblMbCouponManager;

public class TblMbCouponAction extends BaseAction{
	private TblMbCoupon tblMbCoupon;
	private TblMbCouponPageInfo pageInfo;
	private List<TblMbCoupon> tblMbCoupons;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����Ա�Ż�ȯ
	 */
	public String saveTblMbCoupon() throws Exception {
		TblMbCouponManager tblMbCouponMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
		if(super.perExecute(tblMbCoupon)!= null) return returnCommand();
		tblMbCouponMgr.saveTblMbCoupon(tblMbCoupon);
		super.postExecute(tblMbCoupon);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����Ա�Ż�ȯ
	 */
	public String removeTblMbCoupon() throws Exception {
		TblMbCouponManager tblMbCouponMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
		tblMbCouponMgr.removeTblMbCouponById(tblMbCoupon.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��Ա�Ż�ȯ
	 */
	public String removeAllTblMbCoupon() throws Exception {
		TblMbCouponManager tblMbCouponMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbCouponid = new Integer( ids[i] );
				tblMbCouponMgr.removeTblMbCouponById(tblMbCouponid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��Ա�Ż�ȯ
	 */
	public String viewTblMbCoupon() throws Exception {
		TblMbCouponManager tblMbCouponMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
		tblMbCoupon = tblMbCouponMgr.getTblMbCouponById(tblMbCoupon.getId());
		return returnCommand();
	}
	
	/**
	 * ��Ա�Ż�ȯ�б�
	 */
	public String tblMbCouponList() throws Exception {
		TblMbCouponManager tblMbCouponMgr = (TblMbCouponManager)SpringContextHolder.getBean(TblMbCoupon.class);
		pageInfo = pageInfo == null ? new TblMbCouponPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbCoupons = tblMbCouponMgr.getSecurityTblMbCouponList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbCoupon getTblMbCoupon() {
		return tblMbCoupon;
	}

	public void setTblMbCoupon(TblMbCoupon tblMbCoupon) {
		this.tblMbCoupon = tblMbCoupon;
	}
	
	public List<TblMbCoupon> getTblMbCoupons() {
		return tblMbCoupons;
	}

	public void setTblMbCoupons(List<TblMbCoupon> tblMbCoupons) {
		this.tblMbCoupons = tblMbCoupons;
	}

	public TblMbCouponPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbCouponPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
