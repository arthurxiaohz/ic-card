package org.hi.common.tools.highcharts.context;

import java.util.List;

public class Pie extends AbstractPlot {
	private String borderColor;
	private Integer borderWidth;
	private List<String> center;
	private String innerSize;
	private Boolean showInLegend;
	private String size;
	private Integer slicedOffset;
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public Integer getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
	public List<String> getCenter() {
		return center;
	}
	public void setCenter(List<String> center) {
		this.center = center;
	}
	public String getInnerSize() {
		return innerSize;
	}
	public void setInnerSize(String innerSize) {
		this.innerSize = innerSize;
	}
	public Boolean getShowInLegend() {
		return showInLegend;
	}
	public void setShowInLegend(Boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getSlicedOffset() {
		return slicedOffset;
	}
	public void setSlicedOffset(Integer slicedOffset) {
		this.slicedOffset = slicedOffset;
	}
	
}
