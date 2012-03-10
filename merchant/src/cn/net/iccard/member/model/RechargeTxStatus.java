package cn.net.iccard.member.model;

import java.io.Serializable;

public class RechargeTxStatus implements Serializable{

	/**
	 * 支付中
	 */
	public static final int RECHARGETXSTATUS_PAYPROCESS = 102500;
	/**
	 * 支付成功
	 */
	public static final int RECHARGETXSTATUS_PAYSUCCESS = 102501;
	/**
	 * 支付失败
	 */
	public static final int RECHARGETXSTATUS_PAYFAIL = 102502;

}