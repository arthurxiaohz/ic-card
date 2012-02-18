package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.service.ExcelSheetManager;

public class ExcelSheetViewAction extends BaseAction{
	private ExcelSheet excelSheet;
	
	public String execute() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		excelSheet = excelSheetMgr.getExcelSheetById(excelSheet.getId());
		return returnCommand();
	}
	
	public ExcelSheet getExcelSheet() {
		return excelSheet;
	}

	public void setExcelSheet(ExcelSheet excelSheet) {
		this.excelSheet = excelSheet;
	}
}
