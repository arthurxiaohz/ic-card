<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="triggerDefList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="triggerDefList.action" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="触发名称" entity="TriggerDef"/>:</label>
				<input type="text" name="pageInfo.f_triggerName" value="${pageInfo.f_triggerName}"/>
			</li>
			<li>
				<label><hi:text key="表达式" entity="TriggerDef"/>:</label>
				<input type="text" name="pageInfo.f_cronExpression" value="${pageInfo.f_cronExpression}"/>
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
			<authz:authorize ifAnyGranted="TRIGGERDEF_SAVE"><li><a class="add" href="<hi:url>triggerDefEdit.action?triggerDef.id=-1</hi:url>" target="navTab" rel="TriggerDef"><span><hi:text key="新建" parameterLanguageKeys="触发器"/></span></a></li></authz:authorize>
			<authz:authorize ifAnyGranted="TRIGGERDEF_DEL"><li><a class="delete" href="<hi:url>triggerDefRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="triggerName" class="${pageInfo.sorterName eq 'triggerName' ? pageInfo.sorterDirection : ''}"><hi:text key="触发名称" entity="TriggerDef"/></th>
				<th orderField="jobDetail.jobName" class="${pageInfo.sorterName eq 'jobDetail.jobName' ? pageInfo.sorterDirection : ''}"><hi:text key="工作项" entity="TriggerDef"/></th>
				<th orderField="startTime" class="${pageInfo.sorterName eq 'startTime' ? pageInfo.sorterDirection : ''}"><hi:text key="开始时间" entity="TriggerDef"/></th>
				<th orderField="endTime" class="${pageInfo.sorterName eq 'endTime' ? pageInfo.sorterDirection : ''}"><hi:text key="截止时间" entity="TriggerDef"/></th>
				<th orderField="cronExpression" class="${pageInfo.sorterName eq 'cronExpression' ? pageInfo.sorterDirection : ''}"><hi:text key="表达式" entity="TriggerDef"/></th>
				<th orderField="enabled" class="${pageInfo.sorterName eq 'enabled' ? pageInfo.sorterDirection : ''}"><hi:text key="是否激活" entity="TriggerDef"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${triggerDefs}" varStatus="triggerDef">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.triggerName}</td>
				    <td>${item.jobDetail.jobName}</td>
				    <td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.cronExpression}</td>
				    <td><hi:select emu="yesNo" name="triggerDefs[${triggerDef.index}].enabled" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TRIGGERDEF_DEL">
				      <a class="btnDel" href="<hi:url>triggerDefRemove.action?ajax=1&triggerDef.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="触发器"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TRIGGERDEF_VIEW">
				      <a class="btnView" href="<hi:url>triggerDefView.action?triggerDef.id=${item.id}</hi:url>" target="navTab" rel="TriggerDef" title="<hi:text key="查看" parameterLanguageKeys="触发器"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TRIGGERDEF_SAVE">
				      <a class="btnEdit" href="<hi:url>triggerDefEdit.action?triggerDef.id=${item.id}</hi:url>" target="navTab" rel="TriggerDef" title="<hi:text key="编辑" parameterLanguageKeys="触发器"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', triggerName:'${item.triggerName}',jobDetailName:'${item.jobDetail.jobName}',priority:'${item.priority}',startTime:'${item.startTime}',endTime:'${item.endTime}',cronExpression:'${item.cronExpression}',enabled:'${item.enabled}',description:'${item.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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