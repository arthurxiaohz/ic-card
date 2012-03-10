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
				<label><hi:text key="会员账号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_userName" value="${pageInfo.f_userName}"/>
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
				<label><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtTxTraceNo" value="${pageInfo.f_mchtTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="交易状态" entity="TblTxPayMentOrder"/>:</label>
				<hi:search name="pageInfo.f_txStatus" emu="orderTxStatus"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="商户名称" entity="TblTxPayMentOrder"/>:</label>
				<input type="text" name="pageInfo.f_mchtName" value="${pageInfo.f_mchtName}"/>
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
				<authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE"><li><a class="add" href="<hi:url>tblTxPayMentOrderEdit.action?tblTxPayMentOrder.id=-1</hi:url>" target="navTab" rel="tblTxPayMentOrder"><span><hi:text key="新建" parameterLanguageKeys="交易订单"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_DEL"><li><a class="delete" href="<hi:url>tblTxPayMentOrderRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', plTxTraceNo:'',userName:'',txTypeId:'',mchtNo:'',mchtTxTime:'',mchtTxTraceNo:'',orderAmount:'',plTxTime:'',txStatus:'',txBody:'',orderExpireDatetime:'',errorCode:'',errorMsg:'',createdDatetime:'',lastUpdatedDatetime:'',mchtName:'',payAmount:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblTxPayMentOrder"/></th>
				<th orderField="userName" class="${pageInfo.sorterName eq 'userName' ? pageInfo.sorterDirection : ''}"><hi:text key="会员账号" entity="TblTxPayMentOrder"/></th>
				<th orderField="txTypeId" class="${pageInfo.sorterName eq 'txTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtTxTime" class="${pageInfo.sorterName eq 'mchtTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易发生时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtTxTraceNo" class="${pageInfo.sorterName eq 'mchtTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户交易流水号" entity="TblTxPayMentOrder"/></th>
				<th orderField="orderAmount" class="${pageInfo.sorterName eq 'orderAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="订单金额" entity="TblTxPayMentOrder"/></th>
				<th orderField="plTxTime" class="${pageInfo.sorterName eq 'plTxTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易完成时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="txStatus" class="${pageInfo.sorterName eq 'txStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="交易状态" entity="TblTxPayMentOrder"/></th>
				<th orderField="txBody" class="${pageInfo.sorterName eq 'txBody' ? pageInfo.sorterDirection : ''}"><hi:text key="商品描述" entity="TblTxPayMentOrder"/></th>
				<th orderField="orderExpireDatetime" class="${pageInfo.sorterName eq 'orderExpireDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="确认过期时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="errorCode" class="${pageInfo.sorterName eq 'errorCode' ? pageInfo.sorterDirection : ''}"><hi:text key="异常代码" entity="TblTxPayMentOrder"/></th>
				<th orderField="errorMsg" class="${pageInfo.sorterName eq 'errorMsg' ? pageInfo.sorterDirection : ''}"><hi:text key="异常描述" entity="TblTxPayMentOrder"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblTxPayMentOrder"/></th>
				<th orderField="mchtName" class="${pageInfo.sorterName eq 'mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblTxPayMentOrder"/></th>
				<th orderField="payAmount" class="${pageInfo.sorterName eq 'payAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="支付金额" entity="TblTxPayMentOrder"/></th>
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
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.userName}</td>
				    <td>${item.txTypeId}</td>
				    <td>${item.mchtNo}</td>
				    <td>${item.mchtTxTime}</td>
				    <td>${item.mchtTxTraceNo}</td>
				    <td>${item.orderAmount}</td>
				    <td>${item.plTxTime}</td>
				    <td><hi:select emu="orderTxStatus" name="tblTxPayMentOrders[${s.index}].txStatus" isLabel="true"/></td>
				    <td>${item.txBody}</td>
				    <td>${item.orderExpireDatetime}</td>
				    <td>${item.errorCode}</td>
				    <td>${item.errorMsg}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.mchtName}</td>
				    <td>${item.payAmount}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_DEL">
				      <a class="btnDel" href="<hi:url>tblTxPayMentOrderRemove.action?ajax=1&tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="交易订单"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_VIEW">
				      <a class="btnView" href="<hi:url>tblTxPayMentOrderView.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="查看" parameterLanguageKeys="交易订单"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXPAYMENTORDER_SAVE">
				      <a class="btnEdit" href="<hi:url>tblTxPayMentOrderEdit.action?tblTxPayMentOrder.id=${item.id}</hi:url>" target="navTab" rel="tblTxPayMentOrder" title="<hi:text key="编辑" parameterLanguageKeys="交易订单"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', plTxTraceNo:'${item.plTxTraceNo}',userName:'${item.userName}',txTypeId:'${item.txTypeId}',mchtNo:'${item.mchtNo}',mchtTxTime:'${item.mchtTxTime}',mchtTxTraceNo:'${item.mchtTxTraceNo}',orderAmount:'${item.orderAmount}',plTxTime:'${item.plTxTime}',txStatus:'<hi:select emu="orderTxStatus" name="tblTxPayMentOrders[${s.index}].txStatus" isLabel="true"/>',txBody:'${item.txBody}',orderExpireDatetime:'${item.orderExpireDatetime}',errorCode:'${item.errorCode}',errorMsg:'${item.errorMsg}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',mchtName:'${item.mchtName}',payAmount:'${item.payAmount}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
