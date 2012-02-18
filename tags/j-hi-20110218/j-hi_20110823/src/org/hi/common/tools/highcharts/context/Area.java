package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Area extends AbstractPlot implements Serializable,ChartSymbol {
	private String fillColor;
	private Double fillOpacity;
	private String lineColor;
	private Integer threshold;

	
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	public Double getFillOpacity() {
		return fillOpacity;
	}
	public void setFillOpacity(Double fillOpacity) {
		this.fillOpacity = fillOpacity;
	}
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public Integer getThreshold() {
		return threshold;
	}
	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	
	
	
}
