package org.hi.framework.dao.ibatis3;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

// see Ibatis3DaoSupport.execute
public interface SqlSessionCallback {
    public Object doInSqlSession(SqlSession session) throws SQLException;
}
