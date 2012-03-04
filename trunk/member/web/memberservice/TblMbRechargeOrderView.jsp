<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="充值订单"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.plNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户类型" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.accountType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户号码" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人卡号" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.pan}</dd>
		</dl>
		<dl>
			<dt><hi:text key="持卡人个人信息" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.chinfo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.mchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.txAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.txIp}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.plTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.txStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.errorCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="实名认证状态" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.errorMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.settleBatchNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.settleStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.settleDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbRechargeOrder"/>：</dt><dd><fmt:formatDate value="${tblMbRechargeOrder.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbRechargeOrder"/>：</dt><dd><fmt:formatDate value="${tblMbRechargeOrder.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行交易状态" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.bankTxStatus}</dd>
		</dl>
		<dl>
			<dt><hi:text key="对账批次号" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.checkBatchNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="对账状态" entity="TblMbRechargeOrder"/>：</dt><dd>${tblMbRechargeOrder.checkStatus}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
