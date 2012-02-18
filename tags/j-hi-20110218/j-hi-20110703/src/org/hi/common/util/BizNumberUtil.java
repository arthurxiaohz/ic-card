package org.hi.common.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.LikeFilter;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.impl.PageImpl;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;


/**
 * ��������������ҵ���ŵĹ�����,��νҵ����ָ�綩����š���/��ⵥ���.
 * һ����˵��Щ���ž�Ϊǰ׺+��ˮ��+��׺,�����ǰ׺�����ڻ��Ƕ����Ĵ���ĸ
 * 
 * @author ���
 * @since 2007-10-16
 *
 */
public class BizNumberUtil {
	
	/**
	 * ������Ȼ��ˮ��,Ҳ����ָ����������Ӧ�����ݿ��ļ�¼����
	 * @param propertyName ������
	 * @param clazz ����
	 * @return ���ؼ�¼����
	 */
	public static String genNumber(String propertyName, Class clazz){
		return genNumber(propertyName, clazz, null, null);
	}
	
	/**
	 * ������Ȼ��ˮ��,Ҳ����ָ����������Ӧ�����ݿ����ǰ׺���˺�ļ�¼����
	 * ����S1,S2,S10
	 * @param propertyName ������
	 * @param clazz ����
	 * @param prefix ǰ׺
	 * @return ���ؼ�ǰ׺�����Ȼ��ˮ��
	 */
	public static String genNumber(String propertyName, Class clazz, String prefix){
		
		return genNumber(propertyName, clazz, prefix, null);
	}
	
	/**
	 * ������Ȼ��ˮ��,Ҳ����ָ����������Ӧ�����ݿ����ǰ׺���˺�ļ�¼����.
	 * ����S1E,S2E,S10E
	 * 
	 * @param propertyName ������
	 * @param clazz ����
	 * @param prefix ǰ׺
	 * @param postfix ��׺
	 * @return ���ؼ�ǰ/��׺�����Ȼ��ˮ��
	 */
	public static String genNumber(String propertyName, Class clazz, String prefix, String postfix){
		int count = getCountNumber(propertyName, clazz, prefix);
		
		String lastNumber = String.valueOf(++count);
		
		if(prefix != null)
			lastNumber =  prefix + lastNumber; 
		
		if(postfix != null)
			lastNumber = lastNumber + postfix;
		
		return lastNumber;
	}
	
	private static int getCountNumber(String propertyName, Class clazz, String prefix){
		Filter filter = null;
		if(prefix != null)
			filter = FilterFactory.getSimpleFilter(propertyName, prefix);
		
		ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
		
		int result = bMgr.getObjectCount(clazz, filter);
		return result;
		
	}	
	
	/**
	 * ����ָ��λ������ˮ��,��0001��003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genNumber(2, "supplerNum", Supplier.class),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,��λռλ�������ݿ���
	 * ��Ӧ�̵������Ϊ05��ô���ø÷������᷵��06���ַ���
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @return ������һ����ˮ�ŵ��ַ���
	 */
	public static String genNumber(int digit, String propertyName, Class clazz){
		return genNumber(digit, propertyName, clazz, null, null);
	}
	
	/**
	/**
	 * ����ָ��λ������ˮ��,��D0001��S003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genNumber(2, "supplerNum", Supplier.class, "S"),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,������ǰ׺����λռλ�������ݿ���
	 * ��Ӧ�̵������ΪS05��ô���ø÷������᷵��S06���ַ���
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param prefix ǰ׺
	 * @return  ������һ����ˮ�ŵ��ַ���
	 */
	public static String genNumber(int digit, String propertyName, Class clazz, String prefix){
		return genNumber(digit, propertyName, clazz, prefix, null);
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��,
	 * ��20071018001��20071018003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,������ǰ׺����λռλ,ǰ׺Ϊ��ǰ����
	 * ת����ʽΪyyyyMMdd�������ݿ��й�Ӧ�̵ĵ��������Ϊ2007101805��ô���ø÷������᷵��2007101806���ַ���
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @return  ������һ����ˮ�ŵ��ַ���
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz){
		return genDateNumber(digit, propertyName, clazz, new Date());
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��,
	 * ��20071018001��1018003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class, "MMdd"),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,������ǰ׺����λռλ,ǰ׺Ϊ��ǰ����,
	 * ת����ʽ�ɲ���datePattern(MMdd)ָ���������ݿ��й�Ӧ�̵ĵ��������Ϊ101805��ô���ø÷������᷵��101806���ַ��� 
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param datePattern ���ڻ�תģʽ
	 * @return  ������һ����ˮ�ŵ��ַ���
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern){
		return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, null );
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��,
	 * ��20071018-001��1018$003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class, "MMdd", "-"),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,������ǰ׺����λռλ,ǰ׺Ϊ��ǰ����,������ˮ��֮��ͨ��-�ָ�
	 * ת����ʽ�ɲ���datePattern(MMdd)ָ���������ݿ��й�Ӧ�̵ĵ��������Ϊ1018-05��ô���ø÷������᷵��1018-06���ַ��� 
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param datePattern ���ڻ�תģʽ
	 * @param separator ������ˮ��֮��ķָ���
	 * @return  ������һ����ˮ�ŵ��ַ���
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern, String separator){
		return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, separator );
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param date ��������
	 * @return  ������һ����ˮ�ŵ��ַ���
	 * @see #genDateNumber(int, String, Class)
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, Date date){
		return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", null, null, null);
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param date ��������
	 * @param prefix ǰ׺
	 * @return  ������һ����ˮ�ŵ��ַ���
	 * @see #genDateNumber(int, String, Class)
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, Date date, String prefix){
		return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", prefix, null, null);
	}
	
	/**
	 * ��������Ϊǰ׺��������λ������ˮ��
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param date ��������
	 * @param datePattern ���ڻ�תģʽ(ȱʡΪyyyyMMdd)
	 * @param prefix ǰ׺ 
	 * @param postfix ��׺
	 * @param separator ������ˮ��֮��ķָ���
	 * @return  ������һ����ˮ�ŵ��ַ���
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, Date date, String datePattern, String prefix, String postfix, String separator){
		
		if( date == null)
			return "";
		if(datePattern == null)
			return "";
		
		if(prefix == null)
			prefix = "";
		DateFormat formater = new SimpleDateFormat(datePattern);
		prefix += formater.format(date);
		
		if(separator != null)
			prefix += separator;
		
		return genNumber(digit, propertyName, clazz, prefix, postfix);
	}
	
	/**
	 * ����ָ��λ������ˮ��,��0001��003,����Ϊȡ������������Ӧ���ݿ����ֶ����ֵ��1
	 * ����BizNumberUtil.genNumber(2, "supplerNum", Supplier.class,"S","L"),��ʾΪ
	 * Supplier��������Ӧ�����ݱ��ֶ�(������)ΪsupplerNum���ֵ��һ,��λռλ�������ݿ���
	 * ��Ӧ�̵������ΪS05L��ô���ø÷������᷵��S06L���ַ���,����S��L�ֱ�Ϊǰ/��׺
	 * @param digit ռλ��
	 * @param propertyName ������
	 * @param clazz ����
	 * @param prefix ǰ׺
	 * @param postfix ��׺
	 * @return
	 */
	public static String genNumber(int digit, String propertyName, Class clazz, String prefix, String postfix){
		if(digit == 0)
			return "";

		String lastNumber = getLastNumber(propertyName, clazz, prefix);
		int returnInt = 1;
		
		if(!lastNumber.equals("")){
			if(prefix != null)
				lastNumber = lastNumber.substring(prefix.length());
			
			if(postfix != null)
				lastNumber = lastNumber.substring(0, lastNumber.lastIndexOf(postfix));
		}
		
		if(!lastNumber.trim().equals("")){
			Integer lastInt = new Integer(lastNumber);
			returnInt = lastInt.intValue() + 1;
		}
		
		//ƴռλ��
		StringBuffer patternDigitSb = new StringBuffer("");
		for (int i = 0; i < digit; i++) 
			patternDigitSb.append("0");
		
		DecimalFormat formater = new DecimalFormat(patternDigitSb.toString());
		String returnNumber = formater.format(returnInt);
		
		if(prefix != null)
			returnNumber = prefix + returnNumber;
		if(postfix != null)
			returnNumber = returnNumber + postfix;
		
		return returnNumber;
	}
	
	/**
	 * �õ����ݿ����������������һ�����
	 * @return
	 */
	private static String getLastNumber(String propertyName, Class clazz, String prefix){
		Sorter sorter = SorterFactory.getSimpleSort(propertyName, Sorter.ORDER_DESC);
		Filter filter = null;
		if(prefix != null)
			filter = FilterFactory.getLikeFilter(propertyName, prefix, Filter.RELATION_AND, LikeFilter.LIKE_CONTROLER_RIGHT);
		Page page = new PageImpl();
		page.setPageSize(2);
		
		ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
		
		List result = bMgr.getObjects(clazz, filter, sorter, page);
		if( result.size() == 0)
			return "";
		
		return (String)BeanUtil.getPropertyValue(result.get(0), propertyName);
	}
}
