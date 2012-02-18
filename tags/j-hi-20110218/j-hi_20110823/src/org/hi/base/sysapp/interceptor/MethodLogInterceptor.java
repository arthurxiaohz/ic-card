package org.hi.base.sysapp.interceptor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hi.base.sysapp.model.HiLog;
import org.hi.base.sysapp.service.HiLogManager;
import org.hi.common.tools.Matcher;
import org.hi.common.tools.StringMatcher;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.framework.web.ServletContext;
import org.hi.metadata.hsc.HSCHelper;
import org.hi.metadata.hsc.context.service.Entity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author 张昊
 * @since 2009-12-3
 *
 */
public class MethodLogInterceptor implements MethodInterceptor,InitializingBean, ApplicationEventPublisherAware {
	private String unincludeMethodNames[];
	private Map<String, LogActionInfo> perDesc;
	private List<LogAnalysisor> analysisors;
	private LogSaveProcessor saveProcessor;
	private LogCacheProcessor cacheProcessor;
	
	public Object invoke(MethodInvocation mi) throws Throwable {
//		表示机器的操作
		if(UserContextHelper.getUser() == null || ServletContext.getServletContext() == null)
			return mi.proceed();

//		表示底层业务或日志业务调用
		Manager manager = (Manager)mi.getThis();
		if(manager.getClass().equals(ManagerImpl.class)  || HiLogManager.class.isAssignableFrom( manager.getClass()))
			return mi.proceed();
		
		if(analysisors == null)	//如果不加日志处理器
			return mi.proceed();
		
		String methodName = mi.getMethod().getName();
//		除去例外的方法名
		if(unincludeMethodNames != null){
			for (int i = 0; i < unincludeMethodNames.length; i++) {
				if(unincludeMethodNames[i].equals(methodName))
					return mi.proceed();
			}
		}
		
		String servletRootPath = ServletContext.getServletContext().getRealPath("");
		Entity entity = null;
		try{
			entity = HSCHelper.getEntity(servletRootPath, manager.getModelClass());
		}catch (Exception e) {}
		
		if(entity == null)
			return mi.proceed();
		
		HiLog log = processLog(methodName, mi.getArguments(), entity, manager);
		if(log == null)
			return mi.proceed();
		
		Object result =  mi.proceed();
		
//		添加处理后日志信息
		String postLogInfo = log.analysisor.postProcess(result);
		if(postLogInfo != null)
			log.setActionContext("" + log.getActionContext() + postLogInfo);
		
		if(log.getActionContext() != null){
			if(cacheProcessor == null){
				
				List<HiLog> logs = new ArrayList<HiLog>();
				logs.add(log);
				saveProcessor.saveLog(logs);
			}
			else{
				cacheProcessor.addHiLog(log);
			}
		}
		
		return result;
	}

	protected HiLog processLog(String methodName, Object[] args, Entity entity, Manager manager){
		HiLog log = new HiLog();
		log.setOperateDate(new Timestamp(System.currentTimeMillis()));
		log.setOperator(UserContextHelper.getUser());
		String actionDesc = "";
		LogAnalysisor analysisor = null;
		Matcher matcher = new StringMatcher();
		for (Map.Entry<String, LogActionInfo> entry : perDesc.entrySet()){
			if(matcher.match(entry.getKey(), methodName)){
				actionDesc = entry.getValue().getOperateDesc();
				analysisor = entry.getValue().getAnalysisor();
				if(!this.getAnalysisors().contains(analysisor))
					return null;
				break;
			}
		}
		
		if(analysisor != null){
			log.setAction(actionDesc + entity.getEntityLabel());
			if(args != null){
				String logContext = analysisor.perProcess(args, entity, manager);
				if(logContext != null)
					log.setActionContext(logContext);
			}
			log.analysisor = analysisor;
		}
		return log;
	}
	
	public String[] getUnincludeMethodNames() {
		return unincludeMethodNames;
	}

	public void setUnincludeMethodNames(String[] unincludeMethodNames) {
		this.unincludeMethodNames = unincludeMethodNames;
	}
	public List<LogAnalysisor> getAnalysisors() {
		return analysisors;
	}

	public void setAnalysisors(List<LogAnalysisor> analysisors) {
		this.analysisors = analysisors;
	}

	
	public LogSaveProcessor getSaveProcessor() {
		return saveProcessor;
	}

	public void setSaveProcessor(LogSaveProcessor saveProcessor) {
		this.saveProcessor = saveProcessor;
	}

	public LogCacheProcessor getCacheProcessor() {
		return cacheProcessor;
	}

	public void setCacheProcessor(LogCacheProcessor cacheProcessor) {
		this.cacheProcessor = cacheProcessor;
	}

	public void afterPropertiesSet() throws Exception {
		if(this.cacheProcessor != null)
			((AbstractLogCacheProcessor)this.cacheProcessor).setInterceptor(this);
		
		perDesc = new LinkedHashMap<String, LogActionInfo>();
		perDesc.put("gen*", new LogActionInfo("生成", new LogSaveAnalysisor()));
		perDesc.put("save*", new LogActionInfo("保存", new LogSaveAnalysisor()));
		perDesc.put("update*", new LogActionInfo("更新", new LogSaveAnalysisor()));
		perDesc.put("create*", new LogActionInfo("创建", new LogSaveAnalysisor()));
		perDesc.put("process*", new LogActionInfo("处理", new LogSaveAnalysisor()));
		perDesc.put("delete*", new LogActionInfo("删除", new LogRemoveAnalysisor()));
		perDesc.put("remove*", new LogActionInfo("删除", new LogRemoveAnalysisor()));
		perDesc.put("send*", new LogActionInfo("发送", new LogSaveAnalysisor()));
		perDesc.put("upload*", new LogActionInfo("上传", new LogSaveAnalysisor()));
		perDesc.put("get*List", new LogActionInfo("查询", new LogSearchAnalysisor()));
		perDesc.put("get*Objects", new LogActionInfo("查询", new LogSearchAnalysisor()));
		perDesc.put("getObject*Id", new LogActionInfo("获取", new LogSearchAnalysisor()));
		perDesc.put("get*", new LogActionInfo("搜索", new LogSearchAnalysisor()));
		perDesc.put("*", new LogActionInfo("未识别操作", new LogNoknowAnalysisor()));
		
	}
	
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
    }

    
	public class LogActionInfo{
    	private String operateDesc;
    	private LogAnalysisor analysisor;
    	
    	LogActionInfo(String operateDesc, LogAnalysisor analysisor){
    		this.operateDesc = operateDesc;
    		this.analysisor = analysisor;
    	}

    	
    	
		public void setOperateDesc(String operateDesc) {
			this.operateDesc = operateDesc;
		}

		public String getOperateDesc() {
			return operateDesc;
		}

		public LogAnalysisor getAnalysisor() {
			return analysisor;
		}

		public void setAnalysisor(LogAnalysisor analysisor) {
			analysisor = analysisor;
		}
		
    }
    
    
//    private class SaveLog extends Thread{
//    	HiLog log;
//    	SaveLog(HiLog log){
//    		this.log = log;
//    	}
//    	
//    	public void run() {
//    		super.run();
//    		HiLogManager logMgr = (HiLogManager)SpringContextHolder.getBean(HiLog.class);
//    		logMgr.saveHiLog(log);
//    	}
//    }
}

