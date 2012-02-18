package org.hi.base.report.excel.action.webwork;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.action.ExcelReportDesignPageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;

public class ExcelReportDesignListAction extends BaseAction{
	private ExcelReportDesign excelReportDesign;
	private ExcelReportDesignPageInfo pageInfo;
	private List<ExcelReportDesign> excelReportDesigns;
	
	public String execute() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		pageInfo = pageInfo == null ? new ExcelReportDesignPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		excelReportDesigns = excelReportDesignMgr.getExcelReportDesignList(sarchPageInfo);
		
		return returnCommand();	
	}
	
	public ExcelReportDesign getExcelReportDesign() {
		return excelReportDesign;
	}

	public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
		this.excelReportDesign = excelReportDesign;
	}
	
	public List<ExcelReportDesign> getExcelReportDesigns() {
		return excelReportDesigns;
	}

	public void setExcelReportDesigns(List<ExcelReportDesign> excelReportDesigns) {
		this.excelReportDesigns = excelReportDesigns;
	}

	public ExcelReportDesignPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(ExcelReportDesignPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}	
}
