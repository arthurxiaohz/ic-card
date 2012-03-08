package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountPayableCancelTransferRequest;

public class AccountPayableCancelTransferRequest extends AccountTransferRequest
		implements IAccountPayableCancelTransferRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6989969997664795031L;
	private int relatedBizLogId;

	public int getRelatedBizLogId() {
		return relatedBizLogId;
	}

	public void setRelatedBizLogId(int relatedBizLogId) {
		this.relatedBizLogId = relatedBizLogId;
	}

}
