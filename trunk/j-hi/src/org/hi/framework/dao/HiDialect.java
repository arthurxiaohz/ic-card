package org.hi.framework.dao;

import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;

/**
 * ���Խӿ�����ʵ�ֲ�ͬRDBMS��SQL��������,���ӽӿڼ�������ֱ��Ӧ��ͬ��ORM������漰��ͬ�Ĺ�ϵ�����ݿ����ϵͳ
 * ���Ե�˼����ο�<code>Hibernate</code>�ķ���
 * @author ���
 * @since 2009-11-14
 * @see org.hi.framework.dao.hibernate.BaseDAOHibernate
 * @see org.hi.framework.dao.ibatis.IbatisHiDialect
 *
 */
public interface HiDialect {
	public static final String DATABASE_TYPE_MYSQL="MSSQL";
	public static final String DATABASE_TYPE_SQLSERVER="SQLSERVER"; 
	public static final String DATABASE_TYPE_ORACLE="ORACLE"; 
	
	public static final String HI_SEQUENCE_SUFFIX = "_SEQ";
	/**
	 * ͨ�������Ĺ�������filter����ҳ��(page)��ƴhql����,���޶������ݿ��ѯʱ��������
	 * ������¼��
	 * <p>ע�⣺��ͬ���ݿ�ϵͳ������޼�¼���Ĵ���ʽ��ͬ,��ORM������ⷽ��û���ṩ������Ϊȫ���
	 * �������,�����ʵ�ָ÷���ʱҪ�����ݿ�ϵͳ�Ĳ��켰ORM��ܲ�ͬ���Ե�ʵ�ַ�ʽ����
	 * @param query ��ѯ���
	 * @param filter ������
	 * @param page ҳ����Ϣ
	 * @return ���ش��в�ͬ���ݿ�ϵͳ������޼�¼���ؼ��ֵĲ�ѯ���,��SQLServer:top;MySQL:limit;Oracle:rownum��
	 * ���ֲ��������෽��ʵ��֮
	 */
	String getMaxRecode(Object query, Filter filter, Page page);
	
	/**
	 * ��������Ӧ����������ݿ�����
	 * @return ����ֵΪMSSQL/SQLSERVER/ORACLE
	 */
	String getDataBaseType();
	
	/**
	 * ��������ݿ��Ӧ�Ĺ�������SQL���
	 * @param filter ������
	 * @return ���������ݿ��SQL�ַ���
	 */
	String getFilterSQL(Filter filter, Manager manager);
}
