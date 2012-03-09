<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlSettleBatchList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlSettleBatchList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="结算批次号" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_settleBatchNo" value="${pageInfo.f_settleBatchNo}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="结算日" entity="TblStlSettleBatch"/>:</label>
				<input type="text" name="pageInfo.f_settleDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_settleDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_settleDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_settleDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_settleDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_settleDate01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="状态" entity="TblStlSettleBatch"/>:</label>
				<hi:search name="pageInfo.f_settleBatchStatus" emu="settleBatchStatus"/>
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
				<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_SAVE"><li><a class="add" href="<hi:url>tblStlSettleBatchEdit.action?tblStlSettleBatch.id=-1</hi:url>" target="navTab" rel="tblStlSettleBatch"><span><hi:text key="新建" parameterLanguageKeys="结算批次"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_DEL"><li><a class="delete" href="<hi:url>tblStlSettleBatchRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', settleBatchNo:'',settleDate:'',totalCount:'',totalAmount:'',settleBatchStatus:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="settleBatchNo" class="${pageInfo.sorterName eq 'settleBatchNo' ? pageInfo.sorterDirection : ''}"><hi:text key="结算批次号" entity="TblStlSettleBatch"/></th>
				<th orderField="settleDate" class="${pageInfo.sorterName eq 'settleDate' ? pageInfo.sorterDirection : ''}"><hi:text key="结算日" entity="TblStlSettleBatch"/></th>
				<th orderField="totalCount" class="${pageInfo.sorterName eq 'totalCount' ? pageInfo.sorterDirection : ''}"><hi:text key="总条数" entity="TblStlSettleBatch"/></th>
				<th orderField="totalAmount" class="${pageInfo.sorterName eq 'totalAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="总金额" entity="TblStlSettleBatch"/></th>
				<th orderField="settleBatchStatus" class="${pageInfo.sorterName eq 'settleBatchStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="状态" entity="TblStlSettleBatch"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlSettleBatchs}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.settleBatchNo}</td>
					<td><fmt:formatDate value="${item.settleDate}" pattern="yyyy-MM-dd"/></td>
				    <td>${item.totalCount}</td>
				    <td>${item.totalAmount}</td>
				    <td><hi:select emu="settleBatchStatus" name="tblStlSettleBatchs[${s.index}].settleBatchStatus" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_DEL">
				      <a class="btnDel" href="<hi:url>tblStlSettleBatchRemove.action?ajax=1&tblStlSettleBatch.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="结算批次"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_VIEW">
				      <a class="btnView" href="<hi:url>tblStlSettleBatchView.action?tblStlSettleBatch.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleBatch" title="<hi:text key="查看" parameterLanguageKeys="结算批次"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLSETTLEBATCH_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlSettleBatchEdit.action?tblStlSettleBatch.id=${item.id}</hi:url>" target="navTab" rel="tblStlSettleBatch" title="<hi:text key="编辑" parameterLanguageKeys="结算批次"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="FUND_REPORT_DOWNLOAD">
				      <a class="btnAttach" href="<hi:url>fundReport.action?id=${item.id}</hi:url>" title="下载">下载</a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', settleBatchNo:'${item.settleBatchNo}',settleDate:'${item.settleDate}',totalCount:'${item.totalCount}',totalAmount:'${item.totalAmount}',settleBatchStatus:'<hi:select emu="settleBatchStatus" name="tblStlSettleBatchs[${s.index}].settleBatchStatus" isLabel="true"/>'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
