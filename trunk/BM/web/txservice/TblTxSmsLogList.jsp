<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblTxSmsLogList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblTxSmsLogList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="发送方标识" entity="TblTxSmsLog"/>:</label>
				<input type="text" name="pageInfo.f_senderId" value="${pageInfo.f_senderId}"/>
			</li>	  
			<li>
				<label><hi:text key="发送方流水号" entity="TblTxSmsLog"/>:</label>
				<input type="text" name="pageInfo.f_seqNo" value="${pageInfo.f_seqNo}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblTxSmsLog"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
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
				<authz:authorize ifAnyGranted="TBLTXSMSLOG_SAVE"><li><a class="add" href="<hi:url>tblTxSmsLogEdit.action?tblTxSmsLog.id=-1</hi:url>" target="navTab" rel="tblTxSmsLog"><span><hi:text key="新建" parameterLanguageKeys="短信明细"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLTXSMSLOG_DEL"><li><a class="delete" href="<hi:url>tblTxSmsLogRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', senderId:'',seqNo:'',phoneNum:'',status:'',createdDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="senderId" class="${pageInfo.sorterName eq 'senderId' ? pageInfo.sorterDirection : ''}"><hi:text key="发送方标识" entity="TblTxSmsLog"/></th>
				<th orderField="seqNo" class="${pageInfo.sorterName eq 'seqNo' ? pageInfo.sorterDirection : ''}"><hi:text key="发送方流水号" entity="TblTxSmsLog"/></th>
				<th orderField="phoneNum" class="${pageInfo.sorterName eq 'phoneNum' ? pageInfo.sorterDirection : ''}"><hi:text key="手机号码" entity="TblTxSmsLog"/></th>
				<th orderField="status" class="${pageInfo.sorterName eq 'status' ? pageInfo.sorterDirection : ''}"><hi:text key="发送状态" entity="TblTxSmsLog"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblTxSmsLog"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblTxSmsLogs}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.senderId}</td>
				    <td>${item.seqNo}</td>
				    <td>${item.phoneNum}</td>
				    <td>${item.status}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLTXSMSLOG_DEL">
				      <a class="btnDel" href="<hi:url>tblTxSmsLogRemove.action?ajax=1&tblTxSmsLog.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="短信明细"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXSMSLOG_VIEW">
				      <a class="btnView" href="<hi:url>tblTxSmsLogView.action?tblTxSmsLog.id=${item.id}</hi:url>" target="navTab" rel="tblTxSmsLog" title="<hi:text key="查看" parameterLanguageKeys="短信明细"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLTXSMSLOG_SAVE">
				      <a class="btnEdit" href="<hi:url>tblTxSmsLogEdit.action?tblTxSmsLog.id=${item.id}</hi:url>" target="navTab" rel="tblTxSmsLog" title="<hi:text key="编辑" parameterLanguageKeys="短信明细"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', senderId:'${item.senderId}',seqNo:'${item.seqNo}',phoneNum:'${item.phoneNum}',status:'${item.status}',createdDatetime:'${item.createdDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
