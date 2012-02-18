package org.hi.framework.dao.springjdbc;

import java.util.List;

import javax.sql.DataSource;

import org.hi.SpringContextHolder;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.impl.AbstractMySQLDialect;
import org.hi.framework.dao.impl.HiAbstractDialect;
import org.hi.framework.paging.Page;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.context.service.Entity;

public class HiMySQLDialect extends AbstractMySQLDialect implements SpringJDBCHiDialect {

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.HiDialect#getMaxRecode(java.lang.Object, org.hi.framework.dao.Filter, org.hi.framework.paging.Page)
	 */
	public String getMaxRecode(Object query, Filter filter, Page page) {
		SpringJDBCQuery _query = (SpringJDBCQuery)query;
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		
		if(!maxLimit.equals(String.valueOf(HiConfigHolder.PAGE_MAXRECORDS))) //�������޼�¼��Ϊ0����ͻ��
			_query.append(" limit ").append(maxLimit);
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.HiDialect#getDataBaseType()
	 */
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_SQLSERVER;
	}

	public String getLimitString(String querySelect, Page page) {
		if(page  == null)
			return querySelect;
		
		return new StringBuffer( querySelect.length()+20 )
		.append(querySelect)
		.append( " limit "+page.getStartRowPosition()+", "+page.getPageSize())
		.toString();
	}
	

	public boolean inResult(int rowNum, Page page){
		return true;
	}

	public String insertSql(String sql, String entityName, List<ValueClass2JDBCType> values) {
		
		String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
		
//		�ҵ�ʵ��̳еĹ�ϵ����Ǹ�ʵ��Ͳ����������������ʵ���Ҫ������
		Entity parentEntity = null;
		try {
			Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
			parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(parentEntity != null)	//����Ǽ̳�ʵ���������
			return sql;
		
		StringBuffer sb = new StringBuffer();
//		ȥ��insert��ID��ID��ֵ
		List<String> list = StringUtils.dividToList(sql, "(", ",");
		for (String string : list) {
			if(StringUtils.isInclude(string, "(") && StringUtils.isInclude(string, ",")){
				sb.append("(");
				continue;
			}
			sb.append(string);
			
		}
		
		if(values != null)
			values.remove(0);
		
		return sb.toString();
	}

	public Number getSelectKey(String entityName, DataSource dataSource) {
//		������������ʵ�ָ÷���
		return null;
	}
}
