package org.hi.common.tools.highcharts.context;

import java.io.Serializable;

import org.hi.common.tools.ChartSymbol;

public class Buttons  implements Serializable,ChartSymbol {
	private Button exportButton;
	private Button printButton;
	
	public Button getExportButton() {
		return exportButton;
	}
	public void setExportButton(Button exportButton) {
		this.exportButton = exportButton;
	}
	public Button getPrintButton() {
		return printButton;
	}
	public void setPrintButton(Button printButton) {
		this.printButton = printButton;
	}
	
	
	
}
