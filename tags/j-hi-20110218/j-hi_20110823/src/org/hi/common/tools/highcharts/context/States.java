package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class States implements Serializable,ChartSymbol{
	private Hover hover;
	public Hover getHover() {
		return hover;
	}

	public void setHover(Hover hover) {
		this.hover = hover;
	}

	public class Hover implements Serializable{
		private Boolean enabled;
		private Integer lineWidth;
		private MarkerElement marker;
		
		public Boolean getEnabled() {
			return enabled;
		}
		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
		public Integer getLineWidth() {
			return lineWidth;
		}
		public void setLineWidth(Integer lineWidth) {
			this.lineWidth = lineWidth;
		}
		public MarkerElement getMarker() {
			return marker;
		}
		public void setMarker(MarkerElement marker) {
			this.marker = marker;
		}
		
	}
}
