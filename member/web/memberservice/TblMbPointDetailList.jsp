<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbPointDetailList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbPointDetailList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="帐号" entity="TblMbPointDetail"/>:</label>
				<input type="text" name="pageInfo.tblMbInfo.f_userName" value="${pageInfo.tblMbInfo.f_userName}"/>
			</li>	  
			<li>
				<label><hi:text key="姓名" entity="TblMbPointDetail"/>:</label>
				<input type="text" name="pageInfo.tblMbInfo.f_fullName" value="${pageInfo.tblMbInfo.f_fullName}"/>
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
				<authz:authorize ifAnyGranted="TBLMBPOINTDETAIL_SAVE"><li><a class="add" href="<hi:url>tblMbPointDetailEdit.action?tblMbPointDetail.id=-1</hi:url>" target="navTab" rel="tblMbPointDetail"><span><hi:text key="新建" parameterLanguageKeys="会员积分明细"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBPOINTDETAIL_DEL"><li><a class="delete" href="<hi:url>tblMbPointDetailRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', point:'',pointTxType:'',voucherNo:'',balance:'',createdDateTime:'',lastUpdatedDatetime:'',userName:'',fullName:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="point" class="${pageInfo.sorterName eq 'point' ? pageInfo.sorterDirection : ''}"><hi:text key="积分" entity="TblMbPointDetail"/></th>
				<th orderField="pointTxType" class="${pageInfo.sorterName eq 'pointTxType' ? pageInfo.sorterDirection : ''}"><hi:text key="积分交易类型" entity="TblMbPointDetail"/></th>
				<th orderField="voucherNo" class="${pageInfo.sorterName eq 'voucherNo' ? pageInfo.sorterDirection : ''}"><hi:text key="积分变动凭证" entity="TblMbPointDetail"/></th>
				<th orderField="balance" class="${pageInfo.sorterName eq 'balance' ? pageInfo.sorterDirection : ''}"><hi:text key="积分余额" entity="TblMbPointDetail"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbPointDetail"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbPointDetail"/></th>
				<th orderField="tblMbInfo.userName" class="${pageInfo.sorterName eq 'tblMbInfo.userName' ? pageInfo.sorterDirection : ''}"><hi:text key="帐号" entity="TblMbPointDetail"/></th>
				<th orderField="tblMbInfo.fullName" class="${pageInfo.sorterName eq 'tblMbInfo.fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="姓名" entity="TblMbPointDetail"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbPointDetails}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.point}</td>
				    <td><hi:select emu="pointTxType" name="tblMbPointDetails[${s.index}].pointTxType" isLabel="true"/></td>
				    <td>${item.voucherNo}</td>
				    <td>${item.balance}</td>
				    <td><fmt:formatDate value="${item.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.lastUpdatedDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><authz:authorize ifAnyGranted="HIUSER_VIEW"><a href="<hi:url>hiUserView.action?hiUser.id=${item.tblMbInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMbInfo.userName}
					<authz:authorize ifAnyGranted="HIUSER_VIEW"></a></authz:authorize>
					</td>
				    <td><authz:authorize ifAnyGranted="HIUSER_VIEW"><a href="<hi:url>hiUserView.action?hiUser.id=${item.tblMbInfo.id}&workflow=-1</hi:url>" target="dialog"></authz:authorize>
					${item.tblMbInfo.fullName}
					<authz:authorize ifAnyGranted="HIUSER_VIEW"></a></authz:authorize>
					</td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBPOINTDETAIL_DEL">
				      <a class="btnDel" href="<hi:url>tblMbPointDetailRemove.action?ajax=1&tblMbPointDetail.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="会员积分明细"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBPOINTDETAIL_VIEW">
				      <a class="btnView" href="<hi:url>tblMbPointDetailView.action?tblMbPointDetail.id=${item.id}</hi:url>" target="navTab" rel="tblMbPointDetail" title="<hi:text key="查看" parameterLanguageKeys="会员积分明细"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBPOINTDETAIL_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbPointDetailEdit.action?tblMbPointDetail.id=${item.id}</hi:url>" target="navTab" rel="tblMbPointDetail" title="<hi:text key="编辑" parameterLanguageKeys="会员积分明细"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', point:'${item.point}',pointTxType:'<hi:select emu="pointTxType" name="tblMbPointDetails[${s.index}].pointTxType" isLabel="true"/>',voucherNo:'${item.voucherNo}',balance:'${item.balance}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',userName:'${item.tblMbInfo.userName}',fullName:'${item.tblMbInfo.fullName}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
