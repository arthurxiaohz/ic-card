package org.hi.base.report.excel.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.framework.service.Manager;

public interface ExcelReportDesignManager extends Manager{
	/**
	 * 新增/修改保存Excel报表设计
	 */
    public void saveExcelReportDesign(ExcelReportDesign excelReportDesign);
    /**
	 * 删除/修改保存Excel报表设计
	 */
    public void removeExcelReportDesignById(Integer id);
    /**
	 * 查询Excel报表设计
	 */
    public ExcelReportDesign getExcelReportDesignById(Integer id);
    /**
	 * Excel报表设计列表
	 */
    public List<ExcelReportDesign> getExcelReportDesignList(PageInfo pageInfo);
    
    public void saveSecurityExcelReportDesign(ExcelReportDesign excelReportDesign);
    public void removeSecurityExcelReportDesignById(Integer id);
    public ExcelReportDesign getSecurityExcelReportDesignById(Integer id);
    public List<ExcelReportDesign> getSecurityExcelReportDesignList(PageInfo pageInfo);
}
