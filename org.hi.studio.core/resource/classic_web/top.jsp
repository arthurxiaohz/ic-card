<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
<head>
<title></title>
<link href="includes/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" height="75" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="100%" class="TopHead"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td>logo</td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" height="25" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="25" class="TopBottom"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="TopBottomText">
      <tr>
        <td width="30" align="center"><img src="images/dian.gif" width="12" height="11"  /></td>
        <td ><hi:text key="欢迎"/> <ws:property value="@org.hi.framework.security.context.UserContextHelper@getUserName()"/> <hi:text key="登陆"/> [ <a href="j_acegi_logout" target="_parent"><hi:text key="退出"/></a> ]&nbsp;[<a href="index.jsp" target="_parent"><hi:text key="首页"/></a>]</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>