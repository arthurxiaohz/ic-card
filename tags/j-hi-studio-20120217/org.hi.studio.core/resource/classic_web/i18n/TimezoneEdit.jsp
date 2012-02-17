<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="i18n/Timezone.js"></script>
</head>
 
<body>
  <form name="saveForm" action="timezoneSave.action" method="post" onsubmit="return checkValue('timezone.timezone,timezone.description')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="时区"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="timezone.timezoneLabel"><hi:text key="时区值" entity="Timezone" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="timezone.timezone" validator="integer" name="timezone.timezone" value="<ws:property value="timezone.timezone"/>">
				  </td>
				  <td width="15%" class="EditTableKeyLabel"  id="timezone.descriptionLabel"><hi:text key="描述" entity="Timezone" />:</td>
				  <td width="35%" class="EditTableData">
				  		<hi:mlText value="timezone.description" />
						 
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="timezone.id" name="timezone.id" value="<ws:property value="timezone.id"/>">
				<input type="hidden" id="timezone.version" name="timezone.version" value="<ws:property value="timezone.version"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='timezoneList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>