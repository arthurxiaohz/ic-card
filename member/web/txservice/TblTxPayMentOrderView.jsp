<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="订单查询"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="平台会员号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.memberNO}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.txTypeId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易发生时间" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.mchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始交易发生时间" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.lastMchtTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.mchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="原始商户交易流水号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.lastMchtTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易金额" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.txAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易结果通知地址" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.notifyUrl}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易IP地址" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.txIp}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易完成时间" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.plTxTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易状态" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="txStatus" name="tblTxPayMentOrder.txStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="凭证号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.voucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="撤销凭证号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.backVoucherNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否使用优惠券" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="useCoupon" name="tblTxPayMentOrder.useCoupon" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="优惠券信息" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.couponMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="返回商户优惠券信息" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.resCouponMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商品展示URL" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.showUrl}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商品描述" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.txBody}</dd>
		</dl>
		<dl>
			<dt><hi:text key="付款人手机号码" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.payerPhone}</dd>
		</dl>
		<dl>
			<dt><hi:text key="验证码" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.verifyCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="确认码" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.confirmCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="确认过期时间" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.orderExpireDatetime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="异常代码" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.errorCode}</dd>
		</dl>
		<dl>
			<dt><hi:text key="异常描述" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.errorMsg}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算批次号" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.settleBatchNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="结算状态" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="settleStatus" name="tblTxPayMentOrder.settleStatus" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="结算日期" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.settleDate}</dd>
		</dl>
		<dl>
			<dt><hi:text key="手续费金额" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.feeAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="是否已计算手续费" entity="TblTxPayMentOrder"/>：</dt><dd><hi:select emu="hasCountFee" name="tblTxPayMentOrder.hasCountFee" isLabel="true"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblTxPayMentOrder"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentOrder.createdDatetime}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblTxPayMentOrder"/>：</dt><dd><fmt:formatDate value="${tblTxPayMentOrder.lastUpdatedDatetime}" pattern="yyyy-MM-dd"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.lastUpdatedBy}</dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
