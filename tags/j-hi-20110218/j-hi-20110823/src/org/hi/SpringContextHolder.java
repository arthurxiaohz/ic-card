package org.hi;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

/**
 * ��Spring��صĹ�����,��������г�Ա������Ϊ��̬����,���Ի�ȡSpring�����е�
 * ��������Ϣ
 * @author ���
 * @since 2007-1-31
 *
 */
public class SpringContextHolder implements ApplicationContextAware, BeanFactoryPostProcessor {
	private static ApplicationContext applicationContext;
	

	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	public static Object getBean(Class clzz){
		return getBean(clzz.getName());
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;

	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static ServletContext getServletContext(){
		if(applicationContext instanceof WebApplicationContext){
			return ((WebApplicationContext)applicationContext).getServletContext();
		}
		return null;
	}
	

//	��Bean�������ô�����,ֻ��Ϊ����Ӧspring��IOC����˳��,ʹ�����������ʱ��һ����ʵ������������
	public void postProcessBeanFactory(	ConfigurableListableBeanFactory beanFactory) throws BeansException {
		;
	}


}
