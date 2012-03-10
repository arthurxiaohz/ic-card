<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlErrorDetailList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlErrorDetailList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="平台交易流水号" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_plTxTraceNo" value="${pageInfo.f_plTxTraceNo}"/>
			</li>	  
			<li>
				<label><hi:text key="订单金额" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_amount" value="${pageInfo.f_amount}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="订单创建时间" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_orderCreateDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_orderCreateDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_orderCreateDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_orderCreateDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_orderCreateDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_orderCreateDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="机构订单号" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_orgOrderId" value="${pageInfo.f_orgOrderId}"/>
			</li>	  
			<li>
				<label><hi:text key="连接id" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_connectionId" value="${pageInfo.f_connectionId}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>
				<label><hi:text key="差错类型" entity="TblStlErrorDetail"/>:</label>
				<hi:search name="pageInfo.f_discrepancyType" emu="discrepancyType"/>
			</li>	  
			<li>
				<label><hi:text key="描述" entity="TblStlErrorDetail"/>:</label>
				<input type="text" name="pageInfo.f_description" value="${pageInfo.f_description}"/>
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
				<authz:authorize ifAnyGranted="TBLSTLERRORDETAIL_SAVE"><li><a class="add" href="<hi:url>tblStlErrorDetailEdit.action?tblStlErrorDetail.id=-1</hi:url>" target="navTab" rel="tblStlErrorDetail"><span><hi:text key="新建" parameterLanguageKeys="差错明细表"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLERRORDETAIL_DEL"><li><a class="delete" href="<hi:url>tblStlErrorDetailRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', plTxTraceNo:'',amount:'',orderCreateDatetime:'',orgOrderId:'',connectionId:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',discrepancyType:'',description:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="plTxTraceNo" class="${pageInfo.sorterName eq 'plTxTraceNo' ? pageInfo.sorterDirection : ''}"><hi:text key="平台交易流水号" entity="TblStlErrorDetail"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="订单金额" entity="TblStlErrorDetail"/></th>
				<th orderField="orderCreateDatetime" class="${pageInfo.sorterName eq 'orderCreateDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="订单创建时间" entity="TblStlErrorDetail"/></th>
				<th orderField="orgOrderId" class="${pageInfo.sorterName eq 'orgOrderId' ? pageInfo.sorterDirection : ''}"><hi:text key="机构订单号" entity="TblStlErrorDetail"/></th>
				<th orderField="connectionId" class="${pageInfo.sorterName eq 'connectionId' ? pageInfo.sorterDirection : ''}"><hi:text key="连接id" entity="TblStlErrorDetail"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblStlErrorDetail"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblStlErrorDetail"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblStlErrorDetail"/></th>
				<th orderField="discrepancyType" class="${pageInfo.sorterName eq 'discrepancyType' ? pageInfo.sorterDirection : ''}"><hi:text key="差错类型" entity="TblStlErrorDetail"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="TblStlErrorDetail"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlErrorDetails}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.plTxTraceNo}</td>
				    <td>${item.amount}</td>
				    <td><fmt:formatDate value="${item.orderCreateDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.orgOrderId}</td>
				    <td>${item.connectionId}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td><hi:select emu="discrepancyType" name="tblStlErrorDetails[${s.index}].discrepancyType" isLabel="true"/></td>
				    <td>${item.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLERRORDETAIL_DEL">
				      <a class="btnDel" href="<hi:url>tblStlErrorDetailRemove.action?ajax=1&tblStlErrorDetail.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="差错明细表"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLERRORDETAIL_VIEW">
				      <a class="btnView" href="<hi:url>tblStlErrorDetailView.action?tblStlErrorDetail.id=${item.id}</hi:url>" target="navTab" rel="tblStlErrorDetail" title="<hi:text key="查看" parameterLanguageKeys="差错明细表"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLERRORDETAIL_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlErrorDetailEdit.action?tblStlErrorDetail.id=${item.id}</hi:url>" target="navTab" rel="tblStlErrorDetail" title="<hi:text key="编辑" parameterLanguageKeys="差错明细表"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', plTxTraceNo:'${item.plTxTraceNo}',amount:'${item.amount}',orderCreateDatetime:'${item.orderCreateDatetime}',orgOrderId:'${item.orgOrderId}',connectionId:'${item.connectionId}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',discrepancyType:'<hi:select emu="discrepancyType" name="tblStlErrorDetails[${s.index}].discrepancyType" isLabel="true"/>',description:'${item.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
