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
 * ��״ͼִ����
 * @author ���
 * @since 2011-08-18
 */
public class ColumnExecutor extends AbstractChartExecutor {
	
	/**
	 * ��״ͼִ������������
	 * @param tilte ��������
	 * @param categories x���ʶ����
	 * @param yAxisTitle y�����
	 * @param unit ��ʾ�ĵ�λ,����Ԫ���ֵ�
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
	 * ���ά���е����ݵ�Ԫ
	 * @param name ά������
	 * @param value ά�������ݼ���List&lt;Point&gt;�е�һ����Ԫֵ
	 * @return ���������ӵ�ά�����ݵ�Ԫ��Point����
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
	 * ����һ��ά��(ϵ��),һ��ά�Ⱦ���һ���۲���������ĵ�����ɼ���������ÿ���¶ȵȡ���֮һ��ά�Ⱦ���һ�����ݲ�Ϊ��������
	 * ��һ������
	 * @param name ά�ȵ�����
	 * @param data ά�ȵ����ݼ���List&lt;Double&gt;
	 * @return ����һ��ά��SeriesElement����
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
