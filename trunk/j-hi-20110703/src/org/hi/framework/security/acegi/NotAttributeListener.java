package org.hi.framework.security.acegi;

import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.event.authorization.PublicInvocationEvent;
import org.acegisecurity.intercept.method.aopalliance.MethodSecurityInterceptor;
import org.acegisecurity.intercept.web.FilterInvocation;
import org.acegisecurity.intercept.web.FilterSecurityInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class NotAttributeListener implements ApplicationListener {
	private FilterSecurityInterceptor filterSecurityInterceptor;
	private MethodSecurityInterceptor methodSecurityInterceptor;
	
	public FilterSecurityInterceptor getFilterSecurityInterceptor() {
		return filterSecurityInterceptor;
	}


	public void setFilterSecurityInterceptor(
			FilterSecurityInterceptor filterSecurityInterceptor) {
		this.filterSecurityInterceptor = filterSecurityInterceptor;
	}



	public MethodSecurityInterceptor getMethodSecurityInterceptor() {
		return methodSecurityInterceptor;
	}



	public void setMethodSecurityInterceptor(
			MethodSecurityInterceptor methodSecurityInterceptor) {
		this.methodSecurityInterceptor = methodSecurityInterceptor;
	}


	public void onApplicationEvent(ApplicationEvent event) {
		if(!(event instanceof PublicInvocationEvent))
			return;

		Object object = event.getSource();
		if(object == null)
			return;
		
		ConfigAttributeDefinition attr = null;
		if(object instanceof FilterInvocation)
			attr = this.filterSecurityInterceptor.obtainObjectDefinitionSource().getAttributes(object);
		if(object instanceof MethodInvocation)
			attr = this.methodSecurityInterceptor.obtainObjectDefinitionSource().getAttributes(object);
		
		if(attr == null)
			MethodConfigAttributeDefHolder.setConfigAttributeDefinition(null);
	}

}
