package cn.net.iccard.bm.mcht.model;

import java.io.Serializable;

public class MchtStatus implements Serializable{

	/**
	 * ����
	 */
	public static final int MCHTSTATUS_NORMAL = 300100;
	/**
	 * ��ͣ
	 */
	public static final int MCHTSTATUS_PAUSE = 300101;
	/**
	 * �ر�
	 */
	public static final int MCHTSTATUS_CLOSE = 300102;

}