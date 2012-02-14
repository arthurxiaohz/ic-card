<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/Authority.js"></script>
</head>
<body>
  <form name="saveForm" action="authoritySave.action" method="post" onsubmit="return checkValue('authority.authorityName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="权限"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="authority.authorityNameLabel"><hi:text key="权限名称" entity="Authority" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="authority.authorityName" name="authority.authorityName" value="<ws:property value="authority.authorityName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="authority.displayRefLabel"><hi:text key="显示信息" entity="Authority" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="authority.displayRef" name="authority.displayRef" value="<ws:property value="authority.displayRef"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="authority.propertedResourceLabel"><hi:text key="属性资源" entity="Authority" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="authority.propertedResource" name="authority.propertedResource" value="<ws:property value="authority.propertedResource"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="authority.descriptionLabel"><hi:text key="描述" entity="Authority" />:</td>
				  <td width="35%">
					<input type="text" class="EditTableDataText" id="authority.description" name="authority.description" value="<ws:property value="authority.description"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="authority.menuLinkNameLabel"><hi:text key="菜单项" entity="Authority" />:</td>
				  <td width="35%">
					<input type="hidden" id="authority.menuLink.id" name="authority.menuLink.id" value="<ws:property value="authority.menuLink.id"/>">
					<input type="text" class="EditTableDataText" id="authority.menuLinkName" name="authority.menuLinkName" value="<ws:property value="authority.menuLink.description"/>">
					<span onclick="authority_lookupPOP('menuLink')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
				  </td>
				</tr>
				<input type="hidden" id="authority.id" name="authority.id" value="<ws:property value="authority.id"/>">
				<input type="hidden" id="authority.creator.id" name="authority.creator.id" value="<ws:property value="authority.creator.id"/>">
				<input type="hidden" id="authority.authorityType" name="authority.authorityType" value="<ws:property value="authority.authorityType"/>">
				<input type="hidden" id="authority.menuLink" name="authority.menuLink" value="<ws:property value="authority.menuLink"/>">
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
		    <td width="94"><input name="submit" type="image" id="submit" class="EditTableSubmitImage" src="images/save.gif" border="0" tppabs="images/save.gif"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='authorityList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>