package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxPayMentRequestPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;

public class TblTxPayMentRequestAction extends BaseAction{
	private TblTxPayMentRequest tblTxPayMentRequest;
	private TblTxPayMentRequestPageInfo pageInfo;
	private List<TblTxPayMentRequest> tblTxPayMentRequests;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存商户请求原始报文
	 */
	public String saveTblTxPayMentRequest() throws Exception {
		TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
		if(super.perExecute(tblTxPayMentRequest)!= null) return returnCommand();
		tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
		super.postExecute(tblTxPayMentRequest);
		return returnCommand();
	}
	
	
	/**
	 * 删除商户请求原始报文
	 */
	public String removeTblTxPayMentRequest() throws Exception {
		TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
		tblTxPayMentRequestMgr.removeTblTxPayMentRequestById(tblTxPayMentRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些商户请求原始报文
	 */
	public String removeAllTblTxPayMentRequest() throws Exception {
		TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxPayMentRequestid = new Integer( ids[i] );
				tblTxPayMentRequestMgr.removeTblTxPayMentRequestById(tblTxPayMentRequestid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看商户请求原始报文
	 */
	public String viewTblTxPayMentRequest() throws Exception {
		TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
		tblTxPayMentRequest = tblTxPayMentRequestMgr.getTblTxPayMentRequestById(tblTxPayMentRequest.getId());
		return returnCommand();
	}
	
	/**
	 * 商户请求原始报文列表
	 */
	public String tblTxPayMentRequestList() throws Exception {
		TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);
		pageInfo = pageInfo == null ? new TblTxPayMentRequestPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxPayMentRequests = tblTxPayMentRequestMgr.getSecurityTblTxPayMentRequestList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxPayMentRequest getTblTxPayMentRequest() {
		return tblTxPayMentRequest;
	}

	public void setTblTxPayMentRequest(TblTxPayMentRequest tblTxPayMentRequest) {
		this.tblTxPayMentRequest = tblTxPayMentRequest;
	}
	
	public List<TblTxPayMentRequest> getTblTxPayMentRequests() {
		return tblTxPayMentRequests;
	}

	public void setTblTxPayMentRequests(List<TblTxPayMentRequest> tblTxPayMentRequests) {
		this.tblTxPayMentRequests = tblTxPayMentRequests;
	}

	public TblTxPayMentRequestPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxPayMentRequestPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
