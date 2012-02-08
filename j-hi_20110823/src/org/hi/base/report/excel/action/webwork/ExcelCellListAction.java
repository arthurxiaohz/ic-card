package org.hi.base.report.excel.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.action.ExcelCellPageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.service.ExcelCellManager;

public class ExcelCellListAction extends BaseAction{
	private ExcelCell excelCell;
	private ExcelCellPageInfo pageInfo;
	private List<ExcelCell> excelCells;
	
	public String execute() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		pageInfo = pageInfo == null ? new ExcelCellPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo);
		
		excelCells = excelCellMgr.getExcelCellList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public ExcelCell getExcelCell() {
		return excelCell;
	}

	public void setExcelCell(ExcelCell excelCell) {
		this.excelCell = excelCell;
	}
	
	public List<ExcelCell> getExcelCells() {
		return excelCells;
	}

	public void setExcelCells(List<ExcelCell> excelCells) {
		this.excelCells = excelCells;
	}

	public ExcelCellPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(ExcelCellPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
