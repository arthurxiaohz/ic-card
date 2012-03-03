package cn.net.iccard.accounting.account;

/**
 * 账户服务
 * 
 * @author Angi
 * 
 */
public interface IAccountService {

	/**
	 * 开户
	 * 
	 * @return
	 */
	IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest);

}
