package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class AccountStatus implements Serializable{

	/**
	 * ����
	 */
	public static final int ACCOUNTSTATUS_NORMAL = 601300;
	/**
	 * ��ע��
	 */
	public static final int ACCOUNTSTATUS_CANCELED = 601301;
	/**
	 * �Ѷ���
	 */
	public static final int ACCOUNTSTATUS_FROZEN = 601302;

}