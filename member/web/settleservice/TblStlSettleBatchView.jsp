<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="结算批次"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="结算批次号" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.settleBatchNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日" entity="TblStlSettleBatch"/>：</dt><dd><fmt:formatDate value="${tblStlSettleBatch.settleDate}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="总条数" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.totalCount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="总金额" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.totalAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlSettleBatch"/>：</dt><dd><hi:select emu="settleBatchStatus" name="tblStlSettleBatch.settleBatchStatus" isLabel="true"/></dd>
		</dl>
		<dl class="nowrap">
			<dt><hi:text key="备注" entity="TblStlSettleBatch"/>：</dt><dd>${tblStlSettleBatch.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleBatch"/>：</dt><dd><fmt:formatDate value="${tblStlSettleBatch.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlSettleBatch"/>：</dt><dd><fmt:formatDate value="${tblStlSettleBatch.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
