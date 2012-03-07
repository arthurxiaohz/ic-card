package cn.net.iccard.accounting.tx;

import cn.net.iccard.accounting.ICommonAccountResponse;

/**
 * 清分账务处理
 * 
 * @author Angi
 * 
 */
public interface IClearingAccountService {

	/**
	 * 支付清分账务处理
	 * 
	 * @param paymentClearingAccountRequest
	 * @return
	 */
	ICommonAccountResponse doPaymentAccountClearing(
			IPaymentClearingAccountRequest paymentClearingAccountRequest);

	/**
	 * 退款清分账务处理
	 * 
	 * @param refundClearingAccountRequest
	 * @return
	 */
	ICommonAccountResponse doRefundAccountClearing(
			IRefundClearingAccountRequest refundClearingAccountRequest);

}