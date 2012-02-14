<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="/styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="/css/ajaxcss.css"  >
  <script type="text/javascript" src="/js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="/security/RoleAuthority.js"></script>
</head>
<body>
  <form action="/roleAuthoritySave.action" method="post" onsubmit="return checkValue('')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="角色权限"/></td>
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
				  <td width="15%" class="EditTableLabel"  id="roleAuthority.roleNameLabel"><hi:text key="角色名称" entity="RoleAuthority" />:</td>
				  <td width="35%">
					<input type="hidden" id="roleAuthority.role.id" name="roleAuthority.role.id" value="<ws:property value="roleAuthority.role.id"/>">
					<input type="text" class="EditTableDataText" id="roleAuthority.roleName" name="roleAuthority.roleName" value="<ws:property value="roleAuthority.role.roleName"/>">
					<span onclick="roleAuthority_lookupPOP('role')"><img src="/images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="roleAuthority.authorityNameLabel"><hi:text key="用户" entity="RoleAuthority" />:</td>
				  <td width="35%">
					<input type="hidden" id="roleAuthority.authority.id" name="roleAuthority.authority.id" value="<ws:property value="roleAuthority.authority.id"/>">
					<input type="text" class="EditTableDataText" id="roleAuthority.authorityName" name="roleAuthority.authorityName" value="<ws:property value="roleAuthority.authority.authorityName"/>">
					<span onclick="roleAuthority_lookupPOP('authority')"><img src="/images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="roleAuthority.orgNameLabel"><hi:text key="部门" entity="RoleAuthority" />:</td>
				  <td width="35%">
					<input type="hidden" id="roleAuthority.org.id" name="roleAuthority.org.id" value="<ws:property value="roleAuthority.org.id"/>">
					<input type="text" class="EditTableDataText" id="roleAuthority.orgName" name="roleAuthority.orgName" value="<ws:property value="roleAuthority.org.orgName"/>">
					<span onclick="roleAuthority_lookupPOP('org')"><img src="/images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="roleAuthority.scopeLabel"><hi:text key="范围" entity="RoleAuthority" />:</td>
				  <td width="35%">
				    <hi:select cssClass="EditTableDataText" emu="securityScope" name="roleAuthority.scope" />

				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="roleAuthority.id" name="roleAuthority.id" value="<ws:property value="roleAuthority.id"/>">
				<input type="hidden" id="roleAuthority.role" name="roleAuthority.role" value="<ws:property value="roleAuthority.role"/>">
				<input type="hidden" id="roleAuthority.authority" name="roleAuthority.authority" value="<ws:property value="roleAuthority.authority"/>">
				<input type="hidden" id="roleAuthority.org" name="roleAuthority.org" value="<ws:property value="roleAuthority.org"/>">
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
		    <td width="94"><input name="submit" type="image" id="submit" class="EditTableSubmitImage" src="/images/save.gif" border="0" tppabs="images/save.gif"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='/roleAuthorityList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>