<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="交易订单"/></h2>
<form action="tblTxPayMentOrderSave.action?navTabId=tblTxPayMentOrderList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.plTxTraceNo" class="textInput required" value="${tblTxPayMentOrder.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="会员账号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.userName" class="textInput" value="${tblTxPayMentOrder.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.txTypeId" class="textInput" value="${tblTxPayMentOrder.txTypeId}" maxlength="4"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.mchtNo" class="textInput" value="${tblTxPayMentOrder.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.mchtTxTime" class="textInput" value="${tblTxPayMentOrder.mchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始交易发生时间" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.lastMchtTxTime" class="textInput" value="${tblTxPayMentOrder.lastMchtTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.mchtTxTraceNo" class="textInput" value="${tblTxPayMentOrder.mchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="原始商户交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.lastMchtTxTraceNo" class="textInput" value="${tblTxPayMentOrder.lastMchtTxTraceNo}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="订单金额" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.orderAmount" class="textInput integer" value="${tblTxPayMentOrder.orderAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易结果通知地址" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.notifyUrl" class="textInput" value="${tblTxPayMentOrder.notifyUrl}" maxlength="256"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.txIp" class="textInput" value="${tblTxPayMentOrder.txIp}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.plTxTime" class="textInput" value="${tblTxPayMentOrder.plTxTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="orderTxStatus" name="tblTxPayMentOrder.txStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.voucherNo" class="textInput" value="${tblTxPayMentOrder.voucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="撤销凭证号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.backVoucherNo" class="textInput" value="${tblTxPayMentOrder.backVoucherNo}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="是否使用优惠券" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="useCoupon" name="tblTxPayMentOrder.useCoupon"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="优惠券信息" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.couponMsg" class="textInput" value="${tblTxPayMentOrder.couponMsg}" maxlength="300"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="返回商户优惠券信息" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.resCouponMsg" class="textInput" value="${tblTxPayMentOrder.resCouponMsg}" maxlength="300"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商品展示URL" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.showUrl" class="textInput" value="${tblTxPayMentOrder.showUrl}" maxlength="400"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商品描述" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.txBody" class="textInput" value="${tblTxPayMentOrder.txBody}" maxlength="400"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="付款人手机号码" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.payerPhone" class="textInput" value="${tblTxPayMentOrder.payerPhone}" maxlength="11"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="验证码" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.verifyCode" class="textInput" value="${tblTxPayMentOrder.verifyCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="确认码" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.confirmCode" class="textInput" value="${tblTxPayMentOrder.confirmCode}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="确认过期时间" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.orderExpireDatetime" class="textInput" value="${tblTxPayMentOrder.orderExpireDatetime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.errorCode" class="textInput" value="${tblTxPayMentOrder.errorCode}" maxlength="10"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="异常描述" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.errorMsg" class="textInput" value="${tblTxPayMentOrder.errorMsg}" maxlength="1,000"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.settleBatchNo" class="textInput" value="${tblTxPayMentOrder.settleBatchNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="settleStatus" name="tblTxPayMentOrder.settleStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.settleDate" class="textInput" value="${tblTxPayMentOrder.settleDate}" maxlength="8"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="手续费金额" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.feeAmount" class="textInput integer" value="${tblTxPayMentOrder.feeAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="是否已计算手续费" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="hasCountFee" name="tblTxPayMentOrder.hasCountFee"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentOrder"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentOrder.createdDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentOrder.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentOrder"/>：</dt>
			<dd>
				<input type="text" name="tblTxPayMentOrder.lastUpdatedDatetime" class="textInput date" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblTxPayMentOrder.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.lastUpdatedBy" class="textInput integer" value="${tblTxPayMentOrder.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易后台通知地址" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.bgNotifyUrl" class="textInput" value="${tblTxPayMentOrder.bgNotifyUrl}" maxlength="256"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.mchtName" class="textInput" value="${tblTxPayMentOrder.mchtName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="支付金额" entity="TblTxPayMentOrder"/>：</dt><dd><input type="text" name="tblTxPayMentOrder.payAmount" class="textInput integer" value="${tblTxPayMentOrder.payAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblTxPayMentOrder.id" value="${tblTxPayMentOrder.id}"/>
				<input type="hidden" name="tblTxPayMentOrder.creator.id" value="${tblTxPayMentOrder.creator.id}"/>
				<input type="hidden" name="tblTxPayMentOrder.deleted" value="${tblTxPayMentOrder.deleted}"/>
				<input type="hidden" name="tblTxPayMentOrder.version" value="${tblTxPayMentOrder.version}"/>

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
