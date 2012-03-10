<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员积分兑换规则"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="积分" entity="TblMbPointExchangeRule"/>：</dt><dd>${tblMbPointExchangeRule.point}</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblMbPointExchangeRule"/>：</dt><dd>${tblMbPointExchangeRule.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期开始日期" entity="TblMbPointExchangeRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointExchangeRule.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="有效期结束日期" entity="TblMbPointExchangeRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointExchangeRule.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPointExchangeRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointExchangeRule.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPointExchangeRule"/>：</dt><dd><fmt:formatDate value="${tblMbPointExchangeRule.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblMbPointExchangeRule"/>：</dt><dd>${tblMbPointExchangeRule.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
