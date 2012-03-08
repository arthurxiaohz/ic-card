<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="结算批次"/></h2>
<form action="tblStlSettleBatchSave.action?navTabId=tblStlSettleBatchList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="结算批次号" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.settleNo" class="textInput required" value="${tblStlSettleBatch.settleNo}" maxlength="22"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.mchtNo" value="${tblStlSettleBatch.tblMchtInfo.mchtNo}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.mchtName" value="${tblStlSettleBatch.tblMchtInfo.mchtName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行行号" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.bankNo" value="${tblStlSettleBatch.tblMchtInfo.bankNo}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="开户行名称" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.bankName" value="${tblStlSettleBatch.tblMchtInfo.bankName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户账号" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.bankAccountNo" value="${tblStlSettleBatch.tblMchtInfo.bankAccountNo}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="银行账户名称" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="hidden" name="tblStlSettleBatch.tblMchtInfo.id" value="${tblStlSettleBatch.tblMchtInfo.id}"/>
				<input type="text" class="textInput" name="tblStlSettleBatch.hi_tblMchtInfo.bankAccountName" value="${tblStlSettleBatch.tblMchtInfo.bankAccountName}"
					autocomplete="off" lookupGroup="tblStlSettleBatch" lookupName="tblMchtInfo" suggestClass="cn.net.iccard.bm.mcht.model.TblMchtInfo" searchFields="mchtNo,mchtName,bankNo,bankName,bankAccountNo,bankAccountName"/>
				<a class="btnLook" href="<hi:url>tblMchtInfoLookup.action?lookup=1</hi:url>" lookupGroup="tblStlSettleBatch" lookupName="tblMchtInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleBatch.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleBatch.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleBatch.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleBatch.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="支付总比数" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.orderCount" class="textInput integer" value="${tblStlSettleBatch.orderCount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付总金额" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.balance" class="textInput" value="${tblStlSettleBatch.balance}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付总手续费" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.fee" class="textInput" value="${tblStlSettleBatch.fee}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总笔数" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.refundCount" class="textInput integer" value="${tblStlSettleBatch.refundCount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总金额" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.refundBalance" class="textInput integer" value="${tblStlSettleBatch.refundBalance}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款总手续费" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.refundFee" class="textInput" value="${tblStlSettleBatch.refundFee}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算金额" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.settleAmount" class="textInput integer" value="${tblStlSettleBatch.settleAmount}" maxlength="30"/></dd>
		</dl>
				<input type="hidden" name="tblStlSettleBatch.id" value="${tblStlSettleBatch.id}"/>
				<input type="hidden" name="tblStlSettleBatch.lastUpdatedBy.id" value="${tblStlSettleBatch.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblStlSettleBatch.creator.id" value="${tblStlSettleBatch.creator.id}"/>
				<input type="hidden" name="tblStlSettleBatch.deleted" value="${tblStlSettleBatch.deleted}"/>
				<input type="hidden" name="tblStlSettleBatch.version" value="${tblStlSettleBatch.version}"/>

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
