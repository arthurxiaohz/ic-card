package cn.net.iccard.accounting.account;

import java.io.Serializable;

/**
 * �������ͨ����Ӧ
 * 
 * @author Angi
 * 
 */
public interface IAccountResponse extends Serializable {

	/**
	 * ��Ӧ��
	 * 
	 * @return
	 */
	String getRespCode();

	/**
	 * ��Ӧ����
	 * 
	 * @return
	 */
	String getRespMsg();
}
