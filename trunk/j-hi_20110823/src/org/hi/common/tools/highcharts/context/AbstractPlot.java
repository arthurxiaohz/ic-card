package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public abstract class AbstractPlot implements Serializable,ChartSymbol{
	private Boolean allowPointSelect;
	private Boolean animation;
	private String color;
	private String cursor;
	private String dashStyle;
	private DataLabel dataLabels;
	private Boolean enableMouseTracking;
	private String id;
	private Events events;
	private Integer lineWidth;
	private Marker marker;
	private PlotPoint point;
	private Integer pointStart;
	private Integer pointInterval;
	private Boolean selected;
	private Boolean shadow;
	private Boolean showCheckbox;
	private Boolean showInLegend;
	private String stacking;
	private States states;
	private Boolean stickyTracking;
	private Boolean visible;
	private Integer zIndex;
	
	
	public Boolean getAllowPointSelect() {
		return allowPointSelect;
	}
	public void setAllowPointSelect(Boolean allowPointSelect) {
		this.allowPointSelect = allowPointSelect;
	}
	public Boolean getAnimation() {
		return animation;
	}
	public void setAnimation(Boolean animation) {
		this.animation = animation;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCursor() {
		return cursor;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	public String getDashStyle() {
		return dashStyle;
	}
	public void setDashStyle(String dashStyle) {
		this.dashStyle = dashStyle;
	}
	public DataLabel getDataLabels() {
		return dataLabels;
	}
	public void setDataLabels(DataLabel dataLabels) {
		this.dataLabels = dataLabels;
	}
	public Boolean getEnableMouseTracking() {
		return enableMouseTracking;
	}
	public void setEnableMouseTracking(Boolean enableMouseTracking) {
		this.enableMouseTracking = enableMouseTracking;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public Integer getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}
	public Marker getMarker() {
		return marker;
	}
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	public PlotPoint getPoint() {
		return point;
	}
	public void setPoint(PlotPoint point) {
		this.point = point;
	}
	public Integer getPointStart() {
		return pointStart;
	}
	public void setPointStart(Integer pointStart) {
		this.pointStart = pointStart;
	}
	public Integer getPointInterval() {
		return pointInterval;
	}
	public void setPointInterval(Integer pointInterval) {
		this.pointInterval = pointInterval;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Boolean getShadow() {
		return shadow;
	}
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}
	public Boolean getShowCheckbox() {
		return showCheckbox;
	}
	public void setShowCheckbox(Boolean showCheckbox) {
		this.showCheckbox = showCheckbox;
	}
	public Boolean getShowInLegend() {
		return showInLegend;
	}
	public void setShowInLegend(Boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	public String getStacking() {
		return stacking;
	}
	public void setStacking(String stacking) {
		this.stacking = stacking;
	}
	public States getStates() {
		return states;
	}
	public void setStates(States states) {
		this.states = states;
	}
	public Boolean getStickyTracking() {
		return stickyTracking;
	}
	public void setStickyTracking(Boolean stickyTracking) {
		this.stickyTracking = stickyTracking;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Integer getZIndex() {
		return zIndex;
	}
	public void setZIndex(Integer index) {
		zIndex = index;
	}
}
