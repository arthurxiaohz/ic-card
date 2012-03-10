<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlOrganizationList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlOrganizationList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="机构代码" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_orgId" value="${pageInfo.f_orgId}"/>
			</li>	  
			<li>
				<label><hi:text key="机构类型" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_orgType" value="${pageInfo.f_orgType}"/>
			</li>	  
			<li>
				<label><hi:text key="机构名称" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_orgName" value="${pageInfo.f_orgName}"/>
			</li>	  
			<li>
				<label><hi:text key="可用状态" entity="TblStlOrganization"/>:</label>
				<hi:search name="pageInfo.f_status" emu="status"/>
			</li>	  
			<li>
				<label><hi:text key="场次数" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_fieldTimes" value="${pageInfo.f_fieldTimes}"/>
			</li>	  
			<li>
				<label><hi:text key="描述" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_extDesc" value="${pageInfo.f_extDesc}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblStlOrganization"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
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
				<authz:authorize ifAnyGranted="TBLSTLORGANIZATION_SAVE"><li><a class="add" href="<hi:url>tblStlOrganizationEdit.action?tblStlOrganization.id=-1</hi:url>" target="navTab" rel="tblStlOrganization"><span><hi:text key="新建" parameterLanguageKeys="发卡行支持表"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLORGANIZATION_DEL"><li><a class="delete" href="<hi:url>tblStlOrganizationRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', orgId:'',orgType:'',orgName:'',status:'',fieldTimes:'',extDesc:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="orgId" class="${pageInfo.sorterName eq 'orgId' ? pageInfo.sorterDirection : ''}"><hi:text key="机构代码" entity="TblStlOrganization"/></th>
				<th orderField="orgType" class="${pageInfo.sorterName eq 'orgType' ? pageInfo.sorterDirection : ''}"><hi:text key="机构类型" entity="TblStlOrganization"/></th>
				<th orderField="orgName" class="${pageInfo.sorterName eq 'orgName' ? pageInfo.sorterDirection : ''}"><hi:text key="机构名称" entity="TblStlOrganization"/></th>
				<th orderField="status" class="${pageInfo.sorterName eq 'status' ? pageInfo.sorterDirection : ''}"><hi:text key="可用状态" entity="TblStlOrganization"/></th>
				<th orderField="fieldTimes" class="${pageInfo.sorterName eq 'fieldTimes' ? pageInfo.sorterDirection : ''}"><hi:text key="场次数" entity="TblStlOrganization"/></th>
				<th orderField="extDesc" class="${pageInfo.sorterName eq 'extDesc' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="TblStlOrganization"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblStlOrganization"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblStlOrganization"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblStlOrganization"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlOrganizations}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.orgId}</td>
				    <td>${item.orgType}</td>
				    <td>${item.orgName}</td>
				    <td><hi:select emu="status" name="tblStlOrganizations[${s.index}].status" isLabel="true"/></td>
				    <td>${item.fieldTimes}</td>
				    <td>${item.extDesc}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLORGANIZATION_DEL">
				      <a class="btnDel" href="<hi:url>tblStlOrganizationRemove.action?ajax=1&tblStlOrganization.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="发卡行支持表"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLORGANIZATION_VIEW">
				      <a class="btnView" href="<hi:url>tblStlOrganizationView.action?tblStlOrganization.id=${item.id}</hi:url>" target="navTab" rel="tblStlOrganization" title="<hi:text key="查看" parameterLanguageKeys="发卡行支持表"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLORGANIZATION_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlOrganizationEdit.action?tblStlOrganization.id=${item.id}</hi:url>" target="navTab" rel="tblStlOrganization" title="<hi:text key="编辑" parameterLanguageKeys="发卡行支持表"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', orgId:'${item.orgId}',orgType:'${item.orgType}',orgName:'${item.orgName}',status:'<hi:select emu="status" name="tblStlOrganizations[${s.index}].status" isLabel="true"/>',fieldTimes:'${item.fieldTimes}',extDesc:'${item.extDesc}',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
