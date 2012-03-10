package cn.net.iccard.bm.accounting.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.accounting.action.ActAccountPageInfo;
import cn.net.iccard.bm.accounting.model.ActAccount;
import cn.net.iccard.bm.accounting.service.ActAccountManager;

public class ActAccountAction extends BaseAction{
	private ActAccount actAccount;
	private ActAccountPageInfo pageInfo;
	private List<ActAccount> actAccounts;
	private String orderIndexs;
	
	
	/**
	 * 新增/修改保存账户
	 */
	public String saveActAccount() throws Exception {
		ActAccountManager actAccountMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
		if(super.perExecute(actAccount)!= null) return returnCommand();
		actAccountMgr.saveActAccount(actAccount);
		super.postExecute(actAccount);
		return returnCommand();
	}
	
	
	/**
	 * 删除账户
	 */
	public String removeActAccount() throws Exception {
		ActAccountManager actAccountMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
		actAccountMgr.removeActAccountById(actAccount.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些账户
	 */
	public String removeAllActAccount() throws Exception {
		ActAccountManager actAccountMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer actAccountid = new Integer( ids[i] );
				actAccountMgr.removeActAccountById(actAccountid);
				}
			}
		}
		
		return returnCommand();
	}
	
	/**
	 *查看账户
	 */
	public String viewActAccount() throws Exception {
		ActAccountManager actAccountMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
		actAccount = actAccountMgr.getActAccountById(actAccount.getId());
		return returnCommand();
	}
	
	/**
	 * 账户列表
	 */
	public String actAccountList() throws Exception {
		ActAccountManager actAccountMgr = (ActAccountManager)SpringContextHolder.getBean(ActAccount.class);
		pageInfo = pageInfo == null ? new ActAccountPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		actAccounts = actAccountMgr.getSecurityActAccountList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	
	
	
	public ActAccount getActAccount() {
		return actAccount;
	}

	public void setActAccount(ActAccount actAccount) {
		this.actAccount = actAccount;
	}
	
	public List<ActAccount> getActAccounts() {
		return actAccounts;
	}

	public void setActAccounts(List<ActAccount> actAccounts) {
		this.actAccounts = actAccounts;
	}

	public ActAccountPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(ActAccountPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
