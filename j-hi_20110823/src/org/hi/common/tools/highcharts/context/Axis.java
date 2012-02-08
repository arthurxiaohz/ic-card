package org.hi.common.tools.highcharts.context;

import java.io.Serializable;
import java.util.List;

import org.hi.common.tools.ChartSymbol;
import org.hi.common.tools.highcharts.core.CSSObject;
import org.hi.common.tools.highcharts.core.Function;
import org.hi.common.tools.highcharts.core.JsonObject;

public class Axis implements Serializable,ChartSymbol {
	private Boolean allowDecimals;
	private String alternateGridColor;
	private List<String> categories;
	private JsonObject dateTimeLabelFormats;
	private Boolean endOnTick;
	private Events events;
	private String gridLineColor;
	private String gridLineDashStyle;
	private Integer gridLineWidth;
	private String id;
	private Lables labels;
	private String lineColor;
	private Integer lineWidth;
	private Double linkedTo;
	private Integer max;
	private Double maxPadding;
	private Integer maxZoom;
	private Integer min;
	private String minorGridLineColor;
	private CSSObject minorGridLineDashStyle;
	private Integer minorGridLineWidth;
	private String minorTickColor;
	private Integer minorTickInterval;
	private Integer minorTickLength;
	private String minorTickPosition;
	private Integer minorTickWidth;
	private Double minPadding;
	private Integer offset;
	private Boolean opposite;
	private PlotBand plotBands;
	private PlotBand plotLines;
	private Boolean reversed;
	private Boolean showFirstLabel;
	private Boolean showLastLabel;
	private Integer startOfWeek;
	private Boolean startOnTick;
	private String tickColor;
	private Double tickInterval;
	private Integer tickLength;
	private String tickmarkPlacement;
	private Double tickPixelInterval;
	private String tickPosition;
	private Integer tickWidth;
	private Title title;
	
	
	public Boolean getAllowDecimals() {
		return allowDecimals;
	}

	public void setAllowDecimals(Boolean allowDecimals) {
		this.allowDecimals = allowDecimals;
	}

	public String getAlternateGridColor() {
		return alternateGridColor;
	}

	public void setAlternateGridColor(String alternateGridColor) {
		this.alternateGridColor = alternateGridColor;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public JsonObject getDateTimeLabelFormats() {
		return dateTimeLabelFormats;
	}

	public void setDateTimeLabelFormats(JsonObject dateTimeLabelFormats) {
		this.dateTimeLabelFormats = dateTimeLabelFormats;
	}

	public Boolean getEndOnTick() {
		return endOnTick;
	}

	public void setEndOnTick(Boolean endOnTick) {
		this.endOnTick = endOnTick;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public String getGridLineColor() {
		return gridLineColor;
	}

	public void setGridLineColor(String gridLineColor) {
		this.gridLineColor = gridLineColor;
	}

	public String getGridLineDashStyle() {
		return gridLineDashStyle;
	}

	public void setGridLineDashStyle(String gridLineDashStyle) {
		this.gridLineDashStyle = gridLineDashStyle;
	}

	public Integer getGridLineWidth() {
		return gridLineWidth;
	}

	public void setGridLineWidth(Integer gridLineWidth) {
		this.gridLineWidth = gridLineWidth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Lables getLabels() {
		return labels;
	}

	public void setLabels(Lables labels) {
		this.labels = labels;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public Integer getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Double getLinkedTo() {
		return linkedTo;
	}

	public void setLinkedTo(Double linkedTo) {
		this.linkedTo = linkedTo;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Double getMaxPadding() {
		return maxPadding;
	}

	public void setMaxPadding(Double maxPadding) {
		this.maxPadding = maxPadding;
	}

	public Integer getMaxZoom() {
		return maxZoom;
	}

	public void setMaxZoom(Integer maxZoom) {
		this.maxZoom = maxZoom;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getMinorGridLineColor() {
		return minorGridLineColor;
	}

	public void setMinorGridLineColor(String minorGridLineColor) {
		this.minorGridLineColor = minorGridLineColor;
	}

	public CSSObject getMinorGridLineDashStyle() {
		return minorGridLineDashStyle;
	}

	public void setMinorGridLineDashStyle(CSSObject minorGridLineDashStyle) {
		this.minorGridLineDashStyle = minorGridLineDashStyle;
	}

	public Integer getMinorGridLineWidth() {
		return minorGridLineWidth;
	}

	public void setMinorGridLineWidth(Integer minorGridLineWidth) {
		this.minorGridLineWidth = minorGridLineWidth;
	}

	public String getMinorTickColor() {
		return minorTickColor;
	}

	public void setMinorTickColor(String minorTickColor) {
		this.minorTickColor = minorTickColor;
	}

	public Integer getMinorTickInterval() {
		return minorTickInterval;
	}

	public void setMinorTickInterval(Integer minorTickInterval) {
		this.minorTickInterval = minorTickInterval;
	}

	public Integer getMinorTickLength() {
		return minorTickLength;
	}

	public void setMinorTickLength(Integer minorTickLength) {
		this.minorTickLength = minorTickLength;
	}

	public String getMinorTickPosition() {
		return minorTickPosition;
	}

	public void setMinorTickPosition(String minorTickPosition) {
		this.minorTickPosition = minorTickPosition;
	}

	public Integer getMinorTickWidth() {
		return minorTickWidth;
	}

	public void setMinorTickWidth(Integer minorTickWidth) {
		this.minorTickWidth = minorTickWidth;
	}

	public Double getMinPadding() {
		return minPadding;
	}

	public void setMinPadding(Double minPadding) {
		this.minPadding = minPadding;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Boolean getOpposite() {
		return opposite;
	}

	public void setOpposite(Boolean opposite) {
		this.opposite = opposite;
	}

	public PlotBand getPlotBands() {
		return plotBands;
	}

	public void setPlotBands(PlotBand plotBands) {
		this.plotBands = plotBands;
	}

	public PlotBand getPlotLines() {
		return plotLines;
	}

	public void setPlotLines(PlotBand plotLines) {
		this.plotLines = plotLines;
	}

	public Boolean getReversed() {
		return reversed;
	}

	public void setReversed(Boolean reversed) {
		this.reversed = reversed;
	}

	public Boolean getShowFirstLabel() {
		return showFirstLabel;
	}

	public void setShowFirstLabel(Boolean showFirstLabel) {
		this.showFirstLabel = showFirstLabel;
	}

	public Boolean getShowLastLabel() {
		return showLastLabel;
	}

	public void setShowLastLabel(Boolean showLastLabel) {
		this.showLastLabel = showLastLabel;
	}

	public Integer getStartOfWeek() {
		return startOfWeek;
	}

	public void setStartOfWeek(Integer startOfWeek) {
		this.startOfWeek = startOfWeek;
	}

	public Boolean getStartOnTick() {
		return startOnTick;
	}

	public void setStartOnTick(Boolean startOnTick) {
		this.startOnTick = startOnTick;
	}

	public String getTickColor() {
		return tickColor;
	}

	public void setTickColor(String tickColor) {
		this.tickColor = tickColor;
	}

	public Double getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(Double tickInterval) {
		this.tickInterval = tickInterval;
	}

	public Integer getTickLength() {
		return tickLength;
	}

	public void setTickLength(Integer tickLength) {
		this.tickLength = tickLength;
	}

	public String getTickmarkPlacement() {
		return tickmarkPlacement;
	}

	public void setTickmarkPlacement(String tickmarkPlacement) {
		this.tickmarkPlacement = tickmarkPlacement;
	}

	public Double getTickPixelInterval() {
		return tickPixelInterval;
	}

	public void setTickPixelInterval(Double tickPixelInterval) {
		this.tickPixelInterval = tickPixelInterval;
	}

	public String getTickPosition() {
		return tickPosition;
	}

	public void setTickPosition(String tickPosition) {
		this.tickPosition = tickPosition;
	}

	public Integer getTickWidth() {
		return tickWidth;
	}

	public void setTickWidth(Integer tickWidth) {
		this.tickWidth = tickWidth;
	}

	
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}



	public class Lables implements Serializable {
		private String align;
		private Boolean enabled;
		private Function formatter;
		private Integer rotation;
		private Double staggerLines;
		private Integer step;
		private CSSObject style;
		private Integer x;
		private Integer y;
		public String getAlign() {
			return align;
		}
		public void setAlign(String align) {
			this.align = align;
		}
		public Boolean getEnabled() {
			return enabled;
		}
		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
		public Function getFormatter() {
			return formatter;
		}
		public void setFormatter(Function formatter) {
			this.formatter = formatter;
		}
		public Integer getRotation() {
			return rotation;
		}
		public void setRotation(Integer rotation) {
			this.rotation = rotation;
		}
		public Double getStaggerLines() {
			return staggerLines;
		}
		public void setStaggerLines(Double staggerLines) {
			this.staggerLines = staggerLines;
		}
		public Integer getStep() {
			return step;
		}
		public void setStep(Integer step) {
			this.step = step;
		}
		public CSSObject getStyle() {
			return style;
		}
		public void setStyle(CSSObject style) {
			this.style = style;
		}
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		
		
	}
	
	public class Lable implements Serializable {
		private String align;
		private String verticalAlign;
		private Double rotation;
		private CSSObject style;
		private String textAlign;
		private Integer x;
		private Integer y;
		public String getAlign() {
			return align;
		}
		public void setAlign(String align) {
			this.align = align;
		}
		public String getVerticalAlign() {
			return verticalAlign;
		}
		public void setVerticalAlign(String verticalAlign) {
			this.verticalAlign = verticalAlign;
		}
		public Double getRotation() {
			return rotation;
		}
		public void setRotation(Double rotation) {
			this.rotation = rotation;
		}
		public CSSObject getStyle() {
			return style;
		}
		public void setStyle(CSSObject style) {
			this.style = style;
		}
		public String getTextAlign() {
			return textAlign;
		}
		public void setTextAlign(String textAlign) {
			this.textAlign = textAlign;
		}
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		
		
	}

	public class PlotBand implements Serializable{
		private String color;
		private Events events;
		private Double from;
		private String id;
		private Label label;
		private Double to;
		private Double zIndex;
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public Events getEvents() {
			return events;
		}
		public void setEvents(Events events) {
			this.events = events;
		}
		public Double getFrom() {
			return from;
		}
		public void setFrom(Double from) {
			this.from = from;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Label getLabel() {
			return label;
		}
		public void setLabel(Label label) {
			this.label = label;
		}
		public Double getTo() {
			return to;
		}
		public void setTo(Double to) {
			this.to = to;
		}
		public Double getZIndex() {
			return zIndex;
		}
		public void setZIndex(Double index) {
			zIndex = index;
		}
		
	}

}
