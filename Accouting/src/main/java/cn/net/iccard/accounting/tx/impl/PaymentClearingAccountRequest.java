package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IPaymentClearingAccountRequest;

public class PaymentClearingAccountRequest implements
		IPaymentClearingAccountRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888101018139796085L;

	private String mchtNo;

	private int mchtFee;

	private int amount;

	private int txLogId;

	public String getMchtNo() {
		return mchtNo;
	}

	public void setMchtNo(String mchtNo) {
		this.mchtNo = mchtNo;
	}

	public int getMchtFee() {
		return mchtFee;
	}

	public void setMchtFee(int mchtFee) {
		this.mchtFee = mchtFee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTxLogId() {
		return txLogId;
	}

	public void setTxLogId(int txLogId) {
		this.txLogId = txLogId;
	}

}
