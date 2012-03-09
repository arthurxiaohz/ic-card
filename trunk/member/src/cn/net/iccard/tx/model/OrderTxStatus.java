package cn.net.iccard.tx.model;

import java.io.Serializable;

public class OrderTxStatus implements Serializable{

	/**
	 * 待支付
	 */
	public static final int ORDERTXSTATUS_PREPAY = 200800;
	/**
	 * 预支付成功
	 */
	public static final int ORDERTXSTATUS_PREPAYSUCCESS = 200801;
	/**
	 * 已确认支付
	 */
	public static final int ORDERTXSTATUS_PAYSUCCESS = 200802;
	/**
	 * 已退款
	 */
	public static final int ORDERTXSTATUS_BACKSUCCESS = 200803;
	/**
	 * 已撤销
	 */
	public static final int ORDERTXSTATUS_REVOCATIONSUCCESS = 200804;
	/**
	 * 待撤销
	 */
	public static final int ORDERTXSTATUS_WAITREVOCATION = 200805;
	/**
	 * 待退款
	 */
	public static final int ORDERTXSTATUS_WAITBACK = 200806;
	/**
	 * 失败
	 */
	public static final int ORDERTXSTATUS_FAIL = 200807;

}