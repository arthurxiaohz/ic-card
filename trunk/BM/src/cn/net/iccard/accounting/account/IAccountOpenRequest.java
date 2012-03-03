package cn.net.iccard.accounting.account;

import java.io.Serializable;

/**
 * �˻���������
 * 
 * @author Angi
 * 
 */
public interface IAccountOpenRequest extends Serializable {

	int getAccountCatalog();

	int getAccountPartyType();

	/**
	 * ����������ţ�
	 * <p/>
	 * ���磺�̻��ŵ�֮��
	 * 
	 * @return
	 */
	String getAccountParty();

	/**
	 * ����������
	 * 
	 * @return
	 */
	String getAccountName();

	/**
	 * ����Ա
	 * 
	 * @return
	 */
	int getOperator();

	/**
	 * ��ע
	 */
	String getRemark();

}
