package cn.net.iccard.accounting.tx;

import java.io.Serializable;

/**
 * 账务交易通用请求
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountTxRequest extends Serializable {

	/**
	 * 商户订单金额
	 * 
	 * @return
	 */
	int getMchtOrderAmount();

	/**
	 * 金额
	 * <p>
	 * 会员实际支付金额，商户订单金额扣除红包等
	 * 
	 * @return
	 */
	int getAmount();

	/**
	 * 业务
	 * 
	 * @return
	 */
	int getBizType();

	/**
	 * 业务流水
	 * 
	 * @return
	 */
	int getBizLogId();

	/**
	 * 操作员
	 * 
	 * @return
	 */
	int getOperator();

	/**
	 * 备注
	 * 
	 * @return
	 */
	String getRemark();

}
