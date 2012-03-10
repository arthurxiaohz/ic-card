package cn.net.iccard.bm.settleservice.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.settleservice.action.TblStlSettleBatchPageInfo;
import cn.net.iccard.bm.settleservice.model.TblStlSettleBatch;
import cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager;

public class TblStlSettleBatchAction extends BaseAction{
	private TblStlSettleBatch tblStlSettleBatch;
	private TblStlSettleBatchPageInfo pageInfo;
	private List<TblStlSettleBatch> tblStlSettleBatchs;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı����������
	 */
	public String saveTblStlSettleBatch() throws Exception {
		TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
		if(super.perExecute(tblStlSettleBatch)!= null) return returnCommand();
		tblStlSettleBatchMgr.saveTblStlSettleBatch(tblStlSettleBatch);
		super.postExecute(tblStlSettleBatch);
		return returnCommand();
	}
	
	
	/**
	 * ɾ����������
	 */
	public String removeTblStlSettleBatch() throws Exception {
		TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
		tblStlSettleBatchMgr.removeTblStlSettleBatchById(tblStlSettleBatch.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ��������
	 */
	public String removeAllTblStlSettleBatch() throws Exception {
		TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblStlSettleBatchid = new Integer( ids[i] );
				tblStlSettleBatchMgr.removeTblStlSettleBatchById(tblStlSettleBatchid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴��������
	 */
	public String viewTblStlSettleBatch() throws Exception {
		TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
		tblStlSettleBatch = tblStlSettleBatchMgr.getTblStlSettleBatchById(tblStlSettleBatch.getId());
		return returnCommand();
	}
	
	/**
	 * ���������б�
	 */
	public String tblStlSettleBatchList() throws Exception {
		TblStlSettleBatchManager tblStlSettleBatchMgr = (TblStlSettleBatchManager)SpringContextHolder.getBean(TblStlSettleBatch.class);
		pageInfo = pageInfo == null ? new TblStlSettleBatchPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblStlSettleBatchs = tblStlSettleBatchMgr.getSecurityTblStlSettleBatchList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblStlSettleBatch getTblStlSettleBatch() {
		return tblStlSettleBatch;
	}

	public void setTblStlSettleBatch(TblStlSettleBatch tblStlSettleBatch) {
		this.tblStlSettleBatch = tblStlSettleBatch;
	}
	
	public List<TblStlSettleBatch> getTblStlSettleBatchs() {
		return tblStlSettleBatchs;
	}

	public void setTblStlSettleBatchs(List<TblStlSettleBatch> tblStlSettleBatchs) {
		this.tblStlSettleBatchs = tblStlSettleBatchs;
	}

	public TblStlSettleBatchPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblStlSettleBatchPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
