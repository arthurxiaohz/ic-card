package cn.net.iccard.accounting.tx;

import cn.net.iccard.accounting.ICommonAccountResponse;

/**
 * ����֮���ײ���ͨ����Ӧ
 * 
 * @author Angi
 * 
 */
public interface IAccountTxResponse extends ICommonAccountResponse {

	/**
	 * ƾ֤��
	 * 
	 * @return
	 */
	String getVoucherNo();
}
