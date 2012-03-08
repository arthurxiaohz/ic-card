package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountPayableTransferRequest;

public class AccountPayableTransferRequest extends AccountTransferRequest
		implements IAccountPayableTransferRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3623219986302773156L;
	private String expiredDate;

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

}
