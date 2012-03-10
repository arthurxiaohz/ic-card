package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;
import cn.net.iccard.tx.action.TblTxPayMentOrderPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class TblTxPayMentOrderAction extends BaseAction{
	private TblTxPayMentOrder tblTxPayMentOrder;
	private TblTxPayMentOrderPageInfo pageInfo;
	private List<TblTxPayMentOrder> tblTxPayMentOrders;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存交易订单
	 */
	public String saveTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		if(super.perExecute(tblTxPayMentOrder)!= null) return returnCommand();
		tblTxPayMentOrderMgr.saveTblTxPayMentOrder(tblTxPayMentOrder);
		super.postExecute(tblTxPayMentOrder);
		return returnCommand();
	}
	
	
	/**
	 * 删除交易订单
	 */
	public String removeTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		tblTxPayMentOrderMgr.removeTblTxPayMentOrderById(tblTxPayMentOrder.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些交易订单
	 */
	public String removeAllTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxPayMentOrderid = new Integer( ids[i] );
				tblTxPayMentOrderMgr.removeTblTxPayMentOrderById(tblTxPayMentOrderid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看交易订单
	 */
	public String viewTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		tblTxPayMentOrder = tblTxPayMentOrderMgr.getTblTxPayMentOrderById(tblTxPayMentOrder.getId());
		return returnCommand();
	}
	
	/**
	 * 交易订单列表
	 */
	public String tblTxPayMentOrderList() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager) SpringContextHolder
				.getBean(TblTxPayMentOrder.class);
		pageInfo = pageInfo == null ? new TblTxPayMentOrderPageInfo()
				: pageInfo;

		//锁定查询所属商户
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager) SpringContextHolder
				.getBean(TblMchtUser.class);
		pageInfo.setF_mchtNo(tblMchtUserMgr.getTblMchtUserById(
				(org.hi.framework.security.context.UserContextHelper.getUser()
						.getId())).getMchtNo());
		
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);

		tblTxPayMentOrders = tblTxPayMentOrderMgr
				.getSecurityTblTxPayMentOrderList(sarchPageInfo);

		return returnCommand();
	}
	
	
	
	
	public TblTxPayMentOrder getTblTxPayMentOrder() {
		return tblTxPayMentOrder;
	}

	public void setTblTxPayMentOrder(TblTxPayMentOrder tblTxPayMentOrder) {
		this.tblTxPayMentOrder = tblTxPayMentOrder;
	}
	
	public List<TblTxPayMentOrder> getTblTxPayMentOrders() {
		return tblTxPayMentOrders;
	}

	public void setTblTxPayMentOrders(List<TblTxPayMentOrder> tblTxPayMentOrders) {
		this.tblTxPayMentOrders = tblTxPayMentOrders;
	}

	public TblTxPayMentOrderPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxPayMentOrderPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
