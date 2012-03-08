<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlCleaningDetailList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlCleaningDetailList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="平台交易流水号" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户订单号" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_mchtOrderId" value="${pageInfo.f_mchtOrderId}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>
				<label><hi:text key="金额" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_orderAmount" value="${pageInfo.f_orderAmount}"/>
			</li>	  
			<li>
				<label><hi:text key="交易时间" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_transTime" value="${pageInfo.f_transTime}"/>
			</li>	  
			<li>
				<label><hi:text key="退款原始订单" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_refundOrderId" value="${pageInfo.f_refundOrderId}"/>
			</li>	  
			<li>
				<label><hi:text key="退款金额" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_refundAmt" value="${pageInfo.f_refundAmt}"/>
			</li>	  
			<li>
				<label><hi:text key="商户结算扣费金额" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_mchtSettleFee" value="${pageInfo.f_mchtSettleFee}"/>
			</li>	  
			<li>
				<label><hi:text key="账号" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_userName" value="${pageInfo.f_userName}"/>
			</li>	  
			<li>
				<label><hi:text key="积分" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_balance" value="${pageInfo.f_balance}"/>
			</li>	  
			<li>
				<label><hi:text key="退还积分" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_backBalance" value="${pageInfo.f_backBalance}"/>
			</li>	  
			<li>
				<label><hi:text key="商户号" entity="TblStlCleaningDetail"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="清分状态" entity="TblStlCleaningDetail"/>:</label>
				<hi:search name="pageInfo.f_cleanStatus" emu="cleanStatus"/>
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
				<authz:authorize ifAnyGranted="TBLSTLCLEANINGDETAIL_SAVE"><li><a class="add" href="<hi:url>tblStlCleaningDetailEdit.action?tblStlCleaningDetail.id=-1</hi:url>" target="navTab" rel="tblStlCleaningDetail"><span><hi:text key="新建" parameterLanguageKeys="清分流水表"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLCLEANINGDETAIL_DEL"><li><a class="delete" href="<hi:url>tblStlCleaningDetailRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', plTxTraceNo:'',mchtOrderId:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',orderAmount:'',transTime:'',refundOrderId:'',refundOrderAmt:'',refundAmt:'',refundFee:'',mchtSettleFee:'',reMark:'',transType:'',userName:'',balance:'',backBalance:'',mchtNo:'',mchtName:'',cleanStatus:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblStlCleaningDetail"/></th>
				<th orderField="mchtOrderId" class="${pageInfo.sorterName eq 'mchtOrderId' ? pageInfo.sorterDirection : ''}"><hi:text key="商户订单号" entity="TblStlCleaningDetail"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblStlCleaningDetail"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblStlCleaningDetail"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblStlCleaningDetail"/></th>
				<th orderField="orderAmount" class="${pageInfo.sorterName eq 'orderAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="金额" entity="TblStlCleaningDetail"/></th>
				<th orderField="transTime" class="${pageInfo.sorterName eq 'transTime' ? pageInfo.sorterDirection : ''}"><hi:text key="交易时间" entity="TblStlCleaningDetail"/></th>
				<th orderField="refundOrderId" class="${pageInfo.sorterName eq 'refundOrderId' ? pageInfo.sorterDirection : ''}"><hi:text key="退款原始订单" entity="TblStlCleaningDetail"/></th>
				<th orderField="refundOrderAmt" class="${pageInfo.sorterName eq 'refundOrderAmt' ? pageInfo.sorterDirection : ''}"><hi:text key="退款订单原始交易金额" entity="TblStlCleaningDetail"/></th>
				<th orderField="refundAmt" class="${pageInfo.sorterName eq 'refundAmt' ? pageInfo.sorterDirection : ''}"><hi:text key="退款金额" entity="TblStlCleaningDetail"/></th>
				<th orderField="refundFee" class="${pageInfo.sorterName eq 'refundFee' ? pageInfo.sorterDirection : ''}"><hi:text key="退还的手续费用" entity="TblStlCleaningDetail"/></th>
				<th orderField="mchtSettleFee" class="${pageInfo.sorterName eq 'mchtSettleFee' ? pageInfo.sorterDirection : ''}"><hi:text key="商户结算扣费金额" entity="TblStlCleaningDetail"/></th>
				<th orderField="reMark" class="${pageInfo.sorterName eq 'reMark' ? pageInfo.sorterDirection : ''}"><hi:text key="备注信息" entity="TblStlCleaningDetail"/></th>
				<th orderField="transType" class="${pageInfo.sorterName eq 'transType' ? pageInfo.sorterDirection : ''}"><hi:text key="交易类型" entity="TblStlCleaningDetail"/></th>
				<th orderField="userName" class="${pageInfo.sorterName eq 'userName' ? pageInfo.sorterDirection : ''}"><hi:text key="账号" entity="TblStlCleaningDetail"/></th>
				<th orderField="balance" class="${pageInfo.sorterName eq 'balance' ? pageInfo.sorterDirection : ''}"><hi:text key="积分" entity="TblStlCleaningDetail"/></th>
				<th orderField="backBalance" class="${pageInfo.sorterName eq 'backBalance' ? pageInfo.sorterDirection : ''}"><hi:text key="退还积分" entity="TblStlCleaningDetail"/></th>
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblStlCleaningDetail"/></th>
				<th orderField="mchtName" class="${pageInfo.sorterName eq 'mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblStlCleaningDetail"/></th>
				<th orderField="cleanStatus" class="${pageInfo.sorterName eq 'cleanStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="清分状态" entity="TblStlCleaningDetail"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlCleaningDetails}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.mchtOrderId}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td>${item.orderAmount}</td>
				    <td>${item.transTime}</td>
				    <td>${item.refundOrderId}</td>
				    <td>${item.refundOrderAmt}</td>
				    <td>${item.refundAmt}</td>
				    <td>${item.refundFee}</td>
				    <td>${item.mchtSettleFee}</td>
				    <td>${item.reMark}</td>
				    <td>${item.transType}</td>
				    <td>${item.userName}</td>
				    <td>${item.balance}</td>
				    <td>${item.backBalance}</td>
				    <td>${item.mchtNo}</td>
				    <td>${item.mchtName}</td>
				    <td><hi:select emu="cleanStatus" name="tblStlCleaningDetails[${s.index}].cleanStatus" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLCLEANINGDETAIL_DEL">
				      <a class="btnDel" href="<hi:url>tblStlCleaningDetailRemove.action?ajax=1&tblStlCleaningDetail.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="清分流水表"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLCLEANINGDETAIL_VIEW">
				      <a class="btnView" href="<hi:url>tblStlCleaningDetailView.action?tblStlCleaningDetail.id=${item.id}</hi:url>" target="navTab" rel="tblStlCleaningDetail" title="<hi:text key="查看" parameterLanguageKeys="清分流水表"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLCLEANINGDETAIL_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlCleaningDetailEdit.action?tblStlCleaningDetail.id=${item.id}</hi:url>" target="navTab" rel="tblStlCleaningDetail" title="<hi:text key="编辑" parameterLanguageKeys="清分流水表"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', plTxTraceNo:'${item.plTxTraceNo}',mchtOrderId:'${item.mchtOrderId}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',orderAmount:'${item.orderAmount}',transTime:'${item.transTime}',refundOrderId:'${item.refundOrderId}',refundOrderAmt:'${item.refundOrderAmt}',refundAmt:'${item.refundAmt}',refundFee:'${item.refundFee}',mchtSettleFee:'${item.mchtSettleFee}',reMark:'${item.reMark}',transType:'${item.transType}',userName:'${item.userName}',balance:'${item.balance}',backBalance:'${item.backBalance}',mchtNo:'${item.mchtNo}',mchtName:'${item.mchtName}',cleanStatus:'<hi:select emu="cleanStatus" name="tblStlCleaningDetails[${s.index}].cleanStatus" isLabel="true"/>'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
