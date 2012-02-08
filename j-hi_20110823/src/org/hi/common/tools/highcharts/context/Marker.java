package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Marker extends MarkerElement implements Serializable ,ChartSymbol{
	private String symbol;
	private MarkerElement hover;
	private MarkerElement select;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public MarkerElement getHover() {
		return hover;
	}
	public void setHover(MarkerElement hover) {
		this.hover = hover;
	}
	public MarkerElement getSelect() {
		return select;
	}
	public void setSelect(MarkerElement select) {
		this.select = select;
	}
	
	
}
