<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiOrg.js"></script>
</head>
<body>
  <form name="saveForm" action="hiOrgSave.action" method="post" onsubmit="return checkValue('hiOrg.orgName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="部门"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="hiOrg.orgNameLabel"><hi:text key="部门名称" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiOrg.orgName" name="hiOrg.orgName" value="<ws:property value="hiOrg.orgName"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiOrg.orgNumLabel"><hi:text key="部门编号" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiOrg.orgNum" name="hiOrg.orgNum" value="<ws:property value="hiOrg.orgNum"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiOrg.managerNameLabel"><hi:text key="部门经理" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="hiOrg.manager.id" name="hiOrg.manager.id" value="<ws:property value="hiOrg.manager.id"/>">
					<input type="text" class="EditTableDataText" id="hiOrg.managerName" name="hiOrg.managerName" value="<ws:property value="hiOrg.manager.fullName"/>" onkeyUp="hiOrg_lookupSuggest(event, 'hiOrg.managerName','manager','hiOrg.managerName.suggest')" onclick="hiOrg_lookupSuggest(event, 'hiOrg.managerName','manager','hiOrg.managerName.suggest')"    onblur="showAndHide('hiOrg.managerName.suggest','hide');">
					<span onclick="hiOrg_lookupPOP('manager')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="hiOrg.managerName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiOrg.parentOrgNameLabel"><hi:text key="上级部门" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="hiOrg.parentOrg.id" name="hiOrg.parentOrg.id" value="<ws:property value="hiOrg.parentOrg.id"/>">
					<input type="text" class="EditTableDataText" id="hiOrg.parentOrgName" name="hiOrg.parentOrgName" value="<ws:property value="hiOrg.parentOrg.orgName"/>" onkeyUp="hiOrg_lookupSuggest(event, 'hiOrg.parentOrgName','parentOrg','hiOrg.parentOrgName.suggest')" onclick="hiOrg_lookupSuggest(event, 'hiOrg.parentOrgName','parentOrg','hiOrg.parentOrgName.suggest')"    onblur="showAndHide('hiOrg.parentOrgName.suggest','hide');">
					<span onclick="window.open('/tree.action?menuName=hiorg','部门','width=300,height=500,left=10,top=20,location=no,status=no')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="hiOrg.parentOrgName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiOrg.addressLabel"><hi:text key="地址" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiOrg.address" name="hiOrg.address" value="<ws:property value="hiOrg.address"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiOrg.descriptionLabel"><hi:text key="描述" entity="HiOrg" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiOrg.description" name="hiOrg.description" value="<ws:property value="hiOrg.description"/>">
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="hiOrg.id" name="hiOrg.id" value="<ws:property value="hiOrg.id"/>">
				<input type="hidden" id="hiOrg.userName" name="hiOrg.userName" value="<ws:property value="hiOrg.userName"/>">
				<input type="hidden" id="hiOrg.deleted" name="hiOrg.deleted" value="<ws:property value="hiOrg.deleted"/>">
				<input type="hidden" id="hiOrg.version" name="hiOrg.version" value="<ws:property value="hiOrg.version"/>">
				<input type="hidden" id="hiOrg.creator.id" name="hiOrg.creator.id" value="<ws:property value="hiOrg.creator.id"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='hiOrgList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>