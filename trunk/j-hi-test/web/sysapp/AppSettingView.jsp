<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle">应用配置查看页面</h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
        				
		<dl>
			<dt><hi:text key="组名" entity="AppSetting"/>：</dt><dd>${appSetting.appGroup}</dd>
		</dl>
		<dl>
			<dt><hi:text key="配置名" entity="AppSetting"/>：</dt><dd>${appSetting.appName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="配置值" entity="AppSetting"/>：</dt><dd>${appSetting.appValue}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="AppSetting"/>：</dt><dd>${appSetting.description}</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>