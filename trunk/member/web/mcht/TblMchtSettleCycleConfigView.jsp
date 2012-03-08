<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="商户结算周期配置"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="结算周期类型" entity="TblMchtSettleCycleConfig"/>：</dt><dd><hi:select emu="mchtSettleCycleType" name="tblMchtSettleCycleConfig.settleCycleType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="参数值" entity="TblMchtSettleCycleConfig"/>：</dt><dd>${tblMchtSettleCycleConfig.ruleValue}</dd>
		</dl>
		<dl>
			<dt><hi:text key="最小结算金额" entity="TblMchtSettleCycleConfig"/>：</dt><dd>${tblMchtSettleCycleConfig.threshold}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMchtSettleCycleConfig"/>：</dt><dd><fmt:formatDate value="${tblMchtSettleCycleConfig.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMchtSettleCycleConfig"/>：</dt><dd><fmt:formatDate value="${tblMchtSettleCycleConfig.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
