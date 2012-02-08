package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;

public class Credit implements Serializable,ChartSymbol {
	private Boolean enabled = true;
	private Position position;
	private String href = "http://www.j-hi.net";
	private CSSObject style;
	private String text= "j-hi.net";
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
