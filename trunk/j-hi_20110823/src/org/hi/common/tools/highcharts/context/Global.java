package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Global implements Serializable ,ChartSymbol{
	private Boolean useUTC = true;

	public Boolean getUseUTC() {
		return useUTC;
	}

	public void setUseUTC(Boolean useUTC) {
		this.useUTC = useUTC;
	}
	
	
	
}
