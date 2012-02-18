package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.Function;

public class Events implements Serializable,ChartSymbol{
	private Function addSeries;
	private Function click;
	private Function load;
	private Function redraw;
	private Function selection;
	private Function checkboxClick;
	private Function hide;
	private Function legendItemClick;
	private Function mouseOver;
	private Function mouseOut ;
	private Function setExtremes;
	
	public Function getAddSeries() {
		return addSeries;
	}
	public void setAddSeries(Function addSeries) {
		this.addSeries = addSeries;
	}
	public Function getClick() {
		return click;
	}
	public void setClick(Function click) {
		this.click = click;
	}
	public Function getLoad() {
		return load;
	}
	public void setLoad(Function load) {
		this.load = load;
	}
	public Function getRedraw() {
		return redraw;
	}
	public void setRedraw(Function redraw) {
		this.redraw = redraw;
	}
	public Function getSelection() {
		return selection;
	}
	public void setSelection(Function selection) {
		this.selection = selection;
	}
	public Function getCheckboxClick() {
		return checkboxClick;
	}
	public void setCheckboxClick(Function checkboxClick) {
		this.checkboxClick = checkboxClick;
	}
	public Function getHide() {
		return hide;
	}
	public void setHide(Function hide) {
		this.hide = hide;
	}
	public Function getLegendItemClick() {
		return legendItemClick;
	}
	public void setLegendItemClick(Function legendItemClick) {
		this.legendItemClick = legendItemClick;
	}
	public Function getMouseOver() {
		return mouseOver;
	}
	public void setMouseOver(Function mouseOver) {
		this.mouseOver = mouseOver;
	}
	public Function getMouseOut() {
		return mouseOut;
	}
	public void setMouseOut(Function mouseOut) {
		this.mouseOut = mouseOut;
	}
	
}
