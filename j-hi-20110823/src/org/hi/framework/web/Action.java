package org.hi.framework.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 该接口是表现层动作的执行器,除了提供所要执行的动作方法execute()方法外.还提供了一些获取
 * request/response/session的助手方法.除此之外还提供了一些整合的工具方法,前置动作、后置动作
 * 、文件上传等
 * 
 * @author 张昊
 * @since 2008-12-15
 * 
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 * @see javax.servlet.http.HttpSession
 */
public interface Action {
	public static final String UNCODE_PARAMETER_KEY = "org.hi.framework.web.webwork.BaseAction.uncode_parameter_key";
	public String execute() throws Exception;
	public String getLookup();
	public HttpServletRequest getRequest();
	public HttpServletResponse getResponse();
	public HttpSession getSession();
	public String getParameter(String name);
	public String saveFile(File file, String fileName,String moduleName) throws IOException;
	public String perExecute(Object obj) throws Exception;
	public String postExecute(Object obj) throws Exception;
	
}
