package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

/** 
 *  Data Access Object (Dao) interface. �ýӿ�Ŀ���������ݷ��ʣ����������κε�ҵ���߼�.<p>
 *  <a href="http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html">DAO��Ҫ������<i></i></a></p>
 *  ����ӿ���Ҫ�ṩ�������ݿ���ͨ�õ�ԭʼ������������Ϊһ����ʶ�ӿ���������������һ��DAO
 * 	<p>����Ҫ���ܣ�
 * 	ʵ�ֶ����ݿ��׼��CRUD [Create,Retrieve,Update,Delete]����,�����ṩ���Ĺ����Է����ǲ�ѯ
 * 	��ѯ��Ҫ��ΪFilter(������),Sorter����������,Page(ҳ��)��
 * <p>ע�⣺���ӿ������з����ڲ�ѯʱ��֧�ֶ����ݵķ��顢���������ӡ��ۼ��Ȳ��������Ҫʵ�������������
 * �����ڸþ�����������Բ�ͬ��ORM����ֶ�����ʵ��֮
 * <p>���ں������ݵĲ�ѯ��ò�Ҫ��ORM��Щ�������Ŀ���Ƽ��ͳ��JDBC��洢�������ϵķ�ʽʵ�֣���Ч����Ҫ��ʹ���м��Ŀ��ܶ� 
 *  
 *  @author ���
 *  @since 2006-11-13
 *  @see org.hi.framework.dao.Filter
 *  @see org.hi.framework.dao.Sorter
 */
public interface DAO {

	/**
	 * �������¸����Ķ���
	 * <p>�������ݿ���˵�����Ǳ���(insert)���Ǹ���(update)��������ORM����ƣ���Ҫ���ж�����������IDֵ
	 * �����ݿ����Ƿ���ڣ�������������Ǳ��棬������Ϊ���²���
	 * @param obj Ҫ�������µ����ݿ��еĶ���
	 * @param mode ������������Դģʽ
	 */
	public void saveObject(Object obj);

	/**
	 * �������Ķ�������ݿ���ɾ��
	 * <p>����ö����Ӧ�����ݿ�������ӱ���һ��ɾ��
	 * ��������ݿ���û���ҵ�ָ���ļ�¼Spring���׳�<code>DataAccessException</code>�쳣
	 * 
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param id ��Ӧ�����ݿ��������ID��һ��ֵ
	 * @see DataAccessException
	 */
	public void removeObjectById(Class clazz, Serializable id);
	
	/**
	 * �������Ķ�������ݿ���ɾ��
	 * <p>����ö����Ӧ�����ݿ�������ӱ���һ��ɾ��
	 * ��������ݿ���û���ҵ�ָ���ļ�¼Spring���׳�<code>DataAccessException</code>�쳣
	 * 
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param id ��Ӧ�����ݿ��������ID��һ��ֵ
	 * @see DataAccessException
	 */
	public void removeObject(Object obj);
	

	/**
	 * ���ݸ��������ͼ����ݿ���ж�Ӧ������IDֵ����һ��POJO����
	 * <p>���ͨ����������Ϣû���ҵ���¼��������ֵΪ<code>null</code>��������ʱ
	 * �׳�<code>ObjectRetrievalFailureException</code>�쳣,���쳣�ᱻSpring����
	 * ����ͳһ����
	 * 
	 * ע�⣺�÷�����֧�ָ����������ڱ�ϵͳ�����Ҳ��׼��֧�ָø���������ѯ�Ĺ��ܡ���Ϊ������������������
	 * ������ʷ�������⣬��ϵͳ��ܲ����Ƕ�����ϵͳ�����ݲ���ҵ�����ȫ�����ϵ�֧��
	 * 
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param id ��Ӧ�����ݿ��������ID��һ��ֵ
	 * @return ����һ��POJO����
	 */
	public Object getObjectById(Class clazz, Serializable id);
	
	/**
	 * ���ݸ��������ͼ�����������һ��POJO����,Ҫ������������õ����ݿ��ֶα�����Ψһ�ֶ�
	 * ����ж���һ���ļ�¼����������׳��쳣
	 * <p>���ͨ����������Ϣû���ҵ���¼��������ֵΪ<code>null</code>��������ʱ
	 * �׳�<code>ObjectRetrievalFailureException</code>�쳣,���쳣�ᱻSpring����
	 * ����ͳһ����
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param filter Ҫ���Ӧ���ݿ��¼Ψһ,������
	 * @return ����һ��POJO����
	 */
	public Object getUniqueObject(Class clazz, Filter filter);
	
	/** 
	 *  ���ݸ��������ͷ���POJO�����List.
	 *  <p>һ����˵�����������������Ͷ�Ӧ���ݿ���е����м�¼������ORM����ת��ΪPOJO����
	 *  
	 *  @param clazz ��Ӧ�����ݿ���POJO����
	 *  @return ��ORM��װ���POJO����
	 */
	public List<Object> getObjects(Class clazz);
	
	/**
	 * ���ݸ����Ĺ����������ݿ��з���ָ����Ӧ�Ľ��
	 * <p>���<code>Filter</code>����Ϣ�����ݿ�����hibernate������Ϣ��Ӧ��������׳�
	 * <code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣
	 * 
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param filter ����ѯ�Ĺ�����
	 * @return ����ָ�����͵�POJO�����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, Filter filter);
	
	/**
	 * ���ݸ����Ĺ������������������ݿ��з���ָ����Ӧ�Ľ��
	 * <p>���<code>Filter</code>��<code>Sorter</code>��Ϣ�����ݿ�����hibernate������Ϣ��Ӧ��������׳�
	 * <code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @return ����ָ�����͵�POJO�����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, Filter filter, Sorter soter);
	
	/**
	 * ���ݸ����Ĺ������������������ݿ��з���ָ����Ӧ�Ľ��,�������page��Ϊnull�������page��
	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�<p>����ݹ�����������������50����¼��ÿҳ10������ǰҪ��ѯ
	 * ���ǵ���ҳ����ô���ص�<code>List</code>����ֻ��10����¼��������������ǰ��21������30����¼
	 * <p>ע�⣺����page�Ĳ���ֻ����ǰ����ʾ�б�ҳ����ʹ�ã����Ƽ����÷�������ҵ���߼����ϣ���Ϊ����
	 * �п��ܻ���ʧ�����������������ݡ����ں������ݵĲ�ѯ��ò�Ҫ��ORM��Щ�������Ŀ���Ƽ��ͳ��JDBC��
	 * �洢�������ϵķ�ʽʵ�֣���Ч����Ҫ��ʹ���м��Ŀ��ܶ�
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param filter ����ѯ�Ĺ�����
	 * @param sorter ����ѯ��������
	 * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
	 * @return ����ָ�����͵�POJO�����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * 
	 */
	public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter, Page page);
	
	/**
	 * ���ݸ�����ҳ����Ϣ�����ݿ��з���ָ����Ӧ�Ľ����������Ĳ���ԭ����<code>getObjects(clazz, filter, sorter, page)</code>
	 * ��ȫ��ͬ
	 * <p>����page��pageInfo����������pageInfo�Ƕ�filter/sorter/page����һ���װ
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param pageInfo ����ѯ��ҳ����Ϣ
	 * @return ����ָ�����͵�POJO�����<code>List</code>����
	 * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, PageInfo pageInfo);
	
	/**
	 * �������͵õ����ݿ�����ܵļ�¼����
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @return ���ؼ�¼����
	 */
	public int getObjectCount(Class clazz);
	
	/**
	 * ����������������õ�����������¼����
	 * @param clazz��Ӧ�����ݿ���POJO����
	 * @param filter ������
	 * @return ���ؼ�¼����
	 */
	public int getObjectCount(Class clazz, Filter filter);
	
	
	public HiDialect getDialect();

}