package org.hi.base.report.excel.service;

import java.util.List;
import org.hi.base.report.excel.model.ExcelReportDesign;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface ExcelReportDesignManager extends Manager
{
  public abstract void saveExcelReportDesign(ExcelReportDesign paramExcelReportDesign);

  public abstract void removeExcelReportDesignById(Integer paramInteger);

  public abstract ExcelReportDesign getExcelReportDesignById(Integer paramInteger);

  public abstract List<ExcelReportDesign> getExcelReportDesignList(PageInfo paramPageInfo);

  public abstract void saveSecurityExcelReportDesign(ExcelReportDesign paramExcelReportDesign);

  public abstract void removeSecurityExcelReportDesignById(Integer paramInteger);

  public abstract ExcelReportDesign getSecurityExcelReportDesignById(Integer paramInteger);

  public abstract List<ExcelReportDesign> getSecurityExcelReportDesignList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.service.ExcelReportDesignManager
 * JD-Core Version:    0.6.0
 */