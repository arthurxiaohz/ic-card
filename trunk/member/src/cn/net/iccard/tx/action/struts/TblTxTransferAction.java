package cn.net.iccard.tx.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxTransferPageInfo;
import cn.net.iccard.tx.model.TblTxTransfer;
import cn.net.iccard.tx.service.TblTxTransferManager;

public class TblTxTransferAction extends BaseAction{
	private TblTxTransfer tblTxTransfer;
	private TblTxTransferPageInfo pageInfo;
	private List<TblTxTransfer> tblTxTransfers;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存转账查询
	 */
	public String saveTblTxTransfer() throws Exception {
		TblTxTransferManager tblTxTransferMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
		if(super.perExecute(tblTxTransfer)!= null) return returnCommand();
		tblTxTransferMgr.saveTblTxTransfer(tblTxTransfer);
		super.postExecute(tblTxTransfer);
		return returnCommand();
	}
	
	
	/**
	 * 删除转账查询
	 */
	public String removeTblTxTransfer() throws Exception {
		TblTxTransferManager tblTxTransferMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
		tblTxTransferMgr.removeTblTxTransferById(tblTxTransfer.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些转账查询
	 */
	public String removeAllTblTxTransfer() throws Exception {
		TblTxTransferManager tblTxTransferMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblTxTransferid = new Integer( ids[i] );
				tblTxTransferMgr.removeTblTxTransferById(tblTxTransferid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看转账查询
	 */
	public String viewTblTxTransfer() throws Exception {
		TblTxTransferManager tblTxTransferMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
		tblTxTransfer = tblTxTransferMgr.getTblTxTransferById(tblTxTransfer.getId());
		return returnCommand();
	}
	
	/**
	 * 转账查询列表
	 */
	public String tblTxTransferList() throws Exception {
		TblTxTransferManager tblTxTransferMgr = (TblTxTransferManager)SpringContextHolder.getBean(TblTxTransfer.class);
		pageInfo = pageInfo == null ? new TblTxTransferPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblTxTransfers = tblTxTransferMgr.getSecurityTblTxTransferList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblTxTransfer getTblTxTransfer() {
		return tblTxTransfer;
	}

	public void setTblTxTransfer(TblTxTransfer tblTxTransfer) {
		this.tblTxTransfer = tblTxTransfer;
	}
	
	public List<TblTxTransfer> getTblTxTransfers() {
		return tblTxTransfers;
	}

	public void setTblTxTransfers(List<TblTxTransfer> tblTxTransfers) {
		this.tblTxTransfers = tblTxTransfers;
	}

	public TblTxTransferPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblTxTransferPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
