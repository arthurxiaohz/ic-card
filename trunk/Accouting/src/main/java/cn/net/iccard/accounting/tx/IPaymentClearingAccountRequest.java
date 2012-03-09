package cn.net.iccard.accounting.tx;

import java.io.Serializable;

/**
 * 支付清分请求
 * 
 * @author Angi
 * 
 */
public interface IPaymentClearingAccountRequest extends Serializable {

	String getMchtNo();

	String getUserName();

	int getMchtFee();

	int getMchtOrderAmount();

	/**
	 * 会员实际支付金额，商户订单金额扣除红包等
	 * @return
	 */
	int getAmount();

	int getBizLogId();

}
