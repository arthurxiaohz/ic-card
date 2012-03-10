package cn.net.iccard.tx.model;

import java.io.Serializable;

public class TransTxStatus implements Serializable{

	/**
	 * 待转帐
	 */
	public static final int TRANSTXSTATUS_UNFRANSFER = 201200;
	/**
	 * 转账成功
	 */
	public static final int TRANSTXSTATUS_FRANSFERSUCCESS = 201201;
	/**
	 * 转账失败
	 */
	public static final int TRANSTXSTATUS_FRANSFERFAIL = 201202;

}