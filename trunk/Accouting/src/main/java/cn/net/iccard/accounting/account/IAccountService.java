package cn.net.iccard.accounting.account;

import cn.net.iccard.accounting.ICommonAccountResponse;

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
	IAccountOpenResponse openAccount(IAccountOpenRequest accountOpenRequest);

	/**
	 * ��Ա����
	 * 
	 * @return
	 */
	ICommonAccountResponse openAccountForMemeber(
			IAccountOpenForOrgRequest accountOpenForOrgRequest);

	/**
	 * �̻�����
	 * 
	 * @return
	 */
	ICommonAccountResponse openAccountForMcht(
			IAccountOpenForOrgRequest accountOpenForOrgRequest);

}
