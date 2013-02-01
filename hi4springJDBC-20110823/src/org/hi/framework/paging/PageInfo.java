package org.hi.framework.paging;

import java.io.Serializable;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;

public abstract interface PageInfo extends Serializable
{
  public abstract Filter getFilter();

  public abstract void setFilter(Filter paramFilter);

  public abstract Page getPage();

  public abstract void setPage(Page paramPage);

  public abstract Sorter getSorter();

  public abstract void setSorter(Sorter paramSorter);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.paging.PageInfo
 * JD-Core Version:    0.6.0
 */