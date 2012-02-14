<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="${entity.entityName?uncap_first}List.action">
<#noparse>
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</#noparse>	
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="${entity.entityName?uncap_first}List.action?<#noparse>lookup=${lookup}</#noparse>" onsubmit="return dwzSearch(this, '<#noparse>${</#noparse>targetType<#noparse>}</#noparse>');">
	<input type="hidden" name="pageInfo.pageSize" value="<#noparse>${</#noparse>pageInfo.pageSize<#noparse>}</#noparse>" />
	<div class="searchBar">
		<ul class="searchContent">	
<#include "/dwz/list-search.ftl">
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
			<c:when test="<#noparse>${empty lookup}</#noparse>">
				<authz:authorize ifAnyGranted="${entity.entityName?upper_case}_SAVE"><li><a class="add" href="<hi:url>${entity.entityName?uncap_first}Edit.action?${entity.entityName?uncap_first}.id=-1</hi:url>" target="navTab" rel="${entity.entityName?uncap_first}"><span><hi:text key="新建" parameterLanguageKeys="${entity.entityLabel}"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="${entity.entityName?upper_case}_DEL"><li><a class="delete" href="<hi:url>${entity.entityName?uncap_first}RemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', <#list serviceTool.getDisplayFields(entity) as field>${field.fieldName?uncap_first}:''<#if field_has_next>,</#if></#list>})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
<#include "/dwz/list-list.ftl">

<#noparse>
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
</#noparse>	
</div>
