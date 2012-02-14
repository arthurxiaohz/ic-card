<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
﻿	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="includes/style.css"/>
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/UserGroup.js"></script>
	</head>	
	<body>
		<form name="formSearch" method="post" action="userGroupList.action">
		<table width="100%">
		   <tr>
			<td>
﻿					<table class="searchFormTable">

					 	<tr class="searchFromTR" width="100%" >
					 		<td class="searchFromTDLable"><hi:text key="用户" entity="UserGroup" /></td>
					 		<td class="searchFromTDDate">
					 			<hi:search name="pageInfo.securityUser.f_fullName" cssClass="searchText" needSelect="true"/>
					 		</td>
					 		<td class="searchFromTDLable"><hi:text key="角色名称" entity="UserGroup" /></td>
					 		<td class="searchFromTDDate">
					 			<hi:search name="pageInfo.securityGroup.f_groupName" cssClass="searchText" needSelect="true"/>
					 		</td>
					 	</tr>
							 	
						<input type="hidden" name="pageInfo.sorterName"	id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
						<input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
										
						<tr class="searchFromActionTR">
							 <!-- action -->
							 <td  colspan="6"> &nbsp;  <input type="button" value="<hi:text key="查询" />" onclick="document.formSearch.submit()" />
								<ws:if test="lookup==null">
									&nbsp; <input name="deleteAll" value="<hi:text key="删除选中" />" onclick="javascript:deleteChecked('userGroup')" type="button">
									&nbsp; <input type="button" value="<hi:text key="新建" />" onclick="userGroup_addNew()" />
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
								<td> <a href="javascript:sortBy('securityUser.fullName')" id="title_securityUser.fullName"><hi:text key="用户" entity="UserGroup" /></a></td>
								<td> <a href="javascript:sortBy('securityGroup.groupName')" id="title_securityGroup.groupName"><hi:text key="角色名称" entity="UserGroup" /></a></td>
								<td>
									<ws:if test="lookup==null">
										<hi:text key="操作" />   <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">
									</ws:if>
									<ws:else>
										<hi:text key="查找带回" />
									</ws:else>
								</td>
							</tr>

							<ws:iterator value="userGroups" status="userGroup">
							<tr class="ListTableBody">
								<td> <ws:property id="userGroup" value="securityUser.fullName" /></td>
								<td> <ws:property id="userGroup" value="securityGroup.groupName" /></td>
								<td>
									<ws:if test="lookup==null">
										<input name="orderId" value="<ws:property id="userGroup" value="id"/>" type="checkbox">
										<a href="/userGroupRemove.action?userGroup.id=<ws:property id="userGroup" value="id"/>&pageInfo.crruntPage=1"><hi:text key="删除" /></a>
										<a href="/userGroupView.action?userGroup.id=<ws:property id="userGroup" value="id"/>&pageInfo.crruntPage=1"><hi:text key="编辑" /></a>
										</ws:if>
										<ws:else>
											<span style="cursor: pointer" onclick="lookupUserGroup('<ws:property id="userGroup" value="id"/>','<ws:property id="userGroup" value="userName"/>','<ws:property id="userGroup" value="groupName"/>')"><hi:text key="选择" /></span>								
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
								<td><hi:page pageBeanName="pageInfo" currentPage="1" url="/userGroupList.action" /></td>
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