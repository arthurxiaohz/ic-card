package cn.net.iccard.tx.model;

import java.io.Serializable;

public class TransTxStatus implements Serializable{

	/**
	 * ��ת��
	 */
	public static final int TRANSTXSTATUS_UNFRANSFER = 201200;
	/**
	 * ת�˳ɹ�
	 */
	public static final int TRANSTXSTATUS_FRANSFERSUCCESS = 201201;
	/**
	 * ת��ʧ��
	 */
	public static final int TRANSTXSTATUS_FRANSFERFAIL = 201202;

}