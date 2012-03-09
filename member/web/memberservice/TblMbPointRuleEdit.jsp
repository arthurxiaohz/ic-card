<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="积分规则"/></h2>
<form action="tblMbPointRuleSave.action?navTabId=tblMbPointRuleList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbPointRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointRule.startDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointRule.startDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbPointRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointRule.endDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointRule.endDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="起始金额" entity="TblMbPointRule"/>：</dt><dd><input type="text" name="tblMbPointRule.minAmount" class="textInput" value="${tblMbPointRule.minAmount}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="截止金额" entity="TblMbPointRule"/>：</dt><dd><input type="text" name="tblMbPointRule.maxAmount" class="textInput" value="${tblMbPointRule.maxAmount}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="积分规则类型" entity="TblMbPointRule"/>：</dt><dd><hi:select emu="pointRuleType" name="tblMbPointRule.pointRuleType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="参数值" entity="TblMbPointRule"/>：</dt><dd><input type="text" name="tblMbPointRule.ruleValue" class="textInput float" value="${tblMbPointRule.ruleValue}" alt="<hi:text key="请输浮点数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointRule.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointRule.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointRule.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointRule.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMbPointRule.id" value="${tblMbPointRule.id}"/>
				<input type="hidden" name="tblMbPointRule.userName.userName" value="${tblMbPointRule.userName.userName}"/>
				<input type="hidden" name="tblMbPointRule.fullName.fullName" value="${tblMbPointRule.fullName.fullName}"/>
				<input type="hidden" name="tblMbPointRule.mchtNo.mchtNo" value="${tblMbPointRule.mchtNo.mchtNo}"/>
				<input type="hidden" name="tblMbPointRule.mchtName.mchtName" value="${tblMbPointRule.mchtName.mchtName}"/>
				<input type="hidden" name="tblMbPointRule.mchtType" value="${tblMbPointRule.mchtType}"/>
				<input type="hidden" name="tblMbPointRule.lastUpdatedBy.id" value="${tblMbPointRule.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbPointRule.creator.id" value="${tblMbPointRule.creator.id}"/>
				<input type="hidden" name="tblMbPointRule.version" value="${tblMbPointRule.version}"/>

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
