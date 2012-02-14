<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page import="org.hi.framework.security.context.UserContextHelper"%>
<%@page import="org.hi.base.organization.model.UserType"%><html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <link rel="stylesheet" type="text/css" href="css/calendar.css"  >
   <script type="text/javascript" src="js/common/calendar.js"></script>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiUser.js"></script>
</head>
<%
	String filterUserType = "";
	if(UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_MANAGER){
		filterUserType = "1401,1402";
	}
	
%>
<body>
  <form name="saveForm"  action="securityUserSave.action" method="post" onsubmit="return checkValue('hiUser.userName,hiUser.fullName,hiUser.newPassword')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="用户"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="EditTableKeyLabel"  id="hiUser.fullNameLabel"><hi:text key="姓名" entity="HiUser" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="hiUser.fullName" name="hiUser.fullName" value="<ws:property value="hiUser.fullName"/>">
				  </td>			  
				  <td width="15%" class="EditTableLabel"  id="hiUser.orgNameLabel"><hi:text key="部门" entity="HiUser" />:</td>
				  <td width="35%">
					<input type="hidden" id="hiUser.org.id" name="hiUser.org.id" value="<ws:property value="hiUser.org.id"/>">
					<input type="text" class="EditTableDataText" id="hiUser.orgName" name="hiUser.orgName" value="<ws:property value="hiUser.org.orgName"/>">
					<span onclick="hiUser_lookupPOP('org')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
				  </td>				    
			    </tr>
				<tr>
				  <td width="15%" class="EditTableKeyLabel"  id="hiUser.userNameLabel"><hi:text key="帐号" entity="HiUser" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="hiUser.userName" name="hiUser.userName" value="<ws:property value="hiUser.userName"/>">
				  </td>
				  <td width="15%" class="EditTableKeyLabel"  id="hiUser.accountEnabledLabel"><hi:text key="密码" entity="HiUser" />:</td>
				  <td width="35%">	
					<input type="password"  class="EditTableDataText" id="hiUser.newPassword" name="hiUser.newPassword" value="<ws:property value="hiUser.password"/>">				  			  
				  </td>

			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.accountEnabledLabel"><hi:text key="帐号可用" entity="HiUser" />:</td>
				  <td width="35%">
				    <hi:select type="radio"   emu="yesNo" name="hiUser.accountEnabled" defaultValue="3200" />
				  </td>				
				  <td width="15%" class="EditTableLabel"  id="hiUser.accountLockedLabel"><hi:text key="加锁" entity="HiUser" />:</td>
				  <td width="35%">
				    <hi:select type="radio"   emu="yesNo" name="hiUser.accountLocked" defaultValue="3201" />
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.expiredDateLabel"><hi:text key="有效期至" entity="HiUser" />:</td>
				  <td width="35%">
				    <table border="0" cellpadding="0" cellspacing="0">
				       <input name="hiUser.expiredDate" maxlength="10"	id="hiUser.expiredDate" type="text" size="10" onclick="calendar(this);" value="<ws:property value="hiUser.expiredDate"/>" />
					</table>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiUser.userMgrTypeLabel"><hi:text key="用户类型" entity="HiUser" />:</td>
				  <td width="35%">
				    <hi:select cssClass="EditTableDataText" emu="userType" name="hiUser.userMgrType" defaultValue="1402" filterPattern="<%=filterUserType%>"/>
				  </td>
			    </tr>
				<input type="hidden" id="hiUser.id" name="hiUser.id" value="<ws:property value="hiUser.id"/>">
				<input type="hidden" id="hiUser.org" name="hiUser.org" value="<ws:property value="hiUser.org"/>">
				<input type="hidden" id="hiUser.creator.id" name="hiUser.creator.id" value="<ws:property value="hiUser.creator.id"/>">
			  </table>
			</td>
		  </tr>
		  <tfoot>
			<tr>
			  <td colspan="4">
			    &nbsp;
			  </td>
			</tr>
		  </tfoot>
		</table>  <!-- fields to edit end -->
		<!-- orderDetail edit -->
				
		<script language="JavaScript">
          var detailNames = Array();
		  var detailTabButtons = Array();
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" onclick="if(saveForm.onsubmit()) saveForm.submit();" id="save" value="<hi:text key="保存"    />" class="Button2"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='securityUserList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>