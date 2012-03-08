<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="调账申请表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlAdjustDetail"/>：</dt><dd>${tblStlAdjustDetail.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="网关订单号" entity="TblStlAdjustDetail"/>：</dt><dd>${tblStlAdjustDetail.orderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlAdjustDetail"/>：</dt><dd><hi:select emu="adjustStatus" name="tblStlAdjustDetail.status" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlAdjustDetail"/>：</dt><dd><fmt:formatDate value="${tblStlAdjustDetail.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlAdjustDetail"/>：</dt><dd><fmt:formatDate value="${tblStlAdjustDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlAdjustDetail"/>：</dt><dd>${tblStlAdjustDetail.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="描述" entity="TblStlAdjustDetail"/>：</dt><dd>${tblStlAdjustDetail.description}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
