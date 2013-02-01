package org.hi.framework.dao;

import org.hi.framework.paging.Page;
import org.hi.framework.service.Manager;

public abstract interface HiDialect
{
  public static final String DATABASE_TYPE_MYSQL = "MSSQL";
  public static final String DATABASE_TYPE_SQLSERVER = "SQLSERVER";
  public static final String DATABASE_TYPE_ORACLE = "ORACLE";

  public abstract String getMaxRecode(Object paramObject, Filter paramFilter, Page paramPage);

  public abstract String getDataBaseType();

  public abstract String getFilterSQL(Filter paramFilter, Manager paramManager);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.HiDialect
 * JD-Core Version:    0.6.0
 */