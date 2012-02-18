package org.hi.base.report.excel.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.framework.service.Manager;

public interface ExcelCellManager extends Manager{
    /**
     * ����/�޸ĵ�Ԫ��
     * @param excelCell
     */
    public void saveExcelCell(ExcelCell excelCell);
    /**
     * ɾ����Ԫ��
     * @param id
     */
    public void removeExcelCellById(Integer id);
    /**
     * ��ѯ��Ԫ��
     * @param id
     * @return
     */
    public ExcelCell getExcelCellById(Integer id);
    /**
     * ��Ԫ���б�
     * @param pageInfo
     * @return
     */
    public List<ExcelCell> getExcelCellList(PageInfo pageInfo);
    
    public void saveSecurityExcelCell(ExcelCell excelCell);
    public void removeSecurityExcelCellById(Integer id);
    public ExcelCell getSecurityExcelCellById(Integer id);
    public List<ExcelCell> getSecurityExcelCellList(PageInfo pageInfo);
}
