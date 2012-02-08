package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;

public class LabelItem implements Serializable,ChartSymbol{
	private String html;
	private CSSObject style;
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	
	
	
}
