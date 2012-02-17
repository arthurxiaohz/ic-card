<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="includes/main.jsp"%>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<%@page import="java.util.Random"%>

<%@page import="org.hi.framework.HiConfigHolder"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="includes/style.css"  >
<title><hi:text key="HI平台"/></title>

</head>
<body>
<div id="wrap">

		<table height="100%" width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div id="loginHead">
						<div id="powerBy"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%" id="loginBody">
				  <div>
				       <div>
						<table width="100%" border="0" height="100%">
							<tbody>
							<tr>
								<td id="loginImage" width="100%" align="center" style="width:55%; padding-bottom:60px;">
									<div></div>
								</td>
								<td id="loginFormCont">
<%if(HiConfigHolder.getVerifyCode()){ %>
									<form action="<c:url value='j_security_check'/>" method="POST" onsubmit="return checkedImage()">
<%}else{ %>
									 <form action="<c:url value='j_security_check'/>" method="POST" >
<%} %>
									  <table border="0" cellpadding="5" cellspacing="2">
											<tbody>
												<tr>
											  <td colspan="2" style="padding-right:5px;font-size:12px;">
											   <c:if test="${not empty param.login_error}">
											      <font color="orange">
											        <hi:text key="你没有登陆成功"/><BR><BR>
											        <hi:text key="可能的原因"/><br>
											      <ws:if test="!#published">
											       Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
											      </ws:if>
											      </font>
											    </c:if>
											  </td>
											  </tr>
											<tr>
												<td nowrap>
													<label style="color: white"><hi:text key="用户名 "/>:</label>												</td>
												<td><input type='text' id='j_username' name='j_username' <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY) %>'</c:if>></td>
											</tr>
											<tr>
												<td>
													<label style="color: white"><hi:text key="密码"/>:</label>												</td>
												<td>
													
													<input type='password' id='j_password' name='j_password'>
																									</td>
											</tr>
											<tr>
<%
String sRand = "";
if(HiConfigHolder.getVerifyCode()){ %>
												<td>
													<label style="color: white"><hi:text key="验证码"/>:</label>												</td>
											  <td>
											  <%
											  //生成随机类
												Random random = new Random();

											   	for (int i=0;i<4;i++){
    												String rand=String.valueOf(random.nextInt(10));
    												sRand += rand;
    											}
											    //System.out.println("current="+sRand);
											
											 %>
													<input id="checkcode" name="checkcode"  type="text" maxlength="4" style="width:66px"/>
												  <img width="100" height="20" src="image.jsp?sRand=<%=sRand%>"  border="1" align="absmiddle">												</td>
												  
<%} %>
											</tr>
											<tr>
												<td colspan="2" style="padding-top:20px;"><input name="image" type="image" id="buttLogin" style="width:222px;height:41px;border:0px"  src="images/login.gif" border="0" tppabs="images/login.gif"/></td>
											</tr>
											</tbody>
										</table>
									</form>
								</td>
							</tr>
							</tbody>
						</table>
				     </div>
				  </div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="loginFoot">
						<div id="copyright"></div>
					</div>
				</td>
			</tr>
		</table>
</div>
<script language="javascript">

function checkedImage(){
	
	var imageText = document.getElementById("checkcode").value;
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
</body>
</html>