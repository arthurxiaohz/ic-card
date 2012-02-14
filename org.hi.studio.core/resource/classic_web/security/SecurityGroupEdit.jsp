<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="includes/style.css"  >
		<link rel="stylesheet" type="text/css" href="/css/ajaxcss.css"  >
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/SecurityGroup.js"></script>
	</head>

	<body>
		<form action="/securityGroupSave.action" method="post" onsubmit="return checkValue('securityGroup.groupName')">
﻿    
    	<input type="hidden" id="securityGroup.id" name="securityGroup.id" value="<ws:property value="securityGroup.id" />">
			<input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
				
			<table class="EditTable" cellpadding="2" cellspacing="1" width="100%"> <!-- fields to edit  -->
				<thead>
				</thead>
				<tbody>
				  <tr>
						<td class="EditTableTDKeyLabel"><hi:text key="用户组名" entity="SecurityGroup" />:</td>
						<td class="EditTableTDData" >
							<input type="text" id="securityGroup.groupName" name="securityGroup.groupName" value="<ws:property value="securityGroup.groupName"/>">
						</td>
						<td class="EditTableTDLabel"><hi:text key="显示信息" entity="SecurityGroup" />:</td>
						<td class="EditTableTDData" >
							<input type="text" id="securityGroup.displayRef" name="securityGroup.displayRef" value="<ws:property value="securityGroup.displayRef"/>">
						</td>
					</tr>
					<tr>
						<td class="EditTableTDLabel"><hi:text key="描述" entity="SecurityGroup" />:</td>
						<td class="EditTableTDData" >
							<input type="text" id="securityGroup.description" name="securityGroup.description" value="<ws:property value="securityGroup.description"/>">
						</td>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							&nbsp;
						</td>
					</tr>
				</tfoot>
		</table>  <!-- fields to edit end -->
			<br/>
			<!-- orderDetail edit -->

	<script language="JavaScript">
		var detailNames = Array();
		var detailTabButtons = Array();
	</script>
			<!-- orderDetail edit end  -->
     <table width="100%">
     	<tr> <td>
			<input type="submit" value="提交" />&nbsp;<input type="button" value="返回" onclick="javascript:window.location='/securityGroupList.action'" />
	   	</td></tr>
    	</table>
    	
		</form>
	</body>
</html>