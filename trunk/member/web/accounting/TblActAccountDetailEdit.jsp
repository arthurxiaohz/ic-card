<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="账户明细"/></h2>
<form action="tblActAccountDetailSave.action?navTabId=tblActAccountDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="账号" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="hidden" name="tblActAccountDetail.actAccount.id" value="${tblActAccountDetail.actAccount.id}"/>
				<input type="text" class="textInput" name="tblActAccountDetail.hi_actAccount.accountNo" value="${tblActAccountDetail.actAccount.accountNo}"
					autocomplete="off" lookupGroup="tblActAccountDetail" lookupName="actAccount" suggestClass="cn.net.iccard.bm.accounting.model.ActAccount" searchFields="accountNo,accountCatalog,accountPartyType,accountParty,accountName"/>
				<a class="btnLook" href="<hi:url>actAccountLookup.action?lookup=1</hi:url>" lookupGroup="tblActAccountDetail" lookupName="actAccount"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户分类" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblActAccountDetail.hi_actAccount.accountCatalog" value="<hi:select emu="accountCatalog" name="tblActAccountDetail.actAccount.accountCatalog" isLabel="true"/>" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方类型" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblActAccountDetail.hi_actAccount.accountPartyType" value="<hi:select emu="accountPartyType" name="tblActAccountDetail.actAccount.accountPartyType" isLabel="true"/>" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户方" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblActAccountDetail.hi_actAccount.accountParty" value="${tblActAccountDetail.actAccount.accountParty}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户名称" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblActAccountDetail.hi_actAccount.accountName" value="${tblActAccountDetail.actAccount.accountName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="凭证类型" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="voucherType" name="tblActAccountDetail.voucherType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblActAccountDetail"/>：</dt><dd><input type="text" name="tblActAccountDetail.voucherNo" class="textInput" value="${tblActAccountDetail.voucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblActAccountDetail"/>：</dt><dd><input type="text" name="tblActAccountDetail.amount" class="textInput integer" value="${tblActAccountDetail.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="借贷方向" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="debitOrCredit" name="tblActAccountDetail.debitOrCredit"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="余额" entity="TblActAccountDetail"/>：</dt><dd><input type="text" name="tblActAccountDetail.balance" class="textInput integer" value="${tblActAccountDetail.balance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblActAccountDetail"/>：</dt><dd><input type="text" name="tblActAccountDetail.remark" class="textInput" value="${tblActAccountDetail.remark}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="截止日期" entity="TblActAccountDetail"/>：</dt><dd><input type="text" name="tblActAccountDetail.expiredDate" class="textInput" value="${tblActAccountDetail.expiredDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="处理状态" entity="TblActAccountDetail"/>：</dt><dd><hi:select emu="handledStatus" name="tblActAccountDetail.settleStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" name="tblActAccountDetail.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActAccountDetail.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblActAccountDetail"/>：</dt>
			<dd>
				<input type="text" name="tblActAccountDetail.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblActAccountDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblActAccountDetail.id" value="${tblActAccountDetail.id}"/>
				<input type="hidden" name="tblActAccountDetail.lastUpdatedBy.id" value="${tblActAccountDetail.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblActAccountDetail.creator.id" value="${tblActAccountDetail.creator.id}"/>
				<input type="hidden" name="tblActAccountDetail.deleted" value="${tblActAccountDetail.deleted}"/>
				<input type="hidden" name="tblActAccountDetail.version" value="${tblActAccountDetail.version}"/>

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
