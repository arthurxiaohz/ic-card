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
 * 本类是接口<code>DAO</code>多个实现类中的一个，是对ORM工具hibernate的DAO的实现。
 * <p> 本类继承Spring的<code>HibernateDaoSupport</code>而后者是DAO实现的服务基类，它带有
 * 一个SessionFactory引用并且它提供一个<code>HibernateTemplate</code>实例 
 * 对于<code>HibernateTemplate</code>作用是：用于DAO中的数据访问，无缝地在后台处理Hibernate
 * Session.自动参与Spring驱动的和EJB驱动的事务。将可控式<code>HibernateException</code>转换成Spring提供
 * 的通用<code>DataAccessException</code>层次结构
 * <p>由于Hibernate默认的对于查询采用一级缓冲，这样就导致如果有n条记录那么就要与数据交互n次，每次
 * 只查询出一条记录。而且为了统计返回满足条件结果的记录数由于数据库间的差异性，最多的要在一个select语
 * 句有三层子查询，这样的效率可想而知。所以在查询海量数据时最好不要采用Hibernate来处理，对于一次查询
 * 要返回大数据量的操作Hibernate不是一个最佳的解决方案
 * @author 张昊
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
	
	/**批量添加或者修改coll集合中的对象,如果是脱管对象就update,如果是临时对象就save。
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
	

	/**根据给定的类型和过滤器返回一个POJO对象
	 * @param session
	 * @param clazz
	 * @param filter
	 * @return
	 */
	Object processUnique(Session session, Class clazz, Filter filter) {
		Query[] queries = setupQuery(session, clazz, filter, null, null);
		Query query = queries[0];//0表示是返回查询的sql语句
		long startTime = System.currentTimeMillis();
		Object result = query.uniqueResult();				//执行HQL查询
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
	 * 该方法完成如下功能：1.根据给定的过滤器与排序器构建出hibernate的Query对象 2.设置查询返回
	 * 的记录个数与启止位置 3.执行Query的list()方法返回待查询的结果集 4.返回该结果集
	 * 注意：该方法会返回满足查询条件的记录数，并将该值放到<code>Page</code>的totalRecords属性中，
	 * 如果参数page不为空的话
	 * @param session Hibernate的Session,该对象实例由Spring框架提供
	 * @param clazz 对应于数据库表的POJO类型
	 * @param filter 待查询的过滤器
	 * @param sorter 待查询的排序器
	 * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
	 * @return 返回指定类型的POJO对象的<code>List</code>集合
	 */
	List processFind(Session session, Class clazz, Filter filter, Sorter sorter, Page page){
		Query[] querys = setupQuery(session, clazz, filter, sorter, page);
		return executQuery(querys, page);
	}

	/**
	 * 逐个执行给定的Query[],并设置page信息
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
				
				//如果真实记录数最大限记录数就取最大限记录数
				count = page.getMaxRecords() != 0 && count > page.getMaxRecords() ? page.getMaxRecords() : count;
					
				page.setTotalRecords(count);		//设置查询结果的总记录数
				
				int totoalPage = 0;
				totoalPage= count%page.getPageSize() > 0 ? count/page.getPageSize() + 1  : count/page.getPageSize();
				page.setTotalPage(totoalPage);						//设置查询结果的总页数
			}
			
			query.setFirstResult(page.getStartRowPosition()); 	//设置返回的第一条记录的位置
			
			if(page.getMaxRecords() != 0 && (page.getStartRowPosition() + page.getPageSize()) > page.getMaxRecords())
				query.setMaxResults(page.getMaxRecords() - page.getStartRowPosition());
			else
				query.setMaxResults(page.getPageSize());			//设置返回的记录数
		}
		
		long startTime = System.currentTimeMillis();
		List result = query.list();								//执行HQL查询
		long endTime = System.currentTimeMillis();
		if(log.isDebugEnabled()){
			log.debug("Query string: " + query.getQueryString() + "\n\t use:" 
				+ (endTime - startTime) + "ms");
		}
		return result;
	}	
	
	/**返回两个HQL语句，一个是需要查询的语句，另一个是需要统计的查询语句
	 * @param session
	 * @param clazz
	 * @param filter
	 * @param sorter
	 * @param page
	 * @return
	 */
	private Query[] setupQuery(Session session, Class clazz, Filter filter, 
			Sorter sorter, Page page){
		
		StringBuffer mainSb = new StringBuffer(); //主HQL语句
		StringBuffer countSb = new StringBuffer(); //统计记录数的HQL语句
		String orderSt = "";					//排序的字符串
		
		String aliasName = clazz.getSimpleName().toLowerCase() + "_1"; //filter无别名，缺省
		if(filter != null && filter.getAliasName() !=null && !filter.getAliasName().trim().equals(""))
			aliasName = filter.getAliasName();
			
		countSb.append("select count(*) ");
		mainSb.append("from ").append(clazz.getName()).append(" " + aliasName + " ");
		
		/*HQL的过滤部分*/
		if(filter != null && filter.getConditions().size() > 0){
			mainSb.append(" where ");
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //如果filter组中只有它自己，没有通过addFilter方法连接的
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
		
		/*为count加最大限记录数，提升大数据量的检索速度*/
		if(sessionFactory.getDialect() instanceof HibernateHiDialect) {
			HibernateHiDialect dialect = (HibernateHiDialect)sessionFactory.getDialect();
			countHql = dialect.getMaxRecode(countHql, filter, page);
		}
		
		/*HQL的排序部分*/
		if(sorter != null && !sorter.getSorts().isEmpty())
			orderSt = " order by " + aliasName + "." +sorter.toString();
		
		/*创建统计返回查询记录数与需要查询的Query实例*/
		Query countQuery = null, query = null;
		if (page != null) 
			countQuery = session.createQuery(countHql);
		query = session.createQuery(mainSb.append(orderSt).toString());
		
		/*向过滤条件的引用占位符中添加相应的值*/
		if(filter != null  && filter.getConditions().size() > 0){
			IntWrapper mainIntWrapper = new IntWrapper();	//创建一个以零开始的计数器对象
			IntWrapper countIntWrapper = new IntWrapper();	//创建一个以零开始的计数器对象
			List filterBeans = filter.getConditions();
			for (Iterator i = filterBeans.iterator(); i.hasNext();) {
				FilterBean filterBean = (FilterBean) i.next();
				
				if(filterBean.getValue() == null)
					continue;
				
				String operater = filterBean.getOperater();
				
				/*如果是值的类型是字符串，并且操作符是like则在值的两端加百分号（%）*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//判断like的控制符
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
				
				setParameter(query, mainIntWrapper, filterBean.getValue());  //为HQL的Query对象,设置引用占位符的值
				if(page != null)
					setParameter(countQuery,countIntWrapper, filterBean.getValue());
			}
		}
		
		Query[] querys = {query, countQuery};
		return querys;
	}
	
	private void setupConditions(StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*为HQL条件部分设置引用占位符*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //如果是第一个条件组,则在最前面加个括号
				mainSb.append("( ");
			
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //如果不是第一个条件组,则在关系符后面加括号
				mainSb.append(filterBean.getRelations()).append(" ( ");
			
			if(i > 0 )
				mainSb.append(filterBean.getRelations()).append(" ");			//添加两个条件之间的关系符
			
			if(aliasName != null && !aliasName.trim().equals(""))
				mainSb.append(aliasName + ".");

			mainSb.append(filterBean.getFieldName()).append(" ");				//添加查询的字段名
			
			
			
			Object val = filterBean.getValue();
			if(val == null){
				if (operater.equals(Filter.OPERATOR_EQ))
					mainSb.append("IS NULL ");
				else
					mainSb.append("IS NOT NULL ");
				continue;
			}
			
			mainSb.append(operater).append(" "); 				//添加操作符

			if(filterBean.isNot())					
				mainSb.append("NOT ");							//添加NOT操作符
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	如果操作符是IN，则每一个值对应一个引用占位符
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
				mainSb.append("? ");								//以坐标位置作为引用占位符
			
		}
	}
	
    /**
     * 判断value的类型是否是一个集合,并根据value的类型累加计数器
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
	 * 返回满足给定hql语句条件的数据记录个数
	 * @param hql  HQL语句
	 * @return 返回记录个数
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
		if(obj instanceof Class){ //如果是Class认为是单表查询
			Class clazz = (Class)obj;
					//参数page没有任何用处,只是为了保持调用setupQuery方法的复用性			
			querys = setupQuery(session, clazz, filter, null, new PageImpl());
		}
		if(obj instanceof String){
			String hql = (String)obj; //如果是String则认为hql
			
					//参数page没有任何用处,只是为了保持调用setupQuery方法的复用性
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
     * 根据给定的HQL语句从数据库中返回与HQL相一致的结果集
     * <p>例如:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * 通过例子可出看到人员与部门虽然已经设定关系,而且也加入了部门的过滤条件,但对于HQL来说它只返回所有HiUser的信息,
     * 也就是说它只返回一个实体类型
     * <p>注意:<code>getHQLObjects(String)</code>方法与<code>getHQLObjects(String, String, Class)</code>
     * 的主要区别在于,<code>getHQLObjects(String)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
     * @param hql HQL语句,注意该HQL必须有select中有且只有一个实体的结果集列表
     * @return 返回指定类型对象的<code>List</code>集合
	 * @see #getHQLObjects(String, String, Class)
	 */
    protected List getHQLObjects(String hql){
    	return this.getHQLObjects(hql, null, null, null, null, null);
    }
    
    /**
     * 根据给定的HQL语句从数据库中返回与HQL相一致的结果集,并且如果page不为null，则根据page的
 	 * 当前要返回记录数返回指定长度的集合。
      * <p>例如:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
      * 通过例子可出看到人员与部门虽然已经设定关系,而且也加入了部门的过滤条件,但对于HQL来说它只返回所有HiUser的信息,
      * 也就是说它只返回一个实体类型
      * @param hql  HQL语句,注意该HQL必须有select中有且只有一个实体的结果集列表
      * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
      * @return 回指定类型对象的<code>List</code>集合
      * @see #getHQLObjects(String, String, Class,Page)
      */
     protected List getHQLObjects(String hql, Page page){
     	return this.getHQLObjects(hql, null, null, null, null, page);
     }
         
	/**
	 * 根据给定的HQL语句及属性名列表从数据库中返回指定类型结果集
	 * <p>目的：通过HQL将查询结果封装为指定的对象集合，封装的规则为查询结果集与给定的属性名顺序一一按对应
	 * <p>如果HQL拼写有错误或与数据库表及hbm文件对应不正确，则会抛出
	 * <code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常
     * <p>注意:<code>getHQLObjects(String)</code>方法与<code>getHQLObjects(String, String, Class)</code>
     * 的主要区别在于,<code>getHQLObjects(String)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
	 * @return 返回指定类型对象的<code>List</code>集合
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */    
    protected List getHQLObjects(String hql, String propertyNames, Class clazz){
    	return this.getHQLObjects(hql, propertyNames, clazz, null, null);
    }


    /**
	 * 根据给定的HQL语句及属性名列表从数据库中返回指定类型结果集,并且如果page不为null，则根据page的
 	 * 当前要返回记录数返回指定长度的集合。
	 * <p>目的：通过HQL将查询结果封装为指定的对象集合，封装的规则为查询结果集与给定的属性名顺序一一按对应
	 * <p>如果HQL拼写有错误或与数据库表及hbm文件对应不正确，则会抛出
	 * <code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常 
     * <p>注意:<code>getHQLObjects(String,Page)</code>方法与<code>getHQLObjects(String, String, Class,Page)</code>
     * 的主要区别在于,<code>getHQLObjects(String,Page)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
     * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
     * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
     * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
     * @return 返回指定类型对象的<code>List</code>集合
     */
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Page page){
    	return this.getHQLObjects(hql, propertyNames, clazz, null, null, page);
    }
    
    /**
	 * 根据给定的HQL语句及过滤器从数据库中返回与HQL相一致的结果集
     * <p>例如:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * 通过例子可出看到人员与部门虽然已经设定关系,而且也加入了部门的过滤条件,但对于HQL来说它只返回所有HiUser的信息,
     * 也就是说它只返回一个实体类型
     * <p>注意:<code>getHQLObjects(String, filer)</code>方法与<code>getHQLObjects(String, String, Class)</code>
     * 的主要区别在于,<code>getHQLObjects(String)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
     * @param hql HQL语句,注意该HQL必须有select中有且只有一个实体的结果集列表
	 * @param filter 待查询的过滤器
     * @return 返回HQL类型类型相一致的对象<code>List</code>集合
     * @see #getHQLObjects(String, String, Class, Filter)
     */
    protected List getHQLObjects(String hql, Filter filter){
    	return getHQLObjects(hql, null, null, filter, null);
    }
    
	/**
	 * 根据给定的HQL语句及属性名列表及过滤器从数据库中返回指定类型结果集
	 * <p>目的：通过HQL将查询结果封装为指定的对象集合，封装的规则为查询结果集与给定的属性名顺序一一按对应
	 * <p>如果HQL拼写有错误或与数据库表及hbm文件对应不正确,或<code>Filter</code>的信息与数据库表或是hibernate
	 * 配置信息对应错误，则会抛出<code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常
	 * 
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
	 * @param filter 待查询的过滤器
	 * @return 返回指定类型对象的<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */  
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter){
    	return getHQLObjects(hql, propertyNames, clazz, filter, null);
    }

    /**
	 * 根据给定的HQL语句及过滤器与批序器从数据库中返回与HQL相一致的结果集
     * <p>例如:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * 通过例子可出看到人员与部门虽然已经设定关系,而且也加入了部门的过滤条件,但对于HQL来说它只返回所有HiUser的信息,
     * 也就是说它只返回一个实体类型
     * <p>注意:<code>getHQLObjects(String, filer)</code>方法与<code>getHQLObjects(String, String, Class)</code>
     * 的主要区别在于,<code>getHQLObjects(String)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
     * @param hql HQL语句,注意该HQL必须有select中有且只有一个实体的结果集列表
	 * @param filter 待查询的过滤器
	 * @param soter 待查询的排序器
     * @return 返回HQL类型类型相一致的对象<code>List</code>集合
     * @see #getHQLObjects(String, String, Class, Filter, Sorter)
     */    
    protected List getHQLObjects(String hql, Filter filter, Sorter sorter){
    	return getHQLObjects(hql, null, null, filter, sorter, null);
    }    
    
	/**
	 * 根据给定的HQL语句及属性名列表及过滤器与批序器从数据库中返回指定类型结果集
	 * <p>目的：通过HQL将查询结果封装为指定的对象集合，封装的规则为查询结果集与给定的属性名顺序一一按对应
	 * <p>如果HQL拼写有错误或与数据库表及hbm文件对应不正确,或<code>Filter</code>或<code>Sorter</code>
	 * 信息与数据库表或是hibernate配置信息对应错误，则会抛出	<code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常
	 * 
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
	 * @param filter 待查询的过滤器
	 * @param soter 待查询的排序器
	 * @return 返回指定类型对象的<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
	 */
    protected List getHQLObjects(String hql, String propertyNames, Class clazz, Filter filter, Sorter sorter){
    	return getHQLObjects(hql, propertyNames, clazz, filter, sorter, null);
    }
    
    /**
	 * 根据给定的HQL语句及过滤器与批序器从数据库中返回与HQL相一致的结果集,并且如果page不为null，则根据page的
	 * 当前要返回记录数返回指定长度的集合。<p>如根据过滤器满足条件的有50条记录，每页10条，当前要查询
	 * 的是第三页，那么返回的<code>List</code>集合只有10条记录且是满足条件的前第21条到第30条记录
	 * <p>注意：带有page的参数只能在前端显示列表页面中使用，不推荐将该方法用于业务逻辑层上，因为这样
	 * 有可能会损失部分满足条件的数据。对于海量数据的查询最好不要用ORM这些框架性项目，推荐最传统的JDBC与
	 * 存储过程相结合的方式实现，在效率上要比使用中间层的框快很多
     * <p>例如:select hiuser.* from HiUser hiuser, HiOrg org where org.id = hiuser.org.id and org.id = 2
     * 通过例子可出看到人员与部门虽然已经设定关系,而且也加入了部门的过滤条件,但对于HQL来说它只返回所有HiUser的信息,
     * 也就是说它只返回一个实体类型
     * <p>注意:<code>getHQLObjects(String, filer)</code>方法与<code>getHQLObjects(String, String, Class)</code>
     * 的主要区别在于,<code>getHQLObjects(String)</code>方法的HQL语句仅返回单一的实体类型,而且后者则是返回
     * 多个实体类型的属性再根据给定的Class封装出来与该Class类型一致的POJO对象集合
     * @param hql HQL语句,注意该HQL必须有select中有且只有一个实体的结果集列表
	 * @param filter 待查询的过滤器
	 * @param soter 待查询的排序器
	 * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
     * @return 返回HQL类型类型相一致的对象<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
     * @see #getHQLObjects(String, String, Class, Filter, Sorter, Page)
     */  
    protected List getHQLObjects(final String hql,  final Filter filter, final Sorter sorter, final Page page){
    	return getHQLObjects(hql, null, null, filter, sorter, null);
    }
    
	/**
	 * 根据给定的HQL语句及属性名列表及过滤器与批序器从数据库中返回指定对应的结果,并且如果page不为null，则根据page的
	 * 当前要返回记录数返回指定长度的集合。<p>如根据过滤器满足条件的有50条记录，每页10条，当前要查询
	 * 的是第三页，那么返回的<code>List</code>集合只有10条记录且是满足条件的前第21条到第30条记录
	 * <p>注意：带有page的参数只能在前端显示列表页面中使用，不推荐将该方法用于业务逻辑层上，因为这样
	 * 有可能会损失部分满足条件的数据。对于海量数据的查询最好不要用ORM这些框架性项目，推荐最传统的JDBC与
	 * 存储过程相结合的方式实现，在效率上要比使用中间层的框快很多
	 * 
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
	 * @param filter 待查询的过滤器
	 * @param soter 待查询的排序器
	 * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
	 * @return 返回指定类型对象的<code>List</code>集合
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
        
        //将hql返回的结果集封装为对象集合
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
				BeanUtil.ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);		//通过OGNL对树型对象深层赋值
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
		
		StringBuffer mainSb = new StringBuffer(); //主HQL语句
		StringBuffer countSb = new StringBuffer(); //统计记录数的HQL语句
		String orderSt = "";					//排序的字符串
		
		mainSb.append(hql);
		
		countSb.append("select count(*) ");
		if(!StringUtils.trimLeft(hql).startsWith("from"))
			countSb.append("from ");
		
		/*HQL的过滤部分*/
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
			
			if(filterGroup.size() < 2) //如果filter组中只有它自己，没有通过addFilter方法连接的
				setupConditions(mainSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(mainSb, filtergroup, aliasName, i);
					mainSb.append(") ");
				}
			}

		}
		
		/*HQL的排序部分*/
		if(sorter != null && !sorter.getSorts().isEmpty()){
			orderSt = " order by "; 
			
			if(filter != null && filter.getAliasName() != null)
				orderSt+=filter.getAliasName() + "." ;
			
			orderSt+=sorter.toString();
		}
		
		
		/*创建统计返回查询记录数与需要查询的Query实例*/
		Query countQuery = null, query = null;
		String mainString = mainSb.toString();
		if (page != null) {
			String countString = mainString.toString();
			if(!StringUtils.trimLeft(hql).startsWith("from"))
				countString = mainString.substring(mainString.indexOf("from") + 4);
			countQuery = session.createQuery(countSb.append(countString).toString());
		}
		query = session.createQuery(mainString + orderSt);
		
		/*向过滤条件的引用占位符中添加相应的值*/
		if(filter != null  && filter.getConditions().size() > 0){
			IntWrapper mainIntWrapper = new IntWrapper();	//创建一个以零开始的计数器对象
			IntWrapper countIntWrapper = new IntWrapper();	//创建一个以零开始的计数器对象
			List<FilterBean> filterBeans = filter.getConditions();
			for (Iterator i = filterBeans.iterator(); i.hasNext();) {
				FilterBean filterBean = (FilterBean) i.next();
				String operater = filterBean.getOperater();
				
				/*如果是值的类型是字符串，并且操作符是like则在值的两端加百分号（%）*/
				if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
					String val = (String)filterBean.getValue();
					//判断like的控制符
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
						val = "%" + val;
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
						val =  val + "%";
					if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
						val =  "%" + val + "%";
					filterBean.setValue(val);
				}
				
				setParameter(query, mainIntWrapper, filterBean.getValue());  //为HQL的Query对象,设置引用占位符的值
				if(page != null)
					setParameter(countQuery,countIntWrapper, filterBean.getValue());
			}
		}
		
		Query[] querys = {query, countQuery};
		return querys;
	}

	/**
	 * 根据给定的HQL语句从数据库中返回与HQL相一致的结果集
	 * <p>参数page与pageInfo的区别在于pageInfo是对filter/sorter/page的又一层封装
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param clazz 待封装的类型
	 * @param pageInfo 待查询的页面信息
     * @return 返回指定类型对象的<code>List</code>集合
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
	 * 根据给定的HQL语句及属性名列表从数据库中返回指定类型结果集，其基本的操作原理与<code>getObjects(clazz, page)</code>
	 * 基本相同
	 * <p>参数page与pageInfo的区别在于pageInfo是对filter/sorter/page的又一层封装
	 * @param hql HQL语句,注意该HQL必须有select中要查询的结果集列表
	 * @param propertyNames 属性名列表的字符串,以逗号分隔.对于对象树属性名可以通过.(点号)逐级设置。
	 * 注意：属性名的关系与给定类型的属性相一致
	 * @param clazz 待封装的类型
	 * @param pageInfo 待查询的页面信息
	 * @return 返回指定类型对象的<code>List</code>集合
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
     * 加数器包装类
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

