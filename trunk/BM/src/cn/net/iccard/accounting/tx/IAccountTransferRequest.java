package cn.net.iccard.accounting.tx;

/**
 * ����ת�˽�������
 * 
 * @author Angi
 * 
 */
public interface IAccountTransferRequest extends ICommonAccountTxRequest {

	int getAccountIdFrom();

	int getAccountIdTo();
}
