<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMchtUserList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMchtUserList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="姓名" entity="TblMchtUser"/>:</label>
				<input type="text" name="pageInfo.f_fullName" value="${pageInfo.f_fullName}"/>
			</li>	  
			<li>
				<label><hi:text key="部门" entity="TblMchtUser"/>:</label>
				<input type="text" name="pageInfo.org.f_orgName" value="${pageInfo.org.f_orgName}"/>
			</li>	  
			<li>
				<label><hi:text key="性别" entity="TblMchtUser"/>:</label>
				<hi:search name="pageInfo.f_gender" emu="gender"/>
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
				<authz:authorize ifAnyGranted="TBLMCHTUSER_SAVE"><li><a class="add" href="<hi:url>tblMchtUserEdit.action?tblMchtUser.id=-1</hi:url>" target="navTab" rel="tblMchtUser"><span><hi:text key="新建" parameterLanguageKeys="商服操作员"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMCHTUSER_DEL"><li><a class="delete" href="<hi:url>tblMchtUserRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', userName:'',fullName:'',orgName:'',gender:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="userName" class="${pageInfo.sorterName eq 'userName' ? pageInfo.sorterDirection : ''}"><hi:text key="帐号" entity="TblMchtUser"/></th>
				<th orderField="fullName" class="${pageInfo.sorterName eq 'fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="姓名" entity="TblMchtUser"/></th>
				<th orderField="org.orgName" class="${pageInfo.sorterName eq 'org.orgName' ? pageInfo.sorterDirection : ''}"><hi:text key="部门" entity="TblMchtUser"/></th>
				<th orderField="gender" class="${pageInfo.sorterName eq 'gender' ? pageInfo.sorterDirection : ''}"><hi:text key="性别" entity="TblMchtUser"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMchtUsers}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.userName}</td>
				    <td>${item.fullName}</td>
				    <td><authz:authorize ifAnyGranted="HIORG_VIEW"><a href="<hi:url>hiOrgView.action?hiOrg.id=${item.org.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.org.orgName}
					<authz:authorize ifAnyGranted="HIORG_VIEW"></a></authz:authorize>
					</td>
				    <td><hi:select emu="gender" name="tblMchtUsers[${s.index}].gender" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMCHTUSER_DEL">
				      <a class="btnDel" href="<hi:url>tblMchtUserRemove.action?ajax=1&tblMchtUser.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="商服操作员"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMCHTUSER_VIEW">
				      <a class="btnView" href="<hi:url>tblMchtUserView.action?tblMchtUser.id=${item.id}</hi:url>" target="navTab" rel="tblMchtUser" title="<hi:text key="查看" parameterLanguageKeys="商服操作员"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMCHTUSER_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMchtUserEdit.action?tblMchtUser.id=${item.id}</hi:url>" target="navTab" rel="tblMchtUser" title="<hi:text key="编辑" parameterLanguageKeys="商服操作员"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', userName:'${item.userName}',fullName:'${item.fullName}',orgName:'${item.org.orgName}',gender:'<hi:select emu="gender" name="tblMchtUsers[${s.index}].gender" isLabel="true"/>'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
