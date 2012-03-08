<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="转账凭证"/></h2>
<form action="tblActTransferVoucherSave.action?navTabId=tblActTransferVoucherList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="凭证号" entity="TblActTransferVoucher"/>：</dt><dd><input type="text" name="tblActTransferVoucher.voucherNo" class="textInput" value="${tblActTransferVoucher.voucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="出账账号" entity="TblActTransferVoucher"/>：</dt>
			<dd>
				<input type="hidden" name="tblActTransferVoucher.actAccountFrom.id" value="${tblActTransferVoucher.actAccountFrom.id}"/>
				<input type="text" class="textInput" name="tblActTransferVoucher.hi_actAccountFrom.accountNo" value="${tblActTransferVoucher.actAccountFrom.accountNo}"
					autocomplete="off" lookupGroup="tblActTransferVoucher" lookupName="actAccountFrom" suggestClass="cn.net.iccard.bm.accounting.model.ActAccount" searchFields="accountNo"/>
				<a class="btnLook" href="<hi:url>actAccountLookup.action?lookup=1</hi:url>" lookupGroup="tblActTransferVoucher" lookupName="actAccountFrom"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="入账账号" entity="TblActTransferVoucher"/>：</dt>
			<dd>
				<input type="hidden" name="tblActTransferVoucher.actAccountTo.id" value="${tblActTransferVoucher.actAccountTo.id}"/>
				<input type="text" class="textInput" name="tblActTransferVoucher.hi_actAccountTo.accountNo" value="${tblActTransferVoucher.actAccountTo.accountNo}"
					autocomplete="off" lookupGroup="tblActTransferVoucher" lookupName="actAccountTo" suggestClass="cn.net.iccard.bm.accounting.model.ActAccount" searchFields="accountNo"/>
				<a class="btnLook" href="<hi:url>actAccountLookup.action?lookup=1</hi:url>" lookupGroup="tblActTransferVoucher" lookupName="actAccountTo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActTransferVoucher"/>：</dt><dd><input type="text" name="tblActTransferVoucher.amount" class="textInput integer" value="${tblActTransferVoucher.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="业务类型" entity="TblActTransferVoucher"/>：</dt><dd><hi:select emu="bizType" name="tblActTransferVoucher.bizType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="业务流水" entity="TblActTransferVoucher"/>：</dt><dd><input type="text" name="tblActTransferVoucher.bizLogId" class="textInput integer" value="${tblActTransferVoucher.bizLogId}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActTransferVoucher"/>：</dt><dd><input type="text" name="tblActTransferVoucher.remark" class="textInput" value="${tblActTransferVoucher.remark}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActTransferVoucher"/>：</dt>
			<dd>
				<input type="text" name="tblActTransferVoucher.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActTransferVoucher.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActTransferVoucher"/>：</dt>
			<dd>
				<input type="text" name="tblActTransferVoucher.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActTransferVoucher.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblActTransferVoucher.id" value="${tblActTransferVoucher.id}"/>
				<input type="hidden" name="tblActTransferVoucher.lastUpdatedBy.id" value="${tblActTransferVoucher.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblActTransferVoucher.creator.id" value="${tblActTransferVoucher.creator.id}"/>
				<input type="hidden" name="tblActTransferVoucher.deleted" value="${tblActTransferVoucher.deleted}"/>
				<input type="hidden" name="tblActTransferVoucher.version" value="${tblActTransferVoucher.version}"/>

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
