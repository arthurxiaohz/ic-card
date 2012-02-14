<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/includes/main.jsp"%>
<%@ page import="org.hi.framework.web.BusinessException"%>

<%@page import="org.hi.framework.web.taglib.component.bean.Token"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><hi:text key="错误详细信息"/></title>
</head>

<body>

<table width="400" align="center" valign="middle" border="1" cellspacing="2" cellpadding="2">
<tr><td bgcolor="red" align="center" height="30" style="font-size:9pt;">
    <font color="white"><hi:text key="权限管理"/></font>
</td></tr>
<tr><td>
<H2><hi:text key="错误详细信息"/>:</H2>
<font color="red"><hi:text key="您没有操作此功能的权限"/>!</font><br>
</td>
</tr>
<tr><td align="center">
<input type=button name=return value="<hi:text key="关闭"/>" onclick="javascript:window.close();">
</td></tr>
</table>
</body>
</html>
