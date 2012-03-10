package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxPayMentOrderPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class TblTxPayMentOrderAction extends BaseAction{
	private TblTxPayMentOrder tblTxPayMentOrder;
	private TblTxPayMentOrderPageInfo pageInfo;
	private List<TblTxPayMentOrder> tblTxPayMentOrders;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存订单查询
	 */
	public String saveTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		if(super.perExecute(tblTxPayMentOrder)!= null) return returnCommand();
		tblTxPayMentOrderMgr.saveTblTxPayMentOrder(tblTxPayMentOrder);
		super.postExecute(tblTxPayMentOrder);
		return returnCommand();
	}
	
	
	/**
	 * 删除订单查询
	 */
	public String removeTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		tblTxPayMentOrderMgr.removeTblTxPayMentOrderById(tblTxPayMentOrder.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些订单查询
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
	 *查看订单查询
	 */
	public String viewTblTxPayMentOrder() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		tblTxPayMentOrder = tblTxPayMentOrderMgr.getTblTxPayMentOrderById(tblTxPayMentOrder.getId());
		return returnCommand();
	}
	
	/**
	 * 订单查询列表
	 */
	public String tblTxPayMentOrderList() throws Exception {
		TblTxPayMentOrderManager tblTxPayMentOrderMgr = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
		
		//点击查询时，更新session中id对应订单的userName和creator
		Integer id = (Integer) getSession().getAttribute("id");
		if (null != id) {
			TblTxPayMentOrder tblTxPayMentOrderTmp = tblTxPayMentOrderMgr.getTblTxPayMentOrderById(id);
			tblTxPayMentOrderTmp.setUserName(org.hi.framework.security.context.UserContextHelper.getUser().getUserName());
			tblTxPayMentOrderTmp.setCreator(org.hi.framework.security.context.UserContextHelper.getUser());
			tblTxPayMentOrderMgr.saveTblTxPayMentOrder(tblTxPayMentOrderTmp);
		}
		
		pageInfo = pageInfo == null ? new TblTxPayMentOrderPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxPayMentOrders = tblTxPayMentOrderMgr.getSecurityTblTxPayMentOrderList(sarchPageInfo);
		
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
