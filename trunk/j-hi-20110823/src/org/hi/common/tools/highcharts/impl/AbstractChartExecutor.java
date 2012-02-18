package org.hi.common.tools.highcharts.impl;

import java.util.List;

import org.hi.common.tools.highcharts.ChartExecutor;
import org.hi.common.tools.highcharts.context.HighChart;
import org.hi.common.tools.highcharts.context.Point;
import org.hi.common.tools.highcharts.context.SeriesElement;
import org.hi.common.tools.highcharts.context.Subtitle;

public abstract class  AbstractChartExecutor implements ChartExecutor {
	protected HighChart highchart;
	protected void init(){
		highchart = new HighChart();
	}
	
	/* (non-Javadoc)
	 * @see org.hi.common.tools.highcharts.ChartExecutor#getProxyObject()
	 */
	public HighChart getProxyObject(){
		return highchart;
	}
	
	/**
	 * 增加一个维度(系列),一个维度就是一个观查点例如语文的历年成绩、北京的每天温度等。总之一个维度就是一组数据并为这组数据
	 * 起一个名字
	 * @param name 维度的名称
	 * @param data 维度的数据集合,其值对应Point对象y属性
	 * @return 返回一个维度SeriesElement对象
	 */
	protected SeriesElement addSeries(String name, List<Point> data){
		SeriesElement element = new SeriesElement();
		element.setName(name);
		element.setData(data);
		highchart.getSeries().add(element);
		return element;
	}
	
	/**
	 * 设置子图中子标题的内容
	 * @param subTitle 子标题名
	 */
	public void setSubTitle(String subTitle){
		Subtitle subtitle = new Subtitle();
		subtitle.setText(subTitle);
		highchart.setSubtitle(subtitle);
	}
	
	/* (non-Javadoc)
	 * @see org.hi.common.tools.highcharts.ChartExecutor#toChartJson(java.lang.String)
	 */
	public String toChartJson(String containerName) {
		if(containerName == null)
			containerName = "container";
		highchart.getChart().setRenderTo(containerName);
		return ChartEnginer.getChart2JSON(highchart);
	}
	
	
	

}
