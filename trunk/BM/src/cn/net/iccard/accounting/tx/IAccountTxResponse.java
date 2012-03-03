package cn.net.iccard.accounting.tx;

import cn.net.iccard.accounting.ICommonAccountResponse;

/**
 * 账务之交易操作通用响应
 * 
 * @author Angi
 * 
 */
public interface IAccountTxResponse extends ICommonAccountResponse {

	/**
	 * 凭证号
	 * 
	 * @return
	 */
	String getVoucherNo();
}
