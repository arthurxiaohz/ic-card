package org.hi.framework.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �ýӿ��Ǳ��ֲ㶯����ִ����,�����ṩ��Ҫִ�еĶ�������execute()������.���ṩ��һЩ��ȡ
 * request/response/session�����ַ���.����֮�⻹�ṩ��һЩ���ϵĹ��߷���,ǰ�ö��������ö���
 * ���ļ��ϴ���
 * 
 * @author ���
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
