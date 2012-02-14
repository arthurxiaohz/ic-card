<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="hi" uri="/WEB-INF/tld/hi.tld"%>

<%response.setContentType("text/xml");
	String enmName = (String)request.getParameter("emuName");
	String inputName = (String)request.getParameter("inputName");
	String defaultValue = request.getParameter("defaultValue") == null ? "" : request.getParameter("defaultValue");

 %>
<hi:select emu="<%=enmName %>" name="<%=inputName %>" defaultValue="<%=defaultValue%>"/>