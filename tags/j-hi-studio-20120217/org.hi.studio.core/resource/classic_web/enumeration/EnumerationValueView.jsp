<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="enumeration/EnumerationValue.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="枚举值" /></td>
    </tr>
    <tr>
      <td valign="top" class="ViewTableBackground">
		    
        <input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTable"> <!-- fields to edit  -->
          <tr>
            <td height="5" >  </td>      
       	  </tr>
		  <tr>
		    <td >
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				  <td width="15%" class="ViewTableLabel"  id="enumerationValue.valueNameLabel"><hi:text key="枚举值名称" entity="EnumerationValue" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumerationValue.valueName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="enumerationValue.displayRefLabel"><hi:text key="显示信息" entity="EnumerationValue" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumerationValue.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="enumerationValue.descriptionLabel"><hi:text key="描述" entity="EnumerationValue" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="enumerationValue.description"/>
				  </td>
				</tr>
				<input type="hidden" id="enumerationValue.id" name="enumerationValue.id" value="<ws:property value="enumerationValue.id"/>">
				<input type="hidden" id="enumerationValue.enumeration" name="enumerationValue.enumeration" value="<ws:property value="enumerationValue.enumeration"/>">
				<input type="hidden" id="enumerationValue.creator" name="enumerationValue.creator" value="<ws:property value="enumerationValue.creator"/>">
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
				
		<script language="JavaScript">
          var detailNames = Array();
		  var detailTabButtons = Array();
		</script>
	 	    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='enumerationValueList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>