package cn.net.iccard.bm.accounting.model;

import java.io.Serializable;

public class BizType implements Serializable{

	/**
	 * ȷ��֧��
	 */
	public static final int BIZTYPE_CONFIRMPAY = 601000;
	/**
	 * Ԥ֧��
	 */
	public static final int BIZTYPE_PREPAID = 601001;
	/**
	 * ����
	 */
	public static final int BIZTYPE_SETTLEMENT = 601002;
	/**
	 * ����
	 */
	public static final int BIZTYPE_CANCEL = 601003;
	/**
	 * ȷ���˿�
	 */
	public static final int BIZTYPE_CONFIRMREFUND = 601004;

}