<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="转账请求原始报文"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.mchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="卡余额" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.cardBalance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="卡序号" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.cardSequence}</dd>
		</dl>
		<dl>
			<dt><hi:text key="卡号" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.cardNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.mchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.txStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.msgext}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始报文" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.mchtRawMessage}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransferRequest"/>：</dt><dd><fmt:formatDate value="${tblTxTransferRequest.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransferRequest"/>：</dt><dd><fmt:formatDate value="${tblTxTransferRequest.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransferRequest"/>：</dt><dd>${tblTxTransferRequest.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
