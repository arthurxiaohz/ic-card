<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="privilegeResourceList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="privilegeResourceList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="权限名称" entity="PrivilegeResource"/>:</label>
				<input type="text" name="pageInfo.f_authorityName" value="${pageInfo.f_authorityName}"/>
			</li>	
			<li>
				<label><hi:text key="业务层" entity="PrivilegeResource"/>:</label>
				<input type="text" name="pageInfo.f_businessLayer" value="${pageInfo.f_businessLayer}"/>
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
			<authz:authorize ifAnyGranted="PRIVILEGERESOURCE_SAVE"><li><a class="add" href="<hi:url>privilegeResourceEdit.action?privilegeResource.id=-1</hi:url>" target="navTab" rel="PrivilegeResource"><span><hi:text key="新建" parameterLanguageKeys="权限资源"/></span></a></li></authz:authorize>
			<authz:authorize ifAnyGranted="PRIVILEGERESOURCE_DEL"><li><a class="delete" href="<hi:url>privilegeResourceRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
		</c:when>
		<c:otherwise>
			<li><a class="icon" href="javascript:$.bringBack({id:'-1', authorityName:'',viewLayer:'',businessLayer:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="authorityName" class="${pageInfo.sorterName eq 'authorityName' ? pageInfo.sorterDirection : ''}"><hi:text key="权限名称" entity="PrivilegeResource"/></th>
				<th orderField="viewLayer" class="${pageInfo.sorterName eq 'viewLayer' ? pageInfo.sorterDirection : ''}"><hi:text key="表现层" entity="PrivilegeResource"/></th>
				<th orderField="businessLayer" class="${pageInfo.sorterName eq 'businessLayer' ? pageInfo.sorterDirection : ''}"><hi:text key="业务层" entity="PrivilegeResource"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作" /></c:when>
						<c:otherwise><hi:text key="查找带回" /></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${privilegeResources}" varStatus="privilegeResource">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.authorityName}</td>
				    <td>${item.viewLayer}</td>
				    <td>${item.businessLayer}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_DEL">
				      <a class="btnDel" href="<hi:url>privilegeResourceRemove.action?ajax=1&privilegeResource.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="权限资源"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_VIEW">
				      <a class="btnView" href="<hi:url>privilegeResourceView.action?privilegeResource.id=${item.id}</hi:url>" target="navTab" rel="PrivilegeResource" title="<hi:text key="查看" parameterLanguageKeys="权限资源"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="PRIVILEGERESOURCE_SAVE">
				      <a class="btnEdit" href="<hi:url>privilegeResourceEdit.action?privilegeResource.id=${item.id}</hi:url>" target="navTab" rel="PrivilegeResource" title="<hi:text key="编辑" parameterLanguageKeys="权限资源"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', authorityName:'${item.authorityName}',viewLayer:'${item.viewLayer}',businessLayer:'${item.businessLayer}')" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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