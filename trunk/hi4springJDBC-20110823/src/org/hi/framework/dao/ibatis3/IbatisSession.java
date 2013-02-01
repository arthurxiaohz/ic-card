/*     */ package org.hi.framework.dao.ibatis3;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.ibatis.exceptions.ExceptionFactory;
/*     */ import org.apache.ibatis.executor.Executor;
/*     */ import org.apache.ibatis.executor.result.ResultHandler;
/*     */ import org.apache.ibatis.mapping.Configuration;
/*     */ import org.apache.ibatis.mapping.MappedStatement;
/*     */ import org.apache.ibatis.mapping.MappedStatement.Builder;
/*     */ import org.apache.ibatis.mapping.ResultMap.Builder;
/*     */ import org.apache.ibatis.session.defaults.DefaultSqlSession;
/*     */ 
/*     */ public class IbatisSession extends DefaultSqlSession
/*     */ {
/*     */   private Configuration configuration;
/*     */   private Executor executor;
/*     */ 
/*     */   public IbatisSession(Configuration configuration, Executor executor, boolean autoCommit)
/*     */   {
/*  24 */     super(configuration, executor, autoCommit);
/*  25 */     this.configuration = configuration;
/*  26 */     this.executor = executor;
/*     */   }
/*     */ 
/*     */   public List selectList(String statement, Object parameter, int offset, int limit) {
/*     */     try {
/*  31 */       MappedStatement ms = this.configuration.getMappedStatement(statement);
/*  32 */       if (statement.indexOf("hi.common") >= 0) {
/*  33 */         ms = createMappedStatement(ms, parameter);
/*     */       }
/*     */ 
/*  36 */       return this.executor.query(ms, wrapCollection(parameter), offset, limit, Executor.NO_RESULT_HANDLER); } catch (Exception e) {
/*     */     }
/*  38 */     throw ExceptionFactory.wrapException(
/*  39 */       "Error querying database.  Cause: " + e, e);
/*     */   }
/*     */ 
/*     */   public void select(String statement, Object parameter, int offset, int limit, ResultHandler handler)
/*     */   {
/*     */     try {
/*  45 */       MappedStatement ms = this.configuration.getMappedStatement(statement);
/*  46 */       if (statement.indexOf("hi.common") >= 0) {
/*  47 */         ms = createMappedStatement(ms, parameter);
/*     */       }
/*     */ 
/*  50 */       this.executor.query(ms, wrapCollection(parameter), offset, limit, handler);
/*     */     } catch (Exception e) {
/*  52 */       throw ExceptionFactory.wrapException(
/*  53 */         "Error querying database.  Cause: " + e, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected MappedStatement createMappedStatement(MappedStatement ms, Object parameter) {
/*  58 */     MappedStatement.Builder statementBuilder = new MappedStatement.Builder(this.configuration, ms.getId(), ms.getSqlSource(), ms.getSqlCommandType());
/*  59 */     statementBuilder.resource(ms.getResource());
/*  60 */     statementBuilder.fetchSize(ms.getFetchSize());
/*  61 */     statementBuilder.statementType(ms.getStatementType());
/*  62 */     statementBuilder.keyGenerator(ms.getKeyGenerator());
/*  63 */     statementBuilder.keyProperty(ms.getKeyProperty());
/*  64 */     statementBuilder.timeout(ms.getTimeout());
/*  65 */     statementBuilder.parameterMap(ms.getParameterMap());
/*  66 */     statementBuilder.cache(ms.getCache());
/*  67 */     statementBuilder.useCache(ms.isUseCache());
/*     */ 
/*  69 */     setStatementResultMap(ms, statementBuilder, parameter);
/*  70 */     MappedStatement ms_statement = statementBuilder.build();
/*  71 */     return ms_statement;
/*     */   }
/*     */ 
/*     */   private void setStatementResultMap(MappedStatement ms, MappedStatement.Builder statementBuilder, Object parameter)
/*     */   {
/*  79 */     List resultMaps = new ArrayList();
/*     */ 
/*  81 */     if (((parameter instanceof Query)) && (ms.getResultMaps().size() == 0)) {
/*  82 */       Query query = (Query)parameter;
/*     */ 
/*  84 */       if (query.getClazz() == null) {
/*  85 */         Class resultType = HashMap.class;
/*  86 */         ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
/*  87 */           this.configuration, 
/*  88 */           statementBuilder.id() + "-Inline", 
/*  89 */           resultType, 
/*  90 */           new ArrayList());
/*  91 */         resultMaps.add(inlineResultMapBuilder.build());
/*     */       }
/*     */       else
/*     */       {
/*  95 */         Class resultType = query.getClazz();
/*  96 */         String resultMapId = resultType.getSimpleName() + "." + resultType.getSimpleName();
/*     */ 
/*  98 */         if (this.configuration.getResultMap(resultMapId) != null) {
/*  99 */           resultMaps.add(this.configuration.getResultMap(resultMapId));
/*     */         } else {
/* 101 */           resultType = HashMap.class;
/* 102 */           ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
/* 103 */             this.configuration, 
/* 104 */             statementBuilder.id() + "-Inline", 
/* 105 */             resultType, 
/* 106 */             new ArrayList());
/* 107 */           resultMaps.add(inlineResultMapBuilder.build());
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 113 */     statementBuilder.resultMaps(resultMaps);
/*     */ 
/* 115 */     statementBuilder.resultSetType(ms.getResultSetType());
/*     */   }
/*     */ 
/*     */   private Object wrapCollection(Object object) {
/* 119 */     if ((object instanceof List)) {
/* 120 */       return new HashMap(object)
/*     */       {
/*     */       };
/*     */     }
/* 125 */     if ((object != null) && (object.getClass().isArray())) {
/* 126 */       return new HashMap(object)
/*     */       {
/*     */       };
/*     */     }
/*     */ 
/* 132 */     return object;
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.ibatis3.IbatisSession
 * JD-Core Version:    0.6.0
 */