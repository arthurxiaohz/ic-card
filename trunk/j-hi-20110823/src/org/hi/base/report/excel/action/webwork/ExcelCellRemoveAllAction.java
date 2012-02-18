package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.service.ExcelCellManager;

public class ExcelCellRemoveAllAction extends BaseAction{
	private ExcelCell excelCell;
	private String orderIndexs;
	
	public String execute() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer excelCellid = new Integer( ids[i] );
				excelCellMgr.removeExcelCellById(excelCellid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public ExcelCell getExcelCell() {
		return excelCell;
	}

	public void setExcelCell(ExcelCell excelCell) {
		this.excelCell = excelCell;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
