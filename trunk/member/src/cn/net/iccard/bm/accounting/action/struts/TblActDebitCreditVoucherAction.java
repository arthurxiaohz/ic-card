package cn.net.iccard.bm.accounting.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.accounting.action.TblActDebitCreditVoucherPageInfo;
import cn.net.iccard.bm.accounting.model.TblActDebitCreditVoucher;
import cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager;

public class TblActDebitCreditVoucherAction extends BaseAction{
	private TblActDebitCreditVoucher tblActDebitCreditVoucher;
	private TblActDebitCreditVoucherPageInfo pageInfo;
	private List<TblActDebitCreditVoucher> tblActDebitCreditVouchers;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı�����ƾ֤
	 */
	public String saveTblActDebitCreditVoucher() throws Exception {
		TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
		if(super.perExecute(tblActDebitCreditVoucher)!= null) return returnCommand();
		tblActDebitCreditVoucherMgr.saveTblActDebitCreditVoucher(tblActDebitCreditVoucher);
		super.postExecute(tblActDebitCreditVoucher);
		return returnCommand();
	}
	
	
	/**
	 * ɾ�����ƾ֤
	 */
	public String removeTblActDebitCreditVoucher() throws Exception {
		TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
		tblActDebitCreditVoucherMgr.removeTblActDebitCreditVoucherById(tblActDebitCreditVoucher.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ���ƾ֤
	 */
	public String removeAllTblActDebitCreditVoucher() throws Exception {
		TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblActDebitCreditVoucherid = new Integer( ids[i] );
				tblActDebitCreditVoucherMgr.removeTblActDebitCreditVoucherById(tblActDebitCreditVoucherid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *�鿴���ƾ֤
	 */
	public String viewTblActDebitCreditVoucher() throws Exception {
		TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
		tblActDebitCreditVoucher = tblActDebitCreditVoucherMgr.getTblActDebitCreditVoucherById(tblActDebitCreditVoucher.getId());
		return returnCommand();
	}
	
	/**
	 * ���ƾ֤�б�
	 */
	public String tblActDebitCreditVoucherList() throws Exception {
		TblActDebitCreditVoucherManager tblActDebitCreditVoucherMgr = (TblActDebitCreditVoucherManager)SpringContextHolder.getBean(TblActDebitCreditVoucher.class);
		pageInfo = pageInfo == null ? new TblActDebitCreditVoucherPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblActDebitCreditVouchers = tblActDebitCreditVoucherMgr.getSecurityTblActDebitCreditVoucherList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblActDebitCreditVoucher getTblActDebitCreditVoucher() {
		return tblActDebitCreditVoucher;
	}

	public void setTblActDebitCreditVoucher(TblActDebitCreditVoucher tblActDebitCreditVoucher) {
		this.tblActDebitCreditVoucher = tblActDebitCreditVoucher;
	}
	
	public List<TblActDebitCreditVoucher> getTblActDebitCreditVouchers() {
		return tblActDebitCreditVouchers;
	}

	public void setTblActDebitCreditVouchers(List<TblActDebitCreditVoucher> tblActDebitCreditVouchers) {
		this.tblActDebitCreditVouchers = tblActDebitCreditVouchers;
	}

	public TblActDebitCreditVoucherPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblActDebitCreditVoucherPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
