package org.hi.base.report.excel.action.struts;

import java.util.Map;
import org.hi.framework.web.struts.BaseAction;

public abstract class ReportBaseAction extends BaseAction
{
  abstract void mergedOutputModel(Map<String, Object> paramMap);

  public abstract void prepare();
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.report.excel.action.struts.ReportBaseAction
 * JD-Core Version:    0.6.0
 */