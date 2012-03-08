<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="转账查询"/></h2>
<form action="tblTxTransferSave.action?navTabId=tblTxTransferList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.plTxTraceNo" class="textInput required" value="${tblTxTransfer.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.userName" class="textInput" value="${tblTxTransfer.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.txTypeId" class="textInput" value="${tblTxTransfer.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.mchtNo" class="textInput" value="${tblTxTransfer.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.mchtTxTime" class="textInput" value="${tblTxTransfer.mchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.mchtTxTraceNo" class="textInput" value="${tblTxTransfer.mchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.txAmount" class="textInput integer" value="${tblTxTransfer.txAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易结果通知地址" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.notifyUrl" class="textInput" value="${tblTxTransfer.notifyUrl}" maxlength="256"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.txIp" class="textInput" value="${tblTxTransfer.txIp}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.plTxTime" class="textInput" value="${tblTxTransfer.plTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="transTxStatus" name="tblTxTransfer.txStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.voucherNo" class="textInput" value="${tblTxTransfer.voucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.errorCode" class="textInput" value="${tblTxTransfer.errorCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="异常描述" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.errorMsg" class="textInput" value="${tblTxTransfer.errorMsg}" maxlength="1,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.settleBatchNo" class="textInput" value="${tblTxTransfer.settleBatchNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="settleStatus" name="tblTxTransfer.settleStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.settleDate" class="textInput" value="${tblTxTransfer.settleDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手续费金额" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.feeAmount" class="textInput integer" value="${tblTxTransfer.feeAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="是否已计算手续费" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="hasCountFee" name="tblTxTransfer.hasCountFee"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransfer"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransfer.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransfer.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransfer"/>：</dt>
			<dd>
				<input type="text" name="tblTxTransfer.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxTransfer.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransfer"/>：</dt><dd><input type="text" name="tblTxTransfer.lastUpdatedBy" class="textInput integer" value="${tblTxTransfer.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxTransfer.id" value="${tblTxTransfer.id}"/>
				<input type="hidden" name="tblTxTransfer.creator.id" value="${tblTxTransfer.creator.id}"/>
				<input type="hidden" name="tblTxTransfer.deleted" value="${tblTxTransfer.deleted}"/>
				<input type="hidden" name="tblTxTransfer.version" value="${tblTxTransfer.version}"/>

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
