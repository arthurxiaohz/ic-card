<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblTxPayMentOrderList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblTxPayMentOrderList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="平台交易流水号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易类型" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_txTypeId" value="${pageInfo.f_txTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易发生时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTime" value="${pageInfo.f_mchtTxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="原始交易发生时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastMchtTxTime" value="${pageInfo.f_lastMchtTxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTraceNo" value="${pageInfo.f_mchtTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="原始商户交易流水号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastMchtTxTraceNo" value="${pageInfo.f_lastMchtTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易金额" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_orderAmount" value="${pageInfo.f_orderAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易结果通知地址" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_notifyUrl" value="${pageInfo.f_notifyUrl}"/>
			</li>	  
			<li>
				<label><hi:text key="交易IP地址" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_txIp" value="${pageInfo.f_txIp}"/>
			</li>	  
			<li>
				<label><hi:text key="交易状态" entity="TblTxPayMentOrder"/>:</label>
				<hi:search name="pageInfo.f_txStatus" emu="txStatus"/>
			</li>	  
			<li>
				<label><hi:text key="凭证号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_voucherNo" value="${pageInfo.f_voucherNo}"/>
			</li>	  
			<li>
				<label><hi:text key="撤销凭证号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_backVoucherNo" value="${pageInfo.f_backVoucherNo}"/>
			</li>	  
			<li>
				<label><hi:text key="是否使用优惠券" entity="TblTxPayMentOrder"/>:</label>
				<hi:search name="pageInfo.f_useCoupon" emu="useCoupon"/>
			</li>	  
			<li>
				<label><hi:text key="验证码" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_verifyCode" value="${pageInfo.f_verifyCode}"/>
			</li>	  
			<li>
				<label><hi:text key="确认码" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_confirmCode" value="${pageInfo.f_confirmCode}"/>
			</li>	  
			<li>
				<label><hi:text key="确认过期时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_orderExpireDatetime" value="${pageInfo.f_orderExpireDatetime}"/>
			</li>	  
			<li>
				<label><hi:text key="异常代码" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_errorCode" value="${pageInfo.f_errorCode}"/>
			</li>	  
			<li>
				<label><hi:text key="异常描述" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_errorMsg" value="${pageInfo.f_errorMsg}"/>
			</li>	  
			<li>
				<label><hi:text key="结算批次号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_settleBatchNo" value="${pageInfo.f_settleBatchNo}"/>
			</li>	  
			<li>
				<label><hi:text key="结算状态" entity="TblTxPayMentOrder"/>:</label>
				<hi:search name="pageInfo.f_settleStatus" emu="settleStatus"/>
			</li>	  
			<li>
				<label><hi:text key="结算日期" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_settleDate" value="${pageInfo.f_settleDate}"/>
			</li>	  
			<li>
				<label><hi:text key="手续费金额" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_feeAmount" value="${pageInfo.f_feeAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="是否已计算手续费" entity="TblTxPayMentOrder"/>:</label>
				<hi:search name="pageInfo.f_hasCountFee" emu="hasCountFee"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>

			</li>	  
		</ul>
		<div class="subBar">
			<div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="查询"/></button></div></div>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<c:choose>
			<c:when test="${empty lookup}">
				<authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE"><li><a class="add" href="<hi:url>tblTxPayMentOrderEdit.action?tblTxPayMentOrder.id=-1</hi:url>" target="navTab" rel="tblTxPayMentOrder"><span><hi:text key="新建" parameterLanguageKeys="订单查询"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_DEL"><li><a class="delete" href="<hi:url>tblTxPayMentOrderRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', plTxTraceNo:'',userName:'',txTypeId:'',mchtNo:'',mchtTxTime:'',lastMchtTxTime:'',mchtTxTraceNo:'',lastMchtTxTraceNo:'',orderAmount:'',notifyUrl:'',txIp:'',plTxTime:'',txStatus:'',voucherNo:'',backVoucherNo:'',useCoupon:'',couponMsg:'',resCouponMsg:'',showUrl:'',txBody:'',payerPhone:'',verifyCode:'',confirmCode:'',orderExpireDatetime:'',errorCode:'',errorMsg:'',settleBatchNo:'',settleStatus:'',settleDate:'',feeAmount:'',hasCountFee:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="28"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				
				
				<!-- th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblTxPayMentOrder"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="userName" class="${pageInfo.sorterName eq 'userName' ? pageInfo.sorterDirection : ''}"><hi:text key="平台会员号" entity="TblTxPayMentOrder"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblTxPayMentOrder"/></th>
				<th orderField="lastMchtTxTime" class="${pageInfo.sorterName eq 'lastMchtTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="原始交易发生时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtTxTraceNo" class="${pageInfo.sorterName eq 'mchtTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/></th>
				<th orderField="lastMchtTxTraceNo" class="${pageInfo.sorterName eq 'lastMchtTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="原始商户交易流水号" entity="TblTxPayMentOrder"/></th>
				<th orderField="notifyUrl" class="${pageInfo.sorterName eq 'notifyUrl' ? pageInfo.sorterDirection : ''}"><hi:text key="交易结果通知地址" entity="TblTxPayMentOrder"/></th>
				<th orderField="txIp" class="${pageInfo.sorterName eq 'txIp' ? pageInfo.sorterDirection : ''}"><hi:text key="交易IP地址" entity="TblTxPayMentOrder"/></th>
				<th orderField="plTxTime" class="${pageInfo.sorterName eq 'plTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易完成时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="voucherNo" class="${pageInfo.sorterName eq 'voucherNo' ? pageInfo.sorterDirection : ''}"><hi:text key="凭证号" entity="TblTxPayMentOrder"/></th>
				<th orderField="backVoucherNo" class="${pageInfo.sorterName eq 'backVoucherNo' ? pageInfo.sorterDirection : ''}"><hi:text key="撤销凭证号" entity="TblTxPayMentOrder"/></th>
				<th orderField="useCoupon" class="${pageInfo.sorterName eq 'useCoupon' ? pageInfo.sorterDirection : ''}"><hi:text key="是否使用优惠券" entity="TblTxPayMentOrder"/></th>
				<th orderField="couponMsg" class="${pageInfo.sorterName eq 'couponMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券信息" entity="TblTxPayMentOrder"/></th>
				<th orderField="resCouponMsg" class="${pageInfo.sorterName eq 'resCouponMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="返回商户优惠券信息" entity="TblTxPayMentOrder"/></th>
				<th orderField="payerPhone" class="${pageInfo.sorterName eq 'payerPhone' ? pageInfo.sorterDirection : ''}"><hi:text key="付款人手机号码" entity="TblTxPayMentOrder"/></th>
				<th orderField="verifyCode" class="${pageInfo.sorterName eq 'verifyCode' ? pageInfo.sorterDirection : ''}"><hi:text key="验证码" entity="TblTxPayMentOrder"/></th>
				<th orderField="confirmCode" class="${pageInfo.sorterName eq 'confirmCode' ? pageInfo.sorterDirection : ''}"><hi:text key="确认码" entity="TblTxPayMentOrder"/></th>
				<th orderField="orderExpireDatetime" class="${pageInfo.sorterName eq 'orderExpireDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="确认过期时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="errorCode" class="${pageInfo.sorterName eq 'errorCode' ? pageInfo.sorterDirection : ''}"><hi:text key="异常代码" entity="TblTxPayMentOrder"/></th>
				<th orderField="errorMsg" class="${pageInfo.sorterName eq 'errorMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="异常描述" entity="TblTxPayMentOrder"/></th>
				<th orderField="settleBatchNo" class="${pageInfo.sorterName eq 'settleBatchNo' ? pageInfo.sorterDirection : ''}"><hi:text key="结算批次号" entity="TblTxPayMentOrder"/></th>
				<th orderField="settleStatus" class="${pageInfo.sorterName eq 'settleStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="结算状态" entity="TblTxPayMentOrder"/></th>
				<th orderField="settleDate" class="${pageInfo.sorterName eq 'settleDate' ? pageInfo.sorterDirection : ''}"><hi:text key="结算日期" entity="TblTxPayMentOrder"/></th>
				<th orderField="feeAmount" class="${pageInfo.sorterName eq 'feeAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="手续费金额" entity="TblTxPayMentOrder"/></th>
				<th orderField="hasCountFee" class="${pageInfo.sorterName eq 'hasCountFee' ? pageInfo.sorterDirection : ''}"><hi:text key="是否已计算手续费" entity="TblTxPayMentOrder"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblTxPayMentOrder"/></th>
				
				 -->
				<th orderField="mchtTxTime" class="${pageInfo.sorterName eq 'mchtTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易发生时间" entity="TblTxPayMentOrder"/></th>
								<th orderField="orderAmount" class="${pageInfo.sorterName eq 'orderAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="交易金额" entity="TblTxPayMentOrder"/></th>
								<th orderField="txStatus" class="${pageInfo.sorterName eq 'txStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="交易状态" entity="TblTxPayMentOrder"/></th>
								<th orderField="showUrl" class="${pageInfo.sorterName eq 'showUrl' ? pageInfo.sorterDirection : ''}"><hi:text key="商品展示URL" entity="TblTxPayMentOrder"/></th>
				<th orderField="txBody" class="${pageInfo.sorterName eq 'txBody' ? pageInfo.sorterDirection : ''}"><hi:text key="商品描述" entity="TblTxPayMentOrder"/></th>
								
								<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblTxPayMentOrders}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <!--  td>${item.plTxTraceNo}</td>
				    <td>${item.userName}</td>
				     <td>${item.mchtTxTime}</td>
				    <td>${item.txTypeId}</td>
				       <td>${item.mchtNo}</td>
				        <td>${item.lastMchtTxTime}</td>
				         <td>${item.mchtTxTraceNo}</td>
				    <td>${item.lastMchtTxTraceNo}</td>
				     <td>${item.notifyUrl}</td>
				    <td>${item.txIp}</td>
				    <td>${item.plTxTime}</td>
				    <td>${item.voucherNo}</td>
				    <td>${item.backVoucherNo}</td>
				    <td><hi:select emu="useCoupon" name="tblTxPayMentOrders[${s.index}].useCoupon" isLabel="true"/></td>
				    <td>${item.couponMsg}</td>
				    <td>${item.resCouponMsg}</td>
				      <td>${item.payerPhone}</td>
				    <td>${item.verifyCode}</td>
				    <td>${item.confirmCode}</td>
				    <td>${item.orderExpireDatetime}</td>
				    <td>${item.errorCode}</td>
				    <td>${item.errorMsg}</td>
				    <td>${item.settleBatchNo}</td>
				    <td><hi:select emu="settleStatus" name="tblTxPayMentOrders[${s.index}].settleStatus" isLabel="true"/></td>
				    <td>${item.settleDate}</td>
				    <td>${item.feeAmount}</td>
				    <td><hi:select emu="hasCountFee" name="tblTxPayMentOrders[${s.index}].hasCountFee" isLabel="true"/></td>
					<td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    -->
				 
				   
				   
				   <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd"/></td>
				    <td>${item.orderAmount/100}</td>
				   
				    <td><hi:select emu="orderTxStatus" name="tblTxPayMentOrders[${s.index}].txStatus" isLabel="true"/></td>
				    
				    <td>  <a href=${item.showUrl} target="_blank" seed="i-record-item-detail">${item.txBody}</a></td>
				    <td>${item.txBody}</td>
				  
				<td>
				<c:choose>
					<c:when test="${item.txStatus==200800}">
					<!-- 
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_DEL">
				      <a class="btnDel" href="<hi:url>tblTxPayMentOrderRemove.action?ajax=1&tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="订单查询"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				      <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_VIEW">
				      <a class="btnView" href="<hi:url>tblTxPayMentOrderView.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="查看" parameterLanguageKeys="订单查询"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				     -->
				  
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE">
				      <a  href="<hi:url>tblTxPayMentOrderEdit.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="支付" parameterLanguageKeys="订单"/>">支付</a>
				    </authz:authorize>
				    </c:when>
				    <c:when test="${item.txStatus==200801}">
				      <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE">
				      <a  href="<hi:url>payMentOrderFinish.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="支付" parameterLanguageKeys="订单"/>">确认付款</a>
				    </authz:authorize>
				    </c:when>
				     <c:when test="${item.txStatus==200805}">
				      <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE">
				      <a  href="<hi:url>revocationTxPayMentOrderFinish.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="支付" parameterLanguageKeys="订单"/>">待撤销</a>
				    </authz:authorize>
				    </c:when>
				     <c:when test="${item.txStatus==200806}">
				      <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE">
				      <a  href="<hi:url>backTxPayMentOrderFinish.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="支付" parameterLanguageKeys="订单"/>">待退款</a>
				    </authz:authorize>
				    
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
	<div class="panelBar">
		<div class="pages">
			<span><hi:text key="每页"/></span>
			<c:set var="pageSizeList" value="${fn:split('10|20|50|100', '|')}"/>  
			<select name="pageInfo.pageSize" onchange="dwzPageBreak({targetType:'${targetType}', numPerPage:this.value})">
				<c:forEach var="item" items="${pageSizeList}">
				<option value="${item}" ${item eq pageInfo.pageSize ? 'selected="selected"' : ''}>${item}</option>
				</c:forEach>
			</select>
			<span><hi:text key="条"/>，<hi:text key="共"/>${pageInfo.totalRecords}<hi:text key="条"/></span>
		</div>
		<div class="pagination" targetType="${targetType}" totalCount="${pageInfo.totalRecords}" numPerPage="${pageInfo.pageSize}" pageNumShown="${pageInfo.middlePageNum*2}" currentPage="${pageInfo.currentPage}"></div>
	</div>
</div>
