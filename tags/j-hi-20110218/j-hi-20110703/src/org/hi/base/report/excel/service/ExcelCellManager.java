package org.hi.base.report.excel.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiUser;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.framework.service.Manager;

public interface ExcelCellManager extends Manager{
    /**
     * 保存/修改单元格
     * @param excelCell
     */
    public void saveExcelCell(ExcelCell excelCell);
    /**
     * 删除单元格
     * @param id
     */
    public void removeExcelCellById(Integer id);
    /**
     * 查询单元格
     * @param id
     * @return
     */
    public ExcelCell getExcelCellById(Integer id);
    /**
     * 单元格列表
     * @param pageInfo
     * @return
     */
    public List<ExcelCell> getExcelCellList(PageInfo pageInfo);
    
    public void saveSecurityExcelCell(ExcelCell excelCell);
    public void removeSecurityExcelCellById(Integer id);
    public ExcelCell getSecurityExcelCellById(Integer id);
    public List<ExcelCell> getSecurityExcelCellList(PageInfo pageInfo);
}
