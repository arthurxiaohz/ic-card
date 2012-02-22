<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="枚举值"/></h2>
<form action="enumerationValueSave.action?navTabId=enumerationValueList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="enumerationValue.enumeration.id" value="${enumerationValue.enumeration.id}"/>
<input type="hidden" name="enumerationValue.id" value="${enumerationValue.id}"/>
<input type="hidden" name="enumerationValue.creator.id" value="${enumerationValue.creator.id}"/>
<input type="hidden" value="${enumerationValue.version}">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="枚举值名称" entity="EnumerationValue"/>：</dt><dd><input type="text" name="enumerationValue.valueName" class="textInput" value="${enumerationValue.valueName}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="显示信息" entity="EnumerationValue"/>：</dt><dd><input type="text" name="enumerationValue.displayRef" class="textInput" value="${enumerationValue.displayRef}" /></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="EnumerationValue"/>：</dt><dd><input type="text" name="enumerationValue.description" class="textInput" value="${enumerationValue.description}" /></dd>
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