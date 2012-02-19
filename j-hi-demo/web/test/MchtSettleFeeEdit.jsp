<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户手续费"/></h2>
<form action="mchtSettleFeeSave.action?navTabId=mchtSettleFeeList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="比率" entity="MchtSettleFee"/>：</dt><dd><input type="text" name="mchtSettleFee.byRate" class="textInput required float" value="${mchtSettleFee.byRate}" alt="<hi:text key="请输浮点数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="MchtSettleFee"/>：</dt><dd><input type="text" name="mchtSettleFee.mchtCd" class="textInput required" value="${mchtSettleFee.mchtCd}" maxlength="15"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="MchtSettleFee"/>：</dt><dd><input type="text" name="mchtSettleFee.mchtName" class="textInput required" value="${mchtSettleFee.mchtName}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="mchtSettleFee.id" value="${mchtSettleFee.id}"/>
				<input type="hidden" name="mchtSettleFee.creator.id" value="${mchtSettleFee.creator.id}"/>
				<input type="hidden" name="mchtSettleFee.deleted" value="${mchtSettleFee.deleted}"/>
				<input type="hidden" name="mchtSettleFee.version" value="${mchtSettleFee.version}"/>

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
