package cn.net.iccard.accounting.tx;

/**
 * �˿��������
 * 
 * @author Angi
 * 
 */
public interface IRefundClearingAccountRequest extends IPaymentClearingAccountRequest {

	boolean isFeeReturn();

}
