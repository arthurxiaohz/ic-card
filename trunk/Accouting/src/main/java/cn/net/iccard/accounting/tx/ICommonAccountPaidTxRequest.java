package cn.net.iccard.accounting.tx;

/**
 * 实付交易通用请求
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountPaidTxRequest extends ICommonAccountTxRequest {
	int getRelatedBizLogId();
}
