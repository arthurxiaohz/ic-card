package org.hi.common.tools.highcharts;

import org.hi.common.tools.highcharts.context.HighChart;

/**
 * 图型执行器接口,该接口规范图型执行器的处理形式,针对不同的图型类型会有不同的图型执行器.
 * 例如饼型图的执行器为PieExecutor,曲线图的执行器为LineExecutor,柱形图的执行器为ColumnExecutor.这些是平台根据具体图型
 * 而提供的缺省执行器,通过实现该接口你也可以通过扩展的方式加入你自己的执行器
 * @author 张昊
 * @since 2011-08-18
 * @see org.hi.common.tools.highcharts.ChartProcessor
 * @see org.hi.common.tools.highcharts.impl.PieExecutor
 * @see org.hi.common.tools.highcharts.impl.LineExecutor
 * @see org.hi.common.tools.highcharts.impl.ColumnExecutor
 */
public interface ChartExecutor {

	/**
	 * 获取该执行器所对应的Highcharts的JSON对象
	 * @param containerName  容器名称,对应&lt;hi:chart&gt;标签中的id值
	 * @return 返回Highcharts的JSON对象
	 */
	public String toChartJson(String containerName);
	
	/**
	 * 返回代理对象,该对象的java结构体与Highcharts的JSON结构体完全相同,
	 * 通过对该代理对象做赋值操作就会影响Highcharts的JSON对象
	 * @return 返回HighChart代理对象
	 * @see org.hi.common.tools.highcharts.context.HighChart
	 */
	public HighChart getProxyObject();
}
