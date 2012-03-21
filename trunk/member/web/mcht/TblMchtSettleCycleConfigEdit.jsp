<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户结算周期配置"/></h2>
<form action="tblMchtSettleCycleConfigSave.action?navTabId=tblMchtSettleCycleConfigList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="结算频度间隔" entity="TblMchtSettleCycleConfig"/>：</dt><dd><input type="text" name="tblMchtSettleCycleConfig.settleInterval" class="textInput integer" value="${tblMchtSettleCycleConfig.settleInterval}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="最小结算金额" entity="TblMchtSettleCycleConfig"/>：</dt><dd><input type="text" name="tblMchtSettleCycleConfig.threshold" class="textInput integer" value="${tblMchtSettleCycleConfig.threshold}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备付金" entity="TblMchtSettleCycleConfig"/>：</dt><dd><input type="text" name="tblMchtSettleCycleConfig.excessReserve" class="textInput integer" value="${tblMchtSettleCycleConfig.excessReserve}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblMchtSettleCycleConfig.id" value="${tblMchtSettleCycleConfig.id}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.createdDateTime" value="${tblMchtSettleCycleConfig.createdDateTime}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.lastUpdatedDatetime" value="${tblMchtSettleCycleConfig.lastUpdatedDatetime}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.lastUpdatedBy.id" value="${tblMchtSettleCycleConfig.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.tblMchtInfo.id" value="${tblMchtSettleCycleConfig.tblMchtInfo.id}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.creator.id" value="${tblMchtSettleCycleConfig.creator.id}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.deleted" value="${tblMchtSettleCycleConfig.deleted}"/>
				<input type="hidden" name="tblMchtSettleCycleConfig.version" value="${tblMchtSettleCycleConfig.version}"/>

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
