package org.hi.base.tree;

import java.util.List;

import org.hi.framework.context.HiEvent;
import org.hi.framework.service.impl.ManagerImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * <code>TreeManager</code>类的扩展.本类的作用是在<code>TreeManager</code>类的基础
 * 上增加一个监听器,用以目标对象发生变化时重构树
 * <p>注意:为了实现对目标对象变更的监听,必须在目标对象变更发布一个事件.本类监听器的条件为事件
 * 必须为<code>HiEvent</code>类型,而且事件的源对象必须实现<code>Component</code>接口
 * @see org.hi.base.tree.TreeManager
 * @see org.hi.framework.context.HiEvent
 * @see org.hi.base.tree.Component
 * @author 张昊
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
