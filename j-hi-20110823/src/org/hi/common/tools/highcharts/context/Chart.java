package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.HighChartType;
import org.hi.common.tools.highcharts.core.CSSObject;


public class Chart implements Serializable,ChartSymbol{
	private Boolean alignTicks;
	private Boolean animation;
	private String backgroundColor;
	private String borderColor;
	private Integer borderRadius;
	private Integer borderWidth;
	private String className;
	private String defaultSeriesType;
	private Events events;
	private Integer height;
	private Boolean ignoreHiddenSeries;
	private Boolean inverted;
	private List<Integer> margin;
	private Integer marginTop;
	private Integer marginRight;
	private Integer marginBottom;
	private Integer marginLeft;
	private String plotBackgroundColor;
	private String plotBackgroundImage;
	private String plotBorderColor;
	private Integer plotBorderWidth;
	private Boolean plotShadow;
	private Boolean reflow;
	private String renderTo;
	private Boolean shadow;
	private Boolean showAxes;
	private Integer spacingTop;
	private Integer spacingRight;
	private Integer spacingBottom;
	private Integer spacingLeft;
	private CSSObject style;
	private String type;
	private Integer width;
	private String zoomType;
	
	public Boolean getAlignTicks() {
		return alignTicks;
	}
	public void setAlignTicks(Boolean alignTicks) {
		this.alignTicks = alignTicks;
	}
	public Boolean getAnimation() {
		return animation;
	}
	public void setAnimation(Boolean animation) {
		this.animation = animation;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDefaultSeriesType() {
		return defaultSeriesType;
	}
	public void setDefaultSeriesType(String defaultSeriesType) {
		this.defaultSeriesType = defaultSeriesType;
	}
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Boolean getIgnoreHiddenSeries() {
		return ignoreHiddenSeries;
	}
	public void setIgnoreHiddenSeries(Boolean ignoreHiddenSeries) {
		this.ignoreHiddenSeries = ignoreHiddenSeries;
	}
	public Boolean getInverted() {
		return inverted;
	}
	public void setInverted(Boolean inverted) {
		this.inverted = inverted;
	}
	public List<Integer> getMargin() {
		return margin;
	}
	public void setMargin(List<Integer> margin) {
		this.margin = margin;
	}
	public Integer getMarginTop() {
		return marginTop;
	}
	public void setMarginTop(Integer marginTop) {
		this.marginTop = marginTop;
	}
	public Integer getMarginRight() {
		return marginRight;
	}
	public void setMarginRight(Integer marginRight) {
		this.marginRight = marginRight;
	}
	public Integer getMarginBottom() {
		return marginBottom;
	}
	public void setMarginBottom(Integer marginBottom) {
		this.marginBottom = marginBottom;
	}
	public Integer getMarginLeft() {
		return marginLeft;
	}
	public void setMarginLeft(Integer marginLeft) {
		this.marginLeft = marginLeft;
	}
	public String getPlotBackgroundColor() {
		return plotBackgroundColor;
	}
	public void setPlotBackgroundColor(String plotBackgroundColor) {
		this.plotBackgroundColor = plotBackgroundColor;
	}
	public String getPlotBackgroundImage() {
		return plotBackgroundImage;
	}
	public void setPlotBackgroundImage(String plotBackgroundImage) {
		this.plotBackgroundImage = plotBackgroundImage;
	}
	public String getPlotBorderColor() {
		return plotBorderColor;
	}
	public void setPlotBorderColor(String plotBorderColor) {
		this.plotBorderColor = plotBorderColor;
	}
	public Integer getPlotBorderWidth() {
		return plotBorderWidth;
	}
	public void setPlotBorderWidth(Integer plotBorderWidth) {
		this.plotBorderWidth = plotBorderWidth;
	}
	public Boolean getPlotShadow() {
		return plotShadow;
	}
	public void setPlotShadow(Boolean plotShadow) {
		this.plotShadow = plotShadow;
	}
	public Boolean getReflow() {
		return reflow;
	}
	public void setReflow(Boolean reflow) {
		this.reflow = reflow;
	}
	public String getRenderTo() {
		return renderTo;
	}
	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}
	public Boolean getShadow() {
		return shadow;
	}
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}
	public Boolean getShowAxes() {
		return showAxes;
	}
	public void setShowAxes(Boolean showAxes) {
		this.showAxes = showAxes;
	}
	public Integer getSpacingTop() {
		return spacingTop;
	}
	public void setSpacingTop(Integer spacingTop) {
		this.spacingTop = spacingTop;
	}
	public Integer getSpacingRight() {
		return spacingRight;
	}
	public void setSpacingRight(Integer spacingRight) {
		this.spacingRight = spacingRight;
	}
	public Integer getSpacingBottom() {
		return spacingBottom;
	}
	public void setSpacingBottom(Integer spacingBottom) {
		this.spacingBottom = spacingBottom;
	}
	public Integer getSpacingLeft() {
		return spacingLeft;
	}
	public void setSpacingLeft(Integer spacingLeft) {
		this.spacingLeft = spacingLeft;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getZoomType() {
		return zoomType;
	}
	public void setZoomType(String zoomType) {
		this.zoomType = zoomType;
	}
}