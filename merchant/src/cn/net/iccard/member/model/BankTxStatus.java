package cn.net.iccard.member.model;

import java.io.Serializable;

public class BankTxStatus implements Serializable{

	/**
	 * �ɹ�
	 */
	public static final int BANKTXSTATUS_SUCCESS = 102700;
	/**
	 * ʧ��
	 */
	public static final int BANKTXSTATUS_SETTLE = 102701;
	/**
	 * �ѳ���
	 */
	public static final int BANKTXSTATUS_CANCEL = 102702;

}