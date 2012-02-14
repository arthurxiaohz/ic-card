<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="includes/style.css"  >
		<link rel="stylesheet" type="text/css" href="/css/ajaxcss.css"  >
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/GroupRole.js"></script>
	</head>

	<body>
		<form action="/groupRoleSave.action" method="post" onsubmit="return checkValue('')">
﻿    
    	<input type="hidden" id="groupRole.id" name="groupRole.id" value="<ws:property value="groupRole.id" />">
			<input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
				
			<table class="EditTable" cellpadding="2" cellspacing="1" width="100%"> <!-- fields to edit  -->
				<thead>
				</thead>
				<tbody>
				  <tr>
						<td class="EditTableTDLabel"><hi:text key="角色名称" entity="GroupRole" />:</td>
						<td class="EditTableTDData" >
							<input type="hidden" id="groupRole.securityGroup.id" name="groupRole.securityGroup.id" value="<ws:property value="groupRole.securityGroup.id"/>">
							<input type="text" id="groupRole.groupName" name="groupRole.groupName" value="<ws:property value="groupRole.securityGroup.groupName"/>">
							     <span onclick="groupRole_lookupPOP('securityGroup')"><hi:text key="查找带回" /></span>
						</td>
						<td class="EditTableTDLabel"><hi:text key="角色名称" entity="GroupRole" />:</td>
						<td class="EditTableTDData" >
							<input type="hidden" id="groupRole.role.id" name="groupRole.role.id" value="<ws:property value="groupRole.role.id"/>">
							<input type="text" id="groupRole.roleName" name="groupRole.roleName" value="<ws:property value="groupRole.role.roleName"/>">
							     <span onclick="groupRole_lookupPOP('role')"><hi:text key="查找带回" /></span>
						</td>
					</tr>
					<tr>
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
			<input type="submit" value="提交" />&nbsp;<input type="button" value="返回" onclick="javascript:window.location='/groupRoleList.action'" />
	   	</td></tr>
    	</table>
    	
		</form>
	</body>
</html>