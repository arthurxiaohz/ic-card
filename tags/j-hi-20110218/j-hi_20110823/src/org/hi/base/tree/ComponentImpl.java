package org.hi.base.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * �ϳɣ�Composite��ģʽ��Component�ľ���ʵ����.
 * ͨ��������Եõ���ǰ�ڵ��µ�һ���ӽڵ�,��������ڵ�.�ɴ˿��Կ���ÿ���ڵ㶼��һ�ö�����ɵ���.
 * @author ���
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
     * Ϊ��ǰ�ڵ�����ӽڵ�
     * @param childComponent ��ǰ�ڵ��µ��ӽڵ�
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
	 * Ϊ��ǰ�ڵ��踸�ڵ�
	 * @param parentComponent ��ǰ�ڵ�ĸ��ڵ�
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
	 * ��ǰ�ڵ��µ�һ���ӽڵ�.
	 * ע��:��������ǰ�ڵ�
	 * @return ���ص�ǰ�ڵ��µ�һ���ӽڵ�ļ���
	 */
	public List<Component> getComponents() {
		return components;
	}

	public String toString(){
		return this.getComponentName();
	}

	/**
	 * ��ǰ�ڵ��µ���������ڵ�.
	 * ע��:������ǰ�ڵ�
	 * @return ���ص�ǰ�ڵ�����������ڵ�ļ���
	 */
	public List<Component> getAllComponents() {
		return allComponents;
	}
}
