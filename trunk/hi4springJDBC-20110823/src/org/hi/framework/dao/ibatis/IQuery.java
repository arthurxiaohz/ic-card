package org.hi.framework.dao.ibatis;

public abstract interface IQuery
{
  public abstract String toString();

  public abstract IQuery append(String paramString);

  public abstract IQuery append(StringBuffer paramStringBuffer);

  public abstract StringBuffer getQuerySql();

  public abstract void replaceAll(String paramString1, String paramString2);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.IQuery
 * JD-Core Version:    0.6.0
 */