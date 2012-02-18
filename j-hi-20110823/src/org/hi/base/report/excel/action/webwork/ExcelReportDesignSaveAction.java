package org.hi.base.report.excel.action.webwork;

import java.io.File;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.web.webwork.BaseAction;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;
import org.hi.framework.web.BusinessException;
import org.hi.framework.web.SynchronizationData;

public class ExcelReportDesignSaveAction extends BaseAction implements SynchronizationData{
	private ExcelReportDesign excelReportDesign;
	
	private File template;
    private String templateFileName;
    private String templateContentType;
    
	public String execute() throws Exception {
		if(super.perExecute(null)!= null) return returnCommand();
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		
		if (template != null) {
			String imagePath = saveFile(template, templateFileName,"report");
			excelReportDesign.setTemplate(imagePath);
		}
		
		
		
		excelReportDesignMgr.saveExcelReportDesign(excelReportDesign);
		super.postExecute(null);
		return returnCommand();
	}
	
	public ExcelReportDesign getExcelReportDesign() {
		return excelReportDesign;
	}

	public void setExcelReportDesign(ExcelReportDesign excelReportDesign) {
		this.excelReportDesign = excelReportDesign;
	}

	public File getTemplate() {
		return template;
	}

	public void setTemplate(File template) {
		this.template = template;
	}

	public String getTemplateContentType() {
		return templateContentType;
	}

	public void setTemplateContentType(String templateContentType) {
		this.templateContentType = templateContentType;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

}
