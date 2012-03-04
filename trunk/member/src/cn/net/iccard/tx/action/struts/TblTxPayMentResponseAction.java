package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxPayMentResponsePageInfo;
import cn.net.iccard.tx.model.TblTxPayMentResponse;
import cn.net.iccard.tx.service.TblTxPayMentResponseManager;

public class TblTxPayMentResponseAction extends BaseAction{
	private TblTxPayMentResponse tblTxPayMentResponse;
	private TblTxPayMentResponsePageInfo pageInfo;
	private List<TblTxPayMentResponse> tblTxPayMentResponses;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����̻����֪ͨ
	 */
	public String saveTblTxPayMentResponse() throws Exception {
		TblTxPayMentResponseManager tblTxPayMentResponseMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
		if(super.perExecute(tblTxPayMentResponse)!= null) return returnCommand();
		tblTxPayMentResponseMgr.saveTblTxPayMentResponse(tblTxPayMentResponse);
		super.postExecute(tblTxPayMentResponse);
		return returnCommand();
	}
	
	
	/**
	 * ɾ���̻����֪ͨ
	 */
	public String removeTblTxPayMentResponse() throws Exception {
		TblTxPayMentResponseManager tblTxPayMentResponseMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
		tblTxPayMentResponseMgr.removeTblTxPayMentResponseById(tblTxPayMentResponse.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ�̻����֪ͨ
	 */
	public String removeAllTblTxPayMentResponse() throws Exception {
		TblTxPayMentResponseManager tblTxPayMentResponseMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxPayMentResponseid = new Integer( ids[i] );
				tblTxPayMentResponseMgr.removeTblTxPayMentResponseById(tblTxPayMentResponseid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴�̻����֪ͨ
	 */
	public String viewTblTxPayMentResponse() throws Exception {
		TblTxPayMentResponseManager tblTxPayMentResponseMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
		tblTxPayMentResponse = tblTxPayMentResponseMgr.getTblTxPayMentResponseById(tblTxPayMentResponse.getId());
		return returnCommand();
	}
	
	/**
	 * �̻����֪ͨ�б�
	 */
	public String tblTxPayMentResponseList() throws Exception {
		TblTxPayMentResponseManager tblTxPayMentResponseMgr = (TblTxPayMentResponseManager)SpringContextHolder.getBean(TblTxPayMentResponse.class);
		pageInfo = pageInfo == null ? new TblTxPayMentResponsePageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxPayMentResponses = tblTxPayMentResponseMgr.getSecurityTblTxPayMentResponseList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxPayMentResponse getTblTxPayMentResponse() {
		return tblTxPayMentResponse;
	}

	public void setTblTxPayMentResponse(TblTxPayMentResponse tblTxPayMentResponse) {
		this.tblTxPayMentResponse = tblTxPayMentResponse;
	}
	
	public List<TblTxPayMentResponse> getTblTxPayMentResponses() {
		return tblTxPayMentResponses;
	}

	public void setTblTxPayMentResponses(List<TblTxPayMentResponse> tblTxPayMentResponses) {
		this.tblTxPayMentResponses = tblTxPayMentResponses;
	}

	public TblTxPayMentResponsePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxPayMentResponsePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
