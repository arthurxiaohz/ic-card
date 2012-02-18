package org.hi.base.report.excel.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.report.excel.action.ExcelCellPageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.service.ExcelCellManager;

public class ExcelCellAction extends BaseAction{
	private ExcelCell excelCell;
	private ExcelCellPageInfo pageInfo;
	private List<ExcelCell> excelCells;
	private String orderIndexs;
	
	   
	/**
	 * 新增/修改保存单元格
	 */
	public String saveExcelCell() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		if(super.perExecute(excelCell)!= null) return returnCommand();
		excelCellMgr.saveExcelCell(excelCell);
		super.postExecute(excelCell);
		return returnCommand();
	}
	
	
	/**
	 * 删除单元格
	 */
	public String removeExcelCell() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		excelCellMgr.removeExcelCellById(excelCell.getId());
		return returnCommand();
	}
	
	/**
	 * 删除指定的某些单元格
	 */
	public String removeAllExcelCell() throws Exception {
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
	
	/**
	 *查看单元格
	 */
	public String viewExcelCell() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		excelCell = excelCellMgr.getExcelCellById(excelCell.getId());
		return returnCommand();
	}
	
	/**
	 * 单元格列表
	 */
	public String excelCellList() throws Exception {
		ExcelCellManager excelCellMgr = (ExcelCellManager)SpringContextHolder.getBean(ExcelCell.class);
		pageInfo = pageInfo == null ? new ExcelCellPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		excelCells = excelCellMgr.getSecurityExcelCellList(sarchPageInfo);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
