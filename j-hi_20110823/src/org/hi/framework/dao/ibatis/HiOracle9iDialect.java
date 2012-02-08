package org.hi.framework.dao.ibatis;

import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;
import org.hi.SpringContextHolder;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.impl.AbstractOracleDialect;
import org.hi.framework.paging.Page;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.context.service.Entity;

public class HiOracle9iDialect extends AbstractOracleDialect implements IbatisHiDialect{
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.ibatis.IbatisHiDialect#getSelectKey(java.lang.String)
	 */
	public String getSelectKey(String entityName){
		
		String servletRootDir = SpringContextHolder.getServletContext().getRealPath("");
		
//		找到实体继承的关系如果是父实体就不加主键，如果是子实体就要有主键
		Entity parentEntity = null;
		try {
			Entity entity = HSCHelper.getEntity(servletRootDir, entityName);
			parentEntity = HSCHelper.getParentEntity(servletRootDir, HSCHelper.getEntityClass(servletRootDir, entity));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(parentEntity != null)	//如果是继承实体则加主键
			return null;
		
		String sequenceName = entityName.toUpperCase() + HiDialect.HI_SEQUENCE_SUFFIX;
		return " SELECT " + sequenceName + ".NEXTVAL AS ID FROM DUAL ";
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.ibatis.IbatisHiDialect#getKeyGenerateType()
	 */
	public String getKeyGenerateType(){
		return IBATIS_KEYGENERATETYPE_PRE;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.framework.dao.HiDialect#getMaxRecode(java.lang.Object, org.hi.framework.dao.Filter, org.hi.framework.paging.Page)
	 */
	public String getMaxRecode(Object query, Filter filter, Page page) {
		IQuery _query = (IQuery)query;
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		if(!maxLimit.equals(String.valueOf(HiConfigHolder.PAGE_MAXRECORDS))) //如果最大限记录数为0，则突略
			return null;
		
		boolean isWhere = (filter != null && filter.getConditions().size() > 0) 
						|| _query.toString().contains("where");
		if(isWhere)	
			_query.append("and ");
		else 
			_query.append(" where ");
		

		_query.append(" rownum <= ").append(maxLimit);
		return  null;
	}
	
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_ORACLE;
	}

	public String processInsertSql(String insertMap, String entityName ) {
		
		return insertMap;
	}

	public String processInsertSqlFor3(String insertMap, String entityName,
			List<ParameterMapping> pms) {

		return processInsertSql(insertMap, entityName);
	}
	
}