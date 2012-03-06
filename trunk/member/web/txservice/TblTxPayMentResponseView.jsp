<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户结果通知"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="通知记录id标识" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.responseId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="返回接口的版本号" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.versionNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="签名内容" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.signMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付结果" entity="TblTxPayMentResponse"/>：</dt><dd><hi:select emu="txStatus" name="tblTxPayMentResponse.payResult" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.merchantOrderNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单金额" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.orderAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="在系统中的订单实际支付金额" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.payAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付完成时间" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.payDatetime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数1" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.ext1}</dd>
		</dl>
		<dl>
			<dt><hi:text key="扩展参数2" entity="TblTxPayMentResponse"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentResponse.ext2}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="错误代码" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.errorCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="报文内容" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.context}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户返回结果" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.responseContent}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentResponse"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentResponse.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentResponse"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentResponse.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentResponse"/>：</dt><dd>${tblTxPayMentResponse.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
