package cn.net.iccard.accounting.tx;

import java.io.Serializable;

/**
 * ֧���������
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
