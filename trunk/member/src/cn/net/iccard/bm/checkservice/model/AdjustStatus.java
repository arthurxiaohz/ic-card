package cn.net.iccard.bm.checkservice.model;

import java.io.Serializable;

public class AdjustStatus implements Serializable{

	/**
	 * �ύ����
	 */
	public static final int ADJUSTSTATUS_WAIT = 401100;
	/**
	 * ���ͨ��
	 */
	public static final int ADJUSTSTATUS_FINISHED = 401101;
	/**
	 * ���ʧ��
	 */
	public static final int ADJUSTSTATUS_FINISHEDFAIL = 401102;

}