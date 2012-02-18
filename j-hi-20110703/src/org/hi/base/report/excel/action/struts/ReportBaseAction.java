package org.hi.base.report.excel.action.struts;

import java.util.Map;

import org.hi.framework.web.struts.BaseAction;


/**
 * 该类是所有报表action的超类.也是一个策略类,由它来决定所调用的报表引擎.
 * <p>作用是为报表收集相关展示数据,并将收集好的数据传递到相应的报表引擎中,
 * 最终由报表引擎将数据展示成报表
 * @author 张昊
 * @since 2007-10-23
 *
 */   

public abstract class ReportBaseAction extends BaseAction{
	
	/**
	 * 该方法是底层方法,由于收集报表要展示的数据
	 * @param model 数据模形,是一个<code>Map</code>key:对象名,value:对象
	 */
	abstract void mergedOutputModel(Map<String, Object> model);
	
	/**
	 * 回调方法,用于获取具体类中准备的数据.
	 * 您只要实现该方法，将数据对象指向当前action的属性中即可.
	 * 当然action对这些属性要提供设置器与访问器,即get/set方法
	 */
	public abstract void prepare();
	
	
}
