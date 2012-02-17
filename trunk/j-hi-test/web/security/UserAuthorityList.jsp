<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="userAuthorityList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="userAuthorityList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="用户" entity="UserAuthority"/>:</label>
				<input type="text" name="pageInfo.securityUser.f_fullName" value="${pageInfo.securityUser.f_fullName}"/>
			</li>	 
			<li>
				<label><hi:text key="权限" entity="UserAuthority"/>:</label>
				<input type="text" name="pageInfo.authority.f_description" value="${pageInfo.authority.f_description}"/>
			</li>
			<li>
				<label><hi:text key="部门" entity="UserAuthority"/>:</label>
				<input type="text" name="pageInfo.org.f_orgName" value="${pageInfo.org.f_orgName}"/>
			</li>
			<li>
				<label><hi:text key="范围" entity="UserAuthority"/>:</label>
				 <hi:search name="pageInfo.f_scope" emu="securityScope"/>
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
		    <li><a class="add" href="<hi:url>userAuthorityEdit.action?userAuthority.id=-1</hi:url>" target="navTab" rel="UserAuthority"><span><hi:text key="新建" parameterLanguageKeys="用户权限"/></span></a></li>
			<li><a class="delete" href="<hi:url>userAuthorityRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li>
			<li class="line">line</li>
		<!-- 	<li><a class="edit" href="<hi:url>batchAuthority.action</hi:url>" target="navTab"><span><hi:text key="多用户批量授权"/></span></a></li>  -->
		    <li><a class="edit" href="<hi:url>singleBatchAuthority.action</hi:url>" target="navTab"><span><hi:text key="单用户批量授权"/></span></a></li>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="securityUser.fullName" class="${pageInfo.sorterName eq 'securityUser.fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="用户" entity="UserAuthority"/></th>
				<th orderField="authority.description" class="${pageInfo.sorterName eq 'authority.description' ? pageInfo.sorterDirection : ''}"><hi:text key="权限" entity="UserAuthority"/></th>
				<th orderField="org.orgName" class="${pageInfo.sorterName eq 'org.orgName' ? pageInfo.sorterDirection : ''}"><hi:text key="部门" entity="UserAuthority"/></th>
				<th orderField="scope" class="${pageInfo.sorterName eq 'scope' ? pageInfo.sorterDirection : ''}"><hi:text key="范围" entity="UserAuthority"/></th>
				
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作" /></c:when>
						<c:otherwise><hi:text key="查找带回" /></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${userAuthoritys}" varStatus="userAuthority">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.securityUser.fullName}</td>
				    <td>${item.authority.description}</td>
				    <td>${item.org.orgName}</td>
				    <td><hi:select emu="securityScope" name="userAuthoritys[${userAuthority.index}].scope" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				      <a class="btnDel" href="<hi:url>userAuthorityRemove.action?ajax=1&userAuthority.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="用户权限"/>"><hi:text key="删除"/></a>
				
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', userName:'${item.securityUser.fullName}',authorityName:'${item.authority.description}',orgName:'${item.org.orgName}',scope:'${item.scope}')" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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