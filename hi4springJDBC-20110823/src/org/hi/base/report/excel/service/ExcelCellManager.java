package org.hi.base.report.excel.service;

import java.util.List;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface ExcelCellManager extends Manager
{
  public abstract void saveExcelCell(ExcelCell paramExcelCell);

  public abstract void removeExcelCellById(Integer paramInteger);

  public abstract ExcelCell getExcelCellById(Integer paramInteger);

  public abstract List<ExcelCell> getExcelCellList(PageInfo paramPageInfo);

  public abstract void saveSecurityExcelCell(ExcelCell paramExcelCell);

  public abstract void removeSecurityExcelCellById(Integer paramInteger);

  public abstract ExcelCell getSecurityExcelCellById(Integer paramInteger);

  public abstract List<ExcelCell> getSecurityExcelCellList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.service.ExcelCellManager
 * JD-Core Version:    0.6.0
 */