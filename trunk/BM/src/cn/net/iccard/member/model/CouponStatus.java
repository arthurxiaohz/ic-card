package cn.net.iccard.member.model;

import java.io.Serializable;

public class CouponStatus implements Serializable{

	/**
	 * 未领取
	 */
	public static final int COUPONSTATUS_NOTDRAW = 101800;
	/**
	 * 有效
	 */
	public static final int COUPONSTATUS_VALID = 101801;
	/**
	 * 已使用
	 */
	public static final int COUPONSTATUS_USED = 101802;
	/**
	 * 过期
	 */
	public static final int COUPONSTATUS_EXPIRED = 101803;

}