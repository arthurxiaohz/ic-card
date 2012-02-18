package org.hi.base.tree;

/**
 * �ó������Ƕ�<code>Component</code>�ӿڵļ�ʵ��.
 * ���ڸ����µ����г�Ա���Ե���������������<code>ComponentImpl</code>�Ĵ������������
 * @author ���
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
