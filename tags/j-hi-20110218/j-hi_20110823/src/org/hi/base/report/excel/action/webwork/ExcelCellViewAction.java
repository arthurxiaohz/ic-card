package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.service.ExcelCellManager;

public class ExcelCellViewAction extends BaseAction{
	private ExcelCell excelCell;
	
	public String execute() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		excelCell = excelCellMgr.getExcelCellById(excelCell.getId());
		return returnCommand();
	}
	
	public ExcelCell getExcelCell() {
		return excelCell;
	}

	public void setExcelCell(ExcelCell excelCell) {
		this.excelCell = excelCell;
	}
}
