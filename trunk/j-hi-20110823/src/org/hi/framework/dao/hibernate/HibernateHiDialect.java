package org.hi.framework.dao.hibernate;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;

/**
 * 
 * 本接口是对hibernate方言的抽象类<code>Dialect</code>的有意补充.所有实现该接口的子类均继承与hibernate
 * 提供的<code>Dialect</code>子类相关的类实现.该接口中的所有方法均会在<code>BaseDAOHibernate</code>类中被调用
 * <p>在hibernate中方言的作用是通过对<code>Dialect</code>的不同子类实现以实现不同数据库系统(RDBMS)之
 * 间的差异性
 * 
 * @author 张昊
 * @since 2008-7-6
 * @see org.hibernate.dialect.Dialect
 * @see org.hi.framework.dao.hibernate.BaseDAOHibernate
 *
 */
public interface HibernateHiDialect extends HiDialect{
	

//	/**
//	 * 通过给定的过滤器（filter）与页面(page)重拼hql语言,以限定在数据库查询时满足条件
//	 * 的最大记录数
//	 * <p>注意：不同数据库系统对最大限记录数的处理方式不同,而hibernate在这方面没有提供过多或较为全面的
//	 * 解决方案,因此在实现该方法时要依数据库系统的差异及hibernate不同方言的实现方式而定
//	 * @param hql hibernate的hql语句
//	 * @param filter 过滤器
//	 * @param page 页面信息
//	 * @return 返回带有不同数据库系统对最大限记录数关键字的hql语句,如SQLServer:top;MySQL:limit;Oracle:rownum等
//	 * 这种差异由子类方法实现之
//	 */
//	String getMaxRecode(Object hql, Filter filter, Page page);
//	
}