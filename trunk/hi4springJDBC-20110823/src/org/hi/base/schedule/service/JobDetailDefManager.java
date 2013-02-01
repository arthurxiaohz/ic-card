package org.hi.base.schedule.service;

import java.util.List;
import org.hi.base.schedule.model.JobDetailDef;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface JobDetailDefManager extends Manager
{
  public abstract void saveJobDetailDef(JobDetailDef paramJobDetailDef);

  public abstract void removeJobDetailDefById(Integer paramInteger);

  public abstract JobDetailDef getJobDetailDefById(Integer paramInteger);

  public abstract List<JobDetailDef> getJobDetailDefList(PageInfo paramPageInfo);

  public abstract void saveSecurityJobDetailDef(JobDetailDef paramJobDetailDef);

  public abstract void removeSecurityJobDetailDefById(Integer paramInteger);

  public abstract JobDetailDef getSecurityJobDetailDefById(Integer paramInteger);

  public abstract List<JobDetailDef> getSecurityJobDetailDefList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.schedule.service.JobDetailDefManager
 * JD-Core Version:    0.6.0
 */