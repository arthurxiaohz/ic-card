<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="Nation"/></h2>
<form action="nationSave.action?navTabId=nationList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="中文名字" entity="Nation"/>：</dt><dd><input type="text" name="nation.chineseName" class="textInput" value="${nation.chineseName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="英文名字" entity="Nation"/>：</dt><dd><input type="text" name="nation.englishName" class="textInput" value="${nation.englishName}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="nation.id" value="${nation.id}"/>
				<input type="hidden" name="nation.creator.id" value="${nation.creator.id}"/>
				<input type="hidden" name="nation.version" value="${nation.version}"/>

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
