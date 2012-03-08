<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="网关交易结果"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="对应的系统订单号" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.ordedId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易系统的机构号" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.orgId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易系统的交易流水号" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.orgOrdedId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="报文的原始报文" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.context}</dd>
		</dl>
		<dl>
			<dt><hi:text key="返回报文标识订单的成功状态" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.state}</dd>
		</dl>
		<dl>
			<dt><hi:text key="发送报文的IP地址" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.sourceIp}</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbTransactionResponse"/>：</dt><dd><fmt:formatDate value="${tblMbTransactionResponse.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbTransactionResponse"/>：</dt><dd>${tblMbTransactionResponse.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbTransactionResponse"/>：</dt><dd><fmt:formatDate value="${tblMbTransactionResponse.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
