package cn.net.iccard.member.model;

import java.io.Serializable;

public class CouponStatus implements Serializable{

	/**
	 * δ��ȡ
	 */
	public static final int COUPONSTATUS_NOTDRAW = 101800;
	/**
	 * ��Ч
	 */
	public static final int COUPONSTATUS_VALID = 101801;
	/**
	 * ��ʹ��
	 */
	public static final int COUPONSTATUS_USED = 101802;
	/**
	 * ����
	 */
	public static final int COUPONSTATUS_EXPIRED = 101803;

}