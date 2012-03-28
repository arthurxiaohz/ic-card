<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户证书"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="证书序列号" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.certSn}</dd>
		</dl>
		<dl>
			<dt><hi:text key="颁发者DN" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.issuerCertDn}</dd>
		</dl>
		<dl>
			<dt><hi:text key="证书DN" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.certDn}</dd>
		</dl>
		<dl>
			<dt><hi:text key="证书有效期开始时间" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.startTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="证书有效期结束时间" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.endTime}</dd>
		</dl>
		<dl class="nowrap">
			<dt><hi:text key="证书内容" entity="TblMchtCertificate"/>：</dt><dd>${tblMchtCertificate.certContent}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
