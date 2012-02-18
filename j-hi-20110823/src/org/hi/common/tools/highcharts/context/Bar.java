package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Bar extends AbstractPlot implements Serializable,ChartSymbol {
	private String borderColor;
	private Integer borderRadius;
	private Integer borderWidth ;
	private Boolean colorByPoint ;
	private Double  groupPadding ;
	private Integer minPointLength ;
	private Double  pointPadding ;
	private Integer pointWidth;
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public Integer getBorderRadius() {
		return borderRadius;
	}
	public void setBorderRadius(Integer borderRadius) {
		this.borderRadius = borderRadius;
	}
	public Integer getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
	public Boolean getColorByPoint() {
		return colorByPoint;
	}
	public void setColorByPoint(Boolean colorByPoint) {
		this.colorByPoint = colorByPoint;
	}
	public Double getGroupPadding() {
		return groupPadding;
	}
	public void setGroupPadding(Double groupPadding) {
		this.groupPadding = groupPadding;
	}
	public Integer getMinPointLength() {
		return minPointLength;
	}
	public void setMinPointLength(Integer minPointLength) {
		this.minPointLength = minPointLength;
	}
	public Double getPointPadding() {
		return pointPadding;
	}
	public void setPointPadding(Double pointPadding) {
		this.pointPadding = pointPadding;
	}
	public Integer getPointWidth() {
		return pointWidth;
	}
	public void setPointWidth(Integer pointWidth) {
		this.pointWidth = pointWidth;
	}
	
	
}
