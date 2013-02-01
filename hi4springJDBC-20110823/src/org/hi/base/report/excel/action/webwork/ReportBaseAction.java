package org.hi.base.report.excel.action.webwork;

import java.util.Map;
import org.hi.framework.web.webwork.BaseAction;

public abstract class ReportBaseAction extends BaseAction
{
  abstract void mergedOutputModel(Map<String, Object> paramMap);

  public abstract void prepare();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.report.excel.action.webwork.ReportBaseAction
 * JD-Core Version:    0.6.0
 */