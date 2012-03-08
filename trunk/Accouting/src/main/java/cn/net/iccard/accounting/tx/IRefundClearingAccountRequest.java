package cn.net.iccard.accounting.tx;

import java.io.Serializable;

/**
 * 退款清分请求
 * 
 * @author Angi
 * 
 */
public interface IRefundClearingAccountRequest extends Serializable {

	String getMchtNo();

	String getUserName();

	int getAmount();

	int getMchtFee();

	int getBizLogId();

	boolean isFeeReturn();

}
