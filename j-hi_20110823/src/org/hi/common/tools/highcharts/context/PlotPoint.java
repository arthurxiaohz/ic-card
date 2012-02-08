package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class PlotPoint implements Serializable ,ChartSymbol{
	private Events events;

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
	
	
}
