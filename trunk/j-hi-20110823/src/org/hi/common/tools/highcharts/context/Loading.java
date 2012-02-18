package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;

public class Loading implements Serializable,ChartSymbol {
	private Integer hideDuration = 100;
	private Integer showDuration = 100;
	private CSSObject labelStyle;
	private CSSObject style;
	public Integer getHideDuration() {
		return hideDuration;
	}
	public void setHideDuration(Integer hideDuration) {
		this.hideDuration = hideDuration;
	}
	public Integer getShowDuration() {
		return showDuration;
	}
	public void setShowDuration(Integer showDuration) {
		this.showDuration = showDuration;
	}
	public CSSObject getLabelStyle() {
		return labelStyle;
	}
	public void setLabelStyle(CSSObject labelStyle) {
		this.labelStyle = labelStyle;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	
	
}
