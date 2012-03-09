package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.ICommonAccountTxRequest;

public class CommonAccountTxRequest implements ICommonAccountTxRequest {

	/**
	 * ���
	 */
	private int amount;

	/**
	 * ҵ������
	 */
	private int bizType;

	/**
	 * ҵ����ˮ
	 */
	private int bizLogId;

	/**
	 * ����Ա
	 */
//	private int operator;

	/**
	 * ��ע
	 */
	private String remark;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBizType() {
		return bizType;
	}

	public void setBizType(int bizType) {
		this.bizType = bizType;
	}

	public int getBizLogId() {
		return bizLogId;
	}

	public void setBizLogId(int bizLogId) {
		this.bizLogId = bizLogId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
