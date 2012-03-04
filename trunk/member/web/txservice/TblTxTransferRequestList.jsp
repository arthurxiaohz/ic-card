<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblTxTransferRequestList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblTxTransferRequestList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="商户交易流水号" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTraceNo" value="${pageInfo.f_mchtTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易金额" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_amount" value="${pageInfo.f_amount}"/>
			</li>	  
			<li>
				<label><hi:text key="卡余额" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_cardBalance" value="${pageInfo.f_cardBalance}"/>
			</li>	  
			<li>
				<label><hi:text key="卡序号" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_cardSequence" value="${pageInfo.f_cardSequence}"/>
			</li>	  
			<li>
				<label><hi:text key="卡号" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_cardNo" value="${pageInfo.f_cardNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易时间" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTime" value="${pageInfo.f_mchtTxTime}"/>
			</li>	  
			<li>
				<label><hi:text key="交易状态" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_txStatus" value="${pageInfo.f_txStatus}"/>
			</li>	  
			<li>
				<label><hi:text key="交易类型" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_txTypeId" value="${pageInfo.f_txTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="附加信息" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_msgext" value="${pageInfo.f_msgext}"/>
			</li>	  
			<li>
				<label><hi:text key="原始报文" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_mchtRawMessage" value="${pageInfo.f_mchtRawMessage}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblTxTransferRequest"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
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
				<authz:authorize ifAnyGranted="TBLTXTRANSFERREQUEST_SAVE"><li><a class="add" href="<hi:url>tblTxTransferRequestEdit.action?tblTxTransferRequest.id=-1</hi:url>" target="navTab" rel="tblTxTransferRequest"><span><hi:text key="新建" parameterLanguageKeys="转账请求原始报文"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXTRANSFERREQUEST_DEL"><li><a class="delete" href="<hi:url>tblTxTransferRequestRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', mchtTxTraceNo:'',mchtNo:'',amount:'',cardBalance:'',cardSequence:'',cardNo:'',mchtTxTime:'',txStatus:'',txTypeId:'',msgext:'',mchtRawMessage:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="mchtTxTraceNo" class="${pageInfo.sorterName eq 'mchtTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户交易流水号" entity="TblTxTransferRequest"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblTxTransferRequest"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="交易金额" entity="TblTxTransferRequest"/></th>
				<th orderField="cardBalance" class="${pageInfo.sorterName eq 'cardBalance' ? pageInfo.sorterDirection : ''}"><hi:text key="卡余额" entity="TblTxTransferRequest"/></th>
				<th orderField="cardSequence" class="${pageInfo.sorterName eq 'cardSequence' ? pageInfo.sorterDirection : ''}"><hi:text key="卡序号" entity="TblTxTransferRequest"/></th>
				<th orderField="cardNo" class="${pageInfo.sorterName eq 'cardNo' ? pageInfo.sorterDirection : ''}"><hi:text key="卡号" entity="TblTxTransferRequest"/></th>
				<th orderField="mchtTxTime" class="${pageInfo.sorterName eq 'mchtTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易时间" entity="TblTxTransferRequest"/></th>
				<th orderField="txStatus" class="${pageInfo.sorterName eq 'txStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="交易状态" entity="TblTxTransferRequest"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblTxTransferRequest"/></th>
				<th orderField="msgext" class="${pageInfo.sorterName eq 'msgext' ? pageInfo.sorterDirection : ''}"><hi:text key="附加信息" entity="TblTxTransferRequest"/></th>
				<th orderField="mchtRawMessage" class="${pageInfo.sorterName eq 'mchtRawMessage' ? pageInfo.sorterDirection : ''}"><hi:text key="原始报文" entity="TblTxTransferRequest"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxTransferRequest"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblTxTransferRequest"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblTxTransferRequest"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblTxTransferRequests}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.mchtTxTraceNo}</td>
				    <td>${item.mchtNo}</td>
				    <td>${item.amount}</td>
				    <td>${item.cardBalance}</td>
				    <td>${item.cardSequence}</td>
				    <td>${item.cardNo}</td>
				    <td>${item.mchtTxTime}</td>
				    <td>${item.txStatus}</td>
				    <td>${item.txTypeId}</td>
				    <td>${item.msgext}</td>
				    <td>${item.mchtRawMessage}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERREQUEST_DEL">
				      <a class="btnDel" href="<hi:url>tblTxTransferRequestRemove.action?ajax=1&tblTxTransferRequest.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="转账请求原始报文"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERREQUEST_VIEW">
				      <a class="btnView" href="<hi:url>tblTxTransferRequestView.action?tblTxTransferRequest.id=${item.id}</hi:url>" target="navTab" rel="tblTxTransferRequest" title="<hi:text key="查看" parameterLanguageKeys="转账请求原始报文"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXTRANSFERREQUEST_SAVE">
				      <a class="btnEdit" href="<hi:url>tblTxTransferRequestEdit.action?tblTxTransferRequest.id=${item.id}</hi:url>" target="navTab" rel="tblTxTransferRequest" title="<hi:text key="编辑" parameterLanguageKeys="转账请求原始报文"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', mchtTxTraceNo:'${item.mchtTxTraceNo}',mchtNo:'${item.mchtNo}',amount:'${item.amount}',cardBalance:'${item.cardBalance}',cardSequence:'${item.cardSequence}',cardNo:'${item.cardNo}',mchtTxTime:'${item.mchtTxTime}',txStatus:'${item.txStatus}',txTypeId:'${item.txTypeId}',msgext:'${item.msgext}',mchtRawMessage:'${item.mchtRawMessage}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
