package org.hi.framework.security.model;

import java.io.Serializable;

public class SecurityScope implements Serializable{

	/**
	 * �û���
	 */
	public static final int SECURITYSCOPE_USER_LEVEL = 2900;
	/**
	 * ��ǰ���ż�
	 */
	public static final int SECURITYSCOPE_CURRENTORG_LEVEL = 2901;
	/**
	 * ���ż�
	 */
	public static final int SECURITYSCOPE_ORG_LEVEL = 2902;
	/**
	 * ���ż��Ӳ��ż�
	 */
	public static final int SECURITYSCOPE_ORGANDSUBORG_LEVEL = 2903;
	/**
	 * ϵͳ��
	 */
	public static final int SECURITYSCOPE_SYSTEM_LEVEL = 2904;

}