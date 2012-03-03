package cn.net.iccard.accounting.tx;

import java.io.Serializable;

/**
 * ������ͨ������
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountTxRequest extends Serializable {

	/**
	 * ���
	 * 
	 * @return
	 */
	int getAmount();

	/**
	 * ҵ��
	 * 
	 * @return
	 */
	int getBizType();

	/**
	 * ҵ����ˮ
	 * 
	 * @return
	 */
	int getBizLogId();

	/**
	 * ����Ա
	 * 
	 * @return
	 */
	int getOperator();

	/**
	 * ��ע
	 * 
	 * @return
	 */
	String getRemark();

}
