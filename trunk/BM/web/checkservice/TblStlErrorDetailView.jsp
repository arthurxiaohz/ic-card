<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="差错明细表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="订单金额" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="订单创建时间" entity="TblStlErrorDetail"/>：</dt><dd><fmt:formatDate value="${tblStlErrorDetail.orderCreateDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="机构订单号" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.orgOrderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="连接id" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.connectionId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlErrorDetail"/>：</dt><dd><fmt:formatDate value="${tblStlErrorDetail.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlErrorDetail"/>：</dt><dd><fmt:formatDate value="${tblStlErrorDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="差错类型" entity="TblStlErrorDetail"/>：</dt><dd><hi:select emu="discrepancyType" name="tblStlErrorDetail.discrepancyType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlErrorDetail"/>：</dt><dd>${tblStlErrorDetail.description}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
