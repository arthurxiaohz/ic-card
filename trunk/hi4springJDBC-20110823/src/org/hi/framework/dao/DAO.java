package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;
import org.hi.framework.paging.Page;
import org.hi.framework.paging.PageInfo;

public abstract interface DAO
{
  public abstract void saveObject(Object paramObject);

  public abstract void removeObjectById(Class paramClass, Serializable paramSerializable);

  public abstract void removeObject(Object paramObject);

  public abstract Object getObjectById(Class paramClass, Serializable paramSerializable);

  public abstract Object getUniqueObject(Class paramClass, Filter paramFilter);

  public abstract List<Object> getObjects(Class paramClass);

  public abstract List<Object> getObjects(Class paramClass, Filter paramFilter);

  public abstract List<Object> getObjects(Class paramClass, Filter paramFilter, Sorter paramSorter);

  public abstract List<Object> getObjects(Class paramClass, Filter paramFilter, Sorter paramSorter, Page paramPage);

  public abstract List<Object> getObjects(Class paramClass, PageInfo paramPageInfo);

  public abstract int getObjectCount(Class paramClass);

  public abstract int getObjectCount(Class paramClass, Filter paramFilter);

  public abstract HiDialect getDialect();
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.DAO
 * JD-Core Version:    0.6.0
 */