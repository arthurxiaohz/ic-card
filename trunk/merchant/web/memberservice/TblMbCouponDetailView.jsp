<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员优惠券明细"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="优惠券使用金额" entity="TblMbCouponDetail"/>：</dt><dd>${tblMbCouponDetail.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbCouponDetail"/>：</dt><dd>${tblMbCouponDetail.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券可用余额" entity="TblMbCouponDetail"/>：</dt><dd>${tblMbCouponDetail.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCouponDetail"/>：</dt><dd><fmt:formatDate value="${tblMbCouponDetail.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCouponDetail"/>：</dt><dd><fmt:formatDate value="${tblMbCouponDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
