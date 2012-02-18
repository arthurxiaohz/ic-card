package org.hi.framework.service.impl;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.SpringContextHolder;
import org.hi.common.attachment.model.Attachment;
import org.hi.common.attachment.service.AttachmentManager;
import org.hi.common.util.BeanUtil;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.model.BaseObject;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;
import org.hi.framework.service.PostRemoveObjectCallback;
import org.hi.framework.service.PreSaveObjectCallback;
import org.hi.framework.web.ServletContext;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public abstract class AbstractBaseManager implements Manager {

	protected DAO dao = null;

	protected final Log log = LogFactory.getLog(getClass());

	public void setDAO(DAO dao) {
		this.dao = dao;
	}
	
	public DAO getDAO(){
		return this.dao;
	}

	/**
	 * 保存
	 */
	public void saveObject(Object obj) {
		preSaveObject(obj);
		dao.saveObject(obj);
		postSaveObject(obj);
	}

	/**
	 * 保存给定对象之前的操作
	 * @param obj 待保存的POJO对象
	 */
	protected void preSaveObject(Object obj) {
		
//		执行保存前的回调接口
		PreSaveObjectCallback callback = null;
		try{
			callback = (PreSaveObjectCallback)SpringContextHolder.getBean(PreSaveObjectCallback.class);
		}
		catch(NoSuchBeanDefinitionException e){}
//		如果在spring中的容器中没有定义,则忽略回调
		if(callback != null)
			callback.savePreObjectProcess(obj);
	}

	/**
	 * 保存给定对象之后的操作
	 * @param obj 待保存的POJO对象
	 */
	protected void postSaveObject(Object obj) {

	}

	public void removeObjectById(Class clazz, Serializable id) {
		Object obj = this.getObjectById(clazz, id);
		this.removeObject(obj);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.service.Manager#removeObject(java.lang.Object)
	 */
	public void removeObject(Object obj) {
		preRemoveObject(obj);
		
		if(obj instanceof BaseObject){
			BaseObject bo = (BaseObject)obj;
			if(!bo.isDeletedFlag()){
//				删除附件记录及文件
				if(!(obj instanceof Attachment)){
					processAttachment((BaseObject)obj);
				}
				dao.removeObject(obj);
			}
			else{
				BeanUtil.setPropertyValue(obj,BaseObject.POJO_DELETED, new Integer(1)); //如果有删除标识符，则参标识符进行更新
				dao.saveObject(obj);
			}
		}
		else
			dao.removeObject(obj);
		
		
		postRemoveObject(obj);
	}
	
	private void processAttachment(Object obj){
		if(!(obj instanceof BaseObject))
			return;

		PropertyDescriptor[] actionProperties = PropertyUtils.getPropertyDescriptors(obj);
		for (int i = 0; i < actionProperties.length; i++) {
			PropertyDescriptor propertyDescriptor = actionProperties[i];
			Class ObjClazz = propertyDescriptor.getPropertyType();
			String propertyName = propertyDescriptor.getName();
			
//			如果有子实体就递归
			if(Collection.class.isAssignableFrom(ObjClazz)){
				Collection coll = (Collection)BeanUtil.getPropertyValue(obj, propertyName);
				if(coll == null || coll.size() == 0)
					continue;
				for (Object object : coll) {
					processAttachment(object);
				}
			}
//			如果当前属性是附件类型就将实体信息与文件一并删除
			if(Attachment.class.isAssignableFrom(ObjClazz)){
				Attachment att = (Attachment)BeanUtil.getPropertyValue(obj, propertyName);
				removeAttachment(att);
			}
		}
	}
	
	private void removeAttachment(Attachment att){
		if(att == null || att.getAttachmentPath() == null)
			return;
		
		//如果不是文件或文件不存在,就不做处理
		String prefix = ServletContext.getServletContext().getRealPath("/");
		File attFile = new File(prefix + att.getAttachmentPath());
		if(!attFile.isFile())
			return;
		attFile.delete();
		AttachmentManager attMgr = (AttachmentManager)SpringContextHolder.getBean(Attachment.class);
		attMgr.removeObject(att);
	}

	/**
	 * 删除给定对象之前的操作
	 * @param obj 待删除的POJO对象
	 */
	protected void preRemoveObject(Object obj) {

	}

	/**
	 * 删除给定对象之后的操作
	 * @param obj 待删除的POJO对象
	 */
	protected void postRemoveObject(Object obj) {
		
//		执行删除的的回调接口
		PostRemoveObjectCallback callback = null;
		try{
			callback = (PostRemoveObjectCallback)SpringContextHolder.getBean(PostRemoveObjectCallback.class);
		}
		catch(NoSuchBeanDefinitionException e){}
//		如果在spring中的容器中没有定义,则忽略回调
		if(callback != null)
			callback.removePostObjectProcess(obj);
		
	}

	public Object getObjectById(Class clazz, Serializable id) {
		Object obj = dao.getObjectById(clazz, id);
		if (obj == null)
			try {
				obj = clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		return obj;
	}

	public Object getUniqueObject(Class clazz, Filter filter) {
		Filter delFilter = deletedFilter(clazz);
		
		//加删除符的过滤条件
		if(delFilter != null && filter != null)
			filter.addFilter(delFilter);
		if(filter == null)
			filter = delFilter;
		
		return dao.getUniqueObject(clazz, filter);
	}

	public List getObjects(Class clazz) {
		Filter delFilter = deletedFilter(clazz);
		if(delFilter == null)
			return dao.getObjects(clazz);
		else
			return dao.getObjects(clazz, delFilter);
	}

	public List getObjects(Class clazz, Filter filter) {
		Filter delFilter = deletedFilter(clazz);
		if(delFilter != null && filter != null)
			filter.addFilter(delFilter);
		if(filter == null)
			filter = delFilter;
		return dao.getObjects(clazz, filter);
	}

	public List getObjects(Class clazz, Filter filter, Sorter soter) {
		Filter delFilter = deletedFilter(clazz);
		if(delFilter != null && filter != null)
			filter.addFilter(delFilter);
		if(filter == null)
			filter = delFilter;
		return dao.getObjects(clazz, filter, soter);
	}

	public List getObjects(Class clazz, Filter filter, Sorter sorter, Page page) {
		Filter delFilter = deletedFilter(clazz);
		if(delFilter != null && filter != null)
			filter.addFilter(delFilter);
		if(filter == null)
			filter = delFilter;
		return dao.getObjects(clazz, filter, sorter, page);
	}

	public List getObjects(Class clazz, PageInfo pageInfo) {
		Filter delFilter = deletedFilter(clazz);
		if(delFilter != null)
			pageInfo.setFilter(delFilter);
		return dao.getObjects(clazz, pageInfo);
	}

	public int getObjectCount(Class clazz){
		return getObjectCount(clazz, null);
	}
	
	public int getObjectCount(Class clazz, Filter filter){
		Filter delFilter = deletedFilter(clazz);
		if(delFilter != null && filter != null)
			filter.addFilter(delFilter);
		if(filter == null)
			filter = delFilter;
		return dao.getObjectCount(clazz, filter);
	}
	
	/**
	 * 
	 * @param pageInfo
	 * @param securityFilter
	 * @return
	 * @see org.hi.framework.service.impl.ManagerImpl#getList(PageInfo)
	 */
	public List getList(PageInfo pageInfo, Filter securityFilter){
		return null;
	}

	
	private Filter deletedFilter(Class clazz){
		if(BeanUtil.hasPropertyName(BeanUtil.CreateObject(clazz.getName()), BaseObject.POJO_DELETED)){
			Filter filter = FilterFactory.getSimpleFilter(BaseObject.POJO_DELETED, new Integer(1), Filter.OPERATOR_NOT_EQ)
			.addCondition(BaseObject.POJO_DELETED, null, Filter.OPERATOR_EQ, Filter.RELATION_OR);
			return filter;
		}
		return null;
	}
}