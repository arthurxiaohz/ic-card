<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户证书"/></h2>
<form action="tblMchtCertificateSave.action?navTabId=tblMchtCertificateList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="证书序列号" entity="TblMchtCertificate"/>：</dt><dd><input type="text" name="tblMchtCertificate.certSn" class="textInput" value="${tblMchtCertificate.certSn}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="颁发者DN" entity="TblMchtCertificate"/>：</dt><dd><input type="text" name="tblMchtCertificate.issuerCertDn" class="textInput" value="${tblMchtCertificate.issuerCertDn}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="证书DN" entity="TblMchtCertificate"/>：</dt><dd><input type="text" name="tblMchtCertificate.certDn" class="textInput" value="${tblMchtCertificate.certDn}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="证书有效期开始时间" entity="TblMchtCertificate"/>：</dt><dd><input type="text" name="tblMchtCertificate.startTime" class="textInput" value="${tblMchtCertificate.startTime}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="证书有效期结束时间" entity="TblMchtCertificate"/>：</dt><dd><input type="text" name="tblMchtCertificate.endTime" class="textInput" value="${tblMchtCertificate.endTime}" maxlength="30"/></dd>
		</dl>
		<dl  class="nowrap">
			<dt><hi:text key="证书内容" entity="TblMchtCertificate"/>：</dt>
			<dd>
				<textarea class="editor" name="tblMchtCertificate.certContent" rows="8" cols="95"
					upLinkUrl="xhEditorUpload.action" upLinkExt="zip,rar,txt" 
					upImgUrl="xhEditorUpload.action" upImgExt="jpg,jpeg,gif,png" 
					upFlashUrl="xhEditorUpload.action" upFlashExt="swf"
					upMediaUrl="xhEditorUpload.action" upMediaExt:"avi" html5Upload="false">
				${tblMchtCertificate.certContent}</textarea>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtCertificate"/>：</dt>
			<dd>
				<input type="text" name="tblMchtCertificate.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtCertificate.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtCertificate"/>：</dt>
			<dd>
				<input type="text" name="tblMchtCertificate.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtCertificate.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMchtCertificate.id" value="${tblMchtCertificate.id}"/>
				<input type="hidden" name="tblMchtCertificate.tblMchtInfo.id" value="${tblMchtCertificate.tblMchtInfo.id}"/>
				<input type="hidden" name="tblMchtCertificate.lastUpdatedBy.id" value="${tblMchtCertificate.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMchtCertificate.creator.id" value="${tblMchtCertificate.creator.id}"/>
				<input type="hidden" name="tblMchtCertificate.version" value="${tblMchtCertificate.version}"/>

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
