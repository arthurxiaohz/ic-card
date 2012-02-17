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
  <form name="saveForm" action="userAuthoritySave.action" method="post" onsubmit="return checkValue('')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="用户权限"/></td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
		    
﻿        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="EditTableLabel"  id="userAuthority.userNameLabel"><hi:text key="用户" entity="UserAuthority" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="userAuthority.securityUser.id" name="userAuthority.securityUser.id" value="<ws:property value="userAuthority.securityUser.id"/>">
					<input type="text" class="EditTableDataText" id="userAuthority.userName" name="userAuthority.userName" value="<ws:property value="userAuthority.securityUser.fullName"/>" onkeyUp="userAuthority_lookupSuggest(event, 'userAuthority.userName','securityUser','userAuthority.userName.suggest')" onclick="userAuthority_lookupSuggest(event, 'userAuthority.userName','securityUser','userAuthority.userName.suggest')"    onblur="showAndHide('userAuthority.userName.suggest','hide');">
					<span onclick="userAuthority_lookupPOP('securityUser')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="userAuthority.userName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="userAuthority.authorityNameLabel"><hi:text key="权限" entity="UserAuthority" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="userAuthority.authority.id" name="userAuthority.authority.id" value="<ws:property value="userAuthority.authority.id"/>">
					<input type="text" class="EditTableDataText" id="userAuthority.authorityName" name="userAuthority.authorityName" value="<ws:property value="userAuthority.authority.description"/>" onkeyUp="userAuthority_lookupSuggest(event, 'userAuthority.authorityName','authority','userAuthority.authorityName.suggest')" onclick="userAuthority_lookupSuggest(event, 'userAuthority.authorityName','authority','userAuthority.authorityName.suggest')"    onblur="showAndHide('userAuthority.authorityName.suggest','hide');">
					<span onclick="userAuthority_lookupPOP('authority')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="userAuthority.authorityName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="userAuthority.orgNameLabel"><hi:text key="部门" entity="UserAuthority" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="userAuthority.org.id" name="userAuthority.org.id" value="<ws:property value="userAuthority.org.id"/>">
					<input type="text" class="EditTableDataText" id="userAuthority.orgName" name="userAuthority.orgName" value="<ws:property value="userAuthority.org.orgName"/>" onkeyUp="userAuthority_lookupSuggest(event, 'userAuthority.orgName','org','userAuthority.orgName.suggest')" onclick="userAuthority_lookupSuggest(event, 'userAuthority.orgName','org','userAuthority.orgName.suggest')"    onblur="showAndHide('userAuthority.orgName.suggest','hide');">
					<span onclick="userAuthority_lookupPOP('org')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="userAuthority.orgName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="userAuthority.scopeLabel"><hi:text key="范围" entity="UserAuthority" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataEnum" emu="securityScope" name="userAuthority.scope" id="userAuthority.scope"/>

				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="userAuthority.id" name="userAuthority.id" value="<ws:property value="userAuthority.id"/>">
				<input type="hidden" id="userAuthority.version" name="userAuthority.version" value="<ws:property value="userAuthority.version"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='userAuthorityList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>