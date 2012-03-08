package cn.net.iccard.accounting.account;

/**
 * 账户开户请求
 * 
 * @author Angi
 * 
 */
public interface IAccountOpenRequest extends IAccountOpenForOrgRequest {

	int getAccountCatalog();

	int getAccountPartyType();

}
