<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员积分兑换规则"/></h2>
<form action="tblMbPointExchangeRuleSave.action?navTabId=tblMbPointExchangeRuleList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="积分" entity="TblMbPointExchangeRule"/>：</dt><dd><input type="text" name="tblMbPointExchangeRule.point" class="textInput integer" value="${tblMbPointExchangeRule.point}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblMbPointExchangeRule"/>：</dt><dd><input type="text" name="tblMbPointExchangeRule.amount" class="textInput integer" value="${tblMbPointExchangeRule.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期开始日期" entity="TblMbPointExchangeRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointExchangeRule.startDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointExchangeRule.startDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期结束日期" entity="TblMbPointExchangeRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointExchangeRule.endDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointExchangeRule.endDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointExchangeRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointExchangeRule.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointExchangeRule.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointExchangeRule"/>：</dt>
			<dd>
				<input type="text" name="tblMbPointExchangeRule.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbPointExchangeRule.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbPointExchangeRule"/>：</dt><dd><input type="text" name="tblMbPointExchangeRule.lastUpdatedBy" class="textInput integer" value="${tblMbPointExchangeRule.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblMbPointExchangeRule.id" value="${tblMbPointExchangeRule.id}"/>
				<input type="hidden" name="tblMbPointExchangeRule.creator.id" value="${tblMbPointExchangeRule.creator.id}"/>
				<input type="hidden" name="tblMbPointExchangeRule.version" value="${tblMbPointExchangeRule.version}"/>

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
