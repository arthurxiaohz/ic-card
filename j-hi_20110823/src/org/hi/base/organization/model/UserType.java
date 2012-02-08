package org.hi.base.organization.model;

import java.io.Serializable;

public class UserType implements Serializable{

	/**
	 * 超级管理员
	 */
	public static final int USERTYPE_ADMINISTRATOR = 1400;
	/**
	 * 管理员
	 */
	public static final int USERTYPE_MANAGER = 1401;
	/**
	 * 一般用户
	 */
	public static final int USERTYPE_MENUAL = 1402;

}