package cn.net.iccard.tx.model;

import java.io.Serializable;

public class TransTxStatus implements Serializable{

	/**
	 * ��ת��
	 */
	public static final int TRANSTXSTATUS_UNFRANSFER = 101200;
	/**
	 * ת�˳ɹ�
	 */
	public static final int TRANSTXSTATUS_FRANSFERSUCCESS = 101201;
	/**
	 * ת��ʧ��
	 */
	public static final int TRANSTXSTATUS_FRANSFERFAIL = 101202;

}