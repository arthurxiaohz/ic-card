package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.service.ExcelCellManager;
import org.hi.framework.web.SynchronizationData;

public class ExcelCellSaveAction extends BaseAction implements SynchronizationData{
	private ExcelCell excelCell;
	
	public String execute() throws Exception {
		if(super.perExecute(excelCell)!= null) return returnCommand();
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		excelCellMgr.saveExcelCell(excelCell);
		super.postExecute(excelCell);
		return returnCommand();
	}
	
	public ExcelCell getExcelCell() {
		return excelCell;
	}

	public void setExcelCell(ExcelCell excelCell) {
		this.excelCell = excelCell;
	}

}
