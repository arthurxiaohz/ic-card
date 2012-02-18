package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.List;

import org.hi.common.tools.highcharts.HighChartType;
import org.hi.common.tools.highcharts.core.Function;

public class SeriesCollecton implements Serializable {
	private List<Object> data;
	private Function dataParser;
	private String dataURL;
	private String name;
	private Integer stack;
	private String type = HighChartType.TYPE_LINE;
	private Double xAxis;
	private Double yAxis;
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public Function getDataParser() {
		return dataParser;
	}
	public void setDataParser(Function dataParser) {
		this.dataParser = dataParser;
	}
	public String getDataURL() {
		return dataURL;
	}
	public void setDataURL(String dataURL) {
		this.dataURL = dataURL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStack() {
		return stack;
	}
	public void setStack(Integer stack) {
		this.stack = stack;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getXAxis() {
		return xAxis;
	}
	public void setXAxis(Double axis) {
		xAxis = axis;
	}
	public Double getYAxis() {
		return yAxis;
	}
	public void setYAxis(Double axis) {
		yAxis = axis;
	}
}
