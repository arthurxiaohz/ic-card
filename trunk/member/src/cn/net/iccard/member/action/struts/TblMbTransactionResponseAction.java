package cn.net.iccard.member.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.member.action.TblMbTransactionResponsePageInfo;
import cn.net.iccard.member.model.TblMbTransactionResponse;
import cn.net.iccard.member.service.TblMbTransactionResponseManager;

public class TblMbTransactionResponseAction extends BaseAction{
	private TblMbTransactionResponse tblMbTransactionResponse;
	private TblMbTransactionResponsePageInfo pageInfo;
	private List<TblMbTransactionResponse> tblMbTransactionResponses;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存网关交易结果
	 */
	public String saveTblMbTransactionResponse() throws Exception {
		TblMbTransactionResponseManager tblMbTransactionResponseMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
		if(super.perExecute(tblMbTransactionResponse)!= null) return returnCommand();
		tblMbTransactionResponseMgr.saveTblMbTransactionResponse(tblMbTransactionResponse);
		super.postExecute(tblMbTransactionResponse);
		return returnCommand();
	}
	
	
	/**
	 * 删除网关交易结果
	 */
	public String removeTblMbTransactionResponse() throws Exception {
		TblMbTransactionResponseManager tblMbTransactionResponseMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
		tblMbTransactionResponseMgr.removeTblMbTransactionResponseById(tblMbTransactionResponse.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些网关交易结果
	 */
	public String removeAllTblMbTransactionResponse() throws Exception {
		TblMbTransactionResponseManager tblMbTransactionResponseMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblMbTransactionResponseid = new Integer( ids[i] );
				tblMbTransactionResponseMgr.removeTblMbTransactionResponseById(tblMbTransactionResponseid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看网关交易结果
	 */
	public String viewTblMbTransactionResponse() throws Exception {
		TblMbTransactionResponseManager tblMbTransactionResponseMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
		tblMbTransactionResponse = tblMbTransactionResponseMgr.getTblMbTransactionResponseById(tblMbTransactionResponse.getId());
		return returnCommand();
	}
	
	/**
	 * 网关交易结果列表
	 */
	public String tblMbTransactionResponseList() throws Exception {
		TblMbTransactionResponseManager tblMbTransactionResponseMgr = (TblMbTransactionResponseManager)SpringContextHolder.getBean(TblMbTransactionResponse.class);
		pageInfo = pageInfo == null ? new TblMbTransactionResponsePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblMbTransactionResponses = tblMbTransactionResponseMgr.getSecurityTblMbTransactionResponseList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblMbTransactionResponse getTblMbTransactionResponse() {
		return tblMbTransactionResponse;
	}

	public void setTblMbTransactionResponse(TblMbTransactionResponse tblMbTransactionResponse) {
		this.tblMbTransactionResponse = tblMbTransactionResponse;
	}
	
	public List<TblMbTransactionResponse> getTblMbTransactionResponses() {
		return tblMbTransactionResponses;
	}

	public void setTblMbTransactionResponses(List<TblMbTransactionResponse> tblMbTransactionResponses) {
		this.tblMbTransactionResponses = tblMbTransactionResponses;
	}

	public TblMbTransactionResponsePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMbTransactionResponsePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
