package org.hi.common.tools.highcharts.core;

import java.io.Serializable;

public class Function implements Serializable{
	private String funciton;
	public Function(String function){
		this.funciton = function;
	}
	
	public String toString(){
		return this.funciton;
	}
}
