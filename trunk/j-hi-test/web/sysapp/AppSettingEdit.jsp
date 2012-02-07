<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="应用配置"/></h2>
<form action="appSettingSave.action?navTabId=appSettingList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="appSetting.id" value="${appSetting.id}"/>
<input type="hidden" name="appSetting.version" value="${appSetting.version}"/>
<input type="hidden" name="appSetting.creator.id" value="${appSetting.creator.id}"/>

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="组名" entity="AppSetting"/>：</dt><dd><input type="text" name="appSetting.appGroup" class="textInput required" value="${appSetting.appGroup}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="配置名" entity="AppSetting"/>：</dt><dd><input type="text" name="appSetting.appName" class="textInput required" value="${appSetting.appName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="配置值" entity="AppSetting"/>：</dt><dd><input type="text" name="appSetting.appValue" class="textInput required" value="${appSetting.appValue}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="AppSetting"/>：</dt><dd><input type="text" name="appSetting.description" size="100" class="textInput" value="${appSetting.description}" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
  
</div>
</form>
