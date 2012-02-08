package org.hi.base.tree;

/**
 * 该抽象类是对<code>Component</code>接口的简单实现.
 * 对于该类下的所有成员属性的设置是在其子类<code>ComponentImpl</code>的创建函数中完成
 * @author 张昊
 * @since 2007-1-27
 * @see org.hi.base.tree.Component
 *
 */
public abstract class AbstractComponent implements Component {
	private String componentName;
	private Component targetParent;
	private Component target;
	
	/* (non-Javadoc)
	 * @see org.hi.common.tree.Component#getComponentName()
	 */
	public String getComponentName() {
		return this.componentName;
	}

	/* (non-Javadoc)
	 * @see org.hi.common.tree.Component#getTarget()
	 */
	public Component getTarget() {
		return this.target;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.common.tree.Component#getTargetParent()
	 */
	public Component getTargetParent() {
		return this.targetParent;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public void setTarget(Component target) {
		this.target = target;
	}

	public void setTargetParent(Component targetParent) {
		this.targetParent = targetParent;
	}

}
