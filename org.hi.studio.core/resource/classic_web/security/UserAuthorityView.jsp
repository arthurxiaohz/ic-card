<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/UserAuthority.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="用户权限" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="userAuthority.userNameLabel"><hi:text key="用户" entity="UserAuthority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="userAuthority.securityUser.id" name="userAuthority.securityUser.id" value="<ws:property value="userAuthority.securityUser.id"/>">
					<ws:property value="userAuthority.securityUser.fullName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="userAuthority.authorityNameLabel"><hi:text key="权限" entity="UserAuthority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="userAuthority.authority.id" name="userAuthority.authority.id" value="<ws:property value="userAuthority.authority.id"/>">
					<ws:property value="userAuthority.authority.description"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="userAuthority.orgNameLabel"><hi:text key="部门" entity="UserAuthority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="userAuthority.org.id" name="userAuthority.org.id" value="<ws:property value="userAuthority.org.id"/>">
					<ws:property value="userAuthority.org.orgName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="userAuthority.scopeLabel"><hi:text key="范围" entity="UserAuthority" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="securityScope" name="userAuthority.scope" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="userAuthority.id" name="userAuthority.id" value="<ws:property value="userAuthority.id"/>">
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
		    <td><ws:if test="workflow==null"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='userAuthorityList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>