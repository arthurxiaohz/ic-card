<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblTxPayMentResponseList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblTxPayMentResponseList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="返回接口的版本号" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_versionNo" value="${pageInfo.f_versionNo}"/>
			</li>	  
			<li>
				<label><hi:text key="支付结果" entity="TblTxPayMentResponse"/>:</label>
				<hi:search name="pageInfo.f_payResult" emu="txStatus"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户订单号" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_merchantOrderNo" value="${pageInfo.f_merchantOrderNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户订单金额" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_orderAmount" value="${pageInfo.f_orderAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易类型" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_txTypeId" value="${pageInfo.f_txTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="在系统中的订单实际支付金额" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_payAmount" value="${pageInfo.f_payAmount}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxPayMentResponse"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="TBLTXPAYMENTRESPONSE_SAVE"><li><a class="add" href="<hi:url>tblTxPayMentResponseEdit.action?tblTxPayMentResponse.id=-1</hi:url>" target="navTab" rel="tblTxPayMentResponse"><span><hi:text key="新建" parameterLanguageKeys="商户交易结果通知"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXPAYMENTRESPONSE_DEL"><li><a class="delete" href="<hi:url>tblTxPayMentResponseRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', versionNo:'',payResult:'',mchtNo:'',merchantOrderNo:'',orderAmount:'',txTypeId:'',payAmount:'',errorCode:'',createdDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="versionNo" class="${pageInfo.sorterName eq 'versionNo' ? pageInfo.sorterDirection : ''}"><hi:text key="返回接口的版本号" entity="TblTxPayMentResponse"/></th>
				<th orderField="payResult" class="${pageInfo.sorterName eq 'payResult' ? pageInfo.sorterDirection : ''}"><hi:text key="支付结果" entity="TblTxPayMentResponse"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblTxPayMentResponse"/></th>
				<th orderField="merchantOrderNo" class="${pageInfo.sorterName eq 'merchantOrderNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户订单号" entity="TblTxPayMentResponse"/></th>
				<th orderField="orderAmount" class="${pageInfo.sorterName eq 'orderAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="商户订单金额" entity="TblTxPayMentResponse"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblTxPayMentResponse"/></th>
				<th orderField="payAmount" class="${pageInfo.sorterName eq 'payAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="在系统中的订单实际支付金额" entity="TblTxPayMentResponse"/></th>
				<th orderField="errorCode" class="${pageInfo.sorterName eq 'errorCode' ? pageInfo.sorterDirection : ''}"><hi:text key="错误代码" entity="TblTxPayMentResponse"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxPayMentResponse"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblTxPayMentResponses}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.versionNo}</td>
				    <td><hi:select emu="txStatus" name="tblTxPayMentResponses[${s.index}].payResult" isLabel="true"/></td>
				    <td>${item.mchtNo}</td>
				    <td>${item.merchantOrderNo}</td>
				    <td>${item.orderAmount}</td>
				    <td>${item.txTypeId}</td>
				    <td>${item.payAmount}</td>
				    <td>${item.errorCode}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTRESPONSE_DEL">
				      <a class="btnDel" href="<hi:url>tblTxPayMentResponseRemove.action?ajax=1&tblTxPayMentResponse.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="商户交易结果通知"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTRESPONSE_VIEW">
				      <a class="btnView" href="<hi:url>tblTxPayMentResponseView.action?tblTxPayMentResponse.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentResponse" title="<hi:text key="查看" parameterLanguageKeys="商户交易结果通知"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTRESPONSE_SAVE">
				      <a class="btnEdit" href="<hi:url>tblTxPayMentResponseEdit.action?tblTxPayMentResponse.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentResponse" title="<hi:text key="编辑" parameterLanguageKeys="商户交易结果通知"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', versionNo:'${item.versionNo}',payResult:'<hi:select emu="txStatus" name="tblTxPayMentResponses[${s.index}].payResult" isLabel="true"/>',mchtNo:'${item.mchtNo}',merchantOrderNo:'${item.merchantOrderNo}',orderAmount:'${item.orderAmount}',txTypeId:'${item.txTypeId}',payAmount:'${item.payAmount}',errorCode:'${item.errorCode}',createdDatetime:'${item.createdDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
