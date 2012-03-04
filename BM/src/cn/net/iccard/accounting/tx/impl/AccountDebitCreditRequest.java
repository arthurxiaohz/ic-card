package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountDebitCreditRequest;

public class AccountDebitCreditRequest extends CommonAccountTxRequest implements
		IAccountDebitCreditRequest {

	private int accountId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

}
