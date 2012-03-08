<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblStlCheckOrganizationControlList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblStlCheckOrganizationControlList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="对账批次号" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_checkBatchId" value="${pageInfo.f_checkBatchId}"/>
			</li>	  
			<li>
				<label><hi:text key="机构代码" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_orgId" value="${pageInfo.f_orgId}"/>
			</li>	  
			<li>
				<label><hi:text key="机构类型" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_orgType" value="${pageInfo.f_orgType}"/>
			</li>	  
			<li>
				<label><hi:text key="对账日期" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_checkDate" value="${pageInfo.f_checkDate}"/>
			</li>	  
			<li>
				<label><hi:text key="当前处理状态" entity="TblStlCheckOrganizationControl"/>:</label>
				<hi:search name="pageInfo.f_status" emu="chkStatus"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="最后修改时间" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_lastUpdatedDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_lastUpdatedDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_lastUpdatedDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblStlCheckOrganizationControl"/>:</label>
				<input type="text" name="pageInfo.f_lastUpdatedBy" value="${pageInfo.f_lastUpdatedBy}"/>
			</li>	  
			<li>
				<label><hi:text key="是否正在处理" entity="TblStlCheckOrganizationControl"/>:</label>
				<hi:search name="pageInfo.f_inProcess" emu="inProcess"/>
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
				<authz:authorize ifAnyGranted="TBLSTLCHECKORGANIZATIONCONTROL_SAVE"><li><a class="add" href="<hi:url>tblStlCheckOrganizationControlEdit.action?tblStlCheckOrganizationControl.id=-1</hi:url>" target="navTab" rel="tblStlCheckOrganizationControl"><span><hi:text key="新建" parameterLanguageKeys="对账任务控制表"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLSTLCHECKORGANIZATIONCONTROL_DEL"><li><a class="delete" href="<hi:url>tblStlCheckOrganizationControlRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', checkBatchId:'',orgId:'',orgType:'',checkDate:'',status:'',createdDatetime:'',lastUpdatedDatetime:'',lastUpdatedBy:'',inProcess:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="checkBatchId" class="${pageInfo.sorterName eq 'checkBatchId' ? pageInfo.sorterDirection : ''}"><hi:text key="对账批次号" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="orgId" class="${pageInfo.sorterName eq 'orgId' ? pageInfo.sorterDirection : ''}"><hi:text key="机构代码" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="orgType" class="${pageInfo.sorterName eq 'orgType' ? pageInfo.sorterDirection : ''}"><hi:text key="机构类型" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="checkDate" class="${pageInfo.sorterName eq 'checkDate' ? pageInfo.sorterDirection : ''}"><hi:text key="对账日期" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="status" class="${pageInfo.sorterName eq 'status' ? pageInfo.sorterDirection : ''}"><hi:text key="当前处理状态" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="lastUpdatedBy" class="${pageInfo.sorterName eq 'lastUpdatedBy' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改人" entity="TblStlCheckOrganizationControl"/></th>
				<th orderField="inProcess" class="${pageInfo.sorterName eq 'inProcess' ? pageInfo.sorterDirection : ''}"><hi:text key="是否正在处理" entity="TblStlCheckOrganizationControl"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblStlCheckOrganizationControls}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.checkBatchId}</td>
				    <td>${item.orgId}</td>
				    <td>${item.orgType}</td>
				    <td>${item.checkDate}</td>
				    <td><hi:select emu="chkStatus" name="tblStlCheckOrganizationControls[${s.index}].status" isLabel="true"/></td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.lastUpdatedBy}</td>
				    <td><hi:select emu="inProcess" name="tblStlCheckOrganizationControls[${s.index}].inProcess" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLSTLCHECKORGANIZATIONCONTROL_DEL">
				      <a class="btnDel" href="<hi:url>tblStlCheckOrganizationControlRemove.action?ajax=1&tblStlCheckOrganizationControl.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="对账任务控制表"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLCHECKORGANIZATIONCONTROL_VIEW">
				      <a class="btnView" href="<hi:url>tblStlCheckOrganizationControlView.action?tblStlCheckOrganizationControl.id=${item.id}</hi:url>" target="navTab" rel="tblStlCheckOrganizationControl" title="<hi:text key="查看" parameterLanguageKeys="对账任务控制表"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLSTLCHECKORGANIZATIONCONTROL_SAVE">
				      <a class="btnEdit" href="<hi:url>tblStlCheckOrganizationControlEdit.action?tblStlCheckOrganizationControl.id=${item.id}</hi:url>" target="navTab" rel="tblStlCheckOrganizationControl" title="<hi:text key="编辑" parameterLanguageKeys="对账任务控制表"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', checkBatchId:'${item.checkBatchId}',orgId:'${item.orgId}',orgType:'${item.orgType}',checkDate:'${item.checkDate}',status:'<hi:select emu="chkStatus" name="tblStlCheckOrganizationControls[${s.index}].status" isLabel="true"/>',createdDatetime:'${item.createdDatetime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',lastUpdatedBy:'${item.lastUpdatedBy}',inProcess:'<hi:select emu="inProcess" name="tblStlCheckOrganizationControls[${s.index}].inProcess" isLabel="true"/>'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
