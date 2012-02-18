package org.hi.framework.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.common.util.StringUtils;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.model.BaseObject;
import org.hi.framework.service.Manager;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.context.service.Entity;
import org.hi.metadata.hsc.context.service.ExtendEntity;
import org.hi.metadata.hsc.context.service.Field;

public abstract class HiAbstractDialect implements HiDialect{
	
	protected final Log log = LogFactory.getLog(getClass());
	
    protected void setupConditions(List<Entity> entities,StringBuffer mainSb, List<FilterBean> filterBeans, String aliasName, Integer groupIndex){
		/*为SQL条件部分设置引用占位符*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //如果是第一个条件组,则在最前面加个括号 group主要就是为了添加括号用
				mainSb.append("( ");
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //如果不是第一个条件组,则在关系符后面加括号
				mainSb.append(filterBean.getRelations()).append(" ( ");
			if(i > 0 )
				mainSb.append(" ").append(filterBean.getRelations()).append(" ");			//添加两个条件之间的关系符
			
			if(aliasName != null && !aliasName.trim().equals("")){
				
				//获取待级联的表的别名
				String tableName = aliasName;
				if(entities.size() > 1){
					String fieldName = filterBean.getFieldName();
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int j=entities.size()-1;j>=0;j--){			//如果有继承要加继承表的
						List<Field> allFields=entities.get(j).getField();
						for (Field field : allFields) {
							if(field.getFieldName().equals(fieldName)){
								tableName = entities.get(j).getTableName();
						        break entityLabel;
							}
						}
					}
				}
				
				//对查询条件级联字段的处理
				String fieldName;
				if(!filterBean.getFieldName().contains(".")){
					fieldName = tableName + "." + filterBean.getFieldName();
					mainSb.append(fieldName).append(" ");
				}
				else{
					String[] fieldNames = filterBean.getFieldName().split("[.]");//拆分还有"."的属性名称
					fieldName = fieldNames[fieldNames.length - 2] + "." + fieldNames[fieldNames.length - 1]; //留下属性的后两个a.b
					mainSb.append(fieldName).append(" ");
				}
				
			}
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
			
			
			/*如果是值的类型是字符串，并且操作符是like则在值的两端加百分号（%）*/
			if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
				val = (String)filterBean.getValue();
				//判断like的控制符
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
					val = "%" + val;
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
					val =  val + "%";
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
					val =  "%" + val + "%";
				filterBean.setValue(val);
			}
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	如果操作符是IN，则每一个值对应一个引用占位符
				mainSb.append("(");
				List coll = (List)filterBean.getValue();
				for(int j = 0; j < coll.size(); j++){
					if(j > 0)
						mainSb.append(",");
					mainSb.append(setupConditionValue(coll.get(i)));
					
				}
				mainSb.append(") ");
			}
			else{
				if(filterBean.getValue() instanceof BaseObject)
					mainSb.append(((BaseObject)filterBean.getValue()).getPrimarykey());
				else
		            mainSb.append(setupConditionValue(filterBean.getValue()));		
			}
		}
	}
    
    protected  abstract String getFeildToString(String fieldName, FilterBean filterBean);
	protected String setupConditionValue(Object val){
		if(val instanceof String)
			return "'" + val + "'";
		else if(val instanceof Date)
			return "'" + StringUtils.DateToStr((Date)val, "yyyy-MM-dd") + "'";
		else if(val instanceof Timestamp){
			Timestamp timestamp = (Timestamp)val;
			return "'" + StringUtils.DateToStr(new Date(timestamp.getTime()), "yyyy-MM-dd hh:mm:ss") + "'";
		}
		else 
			return val.toString();
	}
    
	public String getFilterSQL(Filter filter, Manager manager){
		
		if(manager.getDAO().getDialect() == null)
			return null;
		
		Entity entity=null;
		try {
			
			entity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), manager.getClass());//通过class获得实体类
		} catch (Exception e) {
			log.error("not found Entity Define by className:" + manager.getClass().getName());
		}
		List<Entity> entities = this.getSuperClassName(entity, null, null);//获得包括实体在内的所有祖先实体
		
		StringBuffer mainSb = new StringBuffer("");
		if(filter != null && filter.getConditions().size() > 0){
			String tableName = entity.getTableName(); //获得实体的表名
			String	aliasName = filter == null || filter.getAliasName() == null ? tableName : filter.getAliasName();//设置别名
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //如果filter组中只有它自己，没有通过addFilter方法连接的
				setupConditions(entities, mainSb, filterBeans, aliasName, null);
			else{
				for(int i = 0; i < filterGroup.size(); i++){
					List<FilterBean> filtergroup = filterGroup.get(i);
					setupConditions(entities, mainSb, filtergroup, aliasName, i);
					mainSb.append(") ");
				}
			}
		}	
		return mainSb.toString();
	}
	
	 /**
     * 获得包括当前类在内的所有祖先对象实体
     */
	
	private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity){
		if(entitis == null)
			entitis = new ArrayList<Entity>();
		
		String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
		Entity entity = null;
		try {
			if(obj != null){
				if(obj instanceof BaseObject)
					entity = HSCHelper.getEntity(servletRootPath, obj.getClass());//获得给定类型的实体
				if(obj instanceof Class)
					entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
				if(obj instanceof Entity)
					entity = (Entity)obj;
			}
			else
				entity = superEntity;
			
			ExtendEntity extendEntity = entity.getExtendEntity();//获得继承的实体
			if(extendEntity != null  && extendEntity.getExtendEntityName() != null && !extendEntity.getExtendEntityName().trim().equals("")){
				//获得祖先实体的名字
				getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
			}
		} catch (Exception e) {}
		
		if(entity != null)
			entitis.add(entity);
		
		return entitis;
	}
}
