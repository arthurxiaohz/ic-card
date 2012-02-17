<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="authorityList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="authorityList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="权限名称" entity="Authority"/>:</label>
				<input type="text" name="pageInfo.f_authorityName" value="${pageInfo.f_authorityName}"/>
			</li>	
			<li>
				<label><hi:text key="属性资源" entity="Authority"/>:</label>
				<input type="text" name="pageInfo.f_propertedResource" value="${pageInfo.f_propertedResource}"/>
			</li>
			<li>
				<label><hi:text key="菜单项" entity="Authority"/>:</label>
				<input type="text" name="pageInfo.menuLink.f_description" value="${pageInfo.menuLink.f_description}"/>
			</li>
			<li>
				<label><hi:text key="描述" entity="Authority"/>:</label>
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
			<li><a class="add" href="<hi:url>authorityEdit.action?authority.id=-1</hi:url>" target="navTab" rel="Authority"><span><hi:text key="新建" parameterLanguageKeys="权限"/></span></a></li>
			<li><a class="delete" href="<hi:url>authorityRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li>
		</c:when>
		<c:otherwise>
			<li><a class="icon" href="javascript:$.bringBack({id:'-1', authorityName:'',propertedResource:'',description:'',menuLinkName:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="authorityName" class="${pageInfo.sorterName eq 'authorityName' ? pageInfo.sorterDirection : ''}"><hi:text key="权限名称" entity="Authority"/></th>
				<th orderField="propertedResource" class="${pageInfo.sorterName eq 'propertedResource' ? pageInfo.sorterDirection : ''}"><hi:text key="属性资源" entity="Authority"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="Authority"/></th>
				<th orderField="menuLink.description" class="${pageInfo.sorterName eq 'menuLink.description' ? pageInfo.sorterDirection : ''}"><hi:text key="菜单项" entity="Authority"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${authoritys}" varStatus="authority">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.authorityName}</td>
				    <td>${item.propertedResource}</td>
				    <td>${item.description}</td>
				    <td>${item.menuLink.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				      <a class="btnDel" href="<hi:url>authorityRemove.action?ajax=1&authority.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="权限"/>"><hi:text key="删除"/></a>
				      <a class="btnView" href="<hi:url>authorityView.action?authority.id=${item.id}</hi:url>" target="navTab" rel="Authority" title="<hi:text key="查看" parameterLanguageKeys="权限"/>"><hi:text key="查看"/></a>
				      <a class="btnEdit" href="<hi:url>authorityEdit.action?authority.id=${item.id}</hi:url>" target="navTab" rel="Authority" title="<hi:text key="编辑" parameterLanguageKeys="权限"/>"><hi:text key="编辑"/></a>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', authorityName:'${item.authorityName}',propertedResource:'${item.propertedResource}',description:'${item.description}',menuLinkName:'${item.menuLink.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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