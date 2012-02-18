package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;
import org.hi.common.tools.highcharts.core.Function;

public class Legend implements Serializable ,ChartSymbol{
	private String align = "center";
	private String backgroundColor;
	private String borderColor = "#909090";
	private Integer borderRadius = 5;
	private Integer borderWidth  = 1;
	private Boolean enabled = true;
	private Boolean floating  = true;
	private CSSObject itemHiddenStyle;
	private CSSObject itemHoverStyle;
	private CSSObject itemStyle;
	private Integer itemWidth;
	private String layout = "horizontal";
	private Function labelFormatter;
	private Integer lineHeight;
	private Integer margin;
	private Boolean reversed  = false;
	private Boolean shadow  = false;
	private CSSObject style;
	private Integer symbolPadding = 5;
	private Integer symbolWidth = 30;
	private String verticalAlign = "bottom";
	private Integer width;
	private Integer x = 15;
	private Integer y = 0;
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
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
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getFloating() {
		return floating;
	}
	public void setFloating(Boolean floating) {
		this.floating = floating;
	}
	public CSSObject getItemHiddenStyle() {
		return itemHiddenStyle;
	}
	public void setItemHiddenStyle(CSSObject itemHiddenStyle) {
		this.itemHiddenStyle = itemHiddenStyle;
	}
	public CSSObject getItemHoverStyle() {
		return itemHoverStyle;
	}
	public void setItemHoverStyle(CSSObject itemHoverStyle) {
		this.itemHoverStyle = itemHoverStyle;
	}
	public CSSObject getItemStyle() {
		return itemStyle;
	}
	public void setItemStyle(CSSObject itemStyle) {
		this.itemStyle = itemStyle;
	}
	public Integer getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(Integer itemWidth) {
		this.itemWidth = itemWidth;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public Function getLabelFormatter() {
		return labelFormatter;
	}
	public void setLabelFormatter(Function labelFormatter) {
		this.labelFormatter = labelFormatter;
	}
	public Integer getLineHeight() {
		return lineHeight;
	}
	public void setLineHeight(Integer lineHeight) {
		this.lineHeight = lineHeight;
	}
	public Integer getMargin() {
		return margin;
	}
	public void setMargin(Integer margin) {
		this.margin = margin;
	}
	public Boolean getReversed() {
		return reversed;
	}
	public void setReversed(Boolean reversed) {
		this.reversed = reversed;
	}
	public Boolean getShadow() {
		return shadow;
	}
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	public Integer getSymbolPadding() {
		return symbolPadding;
	}
	public void setSymbolPadding(Integer symbolPadding) {
		this.symbolPadding = symbolPadding;
	}
	public Integer getSymbolWidth() {
		return symbolWidth;
	}
	public void setSymbolWidth(Integer symbolWidth) {
		this.symbolWidth = symbolWidth;
	}
	public String getVerticalAlign() {
		return verticalAlign;
	}
	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
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
	
	
	
	
}
