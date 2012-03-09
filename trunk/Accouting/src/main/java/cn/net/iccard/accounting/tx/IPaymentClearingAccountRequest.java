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

	String getUserName();

	int getMchtFee();

	int getMchtOrderAmount();

	/**
	 * ��Աʵ��֧�����̻��������۳������
	 * @return
	 */
	int getAmount();

	int getBizLogId();

}
