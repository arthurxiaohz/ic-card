<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员优惠券明细"/></h2>
<form action="tblMbCouponDetailSave.action?navTabId=tblMbCouponDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="优惠券使用金额" entity="TblMbCouponDetail"/>：</dt><dd><input type="text" name="tblMbCouponDetail.amount" class="textInput" value="${tblMbCouponDetail.amount}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblMbCouponDetail"/>：</dt><dd><input type="text" name="tblMbCouponDetail.plTxTraceNo" class="textInput" value="${tblMbCouponDetail.plTxTraceNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券可用余额" entity="TblMbCouponDetail"/>：</dt><dd><input type="text" name="tblMbCouponDetail.balance" class="textInput" value="${tblMbCouponDetail.balance}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCouponDetail"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponDetail.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponDetail.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCouponDetail"/>：</dt>
			<dd>
				<input type="text" name="tblMbCouponDetail.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCouponDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
				<input type="hidden" name="tblMbCouponDetail.id" value="${tblMbCouponDetail.id}"/>
				<input type="hidden" name="tblMbCouponDetail.lastUpdatedBy.id" value="${tblMbCouponDetail.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbCouponDetail.tblMbCoupon.id" value="${tblMbCouponDetail.tblMbCoupon.id}"/>
				<input type="hidden" name="tblMbCouponDetail.creator.id" value="${tblMbCouponDetail.creator.id}"/>
				<input type="hidden" name="tblMbCouponDetail.version" value="${tblMbCouponDetail.version}"/>

		<div class="divider"></div>
			</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
