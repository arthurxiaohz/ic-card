<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="积分规则"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbPointRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointRule.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbPointRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointRule.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="起始金额" entity="TblMbPointRule"/>：</dt><dd>${tblMbPointRule.minAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="截止金额" entity="TblMbPointRule"/>：</dt><dd>${tblMbPointRule.maxAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分规则类型" entity="TblMbPointRule"/>：</dt><dd><hi:select emu="pointRuleType" name="tblMbPointRule.pointRuleType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="参数值" entity="TblMbPointRule"/>：</dt><dd>${tblMbPointRule.ruleValue}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointRule.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointRule.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
