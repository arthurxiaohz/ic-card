<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="hiLogList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="hiLogList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="操作人" entity="HiLog"/>:</label>
				<input type="text" name="pageInfo.operator.f_fullName" value="${pageInfo.operator.f_fullName}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="操作时间" entity="HiLog"/>:</label>
				<input type="text" name="pageInfo.f_operateDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_operateDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_operateDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_operateDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_operateDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_operateDate01_op" value="&lt;=">
			</li>	
			<li>
				<label><hi:text key="动作" entity="HiLog"/>:</label>
				<input type="text" name="pageInfo.f_action" value="${pageInfo.f_action}"/>
			</li>	  
			<li>
				<label><hi:text key="操作内容" entity="HiLog"/>:</label>
				<input type="text" name="pageInfo.f_actionContext" value="${pageInfo.f_actionContext}"/>
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
		<c:if test="${empty lookup}">
		<ul class="toolBar">
			<authz:authorize ifAnyGranted="HILOG_DEL"><li><a class="delete" href="<hi:url>hiLogRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="operator.fullName" class="${pageInfo.sorterName eq 'operator.fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="操作人" entity="HiLog"/></th>
				<th orderField="operateDate" class="${pageInfo.sorterName eq 'operateDate' ? pageInfo.sorterDirection : ''}"><hi:text key="操作时间" entity="HiLog"/></th>
				<th orderField="action" class="${pageInfo.sorterName eq 'action' ? pageInfo.sorterDirection : ''}"><hi:text key="动作" entity="HiLog"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${hiLogs}" varStatus="hiLog">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><authz:authorize ifAnyGranted="HIUSER_VIEW"><a href="<hi:url>hiUserView.action?hiUser.id=${item.operator.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.operator.fullName}<authz:authorize ifAnyGranted="HIUSER_VIEW"></a></authz:authorize>
					</td>
				    <td><fmt:formatDate value="${item.operateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.action}</td>
					
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="HILOG_DEL">
				      <a class="btnDel" href="<hi:url>hiLogRemove.action?ajax=1&hiLog.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="系统日志"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="HILOG_VIEW">
				      <a class="btnView" href="<hi:url>hiLogView.action?hiLog.id=${item.id}</hi:url>" target="navTab" rel="HiLog" title="<hi:text key="查看" parameterLanguageKeys="系统日志"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', operatorName:'${item.operator.fullName}',operateDate:'${item.operateDate}',action:'${item.action}',actionContext:'${item.actionContext}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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