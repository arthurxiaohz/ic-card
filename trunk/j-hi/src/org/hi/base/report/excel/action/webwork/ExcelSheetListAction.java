package org.hi.base.report.excel.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.action.ExcelSheetPageInfo;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.service.ExcelSheetManager;

public class ExcelSheetListAction extends BaseAction{
	private ExcelSheet excelSheet;
	private ExcelSheetPageInfo pageInfo;
	private List<ExcelSheet> excelSheets;
	
	public String execute() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		pageInfo = pageInfo == null ? new ExcelSheetPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo);
		
		excelSheets = excelSheetMgr.getExcelSheetList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public ExcelSheet getExcelSheet() {
		return excelSheet;
	}

	public void setExcelSheet(ExcelSheet excelSheet) {
		this.excelSheet = excelSheet;
	}
	
	public List<ExcelSheet> getExcelSheets() {
		return excelSheets;
	}

	public void setExcelSheets(List<ExcelSheet> excelSheets) {
		this.excelSheets = excelSheets;
	}

	public ExcelSheetPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(ExcelSheetPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
