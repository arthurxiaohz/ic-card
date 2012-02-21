
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">用户权限查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="用户" entity="UserAuthority"/>：</dt><dd>${userAuthority.securityUser.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="权限" entity="UserAuthority"/>：</dt><dd>${userAuthority.authority.description}</dd>
		</dl>
		<dl>
			<dt><hi:text key="部门" entity="UserAuthority"/>：</dt><dd>${userAuthority.org.orgName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="范围" entity="UserAuthority"/>：</dt><dd><hi:select emu="securityScope" name="userAuthority.scope" isLabel="true"/></dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>