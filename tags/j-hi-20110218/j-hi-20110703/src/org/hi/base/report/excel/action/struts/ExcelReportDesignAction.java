package org.hi.base.report.excel.action.struts;

import java.io.File;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import org.hi.base.report.excel.action.ExcelReportDesignPageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.service.ExcelReportDesignManager;

public class ExcelReportDesignAction extends BaseAction{
	private ExcelReportDesign excelReportDesign;
	private ExcelReportDesignPageInfo pageInfo;
	private List<ExcelReportDesign> excelReportDesigns;
	private String orderIndexs;
	
	private File template;
    private String templateFileName;
    private String templateContentType;
	/**
	 * ����/�޸ı���Excel�������
	 */
	public String saveExcelReportDesign() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		if(super.perExecute(excelReportDesign)!= null) return returnCommand();
		
		
		if (template != null) {
			String imagePath = saveFile(template, templateFileName,"report");
			excelReportDesign.setTemplate(imagePath);
		}
		
		
		excelReportDesignMgr.saveExcelReportDesign(excelReportDesign);
		super.postExecute(excelReportDesign);
		return returnCommand();
	}
	
	
	/**
	 * ɾ��Excel�������
	 */
	public String removeExcelReportDesign() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		excelReportDesignMgr.removeExcelReportDesignById(excelReportDesign.getId());
		return returnCommand();
	}
	
	/**
	 * ɾ��ָ����ĳЩExcel�������
	 */
	public String removeAllExcelReportDesign() throws Exception {
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
	
	/**
	 *�鿴Excel�������
	 */
	public String viewExcelReportDesign() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		excelReportDesign = excelReportDesignMgr.getExcelReportDesignById(excelReportDesign.getId());
		return returnCommand();
	}
	
	/**
	 * Excel��������б�
	 */
	public String excelReportDesignList() throws Exception {
		ExcelReportDesignManager excelReportDesignMgr = (ExcelReportDesignManager)SpringContextHolder.getBean(ExcelReportDesign.class);
		pageInfo = pageInfo == null ? new ExcelReportDesignPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);
		
		excelReportDesigns = excelReportDesignMgr.getSecurityExcelReportDesignList(sarchPageInfo);
		
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
	
	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
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
