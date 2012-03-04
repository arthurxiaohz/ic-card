<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="转账结果通知"/></h2>
<form action="tblTxTransferResponseSave.action?navTabId=tblTxTransferResponseList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="通知记录id标识" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.responseId" class="textInput required" value="${tblTxTransferResponse.responseId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="返回接口的版本号" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.versionNo" class="textInput" value="${tblTxTransferResponse.versionNo}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="签名内容" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.signMsg" class="textInput" value="${tblTxTransferResponse.signMsg}" maxlength="1,024"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="转账结果" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.transferResult" class="textInput" value="${tblTxTransferResponse.transferResult}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.plTxTraceNo" class="textInput" value="${tblTxTransferResponse.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.merchantOrderNo" class="textInput" value="${tblTxTransferResponse.merchantOrderNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户转账金额" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.transferAmount" class="textInput integer" value="${tblTxTransferResponse.transferAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.txTypeId" class="textInput" value="${tblTxTransferResponse.txTypeId}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付完成时间" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.payDatetime" class="textInput" value="${tblTxTransferResponse.payDatetime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数1" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.ext1" class="textInput" value="${tblTxTransferResponse.ext1}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数2" entity="TblTxTransferResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransferResponse.ext2" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${tblTxTransferResponse.ext2}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransferResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransferResponse.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransferResponse.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransferResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransferResponse.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransferResponse.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.lastUpdatedBy" class="textInput integer" value="${tblTxTransferResponse.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="错误代码" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.errorCode" class="textInput" value="${tblTxTransferResponse.errorCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="报文内容" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.context" class="textInput" value="${tblTxTransferResponse.context}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户返回结果" entity="TblTxTransferResponse"/>：</dt><dd><input type="text" name="tblTxTransferResponse.responseContent" class="textInput" value="${tblTxTransferResponse.responseContent}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="tblTxTransferResponse.id" value="${tblTxTransferResponse.id}"/>
				<input type="hidden" name="tblTxTransferResponse.creator.id" value="${tblTxTransferResponse.creator.id}"/>
				<input type="hidden" name="tblTxTransferResponse.deleted" value="${tblTxTransferResponse.deleted}"/>
				<input type="hidden" name="tblTxTransferResponse.version" value="${tblTxTransferResponse.version}"/>

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
