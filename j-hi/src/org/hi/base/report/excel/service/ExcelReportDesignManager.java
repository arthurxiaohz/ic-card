package org.hi.base.report.excel.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.framework.service.Manager;

public interface ExcelReportDesignManager extends Manager{
	/**
	 * ����/�޸ı���Excel�������
	 */
    public void saveExcelReportDesign(ExcelReportDesign excelReportDesign);
    /**
	 * ɾ��/�޸ı���Excel�������
	 */
    public void removeExcelReportDesignById(Integer id);
    /**
	 * ��ѯExcel�������
	 */
    public ExcelReportDesign getExcelReportDesignById(Integer id);
    /**
	 * Excel��������б�
	 */
    public List<ExcelReportDesign> getExcelReportDesignList(PageInfo pageInfo);
    
    public void saveSecurityExcelReportDesign(ExcelReportDesign excelReportDesign);
    public void removeSecurityExcelReportDesignById(Integer id);
    public ExcelReportDesign getSecurityExcelReportDesignById(Integer id);
    public List<ExcelReportDesign> getSecurityExcelReportDesignList(PageInfo pageInfo);
}
