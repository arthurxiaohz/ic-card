package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

/** 
 *  Data Access Object (Dao) interface. 该接口目的用于数据访问，不参与有任何的业务逻辑.<p>
 *  <a href="http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html">DAO的要关资料<i></i></a></p>
 *  这个接口主要提供了与数据库最通用的原始操作，并且做为一个标识接口其所有子孙类是一个DAO
 * 	<p>其主要功能：
 * 	实现对数据库标准的CRUD [Create,Retrieve,Update,Delete]操作,其中提供最多的功能性方法是查询
 * 	查询主要分为Filter(过滤器),Sorter（排序器）,Page(页面)。
 * <p>注意：本接口中所有方法在查询时不支持对数据的分组、左右外连接、聚集等操作，如果要实现上述特殊操作
 * 可以在该具体子类中针对不同的ORM框架手动编码实现之
 * <p>对于海量数据的查询最好不要用ORM这些框架性项目，推荐最传统的JDBC与存储过程相结合的方式实现，在效率上要比使用中间层的框快很多 
 *  
 *  @author 张昊
 *  @since 2006-11-13
 *  @see org.hi.framework.dao.Filter
 *  @see org.hi.framework.dao.Sorter
 */
public interface DAO {

	/**
	 * 保存或更新给定的对象
	 * <p>对于数据库来说具体是保存(insert)还是更新(update)操作是由ORM层控制，主要的判断条件是主键ID值
	 * 在数据库中是否存在，如果不存在则是保存，否则则为更新操作
	 * @param obj 要保存或更新到数据库中的对象
	 * @param mode 待保存对象的来源模式
	 */
	public void saveObject(Object obj);

	/**
	 * 将给定的对象从数据库中删除
	 * <p>如果该对象对应的数据库表中有子表将会一并删除
	 * 如果在数据库中没有找到指定的记录Spring将抛出<code>DataAccessException</code>异常
	 * 
	 * @param clazz 对应于数据库表的POJO类型
	 * @param id 对应于数据库表中主键ID的一个值
	 * @see DataAccessException
	 */
	public void removeObjectById(Class clazz, Serializable id);
	
	/**
	 * 将给定的对象从数据库中删除
	 * <p>如果该对象对应的数据库表中有子表将会一并删除
	 * 如果在数据库中没有找到指定的记录Spring将抛出<code>DataAccessException</code>异常
	 * 
	 * @param clazz 对应于数据库表的POJO类型
	 * @param id 对应于数据库表中主键ID的一个值
	 * @see DataAccessException
	 */
	public void removeObject(Object obj);
	

	/**
	 * 根据给定的类型及数据库表中对应的主键ID值返回一个POJO对象
	 * <p>如果通过给定的信息没有找到记录，即返回值为<code>null</code>则在运行时
	 * 抛出<code>ObjectRetrievalFailureException</code>异常,该异常会被Spring所捕
	 * 获并做统一处理
	 * 
	 * 注意：该方法不支持复合主键，在本系统框架中也不准备支持该复合主键查询的功能。因为大多数复合主键的设计
	 * 都是历史遗留问题，本系统框架不考虑对其它系统在数据层与业务层做全面整合的支持
	 * 
	 * @param clazz 对应于数据库表的POJO类型
	 * @param id 对应于数据库表中主键ID的一个值
	 * @return 返回一个POJO对象
	 */
	public Object getObjectById(Class clazz, Serializable id);
	
	/**
	 * 根据给定的类型及过滤器返回一个POJO对象,要求过滤器所设置的数据库字段必须是唯一字段
	 * 如果有多于一条的记录被返回则会抛出异常
	 * <p>如果通过给定的信息没有找到记录，即返回值为<code>null</code>则在运行时
	 * 抛出<code>ObjectRetrievalFailureException</code>异常,该异常会被Spring所捕
	 * 获并做统一处理
	 * @param clazz 对应于数据库表的POJO类型
	 * @param filter 要求对应数据库记录唯一,过滤器
	 * @return 返回一个POJO对象
	 */
	public Object getUniqueObject(Class clazz, Filter filter);
	
	/** 
	 *  根据给定的类型返回POJO对象的List.
	 *  <p>一般来说，将返回所给定类型对应数据库表中的所有记录，并由ORM将其转换为POJO对象
	 *  
	 *  @param clazz 对应于数据库表的POJO类型
	 *  @return 由ORM封装后的POJO集合
	 */
	public List<Object> getObjects(Class clazz);
	
	/**
	 * 根据给定的过滤器从数据库中返回指定对应的结果
	 * <p>如果<code>Filter</code>的信息与数据库表或是hibernate配置信息对应错误，则会抛出
	 * <code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常
	 * 
	 * @param clazz 对应于数据库表的POJO类型
	 * @param filter 待查询的过滤器
	 * @return 返回指定类型的POJO对象的<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, Filter filter);
	
	/**
	 * 根据给定的过滤器与批序器从数据库中返回指定对应的结果
	 * <p>如果<code>Filter</code>或<code>Sorter</code>信息与数据库表或是hibernate配置信息对应错误，则会抛出
	 * <code>org.hibernate.exeption.SQLGrammarException</code>异常，所有有hibernate的
	 * 异常都会被Spring包装为<code>org.springframework.orm.hibernate3.HibernateJdbcException</code>
	 * 异常
	 * @param clazz 对应于数据库表的POJO类型
	 * @param filter 待查询的过滤器
	 * @param soter 待查询的排序器
	 * @return 返回指定类型的POJO对象的<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, Filter filter, Sorter soter);
	
	/**
	 * 根据给定的过滤器与批序器从数据库中返回指定对应的结果,并且如果page不为null，则根据page的
	 * 当前要返回记录数返回指定长度的集合。<p>如根据过滤器满足条件的有50条记录，每页10条，当前要查询
	 * 的是第三页，那么返回的<code>List</code>集合只有10条记录且是满足条件的前第21条到第30条记录
	 * <p>注意：带有page的参数只能在前端显示列表页面中使用，不推荐将该方法用于业务逻辑层上，因为这样
	 * 有可能会损失部分满足条件的数据。对于海量数据的查询最好不要用ORM这些框架性项目，推荐最传统的JDBC与
	 * 存储过程相结合的方式实现，在效率上要比使用中间层的框快很多
	 * @param clazz 对应于数据库表的POJO类型
	 * @param filter 待查询的过滤器
	 * @param sorter 待查询的排序器
	 * @param page 待查询的页面信息，该参数在本方法内的作用主要是控制返回集合的长度与返回记录的启止位置
	 * @return 返回指定类型的POJO对象的<code>List</code>集合
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * 
	 */
	public List<Object> getObjects(Class clazz, Filter filter, Sorter sorter, Page page);
	
	/**
	 * 根据给定的页面信息从数据库中返回指定对应的结果，其基本的操作原理与<code>getObjects(clazz, filter, sorter, page)</code>
	 * 完全相同
	 * <p>参数page与pageInfo的区别在于pageInfo是对filter/sorter/page的又一层封装
	 * @param clazz 对应于数据库表的POJO类型
	 * @param pageInfo 待查询的页面信息
	 * @return 返回指定类型的POJO对象的<code>List</code>集合
	 * @see org.hi.framework.paging.PageInfo
	 * @see org.hi.framework.dao.Filter
	 * @see org.hi.framework.dao.Sorter
	 * @ses org.hi.framework.paging.Page
	 * @see #getObjects(Class, Filter, Sorter, Page)
	 */
	public List<Object> getObjects(Class clazz, PageInfo pageInfo);
	
	/**
	 * 根据类型得到数据库表中总的记录个数
	 * @param clazz 对应于数据库表的POJO类型
	 * @return 返回记录数量
	 */
	public int getObjectCount(Class clazz);
	
	/**
	 * 根据类型与过滤器得到满足条件记录个数
	 * @param clazz对应于数据库表的POJO类型
	 * @param filter 过滤器
	 * @return 返回记录数量
	 */
	public int getObjectCount(Class clazz, Filter filter);
	
	
	public HiDialect getDialect();

}