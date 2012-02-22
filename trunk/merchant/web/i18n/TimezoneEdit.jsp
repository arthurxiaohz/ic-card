<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="时区"/></h2>
<form action="timezoneSave.action?navTabId=timezoneList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="时区值" entity="Timezone"/>：</dt><dd><input type="text" name="timezone.timezone" class="textInput required integer" value="${timezone.timezone}"  alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="Timezone"/>：</dt><dd><input type="text" name="timezone.description" class="textInput required" value="${timezone.description}" /></dd>
		</dl>
				<input type="hidden" name="timezone.id" value="${timezone.id}"/>
				<input type="hidden" name="timezone.creator.id" value="${timezone.creator.id}"/>
				<input type="hidden" name="timezone.version" value="${timezone.version}"/>

		<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
