<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbInfoList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbInfoList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="证件类型" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.f_certificateTypeId" value="${pageInfo.f_certificateTypeId}"/>
			</li>	  
			<li>
				<label><hi:text key="卡号" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.f_cardNo" value="${pageInfo.f_cardNo}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
			<li>
				<label><hi:text key="最后修改人" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.lastUpdatedBy.f_id" value="${pageInfo.lastUpdatedBy.f_id}"/>
			</li>	  
			<li>
				<label><hi:text key="姓名" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.f_fullName" value="${pageInfo.f_fullName}"/>
			</li>	  
			<li>
				<label><hi:text key="部门" entity="TblMbInfo"/>:</label>
				<input type="text" name="pageInfo.org.f_orgName" value="${pageInfo.org.f_orgName}"/>
			</li>	  
			<li>
				<label><hi:text key="性别" entity="TblMbInfo"/>:</label>
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
				<authz:authorize ifAnyGranted="TBLMBINFO_SAVE"><li><a class="add" href="<hi:url>tblMbInfoEdit.action?tblMbInfo.id=-1</hi:url>" target="navTab" rel="tblMbInfo"><span><hi:text key="新建" parameterLanguageKeys="会员信息"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBINFO_DEL"><li><a class="delete" href="<hi:url>tblMbInfoRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', certificateTypeId:'',cardNo:'',realNameStatus:'',realNameTime:'',registerTime:'',registerWay:'',createdDatetime:'',userName:'',fullName:'',orgName:'',gender:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="certificateTypeId" class="${pageInfo.sorterName eq 'certificateTypeId' ? pageInfo.sorterDirection : ''}"><hi:text key="证件类型" entity="TblMbInfo"/></th>
				<th orderField="cardNo" class="${pageInfo.sorterName eq 'cardNo' ? pageInfo.sorterDirection : ''}"><hi:text key="卡号" entity="TblMbInfo"/></th>
				<th orderField="realNameStatus" class="${pageInfo.sorterName eq 'realNameStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="实名认证状态" entity="TblMbInfo"/></th>
				<th orderField="realNameTime" class="${pageInfo.sorterName eq 'realNameTime' ? pageInfo.sorterDirection : ''}"><hi:text key="实名认证时间" entity="TblMbInfo"/></th>
				<th orderField="registerTime" class="${pageInfo.sorterName eq 'registerTime' ? pageInfo.sorterDirection : ''}"><hi:text key="注册时间" entity="TblMbInfo"/></th>
				<th orderField="registerWay" class="${pageInfo.sorterName eq 'registerWay' ? pageInfo.sorterDirection : ''}"><hi:text key="注册方式" entity="TblMbInfo"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbInfo"/></th>
				<th orderField="userName" class="${pageInfo.sorterName eq 'userName' ? pageInfo.sorterDirection : ''}"><hi:text key="帐号" entity="TblMbInfo"/></th>
				<th orderField="fullName" class="${pageInfo.sorterName eq 'fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="姓名" entity="TblMbInfo"/></th>
				<th orderField="org.orgName" class="${pageInfo.sorterName eq 'org.orgName' ? pageInfo.sorterDirection : ''}"><hi:text key="部门" entity="TblMbInfo"/></th>
				<th orderField="gender" class="${pageInfo.sorterName eq 'gender' ? pageInfo.sorterDirection : ''}"><hi:text key="性别" entity="TblMbInfo"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbInfos}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.certificateTypeId}</td>
				    <td>${item.cardNo}</td>
				    <td>${item.realNameStatus}</td>
				    <td>${item.realNameTime}</td>
				    <td>${item.registerTime}</td>
				    <td>${item.registerWay}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td>${item.userName}</td>
				    <td>${item.fullName}</td>
				    <td><authz:authorize ifAnyGranted="HIORG_VIEW"><a href="<hi:url>hiOrgView.action?hiOrg.id=${item.org.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.org.orgName}
					<authz:authorize ifAnyGranted="HIORG_VIEW"></a></authz:authorize>
					</td>
				    <td><hi:select emu="gender" name="tblMbInfos[${s.index}].gender" isLabel="true"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBINFO_DEL">
				      <a class="btnDel" href="<hi:url>tblMbInfoRemove.action?ajax=1&tblMbInfo.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="会员信息"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBINFO_VIEW">
				      <a class="btnView" href="<hi:url>tblMbInfoView.action?tblMbInfo.id=${item.id}</hi:url>" target="navTab" rel="tblMbInfo" title="<hi:text key="查看" parameterLanguageKeys="会员信息"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBINFO_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbInfoEdit.action?tblMbInfo.id=${item.id}</hi:url>" target="navTab" rel="tblMbInfo" title="<hi:text key="编辑" parameterLanguageKeys="会员信息"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', certificateTypeId:'${item.certificateTypeId}',cardNo:'${item.cardNo}',realNameStatus:'${item.realNameStatus}',realNameTime:'${item.realNameTime}',registerTime:'${item.registerTime}',registerWay:'${item.registerWay}',createdDatetime:'${item.createdDatetime}',userName:'${item.userName}',fullName:'${item.fullName}',orgName:'${item.org.orgName}',gender:'<hi:select emu="gender" name="tblMbInfos[${s.index}].gender" isLabel="true"/>'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
