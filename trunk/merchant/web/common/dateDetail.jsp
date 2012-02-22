<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="hi" uri="/WEB-INF/tld/hi.tld"%>

<%response.setContentType("text/xml");
	String showstime = "", displayFormat="yyyy-MM-dd";
	String size = (String)request.getParameter("size");
	String inputName = (String)request.getParameter("inputName");
	String dateType = (String)request.getParameter("dateType");
	if(dateType != null && dateType.equals("datetime")){
		showstime = "true";
	}
	String defaultValue = (String)request.getParameter("defaultvalue");
	java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateValue = null;
	if(defaultValue!=null && defaultValue.equals("true")){
		dateValue = sf.format(new Date());
	}
	if (dateValue == null) dateValue = "";
	String readonly = (String)request.getParameter("readonly");
	if(readonly==null || readonly.equals("") || readonly.equals("true")){
		readonly="false";
	}
 %>
 
<%@page import="java.util.Date"%>
<%@page import="javax.swing.text.DateFormatter"%>
<table border="0">
<%if(showstime.equals("true")){ %>
	<input name="<%=inputName%>"   id="<%=inputName%>"
		type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<%=dateValue%>" />
 <%}else{ %>
	<input name="<%=inputName%>"   id="<%=inputName%>"
		type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<%=dateValue%>" />
	<%} %>
</table>
