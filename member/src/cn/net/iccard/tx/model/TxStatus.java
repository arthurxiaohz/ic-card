package cn.net.iccard.tx.model;

import java.io.Serializable;

public class TxStatus implements Serializable{

	/**
	 * ��֧��
	 */
	public static final int TXSTATUS_PREPAY = 200800;
	/**
	 * Ԥ֧���ɹ�
	 */
	public static final int TXSTATUS_PREPAYSUCCESS = 200801;
	/**
	 * ��ȷ��֧��
	 */
	public static final int TXSTATUS_PAYSUCCESS = 200802;
	/**
	 * ���˿�
	 */
	public static final int TXSTATUS_BACKSUCCESS = 200803;
	/**
	 * �ѳ���
	 */
	public static final int TXSTATUS_REVOCATIONSUCCESS = 200804;

}