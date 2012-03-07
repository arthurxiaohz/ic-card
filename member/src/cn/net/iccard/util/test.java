package cn.net.iccard.util;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import org.hi.common.util.BeanUtil;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.model.BaseObject;
import org.hi.framework.web.PageInfoUtil;

import cn.net.iccard.tx.action.TblTxPayMentRequestPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.service.impl.TblTxPayMentRequestManagerImpl;

public class test {

	
	private static Filter deletedFilter(Class clazz){
		if(BeanUtil.hasPropertyName(BeanUtil.CreateObject(clazz.getName()), BaseObject.POJO_DELETED)){
			Filter filter = FilterFactory.getSimpleFilter(BaseObject.POJO_DELETED, new Integer(1), Filter.OPERATOR_NOT_EQ)
			.addCondition(BaseObject.POJO_DELETED, null, Filter.OPERATOR_EQ, Filter.RELATION_OR);
			return filter;
		}
		return null;
	}
	
//	public static void main(String args[]){
//		
//		/*
//		TblTxPayMentRequestPageInfo TblTxPayMentRequestPageInfo= new TblTxPayMentRequestPageInfo();
//		
//		TblTxPayMentRequestPageInfo.setF_amount_op("1002");
//		
//		Filter Filter = PageInfoUtil.populateFilter(TblTxPayMentRequestPageInfo);
//		System.out.println(Filter);
//		TblTxPayMentRequestManagerImpl TblTxPayMentRequestManagerImpl = new TblTxPayMentRequestManagerImpl();
//		List list  = TblTxPayMentRequestManagerImpl.getObjects(TblTxPayMentRequest.class,Filter);
//		
//		System.out.println("111111111");
//		System.out.println(Filter);
//		*/
//		Timestamp a = new Timestamp(System.currentTimeMillis());
//		System.out.println(DateUtil.date2showString(a));
//		
//	}
	
	public static void main(String args[]){
		String a = "MchtTxTraceNo=1221314|TxAmount=123|MerchantNo=2342|TxDate=20120202|TxTime=121212|TxBody=百度一下|ShowUrl=http://www.baidu.com|UseCoupon=|CouponMsg=|NotifyURL=|BGNotifyURL=";
		try {
			String tPlainByBase64 = Base64.encode(a.getBytes("UTF-8"));
			
			System.out.println(tPlainByBase64);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
