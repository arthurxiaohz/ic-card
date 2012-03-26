<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="借贷凭证"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="凭证号" entity="TblActDebitCreditVoucher"/>：</dt><dd>${tblActDebitCreditVoucher.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblActDebitCreditVoucher"/>：</dt><dd>${tblActDebitCreditVoucher.actAccount.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActDebitCreditVoucher"/>：</dt><dd>${tblActDebitCreditVoucher.amount/100}</dd>
		</dl>
		<dl>
			<dt><hi:text key="借贷方向" entity="TblActDebitCreditVoucher"/>：</dt><dd><hi:select emu="debitOrCredit" name="tblActDebitCreditVoucher.debitOrCredit" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="业务类型" entity="TblActDebitCreditVoucher"/>：</dt><dd><hi:select emu="bizType" name="tblActDebitCreditVoucher.bizType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="业务流水" entity="TblActDebitCreditVoucher"/>：</dt><dd>${tblActDebitCreditVoucher.bizLogId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActDebitCreditVoucher"/>：</dt><dd>${tblActDebitCreditVoucher.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActDebitCreditVoucher"/>：</dt><dd><fmt:formatDate value="${tblActDebitCreditVoucher.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActDebitCreditVoucher"/>：</dt><dd><fmt:formatDate value="${tblActDebitCreditVoucher.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
