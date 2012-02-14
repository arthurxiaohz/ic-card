<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="menu/MenuLink.js"></script>
</head>
<body>
  <form name="saveForm" action="menuLinkSave.action" method="post" onsubmit="return checkValue('menuLink.linkUrl')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="菜单链接"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="menuLink.linkUrlLabel"><hi:text key="菜单URL" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.linkUrl" name="menuLink.linkUrl" value="<ws:property value="menuLink.linkUrl"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menuLink.displayRefLabel"><hi:text key="显示信息" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.displayRef" name="menuLink.displayRef" value="<ws:property value="menuLink.displayRef"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="menuLink.descriptionLabel"><hi:text key="描述" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.description" name="menuLink.description" value="<ws:property value="menuLink.description"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menuLink.authorityLabel"><hi:text key="权限" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.authority" name="menuLink.authority" value="<ws:property value="menuLink.authority.id"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="menuLink.authorityNameLabel"><hi:text key="权限名称" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="menuLink.authority.id" name="menuLink.authority.id" value="<ws:property value="menuLink.authority.id"/>">
					<input type="text" class="EditTableDataText" id="menuLink.authorityName" name="menuLink.authorityName" value="<ws:property value="menuLink.authority.authorityName"/>" onkeyUp="menuLink_lookupSuggest(event, 'menuLink.authorityName','authority','menuLink.authorityName.suggest')" onclick="menuLink_lookupSuggest(event, 'menuLink.authorityName','authority','menuLink.authorityName.suggest')"    onblur="showAndHide('menuLink.authorityName.suggest','hide');">
					<span onclick="menuLink_lookupPOP('authority')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="menuLink.authorityName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menuLink.sequenceLabel"><hi:text key="序列" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.sequence" name="menuLink.sequence" value="<ws:property value="menuLink.sequence"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="menuLink.menuNameLabel"><hi:text key="菜单项名称" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="menuLink.menu.id" name="menuLink.menu.id" value="<ws:property value="menuLink.menu.id"/>">
					<input type="text" class="EditTableDataText" id="menuLink.menuName" name="menuLink.menuName" value="<ws:property value="menuLink.menu.menuName"/>" onkeyUp="menuLink_lookupSuggest(event, 'menuLink.menuName','menu','menuLink.menuName.suggest')" onclick="menuLink_lookupSuggest(event, 'menuLink.menuName','menu','menuLink.menuName.suggest')"    onblur="showAndHide('menuLink.menuName.suggest','hide');">
					<span onclick="menuLink_lookupPOP('menu')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="menuLink.menuName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menuLink.menuDescriptionLabel"><hi:text key="菜单项描述" entity="MenuLink" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menuLink.menuDescription" name="menuLink.menuDescription" value="<ws:property value="menuLink.menu.description"/>">
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="menuLink.id" name="menuLink.id" value="<ws:property value="menuLink.id"/>">
				<input type="hidden" id="menuLink.menuLinkType" name="menuLink.menuLinkType" value="<ws:property value="menuLink.menuLinkType"/>">
				<input type="hidden" id="menuLink.userName" name="menuLink.userName" value="<ws:property value="menuLink.userName"/>">
				<input type="hidden" id="menuLink.version" name="menuLink.version" value="<ws:property value="menuLink.version"/>">
				<input type="hidden" id="menuLink.creator.id" name="menuLink.creator.id" value="<ws:property value="menuLink.creator.id"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='menuLinkList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>