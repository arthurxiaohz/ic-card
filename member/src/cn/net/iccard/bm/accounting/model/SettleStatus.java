package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class SettleStatus implements Serializable{

	/**
	 * 待处理
	 */
	public static final int SETTLESTATUS_TOSETTLED = 601200;
	/**
	 * 已处理
	 */
	public static final int SETTLESTATUS_SETTLED = 601201;

}