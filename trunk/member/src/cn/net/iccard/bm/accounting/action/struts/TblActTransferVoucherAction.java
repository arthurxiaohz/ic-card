package cn.net.iccard.bm.accounting.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.accounting.action.TblActTransferVoucherPageInfo;
import cn.net.iccard.bm.accounting.model.TblActTransferVoucher;
import cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager;

public class TblActTransferVoucherAction extends BaseAction{
	private TblActTransferVoucher tblActTransferVoucher;
	private TblActTransferVoucherPageInfo pageInfo;
	private List<TblActTransferVoucher> tblActTransferVouchers;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存转账凭证
	 */
	public String saveTblActTransferVoucher() throws Exception {
		TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
		if(super.perExecute(tblActTransferVoucher)!= null) return returnCommand();
		tblActTransferVoucherMgr.saveTblActTransferVoucher(tblActTransferVoucher);
		super.postExecute(tblActTransferVoucher);
		return returnCommand();
	}
	
	
	/**
	 * 删除转账凭证
	 */
	public String removeTblActTransferVoucher() throws Exception {
		TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
		tblActTransferVoucherMgr.removeTblActTransferVoucherById(tblActTransferVoucher.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些转账凭证
	 */
	public String removeAllTblActTransferVoucher() throws Exception {
		TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblActTransferVoucherid = new Integer( ids[i] );
				tblActTransferVoucherMgr.removeTblActTransferVoucherById(tblActTransferVoucherid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看转账凭证
	 */
	public String viewTblActTransferVoucher() throws Exception {
		TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
		tblActTransferVoucher = tblActTransferVoucherMgr.getTblActTransferVoucherById(tblActTransferVoucher.getId());
		return returnCommand();
	}
	
	/**
	 * 转账凭证列表
	 */
	public String tblActTransferVoucherList() throws Exception {
		TblActTransferVoucherManager tblActTransferVoucherMgr = (TblActTransferVoucherManager)SpringContextHolder.getBean(TblActTransferVoucher.class);
		pageInfo = pageInfo == null ? new TblActTransferVoucherPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblActTransferVouchers = tblActTransferVoucherMgr.getSecurityTblActTransferVoucherList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblActTransferVoucher getTblActTransferVoucher() {
		return tblActTransferVoucher;
	}

	public void setTblActTransferVoucher(TblActTransferVoucher tblActTransferVoucher) {
		this.tblActTransferVoucher = tblActTransferVoucher;
	}
	
	public List<TblActTransferVoucher> getTblActTransferVouchers() {
		return tblActTransferVouchers;
	}

	public void setTblActTransferVouchers(List<TblActTransferVoucher> tblActTransferVouchers) {
		this.tblActTransferVouchers = tblActTransferVouchers;
	}

	public TblActTransferVoucherPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblActTransferVoucherPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
