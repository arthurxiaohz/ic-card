<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">菜单链接查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="菜单URL" entity="MenuLink"/>：</dt><dd>${menuLink.linkUrl}</dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="MenuLink"/>：</dt><dd>${menuLink.displayRef}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="MenuLink"/>：</dt><dd>${menuLink.description}</dd>
		</dl>
		<dl>
			<dt><hi:text key="权限" entity="MenuLink"/>：</dt><dd>${menuLink.authority.id}</dd>
		</dl>
		<dl>
			<dt><hi:text key="权限名称" entity="MenuLink"/>：</dt><dd>${menuLink.authority.authorityName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="序列" entity="MenuLink"/>：</dt><dd>${menuLink.sequence}</dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单项名称" entity="MenuLink"/>：</dt><dd>${menuLink.menu.menuName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="菜单项描述" entity="MenuLink"/>：</dt><dd>${menuLink.menu.description}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>