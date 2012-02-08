package org.hi.framework.dao.ibatis;

import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;
import org.hi.framework.dao.HiDialect;

/**
 * 本接口是对Ibatis方言的接口的有意补充.该接口中的所有方法均会在<code>BaseDAOIbatis</code>类及ibatis的<code>SqlMapParser</code>类中被调用
 * <p>在ibatis中方言的作用是通过对<code>Dialect</code>的不同子类实现以实现不同数据库系统(RDBMS)之
 * 间的差异性
 * @author 张昊
 * @since 2009-10-13
 * @see org.hi.framework.dao.HiDialect
 * @see org.hi.framework.dao.ibatis.BaseDAOIbatis
 * @see com.ibatis.sqlmap.engine.builder.xml.SqlMapParser
 *
 */
public interface IbatisHiDialect extends HiDialect{
	public final static String HI_PROPERTY_DIALET_KEY = "ibatis.dialect";
	public final static String IBATIS_KEYGENERATETYPE_POST = "post";
	public final static String IBATIS_KEYGENERATETYPE_PRE = "pre";
	/**
	 * 在*.ism.xml文件中您会发现在insert元素的子元素selectKey中没有正文,该方法的作用就是在
	 * 系统启动Ibatis通过SqlMapParser构建<code>MappedStatement</code>时将selectKey元素中的正文自动注入到ibatis的
	 * 容器中,从而实现不同数据库系统(RDBMS)之间的在插入记录时生成主键值的差异性
	 * @param entityName 与数据库表对应的实体的实体名称
	 * @return 返回生成获取数据主键值的正文
	 * @see com.ibatis.sqlmap.engine.mapping.statement.MappedStatement
	 */
	public String getSelectKey(String entityName);
	
	/**
	 * 主健生成的类型即在插入数据之前还是之后,缺省为post
	 * @return 主健生成的类型
	 */
	public String getKeyGenerateType();
	
	public String processInsertSql(String insertMap, String entityName);
	
	public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms);
}
