package org.hi.framework.context;

import org.springframework.context.ApplicationEvent;

/**
 * ����̳�Spring��<code>ApplicationEvent</code>��,
 * Ŀ��������Hiƽ̨���¼����ռ�����,ע�����һ��������������ʵ����
 * @author ���
 * @since 2007-1-31
 *
 */
public abstract class HiEvent extends ApplicationEvent {

	public HiEvent(Object source) {
		super(source);
	}
	
}
