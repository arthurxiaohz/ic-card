package org.hi.framework.security.model;

import java.io.Serializable;

public class SecurityScope implements Serializable{

	/**
	 * 用户级
	 */
	public static final int SECURITYSCOPE_USER_LEVEL = 2900;
	/**
	 * 当前部门级
	 */
	public static final int SECURITYSCOPE_CURRENTORG_LEVEL = 2901;
	/**
	 * 部门级
	 */
	public static final int SECURITYSCOPE_ORG_LEVEL = 2902;
	/**
	 * 部门及子部门级
	 */
	public static final int SECURITYSCOPE_ORGANDSUBORG_LEVEL = 2903;
	/**
	 * 系统级
	 */
	public static final int SECURITYSCOPE_SYSTEM_LEVEL = 2904;
	
	
	/**
	 * 当前部门及子部门级
	 */
	public static final int SECURITYSCOPE_CURRENTANDSUBORG_LEVEL = 2905;
	
	/**
	 * 自定义
	 */
	public static final int SECURITYSCOPE_CUSTOMBER_LEVEL = 2906;
}