package org.hi.framework.model;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.hi.common.util.BeanUtil;


/**
 * Base class for Model objects.  Child objects should implement toString(), 
 * equals() and hashCode() and equals();
 *
 *@author 张昊
 *@since 2007-5-23
 * 
 */
public abstract class BaseObject implements Serializable {  
	
	private boolean dirty = false;
	
	public static final String POJO_DELETED="deleted";
	public static final String VERSION = "version";
	
    public abstract String toString();
    
    public abstract boolean equals(Object o);
    
    public abstract int hashCode();
    
    public abstract Serializable getPrimarykey();
    
    public abstract void setVersion(Integer version);
    
    public abstract Integer getVersion();
    
    /**
     * 当前数据的唯一标识信息,例如如果是人员就返回人员的编号,单据就返回单据的流水号
     * 总之是用于区别每条数据让操作人员可理解的差异信息
     * @return
     */
    public String getDataSymbol(){
    	return null;
    }
    
    protected Map<String, Object> oldValues = new HashMap<String, Object>();
    
    /**
     * 该实体是否有删除标识符
     * @return 如果有删除标识符则返回true,否则返回false
     */
    public boolean isDeletedFlag(){
    	return BeanUtil.hasPropertyName(this, POJO_DELETED);
    }
    
    /**
     * 得到主从关系的主实体信息
     * @return 返回主实体信息
     */
    public BaseObject getParentEntity(){
		return null;
	}
    
    public void setParentEntity(BaseObject parent){}

	/**
	 * 如果该对象与数据库中的相应记录,只要有一个不同则返回true,否则返回false
	 * @return
	 */
	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		
		if(!this.dirty)
			oldValues.clear();
	}
    
	public Object getOldValue(String propertyName){
		return oldValues.get(propertyName);
	}
	
	public boolean hasOldValue(String propertyName){
		return oldValues.keySet().contains(propertyName);
	}
	
	/**
	 * 遍历所有子实体包括自已,如果有任何一个为dirty则返回true
	 * @return
	 */
	public boolean isCascadeDirty(){
		if(this.dirty)
			return true;
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(this);
		for (PropertyDescriptor descriptor : properties) {
			Class clzz = descriptor.getPropertyType();
			
			//如果不是集合类型就跳过
			if(!Collection.class.isAssignableFrom(clzz))
				 continue;
			
			String propertyName = descriptor.getName();
			Object collObj = BeanUtil.getPropertyValue(this, propertyName);
			
			//如果是集合类型但是为空则跳过
			if(collObj == null)
				continue;
			
			//遍历所有集合(子实体),如果有任何一个返回true则返回true
			Collection coll = (Collection)collObj;
			for (Iterator i = coll.iterator(); i.hasNext();) {
				BaseObject element = (BaseObject) i.next();
				if(element.dirty)
					return true;
			}
		}
		
		return false;
	}
	
}
