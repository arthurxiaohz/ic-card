<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="experienceList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="experienceList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li class="dateRange">
				<label><hi:text key="开始时间" entity="Experience"/>:</label>
				<input type="text" name="pageInfo.f_startTime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_startTime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_startTime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_startTime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_startTime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_startTime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="结束时间" entity="Experience"/>:</label>
				<input type="text" name="pageInfo.f_endTime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_endTime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_endTime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_endTime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_endTime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_endTime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="地点" entity="Experience"/>:</label>
				<input type="text" name="pageInfo.f_place" value="${pageInfo.f_place}"/>
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
				<authz:authorize ifAnyGranted="EXPERIENCE_SAVE"><li><a class="add" href="<hi:url>experienceEdit.action?experience.id=-1</hi:url>" target="navTab" rel="experience"><span><hi:text key="新建" parameterLanguageKeys="Experience"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="EXPERIENCE_DEL"><li><a class="delete" href="<hi:url>experienceRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', startTime:'',endTime:'',place:'',task:'',people:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="startTime" class="${pageInfo.sorterName eq 'startTime' ? pageInfo.sorterDirection : ''}"><hi:text key="开始时间" entity="Experience"/></th>
				<th orderField="endTime" class="${pageInfo.sorterName eq 'endTime' ? pageInfo.sorterDirection : ''}"><hi:text key="结束时间" entity="Experience"/></th>
				<th orderField="place" class="${pageInfo.sorterName eq 'place' ? pageInfo.sorterDirection : ''}"><hi:text key="地点" entity="Experience"/></th>
				<th orderField="task" class="${pageInfo.sorterName eq 'task' ? pageInfo.sorterDirection : ''}"><hi:text key="任务" entity="Experience"/></th>
				<th orderField="people" class="${pageInfo.sorterName eq 'people' ? pageInfo.sorterDirection : ''}"><hi:text key="证明人" entity="Experience"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${experiences}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.place}</td>
				    <td>${item.task}</td>
				    <td>${item.people}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="EXPERIENCE_DEL">
				      <a class="btnDel" href="<hi:url>experienceRemove.action?ajax=1&experience.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="Experience"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="EXPERIENCE_VIEW">
				      <a class="btnView" href="<hi:url>experienceView.action?experience.id=${item.id}</hi:url>" target="navTab" rel="experience" title="<hi:text key="查看" parameterLanguageKeys="Experience"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="EXPERIENCE_SAVE">
				      <a class="btnEdit" href="<hi:url>experienceEdit.action?experience.id=${item.id}</hi:url>" target="navTab" rel="experience" title="<hi:text key="编辑" parameterLanguageKeys="Experience"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', startTime:'${item.startTime}',endTime:'${item.endTime}',place:'${item.place}',task:'${item.task}',people:'${item.people}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
