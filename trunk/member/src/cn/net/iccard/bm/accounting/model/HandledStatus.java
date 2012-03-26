package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class HandledStatus implements Serializable{

	/**
	 * 待处理
	 */
	public static final int HANDLEDSTATUS_TOSETTLED = 601200;
	/**
	 * 已处理
	 */
	public static final int HANDLEDSTATUS_SETTLED = 601201;

}