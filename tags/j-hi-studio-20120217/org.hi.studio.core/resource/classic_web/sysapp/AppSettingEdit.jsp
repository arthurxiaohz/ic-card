<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="sysapp/AppSetting.js"></script>
</head>
<body>
  <form name="saveForm" action="appSettingSave.action" method="post" onsubmit="return checkValue('appSetting.appGroup,appSetting.appName,appSetting.appValue')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="应用配置"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="appSetting.appGroupLabel"><hi:text key="" entity="AppSetting" />组名:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="appSetting.appGroup" name="appSetting.appGroup" value="<ws:property value="appSetting.appGroup"/>">
				  </td>
				  <td width="15%" class="EditTableKeyLabel"  id="appSetting.appNameLabel"><hi:text key="" entity="AppSetting" />配置名:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="appSetting.appName" name="appSetting.appName" value="<ws:property value="appSetting.appName"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableKeyLabel"  id="appSetting.appValueLabel"><hi:text key="" entity="AppSetting" />配置值:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="appSetting.appValue" name="appSetting.appValue" value="<ws:property value="appSetting.appValue"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="appSetting.descriptionLabel"><hi:text key="" entity="AppSetting" />描述:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="appSetting.description" name="appSetting.description" value="<ws:property value="appSetting.description"/>">
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="appSetting.id" name="appSetting.id" value="<ws:property value="appSetting.id"/>">
				<input type="hidden" id="appSetting.version" name="appSetting.version" value="<ws:property value="appSetting.version"/>">
				<input type="hidden" id="appSetting.creator.id" name="appSetting.creator.id" value="<ws:property value="appSetting.creator.id"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='appSettingList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>