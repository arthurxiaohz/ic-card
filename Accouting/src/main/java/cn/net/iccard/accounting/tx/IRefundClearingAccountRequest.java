package cn.net.iccard.accounting.tx;

/**
 * 退款清分请求
 * 
 * @author Angi
 * 
 */
public interface IRefundClearingAccountRequest extends IPaymentClearingAccountRequest {

	boolean isFeeReturn();

}
