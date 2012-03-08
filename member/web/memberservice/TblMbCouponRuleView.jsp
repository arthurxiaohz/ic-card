<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="会员优惠券规则"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="帐号" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.tblMbInfo.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.tblMbInfo.fullName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.tblMchtInfo.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.tblMchtInfo.mchtName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户类别" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="mchtType" name="tblMbCouponRule.mchtType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商品类别" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="merchandiseCategory" name="tblMbCouponRule.merchandiseCategory" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商品编号" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.merchandiseNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券类型" entity="TblMbCouponRule"/>：</dt><dd><hi:select emu="couponType" name="tblMbCouponRule.couponType" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券金额" entity="TblMbCouponRule"/>：</dt><dd>${tblMbCouponRule.amount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbCouponRule"/>：</dt><dd><fmt:formatDate value="${tblMbCouponRule.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbCouponRule"/>：</dt><dd><fmt:formatDate value="${tblMbCouponRule.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCouponRule"/>：</dt><dd><fmt:formatDate value="${tblMbCouponRule.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCouponRule"/>：</dt><dd><fmt:formatDate value="${tblMbCouponRule.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
