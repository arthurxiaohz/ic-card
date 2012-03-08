package cn.net.iccard.accounting.tx;

/**
 * 应付交易通用请求
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountPayableTxRequest extends ICommonAccountTxRequest {

	String getExpiredDate();
}
