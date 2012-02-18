package org.hi.framework.security.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限处理器的工厂类,所以权限处理的实例均由该工厂创建出来.同时该类还是一个权限处理器对象的容器,用于缓存所以
 * 待调用的权限处理器实例
 * @author 张昊
 * @since 2011-8-15
 *
 */
public class PrivilegeProcessorFactory {
	
	private static PrivilegeProcessorFactory factory;
	private Map<String, PrivilegeProcessor> processorMap = new HashMap<String, PrivilegeProcessor>();
	private PrivilegeProcessorFactory(){
	}
	
	public static PrivilegeProcessorFactory getInstance(){
		if(factory == null)
			factory = new PrivilegeProcessorFactory();
		return factory;
	}
	
	public PrivilegeProcessor getProcessor(String processorClassName) throws Exception{
		String _processorClassName = processorClassName.trim();
		PrivilegeProcessor processor = processorMap.get(_processorClassName);
		if(processor == null){
			processor = (PrivilegeProcessor) Class.forName(_processorClassName,true,Thread.currentThread().getContextClassLoader()).newInstance();
			processorMap.put(_processorClassName, processor);
		}
		
		return processor;
	}
}
