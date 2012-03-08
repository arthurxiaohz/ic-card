package cn.net.iccard.member.model;

import java.io.Serializable;

public class PointTxType implements Serializable{

	/**
	 * 交易积分
	 */
	public static final int POINTTXTYPE_TXPOINT = 102400;
	/**
	 * 积分兑换
	 */
	public static final int POINTTXTYPE_POINTEXCHANGE = 102401;
	/**
	 * 退款回退积分
	 */
	public static final int POINTTXTYPE_REFUNDPOINT = 102402;

}