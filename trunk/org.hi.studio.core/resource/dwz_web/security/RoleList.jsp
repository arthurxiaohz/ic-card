<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="roleList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="roleList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="角色名称" entity="Role"/>:</label>
				<input type="text" name="pageInfo.role.f_roleName" value="${pageInfo.role.f_roleName}"/>
			</li>	 
			<li>
				<label><hi:text key="用户名" entity="Role"/>:</label>
				<input type="text" name="pageInfo.securityUser.f_fullName" value="${pageInfo.securityUser.f_fullName}"/>
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
			<authz:authorize ifAnyGranted="ROLE_SAVE"><li><a class="add" href="<hi:url>roleEdit.action?role.id=-1</hi:url>" target="navTab" rel="Role"><span><hi:text key="新建" parameterLanguageKeys="角色"/></span></a></li></authz:authorize>
			<ws:if test="#isSupperManager"> <li><a class="delete" href="<hi:url>roleRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li> </ws:if>
		</c:when>
		<c:otherwise>
			<li><a class="icon" href="javascript:$.bringBack({id:'-1', roleName:'',displayRef:'',userName:'',description:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="roleName" class="${pageInfo.sorterName eq 'roleName' ? pageInfo.sorterDirection : ''}"><hi:text key="角色名称" entity="Role"/></th>
				<th orderField="displayRef" class="${pageInfo.sorterName eq 'displayRef' ? pageInfo.sorterDirection : ''}"><hi:text key="显示信息" entity="Role"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="Role"/></th>
				<th width="115">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${roles}" varStatus="role">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.roleName}</td>
				    <td>${item.displayRef}</td>
				    <td>${item.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="ROLE_DEL">
				      <a class="btnDel" href="<hi:url>roleRemove.action?ajax=1&role.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="角色"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="ROLE_VIEW">
				      <a class="btnView" href="<hi:url>roleView.action?role.id=${item.id}</hi:url>" target="navTab" rel="Role" title="<hi:text key="查看" parameterLanguageKeys="角色"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="ROLE_SAVE">
				      <a class="btnEdit" href="<hi:url>roleEdit.action?role.id=${item.id}</hi:url>" target="navTab" rel="Role" title="<hi:text key="编辑" parameterLanguageKeys="角色"/>"><hi:text key="编辑"/></a>
				      <a class="btnAssign" href="<hi:url>roleAssignView.action?role.id=${item.id}</hi:url>" target="navTab"  title="<hi:text key="分派" parameterLanguageKeys="角色"/>" style="cursor: pointer"><hi:text key="分派"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', roleName:'${item.roleName}',displayRef:'${item.displayRef}',userName:'${item.role.creator.userName}',description:'${item.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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