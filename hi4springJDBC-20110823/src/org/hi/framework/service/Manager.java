package org.hi.framework.service;

import java.io.Serializable;
import java.util.List;
import org.hi.framework.dao.DAO;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

public abstract interface Manager
{
  public static final String SPRING_BEAN_ID = "org.hi.framework.service.Manager";

  public abstract void setDAO(DAO paramDAO);

  public abstract DAO getDAO();

  public abstract Class getModelClass();

  public abstract void saveObject(Object paramObject);

  public abstract void removeObject(Object paramObject);

  public abstract void removeObjectById(Serializable paramSerializable);

  public abstract Object getObjectById(Serializable paramSerializable);

  public abstract Object getUniqueObject(Filter paramFilter);

  public abstract List getObjects();

  public abstract List getObjects(Filter paramFilter);

  public abstract List getObjects(Filter paramFilter, Sorter paramSorter);

  public abstract List getObjects(Filter paramFilter, Sorter paramSorter, Page paramPage);

  public abstract List getObjects(PageInfo paramPageInfo);

  public abstract List getList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.service.Manager
 * JD-Core Version:    0.6.0
 */