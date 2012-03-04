package cn.net.iccard.accounting.tx;

/**
 * 账务转账交易请求
 * 
 * @author Angi
 * 
 */
public interface IAccountTransferRequest extends ICommonAccountTxRequest {

	int getAccountIdFrom();

	int getAccountIdTo();
}
