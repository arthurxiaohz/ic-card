package cn.net.iccard.accounting.account.impl;

import cn.net.iccard.accounting.account.IAccountOpenRequest;

public class SimpleAccountOpenRequest implements IAccountOpenRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6283829117313917422L;

	private int accountPartyType;

	private int accountCatalog;

	/**
	 * 开户方（编号）
	 * <p/>
	 * 比如：商户号等之类
	 * 
	 * @return
	 */
	private String accountParty;

	/**
	 * 开户方名称
	 * 
	 * @return
	 */
	private String accountName;

	private int availableBalance = 0;

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * 操作员
	 * 
	 * @return
	 */
	// private int operator;
	/**
	 * 备注
	 */
	private String remark;

	public int getAccountPartyType() {
		return accountPartyType;
	}

	public void setAccountPartyType(int accountPartyType) {
		this.accountPartyType = accountPartyType;
	}

	public int getAccountCatalog() {
		return accountCatalog;
	}

	public void setAccountCatalog(int accountCatalog) {
		this.accountCatalog = accountCatalog;
	}

	public String getAccountParty() {
		return accountParty;
	}

	public void setAccountParty(String accountParty) {
		this.accountParty = accountParty;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
