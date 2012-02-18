package org.hi.common.tools.highcharts.impl;

import java.util.ArrayList;
import java.util.List;

import org.hi.common.tools.highcharts.HighChartType;
import org.hi.common.tools.highcharts.context.Axis;
import org.hi.common.tools.highcharts.context.Column;
import org.hi.common.tools.highcharts.context.DataLabel;
import org.hi.common.tools.highcharts.context.Point;
import org.hi.common.tools.highcharts.context.SeriesElement;
import org.hi.common.tools.highcharts.context.Title;
import org.hi.common.tools.highcharts.core.Function;

/**
 * 柱状图执行器
 * @author 张昊
 * @since 2011-08-18
 */
public class ColumnExecutor extends AbstractChartExecutor {
	
	/**
	 * 柱状图执行器构建函数
	 * @param tilte 标题名称
	 * @param categories x轴标识集合
	 * @param yAxisTitle y轴标题
	 * @param unit 显示的单位,比如元、吨等
	 */
	public ColumnExecutor(String tilte, List<String> categories, String yAxisTitle, String unit){
		init();
		highchart.getTitle().setText(tilte);
		highchart.getChart().setDefaultSeriesType(HighChartType.TYPE_COLUMN);
		
		if(unit == null)
			unit = "";
		else
			unit = "'" + unit + "'";
		highchart.getTooltip().setFormatter(new Function("return '<b>'+ this.series.name +'</b><br/>'+this.x +': '+ this.y +"+unit+";"));
		
		Column column = new Column();
		highchart.getPlotOptions().setColumn(column);
		column.setEnableMouseTracking(true);
		DataLabel dataLabels = new DataLabel();
		column.setDataLabels(dataLabels);
		dataLabels.setEnabled(true);
		
		
		highchart.setxAxis(new Axis());
		highchart.getxAxis().setCategories(categories);
		
		highchart.setyAxis(new Axis());
		highchart.getyAxis().setTitle(new Title());
		highchart.getyAxis().getTitle().setText(yAxisTitle);
		
		highchart.setSeries(new ArrayList<SeriesElement>());
	}
	
	/**
	 * 添加维度中的数据单元
	 * @param name 维度名称
	 * @param value 维度中数据集合List&lt;Point&gt;中的一个单元值
	 * @return 返回所增加的维度数据单元的Point对象
	 */
	public SeriesElement addSeriesDataElement(String name , Double value){
		List<SeriesElement> series = highchart.getSeries();
		SeriesElement seriesElement = null;
		for (SeriesElement _seriesElement : series) {
			if(_seriesElement.getName().equals(name)){
				seriesElement = _seriesElement;
				break;
			}
		}
		
		if(seriesElement == null){
			seriesElement = new SeriesElement();
			seriesElement.setName(name);
			series.add(seriesElement);
		}
		
		if(seriesElement.getData() == null)
			seriesElement.setData(new ArrayList<Point>());
		
		List<Point> data = seriesElement.getData();
		Point point = new Point();
		point.setY(value);
		data.add(point);
		
		return seriesElement;
	}
	
	
	/**
	 * 增加一个维度(系列),一个维度就是一个观查点例如语文的历年成绩、北京的每天温度等。总之一个维度就是一组数据并为这组数据
	 * 起一个名字
	 * @param name 维度的名称
	 * @param data 维度的数据集合List&lt;Double&gt;
	 * @return 返回一个维度SeriesElement对象
	 */
	public SeriesElement addSerieElement(String name, List<Double> data){
		List<Point> pointData = new ArrayList<Point>();
		for (Double element : data) {
			Point point = new Point();
			point.setY(element);
			pointData.add(point);
		}
		
		return super.addSeries(name, pointData);
		
	}
}
