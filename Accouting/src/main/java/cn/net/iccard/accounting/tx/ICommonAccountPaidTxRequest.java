package cn.net.iccard.accounting.tx;

/**
 * ʵ������ͨ������
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountPaidTxRequest extends ICommonAccountTxRequest {
	int getRelatedBizLogId();
}
