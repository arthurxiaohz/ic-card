package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class AccountStatus implements Serializable{

	/**
	 * 正常
	 */
	public static final int ACCOUNTSTATUS_NORMAL = 601300;
	/**
	 * 已注销
	 */
	public static final int ACCOUNTSTATUS_CANCELED = 601301;
	/**
	 * 已冻结
	 */
	public static final int ACCOUNTSTATUS_FROZEN = 601302;

}