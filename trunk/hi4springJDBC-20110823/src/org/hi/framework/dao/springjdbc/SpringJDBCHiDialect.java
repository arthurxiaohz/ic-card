package org.hi.framework.dao.springjdbc;

import java.util.List;
import javax.sql.DataSource;
import org.hi.framework.dao.HiDialect;
import org.hi.framework.paging.Page;

public abstract interface SpringJDBCHiDialect extends HiDialect
{
  public static final String HI_PROPERTY_DIALET_KEY = "springjdbc.dialect";

  public abstract String getLimitString(String paramString, Page paramPage);

  public abstract boolean inResult(int paramInt, Page paramPage);

  public abstract String insertSql(String paramString1, String paramString2, List<ValueClass2JDBCType> paramList);

  public abstract Number getSelectKey(String paramString, DataSource paramDataSource);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.springjdbc.SpringJDBCHiDialect
 * JD-Core Version:    0.6.0
 */