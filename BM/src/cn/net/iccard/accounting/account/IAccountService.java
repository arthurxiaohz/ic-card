package cn.net.iccard.accounting.account;

/**
 * �˻�����
 * 
 * @author Angi
 * 
 */
public interface IAccountService {

	/**
	 * ����
	 * 
	 * @return
	 */
	IAccountResponse openAccount(IAccountOpenRequest accountOpenRequest);

}
