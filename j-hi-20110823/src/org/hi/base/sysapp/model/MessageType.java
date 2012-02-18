package org.hi.base.sysapp.model;

import java.io.Serializable;

public class MessageType implements Serializable{

	/**
	 * 手机短信
	 */
	public static final int MESSAGETYPE_SMS = 5300;
	/**
	 * 内部邮件
	 */
	public static final int MESSAGETYPE_INTERNALMAIL = 5301;
	/**
	 * 外部邮件
	 */
	public static final int MESSAGETYPE_EXTERNALMAIL = 5302;
	/**
	 * 短消息
	 */
	public static final int MESSAGETYPE_INTERALMESSAGE = 5303;
	/**
	 * QQ
	 */
	public static final int MESSAGETYPE_QQ = 5304;
	/**
	 * MSN
	 */
	public static final int MESSAGETYPE_MSN = 5305;

}