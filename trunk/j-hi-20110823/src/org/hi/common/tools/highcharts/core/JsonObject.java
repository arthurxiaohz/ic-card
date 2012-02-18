package org.hi.common.tools.highcharts.core;

import org.hi.common.tools.highcharts.context.Axis;

public class JsonObject {
	private String json;
	public JsonObject(String json){
		this.json = json;
	}
	
	public String toString(){
		return this.json;
	}
}
