package org.hi.framework.security.context;

import org.hi.framework.context.HiEvent;;

/**
 * 部门数据变更对应于安全管理器重构树时所触发的事件
 * @author 张昊
 * @since 2007-1-27
 *
 */
public class SecurityOrgFilterEvent extends HiEvent {

	private static final long serialVersionUID = -6344771543305618940L;

	public SecurityOrgFilterEvent(Object source) {
		super(source);
	}

	

}
