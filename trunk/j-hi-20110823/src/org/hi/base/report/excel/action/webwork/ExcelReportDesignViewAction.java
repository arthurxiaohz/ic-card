package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;

public class ExcelReportDesignViewAction extends BaseAction{
	private ExcelReportDesign excelReportDesign;
	
	public String execute() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		excelReportDesign = excelReportDesignMgr.getExcelReportDesignById(excelReportDesign.getId());
		return returnCommand();
	}
	
	public ExcelReportDesign getExcelReportDesign() {
		return excelReportDesign;
	}

	public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
		this.excelReportDesign = excelReportDesign;
	}
}
