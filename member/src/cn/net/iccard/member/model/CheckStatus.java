package cn.net.iccard.member.model;

import java.io.Serializable;

public class CheckStatus implements Serializable{

	/**
	 * δ����
	 */
	public static final int CHECKSTATUS_UNCHECK = 102800;
	/**
	 * ����ƽ
	 */
	public static final int CHECKSTATUS_CHECKSUCCESS = 102801;
	/**
	 * ����
	 */
	public static final int CHECKSTATUS_CHECKLONG = 102802;
	/**
	 * �̿�
	 */
	public static final int CHECKSTATUS_CHECKSHORT = 102803;

}