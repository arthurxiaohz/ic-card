package org.hi.framework.spring;


/**
 * 容器会自动加载web.xml文件中配置的<listener>中的监听器ContextLoaderListener，
 * 这个类继承了spring中的ContextLoaderListener，而最终继承了ServletContextListener这个接口并实现了contextInitialized方法和contextDestroyed方法
 * contextInitialized方法的主要作用是ContextLoader这个类来加载web.xml文件中的contextConfigLocation属性和contextClass属性
 *
 */
public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {
	
	protected ContextLoader createContextLoader() {
		return new ContextLoader();
	}
}
