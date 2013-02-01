package org.hi.base.report.excel.service;

import java.util.List;
import org.hi.base.report.excel.model.ExcelSheet;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface ExcelSheetManager extends Manager
{
  public abstract void saveExcelSheet(ExcelSheet paramExcelSheet);

  public abstract void removeExcelSheetById(Integer paramInteger);

  public abstract ExcelSheet getExcelSheetById(Integer paramInteger);

  public abstract List<ExcelSheet> getExcelSheetList(PageInfo paramPageInfo);

  public abstract void saveSecurityExcelSheet(ExcelSheet paramExcelSheet);

  public abstract void removeSecurityExcelSheetById(Integer paramInteger);

  public abstract ExcelSheet getSecurityExcelSheetById(Integer paramInteger);

  public abstract List<ExcelSheet> getSecurityExcelSheetList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.service.ExcelSheetManager
 * JD-Core Version:    0.6.0
 */