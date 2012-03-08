package cn.net.iccard.member.model;

import java.io.Serializable;

public class CheckStatus implements Serializable{

	/**
	 * 未对账
	 */
	public static final int CHECKSTATUS_UNCHECK = 102800;
	/**
	 * 对账平
	 */
	public static final int CHECKSTATUS_CHECKSUCCESS = 102801;
	/**
	 * 长款
	 */
	public static final int CHECKSTATUS_CHECKLONG = 102802;
	/**
	 * 短款
	 */
	public static final int CHECKSTATUS_CHECKSHORT = 102803;

}