<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="网关交易请求"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="交易代码" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.trancode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.trxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.txStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.msgext}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbTransactionRequest"/>：</dt><dd><fmt:formatDate value="${tblMbTransactionRequest.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbTransactionRequest"/>：</dt><dd><fmt:formatDate value="${tblMbTransactionRequest.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人卡号" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.pan}</dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人个人信息" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.chinfo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台流水号" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="币种" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.currencyType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户类型" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.accountType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户号码" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.plTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key=" 网关订单号" entity="TblMbTransactionRequest"/>：</dt><dd>${tblMbTransactionRequest.orderId}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
