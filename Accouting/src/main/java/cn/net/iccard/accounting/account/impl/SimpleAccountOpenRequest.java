package cn.net.iccard.accounting.account.impl;

import cn.net.iccard.accounting.account.IAccountOpenRequest;

public class SimpleAccountOpenRequest extends SimpleAccountForOrgOpenRequest
		implements IAccountOpenRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8284825538238257812L;

	private int accountPartyType;

	private int accountCatalog;

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

}
