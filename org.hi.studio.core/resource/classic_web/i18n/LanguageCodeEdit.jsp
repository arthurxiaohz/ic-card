<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="i18n/LanguageCode.js"></script>
</head>
<body>
  <form name="saveForm" action="languageCodeSave.action" method="post" onsubmit="return checkValue('languageCode.languageCode')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="语言编码"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="languageCode.languageCodeLabel"><hi:text key="语言编码" entity="LanguageCode" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="languageCode.languageCode" name="languageCode.languageCode" value="<ws:property value="languageCode.languageCode"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="languageCode.descriptionLabel"><hi:text key="描述" entity="LanguageCode" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="languageCode.description" name="languageCode.description" value="<ws:property value="languageCode.description"/>">
				  </td>
			    </tr>
				<tr>
				</tr>
				<input type="hidden" id="languageCode.id" name="languageCode.id" value="<ws:property value="languageCode.id"/>">
				<input type="hidden" id="languageCode.version" name="languageCode.version" value="<ws:property value="languageCode.version"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='languageCodeList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>