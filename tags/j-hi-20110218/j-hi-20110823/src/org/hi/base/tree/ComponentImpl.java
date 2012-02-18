package org.hi.base.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 合成（Composite）模式中Component的具体实现类.
 * 通过该类可以得到当前节点下的一级子节点,所有子孙节点.由此可以看出每个节点都是一棵独立完成的树.
 * @author 张昊
 * @since 2007-1-26
 * @see org.hi.base.tree.Component
 */
public class ComponentImpl extends AbstractComponent {

    protected List<Component> components = Collections.synchronizedList(new ArrayList<Component>());
    protected List<Component> allComponents = Collections.synchronizedList(new ArrayList<Component>());
    protected Component parentComponent;
    private TreeManager treeMgr;
    
    ComponentImpl(Component component, TreeManager treeMgr){
    	this.setComponentName(component.getComponentName());
    	this.setTarget(component.getTarget());
    	this.setTargetParent(component.getTargetParent());
    	this.treeMgr = treeMgr;
    }
    
    /**
     * 为当前节点添加子节点
     * @param childComponent 当前节点下的子节点
     */
    public void addComponent(ComponentImpl childComponent) {
        if ((childComponent.getComponentName() == null) || (childComponent.getComponentName().equals(""))) {
        	childComponent.setComponentName(this.getComponentName() + components.size());
        }

        if (!components.contains(childComponent)) {
            components.add(childComponent);
        if (!allComponents.contains(childComponent))
            	allComponents.add(childComponent);
        
            childComponent.setParentComponent(this);
        }
    }

	/**
	 * 为当前节点设父节点
	 * @param parentComponent 当前节点的父节点
	 */
	void setParentComponent(ComponentImpl parentComponent) {
        if (parentComponent != null) {
        	
            if (!parentComponent.getComponents().contains(this)) {
            	parentComponent.addComponent(this);
            }
            
            List children = treeMgr.getChildren(this);
            if (children != null) {
                for (Iterator it = children.iterator(); it.hasNext();) {
                    ComponentImpl child = (ComponentImpl) it.next();
                    
                    if (!treeMgr.get_component().allComponents.contains(child))
                    	treeMgr.get_component().allComponents.add(child);
                    
                    this.addComponent(child);
                }
            }
        }
        this.parentComponent = parentComponent;
	}

	public Component getParentComponent() {
		return parentComponent;
	}
	
	/**
	 * 当前节点下的一级子节点.
	 * 注意:不包括当前节点
	 * @return 返回当前节点下的一级子节点的集合
	 */
	public List<Component> getComponents() {
		return components;
	}

	public String toString(){
		return this.getComponentName();
	}

	/**
	 * 当前节点下的所有子孙节点.
	 * 注意:包括当前节点
	 * @return 返回当前节点下所有子孙节点的集合
	 */
	public List<Component> getAllComponents() {
		return allComponents;
	}
}
