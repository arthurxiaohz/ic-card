package cn.net.iccard.accounting.tx;

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

	/**
	 * ƾ֤��
	 * 
	 * @return
	 */
	String getVoucherNo();
}
