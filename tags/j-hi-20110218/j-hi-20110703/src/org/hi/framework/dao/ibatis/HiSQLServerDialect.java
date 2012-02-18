package org.hi.framework.dao.ibatis;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.ibatis.mapping.ParameterMapping;
import org.hi.SpringContextHolder;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.dao.impl.AbstractSQLServerDialect;
import org.hi.framework.paging.Page;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.context.service.Entity;

public class HiSQLServerDialect extends AbstractSQLServerDialect implements IbatisHiDialect{
	
	public String getSelectKey(String entityName){
		return " select @@IDENTITY as id ";
	}
	
	public String getKeyGenerateType(){
		return IBATIS_KEYGENERATETYPE_POST;
	}
	
	public String getMaxRecode(Object query, Filter filter, Page page) {
		IQuery _query = (IQuery)query;
		String maxLimit = HiConfigHolder.getMaxLimit();
		
		if(page != null && page.getMaxRecords() > 0)
			maxLimit = String.valueOf(page.getMaxRecords());
		
		String top = " top "+ maxLimit + " ";
		
		if(!maxLimit.equals(String.valueOf(HiConfigHolder.PAGE_MAXRECORDS))) //�������޼�¼��Ϊ0����ͻ��
			_query.replaceAll("select", "select"+top);
		return null;
	}
	
	public String getDataBaseType() {
		return HiDialect.DATABASE_TYPE_SQLSERVER;
	}

	public String processInsertSql(String insertMap, String entityName) {
		return processInsertSqlFor3(insertMap, entityName, null);
	}

	public String processInsertSqlFor3(String insertMap, String entityName, List<ParameterMapping> pms) {
		StringBuffer sb = new StringBuffer();
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
			return insertMap;
		
//		ȥ��insert��ID��ID��ֵ
		List<String> list = StringUtils.dividToList(insertMap, "(", ",");
		for (String string : list) {
			if(StringUtils.isInclude(string, "(") && StringUtils.isInclude(string, ",")){
				sb.append("(");
				continue;
			}
			sb.append(string);
			
		}
		
		if(pms != null)
			pms.remove(0);
		
		return sb.toString();
	}
	
}