package org.hi.base.sysapp.interceptor;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hi.base.enumeration.EnumerationHelper;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.dao.impl.LikeFilter;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.framework.web.ServletContext;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.constant.FieldType;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.Field;


/**
 * @author 张昊
 * @since 2009-12-3
 *
 */
public class LogSearchAnalysisor extends AbstractLogAnalysisor {

	public String perProcess(Object[] args, Entity entity, Manager manager) {
		StringBuffer conditions = new StringBuffer("筛选条件:");
		StringBuffer parameters = new StringBuffer("参数信息:");
		boolean hasParameter = false;
		for (int i = 0; i < args.length; i++) {
			if(args[i] instanceof PageInfo){
				PageInfo pageInfo = (PageInfo)args[i];
				getFilerInfo(pageInfo.getFilter(), entity, conditions);
			}
			if(args[i] instanceof Filter ){
				Filter filter = (Filter)args[i];
				getFilerInfo(filter, entity, conditions);
			}
			if(args[i] instanceof String){
				if(args[i] != null){
					parameters.append(args[i]);
					hasParameter = true;
				}
			}
		}
		
		if(hasParameter)
			conditions.append("\n").append(parameters);
		
		return conditions.toString();
	}
	
	protected void getFilerInfo(Filter filter, Entity entity, StringBuffer conditions){
		if(filter.getConditions().size() == 0){
			conditions.append("无");
			return;
		}
		List<FilterBean> filterBeans = filter.getConditions();
		for(int i = 0; i < filterBeans.size(); i++){
			FilterBean filterBean = filterBeans.get(i);
			if(i > 0)
				conditions.append(" ").append(filterBean.getRelations()).append(" ");
			String name = null;
			Object value = filterBean.getValue();
			try {
				Field field = HSCHelper.getField(ServletContext.getServletContext().getRealPath(""), entity, filterBean.getFieldName());
				name = field.getFieldLabel();
				if( value != null){
					if(field.getFieldType() == FieldType.FIELD_TYPE_ENUMERATION){
						EnumerationValue enuValue = EnumerationHelper.getEnumerationValue((Integer)value);
						value = enuValue.getDescription();
					}
					if(value instanceof Date){
						Date date = (Date)value;
						value = StringUtils.DateToStr(date, "yyyy-MM-dd");
					}
					if(value instanceof Timestamp){
						Timestamp time = (Timestamp)value;
						Date date = new Date(time.getTime());
						value = StringUtils.DateToStr(date, "yyyy-MM-dd hh:mm:ss");
					}
					
				}
			} catch (Exception e) {
				name = filterBean.getFieldName();
			}
			//加属性名的描述
			conditions.append(name).append(" ");
			//加NO标识
			if(filterBean.isNot())
				conditions.append("NO ");
			//加操作符
			String operater = filterBean.getOperater();
			conditions.append(operater).append(" ");
			
			int lkControler = filterBean.getLikeControler();
			if(operater.equals(Filter.OPERATOR_LIKE) && (LikeFilter.LIKE_CONTROLER_LEFT == lkControler ||
					LikeFilter.LIKE_CONTROLER_ALL == lkControler))
					conditions.append("%");
			
			//加值
			conditions.append(value);
			
			if(operater.equals(Filter.OPERATOR_LIKE) && (LikeFilter.LIKE_CONTROLER_RIGHT == lkControler ||
					LikeFilter.LIKE_CONTROLER_ALL == lkControler))
					conditions.append("%");
		}
	}

	public String postProcess(Object result) {
		String count = null;
		if(result == null) count = "0";
		
		if(result instanceof Collection){
			Collection coll = (Collection)result;
			count = String.valueOf(coll.size());
		}
		else if(result instanceof Array)
			count = String.valueOf(Array.getLength(result));
		else
			count = "1";
		return "\n记录数:" + count;
	}

}
