package cn.net.iccard.accounting;

import java.io.Serializable;

/**
 * �������ͨ����Ӧ
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountResponse extends Serializable {

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
