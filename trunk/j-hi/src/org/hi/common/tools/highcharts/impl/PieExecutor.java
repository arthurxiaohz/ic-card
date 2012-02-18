package org.hi.common.tools.highcharts.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.hi.common.tools.highcharts.context.DataLabel;
import org.hi.common.tools.highcharts.context.Pie;
import org.hi.common.tools.highcharts.context.Point;
import org.hi.common.tools.highcharts.context.SeriesElement;
import org.hi.common.tools.highcharts.core.Function;
import org.hi.common.util.CollectionUtils;

/**
 * ����ͼִ����
 * @author ���
 * @since 2011-08-18
 */
public class PieExecutor extends AbstractChartExecutor{

	/**
	 * ����ͼִ������������
	 * @param title ������
	 */
	public PieExecutor(String title){
		init();
		highchart.getTitle().setText(title);
		
		highchart.getTooltip().setFormatter(new Function("return '<b>'+ this.point.name +'</b>: '+ this.point.x;"));
		
		Pie pie = new Pie();
		highchart.getPlotOptions().setPie(pie);
		pie.setAllowPointSelect(true);
		pie.setCursor("pointer");
		DataLabel dataLabels = new DataLabel();
		pie.setDataLabels(dataLabels);
		dataLabels.setEnabled(true);
		dataLabels.setColor("#000000");
		dataLabels.setConnectorColor("#000000");
		dataLabels.setFormatter(new Function("return '<b>'+ this.point.name +'</b>: '+ this.point.y +' %';"));
		pie.setShowInLegend(true);
		addSeries(null, new ArrayList<Point>());
	}
	
	/**
	 * ���ά���е����ݵ�Ԫ
	 * @param name ά������
	 * @param value ά�������ݼ���List&lt;Point&gt;�е�һ����Ԫֵ
	 * @return ���������ӵ�ά�����ݵ�Ԫ��Point����
	 */
	public Point addSeriesDataElement(String name , Double value){
		Point seriesDataElement = new Point();
		seriesDataElement.setName(name);
		seriesDataElement.setX(value);
		seriesDataElement.setY(value);
		SeriesElement firstSeriesElement = highchart.getSeries().get(0);
		firstSeriesElement.getData().add(seriesDataElement);
		return seriesDataElement;
	}
	
	/**
	 * @deprecated
	 */
	protected SeriesElement addSeries(String name, List<Point> data){
		SeriesElement series = super.addSeries(name, data);
		series.setType("pie");
		return series;
	}
	
	/* (non-Javadoc)
	 * @see org.hi.common.tools.highcharts.impl.AbstractChartExecutor#toChartJson(java.lang.String)
	 */
	public String toChartJson(String containerName){
		
		List<SeriesElement>  series = highchart.getSeries();
		for (SeriesElement seriesElement : series) {
			
			Double all = CollectionUtils.getPropertySum(seriesElement.getData(), "x");
			List<Point> data = seriesElement.getData();
			for (Point point : data) {
				Double y = point.getX() / all * 100;
				DecimalFormat df1 = new DecimalFormat("###.##");
				point.setY(new Double(df1.format(y)));
			}
		}
		
		return super.toChartJson(containerName);
	}
	
}
