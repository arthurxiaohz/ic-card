package cn.net.iccard.member.model;

import java.io.Serializable;

public class BankTxStatus implements Serializable{

	/**
	 * 成功
	 */
	public static final int BANKTXSTATUS_SUCCESS = 102700;
	/**
	 * 失败
	 */
	public static final int BANKTXSTATUS_SETTLE = 102701;
	/**
	 * 已撤单
	 */
	public static final int BANKTXSTATUS_CANCEL = 102702;

}