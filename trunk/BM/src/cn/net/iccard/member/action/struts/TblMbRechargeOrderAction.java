package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbRechargeOrderPageInfo;
import cn.net.iccard.member.model.TblMbRechargeOrder;
import cn.net.iccard.member.service.TblMbRechargeOrderManager;

public class TblMbRechargeOrderAction extends BaseAction{
	private TblMbRechargeOrder tblMbRechargeOrder;
	private TblMbRechargeOrderPageInfo pageInfo;
	private List<TblMbRechargeOrder> tblMbRechargeOrders;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����ֵ����
	 */
	public String saveTblMbRechargeOrder() throws Exception {
		TblMbRechargeOrderManager tblMbRechargeOrderMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
		if(super.perExecute(tblMbRechargeOrder)!= null) return returnCommand();
		tblMbRechargeOrderMgr.saveTblMbRechargeOrder(tblMbRechargeOrder);
		super.postExecute(tblMbRechargeOrder);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����ֵ����
	 */
	public String removeTblMbRechargeOrder() throws Exception {
		TblMbRechargeOrderManager tblMbRechargeOrderMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
		tblMbRechargeOrderMgr.removeTblMbRechargeOrderById(tblMbRechargeOrder.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��ֵ����
	 */
	public String removeAllTblMbRechargeOrder() throws Exception {
		TblMbRechargeOrderManager tblMbRechargeOrderMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbRechargeOrderid = new Integer( ids[i] );
				tblMbRechargeOrderMgr.removeTblMbRechargeOrderById(tblMbRechargeOrderid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��ֵ����
	 */
	public String viewTblMbRechargeOrder() throws Exception {
		TblMbRechargeOrderManager tblMbRechargeOrderMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
		tblMbRechargeOrder = tblMbRechargeOrderMgr.getTblMbRechargeOrderById(tblMbRechargeOrder.getId());
		return returnCommand();
	}
	
	/**
	 * ��ֵ�����б�
	 */
	public String tblMbRechargeOrderList() throws Exception {
		TblMbRechargeOrderManager tblMbRechargeOrderMgr = (TblMbRechargeOrderManager)SpringContextHolder.getBean(TblMbRechargeOrder.class);
		pageInfo = pageInfo == null ? new TblMbRechargeOrderPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbRechargeOrders = tblMbRechargeOrderMgr.getSecurityTblMbRechargeOrderList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbRechargeOrder getTblMbRechargeOrder() {
		return tblMbRechargeOrder;
	}

	public void setTblMbRechargeOrder(TblMbRechargeOrder tblMbRechargeOrder) {
		this.tblMbRechargeOrder = tblMbRechargeOrder;
	}
	
	public List<TblMbRechargeOrder> getTblMbRechargeOrders() {
		return tblMbRechargeOrders;
	}

	public void setTblMbRechargeOrders(List<TblMbRechargeOrder> tblMbRechargeOrders) {
		this.tblMbRechargeOrders = tblMbRechargeOrders;
	}

	public TblMbRechargeOrderPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbRechargeOrderPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
