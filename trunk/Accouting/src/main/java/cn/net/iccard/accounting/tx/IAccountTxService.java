package cn.net.iccard.accounting.tx;

import javax.security.auth.login.AccountException;

/**
 * 账务交易服务
 * 
 * @author Angi
 * 
 */
public interface IAccountTxService {

	/**
	 * 借记
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountDebitCreditResponse debit(
			IAccountDebitCreditRequest accountDebitCreditRequest);

	/**
	 * 贷记
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountDebitCreditResponse credit(
			IAccountDebitCreditRequest accountDebitCreditRequest);

	/**
	 * 转账
	 * 
	 * @return
	 * @throws AccountException
	 */
	IAccountTransferResponse transfer(
			IAccountTransferRequest accountTransferRequest);

}
