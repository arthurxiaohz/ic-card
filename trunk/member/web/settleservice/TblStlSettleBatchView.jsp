<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="结算批次"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="结算批次号" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.settleNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.mchtName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行行号" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.bankNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行名称" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.bankName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户账号" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.bankAccountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户名称" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.tblMchtInfo.bankAccountName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleBatch"/>：</dt><dd><fmt:formatDate value="${tblStlSettleBatch.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlSettleBatch"/>：</dt><dd><fmt:formatDate value="${tblStlSettleBatch.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="支付总比数" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.orderCount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付总金额" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付总手续费" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.fee}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总笔数" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.refundCount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总金额" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.refundBalance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总手续费" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.refundFee}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算金额" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.settleAmount}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
