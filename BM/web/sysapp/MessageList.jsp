<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="masterList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="masterList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="收信人" entity="Message"/>:</label>
				<input type="text" name="pageInfo.f_receiverNames" value="${pageInfo.f_receiverNames}"/>
			</li>	
			<li>
				<label><hi:text key="发信人" entity="Message"/>:</label>
				<input type="text" name="pageInfo.f_sender" value="${pageInfo.f_sender}"/>
			</li>	  
			<li>
				<label><hi:text key="消息类型" entity="Message"/>:</label>
				<hi:search name="pageInfo.f_messageType" emu="messageType"/>
			</li>	  
			<li>
				<label><hi:text key="消息正文" entity="Message"/>:</label>
				<input type="text" name="pageInfo.f_messageText" value="${pageInfo.f_messageText}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="Message"/>:</label>
				<input type="text" name="pageInfo.f_createDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createDate01_op" value="&lt;=">
			</li>	  
			<li class="dateRange">
				<label><hi:text key="发送时间" entity="Message"/>:</label>
				<input type="text" name="pageInfo.f_sendDate" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_sendDate}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_sendDate_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_sendDate01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_sendDate01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_sendDate01_op" value="&lt;=">
			</li>	  <li>
				<label><hi:text key="已发送" entity="Message"/>:</label>
				<hi:search name="pageInfo.f_isSent" emu="yesNo"/>
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
			<authz:authorize ifAnyGranted="MESSAGE_SAVE"><li><a class="add" href="<hi:url>messageEdit.action?message.id=-1</hi:url>" target="navTab" rel="Message"><span><hi:text key="新建" parameterLanguageKeys="消息"/></span></a></li></authz:authorize>
			<authz:authorize ifAnyGranted="MESSAGE_DEL"><li><a class="delete" href="<hi:url>messageRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
		</ul>
		</c:if>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="22"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="receiverNames" class="${pageInfo.sorterName eq 'receiverNames' ? pageInfo.sorterDirection : ''}"><hi:text key="收信人" entity="Message"/></th>
				<th orderField="sender" class="${pageInfo.sorterName eq 'sender' ? pageInfo.sorterDirection : ''}"><hi:text key="发信人" entity="Message"/></th>
				<th orderField="messageType" class="${pageInfo.sorterName eq 'messageType' ? pageInfo.sorterDirection : ''}"><hi:text key="消息类型" entity="Message"/></th>
				<th orderField="createDate" class="${pageInfo.sorterName eq 'createDate' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="Message"/></th>
				<th orderField="sendDate" class="${pageInfo.sorterName eq 'sendDate' ? pageInfo.sorterDirection : ''}"><hi:text key="发送时间" entity="Message"/></th>
				<th orderField="isSent" class="${pageInfo.sorterName eq 'isSent' ? pageInfo.sorterDirection : ''}"><hi:text key="已发送" entity="Message"/></th>
				<th orderField="description" class="${pageInfo.sorterName eq 'description' ? pageInfo.sorterDirection : ''}"><hi:text key="描述" entity="Message"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${messages}" varStatus="message">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.receiverNames}</td>
				    <td>${item.sender}</td>
				    <td><hi:select emu="messageType" name="messages[${s.index}].messageType" isLabel="true"/></td>
				    <td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.sendDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><hi:select emu="yesNo" name="messages[${s.index}].isSent" isLabel="true"/></td>
				    <td>${item.description}</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="MESSAGE_DEL">
				      <a class="btnDel" href="<hi:url>messageRemove.action?ajax=1&message.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="消息"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MESSAGE_VIEW">
				      <a class="btnView" href="<hi:url>messageView.action?message.id=${item.id}</hi:url>" target="navTab" rel="Message" title="<hi:text key="查看" parameterLanguageKeys="消息"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="MESSAGE_SAVE">
				      <a class="btnEdit" href="<hi:url>messageEdit.action?message.id=${item.id}</hi:url>" target="navTab" rel="Message" title="<hi:text key="编辑" parameterLanguageKeys="消息"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', receiverNames:'${item.receiverNames}',sender:'${item.sender}',createDate:'${item.createDate}',messageType:'${item.messageType}',sendDate:'${item.sendDate}',isSent:'${item.isSent}',description:'${item.description}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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