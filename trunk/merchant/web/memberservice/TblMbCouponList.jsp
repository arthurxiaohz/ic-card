<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbCouponList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbCouponList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="帐号" entity="TblMbCoupon"/>:</label>
				<input type="text" name="pageInfo.tblMbInfo.f_userName" value="${pageInfo.tblMbInfo.f_userName}"/>
			</li>	  
			<li>
				<label><hi:text key="姓名" entity="TblMbCoupon"/>:</label>
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
				<authz:authorize ifAnyGranted="TBLMBCOUPON_SAVE"><li><a class="add" href="<hi:url>tblMbCouponEdit.action?tblMbCoupon.id=-1</hi:url>" target="navTab" rel="tblMbCoupon"><span><hi:text key="新建" parameterLanguageKeys="会员优惠券"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBCOUPON_DEL"><li><a class="delete" href="<hi:url>tblMbCouponRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', couponType:'',amount:'',balance:'',couponStatus:'',startDatetime:'',endDatetime:'',createdDateTime:'',lastUpdatedDatetime:'',userName:'',fullName:''})"><span><hi:text key="重置"/></span></a></li>
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
				<th orderField="couponType" class="${pageInfo.sorterName eq 'couponType' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券类型" entity="TblMbCoupon"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券金额" entity="TblMbCoupon"/></th>
				<th orderField="balance" class="${pageInfo.sorterName eq 'balance' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券可用余额" entity="TblMbCoupon"/></th>
				<th orderField="couponStatus" class="${pageInfo.sorterName eq 'couponStatus' ? pageInfo.sorterDirection : ''}"><hi:text key="优惠券状态" entity="TblMbCoupon"/></th>
				<th orderField="startDatetime" class="${pageInfo.sorterName eq 'startDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期开始时间" entity="TblMbCoupon"/></th>
				<th orderField="endDatetime" class="${pageInfo.sorterName eq 'endDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="有效期结束时间" entity="TblMbCoupon"/></th>
				<th orderField="createdDateTime" class="${pageInfo.sorterName eq 'createdDateTime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbCoupon"/></th>
				<th orderField="lastUpdatedDatetime" class="${pageInfo.sorterName eq 'lastUpdatedDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="最后修改时间" entity="TblMbCoupon"/></th>
				<th orderField="tblMbInfo.userName" class="${pageInfo.sorterName eq 'tblMbInfo.userName' ? pageInfo.sorterDirection : ''}"><hi:text key="帐号" entity="TblMbCoupon"/></th>
				<th orderField="tblMbInfo.fullName" class="${pageInfo.sorterName eq 'tblMbInfo.fullName' ? pageInfo.sorterDirection : ''}"><hi:text key="姓名" entity="TblMbCoupon"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbCoupons}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.couponType}</td>
				    <td>${item.amount}</td>
				    <td>${item.balance}</td>
				    <td><hi:select emu="couponStatus" name="tblMbCoupons[${s.index}].couponStatus" isLabel="true"/></td>
				    <td><fmt:formatDate value="${item.startDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td><fmt:formatDate value="${item.endDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
				    <authz:authorize ifAnyGranted="TBLMBCOUPON_DEL">
				      <a class="btnDel" href="<hi:url>tblMbCouponRemove.action?ajax=1&tblMbCoupon.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="会员优惠券"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBCOUPON_VIEW">
				      <a class="btnView" href="<hi:url>tblMbCouponView.action?tblMbCoupon.id=${item.id}</hi:url>" target="navTab" rel="tblMbCoupon" title="<hi:text key="查看" parameterLanguageKeys="会员优惠券"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBCOUPON_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbCouponEdit.action?tblMbCoupon.id=${item.id}</hi:url>" target="navTab" rel="tblMbCoupon" title="<hi:text key="编辑" parameterLanguageKeys="会员优惠券"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', couponType:'${item.couponType}',amount:'${item.amount}',balance:'${item.balance}',couponStatus:'<hi:select emu="couponStatus" name="tblMbCoupons[${s.index}].couponStatus" isLabel="true"/>',startDatetime:'${item.startDatetime}',endDatetime:'${item.endDatetime}',createdDateTime:'${item.createdDateTime}',lastUpdatedDatetime:'${item.lastUpdatedDatetime}',userName:'${item.tblMbInfo.userName}',fullName:'${item.tblMbInfo.fullName}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
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
