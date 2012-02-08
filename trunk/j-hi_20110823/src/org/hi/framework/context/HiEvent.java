package org.hi.framework.context;

import org.springframework.context.ApplicationEvent;

/**
 * 该类继承Spring的<code>ApplicationEvent</code>类,
 * 目的是所有Hi平台中事件的终级超类,注意该是一个抽象类自身不能实例化
 * @author 张昊
 * @since 2007-1-31
 *
 */
public abstract class HiEvent extends ApplicationEvent {

	public HiEvent(Object source) {
		super(source);
	}
	
}
