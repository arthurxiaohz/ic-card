<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">权限资源查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="权限名称" entity="PrivilegeResource"/>：</dt><dd>${privilegeResource.authorityName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="表现层" entity="PrivilegeResource"/>：</dt><dd>${privilegeResource.viewLayer}</dd>
		</dl>
		<dl>
			<dt><hi:text key="表现层权限扩展" entity="PrivilegeResource"/>：</dt><dd>${privilegeResource.veiwExtAuthNames}</dd>
		</dl>
		<dl>
			<dt><hi:text key="业务层" entity="PrivilegeResource"/>：</dt><dd>${privilegeResource.businessLayer}</dd>
		</dl>
		<dl>
			<dt><hi:text key="业务层权限扩展" entity="PrivilegeResource"/>：</dt><dd>${privilegeResource.bizExtAuthNames}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
