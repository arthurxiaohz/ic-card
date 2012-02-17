<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="languageList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="languageList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="Key值" entity="Language"/>:</label>
				<input type="text" name="pageInfo.f_keyStr" value="${pageInfo.f_keyStr}"/>
			</li>	  
		 
			<li>
				<label><hi:text key="实体" entity="Language"/>:</label>
				<input type="text" name="pageInfo.f_entity" value="${pageInfo.f_entity}"/>
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
				 <li><a class="add" href="<hi:url>languageEdit.action?language.id=-1</hi:url>" target="navTab" rel="language"><span><hi:text key="新建" parameterLanguageKeys="多语言信息"/></span></a></li>
	
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', keyStr:'',service:'',entity:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				 
				</c:if>
				<th orderField="keyStr" class="${pageInfo.sorterName eq 'keyStr' ? pageInfo.sorterDirection : ''}"><hi:text key="Key值" entity="Language"/></th>
				<th orderField="service" class="${pageInfo.sorterName eq 'service' ? pageInfo.sorterDirection : ''}"><hi:text key="服务" entity="Language"/></th>
				<th orderField="entity" class="${pageInfo.sorterName eq 'entity' ? pageInfo.sorterDirection : ''}"><hi:text key="实体" entity="Language"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${languages}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				 
				</c:if>			
				    <td>${item.keyStr}</td>
				    <td>${item.service}</td>
				    <td>${item.entity}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				   <c:if test="${item.isSystem!=1}" >
				      <a class="btnDel" href="<hi:url>languageRemove.action?ajax=1&language.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="多语言信息"/>"><hi:text key="删除"/></a>
				    </c:if>
				 
				      <a class="btnView" href="<hi:url>languageView.action?language.id=${item.id}</hi:url>" target="navTab" rel="language" title="<hi:text key="查看" parameterLanguageKeys="多语言信息"/>"><hi:text key="查看"/></a>
				    
				      <a class="btnEdit" href="<hi:url>languageEdit.action?language.id=${item.id}</hi:url>" target="navTab" rel="language" title="<hi:text key="编辑" parameterLanguageKeys="多语言信息"/>"><hi:text key="编辑"/></a>
				   
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', keyStr:'${item.keyStr}',service:'${item.service}',entity:'${item.entity}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
