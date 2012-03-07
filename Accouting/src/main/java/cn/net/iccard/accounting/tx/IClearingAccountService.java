package cn.net.iccard.accounting.tx;

import cn.net.iccard.accounting.ICommonAccountResponse;

/**
 * ���������
 * 
 * @author Angi
 * 
 */
public interface IClearingAccountService {

	/**
	 * ֧�����������
	 * 
	 * @param paymentClearingAccountRequest
	 * @return
	 */
	ICommonAccountResponse doPaymentAccountClearing(
			IPaymentClearingAccountRequest paymentClearingAccountRequest);

	/**
	 * �˿����������
	 * 
	 * @param refundClearingAccountRequest
	 * @return
	 */
	ICommonAccountResponse doRefundAccountClearing(
			IRefundClearingAccountRequest refundClearingAccountRequest);

}