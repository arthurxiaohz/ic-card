package cn.net.iccard.bm.settleservice.model;

import java.io.Serializable;

public class SettleApplyStatus implements Serializable{

	/**
	 * �����
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKING = 500800;
	/**
	 * ���ͨ��
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKPASS = 500801;
	/**
	 * ��˲�ͨ��
	 */
	public static final int SETTLEAPPLYSTATUS_CHECKFAIL = 500802;
	/**
	 * ������
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLING = 500803;
	/**
	 * �ѽ���
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLED = 500804;
	/**
	 * ����ʧ��
	 */
	public static final int SETTLEAPPLYSTATUS_SETTLEFAIL = 500805;

}