package cn.net.iccard.bm.settleservice.model;

import java.io.Serializable;

public class SettleApplyStatus implements Serializable{

	/**
	 * 审核中
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKING = 500800;
	/**
	 * 审核通过
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKPASS = 500801;
	/**
	 * 审核不通过
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKFAIL = 500802;
	/**
	 * 结算中
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLING = 500803;
	/**
	 * 已结算
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLED = 500804;
	/**
	 * 结算失败
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLEFAIL = 500805;

}