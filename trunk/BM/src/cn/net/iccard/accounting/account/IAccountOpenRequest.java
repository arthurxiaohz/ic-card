package cn.net.iccard.accounting.account;

import java.io.Serializable;

/**
 * 账户开户请求
 * 
 * @author Angi
 * 
 */
public interface IAccountOpenRequest extends Serializable {

	int getAccountCatalog();

	int getAccountPartyType();

	/**
	 * 开户方（编号）
	 * <p/>
	 * 比如：商户号等之类
	 * 
	 * @return
	 */
	String getAccountParty();

	/**
	 * 开户方名称
	 * 
	 * @return
	 */
	String getAccountName();

	/**
	 * 操作员
	 * 
	 * @return
	 */
	int getOperator();

	/**
	 * 备注
	 */
	String getRemark();

}
