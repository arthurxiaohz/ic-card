package cn.net.iccard.accounting.account.impl;

import cn.net.iccard.accounting.account.IAccountOpenResponse;

public class SimpleAccountOpenResponse implements IAccountOpenResponse {
	/**
	 * ��Ӧ��
	 * 
	 * @return
	 */
	private String respCode;

	/**
	 * ��Ӧ����
	 * 
	 * @return
	 */
	private String respMsg;

	private int accountId;

	private String accountNo;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
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
