<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="语言编码"/></h2>
<form action="languageCodeSave.action?navTabId=languageCodeList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="语言编码" entity="LanguageCode"/>：</dt><dd><input type="text" name="languageCode.languageCode" class="textInput required" value="${languageCode.languageCode}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="LanguageCode"/>：</dt><dd><input type="text" name="languageCode.description" class="textInput" value="${languageCode.description}" /></dd>
		</dl>
				<input type="hidden" name="languageCode.id" value="${languageCode.id}"/>
				<input type="hidden" name="languageCode.creator.id" value="${languageCode.creator.id}"/>
				<input type="hidden" name="languageCode.version" value="${languageCode.version}"/>

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
