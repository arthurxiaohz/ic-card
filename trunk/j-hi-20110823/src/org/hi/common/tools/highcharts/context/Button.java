package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.List;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.Function;

public class Button  implements Serializable,ChartSymbol{
	private String hoverSymbolFill;
	private Function onclick;
	private List<String> menuItems;
	private String symbol;
	private String symbolFill;
	private Integer x;
	private String align;
	private String backgroundColor;
	private String borderColor;
	private Integer borderRadius;
	private Integer borderWidth;
	private Boolean enabled;
	private Integer height;
	private String hoverBorderColor;
	private String hoverSymbolStroke;
	private Integer symbolSize;
	private String symbolStroke;
	private String symbolStrokeWidth;
	private Double symbolX;
	private Double symbolY;
	private String verticalAlign;
	private Integer width;
	private Integer y;
	public String getHoverSymbolFill() {
		return hoverSymbolFill;
	}
	public void setHoverSymbolFill(String hoverSymbolFill) {
		this.hoverSymbolFill = hoverSymbolFill;
	}
	public Function getOnclick() {
		return onclick;
	}
	public void setOnclick(Function onclick) {
		this.onclick = onclick;
	}
	public List<String> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<String> menuItems) {
		this.menuItems = menuItems;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSymbolFill() {
		return symbolFill;
	}
	public void setSymbolFill(String symbolFill) {
		this.symbolFill = symbolFill;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public Integer getBorderRadius() {
		return borderRadius;
	}
	public void setBorderRadius(Integer borderRadius) {
		this.borderRadius = borderRadius;
	}
	public Integer getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getHoverBorderColor() {
		return hoverBorderColor;
	}
	public void setHoverBorderColor(String hoverBorderColor) {
		this.hoverBorderColor = hoverBorderColor;
	}
	public String getHoverSymbolStroke() {
		return hoverSymbolStroke;
	}
	public void setHoverSymbolStroke(String hoverSymbolStroke) {
		this.hoverSymbolStroke = hoverSymbolStroke;
	}
	public Integer getSymbolSize() {
		return symbolSize;
	}
	public void setSymbolSize(Integer symbolSize) {
		this.symbolSize = symbolSize;
	}
	public String getSymbolStroke() {
		return symbolStroke;
	}
	public void setSymbolStroke(String symbolStroke) {
		this.symbolStroke = symbolStroke;
	}
	public String getSymbolStrokeWidth() {
		return symbolStrokeWidth;
	}
	public void setSymbolStrokeWidth(String symbolStrokeWidth) {
		this.symbolStrokeWidth = symbolStrokeWidth;
	}
	public Double getSymbolX() {
		return symbolX;
	}
	public void setSymbolX(Double symbolX) {
		this.symbolX = symbolX;
	}
	public Double getSymbolY() {
		return symbolY;
	}
	public void setSymbolY(Double symbolY) {
		this.symbolY = symbolY;
	}
	public String getVerticalAlign() {
		return verticalAlign;
	}
	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	
}
