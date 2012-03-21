<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户支付配置"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="是否允许接入支付平台" entity="TblMchtPaymentConfig"/>：</dt><dd><hi:select emu="yesNo" name="tblMchtPaymentConfig.authorized" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="签名方式" entity="TblMchtPaymentConfig"/>：</dt><dd><hi:select emu="signType" name="tblMchtPaymentConfig.signType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="MD5" entity="TblMchtPaymentConfig"/>：</dt><dd>${tblMchtPaymentConfig.md5}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtPaymentConfig"/>：</dt><dd><fmt:formatDate value="${tblMchtPaymentConfig.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtPaymentConfig"/>：</dt><dd><fmt:formatDate value="${tblMchtPaymentConfig.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
