package cn.net.iccard.tx.model;

import java.io.Serializable;

public class TxStatus implements Serializable{

	/**
	 * 待支付
	 */
	public static final int TXSTATUS_PREPAY = 100800;
	/**
	 * 预支付成功
	 */
	public static final int TXSTATUS_PREPAYSUCCESS = 100801;
	/**
	 * 已确认支付
	 */
	public static final int TXSTATUS_PAYSUCCESS = 100802;
	/**
	 * 已退款
	 */
	public static final int TXSTATUS_BACKSUCCESS = 100803;
	/**
	 * 已撤销
	 */
	public static final int TXSTATUS_REVOCATIONSUCCESS = 100804;

}