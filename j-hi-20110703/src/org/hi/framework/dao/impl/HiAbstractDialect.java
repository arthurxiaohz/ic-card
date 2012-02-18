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
		/*ΪSQL����������������ռλ��*/
		for (int i = 0; i<filterBeans.size(); i++) {
			FilterBean filterBean = (FilterBean) filterBeans.get(i);
			String operater = filterBean.getOperater();
			if(groupIndex !=null && groupIndex == 0 && i ==0)  //����ǵ�һ��������,������ǰ��Ӹ����� group��Ҫ����Ϊ�����������
				mainSb.append("( ");
			if(groupIndex !=null && groupIndex != 0 && i == 0)  //������ǵ�һ��������,���ڹ�ϵ�����������
				mainSb.append(filterBean.getRelations()).append(" ( ");
			if(i > 0 )
				mainSb.append(" ").append(filterBean.getRelations()).append(" ");			//�����������֮��Ĺ�ϵ��
			
			if(aliasName != null && !aliasName.trim().equals("")){
				
				//��ȡ�������ı�ı���
				String tableName = aliasName;
				if(entities.size() > 1){
					String fieldName = filterBean.getFieldName();
					if(fieldName.contains("."))
						fieldName = fieldName.substring(0, fieldName.indexOf("."));
					entityLabel:for(int j=entities.size()-1;j>=0;j--){			//����м̳�Ҫ�Ӽ̳б��
						List<Field> allFields=entities.get(j).getField();
						for (Field field : allFields) {
							if(field.getFieldName().equals(fieldName)){
								tableName = entities.get(j).getTableName();
						        break entityLabel;
							}
						}
					}
				}
				
				//�Բ�ѯ���������ֶεĴ���
				String fieldName;
				if(!filterBean.getFieldName().contains(".")){
					fieldName = tableName + "." + filterBean.getFieldName();
					mainSb.append(fieldName).append(" ");
				}
				else{
					String[] fieldNames = filterBean.getFieldName().split("[.]");//��ֻ���"."����������
					fieldName = fieldNames[fieldNames.length - 2] + "." + fieldNames[fieldNames.length - 1]; //�������Եĺ�����a.b
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
			mainSb.append(operater).append(" "); 				//��Ӳ�����
			
			if(filterBean.isNot())					
				mainSb.append("NOT ");							//���NOT������
			
			
			/*�����ֵ���������ַ��������Ҳ�������like����ֵ�����˼Ӱٷֺţ�%��*/
			if(operater.equals(Filter.OPERATOR_LIKE) && filterBean.getValue() instanceof String ){
				val = (String)filterBean.getValue();
				//�ж�like�Ŀ��Ʒ�
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_LEFT)
					val = "%" + val;
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_RIGHT)
					val =  val + "%";
				if(filterBean.getLikeControler() == LikeFilter.LIKE_CONTROLER_ALL)
					val =  "%" + val + "%";
				filterBean.setValue(val);
			}
			
			if(operater.equals(Filter.OPERATOR_IN)){		//	�����������IN����ÿһ��ֵ��Ӧһ������ռλ��
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
			
			entity = HSCHelper.getEntity(SpringContextHolder.getServletContext().getRealPath(""), manager.getClass());//ͨ��class���ʵ����
		} catch (Exception e) {
			log.error("not found Entity Define by className:" + manager.getClass().getName());
		}
		List<Entity> entities = this.getSuperClassName(entity, null, null);//��ð���ʵ�����ڵ���������ʵ��
		
		StringBuffer mainSb = new StringBuffer("");
		if(filter != null && filter.getConditions().size() > 0){
			String tableName = entity.getTableName(); //���ʵ��ı���
			String	aliasName = filter == null || filter.getAliasName() == null ? tableName : filter.getAliasName();//���ñ���
			List<FilterBean> filterBeans = filter.getConditions();
			
			List<List<FilterBean>> filterGroup = filter.getFilterGroup();
			
			if(filterGroup.size() < 2) //���filter����ֻ�����Լ���û��ͨ��addFilter�������ӵ�
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
     * ��ð�����ǰ�����ڵ��������ȶ���ʵ��
     */
	
	private List<Entity> getSuperClassName(Object obj, List<Entity> entitis, Entity superEntity){
		if(entitis == null)
			entitis = new ArrayList<Entity>();
		
		String servletRootPath = SpringContextHolder.getServletContext().getRealPath("");
		Entity entity = null;
		try {
			if(obj != null){
				if(obj instanceof BaseObject)
					entity = HSCHelper.getEntity(servletRootPath, obj.getClass());//��ø������͵�ʵ��
				if(obj instanceof Class)
					entity = HSCHelper.getEntity(servletRootPath, (Class)obj);
				if(obj instanceof Entity)
					entity = (Entity)obj;
			}
			else
				entity = superEntity;
			
			ExtendEntity extendEntity = entity.getExtendEntity();//��ü̳е�ʵ��
			if(extendEntity != null  && extendEntity.getExtendEntityName() != null && !extendEntity.getExtendEntityName().trim().equals("")){
				//�������ʵ�������
				getSuperClassName(null, entitis, HSCHelper.getEntity(servletRootPath, extendEntity.getExtendEntityName(), extendEntity.getExtendServiceName()));
			}
		} catch (Exception e) {}
		
		if(entity != null)
			entitis.add(entity);
		
		return entitis;
	}
}
