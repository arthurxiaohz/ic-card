package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.impl.SimpleCommonAccountResponse;
import cn.net.iccard.accounting.tx.IAccountTxResponse;

public class AccountTxResponse extends SimpleCommonAccountResponse implements
		IAccountTxResponse {

	/**
	 * Æ¾Ö¤ºÅ
	 * 
	 * @return
	 */
	private String voucherNo;

	public AccountTxResponse() {
		super();
	}

	public AccountTxResponse(EAccountResponse eAccountResponse, String voucherNo) {
		super(eAccountResponse);
		this.voucherNo = voucherNo;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

}
