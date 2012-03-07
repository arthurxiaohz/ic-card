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

	int getMchtFee();

	int getAmount();

	int getTxLogId();

}
