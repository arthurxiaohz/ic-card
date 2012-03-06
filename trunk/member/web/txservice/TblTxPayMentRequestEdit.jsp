<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户请求原始报文"/></h2>
<form action="tblTxPayMentRequestSave.action?navTabId=tblTxPayMentRequestList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.mchtTxTraceNo" class="textInput required" value="${tblTxPayMentRequest.mchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始商户交易流水号" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.lastMchtTxTraceNo" class="textInput" value="${tblTxPayMentRequest.lastMchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.mchtNo" class="textInput" value="${tblTxPayMentRequest.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.amount" class="textInput integer" value="${tblTxPayMentRequest.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始交易发生时间" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.lastMchtTxTime" class="textInput" value="${tblTxPayMentRequest.lastMchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.mchtTxTime" class="textInput" value="${tblTxPayMentRequest.mchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.txStatus" class="textInput" value="${tblTxPayMentRequest.txStatus}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.txTypeId" class="textInput" value="${tblTxPayMentRequest.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.msgext" class="textInput" value="${tblTxPayMentRequest.msgext}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始报文" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.mchtRawMessage" class="textInput" value="${tblTxPayMentRequest.mchtRawMessage}" maxlength="3,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentRequest"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentRequest.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentRequest.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentRequest"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentRequest.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentRequest.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentRequest"/>：</dt><dd><input type="text" name="tblTxPayMentRequest.lastUpdatedBy" class="textInput integer" value="${tblTxPayMentRequest.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxPayMentRequest.id" value="${tblTxPayMentRequest.id}"/>
				<input type="hidden" name="tblTxPayMentRequest.creator.id" value="${tblTxPayMentRequest.creator.id}"/>
				<input type="hidden" name="tblTxPayMentRequest.deleted" value="${tblTxPayMentRequest.deleted}"/>
				<input type="hidden" name="tblTxPayMentRequest.version" value="${tblTxPayMentRequest.version}"/>

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
