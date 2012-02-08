package org.hi.framework.dao.ibatis3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.result.ResultHandler;
import org.apache.ibatis.mapping.Configuration;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

public class IbatisSession extends DefaultSqlSession {

	private Configuration configuration;
	private Executor executor;


	public IbatisSession(Configuration configuration, Executor executor, boolean autoCommit) {
		super(configuration, executor, autoCommit);
		this.configuration = configuration;
		this.executor = executor;
	}

	public List selectList(String statement, Object parameter, int offset, int limit) {
		try {
			MappedStatement ms = configuration.getMappedStatement(statement);
			if(statement.indexOf("hi.common")>=0){
				ms = createMappedStatement(ms, parameter);
			}
		    
			return executor.query(ms, wrapCollection(parameter), offset, limit,Executor.NO_RESULT_HANDLER);
		} catch (Exception e) {
			throw ExceptionFactory.wrapException(
					"Error querying database.  Cause: " + e, e);
		}
	}
	
	public void select(String statement, Object parameter, int offset, int limit, ResultHandler handler) {
		try {
			MappedStatement ms = configuration.getMappedStatement(statement);
			if(statement.indexOf("hi.common")>=0){
				ms = createMappedStatement(ms, parameter);
			}
			
			executor.query(ms, wrapCollection(parameter), offset, limit,handler);
		} catch (Exception e) {
			throw ExceptionFactory.wrapException(
					"Error querying database.  Cause: " + e, e);
		}
	}

	protected MappedStatement createMappedStatement(MappedStatement ms, Object parameter){
	    MappedStatement.Builder statementBuilder = new MappedStatement.Builder(configuration, ms.getId(), ms.getSqlSource(), ms.getSqlCommandType());
	    statementBuilder.resource(ms.getResource());
	    statementBuilder.fetchSize(ms.getFetchSize());
	    statementBuilder.statementType(ms.getStatementType());
	    statementBuilder.keyGenerator(ms.getKeyGenerator());
	    statementBuilder.keyProperty(ms.getKeyProperty());
	    statementBuilder.timeout(ms.getTimeout());
	    statementBuilder.parameterMap(ms.getParameterMap());
	    statementBuilder.cache(ms.getCache());
	    statementBuilder.useCache(ms.isUseCache());
	    
	    setStatementResultMap(ms, statementBuilder, parameter);
	    MappedStatement ms_statement = statementBuilder.build();
	    return ms_statement;
	}
	  private void setStatementResultMap(
		      MappedStatement ms,
		      MappedStatement.Builder statementBuilder,
		      Object parameter) {
		  
		  	Class resultType;
		    List<ResultMap> resultMaps = new ArrayList<ResultMap>();
		    
		    if((parameter instanceof Query) && ms.getResultMaps().size() == 0){
	    		Query query = (Query)parameter;
	    		   		
	    		if(query.getClazz() == null ){
	    			resultType = HashMap.class;
	    			ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
	    					configuration,
	    					statementBuilder.id() + "-Inline",
	    					resultType,
	    					new ArrayList<ResultMapping>());
	    			resultMaps.add(inlineResultMapBuilder.build());
	    		}
	    		else{
		    		//resultMap的ID值
	    			resultType = query.getClazz();
	    			String resultMapId = resultType.getSimpleName() + "." + resultType.getSimpleName();
	    			
	    			if(configuration.getResultMap(resultMapId) != null)	//如果有resultmap的配置信息就直截取
	    				resultMaps.add(configuration.getResultMap(resultMapId));
	    			else{												//如果没有就将返回类型设为hashMap
		    			resultType = HashMap.class;
		    			ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
		    					configuration,
		    					statementBuilder.id() + "-Inline",
		    					resultType,
		    					new ArrayList<ResultMapping>());
		    			resultMaps.add(inlineResultMapBuilder.build());
	    			}
	    		}
	    		
		    }
		    
		    statementBuilder.resultMaps(resultMaps);

		    statementBuilder.resultSetType(ms.getResultSetType());
		  }
	 
	private Object wrapCollection(final Object object) {
		if (object instanceof List) {
			return new HashMap() {
				{
					put("list", object);
				}
			};
		} else if (object != null && object.getClass().isArray()) {
			return new HashMap() {
				{
					put("array", object);
				}
			};
		}
		return object;
	}
}
