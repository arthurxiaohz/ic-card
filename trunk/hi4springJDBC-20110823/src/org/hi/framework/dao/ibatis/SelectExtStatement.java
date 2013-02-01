/*    */ package org.hi.framework.dao.ibatis;
/*    */ 
/*    */ import com.ibatis.common.jdbc.exception.NestedSQLException;
/*    */ import com.ibatis.sqlmap.client.event.RowHandler;
/*    */ import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
/*    */ import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMapping;
/*    */ import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
/*    */ import com.ibatis.sqlmap.engine.mapping.sql.Sql;
/*    */ import com.ibatis.sqlmap.engine.mapping.sql.stat.StaticSql;
/*    */ import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
/*    */ import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
/*    */ import com.ibatis.sqlmap.engine.scope.ErrorContext;
/*    */ import com.ibatis.sqlmap.engine.scope.StatementScope;
/*    */ import com.ibatis.sqlmap.engine.transaction.Transaction;
/*    */ import com.ibatis.sqlmap.engine.type.TypeHandlerFactory;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class SelectExtStatement extends MappedStatement
/*    */ {
/*    */   public int executeUpdate(StatementScope statementScope, Transaction trans, Object parameterObject)
/*    */     throws SQLException
/*    */   {
/* 27 */     throw new SQLException("SelectExt statements cannot be executed as an update.");
/*    */   }
/*    */ 
/*    */   protected void executeQueryWithCallback(StatementScope statementScope, Connection conn, Object parameterObject, Object resultObject, RowHandler rowHandler, int skipResults, int maxResults) throws SQLException
/*    */   {
/* 32 */     ErrorContext errorContext = statementScope.getErrorContext();
/* 33 */     errorContext.setActivity("preparing the mapped statement for execution");
/* 34 */     errorContext.setObjectId(getId());
/* 35 */     errorContext.setResource(getResource());
/* 36 */     Query query = null;
/* 37 */     if ((parameterObject instanceof Query)) {
/* 38 */       query = (Query)parameterObject;
/* 39 */       parameterObject = query.toString();
/*    */     }
/*    */     try {
/* 42 */       parameterObject = validateParameter(parameterObject);
/*    */ 
/* 44 */       Sql sql = new StaticSql(parameterObject.toString());
/*    */ 
/* 46 */       errorContext.setMoreInfo("Check the parameter map.");
/* 47 */       ParameterMap parameterMap = sql.getParameterMap(statementScope, parameterObject);
/*    */ 
/* 49 */       errorContext.setMoreInfo("Check the result map.");
/* 50 */       ResultMap resultMap = sql.getResultMap(statementScope, parameterObject);
/*    */ 
/* 52 */       statementScope.setResultMap(resultMap);
/* 53 */       statementScope.setParameterMap(parameterMap);
/*    */ 
/* 55 */       errorContext.setMoreInfo("Check the parameter map.");
/*    */ 
/* 58 */       List parameterMappingList = new ArrayList();
/* 59 */       Map parMap = query.getParameterObject();
/* 60 */       Object[] parameters = parMap.values().toArray(new Object[parMap.values().size()]);
/* 61 */       TypeHandlerFactory typeHandlerFactory = new TypeHandlerFactory();
/* 62 */       for (Map.Entry entry : parMap.entrySet()) {
/* 63 */         ParameterMapping pMapping = new ParameterMapping();
/* 64 */         pMapping.setJavaType(entry.getValue().getClass());
/* 65 */         pMapping.setPropertyName((String)entry.getKey());
/* 66 */         pMapping.setTypeHandler(typeHandlerFactory.getTypeHandler(entry.getValue().getClass()));
/* 67 */         parameterMappingList.add(pMapping);
/*    */       }
/*    */ 
/* 71 */       statementScope.getParameterMap().setParameterMappingList(parameterMappingList);
/*    */ 
/* 73 */       errorContext.setMoreInfo("Check the SQL statement.");
/* 74 */       String sqlString = sql.getSql(statementScope, parameterObject);
/*    */ 
/* 76 */       errorContext.setActivity("executing mapped statement");
/* 77 */       errorContext.setMoreInfo("Check the SQL statement or the result map.");
/* 78 */       RowHandlerCallback callback = new RowHandlerCallback(resultMap, resultObject, rowHandler);
/* 79 */       sqlExecuteQuery(statementScope, conn, sqlString, parameters, skipResults, maxResults, callback);
/*    */ 
/* 81 */       errorContext.setMoreInfo("Check the output parameters.");
/* 82 */       if (parameterObject != null) {
/* 83 */         postProcessParameterObject(statementScope, parameterObject, parameters);
/*    */       }
/*    */ 
/* 86 */       errorContext.reset();
/* 87 */       sql.cleanup(statementScope);
/* 88 */       notifyListeners();
/*    */     } catch (SQLException e) {
/* 90 */       errorContext.setCause(e);
/* 91 */       throw new NestedSQLException(errorContext.toString(), e.getSQLState(), e.getErrorCode(), e);
/*    */     } catch (Exception e) {
/* 93 */       errorContext.setCause(e);
/* 94 */       throw new NestedSQLException(errorContext.toString(), e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.SelectExtStatement
 * JD-Core Version:    0.6.0
 */