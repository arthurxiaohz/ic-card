<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="hi" uri="/WEB-INF/tld/hi.tld"%>

<%response.setContentType("text/xml");
	String name = (String)request.getParameter("inputName");
	String entityName = (String)request.getParameter("entityName");
	String filterStr = (String)request.getParameter("filterStr");
	String pageInfo = (String)request.getParameter("pageInfo");	
	String key = (String)request.getParameter("key");
	String title = (String)request.getParameter("title");	
	String pattern = request.getParameter("pattern") == null ||  request.getParameter("pattern").equals("undefined") ? "" : request.getParameter("pattern");
	String onEvent = request.getParameter("onEvent")==null || request.getParameter("onEvent").equals("undefined") ? "" : (String)request.getParameter("onEvent");
 %>
 
<hi:entitySelect name="<%=name%>" entityName="<%=entityName%>" filterStr="<%=filterStr%>" pageInfo="<%=pageInfo%>" key="<%=key%>" title="<%=title%>" pattern="<%=pattern%>" onEvent="<%=onEvent%>"/> 