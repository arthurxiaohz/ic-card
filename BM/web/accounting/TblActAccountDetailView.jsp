<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="账户明细"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="账号" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.actAccount.accountNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户分类" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="accountCatalog" name="tblActAccountDetail.actAccount.accountCatalog" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方类型" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="accountPartyType" name="tblActAccountDetail.actAccount.accountPartyType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.actAccount.accountParty}</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户名称" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.actAccount.accountName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="凭证类型" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="voucherType" name="tblActAccountDetail.voucherType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="借贷方向" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="debitOrCredit" name="tblActAccountDetail.debitOrCredit" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="余额" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="截止日期" entity="TblActAccountDetail"/>：</dt><dd>${tblActAccountDetail.expiredDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="settleStatus" name="tblActAccountDetail.settleStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActAccountDetail"/>：</dt><dd><fmt:formatDate value="${tblActAccountDetail.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActAccountDetail"/>：</dt><dd><fmt:formatDate value="${tblActAccountDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
