package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IPaymentClearingAccountRequest;

public class PaymentClearingAccountRequest implements
		IPaymentClearingAccountRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888101018139796085L;

	private String mchtNo;

	private String userName;

	private int mchtFee;

	private int mchtOrderAmount;

	public int getMchtOrderAmount() {
		return mchtOrderAmount;
	}

	public void setMchtOrderAmount(int mchtOrderAmount) {
		this.mchtOrderAmount = mchtOrderAmount;
	}

	private int amount;

	private int bizLogId;

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

	public int getBizLogId() {
		return bizLogId;
	}

	public void setBizLogId(int bizLogId) {
		this.bizLogId = bizLogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
