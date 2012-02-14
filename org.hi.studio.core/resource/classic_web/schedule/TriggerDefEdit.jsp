<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="schedule/TriggerDef.js"></script>
</head>
<body>
  <form name="saveForm" action="triggerDefSave.action" method="post" onsubmit="return checkValue('triggerDef.triggerName,triggerDef.cronExpression,triggerDef.jobDetailName')">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader"><hi:text key="编辑页面" parameterLanguageKeys="触发器"/></td>
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
				  <td width="15%" class="EditTableKeyLabel"  id="triggerDef.triggerNameLabel"><hi:text key="触发名称" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="triggerDef.triggerName" name="triggerDef.triggerName" value="<ws:property value="triggerDef.triggerName"/>">
				  </td>
				  <td width="15%" class="EditTableKeyLabel"  id="triggerDef.jobDetailNameLabel"><hi:text key="工作项" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="hidden" id="triggerDef.jobDetail.id" name="triggerDef.jobDetail.id" value="<ws:property value="triggerDef.jobDetail.id"/>">
					<input type="text" class="EditTableDataText" id="triggerDef.jobDetailName" name="triggerDef.jobDetailName" value="<ws:property value="triggerDef.jobDetail.jobClassName"/>">
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="triggerDef.startTimeLabel"><hi:text key="开始时间" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
				    <table border="0" cellpadding="0" cellspacing="0">
				    	<input name="triggerDef.startTime" class="EditTableDataText"	id="triggerDef_startTime" type="text" size="10" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<ws:date name="excelReportDesign.createDate" format="yyyy-MM-dd"/>" />
					</table>

				  </td>
				  <td width="15%" class="EditTableLabel"  id="triggerDef.endTimeLabel"><hi:text key="截止时间" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
				    <table border="0" cellpadding="0" cellspacing="0">
				      <input name="triggerDef.endTime" class="EditTableDataText"	id="triggerDef_endTime" type="text" size="10" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<ws:date name="excelReportDesign.createDate" format="yyyy-MM-dd"/>" />
					</table>

				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableKeyLabel"  id="triggerDef.cronExpressionLabel"><hi:text key="表达式" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
					<input type="text" class="EditTableDataText" id="triggerDef.cronExpression" name="triggerDef.cronExpression" value="<ws:property value="triggerDef.cronExpression"/>">
				  </td>
				  <td width="15%" class="EditTableLabel"  id="triggerDef.enabledLabel"><hi:text key="激活" entity="TriggerDef" />:</td>
				  <td width="35%" class="EditTableData">
				    <hi:select cssClass="EditTableDataEnum" emu="yesNo" name="triggerDef.enabled" id="triggerDef.enabled"/>

				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="EditTableLabel"  id="triggerDef.descriptionLabel"><hi:text key="描述" entity="TriggerDef" />:</td>
				  <td width="85%" class="EditTableData" colspan="3">
					<input type="text" class="EditTableDataText" size="80" id="triggerDef.description" name="triggerDef.description" value="<ws:property value="triggerDef.description"/>">
					</td>
			    </tr>
				<input type="hidden" id="triggerDef.id" name="triggerDef.id" value="<ws:property value="triggerDef.id"/>">
				<input type="hidden" id="triggerDef.version" name="triggerDef.version" value="<ws:property value="triggerDef.version"/>">
				<input type="hidden" id="triggerDef.creator.id" name="triggerDef.creator.id" value="<ws:property value="triggerDef.creator.id"/>">
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
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='triggerDefList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  <hi:token mothed="post"></hi:token>
  </form>
</body>
</html>