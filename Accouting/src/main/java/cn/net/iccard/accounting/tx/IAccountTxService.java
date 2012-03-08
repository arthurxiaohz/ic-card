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

	/**
	 * 应付转账
	 * 
	 * 例如：预支付成功（由会员虚拟账户转账到会员担保账户（应付））
	 * 
	 * @param accountTransferRequest
	 * @return
	 */
	IAccountTransferResponse transfer(
			IAccountPayableTransferRequest accountRcvOrPabTransferRequest);

	/**
	 * 应付转账撤销
	 * 
	 * 例如：预支付撤销（由会员担保账户（应付）转账到会员虚拟账户）
	 * 
	 * @param accountTransferRequest
	 * @return
	 */
	IAccountTransferResponse transfer(
			IAccountPayableCancelTransferRequest accountPayableCancelTransferRequest);

	/**
	 * 应收付确认
	 * <p>
	 * 
	 * 修改原账务为已处理，并生成反向借/贷记
	 * 
	 * @param voucherType
	 * @param originalBizType
	 * @param originalBizLogId
	 * @param bizType
	 * @param bizLogId
	 * @return
	 */
	IAccountDebitCreditResponse doSettle(int voucherType, int originalBizType,
			int originalBizLogId, int bizType, int bizLogId);

}
