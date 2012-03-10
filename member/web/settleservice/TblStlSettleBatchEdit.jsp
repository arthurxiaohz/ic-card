<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="结算批次"/></h2>
<form action="tblStlSettleBatchSave.action?navTabId=tblStlSettleBatchList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="结算批次号" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.settleBatchNo" class="textInput" value="${tblStlSettleBatch.settleBatchNo}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleBatch.settleDate" class="textInput date" readonly="readonly"
					value="<fmt:formatDate value='${tblStlSettleBatch.settleDate}' pattern='yyyy-MM-dd'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="总条数" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.totalCount" class="textInput integer" value="${tblStlSettleBatch.totalCount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="总金额" entity="TblStlSettleBatch"/>：</dt><dd><input type="text" name="tblStlSettleBatch.totalAmount" class="textInput integer" value="${tblStlSettleBatch.totalAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlSettleBatch"/>：</dt><dd><hi:select emu="settleBatchStatus" name="tblStlSettleBatch.settleBatchStatus"/></dd>			
		</dl>
		<dl  class="nowrap">
			<dt><hi:text key="备注" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<textarea class="editor" name="tblStlSettleBatch.remark" rows="8" cols="95"
					upLinkUrl="xhEditorUpload.action" upLinkExt="zip,rar,txt" 
					upImgUrl="xhEditorUpload.action" upImgExt="jpg,jpeg,gif,png" 
					upFlashUrl="xhEditorUpload.action" upFlashExt="swf"
					upMediaUrl="xhEditorUpload.action" upMediaExt:"avi" html5Upload="false">
				${tblStlSettleBatch.remark}</textarea>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleBatch.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleBatch.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlSettleBatch"/>：</dt>
			<dd>
				<input type="text" name="tblStlSettleBatch.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlSettleBatch.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblStlSettleBatch.id" value="${tblStlSettleBatch.id}"/>
				<input type="hidden" name="tblStlSettleBatch.lastUpdatedBy.id" value="${tblStlSettleBatch.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblStlSettleBatch.creator.id" value="${tblStlSettleBatch.creator.id}"/>
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
