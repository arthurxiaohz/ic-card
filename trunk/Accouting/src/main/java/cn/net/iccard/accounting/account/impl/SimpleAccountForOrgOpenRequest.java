package cn.net.iccard.accounting.account.impl;

import cn.net.iccard.accounting.account.IAccountOpenForOrgRequest;

public class SimpleAccountForOrgOpenRequest implements
		IAccountOpenForOrgRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4648795271685565787L;

	/**
	 * ����������ţ�
	 * <p/>
	 * ���磺�̻��ŵ�֮��
	 * 
	 * @return
	 */
	private String accountParty;

	/**
	 * ����������
	 * 
	 * @return
	 */
	private String accountName;

	/**
	 * ����Ա
	 * 
	 * @return
	 */
	private int operator;
	/**
	 * ��ע
	 */
	private String remark;

	private int availableBalance = 0;

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getAccountParty() {
		return accountParty;
	}

	public void setAccountParty(String accountParty) {
		this.accountParty = accountParty;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

}
