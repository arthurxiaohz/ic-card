<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="/styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="/css/ajaxcss.css"  >
  <script type="text/javascript" src="/js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="/security/UserRole.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="用户角色" /></td>
    </tr>
    <tr>
      <td valign="top" class="ViewTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="ViewTableLabel"  id="userRole.userNameLabel"><hi:text key="用户" entity="UserRole" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="userRole.securityUser.id" name="userRole.securityUser.id" value="<ws:property value="userRole.securityUser.id"/>">
					<ws:property value="userRole.securityUser.fullName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="userRole.roleNameLabel"><hi:text key="角色名称" entity="UserRole" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="userRole.role.id" name="userRole.role.id" value="<ws:property value="userRole.role.id"/>">
					<ws:property value="userRole.role.roleName"/>
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="userRole.id" name="userRole.id" value="<ws:property value="userRole.id"/>">
				<input type="hidden" id="userRole.securityUser" name="userRole.securityUser" value="<ws:property value="userRole.securityUser"/>">
				<input type="hidden" id="userRole.role" name="userRole.role" value="<ws:property value="userRole.role"/>">
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
				
		<script language="JavaScript">
          var detailNames = Array();
		  var detailTabButtons = Array();
		</script>
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='/userRoleList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>