<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户请求原始报文"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.mchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始商户交易流水号" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.lastMchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始交易发生时间" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.lastMchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.mchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.txStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="附加信息" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.msgext}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始报文" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.mchtRawMessage}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentRequest"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentRequest.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentRequest"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentRequest.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentRequest"/>：</dt><dd>${tblTxPayMentRequest.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
