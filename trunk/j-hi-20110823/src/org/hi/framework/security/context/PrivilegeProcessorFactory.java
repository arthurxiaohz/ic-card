package org.hi.framework.security.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Ȩ�޴������Ĺ�����,����Ȩ�޴����ʵ�����ɸù�����������.ͬʱ���໹��һ��Ȩ�޴��������������,���ڻ�������
 * �����õ�Ȩ�޴�����ʵ��
 * @author ���
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
