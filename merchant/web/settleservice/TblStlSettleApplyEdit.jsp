<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="结算申请"/></h2>
<form action="tblStlSettleApplySave.action?navTabId=tblStlSettleApplyList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="账户可用余额" entity="TblStlSettleApply"/>：</dt><dd><input readonly="readonly"  type="text" name="tblStlSettleApply.availableBalance" class="textInput integer" value="${tblStlSettleApply.availableBalance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="申请结算金额" entity="TblStlSettleApply"/>：</dt><dd><input type="text" name="tblStlSettleApply.amount" class="textInput integer" value="${tblStlSettleApply.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input readonly="readonly" type="hidden" name="tblStlSettleApply.tblMchtInfo.id" value="${tblStlSettleApply.tblMchtInfo.id}"/>
				
				<input type="hidden" name="tblStlSettleApply.id" value="${tblStlSettleApply.id}"/>
				<input type="hidden" name="tblStlSettleApply.lastUpdatedBy.id" value="${tblStlSettleApply.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblStlSettleApply.creator.id" value="${tblStlSettleApply.creator.id}"/>
				<input type="hidden" name="tblStlSettleApply.version" value="${tblStlSettleApply.version}"/>

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
