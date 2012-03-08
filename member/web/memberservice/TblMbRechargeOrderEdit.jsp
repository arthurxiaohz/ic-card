<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="充值订单"/></h2>
<form action="tblMbRechargeOrderSave.action?navTabId=tblMbRechargeOrderList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.plTxTraceNo" class="textInput required" value="${tblMbRechargeOrder.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.userName" class="textInput" value="${tblMbRechargeOrder.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户类型" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.accountType" class="textInput" value="${tblMbRechargeOrder.accountType}" maxlength="2"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账户号码" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.accountNo" class="textInput" value="${tblMbRechargeOrder.accountNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人卡号" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.pan" class="textInput" value="${tblMbRechargeOrder.pan}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人个人信息" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.chinfo" class="textInput" value="${tblMbRechargeOrder.chinfo}" maxlength="80"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.txTypeId" class="textInput" value="${tblMbRechargeOrder.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.mchtTxTime" class="textInput" value="${tblMbRechargeOrder.mchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.txAmount" class="textInput integer" value="${tblMbRechargeOrder.txAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.txIp" class="textInput" value="${tblMbRechargeOrder.txIp}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.plTxTime" class="textInput" value="${tblMbRechargeOrder.plTxTime}" maxlength="90"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblMbRechargeOrder"/>：</dt><dd><hi:select emu="rechargeTxStatus" name="tblMbRechargeOrder.txStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.errorCode" class="textInput" value="${tblMbRechargeOrder.errorCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证状态" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.errorMsg" class="textInput" value="${tblMbRechargeOrder.errorMsg}" maxlength="1,024"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.settleBatchNo" class="textInput" value="${tblMbRechargeOrder.settleBatchNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblMbRechargeOrder"/>：</dt><dd><hi:select emu="rechargeSettleStatus" name="tblMbRechargeOrder.settleStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.settleDate" class="textInput" value="${tblMbRechargeOrder.settleDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbRechargeOrder"/>：</dt>
			<dd>
				<input type="text" name="tblMbRechargeOrder.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbRechargeOrder.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbRechargeOrder"/>：</dt>
			<dd>
				<input type="text" name="tblMbRechargeOrder.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbRechargeOrder.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.lastUpdatedBy" class="textInput integer" value="${tblMbRechargeOrder.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="银行交易状态" entity="TblMbRechargeOrder"/>：</dt><dd><hi:select emu="bankTxStatus" name="tblMbRechargeOrder.bankTxStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="对账批次号" entity="TblMbRechargeOrder"/>：</dt><dd><input type="text" name="tblMbRechargeOrder.checkBatchNo" class="textInput" value="${tblMbRechargeOrder.checkBatchNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="对账状态" entity="TblMbRechargeOrder"/>：</dt><dd><hi:select emu="checkStatus" name="tblMbRechargeOrder.checkStatus"/></dd>			
		</dl>
				<input type="hidden" name="tblMbRechargeOrder.id" value="${tblMbRechargeOrder.id}"/>
				<input type="hidden" name="tblMbRechargeOrder.creator.id" value="${tblMbRechargeOrder.creator.id}"/>
				<input type="hidden" name="tblMbRechargeOrder.deleted" value="${tblMbRechargeOrder.deleted}"/>
				<input type="hidden" name="tblMbRechargeOrder.version" value="${tblMbRechargeOrder.version}"/>

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
