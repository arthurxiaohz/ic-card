<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="includes/main.jsp"%>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<%@page import="java.util.Random"%>
<%@page import="org.hi.framework.HiConfigHolder"%>
<%
String success = (String)request.getAttribute("success"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" type="text/css" href="includes/style.css"  >
<title>HI Java快速开发平台</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
.fha{color:#cedde5; text-decoration:none;}
.fha:hover{color:#cedde5; text-decoration:underline;}
.tdbag{background-image:url('styles/images/login_08.gif'); background-repeat:no-repeat; padding-top:60px; vertical-align:top; padding-left:340px;}
.tishi{width:312px; height:auto; color:#b5dff9; font-size:12px; line-height:20px;}
.toplogo{padding:168px 316px 0 305px; color:#cedde5; font-size:12px; vertical-align:top; text-align:center;}
-->
</style>
</head>

<script language='javascript'>
function checkForm( ){
 f.action="register.jsp";
	    f.submit();
}
</script>

<body>
<%if(HiConfigHolder.getVerifyCode()){ %>
<form action="<c:url value='j_security_check'/>" method="POST" onsubmit="return checkedImage()">
<%}else{ %>
<form action="<c:url value='j_security_check'/>" method="POST" name="f">
<%} %>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="217" background="styles/images/login_03.gif" class="toplogo"><img src="styles/images/logo.png" width="230" height="42" border="0"></td>
      </tr>
      <tr>
        <td height="115"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="351" height="115" background="styles/images/login_05.gif">&nbsp;</td>
            <td width="314" background="styles/images/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="26%" height="22"><div align="right"><span class="STYLE1">管理员姓名：</span></div></td>
                <td width="36%" height="22"><div align="center">
                  <input type="text" id="j_username" name="j_username" <c:if test="${not empty param.login_error}">value="<%= session.getAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY) %>"</c:if> style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="38%" height="22">&nbsp;</td>
              </tr>
              <tr>
                <td height="22"><div align="right"><span class="STYLE1">管理员密码：</span></div></td>
                <td height="22"><div align="center">
                  <input type="password" id="j_password" name="j_password" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
              <%
				String sRand = "";
				if(HiConfigHolder.getVerifyCode()){ 
					 //生成随机类
					Random random = new Random();

				   	for (int i=0;i<4;i++){
						String rand=String.valueOf(random.nextInt(10));
						sRand += rand;
					}
			  %>
              <tr>
                <td width="26%" height="22"><div align="right"><span class="STYLE1">验证码：</span></div></td>
                <td width="36%" height="22"><div align="center">
                  <input type="text" id="checkcode" name="checkcode" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                
                </div></td>
                
                <td width="38%" height="22"><div align="left"><img src="image.jsp?sRand=<%=sRand%>" width="40" height="16" border="0"></div></td>
              </tr>
              <%
				}
              %>
              <tr>
                <td height="22" colspan="2" >&nbsp;</td>
                <td height="22"><div align="left"> 
                <input name="image" type="image" id="buttLogin" style="width:49px;height:18px;border:0px"  src="styles/images/dl.gif"  tppabs="styles/images/dl.gif"/>
                <a class="STYLE1" href="register.jsp">注册</a>

                </div></td>
              </tr> 
              <tr> 
                <td height="22">&nbsp;</td>
                <td height="22">&nbsp;</td>
                <td height="22" style="font-size:12px; color:#cedde5;">
                <%
                if(HiConfigHolder.getPublished()){
                %>
             <!--    <a href="#" class="fha">返回首页</a>&nbsp;<a href="#" class="fha">忘记密码?</a>   -->
                <% 
                }
                %>
                </td>
              </tr>
            </table></td>
            <td width="297" background="styles/images/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="269" class="tdbag">
        <div class="tishi">
      	<c:if test="${not empty param.login_error}">
	        你没有登陆成功，请再试一次。<BR><BR>
	        可能的原因: 您输入的用户名或密码错误！<br>
      <ws:if test="!#published">
       Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
      </ws:if>
	    </c:if>
        </div>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<%
// Popup error message window if previous request error.
    if( success != null )  {
        out.println("<script language=\"javascript\">");
        out.println("<!--");
        out.println("alert(\"" + success + "\");");
         out.println("Window.Close();"); 
        
        out.println("-->");
        out.println("</script>");
    }
    request.removeAttribute("success");
%>	
</body>

<script language="javascript">
function checkedImage(){
	if(document.getElementById("j_username").value==""){
		alert("请填写用户名！");
		document.getElementById("j_username").focus();
		return false;
	}
	if(document.getElementById("j_password").value==""){
		alert("请填写密码！");
		document.getElementById("j_password").focus();
		return false;
	}
	
	
<%if(HiConfigHolder.getVerifyCode()){ %>	
	var imageText = document.getElementById("checkcode").value;
	var imageValue = "<%=sRand%>";
	if(imageText==""){
		alert("请输入验证码！");
		document.getElementById("checkcode").focus();
		return false;
	}
	if(imageValue!=imageText){
		alert("您输入的验证码有错！");
		document.getElementById("checkcode").focus();
		return false;
	}
<%}%>	
	return true;
}
 
 
</script>
</html>