package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class BizType implements Serializable{

	/**
	 * 确认支付
	 */
	public static final int BIZTYPE_CONFIRMPAY = 601000;
	/**
	 * 预支付
	 */
	public static final int BIZTYPE_PREPAID = 601001;
	/**
	 * 结算
	 */
	public static final int BIZTYPE_SETTLEMENT = 601002;
	/**
	 * 撤销
	 */
	public static final int BIZTYPE_CANCEL = 601003;
	/**
	 * 确认退款
	 */
	public static final int BIZTYPE_CONFIRMREFUND = 601004;

}