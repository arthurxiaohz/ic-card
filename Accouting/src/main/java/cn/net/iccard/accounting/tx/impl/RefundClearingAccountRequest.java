package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IRefundClearingAccountRequest;

public class RefundClearingAccountRequest extends PaymentClearingAccountRequest
		implements IRefundClearingAccountRequest {

	private boolean feeReturn;

	public boolean isFeeReturn() {
		return feeReturn;
	}

	public void setFeeReturn(boolean feeReturn) {
		this.feeReturn = feeReturn;
	}

}
