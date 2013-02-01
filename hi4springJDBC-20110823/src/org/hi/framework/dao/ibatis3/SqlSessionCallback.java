package org.hi.framework.dao.ibatis3;

import java.sql.SQLException;
import org.apache.ibatis.session.SqlSession;

public abstract interface SqlSessionCallback
{
  public abstract Object doInSqlSession(SqlSession paramSqlSession)
    throws SQLException;
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.SqlSessionCallback
 * JD-Core Version:    0.6.0
 */