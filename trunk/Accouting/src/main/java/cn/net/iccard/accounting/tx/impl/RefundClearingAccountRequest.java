package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IRefundClearingAccountRequest;

public class RefundClearingAccountRequest implements
		IRefundClearingAccountRequest {

	private String mchtNo;

	private String userName;

	private int mchtOrderAmount;

	private int amount;

	private int mchtFee;

	private int bizLogId;

	private boolean feeReturn;

	public boolean isFeeReturn() {
		return feeReturn;
	}

	public void setFeeReturn(boolean feeReturn) {
		this.feeReturn = feeReturn;
	}

	public String getMchtNo() {
		return mchtNo;
	}

	public void setMchtNo(String mchtNo) {
		this.mchtNo = mchtNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMchtOrderAmount() {
		return mchtOrderAmount;
	}

	public void setMchtOrderAmount(int mchtOrderAmount) {
		this.mchtOrderAmount = mchtOrderAmount;
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

	public int getMchtFee() {
		return mchtFee;
	}

	public void setMchtFee(int mchtFee) {
		this.mchtFee = mchtFee;
	}

}
