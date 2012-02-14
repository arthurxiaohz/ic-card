<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
  <link rel="stylesheet" type="text/css" href="css/ajaxcss.css"  >
  <script type="text/javascript" src="js/framework/hi_Include.js"></script>
  <script type="text/javascript" src="security/Role.js"></script>
</head>
<body>
  <form action="" method="post">
  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="ViewTableHeader"><hi:text key="查看页面" parameterLanguageKeys="角色" /></td>
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
				  <td width="15%" class="ViewTableKeyLabel"  id="role.roleNameLabel"><hi:text key="角色名称" entity="Role" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="role.roleName"/>
				  </td>
				  <td width="15%" class="ViewTableLabel"  id="role.displayRefLabel"><hi:text key="显示信息" entity="Role" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="role.displayRef"/>
				  </td>
			    </tr>
				<tr>
				  <td width="15%" class="ViewTableLabel"  id="role.descriptionLabel"><hi:text key="描述" entity="Role" />:</td>
				  <td width="35%" class="ViewTableData">
				  &nbsp;
					<ws:property value="role.description"/>
				  </td>
				</tr>
				<input type="hidden" id="role.id" name="role.id" value="<ws:property value="role.id"/>">
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
		</table> 
				
	<table class="EditDetailTable" cellpadding="2" cellspacing="1" width="100%" >
	 <tr>
	  <td class="ListTableBodyLabel"><hi:text key="权限信息" entity="Role" /></td>
	  <td class="ListTableBodyLabel"><hi:text key="用户信息" entity="Role" /></td>
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
				  <tr class="<ws:if test="#roleAuthorityIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>" >
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
						<td><hi:text key="用户名" entity="Role" /></td>
					</tr>  
				</thead>
				<tbody>
				<ws:iterator value="userRoles" id="userRole" status="userRoleIndex" >
				  <tr class="<ws:if test="#userRoleIndex.count%2==0">ListTableBodyTrEven</ws:if><ws:else>ListTableBodyTrOdd</ws:else>">
					<td>
						<ws:property id="userRole" value="securityUser.fullName"/>
					</td>			
				  </tr>
				</ws:iterator>
				</tbody>
		</table>
	   </td>
	  </tr>
	 </table> 	
		    
		<table width="194" border="0" align="center" cellpadding="0" cellspacing="0" class="ViewTableSubmit">
		  <tr>
		    <td><input name="reback" type="button" id="reback" value="<hi:text key="关闭"    />" class="Button2" onclick="javascript:window.location='roleList.action'"  ></td>
		  </tr>
		</table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>