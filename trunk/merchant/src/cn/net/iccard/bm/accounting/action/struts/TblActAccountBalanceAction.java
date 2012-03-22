package cn.net.iccard.bm.accounting.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.accounting.action.TblActAccountBalancePageInfo;
import cn.net.iccard.bm.accounting.model.TblActAccountBalance;
import cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager;
import cn.net.iccard.bm.mcht.model.TblMchtUser;
import cn.net.iccard.bm.mcht.service.TblMchtUserManager;

public class TblActAccountBalanceAction extends BaseAction{
	private TblActAccountBalance tblActAccountBalance;
	private TblActAccountBalancePageInfo pageInfo;
	private List<TblActAccountBalance> tblActAccountBalances;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存账户余额
	 */
	public String saveTblActAccountBalance() throws Exception {
		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
		if(super.perExecute(tblActAccountBalance)!= null) return returnCommand();
		tblActAccountBalanceMgr.saveTblActAccountBalance(tblActAccountBalance);
		super.postExecute(tblActAccountBalance);
		return returnCommand();
	}
	
	
	/**
	 * 删除账户余额
	 */
	public String removeTblActAccountBalance() throws Exception {
		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
		tblActAccountBalanceMgr.removeTblActAccountBalanceById(tblActAccountBalance.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些账户余额
	 */
	public String removeAllTblActAccountBalance() throws Exception {
		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer tblActAccountBalanceid = new Integer( ids[i] );
				tblActAccountBalanceMgr.removeTblActAccountBalanceById(tblActAccountBalanceid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看账户余额
	 */
	public String viewTblActAccountBalance() throws Exception {
		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
		tblActAccountBalance = tblActAccountBalanceMgr.getTblActAccountBalanceById(tblActAccountBalance.getId());
		return returnCommand();
	}
	
	/**
	 * 账户余额列表
	 */
	public String tblActAccountBalanceList() throws Exception {
		TblActAccountBalanceManager tblActAccountBalanceMgr = (TblActAccountBalanceManager)SpringContextHolder.getBean(TblActAccountBalance.class);
		pageInfo = pageInfo == null ? new TblActAccountBalancePageInfo() : pageInfo;
		
		//锁定查询所属商户
		TblMchtUserManager tblMchtUserMgr = (TblMchtUserManager) SpringContextHolder
				.getBean(TblMchtUser.class);
		pageInfo.setF_accountParty(tblMchtUserMgr.getTblMchtUserById(
				(org.hi.framework.security.context.UserContextHelper.getUser()
						.getId())).getMchtNo());
		
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		tblActAccountBalances = tblActAccountBalanceMgr.getSecurityTblActAccountBalanceList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public TblActAccountBalance getTblActAccountBalance() {
		return tblActAccountBalance;
	}

	public void setTblActAccountBalance(TblActAccountBalance tblActAccountBalance) {
		this.tblActAccountBalance = tblActAccountBalance;
	}
	
	public List<TblActAccountBalance> getTblActAccountBalances() {
		return tblActAccountBalances;
	}

	public void setTblActAccountBalances(List<TblActAccountBalance> tblActAccountBalances) {
		this.tblActAccountBalances = tblActAccountBalances;
	}

	public TblActAccountBalancePageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblActAccountBalancePageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
