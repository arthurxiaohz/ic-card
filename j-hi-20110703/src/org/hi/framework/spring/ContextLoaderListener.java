package org.hi.framework.spring;


/**
 * �������Զ�����web.xml�ļ������õ�<listener>�еļ�����ContextLoaderListener��
 * �����̳���spring�е�ContextLoaderListener�������ռ̳���ServletContextListener����ӿڲ�ʵ����contextInitialized������contextDestroyed����
 * contextInitialized��������Ҫ������ContextLoader�����������web.xml�ļ��е�contextConfigLocation���Ժ�contextClass����
 *
 */
public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {
	
	protected ContextLoader createContextLoader() {
		return new ContextLoader();
	}
}
