package org.hi.base.report.excel.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.report.excel.action.ExcelSheetPageInfo;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.base.report.excel.service.ExcelSheetManager;

public class ExcelSheetAction extends BaseAction{
	private ExcelSheet excelSheet;
	private ExcelSheetPageInfo pageInfo;
	private List<ExcelSheet> excelSheets;
	private String orderIndexs;
	
	
	/**
	 * ����/�޸ı��湤����
	 */
	public String saveExcelSheet() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		if(super.perExecute(excelSheet)!= null) return returnCommand();
		excelSheetMgr.saveExcelSheet(excelSheet);
		super.postExecute(excelSheet);
		return returnCommand();
	}
	
	
	/**
	 * ɾ��������
	 */
	public String removeExcelSheet() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		excelSheetMgr.removeExcelSheetById(excelSheet.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩ������
	 */
	public String removeAllExcelSheet() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer excelSheetid = new Integer( ids[i] );
				excelSheetMgr.removeExcelSheetById(excelSheetid);
				}
			}
		}
		
		return returnCommand();
	}
	  
	 /**
	 *�鿴������
	 */
	public String viewExcelSheet() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		excelSheet = excelSheetMgr.getExcelSheetById(excelSheet.getId());
		return returnCommand();
	}
	
	/**
	 * �������б�
	 */
	public String excelSheetList() throws Exception {
		ExcelSheetManager excelSheetMgr = (ExcelSheetManager)SpringContextHolder.getBean(ExcelSheet.class);
		pageInfo = pageInfo == null ? new ExcelSheetPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		excelSheets = excelSheetMgr.getSecurityExcelSheetList(sarchPageInfo);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
	
}
