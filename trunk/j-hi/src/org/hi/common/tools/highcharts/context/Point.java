package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Point implements Serializable ,ChartSymbol{
	private String color;
	private Events evnets;
	private String id;
	private Marker marker;
	private String name;
	private Boolean sliced;
	private Double x;
	private Double y;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Events getEvnets() {
		return evnets;
	}
	public void setEvnets(Events evnets) {
		this.evnets = evnets;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Marker getMarker() {
		return marker;
	}
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSliced() {
		return sliced;
	}
	public void setSliced(Boolean sliced) {
		this.sliced = sliced;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	
}
