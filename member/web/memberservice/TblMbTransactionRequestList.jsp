<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbTransactionRequestList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbTransactionRequestList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="交易代码" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_trancode" value="${pageInfo.f_trancode}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易金额" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_amount" value="${pageInfo.f_amount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易时间" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_trxTime" value="${pageInfo.f_trxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="交易状态" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_txStatus" value="${pageInfo.f_txStatus}"/>
			</li>	  
			<li>
				<label><hi:text key="附加信息" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_msgext" value="${pageInfo.f_msgext}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>
				<label><hi:text key="持卡人卡号" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_pan" value="${pageInfo.f_pan}"/>
			</li>	  
			<li>
				<label><hi:text key="持卡人个人信息" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_chinfo" value="${pageInfo.f_chinfo}"/>
			</li>	  
			<li>
				<label><hi:text key="平台流水号" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="币种" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_currencyType" value="${pageInfo.f_currencyType}"/>
			</li>	  
			<li>
				<label><hi:text key="账户类型" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_accountType" value="${pageInfo.f_accountType}"/>
			</li>	  
			<li>
				<label><hi:text key="账户号码" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_accountNo" value="${pageInfo.f_accountNo}"/>
			</li>	  
			<li>
				<label><hi:text key=" 网关订单号" entity="TblMbTransactionRequest"/>:</label>
				<input type="text" name="pageInfo.f_orderId" value="${pageInfo.f_orderId}"/>
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
				<authz:authorize ifAnyGranted="TBLMBTRANSACTIONREQUEST_SAVE"><li><a class="add" href="<hi:url>tblMbTransactionRequestEdit.action?tblMbTransactionRequest.id=-1</hi:url>" target="navTab" rel="tblMbTransactionRequest"><span><hi:text key="新建" parameterLanguageKeys="网关交易请求"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBTRANSACTIONREQUEST_DEL"><li><a class="delete" href="<hi:url>tblMbTransactionRequestRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', trancode:'',mchtNo:'',amount:'',trxTime:'',txStatus:'',msgext:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',pan:'',chinfo:'',plTxTraceNo:'',currencyType:'',accountType:'',accountNo:'',plTxTime:'',orderId:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="trancode" class="${pageInfo.sorterName eq 'trancode' ? pageInfo.sorterDirection : ''}"><hi:text key="交易代码" entity="TblMbTransactionRequest"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblMbTransactionRequest"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="交易金额" entity="TblMbTransactionRequest"/></th>
				<th orderField="trxTime" class="${pageInfo.sorterName eq 'trxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易时间" entity="TblMbTransactionRequest"/></th>
				<th orderField="txStatus" class="${pageInfo.sorterName eq 'txStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="交易状态" entity="TblMbTransactionRequest"/></th>
				<th orderField="msgext" class="${pageInfo.sorterName eq 'msgext' ? pageInfo.sorterDirection : ''}"><hi:text key="附加信息" entity="TblMbTransactionRequest"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbTransactionRequest"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbTransactionRequest"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblMbTransactionRequest"/></th>
				<th orderField="pan" class="${pageInfo.sorterName eq 'pan' ? pageInfo.sorterDirection : ''}"><hi:text key="持卡人卡号" entity="TblMbTransactionRequest"/></th>
				<th orderField="chinfo" class="${pageInfo.sorterName eq 'chinfo' ? pageInfo.sorterDirection : ''}"><hi:text key="持卡人个人信息" entity="TblMbTransactionRequest"/></th>
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台流水号" entity="TblMbTransactionRequest"/></th>
				<th orderField="currencyType" class="${pageInfo.sorterName eq 'currencyType' ? pageInfo.sorterDirection : ''}"><hi:text key="币种" entity="TblMbTransactionRequest"/></th>
				<th orderField="accountType" class="${pageInfo.sorterName eq 'accountType' ? pageInfo.sorterDirection : ''}"><hi:text key="账户类型" entity="TblMbTransactionRequest"/></th>
				<th orderField="accountNo" class="${pageInfo.sorterName eq 'accountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="账户号码" entity="TblMbTransactionRequest"/></th>
				<th orderField="plTxTime" class="${pageInfo.sorterName eq 'plTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易完成时间" entity="TblMbTransactionRequest"/></th>
				<th orderField="orderId" class="${pageInfo.sorterName eq 'orderId' ? pageInfo.sorterDirection : ''}"><hi:text key=" 网关订单号" entity="TblMbTransactionRequest"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbTransactionRequests}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.trancode}</td>
				    <td>${item.mchtNo}</td>
				    <td>${item.amount}</td>
				    <td>${item.trxTime}</td>
				    <td>${item.txStatus}</td>
				    <td>${item.msgext}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td>${item.pan}</td>
				    <td>${item.chinfo}</td>
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.currencyType}</td>
				    <td>${item.accountType}</td>
				    <td>${item.accountNo}</td>
				    <td>${item.plTxTime}</td>
				    <td>${item.orderId}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONREQUEST_DEL">
				      <a class="btnDel" href="<hi:url>tblMbTransactionRequestRemove.action?ajax=1&tblMbTransactionRequest.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="网关交易请求"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONREQUEST_VIEW">
				      <a class="btnView" href="<hi:url>tblMbTransactionRequestView.action?tblMbTransactionRequest.id=${item.id}</hi:url>" target="navTab" rel="tblMbTransactionRequest" title="<hi:text key="查看" parameterLanguageKeys="网关交易请求"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONREQUEST_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbTransactionRequestEdit.action?tblMbTransactionRequest.id=${item.id}</hi:url>" target="navTab" rel="tblMbTransactionRequest" title="<hi:text key="编辑" parameterLanguageKeys="网关交易请求"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', trancode:'${item.trancode}',mchtNo:'${item.mchtNo}',amount:'${item.amount}',trxTime:'${item.trxTime}',txStatus:'${item.txStatus}',msgext:'${item.msgext}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',pan:'${item.pan}',chinfo:'${item.chinfo}',plTxTraceNo:'${item.plTxTraceNo}',currencyType:'${item.currencyType}',accountType:'${item.accountType}',accountNo:'${item.accountNo}',plTxTime:'${item.plTxTime}',orderId:'${item.orderId}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
