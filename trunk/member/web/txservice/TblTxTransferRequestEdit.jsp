<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="转账请求原始报文"/></h2>
<form action="tblTxTransferRequestSave.action?navTabId=tblTxTransferRequestList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.mchtTxTraceNo" class="textInput required" value="${tblTxTransferRequest.mchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.mchtNo" class="textInput" value="${tblTxTransferRequest.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.amount" class="textInput" value="${tblTxTransferRequest.amount}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="卡余额" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.cardBalance" class="textInput" value="${tblTxTransferRequest.cardBalance}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="卡序号" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.cardSequence" class="textInput integer" value="${tblTxTransferRequest.cardSequence}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="卡号" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.cardNo" class="textInput" value="${tblTxTransferRequest.cardNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.mchtTxTime" class="textInput" value="${tblTxTransferRequest.mchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.txStatus" class="textInput" value="${tblTxTransferRequest.txStatus}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.txTypeId" class="textInput" value="${tblTxTransferRequest.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.msgext" class="textInput" value="${tblTxTransferRequest.msgext}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始报文" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.mchtRawMessage" class="textInput" value="${tblTxTransferRequest.mchtRawMessage}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransferRequest"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransferRequest.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransferRequest.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransferRequest"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransferRequest.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransferRequest.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransferRequest"/>：</dt><dd><input type="text" name="tblTxTransferRequest.lastUpdatedBy" class="textInput integer" value="${tblTxTransferRequest.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxTransferRequest.id" value="${tblTxTransferRequest.id}"/>
				<input type="hidden" name="tblTxTransferRequest.creator.id" value="${tblTxTransferRequest.creator.id}"/>
				<input type="hidden" name="tblTxTransferRequest.deleted" value="${tblTxTransferRequest.deleted}"/>
				<input type="hidden" name="tblTxTransferRequest.version" value="${tblTxTransferRequest.version}"/>

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
