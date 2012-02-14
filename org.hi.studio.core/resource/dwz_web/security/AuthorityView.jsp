<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">权限查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="权限名称" entity="Authority"/>：</dt><dd>${authority.authorityName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="Authority"/>：</dt><dd>${authority.displayRef}</dd>
		</dl>
		<dl>
			<dt><hi:text key="属性资源" entity="Authority"/>：</dt><dd>${authority.propertedResource}</dd>
		</dl>
			<dl>
			<dt><hi:text key="描述" entity="Authority"/>：</dt><dd>${authority.description}</dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单项" entity="Authority"/>：</dt><dd>${authority.menuLink.description}</dd>
		</dl>
		
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>