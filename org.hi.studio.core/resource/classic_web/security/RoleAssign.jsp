<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
		<script type="text/javascript" src="js/framework/hi_Include.js"></script>
 		<script type="text/javascript" src="security/Role.js"></script>		
		<script type="text/javascript">
			function userRoleAssign(){
				var users = window.frames['uesrFrame'].document.formSearch.orderId;
				var userids = "";
					if (users.length==undefined ){
						if( users.checked == true)
							userids = users.value;
					}
					else{
						for (var i = 0; i < users.length; i++) {
							if (users[i].checked == true) {
								userids += "," + users[i].value;
								}
						}
					}
				if(userids == ""){
					alert("<hi:text key="请选择要授权的用户" entity="Role"/>");
					return;
				}
				
				document.roleAssignForm.action="roleAssignSave.action?userIndexs="+userids;
				document.roleAssignForm.submit();
				
			}
		
		</script>
	</head>

	<body>
	<iframe src="hiUserBatchList.action?pageInfo.f_userMgrType=1400&pageInfo.f_userMgrType_op=&lt;&gt;" id="uesrFrame" height="200" width="100%" ></iframe>
	<p>
	
		<form name="roleAssignForm" action="roleAssignSave.action" method="post" >
	<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
	 <tr>
	  <td class="ListTableBodyLabel"><hi:text key="权限信息" entity="RoleAuthority" /></td>
	  <td class="ListTableBodyLabel"><hi:text key="用户信息" entity="RoleAuthority" /></td>
	 </tr>
	 <tr>
	  <td valign="top">		
		<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
				<thead>
					<tr class="ListTableHeader" >
						<td><hi:text key="权限" entity="RoleAuthority" /></td>
						<td><hi:text key="部门" entity="RoleAuthority" /></td>						
						<td><hi:text key="范围" entity="RoleAuthority" /></td>
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="roleAuthorities" id="roleAuthority" status="roleAuthorityIndex" >
				  <tr class="<ws:if test="#roleAuthorityIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
					<td>
						<ws:property id="roleAuthority" value="authority.description"/>
					</td>
					<td>
						<ws:property id="roleAuthority" value="org.orgName"/>
					</td>					
					<td>
						<hi:select emu="securityScope" name="roleAuthorities[${roleAuthorityIndex.count-1}].scope" isLabel="true" />
					</td>
				  </tr>
				</ws:iterator>
				</tbody>
		</table>
	  </td>
	  <td valign="top">	
		<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
				<thead>
					<tr class="ListTableHeader" >
						<td><hi:text key="用户名" entity="RoleAuthority" /></td>
						<td><hi:text key="事项" entity="RoleAuthority" /></td>						
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="userRoles" id="userRole" status="userRoleIndex" >
				  <tr class="<ws:if test="#userRoleIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
					<td>
						<ws:property id="userRole" value="securityUser.fullName"/>
					</td>
					<td>
						<img src="images/del.gif" style="cursor: pointer" onclick="deleteUser('<ws:property id="userRole" value="id"/>')" />					
					</td>					
				  </tr>
				</ws:iterator>
				</tbody>
		</table>
	   </td>
	  </tr>
	 </table> 							
		<input type="hidden" id="role.id" name="role.id" value="<ws:property value="role.id"/>">
  		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="EditTableSubmit">
		  <tr>
		    <td width="94"><input name="save" type="button" id="save" value="<hi:text key="保存"    />" class="Button2" onclick="javascript:userRoleAssign()"/></td>
		    <td width="100"><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='roleList.action'"  ></td>
		  </tr>
		</table>  	
		</form>
	</body>
</html>