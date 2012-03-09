<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbPointRuleList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbPointRuleList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
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
				<authz:authorize ifAnyGranted="TBLMBPOINTRULE_SAVE"><li><a class="add" href="<hi:url>tblMbPointRuleEdit.action?tblMbPointRule.id=-1</hi:url>" target="navTab" rel="tblMbPointRule"><span><hi:text key="新建" parameterLanguageKeys="积分规则"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBPOINTRULE_DEL"><li><a class="delete" href="<hi:url>tblMbPointRuleRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', startDatetime:'',endDatetime:'',minAmount:'',maxAmount:'',pointRuleType:'',ruleValue:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="28"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="startDatetime" class="${pageInfo.sorterName eq 'startDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期开始时间" entity="TblMbPointRule"/></th>
				<th orderField="endDatetime" class="${pageInfo.sorterName eq 'endDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期结束时间" entity="TblMbPointRule"/></th>
				<th orderField="minAmount" class="${pageInfo.sorterName eq 'minAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="起始金额" entity="TblMbPointRule"/></th>
				<th orderField="maxAmount" class="${pageInfo.sorterName eq 'maxAmount' ? pageInfo.sorterDirection : ''}"><hi:text key="截止金额" entity="TblMbPointRule"/></th>
				<th orderField="pointRuleType" class="${pageInfo.sorterName eq 'pointRuleType' ? pageInfo.sorterDirection : ''}"><hi:text key="积分规则类型" entity="TblMbPointRule"/></th>
				<th orderField="ruleValue" class="${pageInfo.sorterName eq 'ruleValue' ? pageInfo.sorterDirection : ''}"><hi:text key="参数值" entity="TblMbPointRule"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbPointRule"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbPointRule"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbPointRules}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td><fmt:formatDate value="${item.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.minAmount}</td>
				    <td>${item.maxAmount}</td>
				    <td><hi:select emu="pointRuleType" name="tblMbPointRules[${s.index}].pointRuleType" isLabel="true"/></td>
				    <td>${item.ruleValue}</td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBPOINTRULE_DEL">
				      <a class="btnDel" href="<hi:url>tblMbPointRuleRemove.action?ajax=1&tblMbPointRule.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="积分规则"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBPOINTRULE_VIEW">
				      <a class="btnView" href="<hi:url>tblMbPointRuleView.action?tblMbPointRule.id=${item.id}</hi:url>" target="navTab" rel="tblMbPointRule" title="<hi:text key="查看" parameterLanguageKeys="积分规则"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBPOINTRULE_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbPointRuleEdit.action?tblMbPointRule.id=${item.id}</hi:url>" target="navTab" rel="tblMbPointRule" title="<hi:text key="编辑" parameterLanguageKeys="积分规则"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', startDatetime:'${item.startDatetime}',endDatetime:'${item.endDatetime}',minAmount:'${item.minAmount}',maxAmount:'${item.maxAmount}',pointRuleType:'<hi:select emu="pointRuleType" name="tblMbPointRules[${s.index}].pointRuleType" isLabel="true"/>',ruleValue:'${item.ruleValue}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
