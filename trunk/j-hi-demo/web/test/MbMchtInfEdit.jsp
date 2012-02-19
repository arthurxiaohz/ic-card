<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户信息"/></h2>
<form action="mbMchtInfSave.action?navTabId=mbMchtInfList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户号" entity="MbMchtInf"/>：</dt><dd><input type="text" name="mbMchtInf.mchtCd" class="textInput required" value="${mbMchtInf.mchtCd}" maxlength="15"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="MbMchtInf"/>：</dt><dd><input type="text" name="mbMchtInf.mchtName" class="textInput required" value="${mbMchtInf.mchtName}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="mbMchtInf.id" value="${mbMchtInf.id}"/>
				<input type="hidden" name="mbMchtInf.creator.id" value="${mbMchtInf.creator.id}"/>
				<input type="hidden" name="mbMchtInf.deleted" value="${mbMchtInf.deleted}"/>
				<input type="hidden" name="mbMchtInf.version" value="${mbMchtInf.version}"/>

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
