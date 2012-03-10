package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxTransferRequestPageInfo;
import cn.net.iccard.tx.model.TblTxTransferRequest;
import cn.net.iccard.tx.service.TblTxTransferRequestManager;

public class TblTxTransferRequestAction extends BaseAction{
	private TblTxTransferRequest tblTxTransferRequest;
	private TblTxTransferRequestPageInfo pageInfo;
	private List<TblTxTransferRequest> tblTxTransferRequests;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存转账交易请求
	 */
	public String saveTblTxTransferRequest() throws Exception {
		TblTxTransferRequestManager tblTxTransferRequestMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
		if(super.perExecute(tblTxTransferRequest)!= null) return returnCommand();
		tblTxTransferRequestMgr.saveTblTxTransferRequest(tblTxTransferRequest);
		super.postExecute(tblTxTransferRequest);
		return returnCommand();
	}
	
	
	/**
	 * 删除转账交易请求
	 */
	public String removeTblTxTransferRequest() throws Exception {
		TblTxTransferRequestManager tblTxTransferRequestMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
		tblTxTransferRequestMgr.removeTblTxTransferRequestById(tblTxTransferRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些转账交易请求
	 */
	public String removeAllTblTxTransferRequest() throws Exception {
		TblTxTransferRequestManager tblTxTransferRequestMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxTransferRequestid = new Integer( ids[i] );
				tblTxTransferRequestMgr.removeTblTxTransferRequestById(tblTxTransferRequestid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看转账交易请求
	 */
	public String viewTblTxTransferRequest() throws Exception {
		TblTxTransferRequestManager tblTxTransferRequestMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
		tblTxTransferRequest = tblTxTransferRequestMgr.getTblTxTransferRequestById(tblTxTransferRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 转账交易请求列表
	 */
	public String tblTxTransferRequestList() throws Exception {
		TblTxTransferRequestManager tblTxTransferRequestMgr = (TblTxTransferRequestManager)SpringContextHolder.getBean(TblTxTransferRequest.class);
		pageInfo = pageInfo == null ? new TblTxTransferRequestPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxTransferRequests = tblTxTransferRequestMgr.getSecurityTblTxTransferRequestList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxTransferRequest getTblTxTransferRequest() {
		return tblTxTransferRequest;
	}

	public void setTblTxTransferRequest(TblTxTransferRequest tblTxTransferRequest) {
		this.tblTxTransferRequest = tblTxTransferRequest;
	}
	
	public List<TblTxTransferRequest> getTblTxTransferRequests() {
		return tblTxTransferRequests;
	}

	public void setTblTxTransferRequests(List<TblTxTransferRequest> tblTxTransferRequests) {
		this.tblTxTransferRequests = tblTxTransferRequests;
	}

	public TblTxTransferRequestPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxTransferRequestPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
