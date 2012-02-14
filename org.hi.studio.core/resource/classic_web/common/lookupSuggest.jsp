
<%@page import="java.net.URLDecoder"%><%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="org.hi.common.util.StringUtils"%>
<%@page import="org.hi.common.util.BeanUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.hi.framework.service.impl.ManagerImpl"%>
<%@page import="org.hi.framework.service.Manager"%>
<%@page import="org.hi.SpringContextHolder"%>

<%response.setContentType("text/xml");
	String className = (String)request.getParameter("className");
	String inputValue = (String)request.getParameter("inputValue");
	String lookupSearchFields = (String)request.getParameter("lookupSearchFields");
	String lookupPrivileges = (String)request.getParameter("lookupPrivileges");
	ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
  
	List reslut = bMgr.getObjectsForLookup(Class.forName(className),StringUtils.encodingTransfer(inputValue,"GBK","iso8859-1"), lookupSearchFields,lookupPrivileges);
	out.print(BeanUtil.getCollection2XML(reslut, "beans", "bean"));
 %>

