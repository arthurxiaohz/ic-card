<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="actAccountList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="actAccountList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="账号" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_accountNo" value="${pageInfo.f_accountNo}"/>
			</li>	  
			<li>
				<label><hi:text key="账户分类" entity="ActAccount"/>:</label>
				<hi:search name="pageInfo.f_accountCatalog" emu="accountCatalog"/>
			</li>	  
			<li>
				<label><hi:text key="开户方类型" entity="ActAccount"/>:</label>
				<hi:search name="pageInfo.f_accountPartyType" emu="accountPartyType"/>
			</li>	  
			<li>
				<label><hi:text key="开户方" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_accountParty" value="${pageInfo.f_accountParty}"/>
			</li>	  
			<li>
				<label><hi:text key="开户名称" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_accountName" value="${pageInfo.f_accountName}"/>
			</li>	  
			<li>
				<label><hi:text key="备注" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_remark" value="${pageInfo.f_remark}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_createdDateTime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDateTime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDateTime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDateTime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="ActAccount"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="ACTACCOUNT_SAVE"><li><a class="add" href="<hi:url>actAccountEdit.action?actAccount.id=-1</hi:url>" target="navTab" rel="actAccount"><span><hi:text key="新建" parameterLanguageKeys="账户"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="ACTACCOUNT_DEL"><li><a class="delete" href="<hi:url>actAccountRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', accountNo:'',accountCatalog:'',accountPartyType:'',accountParty:'',accountName:'',status:'',remark:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="accountNo" class="${pageInfo.sorterName eq 'accountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="账号" entity="ActAccount"/></th>
				<th orderField="accountCatalog" class="${pageInfo.sorterName eq 'accountCatalog' ? pageInfo.sorterDirection : ''}"><hi:text key="账户分类" entity="ActAccount"/></th>
				<th orderField="accountPartyType" class="${pageInfo.sorterName eq 'accountPartyType' ? pageInfo.sorterDirection : ''}"><hi:text key="开户方类型" entity="ActAccount"/></th>
				<th orderField="accountParty" class="${pageInfo.sorterName eq 'accountParty' ? pageInfo.sorterDirection : ''}"><hi:text key="开户方" entity="ActAccount"/></th>
				<th orderField="accountName" class="${pageInfo.sorterName eq 'accountName' ? pageInfo.sorterDirection : ''}"><hi:text key="开户名称" entity="ActAccount"/></th>
				<th orderField="status" class="${pageInfo.sorterName eq 'status' ? pageInfo.sorterDirection : ''}"><hi:text key="状态" entity="ActAccount"/></th>
				<th orderField="remark" class="${pageInfo.sorterName eq 'remark' ? pageInfo.sorterDirection : ''}"><hi:text key="备注" entity="ActAccount"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="ActAccount"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="ActAccount"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${actAccounts}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.accountNo}</td>
				    <td><hi:select emu="accountCatalog" name="actAccounts[${s.index}].accountCatalog" isLabel="true"/></td>
				    <td><hi:select emu="accountPartyType" name="actAccounts[${s.index}].accountPartyType" isLabel="true"/></td>
				    <td>${item.accountParty}</td>
				    <td>${item.accountName}</td>
				    <td><hi:select emu="accountStatus" name="actAccounts[${s.index}].status" isLabel="true"/></td>
				    <td>${item.remark}</td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="ACTACCOUNT_DEL">
				      <a class="btnDel" href="<hi:url>actAccountRemove.action?ajax=1&actAccount.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="账户"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="ACTACCOUNT_VIEW">
				      <a class="btnView" href="<hi:url>actAccountView.action?actAccount.id=${item.id}</hi:url>" target="navTab" rel="actAccount" title="<hi:text key="查看" parameterLanguageKeys="账户"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="ACTACCOUNT_SAVE">
				      <a class="btnEdit" href="<hi:url>actAccountEdit.action?actAccount.id=${item.id}</hi:url>" target="navTab" rel="actAccount" title="<hi:text key="编辑" parameterLanguageKeys="账户"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', accountNo:'${item.accountNo}',accountCatalog:'<hi:select emu="accountCatalog" name="actAccounts[${s.index}].accountCatalog" isLabel="true"/>',accountPartyType:'<hi:select emu="accountPartyType" name="actAccounts[${s.index}].accountPartyType" isLabel="true"/>',accountParty:'${item.accountParty}',accountName:'${item.accountName}',status:'<hi:select emu="accountStatus" name="actAccounts[${s.index}].status" isLabel="true"/>',remark:'${item.remark}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
