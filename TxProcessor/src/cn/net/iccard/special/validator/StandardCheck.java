package cn.net.iccard.special.validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;

import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;

public class StandardCheck {

	
	// �������������ʽ
	public static Pattern orderAmountPattern = Pattern.compile("\\d{1,16}");
	
	
	/**
	 * �ж��Ƿ�Ϊ������
	 * 
	 * @param p
	 * @param matherStr
	 * @return
	 */
	public static boolean isNumer(final Pattern p,
			final String matherStr,final int number) {
		
		BigDecimal tDecimal  = new BigDecimal(matherStr).movePointRight(number);
		boolean flag = isPatternMatcher(p,tDecimal.toString());
		return flag;
	}
	
	/**
	 * �ж�һ���ַ����Ƿ����ƶ���ģʽƥ��
	 * 
	 * @param p
	 * @param matherStr
	 * @return
	 */
	public static boolean isPatternMatcher(final Pattern p,
			final String matherStr) {
		Matcher m = p.matcher(matherStr);
		return m.matches();
	}
	
	//��ѯ�̻���Ϣ
	public static TblMchtInfo isMcht(final String MchtNo,TblMchtInfoManager  tblMchtInfoMan)
	{
		
		Filter filterno = FilterFactory.getSimpleFilter("mchtNo", MchtNo, Filter.OPERATOR_EQ);

		List<TblMchtInfo> tblMchtInfoList  = tblMchtInfoMan.getObjects(filterno);
			
		TblMchtInfo tblmchtinfo = (TblMchtInfo)tblMchtInfoList.get(0);
		
		return tblmchtinfo;
			
	}
	

	//��ѯ�̻�����
	public static List<TblTxPayMentOrder> isOrderNo(final String MchtNo,final String mchtTxTraceNo,final String mchtTxTime,TblTxPayMentOrderManager  tblTxPayMentOrderManager)
	{
		
		Filter filterno = FilterFactory.getSimpleFilter("mchtNo", MchtNo, Filter.OPERATOR_EQ);
		
		filterno.addCondition("mchtTxTime", mchtTxTime, Filter.OPERATOR_EQ)
		.addCondition("mchtTxTraceNo", mchtTxTraceNo, Filter.OPERATOR_EQ);
		

		List<TblTxPayMentOrder> txPayMentOrderList  = tblTxPayMentOrderManager.getObjects(filterno);
		
		return txPayMentOrderList;
			
	}
	
}
