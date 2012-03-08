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

	int getAmount();

	int getBizLogId();

}
