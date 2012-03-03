package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountTransferRequest;

public class AccountTransferRequest extends CommonAccountTxRequest implements
		IAccountTransferRequest {

	int accountIdFrom;

	int accountIdTo;

	public int getAccountIdFrom() {
		return accountIdFrom;
	}

	public void setAccountIdFrom(int accountIdFrom) {
		this.accountIdFrom = accountIdFrom;
	}

	public int getAccountIdTo() {
		return accountIdTo;
	}

	public void setAccountIdTo(int accountIdTo) {
		this.accountIdTo = accountIdTo;
	}

}
