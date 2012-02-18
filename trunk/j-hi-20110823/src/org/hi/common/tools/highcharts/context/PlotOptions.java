package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class PlotOptions implements Serializable,ChartSymbol {
	private Area area;
	private Areaspline areaspline;
	private Bar bar;
	private Column column;
	private Line line;
	private Pie pie;
	private Series series;
	private Scatter scatter;
	private Spline spline;
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Areaspline getAreaspline() {
		return areaspline;
	}
	public void setAreaspline(Areaspline areaspline) {
		this.areaspline = areaspline;
	}
	public Bar getBar() {
		return bar;
	}
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	public Column getColumn() {
		return column;
	}
	public void setColumn(Column column) {
		this.column = column;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Pie getPie() {
		return pie;
	}
	public void setPie(Pie pie) {
		this.pie = pie;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public Scatter getScatter() {
		return scatter;
	}
	public void setScatter(Scatter scatter) {
		this.scatter = scatter;
	}
	public Spline getSpline() {
		return spline;
	}
	public void setSpline(Spline spline) {
		this.spline = spline;
	}
	
	
	
}
