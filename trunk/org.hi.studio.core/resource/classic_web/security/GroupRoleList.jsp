<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
﻿	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="includes/style.css"/>
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/GroupRole.js"></script>
	</head>	
	<body>
		<form name="formSearch" method="post" action="groupRoleList.action">
		<table width="100%">
		   <tr>
			<td>
﻿					<table class="searchFormTable">

					 	<tr class="searchFromTR" width="100%" >
					 		<td class="searchFromTDLable"><hi:text key="角色名称" entity="GroupRole" /></td>
					 		<td class="searchFromTDDate">
					 			<hi:search name="pageInfo.securityGroup.f_groupName" cssClass="searchText" needSelect="true"/>
					 		</td>
					 		<td class="searchFromTDLable"><hi:text key="角色名称" entity="GroupRole" /></td>
					 		<td class="searchFromTDDate">
					 			<hi:search name="pageInfo.role.f_roleName" cssClass="searchText" needSelect="true"/>
					 		</td>
					 	</tr>
							 	
						<input type="hidden" name="pageInfo.sorterName"	id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
						<input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
										
						<tr class="searchFromActionTR">
							 <!-- action -->
							 <td  colspan="6"> &nbsp;  <input type="button" value="<hi:text key="查询" />" onclick="document.formSearch.submit()" />
								<ws:if test="lookup==null">
									&nbsp; <input name="deleteAll" value=""<hi:text key="删除选中" />" onclick="javascript:deleteChecked('groupRole')" type="button">
									&nbsp; <input type="button" value="<hi:text key="新建" />" onclick="groupRole_addNew()" />
								</ws:if>
				     		 </td>
						</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
﻿				<table width="100%" >
					<tr>
					 <td>
						<table class="ListTable" cellpadding="2" cellspacing="1" width="100%" >

							<tr class="ListTableHeader">
								<td> <a href="javascript:sortBy('securityGroup.groupName')" id="title_securityGroup.groupName"><hi:text key="角色名称" entity="GroupRole" /></a></td>
								<td> <a href="javascript:sortBy('role.roleName')" id="title_role.roleName"><hi:text key="角色名称" entity="GroupRole" /></a></td>
								<td>
									<ws:if test="lookup==null">
										<hi:text key="操作" />   <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">
									</ws:if>
									<ws:else>
										<hi:text key="查找带回" />
									</ws:else>
								</td>
							</tr>

							<ws:iterator value="groupRoles" status="groupRole">
							<tr class="ListTableBody">
								<td> <ws:property id="groupRole" value="securityGroup.groupName" /></td>
								<td> <ws:property id="groupRole" value="role.roleName" /></td>
								<td>
									<ws:if test="lookup==null">
										<input name="orderId" value="<ws:property id="groupRole" value="id"/>" type="checkbox">
										<a href="/groupRoleRemove.action?groupRole.id=<ws:property id="groupRole" value="id"/>&pageInfo.crruntPage=1"><hi:text key="删除" /></a>
										<a href="/groupRoleView.action?groupRole.id=<ws:property id="groupRole" value="id"/>&pageInfo.crruntPage=1"><hi:text key="编辑" /></a>
										</ws:if>
										<ws:else>
											<span style="cursor: pointer" onclick="lookupGroupRole('<ws:property id="groupRole" value="id"/>','<ws:property id="groupRole" value="groupName"/>','<ws:property id="groupRole" value="roleName"/>')"><hi:text key="选择" /></span>								
										</ws:else>
			  					</td>
							</tr>
							</ws:iterator>				  																															</table>
					</td>
				   </tr>
				   <tr>
				    <td>
						<table class="ListTablePageInfo" cellpadding="2" cellspacing="1" width="100%" >
							<tr>
								<td><hi:page pageBeanName="pageInfo" currentPage="1" url="/groupRoleList.action" /></td>
							</tr>
						</table>
					</td>
				   </tr>
			    </table>
			</td>
		 </tr>
	   </table>
	   </form>
	</body>
</html>