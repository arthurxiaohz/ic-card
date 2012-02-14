<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="menu/Menu.js"></script>
</head>
<body>
  <form name="saveForm" action="menuSave.action" method="post" onsubmit="return checkValue('menu.menuName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="菜单项"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="menu.menuNameLabel"><hi:text key="菜单名称" entity="Menu" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menu.menuName" name="menu.menuName" value="<ws:property value="menu.menuName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menu.displayRefLabel"><hi:text key="显示信息" entity="Menu" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menu.displayRef" name="menu.displayRef" value="<ws:property value="menu.displayRef"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="menu.descriptionLabel"><hi:text key="描述" entity="Menu" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menu.description" name="menu.description" value="<ws:property value="menu.description"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="menu.parentMenuNameLabel"><hi:text key="父菜单项" entity="Menu" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="menu.parentMenu.id" name="menu.parentMenu.id" value="<ws:property value="menu.parentMenu.id"/>">
					<input type="text" class="EditTableDataText" id="menu.parentMenuName" name="menu.parentMenuName" value="<ws:property value="menu.parentMenu.menuName"/>" onkeyUp="menu_lookupSuggest(event, 'menu.parentMenuName','parentMenu','menu.parentMenuName.suggest')" onclick="menu_lookupSuggest(event, 'menu.parentMenuName','parentMenu','menu.parentMenuName.suggest')"    onblur="showAndHide('menu.parentMenuName.suggest','hide');">
					<span onclick="menu_lookupPOP('parentMenu')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="menu.parentMenuName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="menu.sequenceLabel"><hi:text key="序列" entity="Menu" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="menu.sequence" name="menu.sequence" value="<ws:property value="menu.sequence"/>">
				  </td>
				</tr>
				<input type="hidden" id="menu.id" name="menu.id" value="<ws:property value="menu.id"/>">
				<input type="hidden" id="menu.menuType" name="menu.menuType" value="<ws:property value="menu.menuType"/>">
				<input type="hidden" id="menu.userName" name="menu.userName" value="<ws:property value="menu.userName"/>">
				<input type="hidden" id="menu.version" name="menu.version" value="<ws:property value="menu.version"/>">
				<input type="hidden" id="menu.creator.id" name="menu.creator.id" value="<ws:property value="menu.creator.id"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='menuList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>