package org.hi.framework.dao.hibernate;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;

/**
 * 
 * ���ӿ��Ƕ�hibernate���Եĳ�����<code>Dialect</code>�����ⲹ��.����ʵ�ָýӿڵ�������̳���hibernate
 * �ṩ��<code>Dialect</code>������ص���ʵ��.�ýӿ��е����з���������<code>BaseDAOHibernate</code>���б�����
 * <p>��hibernate�з��Ե�������ͨ����<code>Dialect</code>�Ĳ�ͬ����ʵ����ʵ�ֲ�ͬ���ݿ�ϵͳ(RDBMS)֮
 * ��Ĳ�����
 * 
 * @author ���
 * @since 2008-7-6
 * @see org.hibernate.dialect.Dialect
 * @see org.hi.framework.dao.hibernate.BaseDAOHibernate
 *
 */
public interface HibernateHiDialect extends HiDialect{
	

//	/**
//	 * ͨ�������Ĺ�������filter����ҳ��(page)��ƴhql����,���޶������ݿ��ѯʱ��������
//	 * ������¼��
//	 * <p>ע�⣺��ͬ���ݿ�ϵͳ������޼�¼���Ĵ���ʽ��ͬ,��hibernate���ⷽ��û���ṩ������Ϊȫ���
//	 * �������,�����ʵ�ָ÷���ʱҪ�����ݿ�ϵͳ�Ĳ��켰hibernate��ͬ���Ե�ʵ�ַ�ʽ����
//	 * @param hql hibernate��hql���
//	 * @param filter ������
//	 * @param page ҳ����Ϣ
//	 * @return ���ش��в�ͬ���ݿ�ϵͳ������޼�¼���ؼ��ֵ�hql���,��SQLServer:top;MySQL:limit;Oracle:rownum��
//	 * ���ֲ��������෽��ʵ��֮
//	 */
//	String getMaxRecode(Object hql, Filter filter, Page page);
//	
}