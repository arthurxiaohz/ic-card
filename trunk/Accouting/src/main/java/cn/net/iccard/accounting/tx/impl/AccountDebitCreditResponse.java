package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.tx.IAccountDebitCreditResponse;

public class AccountDebitCreditResponse extends AccountTxResponse implements
		IAccountDebitCreditResponse {

	public AccountDebitCreditResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDebitCreditResponse(EAccountResponse accountResponse,
			String voucherNo) {
		super(accountResponse, voucherNo);
		// TODO Auto-generated constructor stub
	}

	public AccountDebitCreditResponse(EAccountResponse accountResponse) {
		super(accountResponse);
		// TODO Auto-generated constructor stub
	}

}
