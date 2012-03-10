<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="会员优惠券"/></h2>
<form action="tblMbCouponSave.action?navTabId=tblMbCouponList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="优惠券类型" entity="TblMbCoupon"/>：</dt><dd><input type="text" name="tblMbCoupon.couponType" class="textInput" value="${tblMbCoupon.couponType}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券金额" entity="TblMbCoupon"/>：</dt><dd><input type="text" name="tblMbCoupon.amount" class="textInput integer" value="${tblMbCoupon.amount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券可用余额" entity="TblMbCoupon"/>：</dt><dd><input type="text" name="tblMbCoupon.balance" class="textInput integer" value="${tblMbCoupon.balance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券状态" entity="TblMbCoupon"/>：</dt><dd><hi:select emu="couponStatus" name="tblMbCoupon.couponStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="有效期开始时间" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="text" name="tblMbCoupon.startDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCoupon.startDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="有效期结束时间" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="text" name="tblMbCoupon.endDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCoupon.endDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="text" name="tblMbCoupon.createdDateTime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCoupon.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="text" name="tblMbCoupon.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblMbCoupon.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="帐号" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="hidden" name="tblMbCoupon.tblMbInfo.id" value="${tblMbCoupon.tblMbInfo.id}"/>
				<input type="text" class="textInput" name="tblMbCoupon.hi_tblMbInfo.userName" value="${tblMbCoupon.tblMbInfo.userName}"
					autocomplete="off" lookupGroup="tblMbCoupon" lookupName="tblMbInfo" suggestClass="org.hi.base.organization.model.HiUser" searchFields="userName,fullName"/>
				<a class="btnLook" href="<hi:url>hiUserLookup.action?lookup=1</hi:url>" lookupGroup="tblMbCoupon" lookupName="tblMbInfo"><hi:text key="查找带回"/></a>		
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="姓名" entity="TblMbCoupon"/>：</dt>
			<dd>
				<input type="text" class="textInput" name="tblMbCoupon.hi_tblMbInfo.fullName" value="${tblMbCoupon.tblMbInfo.fullName}" readonly="readonly"/>
			</dd>
		</dl>
				<input type="hidden" name="tblMbCoupon.id" value="${tblMbCoupon.id}"/>
				<input type="hidden" name="tblMbCoupon.lastUpdatedBy.id" value="${tblMbCoupon.lastUpdatedBy.id}"/>
				<input type="hidden" name="tblMbCoupon.creator.id" value="${tblMbCoupon.creator.id}"/>
				<input type="hidden" name="tblMbCoupon.version" value="${tblMbCoupon.version}"/>

		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:void(0)"><span><hi:text key="会员优惠券明细"/></span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height:150px;">
				<div>
					<table class="list nowrap" width="100%" itemDetail="tblMbCoupon.tblMbCouponDetails">
						<thead>
							<tr>
								<th type="text" class="" name="amount" size="12" maxlength="30"><hi:text key="优惠券使用金额" entity="TblMbCouponDetail"/></th>
								<th type="text" class="" name="plTxTraceNo" size="12" maxlength="30"><hi:text key="平台交易流水号" entity="TblMbCouponDetail"/></th>
								<th type="text" class="" name="balance" size="12" maxlength="30"><hi:text key="优惠券可用余额" entity="TblMbCouponDetail"/></th>
								<th type="datetime" class=" date" name="createdDateTime" size="12"><hi:text key="创建时间" entity="TblMbCouponDetail"/></th>
								<th type="datetime" class=" date" name="lastUpdatedDatetime" size="12"><hi:text key="最后修改时间" entity="TblMbCouponDetail"/></th>
								<th type="del" width="60"><hi:text key="操作"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${tblMbCoupon.tblMbCouponDetails}"  varStatus="s">
							<tr>
							<input type="hidden" name="tblMbCoupon.tblMbCouponDetails[${s.index}].id" value="${item.id}"/>
							<input type="hidden" name="tblMbCoupon.tblMbCouponDetails[${s.index}].version" value="${item.version}"/>
								<td>
									<input type="text" class="" name="tblMbCoupon.tblMbCouponDetails[${s.index}].amount" value="${item.amount}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="" name="tblMbCoupon.tblMbCouponDetails[${s.index}].plTxTraceNo" value="${item.plTxTraceNo}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="" name="tblMbCoupon.tblMbCouponDetails[${s.index}].balance" value="${item.balance}" size="12" maxlength="30"/>
								</td>
								<td>
									<input type="text" class="date" name="tblMbCoupon.tblMbCouponDetails[${s.index}].createdDateTime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.createdDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td>
									<input type="text" class="date" name="tblMbCoupon.tblMbCouponDetails[${s.index}].lastUpdatedDatetime" class="date" pattern='yyyy-MM-dd HH:mm:ss'
										value="<fmt:formatDate value='${item.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>" size="12"  readonly="readonly"/>
									<a class="inputDateButton" href="javascript:void(0)"><hi:text key="选择"/></a>
								</td>
								<td><a href="<hi:url>tblMbCouponDetailRemove.action?ajax=1&tblMbCouponDetail.id=${item.id}</hi:url>" class="btnDel" title="<hi:text key="确定要删除吗?"/>">删除</a></td>
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
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="保存"/></button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>  
</div>
</form>
