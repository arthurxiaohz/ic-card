<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员积分"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="帐号" entity="TblMbPoint"/>：</dt><dd>${tblMbPoint.tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbPoint"/>：</dt><dd>${tblMbPoint.tblMbInfo.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分余额" entity="TblMbPoint"/>：</dt><dd>${tblMbPoint.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbPoint"/>：</dt><dd><fmt:formatDate value="${tblMbPoint.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbPoint"/>：</dt><dd><fmt:formatDate value="${tblMbPoint.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
