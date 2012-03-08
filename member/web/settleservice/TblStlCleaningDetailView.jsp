<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<h2 class="contentTitle"><hi:text key="查看页面"  parameterLanguageKeys="清分流水表"/></h2>
<div class="pageContent">
	
	<div class="viewInfo" layoutH="97">
				
		<dl>
			<dt><hi:text key="平台交易流水号" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.plTxTraceNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户订单号" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.mchtOrderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="创建时间" entity="TblStlCleaningDetail"/>：</dt><dd><fmt:formatDate value="${tblStlCleaningDetail.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改时间" entity="TblStlCleaningDetail"/>：</dt><dd><fmt:formatDate value="${tblStlCleaningDetail.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>				  	 
		</dl>
		<dl>
			<dt><hi:text key="最后修改人" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.lastUpdatedBy}</dd>
		</dl>
		<dl>
			<dt><hi:text key="金额" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.orderAmount}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易时间" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.transTime}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款原始订单" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.refundOrderId}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款订单原始交易金额" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.refundOrderAmt}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退款金额" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.refundAmt}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退还的手续费用" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.refundFee}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户结算扣费金额" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.mchtSettleFee}</dd>
		</dl>
		<dl>
			<dt><hi:text key="备注信息" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.reMark}</dd>
		</dl>
		<dl>
			<dt><hi:text key="交易类型" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.transType}</dd>
		</dl>
		<dl>
			<dt><hi:text key="账号" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.userName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="积分" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.balance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="退还积分" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.backBalance}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户号" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.mchtNo}</dd>
		</dl>
		<dl>
			<dt><hi:text key="商户名称" entity="TblStlCleaningDetail"/>：</dt><dd>${tblStlCleaningDetail.mchtName}</dd>
		</dl>
		<dl>
			<dt><hi:text key="清分状态" entity="TblStlCleaningDetail"/>：</dt><dd><hi:select emu="cleanStatus" name="tblStlCleaningDetail.cleanStatus" isLabel="true"/></dd>
		</dl>

		<div class="divider"></div>
			</div>

	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button"><hi:text key="关闭"/></button></div></div></li>
		</ul>
	</div>
</div>
