package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;
import org.hi.common.tools.highcharts.core.Function;

public class DataLabel implements Serializable,ChartSymbol{
	private String align;
	private String color;
	private Boolean enabled;
	private Function formatter;
	private Integer rotation;
	private String connectorColor;
	private String staggerLines;
	private Integer step;
	private CSSObject style;
	private Integer x;
	private Integer y;
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public Integer getRotation() {
		return rotation;
	}
	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}
	public String getStaggerLines() {
		return staggerLines;
	}
	public void setStaggerLines(String staggerLines) {
		this.staggerLines = staggerLines;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public String getConnectorColor() {
		return connectorColor;
	}
	public void setConnectorColor(String connectorColor) {
		this.connectorColor = connectorColor;
	}
	
	
	
}
