package org.hi.framework.dao;

import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;

/**
 * 方言接口用以实现不同RDBMS的SQL语句的声明,其子接口及子孙类分别对应不同的ORM框架引擎及不同的关系型数据库管理系统
 * 方言的思想请参考<code>Hibernate</code>的方言
 * @author 张昊
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
	 * 通过给定的过滤器（filter）与页面(page)重拼hql语言,以限定在数据库查询时满足条件
	 * 的最大记录数
	 * <p>注意：不同数据库系统对最大限记录数的处理方式不同,而ORM框架在这方面没有提供过多或较为全面的
	 * 解决方案,因此在实现该方法时要依数据库系统的差异及ORM框架不同方言的实现方式而定
	 * @param query 查询语句
	 * @param filter 过滤器
	 * @param page 页面信息
	 * @return 返回带有不同数据库系统对最大限记录数关键字的查询语句,如SQLServer:top;MySQL:limit;Oracle:rownum等
	 * 这种差异由子类方法实现之
	 */
	String getMaxRecode(Object query, Filter filter, Page page);
	
	/**
	 * 返回所对应方言类的数据库类型
	 * @return 返回值为MSSQL/SQLSERVER/ORACLE
	 */
	String getDataBaseType();
	
	/**
	 * 获得与数据库对应的过滤器的SQL语句
	 * @param filter 过滤器
	 * @return 返回与数据库的SQL字符串
	 */
	String getFilterSQL(Filter filter, Manager manager);
}
