package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class AccountCatalog implements Serializable{

	/**
	 * 手续费账户
	 */
	public static final int ACCOUNTCATALOG_FEEACCOUNT = 601100;
	/**
	 * 虚拟账户
	 */
	public static final int ACCOUNTCATALOG_VIRTUALACCOUNT = 601101;
	/**
	 * 担保账户
	 */
	public static final int ACCOUNTCATALOG_GUARANTEEACCOUNT = 601102;

}