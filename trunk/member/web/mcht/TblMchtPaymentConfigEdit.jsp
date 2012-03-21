<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="商户支付配置"/></h2>
<form action="tblMchtPaymentConfigSave.action?navTabId=tblMchtPaymentConfigList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="是否允许接入支付平台" entity="TblMchtPaymentConfig"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtPaymentConfig.authorized"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="签名方式" entity="TblMchtPaymentConfig"/>：</dt><dd><hi:select emu="signType" name="tblMchtPaymentConfig.signType"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="MD5" entity="TblMchtPaymentConfig"/>：</dt><dd><input type="text" name="tblMchtPaymentConfig.md5" class="textInput" value="${tblMchtPaymentConfig.md5}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtPaymentConfig"/>：</dt>
			<dd>
				<input type="text" name="tblMchtPaymentConfig.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtPaymentConfig.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtPaymentConfig"/>：</dt>
			<dd>
				<input type="text" name="tblMchtPaymentConfig.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMchtPaymentConfig.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMchtPaymentConfig.id" value="${tblMchtPaymentConfig.id}"/>
				<input type="hidden" name="tblMchtPaymentConfig.tblMchtInfo.id" value="${tblMchtPaymentConfig.tblMchtInfo.id}"/>
				<input type="hidden" name="tblMchtPaymentConfig.lastUpdatedBy.id" value="${tblMchtPaymentConfig.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMchtPaymentConfig.creator.id" value="${tblMchtPaymentConfig.creator.id}"/>
				<input type="hidden" name="tblMchtPaymentConfig.version" value="${tblMchtPaymentConfig.version}"/>

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
