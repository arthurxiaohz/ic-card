<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="转账凭证"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="凭证号" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="出账账号" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.actAccountFrom.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="入账账号" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.actAccountTo.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.amount/100}</dd>
		</dl>
		<dl>
			<dt><hi:text key="业务类型" entity="TblActTransferVoucher"/>：</dt><dd><hi:select emu="bizType" name="tblActTransferVoucher.bizType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="业务流水" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.bizLogId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActTransferVoucher"/>：</dt><dd>${tblActTransferVoucher.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActTransferVoucher"/>：</dt><dd><fmt:formatDate value="${tblActTransferVoucher.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActTransferVoucher"/>：</dt><dd><fmt:formatDate value="${tblActTransferVoucher.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
