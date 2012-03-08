package cn.net.iccard.accounting.tx;

import javax.security.auth.login.AccountException;

/**
 * �����׷���
 * 
 * @author Angi
 * 
 */
public interface IAccountTxService {

	/**
	 * ���
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountDebitCreditResponse debit(
			IAccountDebitCreditRequest accountDebitCreditRequest);

	/**
	 * ����
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountDebitCreditResponse credit(
			IAccountDebitCreditRequest accountDebitCreditRequest);

	/**
	 * ת��
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountTransferResponse transfer(
			IAccountTransferRequest accountTransferRequest);

	/**
	 * Ӧ��ת��
	 * 
	 * ���磺Ԥ֧���ɹ����ɻ�Ա�����˻�ת�˵���Ա�����˻���Ӧ������
	 * 
	 * @param accountTransferRequest
	 * @return
	 */
	IAccountTransferResponse transfer(
			IAccountPayableTransferRequest accountRcvOrPabTransferRequest);

	/**
	 * ʵ��ת��
	 * 
	 * ���磺Ԥ֧��ȷ�ϣ��ɻ�Ա�����˻���Ӧ����ת�˵��̻������˻���
	 * 
	 * @param accountTransferRequest
	 * @return
	 */
	IAccountTransferResponse transfer(
			IAccountPaidTransferRequest accountPaidTransferRequest);

}
