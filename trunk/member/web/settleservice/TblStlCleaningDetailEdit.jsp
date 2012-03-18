<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="编辑页面" parameterLanguageKeys="清分流水表"/></h2>
<form action="tblStlCleaningDetailSave.action?navTabId=tblStlCleaningDetailList&callbackType=closeCurrent&ajax=1" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.plTxTraceNo" class="textInput required" value="${tblStlCleaningDetail.plTxTraceNo}" maxlength="20"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.mchtOrderId" class="textInput" value="${tblStlCleaningDetail.mchtOrderId}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCleaningDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlCleaningDetail.createdDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCleaningDetail.createdDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCleaningDetail"/>：</dt>
			<dd>
				<input type="text" name="tblStlCleaningDetail.lastUpdatedDatetime" class="textInput date required" readonly="readonly" pattern="yyyy-MM-dd HH:mm:ss"
					value="<fmt:formatDate value='${tblStlCleaningDetail.lastUpdatedDatetime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
				<a href="javascript:void(0)" class="inputDateButton"><hi:text key="选择"/></a>
			</dd>
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.lastUpdatedBy" class="textInput required integer" value="${tblStlCleaningDetail.lastUpdatedBy}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="订单金额" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.orderAmount" class="textInput integer" value="${tblStlCleaningDetail.orderAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.transTime" class="textInput" value="${tblStlCleaningDetail.transTime}" maxlength="14"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款原始订单" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.refundOrderId" class="textInput" value="${tblStlCleaningDetail.refundOrderId}" maxlength="50"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款订单原始交易金额" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.refundOrderAmt" class="textInput integer" value="${tblStlCleaningDetail.refundOrderAmt}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退款金额" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.refundAmt" class="textInput integer" value="${tblStlCleaningDetail.refundAmt}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退还的手续费用" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.refundFee" class="textInput integer" value="${tblStlCleaningDetail.refundFee}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户结算扣费金额" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.mchtSettleAmount" class="textInput integer" value="${tblStlCleaningDetail.mchtSettleAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="备注信息" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.reMark" class="textInput" value="${tblStlCleaningDetail.reMark}" maxlength="100"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.transType" class="textInput" value="${tblStlCleaningDetail.transType}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.userName" class="textInput" value="${tblStlCleaningDetail.userName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="积分" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.balance" class="textInput integer" value="${tblStlCleaningDetail.balance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="退还积分" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.backBalance" class="textInput integer" value="${tblStlCleaningDetail.backBalance}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.mchtNo" class="textInput" value="${tblStlCleaningDetail.mchtNo}" maxlength="18"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.mchtName" class="textInput" value="${tblStlCleaningDetail.mchtName}" maxlength="30"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="清分状态" entity="TblStlCleaningDetail"/>：</dt><dd><hi:select emu="cleanStatus" name="tblStlCleaningDetail.cleanStatus"/></dd>			
		</dl>
		<dl>
			<dt><hi:text key="支付金额" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.payAmount" class="textInput integer" value="${tblStlCleaningDetail.payAmount}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
		<dl>
			<dt><hi:text key="商户手续费" entity="TblStlCleaningDetail"/>：</dt><dd><input type="text" name="tblStlCleaningDetail.fee" class="textInput integer" value="${tblStlCleaningDetail.fee}" alt="<hi:text key="请输入整数"/>"/></dd>
		</dl>
				<input type="hidden" name="tblStlCleaningDetail.id" value="${tblStlCleaningDetail.id}"/>
				<input type="hidden" name="tblStlCleaningDetail.creator.id" value="${tblStlCleaningDetail.creator.id}"/>
				<input type="hidden" name="tblStlCleaningDetail.deleted" value="${tblStlCleaningDetail.deleted}"/>
				<input type="hidden" name="tblStlCleaningDetail.version" value="${tblStlCleaningDetail.version}"/>

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
