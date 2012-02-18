package org.hi.base.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.service.impl.ManagerImpl;

/**
 * 该类是组织树型结构的管理器.
 * 通过给定的目标集合组成任一节点下的树型结构的一个Map
 * @author 张昊
 * @since 2007-1-26
 * <p>注意:该类不能随目标集合的变化而动态更新,如果需要该功能请使用
 * <code>TreeManagerTargetListener</code>实例
 *
 */
public class TreeManager {

	private static Log log = LogFactory.getLog(TreeManager.class);
	 
	/**
	 * 目标对象的集合,初始时可以通过<code>initLoadTargets</code>方法获得
	 */
	List<Component> targets;
	private ManagerImpl businessManager = new ManagerImpl();
	private Class targetClass;
	protected LinkedMap treeMap;
	
	private  ComponentImpl _component;
	
    /**
     * 向treeMap中添加给定节点的树
     * @param component 树节点,实际本身也是一棵树
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
     * 通过目标集合加载树
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
     * 获得给定节点下的所有子节点,用于内部封装
     * @param component 节点树
     * @return 返回给定节点的子节点集合
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
    * 获得给定节点下的所有子节点,用于外部调用
    * @param component 树节点
    * @return 返回给定节点的子节点集合
    */   
   public List<Component> getChildren(Component component){
	   ComponentImpl parentComponent = (ComponentImpl)getTreeMap().get(component.getComponentName());
	   List<Component> components = parentComponent.getAllComponents();
   	return components;
   }
   
   /**
    * 获得给定节点所有相邻节点
    * @param component 树节点
    * @return 返回给定节点的相邻(兄弟)节点集合
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
     * 初始化时调用的方法,用得到目标对象的集合
     */
    public void initLoadTargets(){
    	List result = businessManager.getObjects(targetClass);
    	targets = result;
    	this.loadTree();
    }
    
	/**
	 * 该方法为系统内部方法,开放的目的仅用于单元测试之用,在应用系统中不应调用该方法
	 * @deprecated
	 */
	public List<Component> getTargets() {
		return targets;
	}

	/**
	 * 该方法为系统内部方法,开放的目的仅用于单元测试之用,在应用系统中不应调用该方法
	 * @deprecated
	 */
	public void setTargets(List<Component> targets) {
		this.targets = targets;
	}


	synchronized ComponentImpl get_component() {
		return _component;
	}


	/**
	 * 得到以节点名称为key,以节点为value的一个Map
	 * @return 以节点名称为key,以节点为value的一个Map
	 */
	 LinkedMap getTreeMap() {
		return treeMap;
	}


	/**
	 * 目标对象的类型
	 * @return 返回目标对象的类型
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
