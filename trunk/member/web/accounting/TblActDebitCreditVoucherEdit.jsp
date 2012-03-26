<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="借贷凭证"/></h2>
<form action="tblActDebitCreditVoucherSave.action?navTabId=tblActDebitCreditVoucherList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="凭证号" entity="TblActDebitCreditVoucher"/>：</dt><dd><input type="text" name="tblActDebitCreditVoucher.voucherNo" class="textInput" value="${tblActDebitCreditVoucher.voucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblActDebitCreditVoucher"/>：</dt>
			<dd>
				<input type="hidden" name="tblActDebitCreditVoucher.actAccount.id" value="${tblActDebitCreditVoucher.actAccount.id}"/>
				<input type="text" class="textInput" name="tblActDebitCreditVoucher.hi_actAccount.accountNo" value="${tblActDebitCreditVoucher.actAccount.accountNo}"
					autocomplete="off" lookupGroup="tblActDebitCreditVoucher" lookupName="actAccount" suggestClass="cn.net.iccard.bm.accounting.model.ActAccount" searchFields="accountNo"/>
				<a class="btnLook" href="<hi:url>actAccountLookup.action?lookup=1</hi:url>" lookupGroup="tblActDebitCreditVoucher" lookupName="actAccount"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActDebitCreditVoucher"/>：</dt><dd><input type="text" name="tblActDebitCreditVoucher.amount" class="textInput integer" value="${tblActDebitCreditVoucher.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="借贷方向" entity="TblActDebitCreditVoucher"/>：</dt><dd><hi:select emu="debitOrCredit" name="tblActDebitCreditVoucher.debitOrCredit"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="业务类型" entity="TblActDebitCreditVoucher"/>：</dt><dd><hi:select emu="bizType" name="tblActDebitCreditVoucher.bizType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="业务流水" entity="TblActDebitCreditVoucher"/>：</dt><dd><input type="text" name="tblActDebitCreditVoucher.bizLogId" class="textInput integer" value="${tblActDebitCreditVoucher.bizLogId}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActDebitCreditVoucher"/>：</dt><dd><input type="text" name="tblActDebitCreditVoucher.remark" class="textInput" value="${tblActDebitCreditVoucher.remark}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActDebitCreditVoucher"/>：</dt>
			<dd>
				<input type="text" name="tblActDebitCreditVoucher.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActDebitCreditVoucher.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActDebitCreditVoucher"/>：</dt>
			<dd>
				<input type="text" name="tblActDebitCreditVoucher.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActDebitCreditVoucher.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblActDebitCreditVoucher.id" value="${tblActDebitCreditVoucher.id}"/>
				<input type="hidden" name="tblActDebitCreditVoucher.lastUpdatedBy.id" value="${tblActDebitCreditVoucher.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblActDebitCreditVoucher.creator.id" value="${tblActDebitCreditVoucher.creator.id}"/>
				<input type="hidden" name="tblActDebitCreditVoucher.deleted" value="${tblActDebitCreditVoucher.deleted}"/>
				<input type="hidden" name="tblActDebitCreditVoucher.version" value="${tblActDebitCreditVoucher.version}"/>

		<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
