<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="结算申请"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt><hi:text key="账户可用余额" entity="TblStlSettleApply"/>：</dt><dd>${tblStlSettleApply.availableBalance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="申请结算金额" entity="TblStlSettleApply"/>：</dt><dd>${tblStlSettleApply.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="状态" entity="TblStlSettleApply"/>：</dt><dd><hi:select emu="settleApplyStatus" name="tblStlSettleApply.settleApplyStatus" isLabel="true"/></dd>
		</dl>
		<dl class="nowrap">
			<dt><hi:text key="审核意见" entity="TblStlSettleApply"/>：</dt><dd>${tblStlSettleApply.auditOpinion}</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注" entity="TblStlSettleApply"/>：</dt><dd>${tblStlSettleApply.remark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日" entity="TblStlSettleApply"/>：</dt><dd>${tblStlSettleApply.tblStlSettleBatch.settleDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlSettleApply"/>：</dt><dd><fmt:formatDate value="${tblStlSettleApply.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
