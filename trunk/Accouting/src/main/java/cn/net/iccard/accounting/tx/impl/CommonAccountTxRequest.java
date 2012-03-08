package cn.net.iccard.accounting.tx.impl;

import cn.net.iccard.accounting.tx.ICommonAccountTxRequest;

public class CommonAccountTxRequest implements ICommonAccountTxRequest {

	/**
	 * 商户订单金额
	 */
	private int mchtOrderAmount;

	/**
	 * 金额
	 */
	private int amount;

	/**
	 * 业务类型
	 */
	private int bizType;

	/**
	 * 业务流水
	 */
	private int bizLogId;

	/**
	 * 操作员
	 */
	private int operator;

	/**
	 * 备注
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

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public String getRemark() {
		return remark;
	}

	public int getMchtOrderAmount() {
		return mchtOrderAmount;
	}

	public void setMchtOrderAmount(int mchtOrderAmount) {
		this.mchtOrderAmount = mchtOrderAmount;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
