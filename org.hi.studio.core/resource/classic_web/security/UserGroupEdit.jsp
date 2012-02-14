<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="includes/style.css"  >
		<link rel="stylesheet" type="text/css" href="/css/ajaxcss.css"  >
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/UserGroup.js"></script>
	</head>

	<body>
		<form action="/userGroupSave.action" method="post" onsubmit="return checkValue('')">
﻿    
    	<input type="hidden" id="userGroup.id" name="userGroup.id" value="<ws:property value="userGroup.id" />">
			<input type="hidden" id="" name="pageInfo.crruntPage" value="<ws:property value="request['pageInfo.crruntPage']" />">
				
			<table class="EditTable" cellpadding="2" cellspacing="1" width="100%"> <!-- fields to edit  -->
				<thead>
				</thead>
				<tbody>
				  <tr>
						<td class="EditTableTDLabel"><hi:text key="用户" entity="UserGroup" />:</td>
						<td class="EditTableTDData" >
							<input type="hidden" id="userGroup.securityUser.id" name="userGroup.securityUser.id" value="<ws:property value="userGroup.securityUser.id"/>">
							<input type="text" id="userGroup.userName" name="userGroup.userName" value="<ws:property value="userGroup.securityUser.fullName"/>">
							     <span onclick="userGroup_lookupPOP('securityUser')"><hi:text key="查找带回" /></span>
						</td>
						<td class="EditTableTDLabel"><hi:text key="角色名称" entity="UserGroup" />:</td>
						<td class="EditTableTDData" >
							<input type="hidden" id="userGroup.securityGroup.id" name="userGroup.securityGroup.id" value="<ws:property value="userGroup.securityGroup.id"/>">
							<input type="text" id="userGroup.groupName" name="userGroup.groupName" value="<ws:property value="userGroup.securityGroup.groupName"/>">
							     <span onclick="userGroup_lookupPOP('securityGroup')"><hi:text key="查找带回" /></span>
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
			<input type="submit" value="提交" />&nbsp;<input type="button" value="返回" onclick="javascript:window.location='/userGroupList.action'" />
	   	</td></tr>
    	</table>
    	
		</form>
	</body>
</html>