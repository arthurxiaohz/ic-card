package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hi.common.tools.ChartSymbol;

public class HighChart implements Serializable,ChartSymbol{
	private Chart chart = new Chart();
	private Credit credits = new Credit();
	private Global global;
	private Label labels;
	private Legend legend;
	private Loading loading;
	private PlotOptions plotOptions = new PlotOptions();
	private Point point;
	private List<SeriesElement> series = new ArrayList<SeriesElement>();
	private Subtitle subtitle;
	private Title title =new Title();
	private Tooltip tooltip = new Tooltip();
	private Axis xAxis;
	private Axis yAxis;
	private Exporting exporting;
	public Chart getChart() {
		return chart;
	}
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	public Credit getCredits() {
		return credits;
	}
	public void setCredits(Credit credits) {
		this.credits = credits;
	}
	public Global getGlobal() {
		return global;
	}
	public void setGlobal(Global global) {
		this.global = global;
	}
	public Label getLabels() {
		return labels;
	}
	public void setLabels(Label labels) {
		this.labels = labels;
	}
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public Loading getLoading() {
		return loading;
	}
	public void setLoading(Loading loading) {
		this.loading = loading;
	}
	public PlotOptions getPlotOptions() {
		return plotOptions;
	}
	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public List<SeriesElement> getSeries() {
		return series;
	}
	public void setSeries(List<SeriesElement> series) {
		this.series = series;
	}
	public Subtitle getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Tooltip getTooltip() {
		return tooltip;
	}
	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}
	public Axis getxAxis() {
		return xAxis;
	}
	public void setxAxis(Axis axis) {
		xAxis = axis;
	}
	public Axis getyAxis() {
		return yAxis;
	}
	public void setyAxis(Axis axis) {
		yAxis = axis;
	}
	public Exporting getExporting() {
		return exporting;
	}
	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
	}
	
}
