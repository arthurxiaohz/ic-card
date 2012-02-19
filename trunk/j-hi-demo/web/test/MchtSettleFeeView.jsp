<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户手续费"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="比率" entity="MchtSettleFee"/>：</dt><dd>${mchtSettleFee.byRate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="MchtSettleFee"/>：</dt><dd>${mchtSettleFee.mchtCd}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="MchtSettleFee"/>：</dt><dd>${mchtSettleFee.mchtName}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
