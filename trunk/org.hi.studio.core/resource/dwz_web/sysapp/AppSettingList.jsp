<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="appSettingList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="appSettingList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="组名" entity="AppSetting"/>:</label>
				<input type="text" name="pageInfo.f_appGroup" value="${pageInfo.f_appGroup}"/>
			</li>	 
			<li>
				<label><hi:text key="配置名" entity="AppSetting"/>:</label>
				<input type="text" name="pageInfo.f_appName" value="${pageInfo.f_appName}"/>
			</li> 
			<li>
				<label><hi:text key="配置值" entity="AppSetting"/>:</label>
				<input type="text" name="pageInfo.f_appValue" value="${pageInfo.f_appValue}"/>
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
			<authz:authorize ifAnyGranted="APPSETTING_SAVE"><li><a class="add" href="<hi:url>appSettingEdit.action?appSetting.id=-1</hi:url>" target="navTab" rel="AppSetting"><span><hi:text key="新建" parameterLanguageKeys="应用配置"/></span></a></li></authz:authorize>
			<ws:if test="!#published">
			<authz:authorize ifAnyGranted="APPSETTING_DEL"><li><a class="delete" href="<hi:url>appSettingRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
		    </ws:if>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="appGroup" class="${pageInfo.sorterName eq 'appGroup' ? pageInfo.sorterDirection : ''}"><hi:text key="组名" entity="AppSetting"/></th>
				<th orderField="appName" class="${pageInfo.sorterName eq 'appName' ? pageInfo.sorterDirection : ''}"><hi:text key="配置名" entity="AppSetting"/></th>
				<th orderField="appValue" class="${pageInfo.sorterName eq 'appValue' ? pageInfo.sorterDirection : ''}"><hi:text key="配置值" entity="AppSetting"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="AppSetting"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${appSettings}" varStatus="appSetting">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.appGroup}</td>
				    <td>${item.appName}</td>
				    <td>${item.appValue}</td>
				    <td>${item.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="APPSETTING_DEL">
				      <a class="btnDel" href="<hi:url>appSettingRemove.action?ajax=1&appSetting.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="应用配置"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="APPSETTING_VIEW">
				      <a class="btnView" href="<hi:url>appSettingView.action?appSetting.id=${item.id}</hi:url>" target="navTab" rel="AppSetting" title="<hi:text key="查看" parameterLanguageKeys="应用配置"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="APPSETTING_SAVE">
				      <a class="btnEdit" href="<hi:url>appSettingEdit.action?appSetting.id=${item.id}</hi:url>" target="navTab" rel="AppSetting" title="<hi:text key="编辑" parameterLanguageKeys="应用配置"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', appGroup:'${item.appGroup}',appName:'${item.appName}',appValue:'${item.appValue}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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