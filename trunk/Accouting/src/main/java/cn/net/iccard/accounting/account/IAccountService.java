package cn.net.iccard.accounting.account;

import cn.net.iccard.accounting.ICommonAccountResponse;

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
	IAccountOpenResponse openAccount(IAccountOpenRequest accountOpenRequest);

	/**
	 * 会员开户
	 * 
	 * @return
	 */
	ICommonAccountResponse openAccountForMemeber(
			IAccountOpenForOrgRequest accountOpenForOrgRequest);

	/**
	 * 商户开户
	 * 
	 * @return
	 */
	ICommonAccountResponse openAccountForMcht(
			IAccountOpenForOrgRequest accountOpenForOrgRequest);

}
