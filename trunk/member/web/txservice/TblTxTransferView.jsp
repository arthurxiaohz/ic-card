<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="转账查询"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.mchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.mchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.txAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易结果通知地址" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.notifyUrl}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.txIp}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.plTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="transTxStatus" name="tblTxTransfer.txStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.errorCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="异常描述" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.errorMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.settleBatchNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="settleStatus" name="tblTxTransfer.settleStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.settleDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手续费金额" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.feeAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否已计算手续费" entity="TblTxTransfer"/>：</dt><dd><hi:select emu="hasCountFee" name="tblTxTransfer.hasCountFee" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxTransfer"/>：</dt><dd><fmt:formatDate value="${tblTxTransfer.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxTransfer"/>：</dt><dd><fmt:formatDate value="${tblTxTransfer.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxTransfer"/>：</dt><dd>${tblTxTransfer.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
