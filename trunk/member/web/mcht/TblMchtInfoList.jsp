<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMchtInfoList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMchtInfoList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="商户号" entity="TblMchtInfo"/>:</label>
				<input type="text" name="pageInfo.f_mchtNo" value="${pageInfo.f_mchtNo}"/>
			</li>	  
			<li>
				<label><hi:text key="商户名称" entity="TblMchtInfo"/>:</label>
				<input type="text" name="pageInfo.f_mchtName" value="${pageInfo.f_mchtName}"/>
			</li>	  
			<li>
				<label><hi:text key="状态" entity="TblMchtInfo"/>:</label>
				<hi:search name="pageInfo.f_status" emu="mchtStatus"/>
			</li>	  
			<li>
				<label><hi:text key="商户类别" entity="TblMchtInfo"/>:</label>
				<hi:search name="pageInfo.f_mchtType" emu="mchtType"/>
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
				<authz:authorize ifAnyGranted="TBLMCHTINFO_SAVE"><li><a class="add" href="<hi:url>tblMchtInfoEdit.action?tblMchtInfo.id=-1</hi:url>" target="navTab" rel="tblMchtInfo"><span><hi:text key="新建" parameterLanguageKeys="商户"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMCHTINFO_DEL"><li><a class="delete" href="<hi:url>tblMchtInfoRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', mchtNo:'',mchtName:'',status:'',mchtType:'',landline:'',mobile:'',fax:'',address:'',days:'',bankAccountNo:'',bankAccountName:'',bankNo:'',bankName:'',createdDateTime:'',lastUpdatedDatetime:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="mchtNo" class="${pageInfo.sorterName eq 'mchtNo' ? pageInfo.sorterDirection : ''}"><hi:text key="商户号" entity="TblMchtInfo"/></th>
				<th orderField="mchtName" class="${pageInfo.sorterName eq 'mchtName' ? pageInfo.sorterDirection : ''}"><hi:text key="商户名称" entity="TblMchtInfo"/></th>
				<th orderField="status" class="${pageInfo.sorterName eq 'status' ? pageInfo.sorterDirection : ''}"><hi:text key="状态" entity="TblMchtInfo"/></th>
				<th orderField="mchtType" class="${pageInfo.sorterName eq 'mchtType' ? pageInfo.sorterDirection : ''}"><hi:text key="商户类别" entity="TblMchtInfo"/></th>
				<th orderField="landline" class="${pageInfo.sorterName eq 'landline' ? pageInfo.sorterDirection : ''}"><hi:text key="座机" entity="TblMchtInfo"/></th>
				<th orderField="mobile" class="${pageInfo.sorterName eq 'mobile' ? pageInfo.sorterDirection : ''}"><hi:text key="移动电话" entity="TblMchtInfo"/></th>
				<th orderField="fax" class="${pageInfo.sorterName eq 'fax' ? pageInfo.sorterDirection : ''}"><hi:text key="传真" entity="TblMchtInfo"/></th>
				<th orderField="address" class="${pageInfo.sorterName eq 'address' ? pageInfo.sorterDirection : ''}"><hi:text key="地址" entity="TblMchtInfo"/></th>
				<th orderField="days" class="${pageInfo.sorterName eq 'days' ? pageInfo.sorterDirection : ''}"><hi:text key="支付自动确认期" entity="TblMchtInfo"/></th>
				<th orderField="bankAccountNo" class="${pageInfo.sorterName eq 'bankAccountNo' ? pageInfo.sorterDirection : ''}"><hi:text key="银行账户账号" entity="TblMchtInfo"/></th>
				<th orderField="bankAccountName" class="${pageInfo.sorterName eq 'bankAccountName' ? pageInfo.sorterDirection : ''}"><hi:text key="银行账户名称" entity="TblMchtInfo"/></th>
				<th orderField="bankNo" class="${pageInfo.sorterName eq 'bankNo' ? pageInfo.sorterDirection : ''}"><hi:text key="开户行行号" entity="TblMchtInfo"/></th>
				<th orderField="bankName" class="${pageInfo.sorterName eq 'bankName' ? pageInfo.sorterDirection : ''}"><hi:text key="开户行名称" entity="TblMchtInfo"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMchtInfo"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMchtInfo"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMchtInfos}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.mchtNo}</td>
				    <td>${item.mchtName}</td>
				    <td><hi:select emu="mchtStatus" name="tblMchtInfos[${s.index}].status" isLabel="true"/></td>
				    <td><hi:select emu="mchtType" name="tblMchtInfos[${s.index}].mchtType" isLabel="true"/></td>
				    <td>${item.landline}</td>
				    <td>${item.mobile}</td>
				    <td>${item.fax}</td>
				    <td>${item.address}</td>
				    <td>${item.days}</td>
				    <td>${item.bankAccountNo}</td>
				    <td>${item.bankAccountName}</td>
				    <td>${item.bankNo}</td>
				    <td>${item.bankName}</td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMCHTINFO_DEL">
				      <a class="btnDel" href="<hi:url>tblMchtInfoRemove.action?ajax=1&tblMchtInfo.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="商户"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMCHTINFO_VIEW">
				      <a class="btnView" href="<hi:url>tblMchtInfoView.action?tblMchtInfo.id=${item.id}</hi:url>" target="navTab" rel="tblMchtInfo" title="<hi:text key="查看" parameterLanguageKeys="商户"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMCHTINFO_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMchtInfoEdit.action?tblMchtInfo.id=${item.id}</hi:url>" target="navTab" rel="tblMchtInfo" title="<hi:text key="编辑" parameterLanguageKeys="商户"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', mchtNo:'${item.mchtNo}',mchtName:'${item.mchtName}',status:'<hi:select emu="mchtStatus" name="tblMchtInfos[${s.index}].status" isLabel="true"/>',mchtType:'<hi:select emu="mchtType" name="tblMchtInfos[${s.index}].mchtType" isLabel="true"/>',landline:'${item.landline}',mobile:'${item.mobile}',fax:'${item.fax}',address:'${item.address}',days:'${item.days}',bankAccountNo:'${item.bankAccountNo}',bankAccountName:'${item.bankAccountName}',bankNo:'${item.bankNo}',bankName:'${item.bankName}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
