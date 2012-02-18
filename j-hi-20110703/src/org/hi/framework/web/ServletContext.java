package org.hi.framework.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContext {
	
	private static ThreadLocal<HttpServletRequest> requestContext = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseContext = new ThreadLocal<HttpServletResponse>();
	
	public static HttpServletRequest getRequest(){
		return requestContext.get();
	}
	
	public static void setRequest(HttpServletRequest request){
		requestContext.set(request);
	}
	
	public static HttpServletResponse getResponse(){
		return responseContext.get();
	}
	
	public static void setResponse(HttpServletResponse response){
		responseContext.set(response);
	}
	
	public static javax.servlet.ServletContext getServletContext(){
		return getRequest().getSession().getServletContext();
	}
}
