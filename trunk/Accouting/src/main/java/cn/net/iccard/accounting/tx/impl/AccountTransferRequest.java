package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountTransferRequest;

public class AccountTransferRequest extends CommonAccountTxRequest implements
		IAccountTransferRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9123216893425167966L;

	private int accountIdFrom;

	private int accountIdTo;

	private String expiredDate;

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

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

}
