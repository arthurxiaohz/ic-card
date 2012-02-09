<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="JobPosition"/></h2>
<form action="jobPositionSave.action?navTabId=jobPositionList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="岗位名称" entity="JobPosition"/>：</dt><dd><input type="text" name="jobPosition.name" class="textInput" value="${jobPosition.name}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="JobPosition"/>：</dt><dd><input type="text" name="jobPosition.description" class="textInput" value="${jobPosition.description}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="jobPosition.id" value="${jobPosition.id}"/>
				<input type="hidden" name="jobPosition.creator.id" value="${jobPosition.creator.id}"/>
				<input type="hidden" name="jobPosition.version" value="${jobPosition.version}"/>

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
