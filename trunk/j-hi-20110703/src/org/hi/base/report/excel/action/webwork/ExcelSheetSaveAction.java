package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.service.ExcelSheetManager;
import org.hi.framework.web.SynchronizationData;

public class ExcelSheetSaveAction extends BaseAction implements SynchronizationData{
	private ExcelSheet excelSheet;
	
	public String execute() throws Exception {
		if(super.perExecute(excelSheet)!= null) return returnCommand();
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		excelSheetMgr.saveExcelSheet(excelSheet);
		super.postExecute(excelSheet);
		return returnCommand();
	}
	
	public ExcelSheet getExcelSheet() {
		return excelSheet;
	}

	public void setExcelSheet(ExcelSheet excelSheet) {
		this.excelSheet = excelSheet;
	}

}
