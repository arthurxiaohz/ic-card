package org.hi.base.report.excel.action.webwork;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;

import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;

public class ExcelReportDesignRemoveAllAction extends BaseAction{
	private ExcelReportDesign excelReportDesign;
	private String orderIndexs;
	
	public String execute() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		
		if (orderIndexs != null && orderIndexs.length()> 0 )
		{
			String[] ids= orderIndexs.split(",");
			for( int i=0; i<ids.length; i++)
			{
				if (ids[i].length()>0)
				{
				Integer excelReportDesignid = new Integer( ids[i] );
				excelReportDesignMgr.removeExcelReportDesignById(excelReportDesignid);
				}
			}
		}
		
		return returnCommand();
	}
	
	public ExcelReportDesign getExcelReportDesign() {
		return excelReportDesign;
	}

	public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
		this.excelReportDesign = excelReportDesign;
	}
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}
}
