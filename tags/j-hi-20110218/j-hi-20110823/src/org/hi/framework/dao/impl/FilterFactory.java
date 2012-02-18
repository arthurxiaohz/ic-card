package org.hi.framework.dao.impl;

import java.util.Collection;

import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.SecurityFilter;


/**
 * �����������Ĺ�����ͨ���ù����ཫ����Ĺ�������װ������
 * <p>�ù����������Ҫ�Զ�������Ӧ�Ĺ���������Ϊ�丳һ���ĳ�ֵ��
 * Ŀǰ�ù�������<code>getSimpleFilter</code>�������Ժ������Ȩ�޻��û��Ĺ���
 * 
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.impl.SimpleFilter
 * @author ���
 * @since 2006-11-15
 * 
 */
public class FilterFactory {
	
	/**
	 * ����������һ����ͨ������
	 * @param name �ֶ���
	 * @param val ֵ
	 * @return ������
	 */
	public static Filter getSimpleFilter(String name, Object val){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val);
		return filter;
	}
	
	/**
	 * ����������һ��������
	 * @param name �ֶ���
	 * @param val ֵ
	 * @param op ������
	 * @return ������
	 */
	public static Filter getSimpleFilter(String name, Object val, String op){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val, op);
		return filter;
	}
	
	/**
	 * ����������һ��������
	 * @param name �ֶ���
	 * @param val ֵ
	 * @param op ������
	 * @param relation ��ϵ��
	 * @return ������
	 */
	public static Filter getSimpleFilter(String name, Object val, String op ,String relation){
		SimpleFilter filter = new SimpleFilter();
		filter.addCondition(name, val, op, relation);
		return filter;
	}
	
	/**
	 * ����������һ����IN�������Ĺ�����
	 * @param name �ֶ���
	 * @param val ֵ
	 * @return ������
	 */	
	public static InFilter getInFilter(String name, Collection val){
		InFilter filter = new InFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN);
		return filter;
	}

	/**
	 * ����������һ����IN�������Ĺ�����
	 * @param name �ֶ���
	 * @param val ֵ
	 * @param op ������
	 * @param relation ��ϵ��
	 * @return ������
	 * ע��:��Ϊ�ӿ�ԭ��,�÷�����op������Ч,�������øò���ֵΪʲôϵͳ���Ὣ��
	 * �Զ�ת��ΪIN,��Ӧ<code>Filter.OPERATOR_IN</code>,�����ڵ��ø÷���ʱ��op
	 * ��������Ϊnull.
	 * ����:FilterFactory.getInFilter(name, val, null, relation);
	 */	
	public static InFilter getInFilter(String name, Collection val, String relation){
		InFilter filter = new InFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN, relation);
		return filter;
	}
	
	/**	
	 * ����������һ����IN�������Ĺ�����
	 * @param name �ֶ���
	 * @param val ֵ
	 * @return ������
	 */	
	public static NotInFilter getNotInFilter(String name, Collection val){
		 NotInFilter filter = new NotInFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN);
		return filter;
	}

	/**
	 * ����������һ����IN�������Ĺ�����
	 * @param name �ֶ���
	 * @param val ֵ
	 * @param op ������
	 * @param relation ��ϵ��
	 * @return ������
	 * ע��:��Ϊ�ӿ�ԭ��,�÷�����op������Ч,�������øò���ֵΪʲôϵͳ���Ὣ��
	 * �Զ�ת��ΪIN,��Ӧ<code>Filter.OPERATOR_IN</code>,�����ڵ��ø÷���ʱ��op
	 * ��������Ϊnull.
	 * ����:FilterFactory.getInFilter(name, val, null, relation);
	 */	
	public static NotInFilter getNotInFilter(String name, Collection val ,String relation){
		NotInFilter filter = new NotInFilter();
		filter.addCondition(name, val, Filter.OPERATOR_IN, relation);
		return filter;
	}	
	
	/**
	 * ����������һ����ͨ������
	 * @param name �ֶ���
	 * @param val ֵ
	 * @return ������
	 */
	public static Filter getNotLikeFilter(String name, String val){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE);
		return filter;
	}
	
	public static Filter getNotLikeFilter(String name, String val ,String relation){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation);
		return filter;
	}
	
	public static Filter getNotLikeFilter(String name, String val ,String relation, int controler){
		NotLikeFilter filter = new NotLikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, controler);
		return filter;
	}
	
	public static Filter getLikeFilter(String name, String val){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE);
		return filter;
	}
	
	public static Filter getLikeFilter(String name, String val ,String relation){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, LikeFilter.LIKE_CONTROLER_ALL);
		return filter;
	}	

	public static Filter getLikeFilter(String name, String val ,String relation, int controler){
		LikeFilter filter = new LikeFilter();
		filter.addCondition(name, val, Filter.OPERATOR_LIKE, relation, controler);
		return filter;
	}
	
	/**
	 * ����������һ�����ݼ�Ȩ�޹�����
	 * @return ������
	 */
	public static Filter getSecurityFilter(){
		String className = HiConfigHolder.getSecurityFilterCalss();
		SecurityFilter filter =  null;
		try {
			filter = (SecurityFilter) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return filter.getSeurityFilter();
	}
}
