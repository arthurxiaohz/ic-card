<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="org.hi.framework.web.BusinessException"%>

<%@page import="org.hi.framework.web.taglib.component.bean.Token"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Exception!</title>
</head>

<body>

<table width="400" align="center" valign="middle" border="1" cellspacing="2" cellpadding="2">
<tr><td bgcolor="red" align="center" height="30" style="font-size:9pt;">
    <font color="white">权限管理</font>
</td></tr>
<tr><td>
<H2>错误详细信息:</H2>
<font color="red">您没有操作此功能的权限!</font><br>
</td>
</tr>
<tr><td align="center">
<input type=button name=return value="关闭" onclick="javascript:window.close();">
</td></tr>
</table>
</body>
</html>
