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
 *@author ���
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
     * ��ǰ���ݵ�Ψһ��ʶ��Ϣ,�����������Ա�ͷ�����Ա�ı��,���ݾͷ��ص��ݵ���ˮ��
     * ��֮����������ÿ�������ò�����Ա�����Ĳ�����Ϣ
     * @return
     */
    public String getDataSymbol(){
    	return null;
    }
    
    protected Map<String, Object> oldValues = new HashMap<String, Object>();
    
    /**
     * ��ʵ���Ƿ���ɾ����ʶ��
     * @return �����ɾ����ʶ���򷵻�true,���򷵻�false
     */
    public boolean isDeletedFlag(){
    	return BeanUtil.hasPropertyName(this, POJO_DELETED);
    }
    
    /**
     * �õ����ӹ�ϵ����ʵ����Ϣ
     * @return ������ʵ����Ϣ
     */
    public BaseObject getParentEntity(){
		return null;
	}
    
    public void setParentEntity(BaseObject parent){}

	/**
	 * ����ö��������ݿ��е���Ӧ��¼,ֻҪ��һ����ͬ�򷵻�true,���򷵻�false
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
	 * ����������ʵ���������,������κ�һ��Ϊdirty�򷵻�true
	 * @return
	 */
	public boolean isCascadeDirty(){
		if(this.dirty)
			return true;
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(this);
		for (PropertyDescriptor descriptor : properties) {
			Class clzz = descriptor.getPropertyType();
			
			//������Ǽ������;�����
			if(!Collection.class.isAssignableFrom(clzz))
				 continue;
			
			String propertyName = descriptor.getName();
			Object collObj = BeanUtil.getPropertyValue(this, propertyName);
			
			//����Ǽ������͵���Ϊ��������
			if(collObj == null)
				continue;
			
			//�������м���(��ʵ��),������κ�һ������true�򷵻�true
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
