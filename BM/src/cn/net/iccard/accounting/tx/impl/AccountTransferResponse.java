package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountTransferResponse;

public class AccountTransferResponse extends AccountTxResponse implements
		IAccountTransferResponse {

	public AccountTransferResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountTransferResponse(EAccountResponse accountResponse,
			String voucherNo) {
		super(accountResponse, voucherNo);
		// TODO Auto-generated constructor stub
	}

	public AccountTransferResponse(EAccountResponse accountResponse) {
		super(accountResponse);
		// TODO Auto-generated constructor stub
	}

}
