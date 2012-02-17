<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/includes/main.jsp"%>
<%@ page import="org.hi.framework.web.BusinessException"%>
<%@page import="org.hi.framework.web.taglib.component.bean.Token"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Exception!</title>
</head>

<body>
<% 
	if(session.getAttribute(Token.TOKEN_LIST_NAME) != null){
		Token token = (Token)session.getAttribute(Token.TOKEN_LIST_NAME);
		token.delEndToken();
	}
%>
<table width="400" align="center" valign="middle" border="1" cellspacing="2" cellpadding="2">
<tr><td bgcolor="red" align="center" height="30" style="font-size:9pt;">
    <font color="white"></font>
</td></tr>
<tr><td>
<H2><hi:text key="错误详细信息"/>:</H2>
<font color="red">
<c:if test="${exception!=null}">
${exception.message }
</c:if>
</font><br>
</td>
</tr>
<tr><td align="center">
<input type=button name=return value=<hi:text key="返回"/> onclick="javascript:history.go(-1);">
</td></tr>
</table>
</body>
</html>
