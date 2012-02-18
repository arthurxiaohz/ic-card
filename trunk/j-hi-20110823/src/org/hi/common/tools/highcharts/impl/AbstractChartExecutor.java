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
	 * ����һ��ά��(ϵ��),һ��ά�Ⱦ���һ���۲���������ĵ�����ɼ���������ÿ���¶ȵȡ���֮һ��ά�Ⱦ���һ�����ݲ�Ϊ��������
	 * ��һ������
	 * @param name ά�ȵ�����
	 * @param data ά�ȵ����ݼ���,��ֵ��ӦPoint����y����
	 * @return ����һ��ά��SeriesElement����
	 */
	protected SeriesElement addSeries(String name, List<Point> data){
		SeriesElement element = new SeriesElement();
		element.setName(name);
		element.setData(data);
		highchart.getSeries().add(element);
		return element;
	}
	
	/**
	 * ������ͼ���ӱ��������
	 * @param subTitle �ӱ�����
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
