package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.IAccountPaidTransferRequest;

public class AccountPaidTransferRequest extends AccountTransferRequest
		implements IAccountPaidTransferRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 779868605047883223L;
	private int relatedBizLogId;

	public int getRelatedBizLogId() {
		return relatedBizLogId;
	}

	public void setRelatedBizLogId(int relatedBizLogId) {
		this.relatedBizLogId = relatedBizLogId;
	}

}
