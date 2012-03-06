<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户结果通知"/></h2>
<form action="tblTxPayMentResponseSave.action?navTabId=tblTxPayMentResponseList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="通知记录id标识" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.responseId" class="textInput required" value="${tblTxPayMentResponse.responseId}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="返回接口的版本号" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.versionNo" class="textInput" value="${tblTxPayMentResponse.versionNo}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="签名内容" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.signMsg" class="textInput" value="${tblTxPayMentResponse.signMsg}" maxlength="1,024"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付结果" entity="TblTxPayMentResponse"/>：</dt><dd><hi:select emu="txStatus" name="tblTxPayMentResponse.payResult"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.mchtNo" class="textInput" value="${tblTxPayMentResponse.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.merchantOrderNo" class="textInput" value="${tblTxPayMentResponse.merchantOrderNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单金额" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.orderAmount" class="textInput integer" value="${tblTxPayMentResponse.orderAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.txTypeId" class="textInput" value="${tblTxPayMentResponse.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="在系统中的订单实际支付金额" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.payAmount" class="textInput integer" value="${tblTxPayMentResponse.payAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付完成时间" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.payDatetime" class="textInput" value="${tblTxPayMentResponse.payDatetime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数1" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.ext1" class="textInput" value="${tblTxPayMentResponse.ext1}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数2" entity="TblTxPayMentResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentResponse.ext2" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${tblTxPayMentResponse.ext2}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="错误代码" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.errorCode" class="textInput" value="${tblTxPayMentResponse.errorCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="报文内容" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.context" class="textInput" value="${tblTxPayMentResponse.context}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户返回结果" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.responseContent" class="textInput" value="${tblTxPayMentResponse.responseContent}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentResponse.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentResponse.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentResponse"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentResponse.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentResponse.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentResponse"/>：</dt><dd><input type="text" name="tblTxPayMentResponse.lastUpdatedBy" class="textInput integer" value="${tblTxPayMentResponse.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxPayMentResponse.id" value="${tblTxPayMentResponse.id}"/>
				<input type="hidden" name="tblTxPayMentResponse.creator.id" value="${tblTxPayMentResponse.creator.id}"/>
				<input type="hidden" name="tblTxPayMentResponse.deleted" value="${tblTxPayMentResponse.deleted}"/>
				<input type="hidden" name="tblTxPayMentResponse.version" value="${tblTxPayMentResponse.version}"/>

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
