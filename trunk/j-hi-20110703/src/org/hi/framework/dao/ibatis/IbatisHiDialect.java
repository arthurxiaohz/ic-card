package org.hi.framework.dao.ibatis;

import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;
import org.hi.framework.dao.HiDialect;

/**
 * ���ӿ��Ƕ�Ibatis���ԵĽӿڵ����ⲹ��.�ýӿ��е����з���������<code>BaseDAOIbatis</code>�༰ibatis��<code>SqlMapParser</code>���б�����
 * <p>��ibatis�з��Ե�������ͨ����<code>Dialect</code>�Ĳ�ͬ����ʵ����ʵ�ֲ�ͬ���ݿ�ϵͳ(RDBMS)֮
 * ��Ĳ�����
 * @author ���
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
	 * ��*.ism.xml�ļ������ᷢ����insertԪ�ص���Ԫ��selectKey��û������,�÷��������þ�����
	 * ϵͳ����Ibatisͨ��SqlMapParser����<code>MappedStatement</code>ʱ��selectKeyԪ���е������Զ�ע�뵽ibatis��
	 * ������,�Ӷ�ʵ�ֲ�ͬ���ݿ�ϵͳ(RDBMS)֮����ڲ����¼ʱ��������ֵ�Ĳ�����
	 * @param entityName �����ݿ���Ӧ��ʵ���ʵ������
	 * @return �������ɻ�ȡ��������ֵ������
	 * @see com.ibatis.sqlmap.engine.mapping.statement.MappedStatement
	 */
	public String getSelectKey(String entityName);
	
	/**
	 * �������ɵ����ͼ��ڲ�������֮ǰ����֮��,ȱʡΪpost
	 * @return �������ɵ�����
	 */
	public String getKeyGenerateType();
	
	public String processInsertSql(String insertMap, String entityName);
	
	public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms);
}
