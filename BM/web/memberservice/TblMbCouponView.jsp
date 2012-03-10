<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员优惠券"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="优惠券类型" entity="TblMbCoupon"/>：</dt><dd>${tblMbCoupon.couponType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券金额" entity="TblMbCoupon"/>：</dt><dd>${tblMbCoupon.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券可用余额" entity="TblMbCoupon"/>：</dt><dd>${tblMbCoupon.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券状态" entity="TblMbCoupon"/>：</dt><dd><hi:select emu="couponStatus" name="tblMbCoupon.couponStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbCoupon"/>：</dt><dd><fmt:formatDate value="${tblMbCoupon.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbCoupon"/>：</dt><dd><fmt:formatDate value="${tblMbCoupon.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCoupon"/>：</dt><dd><fmt:formatDate value="${tblMbCoupon.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCoupon"/>：</dt><dd><fmt:formatDate value="${tblMbCoupon.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbCoupon"/>：</dt><dd>${tblMbCoupon.tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbCoupon"/>：</dt><dd>${tblMbCoupon.tblMbInfo.fullName}</dd>
		</dl>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="会员优惠券明细"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:120px;">
				<div style="overflow: auto">
					<table class="list" width="100%">
						<thead>
							<tr>
								<th><hi:text key="优惠券使用金额" entity="TblMbCouponDetail"/></th>
								<th><hi:text key="平台交易流水号" entity="TblMbCouponDetail"/></th>
								<th><hi:text key="优惠券可用余额" entity="TblMbCouponDetail"/></th>
								<th><hi:text key="创建时间" entity="TblMbCouponDetail"/></th>
								<th><hi:text key="最后修改时间" entity="TblMbCouponDetail"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMbCoupon.tblMbCouponDetails}">
							<tr>						
								<td>${item.amount}</td>
								<td>${item.plTxTraceNo}</td>
								<td>${item.balance}</td>
								<td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>				
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
