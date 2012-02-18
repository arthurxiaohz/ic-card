package org.hi.base.schedule.context;

import org.hi.framework.context.HiEvent;

/**
 * 与任务调度相关在持久层上的变化(主要是与任务调度相关的数据定义),均会触发该
 * 事件
 * @author 张昊
 * @since 2007-09-19
 *
 */
public class ScheduleDefChangeEvent extends HiEvent {

	public ScheduleDefChangeEvent(Object source) {
		super(source);
	}

}
