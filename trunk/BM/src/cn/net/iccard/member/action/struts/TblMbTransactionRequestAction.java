package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbTransactionRequestPageInfo;
import cn.net.iccard.member.model.TblMbTransactionRequest;
import cn.net.iccard.member.service.TblMbTransactionRequestManager;

public class TblMbTransactionRequestAction extends BaseAction{
	private TblMbTransactionRequest tblMbTransactionRequest;
	private TblMbTransactionRequestPageInfo pageInfo;
	private List<TblMbTransactionRequest> tblMbTransactionRequests;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存网关交易请求
	 */
	public String saveTblMbTransactionRequest() throws Exception {
		TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
		if(super.perExecute(tblMbTransactionRequest)!= null) return returnCommand();
		tblMbTransactionRequestMgr.saveTblMbTransactionRequest(tblMbTransactionRequest);
		super.postExecute(tblMbTransactionRequest);
		return returnCommand();
	}
	
	
	/**
	 * 删除网关交易请求
	 */
	public String removeTblMbTransactionRequest() throws Exception {
		TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
		tblMbTransactionRequestMgr.removeTblMbTransactionRequestById(tblMbTransactionRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些网关交易请求
	 */
	public String removeAllTblMbTransactionRequest() throws Exception {
		TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbTransactionRequestid = new Integer( ids[i] );
				tblMbTransactionRequestMgr.removeTblMbTransactionRequestById(tblMbTransactionRequestid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看网关交易请求
	 */
	public String viewTblMbTransactionRequest() throws Exception {
		TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
		tblMbTransactionRequest = tblMbTransactionRequestMgr.getTblMbTransactionRequestById(tblMbTransactionRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 网关交易请求列表
	 */
	public String tblMbTransactionRequestList() throws Exception {
		TblMbTransactionRequestManager tblMbTransactionRequestMgr = (TblMbTransactionRequestManager)SpringContextHolder.getBean(TblMbTransactionRequest.class);
		pageInfo = pageInfo == null ? new TblMbTransactionRequestPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbTransactionRequests = tblMbTransactionRequestMgr.getSecurityTblMbTransactionRequestList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbTransactionRequest getTblMbTransactionRequest() {
		return tblMbTransactionRequest;
	}

	public void setTblMbTransactionRequest(TblMbTransactionRequest tblMbTransactionRequest) {
		this.tblMbTransactionRequest = tblMbTransactionRequest;
	}
	
	public List<TblMbTransactionRequest> getTblMbTransactionRequests() {
		return tblMbTransactionRequests;
	}

	public void setTblMbTransactionRequests(List<TblMbTransactionRequest> tblMbTransactionRequests) {
		this.tblMbTransactionRequests = tblMbTransactionRequests;
	}

	public TblMbTransactionRequestPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbTransactionRequestPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
