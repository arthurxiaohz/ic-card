package cn.net.iccard.tx.model;

import java.io.Serializable;

public class OrderTxStatus implements Serializable{

	/**
	 * ��֧��
	 */
	public static final int ORDERTXSTATUS_PREPAY = 200800;
	/**
	 * Ԥ֧���ɹ�
	 */
	public static final int ORDERTXSTATUS_PREPAYSUCCESS = 200801;
	/**
	 * ��ȷ��֧��
	 */
	public static final int ORDERTXSTATUS_PAYSUCCESS = 200802;
	/**
	 * ���˿�
	 */
	public static final int ORDERTXSTATUS_BACKSUCCESS = 200803;
	/**
	 * �ѳ���
	 */
	public static final int ORDERTXSTATUS_REVOCATIONSUCCESS = 200804;
	/**
	 * ������
	 */
	public static final int ORDERTXSTATUS_WAITREVOCATION = 200805;
	/**
	 * ���˿�
	 */
	public static final int ORDERTXSTATUS_WAITBACK = 200806;
	/**
	 * ʧ��
	 */
	public static final int ORDERTXSTATUS_FAIL = 200807;

}