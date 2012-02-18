package org.hi.framework.dao.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.dao.impl.LikeFilter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.paging.impl.PageImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * �����ǽӿ�<code>DAO</code>���ʵ�����е�һ�����Ƕ�ORM����hibernate��DAO��ʵ�֡�
 * <p> ����̳�Spring��<code>HibernateDaoSupport</code>��������DAOʵ�ֵķ�����࣬������
 * һ��SessionFactory���ò������ṩһ��<code>HibernateTemplate</code>ʵ�� 
 * ����<code>HibernateTemplate</code>�����ǣ�����DAO�е����ݷ��ʣ��޷���ں�̨����Hibernate
 * Session.�Զ�����Spring�����ĺ�EJB���������񡣽��ɿ�ʽ<code>HibernateException</code>ת����Spring�ṩ
 * ��ͨ��<code>DataAccessException</code>��νṹ
 * <p>����HibernateĬ�ϵĶ��ڲ�ѯ����һ�����壬�����͵��������n����¼��ô��Ҫ�����ݽ���n�Σ�ÿ��
 * ֻ��ѯ��һ����¼������Ϊ��ͳ�Ʒ���������������ļ�¼���������ݿ��Ĳ����ԣ�����Ҫ��һ��select��
 * ���������Ӳ�ѯ��������Ч�ʿ����֪�������ڲ�ѯ��������ʱ��ò�Ҫ����Hibernate����������һ�β�ѯ
 * Ҫ���ش��������Ĳ���Hibernate����һ����ѵĽ������
 * @author ���
 * @since 2006-11-14
 * @see org.hi.framework.dao.DAO
 * @see org.hi.framework.dao.hibernate.HibernateDaoSupport
 * @see org.springframework.orm.hibernate3.HibernateTemplate
 * @see org.springframework.dao.DataAccessException
 * @see org.hibernate.HibernateException
 */
public class BaseDAOHibernate extends HibernateDaoSupport implements DAO {

	protected final Log log = LogFactory.getLog(getClass());

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#saveObject(java.lang.Object)
	 */
	public void saveObject(Object obj) {
		Session session = getHibernateSession();
		if(session != null)
			session.saveOrUpdate(obj);
		else
			getHibernateTemplate().saveOrUpdate(obj );
	}
	
	/**������ӻ����޸�coll�����еĶ���,������ѹܶ����update,�������ʱ�����save��
	 * @param coll
	 * @param mode
	 */
	public void saveObjects(Collection coll, int mode){
		Session session = getHibernateSession();
		if(session != null){
			for (Iterator it = coll.iterator(); it.hasNext();) {
				session.saveOrUpdate(it.next());
			}
		}
		else
			getHibernateTemplate().saveOrUpdateAll(coll);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#removeObjectById(java.lang.Class, java.io.Serializable)
	 */
	public void removeObjectById(Class clazz, Serializable id) {
		Session session = getHibernateSession();
		if(session != null)
			session.delete(getObjectById(clazz, id));
		else		
			getHibernateTemplate().delete(getObjectById(clazz, id));
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#removeObject(java.lang.Object)
	 */
	public void removeObject(Object obj) {
		Session session = getHibernateSession();
		if(session != null)
			session.delete(obj);
		else		
			getHibernateTemplate().delete(obj);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectById(java.lang.Class, java.io.Serializable)
	 */
	public Object getObjectById(Class clazz, Serializable id) {
		Session session = getHibernateSession();
		if(session != null)
			return session.get(clazz, id);
		
		return getHibernateTemplate().get(clazz, id);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getUniqueObject(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public Object getUniqueObject(final Class clazz, final Filter filter){
		Session session = getHibernateSession();
		if(session != null)
			return processUnique(session, clazz, filter);
		
		HibernateTemplate ht = getHibernateTemplate();
        Object result = ht.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                return processUnique(session, clazz, filter);
            }
        });
        return result;
	}
	

	/**���ݸ��������ͺ͹���������һ��POJO����
	 * @param session
	 * @param clazz
	 * @param filter
	 * @return
	 */
	Object processUnique(Session session, Class clazz, Filter filter) {
		Query[] queries = setupQuery(session, clazz, filter, null, null);
		Query query = queries[0];//0��ʾ�Ƿ��ز�ѯ��sql���
		long startTime = System.currentTimeMillis();
		Object result = query.uniqueResult();				//ִ��HQL��ѯ
		long endTime = System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("Query string: " + query.getQueryString() + "\n\t use:" 
				+ (endTime - startTime) + "ms");
		}
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class)
	 */
	public List getObjects(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public List getObjects(final Class clazz, final Filter filter){
		return getObjects(clazz, filter, null, null);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter)
	 */
	public List getObjects(final Class clazz, final Filter filter, final Sorter soter){
		return getObjects(clazz, filter, soter, null);
	}
	
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.dao.Filter, org.hi.framework.dao.Sorter, org.hi.framework.paging.Page)
	 */
	public List getObjects(final Class clazz, final Filter filter, final Sorter sorter, final Page page){
		Session session = getHibernateSession();
		if(session != null){
			return processFind(session, clazz, filter, sorter, page);
		}
		
        HibernateTemplate ht = getHibernateTemplate();
        List result = ht.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                return processFind(session, clazz, filter, sorter, page);
            }
        });
        return result;

	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjects(java.lang.Class, org.hi.framework.paging.PageInfo)
	 */
	public List getObjects(final Class clazz, final PageInfo pageInfo){
		if(pageInfo == null)
			return new ArrayList();
		
		Filter filter = null;
		Sorter sorter = null;
		Page page = null;
		filter = pageInfo.getFilter();
		sorter = pageInfo.getSorter();
		page = pageInfo.getPage();
		
		return getObjects(clazz, filter, sorter, page);
	}
	
	/**
	 * �÷���������¹��ܣ�1.���ݸ����Ĺ�������������������hibernate��Query���� 2.���ò�ѯ����
	 * �ļ�¼��������ֹλ�� 3.ִ��Query��list()�������ش���ѯ�Ľ���� 4.���ظý����
	 * ע�⣺�÷����᷵�������ѯ�����ļ�¼����������ֵ�ŵ�<code>Page</code>��totalRecords�����У�
	 * �������page��Ϊ�յĻ�
	 * @param session Hibernate��Session,�ö���ʵ����Spring����ṩ
	 * @param clazz ��Ӧ�����ݿ���POJO����
	 * @param filter ����ѯ�Ĺ�����
	 * @param sorter ����ѯ��������
	 * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
	 * @return ����ָ�����͵�POJO�����<code>List</code>����
	 */
	List processFind(Session session, Class clazz, Filter filter, Sorter sorter, Page page){
		Query[] querys = setupQuery(session, clazz, filter, sorter, page);
		return executQuery(querys, page);
	}

	/**
	 * ���ִ�и�����Query[],������page��Ϣ
	 * @param querys
	 * @param page
	 * @return
	 */
	List executQuery(Query[] querys, Page page){
		Query query = querys[0];
		Query countQuery = querys[1];
		
		if(page != null && countQuery != null){
			int count = 0;
			List countResult = countQuery.list();
			
			if(countResult != null && countResult.size() != 0){
				if (countResult.size() > 1 ) 
					count = countResult.size();
				else{
					Object result = countResult.get(0);
   					if (result instanceof Integer) 
						count = ((Integer)result).intValue();
					else if (result instanceof Long) 
						count = ((Long) result).intValue();
					else if(result instanceof BigDecimal)
						count = ((BigDecimal) result).intValue();
					else if(result instanceof BigInteger)
						count = ((BigInteger) result).intValue();
					else
						count = ((Number) result).intValue();
				}
				
				//�����ʵ��¼������޼�¼����ȡ����޼�¼��
				count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
					
				page.setTotalRecords(count);		//���ò�ѯ������ܼ�¼��
				
				int totoalPage = 0;
				totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
				page.setTotalPage(totoalPage);						//���ò�ѯ�������ҳ��
			}
			
			query.setFirstResult(page.getStartRowPosition()); 	//���÷��صĵ�һ����¼��λ��
			
			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords())
				query.setMaxResults(page.getMaxRecords() - page.getStartRowPosition());
			else
				query.setMaxResults(page.getPageSize());			//���÷��صļ�¼��
		}
		
		long startTime = System.currentTimeMillis();
		List result = query.list();								//ִ��HQL��ѯ
		long endTime = System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("Query string: " + query.getQueryString() + "\n\t use:" 
				+ (endTime - startTime) + "ms");
		}
		return result;
	}	
	
	/**��������HQL��䣬һ������Ҫ��ѯ����䣬��һ������Ҫͳ�ƵĲ�ѯ���
	 * @param session
	 * @param clazz
	 * @param filter
	 * @param sorter
	 * @param page
	 * @return
	 */
	private Query[] setupQuery(Session session, Class clazz, Filter filter, 
			Sorter sorter, Page page){
		
		StringBuffer mainSb = new StringBuffer(); //��HQL���
		StringBuffer countSb = new StringBuffer(); //ͳ�Ƽ�¼����HQL���
		String orderSt = "";					//������ַ���
		
		String aliasName = clazz.getSimpleName().toLowerCase() + "_1"; //filter�ޱ�����ȱʡ
		if(filter != null && filter.getAliasName() !=null && !filter.getAliasName().trim().equals(""))
			aliasName = filter.getAliasName();
			
		countSb.append("select count(*) ");
		mainSb.append("from ").append(clazz.getName()).append(" " + aliasName + " ");
		
		/*HQL�Ĺ��˲���*/
		if(filter != null && filter.getConditions().size() > 0){
			mainSb.append(" where ");
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //���filter����ֻ�����Լ���û��ͨ��addFilter�������ӵ�
				setupConditions(mainSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(mainSb, filtergroup, aliasName, i);
					mainSb.append(") ");
				}
			}
			
		}
				
		countSb.append(mainSb);
		
		String countHql = countSb.toString();
		SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor)session.getSessionFactory();
		
		/*Ϊcount������޼�¼�����������������ļ����ٶ�*/
		if(sessionFactory.getDialect() instanceof HibernateHiDialect) {
			HibernateHiDialect dialect = (HibernateHiDialect)sessionFactory.getDialect();
			countHql = dialect.getMaxRecode(countHql, filter, page);
		}
		
		/*HQL�����򲿷�*/
		if(sorter != null && !sorter.getSorts().isEmpty())
			orderSt = " order by " + aliasName + "." +sorter.toString();
		
		/*����ͳ�Ʒ��ز�ѯ��¼������Ҫ��ѯ��Queryʵ��*/
		Query countQuery = null, query = null;
		if (page != null) 
			countQuery = session.createQuery(countHql);
		query = session.createQuery(mainSb.append(orderSt).toString());
		
		/*���������������ռλ���������Ӧ��ֵ*/
		if(filter != null  && filter.getConditions().size() > 0){
			IntWrapper mainIntWrapper = new IntWrapper();	//����һ�����㿪ʼ�ļ���������
			IntWrapper countIntWrapper = new IntWrapper();	//����һ�����㿪ʼ�ļ���������
			List filterBeans = filter.getConditions();
			for (Iterator i = filterBeans.iterator(); i.hasNext();) {
				FilterBean filterBean = (FilterBean) i.next();
				
				if(filterBean.getValue() == null)
					continue;
				
				String operater = filterBean.getOperater();
				
				/*�����ֵ���������ַ��������Ҳ�������like����ֵ�����˼Ӱٷֺţ�%��*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//�ж�like�Ŀ��Ʒ�
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
						val = "%" + val;
					else if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
						val =  val + "%";
					else if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
						val =  "%" + val + "%";
					else
						val =  "%" + val + "%";
					
					filterBean.setValue(val);
				}
				
				setParameter(query, mainIntWrapper, filterBean.getValue());  //ΪHQL��Query����,��������ռλ����ֵ
				if(page != null)
					setParameter(countQuery,countIntWrapper, filterBean.getValue());
			}
		}
		
		Query[] querys = {query, countQuery};
		return querys;
	}
	
	private void setupConditions(StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*ΪHQL����������������ռλ��*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //����ǵ�һ��������,������ǰ��Ӹ�����
				mainSb.append("( ");
			
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //������ǵ�һ��������,���ڹ�ϵ�����������
				mainSb.append(filterBean.getRelations()).append(" ( ");
			
			if(i > 0 )
				mainSb.append(filterBean.getRelations()).append(" ");			//�����������֮��Ĺ�ϵ��
			
			if(aliasName != null && !aliasName.trim().equals(""))
				mainSb.append(aliasName + ".");

			mainSb.append(filterBean.getFieldName()).append(" ");				//��Ӳ�ѯ���ֶ���
			
			
			
			Object val = filterBean.getValue();
			if(val == null){
				if (operater.equals(Filter.OPERATOR_EQ))
					mainSb.append("IS NULL ");
				else
					mainSb.append("IS NOT NULL ");
				continue;
			}
			
			mainSb.append(operater).append(" "); 				//��Ӳ�����

			if(filterBean.isNot())					
				mainSb.append("NOT ");							//���NOT������
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	�����������IN����ÿһ��ֵ��Ӧһ������ռλ��
				mainSb.append("(");
				Collection coll = (Collection)filterBean.getValue();
				for(int j = 0; j < coll.size(); j++){
					if(j > 0)
						mainSb.append(",");
					mainSb.append("?");
				}
				mainSb.append(") ");
			}
			else
				mainSb.append("? ");								//������λ����Ϊ����ռλ��
			
		}
	}
	
    /**
     * �ж�value�������Ƿ���һ������,������value�������ۼӼ�����
     */
    private void setParameter(Query query, IntWrapper index, Object value) {
    	if(value instanceof Collection){
    		Collection values = (Collection)value;
    		for (Iterator i = values.iterator(); i.hasNext();) {
				Object val = (Object) i.next();
				setParameterSingle(query, index.getInt(), val);
				index.IntAddOne();
			}
    	}
    	else{
    		 setParameterSingle(query, index.getInt(), value);
    		 index.IntAddOne();
    	}
    }
    
    
    private Query setParameterSingle(Query query, int index, Object value) {
        Query result;
        if (value instanceof Boolean) {
        	result = query.setBoolean(index, ((Boolean) value).booleanValue());
        } else if (value instanceof Byte) {
        	result = query.setByte(index, ((Byte) value).byteValue());
        } else if (value instanceof Character) {
        	result = query.setCharacter(index, ((Character) value).charValue());
        } else if (value instanceof Double) {
        	result = query.setDouble(index, ((Double) value).doubleValue());
        } else if (value instanceof Float) {
        	result = query.setFloat(index, ((Float) value).floatValue());
        } else if (value instanceof Integer) {
        	result = query.setInteger(index, ((Integer) value).intValue());
        } else if (value instanceof Long) {
        	result = query.setLong(index, ((Long) value).longValue());
        } else if (value instanceof Short) {
        	result = query.setShort(index, ((Short) value).shortValue());
        } else if (value instanceof String) {
        	result = query.setString(index, (String) value);
        } else if (value instanceof byte[]) {
        	result = query.setBinary(index, (byte[]) value);
        } else if (value instanceof BigDecimal) {
        	result = query.setBigDecimal(index, (BigDecimal) value);
        } else if (value instanceof BigInteger) {
        	result = query.setBigInteger(index, (BigInteger) value);
        } else if (value instanceof Date) {
        	result = query.setDate(index, (Date) value);
        } else if (value instanceof Time) {
        	result = query.setTime(index, (Time) value);
        } else if (value instanceof Timestamp) {
        	result = query.setTimestamp(index, (Timestamp) value);
        } else if (value instanceof java.util.Date) {
        	result = query.setDate(index, (java.util.Date) value);
        } else if (value instanceof Locale) {
        	result = query.setLocale(index, (Locale) value);
        } else {
        	result = query.setParameter(index, value);
        }
        return result;
    }
    
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class)
	 */
	public int getObjectCount(Class clazz){
		return getObjectCount(clazz, null);
	}
	
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.DAO#getObjectCount(java.lang.Class, org.hi.framework.dao.Filter)
	 */
	public int getObjectCount(final Class clazz, final Filter filter){
		Session session = getHibernateSession();
		if(session != null)
			return processCount(session, clazz, filter);
		
		
        HibernateTemplate ht = getHibernateTemplate();
        Object result = ht.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                return processCount(session, clazz, filter);
            }
        });
        
        return (Integer)result;
	}
	
	/**
	 * �����������hql������������ݼ�¼����
	 * @param hql  HQL���
	 * @return ���ؼ�¼����
	 */
	protected int getHQLObjectCount(String hql){
		return getHQLObjectCount(hql, null);
	}
	
	/**
	 * @param hql
	 * @param filter
	 * @return
	 */
	private int getHQLObjectCount(final String hql, final Filter filter){
		Session session = getHibernateSession();
		if(session != null)
			return processCount(session, hql, filter);
		
        HibernateTemplate ht = getHibernateTemplate();		
        Object result = ht.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                return processCount(session, hql, filter);
            }
        });
        return (Integer)result;
	}
	
	
	int processCount(Session session, Object obj, Filter filter){
		Query[] querys = null;
		if(obj instanceof Class){ //�����Class��Ϊ�ǵ����ѯ
			Class clazz = (Class)obj;
					//����pageû���κ��ô�,ֻ��Ϊ�˱��ֵ���setupQuery�����ĸ�����			
			querys = setupQuery(session, clazz, filter, null, new PageImpl());
		}
		if(obj instanceof String){
			String hql = (String)obj; //�����String����Ϊhql
			
					//����pageû���κ��ô�,ֻ��Ϊ�˱��ֵ���setupQuery�����ĸ�����
			querys = setupQuery(session, hql, filter, null, new PageImpl());
		}
		
		return executQuery(querys);
	}
	
	int executQuery(Query[] querys){
		Query countQuery = querys[1];
		
		int count = 0;
		if( countQuery != null){
			List countResult = countQuery.list();
			
			if(countResult != null && countResult.size() != 0){
				if (countResult.size() > 1 ) 
					count = countResult.size();
				else{
					Object result = countResult.get(0);
					if (result instanceof Integer) {
						count = ((Integer)result).intValue();
					}
					if (result instanceof Long) {
						count = ((Long) result).intValue();
					}
				}
			}
		}
		return count;
	}
	
    /**
     * ���ݸ�����HQL�������ݿ��з�����HQL��һ�µĽ����
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������HQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getHQLObjects(String)</code>������<code>getHQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getHQLObjects(String)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param hql HQL���,ע���HQL������select������ֻ��һ��ʵ��Ľ�����б�
     * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see #getHQLObjects(String, String, Class)
	 */
    protected List getHQLObjects(String hql){
    	return this.getHQLObjects(hql, null, null, null, null, null);
    }
    
    /**
     * ���ݸ�����HQL�������ݿ��з�����HQL��һ�µĽ����,�������page��Ϊnull�������page��
 	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�
      * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
      * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������HQL��˵��ֻ��������HiUser����Ϣ,
      * Ҳ����˵��ֻ����һ��ʵ������
      * @param hql  HQL���,ע���HQL������select������ֻ��һ��ʵ��Ľ�����б�
      * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
      * @return ��ָ�����Ͷ����<code>List</code>����
      * @see #getHQLObjects(String, String, Class,Page)
      */
     protected List getHQLObjects(String hql, Page page){
     	return this.getHQLObjects(hql, null, null, null, null, page);
     }
         
	/**
	 * ���ݸ�����HQL��估�������б�����ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��HQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * <p>���HQLƴд�д���������ݿ��hbm�ļ���Ӧ����ȷ������׳�
	 * <code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣
     * <p>ע��:<code>getHQLObjects(String)</code>������<code>getHQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getHQLObjects(String)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */    
    protected List getHQLObjects(String hql, String propertyNames, Class clazz){
    	return this.getHQLObjects(hql, propertyNames, clazz, null, null);
    }


    /**
	 * ���ݸ�����HQL��估�������б�����ݿ��з���ָ�����ͽ����,�������page��Ϊnull�������page��
 	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�
	 * <p>Ŀ�ģ�ͨ��HQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * <p>���HQLƴд�д���������ݿ��hbm�ļ���Ӧ����ȷ������׳�
	 * <code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣 
     * <p>ע��:<code>getHQLObjects(String,Page)</code>������<code>getHQLObjects(String, String, Class,Page)</code>
     * ����Ҫ��������,<code>getHQLObjects(String,Page)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
     * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
     * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
     * @return ����ָ�����Ͷ����<code>List</code>����
     */
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Page page){
    	return this.getHQLObjects(hql, propertyNames, clazz, null, null, page);
    }
    
    /**
	 * ���ݸ�����HQL��估�����������ݿ��з�����HQL��һ�µĽ����
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������HQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getHQLObjects(String, filer)</code>������<code>getHQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getHQLObjects(String)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param hql HQL���,ע���HQL������select������ֻ��һ��ʵ��Ľ�����б�
	 * @param filter ����ѯ�Ĺ�����
     * @return ����HQL����������һ�µĶ���<code>List</code>����
     * @see #getHQLObjects(String, String, Class, Filter)
     */
    protected List getHQLObjects(String hql, Filter filter){
    	return getHQLObjects(hql, null, null, filter, null);
    }
    
	/**
	 * ���ݸ�����HQL��估�������б������������ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��HQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * <p>���HQLƴд�д���������ݿ��hbm�ļ���Ӧ����ȷ,��<code>Filter</code>����Ϣ�����ݿ�����hibernate
	 * ������Ϣ��Ӧ��������׳�<code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣
	 * 
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */  
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter){
    	return getHQLObjects(hql, propertyNames, clazz, filter, null);
    }

    /**
	 * ���ݸ�����HQL��估�������������������ݿ��з�����HQL��һ�µĽ����
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������HQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getHQLObjects(String, filer)</code>������<code>getHQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getHQLObjects(String)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param hql HQL���,ע���HQL������select������ֻ��һ��ʵ��Ľ�����б�
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
     * @return ����HQL����������һ�µĶ���<code>List</code>����
     * @see #getHQLObjects(String, String, Class, Filter, Sorter)
     */    
    protected List getHQLObjects(String hql, Filter filter, Sorter sorter){
    	return getHQLObjects(hql, null, null, filter, sorter, null);
    }    
    
	/**
	 * ���ݸ�����HQL��估�������б��������������������ݿ��з���ָ�����ͽ����
	 * <p>Ŀ�ģ�ͨ��HQL����ѯ�����װΪָ���Ķ��󼯺ϣ���װ�Ĺ���Ϊ��ѯ������������������˳��һһ����Ӧ
	 * <p>���HQLƴд�д���������ݿ��hbm�ļ���Ӧ����ȷ,��<code>Filter</code>��<code>Sorter</code>
	 * ��Ϣ�����ݿ�����hibernate������Ϣ��Ӧ��������׳�	<code>org.hibernate.exeption.SQLGrammarException</code>�쳣��������hibernate��
	 * �쳣���ᱻSpring��װΪ<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * �쳣
	 * 
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter, Sorter sorter){
    	return getHQLObjects(hql, propertyNames, clazz, filter, sorter, null);
    }
    
    /**
	 * ���ݸ�����HQL��估�������������������ݿ��з�����HQL��һ�µĽ����,�������page��Ϊnull�������page��
	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�<p>����ݹ�����������������50����¼��ÿҳ10������ǰҪ��ѯ
	 * ���ǵ���ҳ����ô���ص�<code>List</code>����ֻ��10����¼��������������ǰ��21������30����¼
	 * <p>ע�⣺����page�Ĳ���ֻ����ǰ����ʾ�б�ҳ����ʹ�ã����Ƽ����÷�������ҵ���߼����ϣ���Ϊ����
	 * �п��ܻ���ʧ�����������������ݡ����ں������ݵĲ�ѯ��ò�Ҫ��ORM��Щ�������Ŀ���Ƽ��ͳ��JDBC��
	 * �洢�������ϵķ�ʽʵ�֣���Ч����Ҫ��ʹ���м��Ŀ��ܶ�
     * <p>����:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * ͨ�����ӿɳ�������Ա�벿����Ȼ�Ѿ��趨��ϵ,����Ҳ�����˲��ŵĹ�������,������HQL��˵��ֻ��������HiUser����Ϣ,
     * Ҳ����˵��ֻ����һ��ʵ������
     * <p>ע��:<code>getHQLObjects(String, filer)</code>������<code>getHQLObjects(String, String, Class)</code>
     * ����Ҫ��������,<code>getHQLObjects(String)</code>������HQL�������ص�һ��ʵ������,���Һ������Ƿ���
     * ���ʵ�����͵������ٸ��ݸ�����Class��װ�������Class����һ�µ�POJO���󼯺�
     * @param hql HQL���,ע���HQL������select������ֻ��һ��ʵ��Ľ�����б�
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
     * @return ����HQL����������һ�µĶ���<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
     * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
     */  
    protected List getHQLObjects(final String hql,  final Filter filter, final Sorter sorter, final Page page){
    	return getHQLObjects(hql, null, null, filter, sorter, null);
    }
    
	/**
	 * ���ݸ�����HQL��估�������б��������������������ݿ��з���ָ����Ӧ�Ľ��,�������page��Ϊnull�������page��
	 * ��ǰҪ���ؼ�¼������ָ�����ȵļ��ϡ�<p>����ݹ�����������������50����¼��ÿҳ10������ǰҪ��ѯ
	 * ���ǵ���ҳ����ô���ص�<code>List</code>����ֻ��10����¼��������������ǰ��21������30����¼
	 * <p>ע�⣺����page�Ĳ���ֻ����ǰ����ʾ�б�ҳ����ʹ�ã����Ƽ����÷�������ҵ���߼����ϣ���Ϊ����
	 * �п��ܻ���ʧ�����������������ݡ����ں������ݵĲ�ѯ��ò�Ҫ��ORM��Щ�������Ŀ���Ƽ��ͳ��JDBC��
	 * �洢�������ϵķ�ʽʵ�֣���Ч����Ҫ��ʹ���м��Ŀ��ܶ�
	 * 
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param filter ����ѯ�Ĺ�����
	 * @param soter ����ѯ��������
	 * @param page ����ѯ��ҳ����Ϣ���ò����ڱ������ڵ�������Ҫ�ǿ��Ʒ��ؼ��ϵĳ����뷵�ؼ�¼����ֹλ��
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 */
    protected List getHQLObjects(final String hql, String propertyNames, Class clazz, final Filter filter, final Sorter sorter, final Page page){
    	
    	List result = new ArrayList();
    	if(hql == null || hql.trim().equals(""))
    		return result;
    	
    	List hqlResult;
		Session session = getHibernateSession();
		if(session != null){
			hqlResult = processFind(session, hql, filter, sorter, page);
		}
		else{
			HibernateTemplate ht = getHibernateTemplate();
			hqlResult = ht.executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
					return processFind(session, hql, filter, sorter, page);
				}
			});
		}
        
        if(propertyNames == null)
        	return hqlResult;
        
        //��hql���صĽ������װΪ���󼯺�
        String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
        for (Iterator iter = hqlResult.iterator(); iter.hasNext();) {
        	Object bean = null;
			try {
				bean = clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			Object obj = iter.next();
			Object[] valueArray = null;
			if(obj.getClass().isArray()){
				valueArray = (Object[])obj;
			}
			else{
				valueArray = new Object[1];
				valueArray[0] = obj;
			}
			
			for (int i = 0; i < valueArray.length; i++) {
				BeanUtil.ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);		//ͨ��OGNL�����Ͷ�����㸳ֵ
			}
			result.add(bean);
		}
        
    	return result;
    }
    
    
	List processFind(Session session, String hql, Filter filter, Sorter sorter, Page page){
		Query[] querys = setupQuery(session, hql, filter, sorter, page);
		return executQuery(querys, page);
	}
    
	private Query[] setupQuery(Session session, String hql, Filter filter, Sorter sorter, Page page){
		
		StringBuffer mainSb = new StringBuffer(); //��HQL���
		StringBuffer countSb = new StringBuffer(); //ͳ�Ƽ�¼����HQL���
		String orderSt = "";					//������ַ���
		
		mainSb.append(hql);
		
		countSb.append("select count(*) ");
		if(!StringUtils.trimLeft(hql).startsWith("from"))
			countSb.append("from ");
		
		/*HQL�Ĺ��˲���*/
		if(filter != null && filter.getConditions().size() > 0){
			
			if(StringUtils.isInclude(hql, "where"))
				mainSb.append(" and ");
			else
				mainSb.append(" where ");
			
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			String aliasName = "";
			if(filter != null && filter.getAliasName() != null && !filter.getAliasName().trim().equals(""))
				aliasName = filter.getAliasName();
			
			if(filterGroup.size() < 2) //���filter����ֻ�����Լ���û��ͨ��addFilter�������ӵ�
				setupConditions(mainSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(mainSb, filtergroup, aliasName, i);
					mainSb.append(") ");
				}
			}

		}
		
		/*HQL�����򲿷�*/
		if(sorter != null && !sorter.getSorts().isEmpty()){
			orderSt = " order by "; 
			
			if(filter != null && filter.getAliasName() != null)
				orderSt+=filter.getAliasName() + "." ;
			
			orderSt+=sorter.toString();
		}
		
		
		/*����ͳ�Ʒ��ز�ѯ��¼������Ҫ��ѯ��Queryʵ��*/
		Query countQuery = null, query = null;
		String mainString = mainSb.toString();
		if (page != null) {
			String countString = mainString.toString();
			if(!StringUtils.trimLeft(hql).startsWith("from"))
				countString = mainString.substring(mainString.indexOf("from") + 4);
			countQuery = session.createQuery(countSb.append(countString).toString());
		}
		query = session.createQuery(mainString + orderSt);
		
		/*���������������ռλ���������Ӧ��ֵ*/
		if(filter != null  && filter.getConditions().size() > 0){
			IntWrapper mainIntWrapper = new IntWrapper();	//����һ�����㿪ʼ�ļ���������
			IntWrapper countIntWrapper = new IntWrapper();	//����һ�����㿪ʼ�ļ���������
			List<FilterBean> filterBeans = filter.getConditions();
			for (Iterator i = filterBeans.iterator(); i.hasNext();) {
				FilterBean filterBean = (FilterBean) i.next();
				String operater = filterBean.getOperater();
				
				/*�����ֵ���������ַ��������Ҳ�������like����ֵ�����˼Ӱٷֺţ�%��*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//�ж�like�Ŀ��Ʒ�
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
						val = "%" + val;
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
						val =  val + "%";
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
						val =  "%" + val + "%";
					filterBean.setValue(val);
				}
				
				setParameter(query, mainIntWrapper, filterBean.getValue());  //ΪHQL��Query����,��������ռλ����ֵ
				if(page != null)
					setParameter(countQuery,countIntWrapper, filterBean.getValue());
			}
		}
		
		Query[] querys = {query, countQuery};
		return querys;
	}

	/**
	 * ���ݸ�����HQL�������ݿ��з�����HQL��һ�µĽ����
	 * <p>����page��pageInfo����������pageInfo�Ƕ�filter/sorter/page����һ���װ
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param clazz ����װ������
	 * @param pageInfo ����ѯ��ҳ����Ϣ
     * @return ����ָ�����Ͷ����<code>List</code>����
     * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, PageInfo)
	 * @see #getHQLObjects(String, String, Class, PageInfo)
	 */	
	protected List getHQLObjects(String hql, PageInfo pageInfo){
		return getHQLObjects(hql, null, null, pageInfo);
	}
	
	/**
	 * ���ݸ�����HQL��估�������б�����ݿ��з���ָ�����ͽ������������Ĳ���ԭ����<code>getObjects(clazz, page)</code>
	 * ������ͬ
	 * <p>����page��pageInfo����������pageInfo�Ƕ�filter/sorter/page����һ���װ
	 * @param hql HQL���,ע���HQL������select��Ҫ��ѯ�Ľ�����б�
	 * @param propertyNames �������б���ַ���,�Զ��ŷָ�.���ڶ���������������ͨ��.(���)�����á�
	 * ע�⣺�������Ĺ�ϵ��������͵�������һ��
	 * @param clazz ����װ������
	 * @param pageInfo ����ѯ��ҳ����Ϣ
	 * @return ����ָ�����Ͷ����<code>List</code>����
	 * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, PageInfo)
	 */	
	protected List getHQLObjects(String hql, String propertyNames, Class clazz, PageInfo pageInfo){
		if(pageInfo == null)
			return new ArrayList();
		
		Filter filter = null;
		Sorter sorter = null;
		Page page = null;
		filter = pageInfo.getFilter();
		sorter = pageInfo.getSorter();
		page = pageInfo.getPage();
		return getHQLObjects(hql, propertyNames, clazz, filter, sorter, page);
    }
 
	protected Session getHibernateSession(){
		return null;
	}
	
    /**
     * ��������װ��
     */
    private class IntWrapper{
    	int i = 0;
    	int getInt(){
    		return i;
    	}
    	
    	void IntAddOne(){
    		i++;
    	}
    }

	public HiDialect getDialect() {
		
		SessionFactoryImplementor sessionFactory;
		if(getHibernateSession() == null)
			sessionFactory = (SessionFactoryImplementor)getHibernateTemplate().getSessionFactory();
		else
			sessionFactory = (SessionFactoryImplementor)getHibernateSession().getSessionFactory();
		
		if(sessionFactory.getDialect() instanceof HibernateHiDialect) {
			return (HibernateHiDialect)sessionFactory.getDialect();
		}
		return null;
	}
}

