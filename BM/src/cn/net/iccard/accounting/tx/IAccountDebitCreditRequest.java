package cn.net.iccard.accounting.tx;

/**
 * 账务借贷交易请求
 * 
 * @author Angi
 * 
 */
public interface IAccountDebitCreditRequest extends
		ICommonAccountTxRequest {

	int getAccountId();

}
