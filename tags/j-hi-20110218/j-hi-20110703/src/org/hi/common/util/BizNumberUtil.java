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
 * 该类是用于生成业务编号的工具类,所谓业务编号指如订单编号、出/入库单编号.
 * 一般来说对些类编号均为前缀+流水号+后缀,大多数前缀是日期或是定死的大字母
 * 
 * @author 张昊
 * @since 2007-10-16
 *
 */
public class BizNumberUtil {
	
	/**
	 * 生成自然流水号,也就是指定类型所对应的数据库表的记录个数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @return 返回记录个数
	 */
	public static String genNumber(String propertyName, Class clazz){
		return genNumber(propertyName, clazz, null, null);
	}
	
	/**
	 * 生成自然流水号,也就是指定类型所对应的数据库表并按前缀过滤后的记录个数
	 * 例如S1,S2,S10
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param prefix 前缀
	 * @return 返回加前缀后的自然流水号
	 */
	public static String genNumber(String propertyName, Class clazz, String prefix){
		
		return genNumber(propertyName, clazz, prefix, null);
	}
	
	/**
	 * 生成自然流水号,也就是指定类型所对应的数据库表并按前缀过滤后的记录个数.
	 * 例如S1E,S2E,S10E
	 * 
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param prefix 前缀
	 * @param postfix 后缀
	 * @return 返回加前/后缀后的自然流水号
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
	 * 生成指定位数的流水号,如0001或003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genNumber(2, "supplerNum", Supplier.class),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,两位占位。如数据库中
	 * 供应商的最大编号为05那么调用该方法将会返回06的字符串
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @return 返回下一个流水号的字符串
	 */
	public static String genNumber(int digit, String propertyName, Class clazz){
		return genNumber(digit, propertyName, clazz, null, null);
	}
	
	/**
	/**
	 * 生成指定位数的流水号,如D0001或S003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genNumber(2, "supplerNum", Supplier.class, "S"),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,不包括前缀有两位占位。如数据库中
	 * 供应商的最大编号为S05那么调用该方法将会返回S06的字符串
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param prefix 前缀
	 * @return  返回下一个流水号的字符串
	 */
	public static String genNumber(int digit, String propertyName, Class clazz, String prefix){
		return genNumber(digit, propertyName, clazz, prefix, null);
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号,
	 * 如20071018001或20071018003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,不包括前缀有两位占位,前缀为当前日期
	 * 转换方式为yyyyMMdd。如数据库中供应商的当天最大编号为2007101805那么调用该方法将会返回2007101806的字符串
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @return  返回下一个流水号的字符串
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz){
		return genDateNumber(digit, propertyName, clazz, new Date());
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号,
	 * 如20071018001或1018003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class, "MMdd"),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,不包括前缀有两位占位,前缀为当前日期,
	 * 转换方式由参数datePattern(MMdd)指定。如数据库中供应商的当天最大编号为101805那么调用该方法将会返回101806的字符串 
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param datePattern 日期换转模式
	 * @return  返回下一个流水号的字符串
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern){
		return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, null );
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号,
	 * 如20071018-001或1018$003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genDateNumber(2, "supplerNum", Supplier.class, "MMdd", "-"),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,不包括前缀有两位占位,前缀为当前日期,日期流水号之间通过-分隔
	 * 转换方式由参数datePattern(MMdd)指定。如数据库中供应商的当天最大编号为1018-05那么调用该方法将会返回1018-06的字符串 
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param datePattern 日期换转模式
	 * @param separator 日期流水号之间的分隔符
	 * @return  返回下一个流水号的字符串
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, String datePattern, String separator){
		return genDateNumber(digit, propertyName, clazz, new Date(), datePattern, null, null, separator );
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param date 给定日期
	 * @return  返回下一个流水号的字符串
	 * @see #genDateNumber(int, String, Class)
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, Date date){
		return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", null, null, null);
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param date 给定日期
	 * @param prefix 前缀
	 * @return  返回下一个流水号的字符串
	 * @see #genDateNumber(int, String, Class)
	 */
	public static String genDateNumber(int digit, String propertyName, Class clazz, Date date, String prefix){
		return genDateNumber(digit, propertyName, clazz, date, "yyyyMMdd", prefix, null, null);
	}
	
	/**
	 * 以日期做为前缀生成批定位数的流水号
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param date 给定日期
	 * @param datePattern 日期换转模式(缺省为yyyyMMdd)
	 * @param prefix 前缀 
	 * @param postfix 后缀
	 * @param separator 日期流水号之间的分隔符
	 * @return  返回下一个流水号的字符串
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
	 * 生成指定位数的流水号,如0001或003,规则为取给定类型所对应数据库表的字段最大值加1
	 * 比如BizNumberUtil.genNumber(2, "supplerNum", Supplier.class,"S","L"),表示为
	 * Supplier类型所对应的数据表字段(属性名)为supplerNum最大值加一,两位占位。如数据库中
	 * 供应商的最大编号为S05L那么调用该方法将会返回S06L的字符串,其中S与L分别为前/后缀
	 * @param digit 占位数
	 * @param propertyName 属性名
	 * @param clazz 类型
	 * @param prefix 前缀
	 * @param postfix 后缀
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
		
		//拼占位符
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
	 * 得到数据库中满足条件的最后一个编号
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
