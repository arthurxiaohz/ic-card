<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="转账结果通知"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="返回接口的版本号" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.versionNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="签名内容" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.signMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="转账结果" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.transferResult}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.merchantOrderNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户转账金额" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.transferAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付完成时间" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.payDatetime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数1" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.ext1}</dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数2" entity="TblTxTransferResponse"/>：</dt><dd><fmt:formatDate value="${tblTxTransferResponse.ext2}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransferResponse"/>：</dt><dd><fmt:formatDate value="${tblTxTransferResponse.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransferResponse"/>：</dt><dd><fmt:formatDate value="${tblTxTransferResponse.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="错误代码" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.errorCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="报文内容" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.context}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户返回结果" entity="TblTxTransferResponse"/>：</dt><dd>${tblTxTransferResponse.responseContent}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
