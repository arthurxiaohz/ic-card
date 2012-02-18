package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.List;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;
import org.hi.common.tools.highcharts.core.Function;

public class Tooltip implements Serializable,ChartSymbol {
	private String backgroundColor;
	private String borderColor;
	private Integer borderRadius;
	private Integer borderWidth;
	private List crosshairs;
	private Boolean enabled;
	private Function formatter;
	private Boolean shadow;
	private Boolean shared;
	private Double snap;
	private CSSObject style;
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
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
	public List getCrosshairs() {
		return crosshairs;
	}
	public void setCrosshairs(List crosshairs) {
		this.crosshairs = crosshairs;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Function getFormatter() {
		return formatter;
	}
	public void setFormatter(Function formatter) {
		this.formatter = formatter;
	}
	public Boolean getShadow() {
		return shadow;
	}
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}
	public Boolean getShared() {
		return shared;
	}
	public void setShared(Boolean shared) {
		this.shared = shared;
	}
	public Double getSnap() {
		return snap;
	}
	public void setSnap(Double snap) {
		this.snap = snap;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
		
		
	
}
