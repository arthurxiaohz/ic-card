package cn.net.iccard.accounting.account;

/**
 * �˻���������
 * 
 * @author Angi
 * 
 */
public interface IAccountOpenRequest extends IAccountOpenForOrgRequest {

	int getAccountCatalog();

	int getAccountPartyType();

}
