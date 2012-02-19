<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="朋友"/></h2>
<form action="friendsSave.action?navTabId=friendsList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="姓名" entity="Friends"/>：</dt><dd><input type="text" name="friends.name" class="textInput required" value="${friends.name}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="年龄" entity="Friends"/>：</dt><dd><input type="text" name="friends.age" class="textInput required integer" value="${friends.age}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="性别" entity="Friends"/>：</dt><dd><hi:select emu="gender" name="friends.gentle"/></dd>			
		</dl>
				<input type="hidden" name="friends.id" value="${friends.id}"/>
				<input type="hidden" name="friends.staff.id" value="${friends.staff.id}"/>
				<input type="hidden" name="friends.creator.id" value="${friends.creator.id}"/>
				<input type="hidden" name="friends.deleted" value="${friends.deleted}"/>
				<input type="hidden" name="friends.version" value="${friends.version}"/>

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
