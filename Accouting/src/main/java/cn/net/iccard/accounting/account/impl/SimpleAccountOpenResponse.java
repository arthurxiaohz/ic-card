package cn.net.iccard.accounting.account.impl;

import cn.net.iccard.accounting.EAccountResponse;
import cn.net.iccard.accounting.account.IAccountOpenResponse;
import cn.net.iccard.accounting.impl.SimpleCommonAccountResponse;

public class SimpleAccountOpenResponse extends SimpleCommonAccountResponse
		implements IAccountOpenResponse {

	private int accountId;

	private String accountNo;

	public SimpleAccountOpenResponse() {
		super();
	}

	public SimpleAccountOpenResponse(EAccountResponse eAccountResponse,
			int accountId, String accountNo) {
		super(eAccountResponse);
		this.accountId = accountId;
		this.accountNo = accountNo;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

}
