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
	 * Ӧ��ת�˳���
	 * 
	 * ���磺Ԥ֧���������ɻ�Ա�����˻���Ӧ����ת�˵���Ա�����˻���
	 * 
	 * @param accountTransferRequest
	 * @return
	 */
	IAccountTransferResponse transfer(
			IAccountPayableCancelTransferRequest accountPayableCancelTransferRequest);

	/**
	 * Ӧ�ո�ȷ��
	 * <p>
	 * 
	 * �޸�ԭ����Ϊ�Ѵ��������ɷ����/����
	 * 
	 * @param voucherType
	 * @param originalBizType
	 * @param originalBizLogId
	 * @param bizType
	 * @param bizLogId
	 * @return
	 */
	IAccountDebitCreditResponse doSettle(int voucherType, int originalBizType,
			int originalBizLogId, int bizType, int bizLogId);

}
