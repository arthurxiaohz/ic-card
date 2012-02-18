package org.hi.framework.dao.ibatis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.jdbc.exception.NestedSQLException;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMapping;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.sql.stat.StaticSql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.ErrorContext;
import com.ibatis.sqlmap.engine.scope.StatementScope;
import com.ibatis.sqlmap.engine.transaction.Transaction;
import com.ibatis.sqlmap.engine.type.TypeHandlerFactory;

public class SelectExtStatement extends MappedStatement {

		  public int executeUpdate(StatementScope statementScope, Transaction trans, Object parameterObject)
		      throws SQLException {
		    throw new SQLException("SelectExt statements cannot be executed as an update.");
		  }
	
		  protected void executeQueryWithCallback(StatementScope statementScope, Connection conn, Object parameterObject, Object resultObject, RowHandler rowHandler, int skipResults, int maxResults)
	      throws SQLException {
		    ErrorContext errorContext = statementScope.getErrorContext();
		    errorContext.setActivity("preparing the mapped statement for execution");
		    errorContext.setObjectId(this.getId());
		    errorContext.setResource(this.getResource());
		    Query query = null;
		    if(parameterObject instanceof Query){
		    	query = (Query)parameterObject;
		    	parameterObject = query.toString();
		    }
		    try {
		      parameterObject = validateParameter(parameterObject);
	
		      Sql sql = new StaticSql(parameterObject.toString());
	
		      errorContext.setMoreInfo("Check the parameter map.");
		      ParameterMap parameterMap = sql.getParameterMap(statementScope, parameterObject);
	
		      errorContext.setMoreInfo("Check the result map.");
		      ResultMap resultMap = sql.getResultMap(statementScope, parameterObject);
	
		      statementScope.setResultMap(resultMap);
		      statementScope.setParameterMap(parameterMap);
	
		      errorContext.setMoreInfo("Check the parameter map.");
		      
//		      Object[] parameters = parameterMap.getParameterObjectValues(statementScope, parameterObject);
		      List<Object> parameterMappingList = new ArrayList<Object>();
		      Map<String, Object> parMap = query.getParameterObject();
		      Object[] parameters  = parMap.values().toArray(new Object[parMap.values().size()]);
		      TypeHandlerFactory typeHandlerFactory = new TypeHandlerFactory();
		      for (Map.Entry<String, Object> entry : parMap.entrySet()){
		    	  ParameterMapping pMapping = new ParameterMapping();
		    	  pMapping.setJavaType(entry.getValue().getClass());
		    	  pMapping.setPropertyName(entry.getKey());
		    	  pMapping.setTypeHandler(typeHandlerFactory.getTypeHandler(entry.getValue().getClass()));
		    	  parameterMappingList.add(pMapping);
		      }
		      
		      
		      statementScope.getParameterMap().setParameterMappingList(parameterMappingList);
		      
		      errorContext.setMoreInfo("Check the SQL statement.");
		      String sqlString = sql.getSql(statementScope, parameterObject);
		      
		      errorContext.setActivity("executing mapped statement");
		      errorContext.setMoreInfo("Check the SQL statement or the result map.");
		      RowHandlerCallback callback = new RowHandlerCallback(resultMap, resultObject, rowHandler);
		      sqlExecuteQuery(statementScope, conn, sqlString, parameters, skipResults, maxResults, callback);
	
		      errorContext.setMoreInfo("Check the output parameters.");
		      if (parameterObject != null) {
		        postProcessParameterObject(statementScope, parameterObject, parameters);
		      }
	
		      errorContext.reset();
		      sql.cleanup(statementScope);
		      notifyListeners();
		    } catch (SQLException e) {
		      errorContext.setCause(e);
		      throw new NestedSQLException(errorContext.toString(), e.getSQLState(), e.getErrorCode(), e);
		    } catch (Exception e) {
		      errorContext.setCause(e);
		      throw new NestedSQLException(errorContext.toString(), e);
		    }
	  }

}
