package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxTransferResponsePageInfo;
import cn.net.iccard.tx.model.TblTxTransferResponse;
import cn.net.iccard.tx.service.TblTxTransferResponseManager;

public class TblTxTransferResponseAction extends BaseAction{
	private TblTxTransferResponse tblTxTransferResponse;
	private TblTxTransferResponsePageInfo pageInfo;
	private List<TblTxTransferResponse> tblTxTransferResponses;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存转账交易结果通知
	 */
	public String saveTblTxTransferResponse() throws Exception {
		TblTxTransferResponseManager tblTxTransferResponseMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
		if(super.perExecute(tblTxTransferResponse)!= null) return returnCommand();
		tblTxTransferResponseMgr.saveTblTxTransferResponse(tblTxTransferResponse);
		super.postExecute(tblTxTransferResponse);
		return returnCommand();
	}
	
	
	/**
	 * 删除转账交易结果通知
	 */
	public String removeTblTxTransferResponse() throws Exception {
		TblTxTransferResponseManager tblTxTransferResponseMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
		tblTxTransferResponseMgr.removeTblTxTransferResponseById(tblTxTransferResponse.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些转账交易结果通知
	 */
	public String removeAllTblTxTransferResponse() throws Exception {
		TblTxTransferResponseManager tblTxTransferResponseMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxTransferResponseid = new Integer( ids[i] );
				tblTxTransferResponseMgr.removeTblTxTransferResponseById(tblTxTransferResponseid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看转账交易结果通知
	 */
	public String viewTblTxTransferResponse() throws Exception {
		TblTxTransferResponseManager tblTxTransferResponseMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
		tblTxTransferResponse = tblTxTransferResponseMgr.getTblTxTransferResponseById(tblTxTransferResponse.getId());
		return returnCommand();
	}
	
	/**
	 * 转账交易结果通知列表
	 */
	public String tblTxTransferResponseList() throws Exception {
		TblTxTransferResponseManager tblTxTransferResponseMgr = (TblTxTransferResponseManager)SpringContextHolder.getBean(TblTxTransferResponse.class);
		pageInfo = pageInfo == null ? new TblTxTransferResponsePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxTransferResponses = tblTxTransferResponseMgr.getSecurityTblTxTransferResponseList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxTransferResponse getTblTxTransferResponse() {
		return tblTxTransferResponse;
	}

	public void setTblTxTransferResponse(TblTxTransferResponse tblTxTransferResponse) {
		this.tblTxTransferResponse = tblTxTransferResponse;
	}
	
	public List<TblTxTransferResponse> getTblTxTransferResponses() {
		return tblTxTransferResponses;
	}

	public void setTblTxTransferResponses(List<TblTxTransferResponse> tblTxTransferResponses) {
		this.tblTxTransferResponses = tblTxTransferResponses;
	}

	public TblTxTransferResponsePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxTransferResponsePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
