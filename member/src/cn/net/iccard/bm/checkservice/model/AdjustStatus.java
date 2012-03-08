package cn.net.iccard.bm.checkservice.model;

import java.io.Serializable;

public class AdjustStatus implements Serializable{

	/**
	 * Ã·Ωª…Í«Î
	 */
	public static final int ADJUSTSTATUS_WAIT = 401100;
	/**
	 * …Û∫ÀÕ®π˝
	 */
	public static final int ADJUSTSTATUS_FINISHED = 401101;
	/**
	 * …Û∫À ß∞‹
	 */
	public static final int ADJUSTSTATUS_FINISHEDFAIL = 401102;

}