/*     */ package org.hi.base.sysapp.interceptor;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.aopalliance.intercept.MethodInterceptor;
/*     */ import org.aopalliance.intercept.MethodInvocation;
/*     */ import org.hi.base.sysapp.model.HiLog;
/*     */ import org.hi.base.sysapp.service.HiLogManager;
/*     */ import org.hi.common.tools.Matcher;
/*     */ import org.hi.common.tools.StringMatcher;
/*     */ import org.hi.framework.security.context.UserContextHelper;
/*     */ import org.hi.framework.service.Manager;
/*     */ import org.hi.framework.service.impl.ManagerImpl;
/*     */ import org.hi.metadata.hsc.HSCHelper;
/*     */ import org.hi.metadata.hsc.context.service.Entity;
/*     */ import org.springframework.beans.factory.InitializingBean;
/*     */ import org.springframework.context.ApplicationEventPublisher;
/*     */ import org.springframework.context.ApplicationEventPublisherAware;
/*     */ 
/*     */ public class MethodLogInterceptor
/*     */   implements MethodInterceptor, InitializingBean, ApplicationEventPublisherAware
/*     */ {
/*     */   private String[] unincludeMethodNames;
/*     */   private Map<String, LogActionInfo> perDesc;
/*     */   private List<LogAnalysisor> analysisors;
/*     */   private LogSaveProcessor saveProcessor;
/*     */   private LogCacheProcessor cacheProcessor;
/*     */ 
/*     */   public Object invoke(MethodInvocation mi)
/*     */     throws Throwable
/*     */   {
/*  39 */     if ((UserContextHelper.getUser() == null) || (org.hi.framework.web.ServletContext.getServletContext() == null)) {
/*  40 */       return mi.proceed();
/*     */     }
/*     */ 
/*  43 */     Manager manager = (Manager)mi.getThis();
/*  44 */     if ((manager.getClass().equals(ManagerImpl.class)) || (HiLogManager.class.isAssignableFrom(manager.getClass()))) {
/*  45 */       return mi.proceed();
/*     */     }
/*  47 */     if (this.analysisors == null) {
/*  48 */       return mi.proceed();
/*     */     }
/*  50 */     String methodName = mi.getMethod().getName();
/*     */ 
/*  52 */     if (this.unincludeMethodNames != null) {
/*  53 */       for (int i = 0; i < this.unincludeMethodNames.length; i++) {
/*  54 */         if (this.unincludeMethodNames[i].equals(methodName)) {
/*  55 */           return mi.proceed();
/*     */         }
/*     */       }
/*     */     }
/*  59 */     String servletRootPath = org.hi.framework.web.ServletContext.getServletContext().getRealPath("");
/*  60 */     Entity entity = null;
/*     */     try {
/*  62 */       entity = HSCHelper.getEntity(servletRootPath, manager.getModelClass());
/*     */     } catch (Exception localException) {
/*     */     }
/*  65 */     if (entity == null) {
/*  66 */       return mi.proceed();
/*     */     }
/*  68 */     HiLog log = processLog(methodName, mi.getArguments(), entity, manager);
/*  69 */     if (log == null) {
/*  70 */       return mi.proceed();
/*     */     }
/*  72 */     Object result = mi.proceed();
/*     */ 
/*  75 */     String postLogInfo = log.analysisor.postProcess(result);
/*  76 */     if (postLogInfo != null) {
/*  77 */       log.setActionContext(log.getActionContext() + postLogInfo);
/*     */     }
/*  79 */     if (log.getActionContext() != null) {
/*  80 */       if (this.cacheProcessor == null)
/*     */       {
/*  82 */         List logs = new ArrayList();
/*  83 */         logs.add(log);
/*  84 */         this.saveProcessor.saveLog(logs);
/*     */       }
/*     */       else {
/*  87 */         this.cacheProcessor.addHiLog(log);
/*     */       }
/*     */     }
/*     */ 
/*  91 */     return result;
/*     */   }
/*     */ 
/*     */   protected HiLog processLog(String methodName, Object[] args, Entity entity, Manager manager) {
/*  95 */     HiLog log = new HiLog();
/*  96 */     log.setOperateDate(new Timestamp(System.currentTimeMillis()));
/*  97 */     log.setOperator(UserContextHelper.getUser());
/*  98 */     String actionDesc = "";
/*  99 */     LogAnalysisor analysisor = null;
/* 100 */     Matcher matcher = new StringMatcher();
/* 101 */     for (Map.Entry entry : this.perDesc.entrySet()) {
/* 102 */       if (matcher.match((String)entry.getKey(), methodName)) {
/* 103 */         actionDesc = ((LogActionInfo)entry.getValue()).getOperateDesc();
/* 104 */         analysisor = ((LogActionInfo)entry.getValue()).getAnalysisor();
/* 105 */         if (getAnalysisors().contains(analysisor)) break;
/* 106 */         return null;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 111 */     if (analysisor != null) {
/* 112 */       log.setAction(actionDesc + entity.getEntityLabel());
/* 113 */       if (args != null) {
/* 114 */         String logContext = analysisor.perProcess(args, entity, manager);
/* 115 */         if (logContext != null)
/* 116 */           log.setActionContext(logContext);
/*     */       }
/* 118 */       log.analysisor = analysisor;
/*     */     }
/* 120 */     return log;
/*     */   }
/*     */ 
/*     */   public String[] getUnincludeMethodNames() {
/* 124 */     return this.unincludeMethodNames;
/*     */   }
/*     */ 
/*     */   public void setUnincludeMethodNames(String[] unincludeMethodNames) {
/* 128 */     this.unincludeMethodNames = unincludeMethodNames;
/*     */   }
/*     */   public List<LogAnalysisor> getAnalysisors() {
/* 131 */     return this.analysisors;
/*     */   }
/*     */ 
/*     */   public void setAnalysisors(List<LogAnalysisor> analysisors) {
/* 135 */     this.analysisors = analysisors;
/*     */   }
/*     */ 
/*     */   public LogSaveProcessor getSaveProcessor()
/*     */   {
/* 140 */     return this.saveProcessor;
/*     */   }
/*     */ 
/*     */   public void setSaveProcessor(LogSaveProcessor saveProcessor) {
/* 144 */     this.saveProcessor = saveProcessor;
/*     */   }
/*     */ 
/*     */   public LogCacheProcessor getCacheProcessor() {
/* 148 */     return this.cacheProcessor;
/*     */   }
/*     */ 
/*     */   public void setCacheProcessor(LogCacheProcessor cacheProcessor) {
/* 152 */     this.cacheProcessor = cacheProcessor;
/*     */   }
/*     */ 
/*     */   public void afterPropertiesSet() throws Exception {
/* 156 */     if (this.cacheProcessor != null) {
/* 157 */       ((AbstractLogCacheProcessor)this.cacheProcessor).setInterceptor(this);
/*     */     }
/* 159 */     this.perDesc = new LinkedHashMap();
/* 160 */     this.perDesc.put("gen*", new LogActionInfo("生成", new LogSaveAnalysisor()));
/* 161 */     this.perDesc.put("save*", new LogActionInfo("保存", new LogSaveAnalysisor()));
/* 162 */     this.perDesc.put("update*", new LogActionInfo("更新", new LogSaveAnalysisor()));
/* 163 */     this.perDesc.put("create*", new LogActionInfo("创建", new LogSaveAnalysisor()));
/* 164 */     this.perDesc.put("process*", new LogActionInfo("处理", new LogSaveAnalysisor()));
/* 165 */     this.perDesc.put("delete*", new LogActionInfo("删除", new LogRemoveAnalysisor()));
/* 166 */     this.perDesc.put("remove*", new LogActionInfo("删除", new LogRemoveAnalysisor()));
/* 167 */     this.perDesc.put("send*", new LogActionInfo("发送", new LogSaveAnalysisor()));
/* 168 */     this.perDesc.put("upload*", new LogActionInfo("上传", new LogSaveAnalysisor()));
/* 169 */     this.perDesc.put("get*List", new LogActionInfo("查询", new LogSearchAnalysisor()));
/* 170 */     this.perDesc.put("get*Objects", new LogActionInfo("查询", new LogSearchAnalysisor()));
/* 171 */     this.perDesc.put("getObject*Id", new LogActionInfo("获取", new LogSearchAnalysisor()));
/* 172 */     this.perDesc.put("get*", new LogActionInfo("搜索", new LogSearchAnalysisor()));
/* 173 */     this.perDesc.put("*", new LogActionInfo("未识别操作", new LogNoknowAnalysisor()));
/*     */   }
/*     */ 
/*     */   public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
/*     */   }
/*     */ 
/*     */   public class LogActionInfo {
/*     */     private String operateDesc;
/*     */     private LogAnalysisor analysisor;
/*     */ 
/*     */     LogActionInfo(String operateDesc, LogAnalysisor analysisor) {
/* 186 */       this.operateDesc = operateDesc;
/* 187 */       this.analysisor = analysisor;
/*     */     }
/*     */ 
/*     */     public void setOperateDesc(String operateDesc)
/*     */     {
/* 193 */       this.operateDesc = operateDesc;
/*     */     }
/*     */ 
/*     */     public String getOperateDesc() {
/* 197 */       return this.operateDesc;
/*     */     }
/*     */ 
/*     */     public LogAnalysisor getAnalysisor() {
/* 201 */       return this.analysisor;
/*     */     }
/*     */ 
/*     */     public void setAnalysisor(LogAnalysisor analysisor) {
/* 205 */       analysisor = analysisor;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.interceptor.MethodLogInterceptor
 * JD-Core Version:    0.6.0
 */