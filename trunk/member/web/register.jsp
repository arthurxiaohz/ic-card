<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="includes/main.jsp"%>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<%@page import="java.util.Random"%>
<%@page import="org.hi.framework.HiConfigHolder"%>
<%String error = (String)request.getAttribute("error");
String success = (String)request.getAttribute("success"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" type="text/css" href="includes/style.css"  >
<title>会员服务平台</title>
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
.tdbag{background-image:url(''); background-repeat:no-repeat; padding-top:60px; vertical-align:top; padding-left:340px;}
.tishi{width:312px; height:auto; color:#b5dff9; font-size:12px; line-height:20px;}
.toplogo{padding:168px 316px 0 305px; color:#cedde5; font-size:12px; vertical-align:top; text-align:center;}
-->
</style>
</head>
<script type="text/javascript">
function check_02(){

		}
</script>
<body>
<%if(HiConfigHolder.getVerifyCode()){ %>
<form action="tblMbInfoRegister.action" method="POST" onsubmit="return checkedImage()">
<%}else{ %>
<form action="<c:url value='j_security_check'/>" method="POST" name="form1">
<%} %>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="50"  class="toplogo"><img src="styles/images/logo.png" width="230" height="42" border="0"></td>
      </tr>
      <tr>
        <td height="200"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="351" height="500" >&nbsp;</td>
            <td width="314" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="26%" height="22"><div align="right"><span class="STYLE1">用户名：</span></div></td>
                <td width="36%" height="22"><div align="center">
                  <input type="text" id="UserName" name="UserName" value="" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="38%" height="22">&nbsp;</td>
              </tr>
              <tr>
                <td height="22"><div align="right"><span class="STYLE1">密码：</span></div></td>
                <td height="22"><div align="center">
                  <input type="password" id="password" name="password" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
               <tr>
                <td height="22"><div align="right"><span class="STYLE1">确认密码：</span></div></td>
                <td height="22"><div align="center">
                  <input type="password" id="password1" name="password1" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
               <tr>
                <td height="22"><div align="right"><span class="STYLE1">卡号：</span></div></td>
                <td height="22"><div align="center">
                  <input type="text" id="cardNo" name="cardNo" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
              <tr>
                <td height="22"><div align="right"><span class="STYLE1">真实姓名：</span></div></td>
                <td height="22"><div align="center">
                  <input type="text" id="FullName" name="FullName" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
               <tr>
                <td height="22"><div align="right"><span class="STYLE1">身份证号码：</span></div></td>
                <td height="22"><div align="center">
                  <input type="text" id="SSN" name="SSN" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
               <tr>
                <td height="22"><div align="right"><span class="STYLE1">邮箱：</span></div></td>
                <td height="22"><div align="center">
                  <input type="text" id="email" name="email" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="22">&nbsp;</td>
              </tr>
               <tr>
                <td height="22"><div align="right"><span class="STYLE1">注册码：</span></div></td>
                <td height="22"><div align="center">
                  <input type="text" id="registerId" name="registerId" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
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
                <input name="image" type="image" id="buttLogin" style="width:49px;height:18px;border:0px"  src="styles/images/zhuce.gif"  tppabs="styles/images/zhuce.gif"/>
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
            <td width="297" >&nbsp;</td>
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
    if( error != null )  {
        out.println("<script language=\"javascript\">");
        out.println("<!--");
        out.println("alert(\"" + error + "\");");
        out.println("-->");
        out.println("</script>");
    }
    request.removeAttribute("error");
%>	

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
	if(document.getElementById("UserName").value==""){
		alert("请填写用户名！");
		document.getElementById("UserName").focus();
		return false;
	}
	if(document.getElementById("password").value==""){
		alert("请填写密码！");
		document.getElementById("password").focus();
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
	
	
		if(javaTrim(document.getElementById("password1").value)==''){
			document.getElementById("password1").focus();
		    alert("请确认密码");
			return false;
		
		}
		if(document.getElementById("password").value!=document.getElementById("password1").value){
			alert("两次输入的密码不一致，请重新输入");
			document.getElementById("password").value='';
			document.getElementById("password1").value='';
			document.getElementById("password").focus();
			return false;
		}
		if(javaTrim(document.getElementById("email").value)!=''){
		
		if(!/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/.test(document.form1.email.value)){
		    alert("email格式错误");
			document.form1.email.value='';
			document.form1.email.focus();
			return false;
		  }
		
		}
	return true;
}
 
 
function javaTrim(string)
{
	var length1, i, j;
	var string1 = "";
	
	length1 = string.length;
	for (i = 0 ; i < length1 ; i++)
	{  //除去左边空格
		if(string.charAt(i) != " ")
		{//除去左边空格后
			for (j = i ; j < length1 ; j++) 
				string1 = string1 + string.charAt(j);
				break;	
		}
	}	
	length1 = string1.length;
	string = string1;
	string1 = "";
	for (i = length1 - 1 ; i >= 0 ; i--) 
	{  //除去右边空格
		if(string.charAt(i) != " ") 
		{//除去右边空格后
			for (j = 0 ; j <= i ; j++) 
				string1 = string1 + string.charAt(j);
				break;	
		}
	}
	string = string1;	
	return(string)	
}
 
</script>
</html>