package org.hi.base.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.service.impl.ManagerImpl;

/**
 * ��������֯���ͽṹ�Ĺ�����.
 * ͨ��������Ŀ�꼯�������һ�ڵ��µ����ͽṹ��һ��Map
 * @author ���
 * @since 2007-1-26
 * <p>ע��:���಻����Ŀ�꼯�ϵı仯����̬����,�����Ҫ�ù�����ʹ��
 * <code>TreeManagerTargetListener</code>ʵ��
 *
 */
public class TreeManager {

	private static Log log = LogFactory.getLog(TreeManager.class);
	 
	/**
	 * Ŀ�����ļ���,��ʼʱ����ͨ��<code>initLoadTargets</code>�������
	 */
	List<Component> targets;
	private ManagerImpl businessManager = new ManagerImpl();
	private Class targetClass;
	protected LinkedMap treeMap;
	
	private  ComponentImpl _component;
	
    /**
     * ��treeMap����Ӹ����ڵ����
     * @param component ���ڵ�,ʵ�ʱ���Ҳ��һ����
     */
    void addComponent(ComponentImpl component) {
		if (!treeMap.containsKey(component.getComponentName())) {
			if (_component != null) {
				synchronized (_component) {
					_component = component;
				}
			} else
				_component = component;

			if (!component.allComponents.contains(component))
				component.allComponents.add(component);

			List children = this.getChildren(component);
			if (children != null) {
				for (Iterator it = children.iterator(); it.hasNext();) {
					ComponentImpl child = (ComponentImpl) it.next();
					component.addComponent(child);
				}
			}
		} else {
			if (log.isDebugEnabled()) {
				log.warn("Menu '" + component.getComponentName()
						+ "' already exists in tree manager");
			}
		}

		treeMap.put(component.getComponentName(), component);
	}
    
    
    /**
     * ͨ��Ŀ�꼯�ϼ�����
     */
    void loadTree(){
    	treeMap = new LinkedMap();
    	for (Iterator iter = targets.iterator(); iter.hasNext();) {
			Component target = (Component) iter.next();
			ComponentImpl component = new ComponentImpl(target, this);
			addComponent(component);
		}
    }
    
    /**
     * ��ø����ڵ��µ������ӽڵ�,�����ڲ���װ
     * @param component �ڵ���
     * @return ���ظ����ڵ���ӽڵ㼯��
     */
   List<ComponentImpl> getChildren(ComponentImpl component){
    	Component parent = component.getTarget();
    	List<ComponentImpl> children = new ArrayList<ComponentImpl>();
    	for (Iterator iter = targets.iterator(); iter.hasNext();) {
			Component child = (Component) iter.next();
			if( child.getTargetParent() != null && child.getTargetParent().equals(parent)){
				ComponentImpl childImpl = new ComponentImpl(child, this);
				children.add(childImpl);
			}
		}
    	return children;
    	
    }
    
   /**
    * ��ø����ڵ��µ������ӽڵ�,�����ⲿ����
    * @param component ���ڵ�
    * @return ���ظ����ڵ���ӽڵ㼯��
    */   
   public List<Component> getChildren(Component component){
	   ComponentImpl parentComponent = (ComponentImpl)getTreeMap().get(component.getComponentName());
	   List<Component> components = parentComponent.getAllComponents();
   	return components;
   }
   
   /**
    * ��ø����ڵ��������ڽڵ�
    * @param component ���ڵ�
    * @return ���ظ����ڵ������(�ֵ�)�ڵ㼯��
    */
   public List<Component> getSibling(Component component){
	   List<Component> siblings = new ArrayList<Component>();
	   Component parentComponent = component.getTargetParent();
	   if(parentComponent == null)
		   return siblings;
	   for (Component sibling : targets) {
		   
		   if(sibling.equals(component))
			   continue;
		   
		   if(sibling.getTargetParent().equals(parentComponent))
			   siblings.add(sibling);
	}
	   return siblings;
   }
   
    /**
     * ��ʼ��ʱ���õķ���,�õõ�Ŀ�����ļ���
     */
    public void initLoadTargets(){
    	List result = businessManager.getObjects(targetClass);
    	targets = result;
    	this.loadTree();
    }
    
	/**
	 * �÷���Ϊϵͳ�ڲ�����,���ŵ�Ŀ�Ľ����ڵ�Ԫ����֮��,��Ӧ��ϵͳ�в�Ӧ���ø÷���
	 * @deprecated
	 */
	public List<Component> getTargets() {
		return targets;
	}

	/**
	 * �÷���Ϊϵͳ�ڲ�����,���ŵ�Ŀ�Ľ����ڵ�Ԫ����֮��,��Ӧ��ϵͳ�в�Ӧ���ø÷���
	 * @deprecated
	 */
	public void setTargets(List<Component> targets) {
		this.targets = targets;
	}


	synchronized ComponentImpl get_component() {
		return _component;
	}


	/**
	 * �õ��Խڵ�����Ϊkey,�Խڵ�Ϊvalue��һ��Map
	 * @return �Խڵ�����Ϊkey,�Խڵ�Ϊvalue��һ��Map
	 */
	 LinkedMap getTreeMap() {
		return treeMap;
	}


	/**
	 * Ŀ����������
	 * @return ����Ŀ����������
	 */
	public Class getTargetClass() {
		return targetClass;
	}


	public void setTargetClass(Class targetClass) {
		this.targetClass = targetClass;
	}

	public ManagerImpl getBusinessManager() {
		return businessManager;
	}


	/**
	 * @param businessManager
	 */
	public void setBusinessManager(ManagerImpl businessManager) {
		this.businessManager = businessManager;
	}




}
