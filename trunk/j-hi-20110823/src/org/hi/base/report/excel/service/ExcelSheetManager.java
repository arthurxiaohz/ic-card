package org.hi.base.report.excel.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.framework.service.Manager;

public interface ExcelSheetManager extends Manager{
	/**
	 * ����/�޸ı��湤����
	 */
    public void saveExcelSheet(ExcelSheet excelSheet);
    /**
	 * ɾ��������
	 */
    public void removeExcelSheetById(Integer id);
    /**
     * ��ѯ������
     * @param id
     * @return
     */
    public ExcelSheet getExcelSheetById(Integer id);
    /**
     * �������б�
     * @param pageInfo
     * @return
     */
    public List<ExcelSheet> getExcelSheetList(PageInfo pageInfo);
    
    public void saveSecurityExcelSheet(ExcelSheet excelSheet);
    public void removeSecurityExcelSheetById(Integer id);
    public ExcelSheet getSecurityExcelSheetById(Integer id);
    public List<ExcelSheet> getSecurityExcelSheetList(PageInfo pageInfo);
}
