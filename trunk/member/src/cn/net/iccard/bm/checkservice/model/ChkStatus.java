package cn.net.iccard.bm.checkservice.model;

import java.io.Serializable;

public class ChkStatus implements Serializable{

	/**
	 * 未对帐
	 */
	public static final int CHKSTATUS_UNCHECK = 400400;
	/**
	 * 已记录明细
	 */
	public static final int CHKSTATUS_CHECK = 400401;
	/**
	 * 已对帐
	 */
	public static final int CHKSTATUS_CHECKFINISHED = 400402;

}