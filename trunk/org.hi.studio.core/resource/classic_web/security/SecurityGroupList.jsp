<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>
<html>
﻿	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="includes/style.css"/>
		<script type="text/javascript" src="/js/framework/hi_Include.js"></script>
		<script type="text/javascript" src="/security/SecurityGroup.js"></script>
	</head>	
	<body>
		<form name="formSearch" method="post" action="securityGroupList.action">
		<table width="100%">
		   <tr>
			<td>
﻿					<table class="searchFormTable">

					 	<tr class="searchFromTR" width="100%" >
					 		<td class="searchFromTDLable"><hi:text key="用户组名" entity="SecurityGroup" /></td>
					 		<td class="searchFromTDDate">
					 			<hi:search name="pageInfo.f_groupName" cssClass="searchText" needSelect="true"/>
					 		</td>
					 		<td class="searchFromTDLable"></td>
					 		<td class="searchFromTDDate">
					 		</td>
					 	</tr>
							 	
						<input type="hidden" name="pageInfo.sorterName"	id="pageInfo.sorterName" value="<ws:property value="pageInfo.sorterName" default=""/>" />
						<input type="hidden" name="pageInfo.sorterDirection" id="pageInfo.sorterDirection" value="<ws:property value="pageInfo.sorterDirection" default="ASC"/>" />
										
						<tr class="searchFromActionTR">
							 <!-- action -->
							 <td  colspan="6"> &nbsp;  <input type="button" value="<hi:text key="查询" />" onclick="document.formSearch.submit()" />
								<ws:if test="lookup==null">
									&nbsp; <input name="deleteAll" value="删除选中" onclick="javascript:deleteChecked('securityGroup')" type="button">
									&nbsp; <input type="button" value="<hi:text key="新建" />" onclick="securityGroup_addNew()" />
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
								<td> <a href="javascript:sortBy('groupName')" id="title_groupName"><hi:text key="用户组名" entity="SecurityGroup" /></a></td>
								<td> <a href="javascript:sortBy('displayRef')" id="title_displayRef"><hi:text key="显示信息" entity="SecurityGroup" /></a></td>
								<td> <a href="javascript:sortBy('description')" id="title_description"><hi:text key="描述" entity="SecurityGroup" /></a></td>
								<td>
									<ws:if test="lookup==null">
										<hi:text key="操作" />   <input name="chkall" value="checkbox" onclick="javascript:selectAll()" type="checkbox">
									</ws:if>
									<ws:else>
										<hi:text key="查找带回" />
									</ws:else>
								</td>
							</tr>

							<ws:iterator value="securityGroups" status="securityGroup">
							<tr class="ListTableBody">
								<td> <ws:property id="securityGroup" value="groupName" /></td>
								<td> <ws:property id="securityGroup" value="displayRef" /></td>
								<td> <ws:property id="securityGroup" value="description" /></td>
								<td>
									<ws:if test="lookup==null">
										<input name="orderId" value="<ws:property id="securityGroup" value="id"/>" type="checkbox">
										<a href="/securityGroupRemove.action?securityGroup.id=<ws:property id="securityGroup" value="id"/>&pageInfo.crruntPage=1">删除</a>
										<a href="/securityGroupView.action?securityGroup.id=<ws:property id="securityGroup" value="id"/>&pageInfo.crruntPage=1">编辑</a>
										</ws:if>
										<ws:else>
											<span style="cursor: pointer" onclick="lookupSecurityGroup('<ws:property id="securityGroup" value="id"/>','<ws:property id="securityGroup" value="groupName"/>','<ws:property id="securityGroup" value="displayRef"/>','<ws:property id="securityGroup" value="description"/>')">选择</span>								
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
								<td><hi:page pageBeanName="pageInfo" currentPage="1" url="/securityGroupList.action" /></td>
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