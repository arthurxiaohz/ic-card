package org.hi.framework.paging;

import java.io.Serializable;

public abstract interface Page extends Serializable
{
  public abstract void setTotalRecords(int paramInt);

  public abstract int getTotalRecords();

  public abstract void setTotalPage(int paramInt);

  public abstract int getTotalPage();

  public abstract void setPageSize(int paramInt);

  public abstract int getPageSize();

  public abstract void setIsFristPage(boolean paramBoolean);

  public abstract boolean getIsFristPage();

  public abstract void setIsLastPage(boolean paramBoolean);

  public abstract boolean getIsLastPage();

  public abstract void setCurrentPage(int paramInt);

  public abstract int getCurrentPage();

  public abstract void setStartRowPosition(int paramInt);

  public abstract int getStartRowPosition();

  public abstract void setEndRowPosition(int paramInt);

  public abstract int getEndRowPosition();

  public abstract int getMaxRecords();

  public abstract void setMaxRecords(int paramInt);

  public abstract int getMiddlePageNum();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.paging.Page
 * JD-Core Version:    0.6.0
 */