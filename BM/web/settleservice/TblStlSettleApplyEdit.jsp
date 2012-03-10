<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="结算申请"/></h2>
<form action="tblStlSettleApplySave.action?navTabId=tblStlSettleApplyList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="商户号" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="hidden" name="tblStlSettleApply.tblMchtInfo.id" value="${tblStlSettleApply.tblMchtInfo.id}"/>
				<input type="text" class="textInput" name="tblStlSettleApply.hi_tblMchtInfo.mchtNo" value="${tblStlSettleApply.tblMchtInfo.mchtNo}"
					autocomplete="off" lookupGroup="tblStlSettleApply" lookupName="tblMchtInfo" suggestClass="cn.net.iccard.bm.mcht.model.TblMchtInfo" searchFields="mchtNo,mchtName"/>
				<a class="btnLook" href="<hi:url>tblMchtInfoLookup.action?lookup=1</hi:url>" lookupGroup="tblStlSettleApply" lookupName="tblMchtInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleApply.hi_tblMchtInfo.mchtName" value="${tblStlSettleApply.tblMchtInfo.mchtName}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="账户可用余额" entity="TblStlSettleApply"/>：</dt><dd><input type="text" name="tblStlSettleApply.availableBalance" class="textInput integer" value="${tblStlSettleApply.availableBalance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="申请结算金额" entity="TblStlSettleApply"/>：</dt><dd><input type="text" name="tblStlSettleApply.amount" class="textInput integer" value="${tblStlSettleApply.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlSettleApply"/>：</dt><dd><hi:select emu="settleApplyStatus" name="tblStlSettleApply.settleApplyStatus"/></dd>			
		</dl>
		<dl  class="nowrap">
			<dt><hi:text key="审核意见" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<textarea class="editor" name="tblStlSettleApply.auditOpinion" rows="8" cols="95"
					upLinkUrl="xhEditorUpload.action" upLinkExt="zip,rar,txt" 
					upImgUrl="xhEditorUpload.action" upImgExt="jpg,jpeg,gif,png" 
					upFlashUrl="xhEditorUpload.action" upFlashExt="swf"
					upMediaUrl="xhEditorUpload.action" upMediaExt:"avi" html5Upload="false">
				${tblStlSettleApply.auditOpinion}</textarea>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblStlSettleApply"/>：</dt><dd><input type="text" name="tblStlSettleApply.remark" class="textInput" value="${tblStlSettleApply.remark}" maxlength="200"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblStlSettleApply.hi_tblStlSettleBatch.settleDate" value="${tblStlSettleApply.tblStlSettleBatch.settleDate}" readonly="readonly"/>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="hidden" name="tblStlSettleApply.tblStlSettleBatch.id" value="${tblStlSettleApply.tblStlSettleBatch.id}"/>
				<input type="text" class="textInput" name="tblStlSettleApply.hi_tblStlSettleBatch.settleBatchNo" value="${tblStlSettleApply.tblStlSettleBatch.settleBatchNo}"
					autocomplete="off" lookupGroup="tblStlSettleApply" lookupName="tblStlSettleBatch" suggestClass="cn.net.iccard.bm.settleservice.model.TblStlSettleBatch" searchFields="settleDate,settleBatchNo"/>
				<a class="btnLook" href="<hi:url>tblStlSettleBatchLookup.action?lookup=1</hi:url>" lookupGroup="tblStlSettleApply" lookupName="tblStlSettleBatch"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleApply.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleApply.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlSettleApply"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleApply.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleApply.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblStlSettleApply.id" value="${tblStlSettleApply.id}"/>
				<input type="hidden" name="tblStlSettleApply.lastUpdatedBy.id" value="${tblStlSettleApply.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblStlSettleApply.creator.id" value="${tblStlSettleApply.creator.id}"/>
				<input type="hidden" name="tblStlSettleApply.version" value="${tblStlSettleApply.version}"/>

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
