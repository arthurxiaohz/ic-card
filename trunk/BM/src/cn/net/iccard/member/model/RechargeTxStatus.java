package cn.net.iccard.member.model;

import java.io.Serializable;

public class RechargeTxStatus implements Serializable{

	/**
	 * ֧����
	 */
	public static final int RECHARGETXSTATUS_PAYPROCESS = 102500;
	/**
	 * ֧���ɹ�
	 */
	public static final int RECHARGETXSTATUS_PAYSUCCESS = 102501;
	/**
	 * ֧��ʧ��
	 */
	public static final int RECHARGETXSTATUS_PAYFAIL = 102502;

}