package org.hi.framework.web.webwork;

import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.AroundInterceptor;


public class NothingInterceptor extends AroundInterceptor {

	protected void after(ActionInvocation dispatcher, String result) throws Exception {
	}

	protected void before(ActionInvocation invocation) throws Exception {

	}
	
}
