package org.hi.framework.web.struts;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.framework.model.BaseObject;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;
import org.hi.framework.web.struts.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PrepareInterceptor;


/**
 * 用于从数据库中加载对象的webwork拦截器,其主要目的是在action执行保存POJO操作时
 * 实现对该POJO所引用的对象与数据库做同步操作
 * <p>注意：该拦截器是前置拦截器,即是在执行action类中的execute方法之前被调用
 * @author 张昊
 * @since 2007-8-1
 * @author kongfy
 * 修改
 * @since 2010-03-09
 */
public class LoadObjectInterceptor extends PrepareInterceptor {


	public String doIntercept(ActionInvocation invocation) throws Exception {
		 BaseAction action = (BaseAction)invocation.getAction();
		 String actionName = invocation.getProxy().getActionName();
		 String methodName = invocation.getProxy().getMethod();
		 if((actionName.toUpperCase().indexOf("SAVE")<0  && methodName.toUpperCase().indexOf("UPDATE")<0) && !(action instanceof SynchronizationData)){
			 String result = invocation.invoke();
			 return result;
		 }
		 
		 PropertyDescriptor[] actionProperties = PropertyUtils.getPropertyDescriptors(action);
		 //遍历action中的所有成员属性
		 for (PropertyDescriptor actionDescriptor : actionProperties) {
			
			 //如果不是BaseObject类型的属性就跳过
			 Class ObjClazz = actionDescriptor.getPropertyType();
			 if(!BaseObject.class.isAssignableFrom(ObjClazz) && !Collection.class.isAssignableFrom(ObjClazz))
				 continue;
			 
			 //如果BaseObject类型的对象主键值为null就跳过
			 String propertyName = actionDescriptor.getName();
			 Object mergeObject = null;
			 
			 //如果是一个POJO的处理
			 if(BaseObject.class.isAssignableFrom(ObjClazz)){
				 BaseObject obj = (BaseObject)BeanUtil.getPropertyValue(action, propertyName);
				
				 if(obj == null)
					 continue;
				 
				 mergeObject = assemblingObject(obj, action, invocation);	//如果不是新建对象,则从数据库中load出来该对象,以实现与持久层的同步

				}
			 
			 //如果是集合的处理
			 if(Collection.class.isAssignableFrom(ObjClazz)){
				 Collection obj = (Collection)BeanUtil.getPropertyValue(action, propertyName);
				 
				 if(obj == null)
					 continue;
				 
				 if( obj.size() == 0){
					 mergeObject = obj;
					 continue;
				 }
				 mergeObject = new ArrayList();
				 for (Iterator iter = obj.iterator(); iter.hasNext();) {
					 Object element = iter.next();
					 
					 //如果集合内的元素不是BaseObject类型,则不做与持久层的合并操作
					 if(!BaseObject.class.isAssignableFrom(element.getClass())){
						 mergeObject = obj;
						 break;
					 }
					 
					BaseObject baseObject = (BaseObject)element;
					
					//通过将baseObject合并处理,将该对象作为元素加到集合中
					((Collection)mergeObject).add(assemblingObject(baseObject, action, invocation));
				}
			 }
			 
//			 //如果是新建的对象则执行新建处理方法
//			 if(obj.getPrimarykey() == null){ //主键为null视为新建的对象
//				 ObjectNew(obj,null);  
//				 continue;
//			 }
//			 
//			 BaseObject persistence = loadObject(obj);	//如果不是新建对象,则从数据库中load出来该对象,以实现与持久层的同步
//			 
//			 merageObject(persistence, obj, null);	//将持久层中的对象与表视层送过来的对象做合并
			 BeanUtil.setPropertyValue(action, propertyName, mergeObject);	//将合并后的对象放到action的属性中
		}
		 
		 String result = invocation.invoke();
		 return result;
	}
	
	/**
	 * 返回一个持久层与表现层合并后的POJO
	 * @throws BusinessException 
	 */
	private BaseObject assemblingObject(BaseObject obj, BaseAction action, ActionInvocation invocation) throws InstantiationException, IllegalAccessException, BusinessException{
		 //如果是新建的对象则执行新建处理方法
		 if(obj.getPrimarykey() == null){ //主键为null视为新建的对象
			 ObjectNew(obj,null);  
			 return obj;
		 }
		 
		 BaseObject persistence = loadObject(obj);	//如果不是新建对象,则从数据库中load出来该对象,以实现与持久层的同步
		 
		 merageObject(persistence, obj, null, action, invocation);	//将持久层中的对象与表视层送过来的对象做合并
		 
		 return persistence;
	}
	
	private void ObjectNew(BaseObject obj, BaseObject parentObj) {
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(obj);
		
		//所有新的POJO都认为是改变的,即在BaseObject中的dirty域为true
		obj.setDirty(true);
		
		//遍历对象的所有属性
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			Object domainObject = BeanUtil.getPropertyValue(obj, propertyName);

			if(descriptor.getWriteMethod() == null) //如果没有写方法就跳过,如class
				continue;
			
			
			if (domainObject == null)
				continue;

			if (parentObj == domainObject)
				continue; // 忽略父的lookup属性

			if (domainObject instanceof BaseObject) {
				BaseObject bo = (BaseObject)domainObject;
				if(bo.getPrimarykey() == null)		//如果主键为null，则将该属性的值赋为null
					BeanUtil.setPropertyValue(obj, propertyName, null);
				else{
					Object val = loadObject(bo);	//否则load出来该对象,并赋值
					if(val == null)
						BeanUtil.setPropertyValue(obj, propertyName, null);
					else
						BeanUtil.setPropertyValue(obj, propertyName, val);
				}
			}

			if (domainObject instanceof Collection) {		//如果有集合,做递归操作
				Collection coll = (Collection) domainObject;
				if (coll == null)
					continue;

				for (Object object : coll) {
					if(object != null)
						ObjectNew((BaseObject)object, obj);
				}
			}
		}
	}
	
	private void merageObject(BaseObject pObj, BaseObject vObj, BaseObject parentObj, BaseAction action, ActionInvocation invocation) throws InstantiationException, IllegalAccessException, BusinessException{
		
		boolean equalsClass = vObj.getClass().equals(pObj.getClass());
		
		Set<String> v_PropertyNams = new HashSet<String>();
		if(!equalsClass){
			PropertyDescriptor[] v_properties = PropertyUtils.getPropertyDescriptors(vObj);
			for (PropertyDescriptor v_descriptor : v_properties) {
				v_PropertyNams.add(v_descriptor.getName());
			}
		}
		
		//在赋值之前将两个对象的脏数据标识均设为false
		vObj.setDirty(false); 
		pObj.setDirty(false);
		
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(pObj);
		for (PropertyDescriptor descriptor : properties) {
			String propertyName = descriptor.getName();
			Class clazz = descriptor.getPropertyType();
			
			if(descriptor.getWriteMethod() == null) //如果没有写方法就跳过,如class
				continue;
			
			//如果表现层类型与持久类型不同，并且表现层属性在持久层中没有,跳过.目的是处理实体继承
			if(!equalsClass && !v_PropertyNams.contains(propertyName)) 
				continue;
			
			Set<String>  parameterNames = invocation.getInvocationContext().getParameters().keySet();
			
			Object v_value = BeanUtil.getPropertyValue(vObj, propertyName); //如果对象为null,跳过
			if(v_value == null && notIncludParameterName( parameterNames, propertyName))
				continue;
			
			if(clazz.isInterface() && !(v_value instanceof Collection))	//允许POJO实现接口，属性所对应的类型是接口则跳过
				continue;
			
			if(parentObj !=null && v_value == parentObj)	//如果父对象与当前属性是同一个跳过,主要是为递归调用时起作用
				continue;

			if(propertyName.equals("dirty"))		//如果是dirty不做赋值处理
				continue;
//			Object new_value = BeanUtil.getPropertyValue(newObj,propertyName);
//			if(new_value !=null && new_value.equals(v_value))	//如果新值不为空并且与表现层的值相同,跳过,目的是处理POJO的缺省值
//				continue;
			
			Object p_value = BeanUtil.getPropertyValue(pObj, propertyName);
			
			
			if(propertyName.equals("version") && v_value != null && !v_value.equals(p_value) ){
					action.setErrorObject(vObj);
			}
			
			//如果是明细对象且属性名是version，而表现层该值又为空时,将持久层对象值赋给表现层
			if(parentObj != null && propertyName.equals("version") && v_value == null){ 
				v_value = p_value;
			}
			
			if(!(v_value instanceof Collection) && !(v_value instanceof BaseObject)) //如果该属性的类型不是集合或BaseObject类型,则简单赋值
				BeanUtil.setPropertyValue(pObj, propertyName, v_value);
			
			
			//lookup类型处理
			if (v_value instanceof BaseObject) {
				BaseObject v_bo_obj = (BaseObject)v_value;	//表现层对象
				BaseObject p_bo_obj = (BaseObject)p_value;	//持久层对象
				if(v_bo_obj.getPrimarykey() == null)
					continue;
				
				if(p_value != null && v_bo_obj.getPrimarykey().equals(p_bo_obj.getPrimarykey()))
					continue;
				
				Object val = null;
				if(Integer.parseInt(v_bo_obj.getPrimarykey().toString()) >= 0) //如果lookup的主键是小于0的，就等于置空
					val = loadObject(v_bo_obj);	//load出来lookup对象
//				if(val == null)
//					continue;
				
				BeanUtil.setPropertyValue(pObj, propertyName, val);	//将load出来的对象赋给持久层对象
			}
			
			if(p_value instanceof Collection){	//如果是集合做递归处理
				List p_coll = (List)p_value; //持久层集合
				List _v_coll = (List)v_value;
				List v_coll = new ArrayList(); //表现层集合
				
				for (Iterator iter = _v_coll.iterator(); iter.hasNext();) {	//先将子赋上父对象
					BaseObject element = (BaseObject) iter.next();
					if(element == null){
						continue;
					}
					element.setParentEntity(pObj);	//为子记录赋父POJO的引用
					v_coll.add(element);
				}
				
				if(p_coll.size() == 0){						//如果集合内的对象是新建的
					for (Object object : v_coll) {
						if(object == null)
							continue;
						ObjectNew((BaseObject)object, pObj);
						p_coll.add(object);
					}
				}

				else{									//如果集合内的对象是部分新建或只是更新的
					int p_index = p_coll.size();
					int v_index = v_coll.size();
					int length = v_index - p_index;
					for (int i = 0; i < v_index-length; i++) {	//做更新操作,递归merageObject方法
						merageObject((BaseObject)p_coll.get(i),(BaseObject)v_coll.get(i), pObj, action, invocation);
					}
					for (int i = 0; i < length; i++) {			//做新建操作
						ObjectNew((BaseObject)v_coll.get(v_index - length + i), pObj);
						p_coll.add(v_coll.get(v_index - length + i));
					}
				}
			}
		}
	}
	
	private BaseObject loadObject(BaseObject obj){
		Serializable id = obj.getPrimarykey();
		ManagerImpl manager = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
		Object value = manager.getObjectById(obj.getClass(), id);
		if(value == null)
			return null;
		return (BaseObject)value;
	}
	
	private boolean notIncludParameterName(Set<String> parameterNames, String propertyName){
		for (String parameterName : parameterNames) {
			if(parameterName.contains(propertyName))
				return false;
		}
		return true;
	}

}
