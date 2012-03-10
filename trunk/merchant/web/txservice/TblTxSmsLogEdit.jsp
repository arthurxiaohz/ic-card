<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="短信明细"/></h2>
<form action="tblTxSmsLogSave.action?navTabId=tblTxSmsLogList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="发送方标识" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.senderId" class="textInput" value="${tblTxSmsLog.senderId}" maxlength="15"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="发送方流水号" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.seqNo" class="textInput" value="${tblTxSmsLog.seqNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手机号码" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.phoneNum" class="textInput" value="${tblTxSmsLog.phoneNum}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="短信内容" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.phoneMessage" class="textInput" value="${tblTxSmsLog.phoneMessage}" maxlength="512"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="发送状态" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.status" class="textInput" value="${tblTxSmsLog.status}" maxlength="1"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxSmsLog"/>：</dt>
			<dd>
				<input type="text" name="tblTxSmsLog.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxSmsLog.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxSmsLog"/>：</dt>
			<dd>
				<input type="text" name="tblTxSmsLog.lastUpdatedDdatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxSmsLog.lastUpdatedDdatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxSmsLog"/>：</dt><dd><input type="text" name="tblTxSmsLog.lastUpdatedBy" class="textInput integer" value="${tblTxSmsLog.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxSmsLog.id" value="${tblTxSmsLog.id}"/>
				<input type="hidden" name="tblTxSmsLog.creator.id" value="${tblTxSmsLog.creator.id}"/>
				<input type="hidden" name="tblTxSmsLog.deleted" value="${tblTxSmsLog.deleted}"/>
				<input type="hidden" name="tblTxSmsLog.version" value="${tblTxSmsLog.version}"/>

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
