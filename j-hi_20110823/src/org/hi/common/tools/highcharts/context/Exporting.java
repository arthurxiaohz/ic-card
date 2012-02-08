package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Exporting implements Serializable ,ChartSymbol{
	private Buttons buttons;
	private Boolean enabled;
	private String filename;
	private String type;
	private String url = "http://www.j-hi.net";
	private Integer width;
	public Buttons getButtons() {
		return buttons;
	}
	public void setButtons(Buttons buttons) {
		this.buttons = buttons;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	
}
