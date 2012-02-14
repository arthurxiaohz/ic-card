<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <link rel="stylesheet" type="text/css" href="css/calendar.css"  >
  <script type="text/javascript" src="js/common/calendar.js"></script>
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="organization/HiUser.js"></script>
  <s:head theme="ajax" /> 
</head>
<body>
  <form name="saveForm" action="hiUserSave.action" method="post" onsubmit="return checkValue('hiUser.userName,hiUser.fullName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="人员"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="hiUser.userNameLabel"><hi:text key="帐号" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.userName" name="hiUser.userName" value="<ws:property value="hiUser.userName"/>">
				  </td>
				  <td width="15%" class="EditTableKeyLabel"  id="hiUser.fullNameLabel"><hi:text key="姓名" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.fullName" name="hiUser.fullName" value="<ws:property value="hiUser.fullName"/>">
				  </td>
			    </tr>
				<tr>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.orgNameLabel"><hi:text key="部门" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="hiUser.org.id" name="hiUser.org.id" value="<ws:property value="hiUser.org.id"/>">
					<input type="text" class="EditTableDataText" id="hiUser.orgName" name="hiUser.orgName" value="<ws:property value="hiUser.org.orgName"/>" onkeyUp="hiUser_lookupSuggest(event, 'hiUser.orgName','org','hiUser.orgName.suggest')" onclick="hiUser_lookupSuggest(event, 'hiUser.orgName','org','hiUser.orgName.suggest')"    onblur="showAndHide('hiUser.orgName.suggest','hide');">
					<span onclick="hiUser_lookupPOP('org')"><img src="images/lookup.gif" width="18" height="17" border="0" style="cursor: hand"/></span>
					<br/>
					<div class="SuggestList" id="hiUser.orgName.suggest">
						<div class="SuggestMain">
							<ul>
							</ul>
					    </div>
					</div>
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiUser.genderLabel"><hi:text key="性别" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataEnum" type="radio" emu="gender" name="hiUser.gender" id="hiUser.gender"/>

				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.addressLabel"><hi:text key="地址" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.address" name="hiUser.address" value="<ws:property value="hiUser.address"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiUser.phoneLabel"><hi:text key="电话" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.phone" name="hiUser.phone" value="<ws:property value="hiUser.phone"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.mobileLabel"><hi:text key="手机" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.mobile" name="hiUser.mobile" value="<ws:property value="hiUser.mobile"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiUser.zipLabel"><hi:text key="邮编" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.zip" name="hiUser.zip" value="<ws:property value="hiUser.zip"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.sSNLabel"><hi:text key="身份证" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.sSN" name="hiUser.sSN" value="<ws:property value="hiUser.sSN"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="hiUser.mailLabel"><hi:text key="E-Mail" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.mail" name="hiUser.mail" value="<ws:property value="hiUser.mail"/>">
				  </td>
			    </tr>
			    <tr>
			     <td width="15%" class="EditTableLabel"  id="hiUser.countryLabel"><hi:text key="时区" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<hi:entitySelect entityName="org.hi.i18n.model.Timezone" key="timezone" title="description" name="hiUser.timeZone" />
				  </td>
			    
		
				  <td width="15%" class="EditTableLabel"  id="hiUser.timeZoneLabel"><hi:text key="语言" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<hi:entitySelect entityName="org.hi.i18n.model.LanguageCode"   key="id" title="description" name="hiUser.country" />
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.notifyModeLabel"><hi:text key="提醒方式" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.notifyMode" name="hiUser.notifyMode" value="<ws:property value="hiUser.notifyMode"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="hiUser.descriptionLabel"><hi:text key="描述" entity="HiUser" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="hiUser.description" name="hiUser.description" value="<ws:property value="hiUser.description"/>">
				  </td>
				</tr>
				<input type="hidden" id="hiUser.id" name="hiUser.id" value="<ws:property value="hiUser.id"/>">
				<input type="hidden" id="hiUser.password" name="hiUser.password" value="<ws:property value="hiUser.password"/>">
				<input type="hidden" id="hiUser.creator.id" name="hiUser.creator.id"" value="<ws:property value="hiUser.creator.id"/>">
				<input type="hidden" id="hiUser.deleted" name="hiUser.deleted" value="<ws:property value="hiUser.deleted"/>">
				<input type="hidden" id="hiUser.version" name="hiUser.version" value="<ws:property value="hiUser.version"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='hiUserList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>