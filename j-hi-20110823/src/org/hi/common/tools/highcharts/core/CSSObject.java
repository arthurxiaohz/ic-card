package org.hi.common.tools.highcharts.core;

import java.io.Serializable;

public class CSSObject implements Serializable{
	private String cssJson;
	public CSSObject(String cssJson){
		this.cssJson = cssJson;
	}
	
	public String toString(){
		return this.cssJson;
	}
}
