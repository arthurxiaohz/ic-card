<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="hi" uri="/WEB-INF/tld/hi.tld"%>

<%response.setContentType("text/xml");
	String enumName = (String)request.getParameter("enumName");
	String inputName = (String)request.getParameter("inputName");
	String defaultValue = request.getParameter("defaultValue") == null ? "" : request.getParameter("defaultValue");

 %>
<hi:select emu="<%=enumName %>" name="<%=inputName %>" defaultValue="<%=defaultValue%>" />