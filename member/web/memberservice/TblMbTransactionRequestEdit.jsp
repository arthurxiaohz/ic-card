<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="网关交易请求"/></h2>
<form action="tblMbTransactionRequestSave.action?navTabId=tblMbTransactionRequestList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="请求号" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.requestId" class="textInput required" value="${tblMbTransactionRequest.requestId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易代码" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.trancode" class="textInput" value="${tblMbTransactionRequest.trancode}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.mchtNo" class="textInput" value="${tblMbTransactionRequest.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.amount" class="textInput integer" value="${tblMbTransactionRequest.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.trxTime" class="textInput" value="${tblMbTransactionRequest.trxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.txStatus" class="textInput" value="${tblMbTransactionRequest.txStatus}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.msgext" class="textInput" value="${tblMbTransactionRequest.msgext}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbTransactionRequest"/>：</dt>
			<dd>
				<input type="text" name="tblMbTransactionRequest.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbTransactionRequest.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbTransactionRequest"/>：</dt>
			<dd>
				<input type="text" name="tblMbTransactionRequest.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbTransactionRequest.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.lastUpdatedBy" class="textInput" value="${tblMbTransactionRequest.lastUpdatedBy}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人卡号" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.pan" class="textInput" value="${tblMbTransactionRequest.pan}" maxlength="19"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人个人信息" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.chinfo" class="textInput" value="${tblMbTransactionRequest.chinfo}" maxlength="80"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="平台流水号" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.plTxTraceNo" class="textInput" value="${tblMbTransactionRequest.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="币种" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.currencyType" class="textInput" value="${tblMbTransactionRequest.currencyType}" maxlength="3"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户类型" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.accountType" class="textInput" value="${tblMbTransactionRequest.accountType}" maxlength="2"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户号码" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.accountNo" class="textInput" value="${tblMbTransactionRequest.accountNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblMbTransactionRequest"/>：</dt><dd><input type="text" name="tblMbTransactionRequest.plTxTime" class="textInput" value="${tblMbTransactionRequest.plTxTime}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="tblMbTransactionRequest.id" value="${tblMbTransactionRequest.id}"/>
				<input type="hidden" name="tblMbTransactionRequest.creator.id" value="${tblMbTransactionRequest.creator.id}"/>
				<input type="hidden" name="tblMbTransactionRequest.deleted" value="${tblMbTransactionRequest.deleted}"/>
				<input type="hidden" name="tblMbTransactionRequest.version" value="${tblMbTransactionRequest.version}"/>

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
