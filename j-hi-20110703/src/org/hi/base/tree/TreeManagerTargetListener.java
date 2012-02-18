package org.hi.base.tree;

import java.util.List;

import org.hi.framework.context.HiEvent;
import org.hi.framework.service.impl.ManagerImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * <code>TreeManager</code>�����չ.�������������<code>TreeManager</code>��Ļ���
 * ������һ��������,����Ŀ��������仯ʱ�ع���
 * <p>ע��:Ϊ��ʵ�ֶ�Ŀ��������ļ���,������Ŀ�����������һ���¼�.���������������Ϊ�¼�
 * ����Ϊ<code>HiEvent</code>����,�����¼���Դ�������ʵ��<code>Component</code>�ӿ�
 * @see org.hi.base.tree.TreeManager
 * @see org.hi.framework.context.HiEvent
 * @see org.hi.base.tree.Component
 * @author ���
 * @since 2007-1-31
 */
public class TreeManagerTargetListener extends TreeManager implements
		ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof HiEvent){
			HiEvent hiEvent = (HiEvent)event;
			Object source = hiEvent.getSource();
			
			if(source instanceof Component && source.getClass().equals(getTargetClass())){
				ManagerImpl manager = this.getBusinessManager();
				List<Component> targets = manager.getObjects(getTargetClass());
				this.targets = targets;
				this.loadTree();
			}
		}

	}



}
