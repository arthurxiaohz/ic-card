package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;

public class Label implements Serializable,ChartSymbol{
	private List<LabelItem> items = new ArrayList<LabelItem>();
	private CSSObject style;
	public List<LabelItem> getItems() {
		return items;
	}
	public void setItems(List<LabelItem> items) {
		this.items = items;
	}
	public CSSObject getStyle() {
		return style;
	}
	public void setStyle(CSSObject style) {
		this.style = style;
	}
	
	
}
