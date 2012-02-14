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
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="触发器" /></td>
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
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.triggerNameLabel"><hi:text key="触发名称" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="triggerDef.triggerName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.jobDetailNameLabel"><hi:text key="工作项" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="triggerDef.jobDetail.id" name="triggerDef.jobDetail.id" value="<ws:property value="triggerDef.jobDetail.id"/>">
					<ws:property value="triggerDef.jobDetail.jobName"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.startTimeLabel"><hi:text key="开始时间" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				      <ws:date name="triggerDef.startTime" format="yyyy-MM-dd HH:mm:ss"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.endTimeLabel"><hi:text key="截止时间" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				      <ws:date name="triggerDef.endTime" format="yyyy-MM-dd HH:mm:ss"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.cronExpressionLabel"><hi:text key="表达式" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="triggerDef.cronExpression"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.enabledLabel"><hi:text key="激活" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
				    <hi:select cssClass="ViewTableDataText" emu="yesNo" name="triggerDef.enabled" isLabel="true"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.descriptionLabel"><hi:text key="描述" entity="TriggerDef" />:</td>
				  <td width="85%" class="ViewTableData" colspan="3">
				  &nbsp;
					<ws:property value="triggerDef.description"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="triggerDef.userNameLabel"><hi:text key="创建人" entity="TriggerDef" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<input type="hidden" id="triggerDef.creator.id" name="triggerDef.creator.id" value="<ws:property value="triggerDef.creator.id"/>">
					<ws:property value="triggerDef.creator.fullName"/>
				  </td>
				</tr>
				<input type="hidden" id="triggerDef.id" name="triggerDef.id" value="<ws:property value="triggerDef.id"/>">
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
		    <td><ws:if test="workflow==null">	<input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='triggerDefList.action'"/></ws:if></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>